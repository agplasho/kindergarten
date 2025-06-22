package kg.mega.kindergarten.mappers;


import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.dtos.ChildCreateDto;
import kg.mega.kindergarten.models.dtos.ChildDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ChildMapper {
    ChildMapper INSTANCE = Mappers.getMapper(ChildMapper.class);

    Child childCreateDtoToChild(ChildCreateDto childCreateDto);

    ChildDto childToChildDto(Child child);

    List<ChildDto> childListToChildListDto(List<Child> children);

    Child childDtoToChild(ChildDto childDto);
}
