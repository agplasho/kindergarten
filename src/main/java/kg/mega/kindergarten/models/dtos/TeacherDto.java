package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.enums.TeacherPosition;
import kg.mega.kindergarten.models.Contact;

public record TeacherDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        TeacherPosition position,
        Contact contact

) {
}
