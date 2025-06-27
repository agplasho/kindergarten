package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.enums.PaymentType;
import kg.mega.kindergarten.models.Child;

import java.time.LocalDateTime;

public record PaymentDto (
        Long id,
        Child child,
        double paymentSum,
        LocalDateTime paymentDate,
        String paymentPeriod,
        PaymentType paymentType,
        boolean active
){
}
