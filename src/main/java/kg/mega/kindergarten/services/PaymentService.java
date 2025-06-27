package kg.mega.kindergarten.services;

import kg.mega.kindergarten.models.Payment;
import kg.mega.kindergarten.models.dtos.PaymentCreateDto;
import kg.mega.kindergarten.models.dtos.PaymentDto;
import kg.mega.kindergarten.models.dtos.PaymentUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PaymentService {
    PaymentDto create(PaymentCreateDto paymentCreateDto);

    ResponseEntity<?> deletePaymentById(Long id);

    List<PaymentDto> getAllPayments(int page, int size);

    PaymentDto findPaymentById(Long paymentId);

    PaymentDto update(Long paymentId, PaymentUpdateDto paymentUpdateDto);
}
