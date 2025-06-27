package kg.mega.kindergarten.models.dtos;

public record GroupCreateDto(
        String name,
        Long ageGroup,
        Long teacherId,
        Long assistantId
) {

}

