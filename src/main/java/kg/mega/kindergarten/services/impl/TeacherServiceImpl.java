package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.mappers.ParentMapper;
import kg.mega.kindergarten.mappers.TeacherMapper;
import kg.mega.kindergarten.models.Parent;
import kg.mega.kindergarten.models.Teacher;
import kg.mega.kindergarten.models.dtos.TeacherCreateDto;
import kg.mega.kindergarten.models.dtos.TeacherDto;
import kg.mega.kindergarten.repositories.ParentRepo;
import kg.mega.kindergarten.repositories.TeacherRepo;
import kg.mega.kindergarten.services.TeacherService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepo teacherRepo;


    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;

    }

    public TeacherDto createTeacher(TeacherCreateDto teacherCreateDto) {
        Teacher teacher = TeacherMapper.INSTANCE.teacherCreateDtoToTeacher(teacherCreateDto);
        teacher = teacherRepo.save(teacher);
        return TeacherMapper.INSTANCE.teacherToTeacherDto(teacher);
    }

    public Teacher findTeacherById(Long id) {
        return teacherRepo.findById(id).orElseThrow(() -> new RuntimeException("Учитель по ID : " + id + "не найден"));
    }

    @Override
    public List<Teacher> findAllTeachersById(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return teacherRepo.findAll(pageable).getContent();
    }

    @Override
    public TeacherDto updateTeacher(TeacherDto teacherDto) {
        Teacher existingTeacher = teacherRepo.findById(teacherDto.id()).orElseThrow(() -> new RuntimeException("Учитель с таким ID не найден"));
        // existingTeacher.setFirstName(teacherDto.firstName());
        // existingTeacher.setLastName(teacherDto.lastName());
        // existingTeacher.setContact(teacherDto.teacherContact());
        // existingTeacher.setPosition(teacherDto.position());
        Teacher updated = teacherRepo.save(existingTeacher);
        return TeacherMapper.INSTANCE.teacherToTeacherDto(updated);
    }

    @Override
    public boolean deleteTeacherById(Long id) {
        Teacher existing = teacherRepo.findById(id).orElseThrow(null);
        if (existing == null) {
            return false;
        }
    teacherRepo.delete(existing);
        return true;
    }
}

