package kg.mega.kindergarten.models.dtos;

import jakarta.validation.constraints.NotBlank;

public record AgeGroupDto(
        Long id,
        @NotBlank
        String name,
        @NotBlank
        int minAge,
        @NotBlank
        int maxAge

) {
}
