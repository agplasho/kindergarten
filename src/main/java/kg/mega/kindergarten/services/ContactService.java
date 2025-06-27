package kg.mega.kindergarten.services;

import kg.mega.kindergarten.models.Contact;
import kg.mega.kindergarten.models.dtos.ContactCreateDto;
import kg.mega.kindergarten.models.dtos.ContactDto;
import kg.mega.kindergarten.models.dtos.ContactUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactService {
    ContactDto create(ContactCreateDto contactCreateDto);

    Contact findById(Long aLong);

    ResponseEntity<?> delete(Long id);

    ContactDto update(Long id, ContactUpdateDto updatedDto);

    List<ContactDto> getAll(int page, int size);

    ContactDto findByIdAndReturnDto(Long id);
}
