package kg.mega.kindergarten.services;

import kg.mega.kindergarten.models.Teacher;
import kg.mega.kindergarten.models.dtos.TeacherCreateDto;
import kg.mega.kindergarten.models.dtos.TeacherDto;
import kg.mega.kindergarten.models.dtos.TeacherUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

public interface TeacherService {
    TeacherDto create(TeacherCreateDto teacherCreateDto);

    TeacherDto update(Long teacherId, TeacherUpdateDto teacherUpdateDto);

    ResponseEntity<?> delete(Long id);

    List<TeacherDto> getAllTeachers(int page, int size);

    TeacherDto findByIdAndReturnDto(Long teacherId);

    Teacher findById(Long teacherId);
}
