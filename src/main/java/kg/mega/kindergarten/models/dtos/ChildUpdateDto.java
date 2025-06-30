package kg.mega.kindergarten.models.dtos;

import java.time.LocalDate;
import java.util.List;

public record ChildUpdateDto(
        String firstName,
        String lastName,
        String patronymic,
        LocalDate dateOfBirth,
        Long groupId,
        List<Long> parentsIds,
        boolean active) {
}
