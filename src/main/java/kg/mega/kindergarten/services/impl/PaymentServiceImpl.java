package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.mappers.PaymentMapper;
import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.Payment;
import kg.mega.kindergarten.models.dtos.PaymentCreateDto;
import kg.mega.kindergarten.models.dtos.PaymentDto;
import kg.mega.kindergarten.models.dtos.PaymentUpdateDto;
import kg.mega.kindergarten.repositories.PaymentRepo;
import kg.mega.kindergarten.services.ChildService;
import kg.mega.kindergarten.services.PaymentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo paymentRepo;
    private final ChildService childService;

    public PaymentServiceImpl(PaymentRepo paymentRepo, ChildService childService) {
        this.paymentRepo = paymentRepo;
        this.childService = childService;
    }

    @Override
    public PaymentDto create(PaymentCreateDto paymentCreateDto) {
        Child child = childService.findById(paymentCreateDto.child());
        Payment payment = PaymentMapper.INSTANCE.paymentCreateDtoToPayment(paymentCreateDto, child);
        payment = paymentRepo.save(payment);
        return PaymentMapper.INSTANCE.paymentToPaymentDto(payment);
    }

    @Override
    public PaymentDto update(Long paymentId, PaymentUpdateDto paymentUpdateDto) {
        Child child = childService.findById(paymentUpdateDto.child());
        Payment payment = paymentRepo.findById(paymentId).orElseThrow(()->new RuntimeException("Оплата по данному id не найдена"));
        PaymentMapper.INSTANCE.updatePaymentByDto(paymentUpdateDto,child, payment);
        payment.setChild(child);
        payment = paymentRepo.save(payment);
        return PaymentMapper.INSTANCE.paymentToPaymentDto(payment);
    }

    @Override
    public ResponseEntity<?> deletePaymentById(Long id) {
        Payment payment = paymentRepo.findById(id).orElseThrow();
        payment.setActive(false);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<PaymentDto> getAllPayments(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return paymentRepo.findAllPayments (pageable);
    }

    @Override
    public PaymentDto findPaymentById(Long paymentId) {
        Payment payment = paymentRepo.findById(paymentId).orElseThrow();
        return PaymentMapper.INSTANCE.paymentToPaymentDto(payment);
    }
}
