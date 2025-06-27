package kg.mega.kindergarten.models.dtos;

import jakarta.validation.constraints.Positive;
import kg.mega.kindergarten.enums.TeacherPosition;

import java.time.LocalDate;

public record TeacherUpdateDto(
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        @Positive
        Long contactId,
        TeacherPosition position,
        boolean active

) {
}
