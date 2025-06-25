package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.enums.TeacherPosition;
import kg.mega.kindergarten.models.Contact;

import java.time.LocalDate;

public record TeacherCreateDto(

        String firstName,
        String lastName,
        String email,
        TeacherPosition position,
        Contact contact

) {
}
