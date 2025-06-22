package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.mappers.AgeGroupMapper;
import kg.mega.kindergarten.models.AgeGroup;
import kg.mega.kindergarten.models.dtos.AgeGroupCreateDto;
import kg.mega.kindergarten.models.dtos.AgeGroupDto;
import kg.mega.kindergarten.repositories.AgeGroupRepo;
import kg.mega.kindergarten.services.AgeGroupService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class AgeGroupServiceImpl implements AgeGroupService {

    private final AgeGroupRepo ageGroupRepo;

    public AgeGroupServiceImpl(AgeGroupRepo ageGroupRepo) {
        this.ageGroupRepo = ageGroupRepo;
    }

    @Override
    public AgeGroupDto createAgeGroup(AgeGroupCreateDto ageGroupCreateDto) {
       AgeGroup ageGroup = AgeGroupMapper.INSTANCE.ageGroupCreateDtoToAgeGroup(ageGroupCreateDto);
       ageGroup = ageGroupRepo.save(ageGroup);
        return AgeGroupMapper.INSTANCE.ageGroupToAgeGroupDto(ageGroup);
    }

    @Override
    public AgeGroup findAgeGroupById(Long id) {
        return ageGroupRepo.findById(id).orElseThrow(() -> new RuntimeException("Возрастная группа не найдена : id" + id));
    }

    @Override
    public List<AgeGroupDto> findAllAgeGroupById(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return ageGroupRepo.findAll(pageable).getContent().stream().map(AgeGroupMapper.INSTANCE::ageGroupToAgeGroupDto).collect(Collectors.toList());
    }

    @Override
    public AgeGroupDto updateAgeGroup(AgeGroupDto ageGroupDto) {
        if(ageGroupDto.id() == null){
            throw new IllegalArgumentException("ID не должно быть null");
        }
        AgeGroup existing = ageGroupRepo.findById(ageGroupDto.id()).orElseThrow(() -> new RuntimeException("Возрастная группа не найдена : " + id));

        existing.setName(ageGroupDto.name());
        existing.setMinAge(ageGroupDto.minAge());
        existing.setMaxAge(ageGroupDto.maxAge());
        AgeGroup updated = ageGroupRepo.save(existing);
        return AgeGroupMapper.INSTANCE.ageGroupToAgeGroupDto(updated);
    }

    @Override
    public boolean deleteAgeGroup(Long id) {
        AgeGroup existing = ageGroupRepo.findById(id).orElse(null);
        if(existing == null){
            return false;}

        ageGroupRepo.delete(existing);


        return true;
    }
}
