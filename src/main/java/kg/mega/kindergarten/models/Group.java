package kg.mega.kindergarten.models;

import jakarta.persistence.*;
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
    String name;
    @ManyToOne
    @JoinColumn(name = "age_group_id", nullable = false)
    AgeGroup ageGroup;

}
