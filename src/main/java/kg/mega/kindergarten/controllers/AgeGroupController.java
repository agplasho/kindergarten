package kg.mega.kindergarten.controllers;


import io.swagger.v3.oas.annotations.Operation;
import kg.mega.kindergarten.models.dtos.AgeGroupCreateDto;
import kg.mega.kindergarten.models.dtos.AgeGroupDto;
import kg.mega.kindergarten.models.dtos.AgeGroupUpdateDto;
import kg.mega.kindergarten.services.AgeGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ageGroup")
public class AgeGroupController implements CRUDOperations<AgeGroupDto, AgeGroupCreateDto, AgeGroupUpdateDto> {
    private final AgeGroupService ageGroupService;

    public AgeGroupController(AgeGroupService ageGroupService) {
        this.ageGroupService = ageGroupService;
    }

    @PostMapping("/create")
    @Operation(summary = "Создание возрастной группы")
    @Override
    public AgeGroupDto create(AgeGroupCreateDto ageGroupCreateDto) {
        return ageGroupService.create(ageGroupCreateDto);
    }

    @PutMapping("/age-group/update/{ageGroupId}")
    @Operation(summary = "Обновление группы по id")
    @Override
    public AgeGroupDto update(@PathVariable Long ageGroupId, AgeGroupUpdateDto ageGroupUpdateDto) {
        return ageGroupService.updateAgeGroupById(ageGroupId, ageGroupUpdateDto);
    }

    @DeleteMapping("/delete/{ageGroupId}")
    @Operation(summary = "Удаление группы", description = "Удаление группы, путем установки false на поле Active")
    @Override
    public ResponseEntity<?> delete(Long ageGroupId) {
        return ageGroupService.deleteAgeGroupById(ageGroupId);
    }

    @GetMapping("/get/all")
    @Operation(summary = "Получение всех возрастных групп")
    @Override
    public List<AgeGroupDto> allList(int page, int size) {
        return ageGroupService.getAllAgeGroups(page, size);
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "Получение возрастной группы по Id")
    @Override
    public AgeGroupDto findById(@PathVariable Long id) {
        return ageGroupService.findAgeGroupByIdAndReturnDto(id);
    }
}
