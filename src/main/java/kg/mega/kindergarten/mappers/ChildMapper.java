package kg.mega.kindergarten.mappers;


import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.Parent;
import kg.mega.kindergarten.models.dtos.ChildCreateDto;
import kg.mega.kindergarten.models.dtos.ChildDto;
import kg.mega.kindergarten.models.dtos.ChildUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ChildMapper {
    ChildMapper INSTANCE = Mappers.getMapper(ChildMapper.class);


    @Mapping(source = "parents", target = "parents")
    @Mapping(source = "group", target = "group")
    @Mapping(target = "id", ignore = true)
    Child childCreateDtoToChild(ChildCreateDto childCreateDto, List <Parent> parents, Group group);

    ChildDto childToChildDto(Child child);


    Child childUpdateDtoToChild(ChildUpdateDto childUpdateDto);

    List <ChildDto> childToChildDtoList(List<Child> childs);

    void updateChildByDto(ChildUpdateDto childUpdateDto,@MappingTarget Child child);
}
