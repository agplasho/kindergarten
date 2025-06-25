package kg.mega.kindergarten.controllers;

import io.swagger.v3.oas.annotations.Operation;
import kg.mega.kindergarten.mappers.ParentMapper;
import kg.mega.kindergarten.mappers.TeacherMapper;
import kg.mega.kindergarten.models.dtos.TeacherCreateDto;
import kg.mega.kindergarten.models.dtos.TeacherDto;
import kg.mega.kindergarten.services.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/teacher")
public class TeacherController implements CRUDOperations<TeacherDto, TeacherCreateDto,Long>{

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @PostMapping("/create")
    @Operation(summary = "Создание учителя")
    @Override
    public TeacherDto create(@RequestBody TeacherCreateDto teacherCreateDto) {
        return teacherService.createTeacher(teacherCreateDto);
    }
    @GetMapping("/read")
    @Operation(summary = "Получить учителя по ID")
    @Override
    public TeacherDto read(@PathVariable Long id) {
        return TeacherMapper.INSTANCE.teacherToTeacherDto(teacherService.findTeacherById(id));
    }

    @GetMapping("/all")
    @Operation(summary = "Получить список всех учителей")
    @Override
    public List<TeacherDto> readAll(@RequestParam int page, @RequestParam int size) {
        return teacherService.findAllTeachersById(page,size).stream().map(TeacherMapper.INSTANCE::teacherToTeacherDto).toList();
    }

    @PutMapping("/update")
    @Operation(summary = "Обновить учителя")
    @Override
    public TeacherDto update(TeacherDto teacherDto) {
        return teacherService.updateTeacher(teacherDto);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Удалить учителя")
    @Override
    public boolean delete(Long id) {
        return teacherService.deleteTeacherById(id);
    }
}
