package kg.mega.kindergarten.controllers;

import io.swagger.v3.oas.annotations.Operation;
import kg.mega.kindergarten.models.dtos.ContactCreateDto;
import kg.mega.kindergarten.models.dtos.ContactDto;
import kg.mega.kindergarten.models.dtos.ContactUpdateDto;
import kg.mega.kindergarten.services.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController implements CRUDOperations<ContactDto, ContactCreateDto, ContactUpdateDto> {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @Operation(summary = "Создание контакта")
    @Override
    public ContactDto create(@RequestBody ContactCreateDto contactCreateDto) {
        return contactService.create (contactCreateDto);
    }



    @Operation (summary = "Обновить контакт")
    @Override
    public ContactDto update(@PathVariable Long id, @RequestBody ContactUpdateDto updatedDto) {
        return contactService.update (id, updatedDto);
    }


    @Operation (summary = "Удалить контакт по ID")
    @Override
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return contactService.delete (id);
    }


    @Operation (summary = "Получение всех контактов по страницам")
    @Override
    public List<ContactDto> allList(@RequestParam  int page, @RequestParam int size) {
        return contactService.getAll (page, size);
    }


    @Operation (summary = "Поиска контакта по ID")
    @Override
    public ContactDto findById(@PathVariable Long id) {
        return contactService.findByIdAndReturnDto(id);
    }
}