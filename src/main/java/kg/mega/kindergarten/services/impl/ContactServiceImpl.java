package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.mappers.ContactMapper;
import kg.mega.kindergarten.models.Contact;
import kg.mega.kindergarten.models.dtos.ContactCreateDto;
import kg.mega.kindergarten.models.dtos.ContactDto;
import kg.mega.kindergarten.models.dtos.ContactUpdateDto;
import kg.mega.kindergarten.repositories.ContactRepo;
import kg.mega.kindergarten.services.ContactService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepo contactRepo;

    public ContactServiceImpl(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @Override
    public ContactDto create(ContactCreateDto contactCreateDto) {
        Contact contact = ContactMapper.INSTANCE.contactCreateDtoToContact(contactCreateDto);
        contact = contactRepo.save(contact);
        return ContactMapper.INSTANCE.contactToContactDto(contact);
    }

    @Override
    public Contact findById(Long contactId) {
        return contactRepo.findById(contactId).orElseThrow(() -> new RuntimeException("Контакт не найден"));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Contact contact = contactRepo.findById(id).orElseThrow(() -> new RuntimeException("Контакт не найден"));
        contactRepo.delete(contact);
        return ResponseEntity.ok().build();
    }

    @Override
    public ContactDto update(Long id, ContactUpdateDto contactUpdateDto) {
        Contact contact = contactRepo.findById(id).orElseThrow(() -> new RuntimeException("Контакт не найден"));
        ContactMapper.INSTANCE.updateContactByDto(contactUpdateDto, contact);
        contact = contactRepo.save(contact);
        return ContactMapper.INSTANCE.contactToContactDto(contact);
    }

    @Override
    public List<ContactDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Contact> contacts = contactRepo.findAll(pageable).stream().toList();
        return ContactMapper.INSTANCE.contactToContactDtoList(contacts);
    }

    @Override
    public ContactDto findByIdAndReturnDto(Long id) {
        Contact contact = contactRepo.findById(id).orElseThrow(()-> new RuntimeException("Контакт не найден"));
        return ContactMapper.INSTANCE.contactToContactDto(contact);
    }
}
