package kg.mega.kindergarten.mappers;

import kg.mega.kindergarten.models.AgeGroup;
import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.Teacher;
import kg.mega.kindergarten.models.dtos.ChildDto;
import kg.mega.kindergarten.models.dtos.GroupCreateDto;
import kg.mega.kindergarten.models.dtos.GroupDto;
import kg.mega.kindergarten.models.dtos.GroupUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GroupMapper {

    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    @Mapping(source = "ageGroup", target = "ageGroup")
    @Mapping(source = "groupCreateDto.name", target = "name")
    @Mapping(source = "teacher", target = "teacher")
    @Mapping(source = "assistant", target = "assistant")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    Group groupCreateDto(GroupCreateDto groupCreateDto, AgeGroup ageGroup, Teacher teacher, Teacher assistant);
    GroupDto groupCreateDto(Group group);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "groupUpdateDto.name", target = "name")
    @Mapping(source = "ageGroup", target = "ageGroup")
    @Mapping(source = "groupUpdateDto.active", target = "active")
    Group groupUpdateDto(GroupUpdateDto groupUpdateDto, AgeGroup ageGroup);
    List <GroupDto> groupToGroupDtoList(List<Group> groups);
}
