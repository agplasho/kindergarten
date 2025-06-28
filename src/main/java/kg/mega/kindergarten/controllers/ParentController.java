package kg.mega.kindergarten.controllers;

import io.swagger.v3.oas.annotations.Operation;
import kg.mega.kindergarten.mappers.ParentMapper;
import kg.mega.kindergarten.models.dtos.ParentCreateDto;
import kg.mega.kindergarten.models.dtos.ParentDto;
import kg.mega.kindergarten.models.dtos.ParentUpdateDto;
import kg.mega.kindergarten.services.ParentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/parent")
public class ParentController implements CRUDOperations<ParentDto, ParentCreateDto, ParentUpdateDto> {

    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }


    @Operation(summary = "Создание родителя")
    @Override
    public ParentDto create(ParentCreateDto parentCreateDto) {
        return parentService.create(parentCreateDto);
    }


    @Operation(summary = "Обновить информацию о родителе")
    @Override
    public ParentDto update(@PathVariable Long parentId, ParentUpdateDto parentUpdateDto) {
        return parentService.update(parentId, parentUpdateDto);
    }


    @Operation(summary = "Удалить информацию о родителе")
    @Override
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return parentService.deleteById(id);
    }


    @Operation(summary = "Получить список всех родителей")
    @Override
    public List<ParentDto> allList(int page, int size) {
        return parentService.findAll(page, size);
    }



    @Operation(summary = "Получить родителя по ID")
    @Override
    public ParentDto findById(@PathVariable Long parentId) {
        return parentService.findById(parentId);
    }
}
