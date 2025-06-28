package kg.mega.kindergarten.controllers;

import io.swagger.v3.oas.annotations.Operation;
import kg.mega.kindergarten.mappers.TeacherMapper;
import kg.mega.kindergarten.models.dtos.TeacherCreateDto;
import kg.mega.kindergarten.models.dtos.TeacherDto;
import kg.mega.kindergarten.models.dtos.TeacherUpdateDto;
import kg.mega.kindergarten.services.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/teacher")
public class TeacherController implements CRUDOperations<TeacherDto, TeacherCreateDto, TeacherUpdateDto> {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @Operation(summary = "Создание учителя")
    @Override
    public TeacherDto create(@RequestBody TeacherCreateDto teacherCreateDto) {
        return teacherService.create(teacherCreateDto);
    }


    @Operation(summary = "Обновить учителя")
    @Override
    public TeacherDto update(@PathVariable Long teacherId, TeacherUpdateDto teacherUpdateDto) {
        return teacherService.update(teacherId, teacherUpdateDto);
    }


    @Operation(summary = "Удалить учителя")
    @Override
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return teacherService.delete(id);
    }


    @Operation(summary = "Получить список учителей")
    @Override
    public List<TeacherDto> allList(int page, int size) {
        return teacherService.getAllTeachers(page, size);
    }



    @Operation(summary = "Найти учителя по ID")
    @Override
    public TeacherDto findById(@PathVariable Long teacherId) {
        return teacherService.findByIdAndReturnDto(teacherId);
    }
}
