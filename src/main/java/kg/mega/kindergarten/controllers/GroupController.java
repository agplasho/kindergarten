package kg.mega.kindergarten.controllers;

import io.swagger.v3.oas.annotations.Operation;
import kg.mega.kindergarten.mappers.GroupMapper;
import kg.mega.kindergarten.models.dtos.GroupCreateDto;
import kg.mega.kindergarten.models.dtos.GroupDto;
import kg.mega.kindergarten.models.dtos.GroupUpdateDto;
import kg.mega.kindergarten.services.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController implements CRUDOperations<GroupDto, GroupCreateDto, GroupUpdateDto> {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/create")
    @Operation(summary = "Создание группы")
    @Override
    public GroupDto create(GroupCreateDto groupCreateDto) {
        return groupService.create(groupCreateDto);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Обновление группы")
    @Override
    public GroupDto update(@PathVariable Long id, @RequestBody GroupUpdateDto updatedDto) {
        return groupService.update(id, updatedDto);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удаление группы")
    @Override
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return groupService.delete(id);
    }

    @GetMapping("/get/all")
    @Operation(summary = "Получение всех групп по страницам")
    @Override
    public List<GroupDto> allList(@RequestParam int page, @RequestParam int size) {
        return groupService.getAll(page, size);
    }


    @GetMapping("/get/{id}")
    @Operation(summary = "Получение контакта по id")
    @Override
    public GroupDto findById(@PathVariable Long id) {
        return groupService.findByIdAndReturnDto(id);
    }

    @PostMapping("/{groupId}/assign-teacher")
    @Operation(summary = "Добавление учителя в группу")
    public GroupDto addTeacherToGroup(@PathVariable Long groupId, Long teacherId) {
        return groupService.addTeacherToGroup(groupId, teacherId);
    }

    @PostMapping("/{groupId}/assign-assistant")
    @Operation(summary = "Добавление помощника в группу")
    public GroupDto addAssistantToGroup(Long groupId, Long assistandId) {
        return groupService.addAssistantToGroup(groupId, assistandId);
    }

    @PostMapping("/{groupId}/add-child")
    public GroupDto addChildToGroup(Long groupId, Long childId) {
        return groupService.addChildToGroup(groupId, childId);
    }
}

