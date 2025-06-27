package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.mappers.ParentMapper;
import kg.mega.kindergarten.mappers.TeacherMapper;
import kg.mega.kindergarten.models.Contact;
import kg.mega.kindergarten.models.Parent;
import kg.mega.kindergarten.models.Teacher;
import kg.mega.kindergarten.models.dtos.TeacherCreateDto;
import kg.mega.kindergarten.models.dtos.TeacherDto;
import kg.mega.kindergarten.models.dtos.TeacherUpdateDto;
import kg.mega.kindergarten.repositories.ParentRepo;
import kg.mega.kindergarten.repositories.TeacherRepo;
import kg.mega.kindergarten.services.ContactService;
import kg.mega.kindergarten.services.TeacherService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepo teacherRepo;
    private final ContactService contactService;

    public TeacherServiceImpl(TeacherRepo teacherRepo, ContactService contactService) {
        this.teacherRepo = teacherRepo;
        this.contactService = contactService;
    }

    @Override
    public TeacherDto create(TeacherCreateDto teacherCreateDto) {
        Contact contact = contactService.findById(teacherCreateDto.contactId());
        Teacher teacher = TeacherMapper.INSTANCE.teacherCreateDtoToTeacher(teacherCreateDto, contact);
        teacher = teacherRepo.save(teacher);
        return TeacherMapper.INSTANCE.teacherToTeacherDto(teacher);
    }

    @Override
    public TeacherDto update(Long teacherId, TeacherUpdateDto teacherUpdateDto) {
        Teacher teacher = teacherRepo.findById(teacherId).orElseThrow(()->new RuntimeException("Учитель не найден по ID"));
        TeacherMapper.INSTANCE.updateTeacherFromDto (teacherUpdateDto, teacher);
        Contact contact = contactService.findById(teacherUpdateDto.contactId());
        teacher.setContact(contact);
        teacher = teacherRepo.save(teacher);
        return TeacherMapper.INSTANCE.teacherToTeacherDto(teacher);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Teacher teacher = teacherRepo.findById(id).orElseThrow();
        teacher.setActive(false);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<TeacherDto> getAllTeachers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return teacherRepo.findAllTeachers (pageable);
    }

    @Override
    public TeacherDto findByIdAndReturnDto(Long teacherId) {
        Teacher teacher = teacherRepo.findById(teacherId).orElseThrow();
        return TeacherMapper.INSTANCE.teacherToTeacherDto(teacher);
    }

    @Override
    public Teacher findById(Long teacherId) {
        return teacherRepo.findById(teacherId).orElseThrow(() -> new RuntimeException("Учитель не найден"));
    }
}

