package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.mappers.GroupMapper;
import kg.mega.kindergarten.models.AgeGroup;
import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.Teacher;
import kg.mega.kindergarten.models.dtos.GroupCreateDto;
import kg.mega.kindergarten.models.dtos.GroupDto;
import kg.mega.kindergarten.models.dtos.GroupUpdateDto;
import kg.mega.kindergarten.repositories.GroupRepo;
import kg.mega.kindergarten.services.AgeGroupService;
import kg.mega.kindergarten.services.ChildService;
import kg.mega.kindergarten.services.GroupService;
import kg.mega.kindergarten.services.TeacherService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepo groupRepo;
    private final AgeGroupService ageGroupService;
    private final TeacherService teacherService;


    public GroupServiceImpl(GroupRepo groupRepo, AgeGroupService ageGroupService, TeacherService teacherService) {
        this.groupRepo = groupRepo;
        this.ageGroupService = ageGroupService;
        this.teacherService = teacherService;

    }


    @Override
    public GroupDto create(GroupCreateDto groupCreateDto) {
        AgeGroup ageGroup = ageGroupService.findById (groupCreateDto.ageGroup());
        Teacher teacher = teacherService.findById(groupCreateDto.teacherId());
        Teacher assistant = teacherService.findById(groupCreateDto.assistantId());
        Group group = GroupMapper.INSTANCE.groupCreateDto(groupCreateDto, ageGroup, teacher, assistant);
        group = groupRepo.save(group);
        return GroupMapper.INSTANCE.groupCreateDto(group);
    }

    @Override
    public Group findById(Long groupId) {
        return groupRepo.findById(groupId).orElseThrow();
    }

    @Override
    public GroupDto update(Long id, GroupUpdateDto updatedDto) {
        AgeGroup ageGroup = ageGroupService.findById (updatedDto.ageGroup());
        Group group = groupRepo.findById(id).orElseThrow( ()-> new RuntimeException("Группа по данному id не найдена"));
        group = GroupMapper.INSTANCE.groupUpdateDto(updatedDto, ageGroup);
        group = groupRepo.save(group);
        return GroupMapper.INSTANCE.groupCreateDto(group);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Group group = groupRepo.findById(id).orElseThrow(()-> new RuntimeException("Группа не найдена"));
        group.setActive(false);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<GroupDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of (page, size);
        List <Group> groups = groupRepo.findAll(pageable).stream().toList();
        return GroupMapper.INSTANCE.groupToGroupDtoList(groups);
    }

    @Override
    public GroupDto findByIdAndReturnDto(Long id) {
        Group group = groupRepo.findById( id).orElseThrow(() -> new RuntimeException("Группа не найдена"));
        return GroupMapper.INSTANCE.groupCreateDto(group);
    }

    @Override
    public GroupDto addTeacherToGroup(Long groupId, Long teacherId) {
        Teacher teacher = teacherService.findById(teacherId);
        Group group = groupRepo.findById(groupId).orElseThrow(() -> new RuntimeException("Группа не найдена"));
        group.setTeacher(teacher);
        return GroupMapper.INSTANCE.groupCreateDto(group);
    }

    @Override
    public GroupDto addAssistantToGroup(Long groupId, Long assistandId) {
        Teacher assistant = teacherService.findById(assistandId);
        Group group = groupRepo.findById(groupId).orElseThrow(() -> new RuntimeException("Группа не найдена"));
        group.setAssistant(assistant);
        return GroupMapper.INSTANCE.groupCreateDto(group);
    }

    }


