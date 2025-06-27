package kg.mega.kindergarten.mappers;

import kg.mega.kindergarten.models.Contact;
import kg.mega.kindergarten.models.Parent;
import kg.mega.kindergarten.models.dtos.ParentCreateDto;
import kg.mega.kindergarten.models.dtos.ParentDto;
import kg.mega.kindergarten.models.dtos.ParentUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParentMapper {

    ParentMapper INSTANCE = Mappers.getMapper(ParentMapper.class);

    @Mapping(source = "contact", target = "contact")
    @Mapping(target = "id", ignore = true)
    Parent parentCreateDtoToParent(ParentCreateDto parentCreateDto, Contact contact);
    ParentDto parentToParentDto(Parent parent);

    Parent parentUpdateDtoToParent(ParentUpdateDto parentUpdateDto, Contact contact);

    void updateParentFromDto(ParentUpdateDto parentUpdateDto, @MappingTarget Parent parent);

}
