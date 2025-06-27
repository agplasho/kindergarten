package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.models.Group;
import kg.mega.kindergarten.models.Parent;

import java.time.LocalDate;
import java.util.List;

public record ChildDto(
        Long id,
        String firstName,
        String lastName,
        String patronymic,
        LocalDate dateOfBirth,
        Group group,
        List<Parent> parents,
        boolean active

) {

}
