package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.enums.ParentRole;

public record ParentCreateDto(
        String firstName,
        String lastName,
        ParentRole parentRole
) {
}
