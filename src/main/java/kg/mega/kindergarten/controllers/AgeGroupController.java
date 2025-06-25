package kg.mega.kindergarten.controllers;


import io.swagger.v3.oas.annotations.Operation;
import kg.mega.kindergarten.mappers.AgeGroupMapper;
import kg.mega.kindergarten.models.dtos.AgeGroupCreateDto;
import kg.mega.kindergarten.models.dtos.AgeGroupDto;
import kg.mega.kindergarten.services.AgeGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ageGroup")
public class AgeGroupController implements CRUDOperations<AgeGroupDto, AgeGroupCreateDto, Long> {

    private final AgeGroupService ageGroupService;


    public AgeGroupController(AgeGroupService ageGroupService) {
        this.ageGroupService = ageGroupService;

    }

    @PostMapping("/create")
    @Operation(summary = "Создание возрастной группы")
    @Override
    public AgeGroupDto create(@RequestBody AgeGroupCreateDto ageGroupCreateDto) {
        return ageGroupService.createAgeGroup(ageGroupCreateDto);
    }


    @GetMapping("/read")
    @Operation(summary = "Получить возрастную группу по ID")
    @Override
    public AgeGroupDto read(@PathVariable Long id) {
        return AgeGroupMapper.INSTANCE.ageGroupToAgeGroupDto(ageGroupService.findAgeGroupById(id));
    }

    @GetMapping("/all")
    @Operation(summary = "Получить все возрастные группы")
    @Override
    public List<AgeGroupDto> readAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ageGroupService.findAllAgeGroupById(page, size);
    }

    @PutMapping("/update")
    @Operation(summary = "Обновить возрастную группу")
    @Override
    public AgeGroupDto update(AgeGroupDto ageGroupDto) {
        return ageGroupService.updateAgeGroup(ageGroupDto);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Удалить возрастную группу")
    @Override
    public boolean delete(Long id) {
        return ageGroupService.deleteAgeGroup(id);
    }


//    @DeleteMapping("/{id}")
//    @Operation(summary = "Удалить возрастную группу по ID")
//    public ResponseEntity<?> deleteAgeGroup(@PathVariable Long id) {
//        boolean isDeleted = ageGroupService.delete(id);
//
//        if (isDeleted) {
//            return ResponseEntity.ok("Возрастная группа успешно удалена.");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Возрастная группа не найдена.");
//        }
//    }
}
