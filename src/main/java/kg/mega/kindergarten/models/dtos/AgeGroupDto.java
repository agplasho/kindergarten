package kg.mega.kindergarten.models.dtos;

import jakarta.validation.constraints.NotBlank;

public record AgeGroupDto(
        Long id,
        String name,
        double price,
        boolean active

) {
}
