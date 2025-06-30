package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.enums.TeacherPosition;
import kg.mega.kindergarten.models.Contact;

import java.time.LocalDate;

public record TeacherDto(
        Long id,
        TeacherPosition position,
        LocalDate dateOfBirth,
        Contact contact,
        String firstName,
        String lastName,
        boolean active

) {
}
