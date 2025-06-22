package kg.mega.kindergarten.services;

import kg.mega.kindergarten.mappers.AgeGroupMapper;
import kg.mega.kindergarten.models.AgeGroup;
import kg.mega.kindergarten.models.dtos.AgeGroupCreateDto;
import kg.mega.kindergarten.models.dtos.AgeGroupDto;

import java.util.List;

public interface AgeGroupService {
    AgeGroupDto createAgeGroup(AgeGroupCreateDto ageGroupCreateDto);

    AgeGroup findAgeGroupById(Long id);

    List<AgeGroupDto> findAllAgeGroupById(int page, int size);

    AgeGroupDto updateAgeGroup(AgeGroupDto ageGroupDto);

    boolean deleteAgeGroup(Long id);
}
