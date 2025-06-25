package kg.mega.kindergarten.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.Parent;

import java.time.LocalDate;
import java.util.List;

public record ChildCreateDto(
        String firstName,
        String lastName,
        Long groupId,
        @JsonFormat(pattern = "dd.MM.yyyy")
        LocalDate dateOfBirth,
        List<Long> parentsId


) {
}
