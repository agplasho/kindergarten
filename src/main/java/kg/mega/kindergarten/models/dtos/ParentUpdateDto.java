package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.enums.ParentRole;

public record ParentUpdateDto(
        String firstName,
        String lastName,
        ParentRole parentRole,
        Long contactId,
        boolean active
) {
}
