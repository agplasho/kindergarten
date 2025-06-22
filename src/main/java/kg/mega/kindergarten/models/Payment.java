package kg.mega.kindergarten.models;

import jakarta.persistence.*;
import kg.mega.kindergarten.enums.PaymentType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    Child child;
    double paymentSum;
    LocalDateTime paymentDate;
    String period;
    @Enumerated(EnumType.STRING)
    PaymentType paymentType;
}
