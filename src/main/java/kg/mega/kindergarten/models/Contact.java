package kg.mega.kindergarten.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "contacts")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String phoneNumber;
    String secondaryPhoneNumber;
    String email;
}
