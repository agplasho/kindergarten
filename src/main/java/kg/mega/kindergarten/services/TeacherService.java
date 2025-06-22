package kg.mega.kindergarten.services;

import kg.mega.kindergarten.models.Teacher;
import kg.mega.kindergarten.models.dtos.TeacherCreateDto;
import kg.mega.kindergarten.models.dtos.TeacherDto;

import java.util.Collection;
import java.util.List;

public interface TeacherService {
    TeacherDto createTeacher(TeacherCreateDto teacherCreateDto);

    Teacher findTeacherById(Long id);

    List<Teacher> findAllTeachersById(int page, int size);

    TeacherDto updateTeacher(TeacherDto teacherDto);

    boolean deleteTeacherById(Long id);
}
