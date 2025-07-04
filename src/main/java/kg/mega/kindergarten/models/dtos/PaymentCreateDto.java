package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.enums.PaymentType;
import kg.mega.kindergarten.models.Child;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record PaymentCreateDto (
        Long child,
        double paymentSum,
        LocalDateTime paymentDate,
        String paymentPeriod,
        PaymentType paymentType

){

}
