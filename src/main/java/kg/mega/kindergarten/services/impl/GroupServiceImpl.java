package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.mappers.GroupMapper;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.dtos.ChildDto;
import kg.mega.kindergarten.models.dtos.GroupCreateDto;
import kg.mega.kindergarten.models.dtos.GroupDto;
import kg.mega.kindergarten.repositories.GroupRepo;
import kg.mega.kindergarten.services.GroupService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepo groupRepo;

    public GroupServiceImpl(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }


    @Override
    public GroupDto createGroup(GroupCreateDto groupCreateDto) {
       Group group = GroupMapper.INSTANCE.groupCreateDtoToGroup(groupCreateDto);
       group = groupRepo.save(group);
        return GroupMapper.INSTANCE.groupToGroupDto(group);
    }

    @Override
    public Group findGroupById(Long id) {
        return groupRepo.findById(id).orElseThrow(() -> new RuntimeException("Группа не найдена по ID:" + id));
    }

    @Override
    public List<Group> findAllGroupsById(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return groupRepo.findAll(pageable).getContent();
    }

    @Override
    public GroupDto updateGroup(GroupDto groupDto) {
       Group existingGroup = groupRepo.findById(groupDto.id()).orElseThrow(() -> new RuntimeException("Группа с ID: " + groupDto.id() + "не найдена"));

       Group updated = groupRepo.save(existingGroup);
        return GroupMapper.INSTANCE.groupToGroupDto(updated);
    }

    @Override
    public boolean deleteGroup(Long id) {
        Group existing = groupRepo.findById(id).orElse(null);
        if(existing == null){
        return false;}
        groupRepo.delete(existing);
        return  true;
    }
}
