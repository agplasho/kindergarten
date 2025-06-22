package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.mappers.ParentMapper;
import kg.mega.kindergarten.models.Parent;
import kg.mega.kindergarten.models.dtos.ParentCreateDto;
import kg.mega.kindergarten.models.dtos.ParentDto;
import kg.mega.kindergarten.repositories.ParentRepo;
import kg.mega.kindergarten.services.ParentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {
    private final ParentRepo parentRepo;

    public ParentServiceImpl(ParentRepo parentRepo) {
        this.parentRepo = parentRepo;
    }

    @Override
    public ParentDto createParent(ParentCreateDto parentCreateDto) {
        Parent parent = ParentMapper.INSTANCE.parentCreateDtoToParent(parentCreateDto);
        parent = parentRepo.save(parent);
        return ParentMapper.INSTANCE.parentToParentDto(parent);
    }

    @Override
    public Parent findParentById(Long id) {
        return parentRepo.findById(id).orElseThrow(() -> new RuntimeException("Родитель по ID: " + id + "не найден"));
    }

    @Override
    public List<Parent> findAllParentsById(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return parentRepo.findAll(pageable).getContent();
    }

    @Override
    public ParentDto updateParent(ParentDto parentDto) {
        Parent existingParent = parentRepo.findById(parentDto.id()).orElseThrow(() -> new RuntimeException("Родитель с таким ID не найден"));
        //existingParent.setFirstName(parentDto.firstName());
        //  existingParent.setLastName(parentDto.lastName());
        // existingParent.setContact(parentDto.contact());
        //  existingParent.setRole(parentDto.role());
        Parent updated = parentRepo.save(existingParent);
        return ParentMapper.INSTANCE.parentToParentDto(updated);
    }

    @Override
    public boolean deleteParentById(Long id) {
        Parent existing = parentRepo.findById(id).orElseThrow(null);
        if (existing == null) {
            return false;
        }
        parentRepo.delete(existing);
        return true;
    }
}
