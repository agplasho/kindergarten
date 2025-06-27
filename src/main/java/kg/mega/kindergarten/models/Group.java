package kg.mega.kindergarten.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "groups")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = " teacher_id")
    Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "assistant_id")
    Teacher assistant;
    @NotBlank(message = "Имя не должно быть пустым")
    String name;
    @ManyToOne
    @JoinColumn(name = "age_group_id", nullable = false)
    AgeGroup ageGroup;
    boolean isActive = true;

}
