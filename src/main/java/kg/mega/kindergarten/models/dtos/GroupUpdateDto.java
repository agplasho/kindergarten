package kg.mega.kindergarten.models.dtos;

public record GroupUpdateDto(
        String name,
        Long teacherId,
        Long assistantId,
        Long ageGroup,
        boolean active
) {
}
