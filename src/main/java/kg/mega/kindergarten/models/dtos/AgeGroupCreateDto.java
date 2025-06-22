package kg.mega.kindergarten.models.dtos;

public record AgeGroupCreateDto(

        Long id,
        String name,
        int minAge,
        int maxAge,

        boolean active,
        double price

) {
}
