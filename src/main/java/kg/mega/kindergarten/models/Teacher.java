package kg.mega.kindergarten.models;

import jakarta.persistence.*;
import kg.mega.kindergarten.enums.TeacherPosition;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "teachers")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Teacher extends Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    TeacherPosition position;
    @OneToOne
    @JoinColumn(name = "contact_id", nullable = false)
    Contact contact;
    LocalDate dateOfBirth;


}
