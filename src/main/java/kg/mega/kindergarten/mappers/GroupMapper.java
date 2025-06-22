package kg.mega.kindergarten.mappers;

import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.dtos.ChildDto;
import kg.mega.kindergarten.models.dtos.GroupCreateDto;
import kg.mega.kindergarten.models.dtos.GroupDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GroupMapper {

    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    Group groupCreateDtoToGroup(GroupCreateDto groupCreateDto);

    GroupDto groupToGroupDto(Group group);
    List<GroupDto> groupListToGroupListDto(List<Group> groups);

    Group groupDtoToGroup(GroupDto groupDto);
}
