package kg.mega.kindergarten.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "child_group_histories")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ChildrenGroupHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    Group group;
    LocalDateTime startDate;
    LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    Child child;
    double price;
}
