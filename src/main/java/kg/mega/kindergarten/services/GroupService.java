package kg.mega.kindergarten.services;

import aj.org.objectweb.asm.commons.Remapper;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.dtos.GroupCreateDto;
import kg.mega.kindergarten.models.dtos.GroupDto;
import kg.mega.kindergarten.models.dtos.GroupUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GroupService {
    GroupDto create(GroupCreateDto groupCreateDto);

    Group findById(Long groupId);

    GroupDto update(Long id, GroupUpdateDto updatedDto);

    ResponseEntity<?> delete(Long id);

    List<GroupDto> getAll(int page, int size);

    GroupDto findByIdAndReturnDto(Long id);

    GroupDto addTeacherToGroup(Long groupId, Long teacherId);

    GroupDto addAssistantToGroup(Long groupId, Long assistandId);


}
