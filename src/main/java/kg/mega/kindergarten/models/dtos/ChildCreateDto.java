package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.Parent;

import java.time.LocalDate;

public record ChildCreateDto(
        Group group,
        LocalDate dateOfBirth,
        Parent parents


) {
}
