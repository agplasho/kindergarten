package kg.mega.kindergarten.services;

import kg.mega.kindergarten.models.Payment;
import kg.mega.kindergarten.models.dtos.PaymentCreateDto;
import kg.mega.kindergarten.models.dtos.PaymentDto;

public interface PaymentService {
    PaymentDto createPaymentByChild(PaymentCreateDto paymentCreateDto);

    Payment getPaymentByChildId(Long childId);

    boolean deletePayment(Long paymentId);
}
