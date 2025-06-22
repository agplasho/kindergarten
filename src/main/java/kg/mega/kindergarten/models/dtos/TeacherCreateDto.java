package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.enums.TeacherPosition;

import java.time.LocalDate;

public record TeacherCreateDto(
        String firstName,
        String lastName,
        TeacherPosition position,
        LocalDate DateOfBirth
) {
}
