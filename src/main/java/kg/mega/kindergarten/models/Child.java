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

    boolean active = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
