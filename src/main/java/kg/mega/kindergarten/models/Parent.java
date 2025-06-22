package kg.mega.kindergarten.models;

import jakarta.persistence.*;
import kg.mega.kindergarten.enums.ParentRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "parents")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Parent extends Human{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    @JoinColumn(name = "contact_id", nullable = false)
    Contact contact;
    @Enumerated(EnumType.STRING)
    ParentRole role;
}
