package kg.mega.kindergarten.models.dtos;

public record AgeGroupCreateDto(

        String name,
        int minAge,
        int maxAge,

        boolean active,
        double price

) {
}
