package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.mappers.ParentMapper;
import kg.mega.kindergarten.models.Contact;
import kg.mega.kindergarten.models.Parent;
import kg.mega.kindergarten.models.dtos.ParentCreateDto;
import kg.mega.kindergarten.models.dtos.ParentDto;
import kg.mega.kindergarten.models.dtos.ParentUpdateDto;
import kg.mega.kindergarten.repositories.ParentRepo;
import kg.mega.kindergarten.services.ContactService;
import kg.mega.kindergarten.services.ParentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepo parentRepo;
    private final ContactService contactService;

    public ParentServiceImpl(ParentRepo parentRepo, ContactService contactService) {
        this.parentRepo = parentRepo;
        this.contactService = contactService;
    }

    @Override
    public ParentDto create(ParentCreateDto parentCreateDto) {
        Contact contact = contactService.findById (parentCreateDto.contactId());
        Parent parent = ParentMapper.INSTANCE.parentCreateDtoToParent(parentCreateDto, contact);
        parent = parentRepo.save(parent);
        return ParentMapper.INSTANCE.parentToParentDto(parent);
    }

    @Override
    public List<Parent> findParentByIds(List<Long> parentsIds) {
        return parentRepo.findAllByIds(parentsIds);
    }

    @Override
    public ParentDto findById(Long parentId) {
        Parent parent = parentRepo.findById(parentId).orElse(null);
        return ParentMapper.INSTANCE.parentToParentDto(parent);
    }

    @Override
    public List<ParentDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of (page, size);
        return parentRepo.findAllParents (pageable);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        Parent parent = parentRepo.findById(id).orElseThrow(()-> new RuntimeException("Родитель не найден"));
        parent.setActive(false);
        return ResponseEntity.ok().build();
    }

    @Override
    public ParentDto update(Long parentId, ParentUpdateDto parentUpdateDto) {
        Parent parent = parentRepo.findById(parentId).orElseThrow(()-> new RuntimeException("Родитель по данному id не найден"));
        ParentMapper.INSTANCE.updateParentFromDto (parentUpdateDto, parent);
        Contact contact = contactService.findById (parentUpdateDto.contactId());
        parent.setContact(contact);
        parentRepo.save(parent);
        return ParentMapper.INSTANCE.parentToParentDto(parent);
    }
}
