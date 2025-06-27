package kg.mega.kindergarten.models.dtos;

import jakarta.validation.constraints.Positive;
import kg.mega.kindergarten.enums.TeacherPosition;
import kg.mega.kindergarten.models.Contact;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TeacherCreateDto(

        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        TeacherPosition position,
        @Positive
        Long contactId

) {
}
