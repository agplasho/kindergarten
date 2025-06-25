package kg.mega.kindergarten.controllers;

import io.swagger.v3.oas.annotations.Operation;
import kg.mega.kindergarten.mappers.ParentMapper;
import kg.mega.kindergarten.mappers.TeacherMapper;
import kg.mega.kindergarten.models.dtos.ParentCreateDto;
import kg.mega.kindergarten.models.dtos.ParentDto;
import kg.mega.kindergarten.models.dtos.TeacherDto;
import kg.mega.kindergarten.services.ParentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/parent")
public class ParentController implements CRUDOperations<ParentDto, ParentCreateDto,Long>{
    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @PostMapping("/create")
    @Operation(summary = "Создание родителя")
    @Override
    public ParentDto create(@RequestBody ParentCreateDto parentCreateDto) {
        return parentService.createParent(parentCreateDto );
    }

    @GetMapping("/read")
    @Operation(summary = "Получить родителя по ID")
    @Override
    public ParentDto read(@PathVariable Long id) {
        return ParentMapper.INSTANCE.parentToParentDto(parentService.findParentById(id));
    }

    @GetMapping("/all")
    @Operation(summary = "Получить список всех родителей ")
    @Override
    public List<ParentDto> readAll(@RequestParam int page, @RequestParam int size) {
        return parentService.findAllParentsById(page,size).stream().map(ParentMapper.INSTANCE::parentToParentDto).toList();
    }

    @PutMapping("/update")
    @Operation(summary = "Обновить родителя")
    @Override
    public ParentDto update(ParentDto parentDto) {
        return parentService.updateParent(parentDto);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Удалить Родителя по ID")
    @Override
    public boolean delete(Long id) {
        return parentService.deleteParentById(id);
    }
}
