package kg.mega.kindergarten.models;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class Human {
    @NotBlank(message = "Эта строка не должна оставаться пустой")
    private String firstName;
    @NotBlank(message = "Эта строка не должна оставаться пустой")
    private String lastName;
}
