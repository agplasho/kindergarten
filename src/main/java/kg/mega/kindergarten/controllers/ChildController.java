package kg.mega.kindergarten.controllers;

import io.swagger.v3.oas.annotations.Operation;
import kg.mega.kindergarten.mappers.ChildMapper;
import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.dtos.ChildCreateDto;
import kg.mega.kindergarten.models.dtos.ChildDto;
import kg.mega.kindergarten.services.ChildService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/child")
public class ChildController implements CRUDOperations<ChildDto, ChildCreateDto, Long> {

    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;

    }

    @PostMapping("/create")
    @Operation(summary = "Добавить ребенка")
    @Override
    public ChildDto create(@RequestBody ChildCreateDto childCreateDto) {
        return childService.createChild(childCreateDto);
    }


    @GetMapping("{id}")
    @Operation(summary = "Найти ребенка по ID")
    @Override
    public ChildDto read(@PathVariable Long id) {
        return ChildMapper.INSTANCE.childToChildDto(childService.findChildById(id));
    }

    @GetMapping("/all")
    @Operation(summary = "Посмотреть список всех детей")
    @Override
    public List<ChildDto> readAll(@RequestParam int page, @RequestParam int size) {
        return childService.findAllChildrenById(page, size).stream().map(ChildMapper.INSTANCE::childToChildDto).toList();
    }

    @PutMapping("/update")
    @Operation(summary = "Обновить информацию о ребенке")
    @Override
    public ChildDto update(ChildDto childDto) {
        return childService.updateChild(childDto);
    }


    @DeleteMapping("/delete")
    @Operation(summary = "Удалить ребенка по ID")
    @Override
    public boolean delete(Long id) {
        return childService.deleteChild(id);
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "Удалить Ребенка по ID")
//    public ResponseEntity<?> deleteChild(@PathVariable Long id) {
//        boolean isDeleted = childService.deleteChild(id);
//
//        if (isDeleted) {
//            return ResponseEntity.ok("Ребенок успешно удален");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ребенок не найден");
//        }
//    }
}
