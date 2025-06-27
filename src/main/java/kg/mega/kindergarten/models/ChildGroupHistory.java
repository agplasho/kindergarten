package kg.mega.kindergarten.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "child_group_history")
public class ChildGroupHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    Group group;
    @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    Child child;
    LocalDateTime startDate;
    LocalDateTime endDate;
    double price;
}