package kg.mega.kindergarten.models.dtos;

public record ContactDto(
        Long id,
        String phoneNumber,
        String secondaryNumber,
        String email
) {
}
