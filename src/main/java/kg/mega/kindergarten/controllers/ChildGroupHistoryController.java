package kg.mega.kindergarten.controllers;

import io.swagger.v3.oas.annotations.Operation;
import kg.mega.kindergarten.models.dtos.ChildGroupHistoryCreateDto;
import kg.mega.kindergarten.models.dtos.ChildGroupHistoryDto;
import kg.mega.kindergarten.models.dtos.ChildGroupHistoryUpdateDto;
import kg.mega.kindergarten.services.ChildGroupHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/child-group-history")
public class ChildGroupHistoryController implements CRUDOperations<ChildGroupHistoryDto, ChildGroupHistoryCreateDto, ChildGroupHistoryUpdateDto> {

    private final ChildGroupHistoryService childGroupHistoryService;


    public ChildGroupHistoryController(ChildGroupHistoryService childGroupHistoryService) {
        this.childGroupHistoryService = childGroupHistoryService;
    }


    @Operation(summary = "Создание истории ребенка")

    public ChildGroupHistoryDto create(ChildGroupHistoryCreateDto childGroupHistoryCreateDto) {
        return childGroupHistoryService.create(childGroupHistoryCreateDto);
    }


    @Operation(summary = "Обновить историю ребенка")
    public ChildGroupHistoryDto update(@PathVariable Long id, ChildGroupHistoryUpdateDto updatedDto) {
        return childGroupHistoryService.update(id, updatedDto);
    }


    @Operation(summary = "Удалить историю ребенка")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return childGroupHistoryService.delete(id);
    }


    @Operation(summary = "Получение списка всей истории")
    public List<ChildGroupHistoryDto> allList(@RequestParam int page, @RequestParam int size) {
        return childGroupHistoryService.getAll(page, size);
    }


    @Operation(summary = "Найти информацию о ребенке по ID")
    public ChildGroupHistoryDto findById(@PathVariable Long id) {
        return childGroupHistoryService.findById(id);
    }
}

