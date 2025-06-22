package kg.mega.kindergarten.models.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kg.mega.kindergarten.models.Group;

public record ChildDto(
        Long Id,
        String firstName,
        String lastName,
        @Min(3)
        @Max(6)
        int age,
        @NotNull
        Group group

) {

}
