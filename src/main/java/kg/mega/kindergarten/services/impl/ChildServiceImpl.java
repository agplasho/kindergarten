package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.mappers.ChildMapper;
import kg.mega.kindergarten.models.AgeGroup;
import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.dtos.ChildCreateDto;
import kg.mega.kindergarten.models.dtos.ChildDto;
import kg.mega.kindergarten.repositories.ChildRepo;
import kg.mega.kindergarten.services.ChildService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {
    private final ChildRepo childRepo;

    public ChildServiceImpl(ChildRepo childRepo) {
        this.childRepo = childRepo;
    }

    @Override
    public ChildDto createChild(ChildCreateDto childCreateDto) {
       Child child = ChildMapper.INSTANCE.childCreateDtoToChild(childCreateDto);
       child = childRepo.save(child);
        return ChildMapper.INSTANCE.childToChildDto(child);
    }

    @Override
    public Child findChildById(Long id) {
        return childRepo.findById(id).orElseThrow(() -> new RuntimeException("Ребенок не найден id:" + id));
    }

    @Override
    public List<Child> findAllChildrenById(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return childRepo.findAll(pageable).getContent();
    }

    @Override
    public ChildDto updateChild(ChildDto childDto) {
        Child existingChild = childRepo.findById(childDto.Id()).orElseThrow(() -> new RuntimeException("Ребенок с ID :" + childDto.Id() + "не найден"));

        Child updated = childRepo.save(existingChild);
        return ChildMapper.INSTANCE.childToChildDto(updated);
    }

    @Override
    public boolean deleteChild(Long id) {
        Child existing = childRepo.findById(id).orElse(null);
        if(existing == null){
            return false;}

        childRepo.delete(existing);


        return true;
    }



}

