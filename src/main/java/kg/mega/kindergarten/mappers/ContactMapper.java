package kg.mega.kindergarten.mappers;

import kg.mega.kindergarten.models.Contact;
import kg.mega.kindergarten.models.dtos.ContactCreateDto;
import kg.mega.kindergarten.models.dtos.ContactDto;
import kg.mega.kindergarten.models.dtos.ContactUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactMapper {

    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    Contact contactCreateDtoToContact(ContactCreateDto contactCreateDto);

    ContactDto contactToContactDto(Contact contact);

    @Mapping(target = "id", ignore = true)
    Contact contactUpdateDtoToContact(ContactUpdateDto contactUpdateDto);

    List<ContactDto> contactToContactDtoList(List<Contact> contacts);

    void updateContactByDto(ContactUpdateDto contactUpdateDto, @MappingTarget Contact contact);
}
