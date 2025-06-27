package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.mappers.ChildMapper;
import kg.mega.kindergarten.models.AgeGroup;
import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.Parent;
import kg.mega.kindergarten.models.dtos.ChildCreateDto;
import kg.mega.kindergarten.models.dtos.ChildDto;
import kg.mega.kindergarten.models.dtos.ChildUpdateDto;
import kg.mega.kindergarten.repositories.ChildRepo;
import kg.mega.kindergarten.services.ChildService;
import kg.mega.kindergarten.services.GroupService;
import kg.mega.kindergarten.services.ParentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildServiceImpl implements ChildService{

    private final ChildRepo childRepo;
    private final ParentService parentService;
    private final GroupService groupService;

    public ChildServiceImpl(ChildRepo childRepo, ParentService parentService, GroupService groupService) {
        this.childRepo = childRepo;
        this.parentService = parentService;
        this.groupService = groupService;
    }

    @Override
    public ChildDto create(ChildCreateDto childCreateDto) {
        List<Parent> parents = parentService.findParentByIds (childCreateDto.parentsIds());
        Group group = groupService.findById(childCreateDto.groupId());

        Child child = ChildMapper.INSTANCE.childCreateDtoToChild(childCreateDto, parents, group);
        child = childRepo.save(child);
        return ChildMapper.INSTANCE.childToChildDto(child);
    }

    @Override
    public Child findById(Long child) {
        return childRepo.findById(child).orElse(null);
    }

    @Override
    public ChildDto update(Long childId, ChildUpdateDto childUpdateDto) {
        Group group = groupService.findById(childUpdateDto.groupId());
        List <Parent> parents = parentService.findParentByIds (childUpdateDto.parentsIds());
        Child child = childRepo.findById(childId).orElseThrow( ()-> new RuntimeException("Ребенок по данному id не найден"));
        ChildMapper.INSTANCE.updateChildByDto(childUpdateDto, child);
        child.setGroup(group);
        child.setParents(parents);
        child = childRepo.save(child);
        return ChildMapper.INSTANCE.childToChildDto(child);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        Child child = childRepo.findById(id).orElse(null);
        child.setActive(false);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<ChildDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Child> childs = childRepo.findAll(pageable).getContent();
        return ChildMapper.INSTANCE.childToChildDtoList(childs);
    }

    @Override
    public ChildDto findByIdAndReturnDto(Long id) {
        childRepo.findById(id).orElse(null);
        return ChildMapper.INSTANCE.childToChildDto(childRepo.findById(id).orElse(null));
    }

    @Override
    public Child addChildToGroup(Long groupId) {
        Group group = groupService.findById(groupId);
        return null;
    }



}

