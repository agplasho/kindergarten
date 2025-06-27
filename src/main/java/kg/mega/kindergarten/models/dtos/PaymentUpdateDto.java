package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.enums.PaymentType;

import java.time.LocalDateTime;

public record PaymentUpdateDto(
        Long child,
        double paymentSum,
        LocalDateTime paymentDate,
        String paymentPeriod,
        PaymentType paymentType,
        boolean active
) {
}
