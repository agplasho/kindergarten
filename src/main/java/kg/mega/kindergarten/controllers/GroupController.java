package kg.mega.kindergarten.controllers;

import io.swagger.v3.oas.annotations.Operation;
import kg.mega.kindergarten.mappers.GroupMapper;
import kg.mega.kindergarten.models.dtos.GroupCreateDto;
import kg.mega.kindergarten.models.dtos.GroupDto;
import kg.mega.kindergarten.services.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController implements CRUDOperations<GroupDto, GroupCreateDto, Long> {

    private final GroupService groupService;


    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    @PostMapping("/create")
    @Operation(summary = "Создание группы")
    @Override
    public GroupDto create(@RequestBody GroupCreateDto groupCreateDto) {
        return groupService.createGroup(groupCreateDto);
    }

    @GetMapping("/read")
    @Operation(summary = "Получить группу по ID")
    @Override
    public GroupDto read(@PathVariable Long id) {
        return GroupMapper.INSTANCE.groupToGroupDto(groupService.findGroupById(id));
    }

    @GetMapping("/all")
    @Operation(summary = "Получить все группы")
    @Override
    public List<GroupDto> readAll(@RequestParam int page, @RequestParam int size) {
        return groupService.findAllGroupsById(page, size).stream().map(GroupMapper.INSTANCE::groupToGroupDto).toList();
    }

    @PutMapping("/update")
    @Operation(summary = "Обновить группу")
    @Override
    public GroupDto update(GroupDto groupDto) {
        return groupService.updateGroup(groupDto);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Удалить группу")
    @Override
    public boolean delete(Long id) {
        return groupService.deleteGroup(id);
    }
}
