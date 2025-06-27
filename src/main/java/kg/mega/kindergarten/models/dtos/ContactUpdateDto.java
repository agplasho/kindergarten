package kg.mega.kindergarten.models.dtos;

public record ContactUpdateDto(
        String phoneNumber,
        String secondaryNumber,
        String email
) {
}
