package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.mappers.AgeGroupMapper;
import kg.mega.kindergarten.models.AgeGroup;
import kg.mega.kindergarten.models.dtos.AgeGroupCreateDto;
import kg.mega.kindergarten.models.dtos.AgeGroupDto;
import kg.mega.kindergarten.models.dtos.AgeGroupUpdateDto;
import kg.mega.kindergarten.repositories.AgeGroupRepo;
import kg.mega.kindergarten.services.AgeGroupService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
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
    public AgeGroupDto create(AgeGroupCreateDto ageGroupCreateDto) {
        AgeGroup ageGroup = AgeGroupMapper.INSTANCE.ageGroupCreateDtoToAgeGroup(ageGroupCreateDto);
        ageGroupRepo.save(ageGroup);
        return AgeGroupMapper.INSTANCE.ageGroupToAgeGroupDto(ageGroup);
    }

    @Override
    public AgeGroup findById(Long ageGroupId) {
        return ageGroupRepo.findById(ageGroupId).orElseThrow(()-> new RuntimeException("Возрастная группа не найдена"));
    }

    @Override
    public AgeGroupDto updateAgeGroupById(Long ageGroupId, AgeGroupUpdateDto ageGroupUpdateDto) {
        AgeGroup ageGroup = ageGroupRepo.findById(ageGroupId).orElseThrow(()-> new RuntimeException("Возрастная группа не найдена"));
        AgeGroupMapper.INSTANCE.updateAgeGroupByDto(ageGroupUpdateDto, ageGroup);
        ageGroupRepo.save(ageGroup);
        return AgeGroupMapper.INSTANCE.ageGroupToAgeGroupDto(ageGroup);
    }

    @Override
    public ResponseEntity<?> deleteAgeGroupById(Long ageGroupId) {
        AgeGroup ageGroup = ageGroupRepo.findById(ageGroupId).orElse(null);
        ageGroup.setActive(false);
        return ResponseEntity.ok(ageGroup);
    }

    @Override
    public List<AgeGroupDto> getAllAgeGroups(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<AgeGroup> ageGroups = ageGroupRepo.findAll(pageable).stream().toList();
        return AgeGroupMapper.INSTANCE.ageGroupToAgeGroupDtoList(ageGroups);
    }

    @Override
    public AgeGroupDto findAgeGroupByIdAndReturnDto(Long id) {
        AgeGroup ageGroup = ageGroupRepo.findById(id).orElseThrow(()-> new RuntimeException("Возрастная группа не найдена"));
        return AgeGroupMapper.INSTANCE.ageGroupToAgeGroupDto(ageGroup);


}
    }

