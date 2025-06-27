package kg.mega.kindergarten.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "childrens")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Child extends Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "group_id")
    Group group;
    @Past
    LocalDate birthDate;

    @ManyToMany
    @JoinTable(name = " child_parents",
            joinColumns = @JoinColumn(name = "child_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "parent_id", nullable = false))
    List<Parent> parents;


}
