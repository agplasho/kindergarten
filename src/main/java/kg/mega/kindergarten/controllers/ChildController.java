package kg.mega.kindergarten.controllers;

import io.swagger.v3.oas.annotations.Operation;
import kg.mega.kindergarten.mappers.ChildMapper;
import kg.mega.kindergarten.models.dtos.ChildCreateDto;
import kg.mega.kindergarten.models.dtos.ChildDto;
import kg.mega.kindergarten.models.dtos.ChildUpdateDto;
import kg.mega.kindergarten.services.ChildService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/child")
public class ChildController implements CRUDOperations<ChildDto, ChildCreateDto, ChildUpdateDto> {

    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }


    @Operation(summary = "Создание ребенка")
    @Override
    public ChildDto create(ChildCreateDto childCreateDto) {
        return childService.create(childCreateDto);
    }


    @Operation(summary = "Обновление информации ребенка")
    @Override
    public ChildDto update(@PathVariable Long childId, ChildUpdateDto childUpdateDto) {
        return childService.update(childId, childUpdateDto);
    }


    @Operation(summary = "Удалить информацию о ребенке")
    @Override
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return childService.deleteById(id);
    }


    @Operation(summary = "Получить список всех детей")
    @Override
    public List<ChildDto> allList(int page, int size) {
        return childService.getAll(page, size);
    }


    @Operation(summary = "Найти ребенка по ID")
    @Override
    public ChildDto findById(@PathVariable Long id) {
        return childService.findByIdAndReturnDto(id);
    }
}
