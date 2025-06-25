package kg.mega.kindergarten.models.dtos;

import kg.mega.kindergarten.enums.PaymentType;
import kg.mega.kindergarten.models.Child;

import java.time.LocalDate;
import java.util.List;

public record PaymentCreateDto (
        List<Child> children,
        double paymentSum,
        LocalDate paymentDate,
        String paymentPeriod,
        PaymentType paymentType

){

}
