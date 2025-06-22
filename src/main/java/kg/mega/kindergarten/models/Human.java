package kg.mega.kindergarten.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class Human {
    private String firstName;
    private String lastName;
}
