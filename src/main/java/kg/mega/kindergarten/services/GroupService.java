package kg.mega.kindergarten.services;

import aj.org.objectweb.asm.commons.Remapper;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.dtos.GroupCreateDto;
import kg.mega.kindergarten.models.dtos.GroupDto;

import java.util.List;

public interface GroupService {
    GroupDto createGroup(GroupCreateDto groupCreateDto);

    Group findGroupById(Long id);

    List<Group> findAllGroupsById(int page, int size);

    GroupDto updateGroup(GroupDto groupDto);

    boolean deleteGroup(Long id);
}
