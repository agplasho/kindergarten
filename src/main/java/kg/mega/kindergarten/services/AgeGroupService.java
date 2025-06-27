package kg.mega.kindergarten.services;

import kg.mega.kindergarten.mappers.AgeGroupMapper;
import kg.mega.kindergarten.models.AgeGroup;
import kg.mega.kindergarten.models.dtos.AgeGroupCreateDto;
import kg.mega.kindergarten.models.dtos.AgeGroupDto;
import kg.mega.kindergarten.models.dtos.AgeGroupUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AgeGroupService {

    AgeGroupDto create(AgeGroupCreateDto ageGroupCreateDto);

    AgeGroup findById(Long aLong);

    AgeGroupDto updateAgeGroupById(Long ageGroupId, AgeGroupUpdateDto ageGroupUpdateDto);

    ResponseEntity<?> deleteAgeGroupById(Long ageGroupId);

    List<AgeGroupDto> getAllAgeGroups(int page, int size);

    AgeGroupDto findAgeGroupByIdAndReturnDto(Long id);
}
