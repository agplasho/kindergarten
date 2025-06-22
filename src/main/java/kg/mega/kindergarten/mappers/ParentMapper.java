package kg.mega.kindergarten.mappers;

import kg.mega.kindergarten.models.Parent;
import kg.mega.kindergarten.models.dtos.ParentCreateDto;
import kg.mega.kindergarten.models.dtos.ParentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParentMapper {
    ParentMapper INSTANCE = Mappers.getMapper(ParentMapper.class);

    Parent parentCreateDtoToParent(ParentCreateDto parentCreateDto);

    ParentDto parentToParentDto(Parent parent);

    Parent parentDtoToParent(ParentDto parentDto);

}
