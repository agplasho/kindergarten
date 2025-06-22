package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.enums.ParentRole;
import kg.mega.kindergarten.models.Contact;

public record ParentDto(
        Long id,
        String firstName,
        String lastName,
        ParentRole role,
        Contact contact
) {
}
