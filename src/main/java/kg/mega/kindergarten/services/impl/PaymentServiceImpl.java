package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.mappers.PaymentMapper;
import kg.mega.kindergarten.models.Payment;
import kg.mega.kindergarten.models.dtos.PaymentCreateDto;
import kg.mega.kindergarten.models.dtos.PaymentDto;
import kg.mega.kindergarten.repositories.PaymentRepo;
import kg.mega.kindergarten.services.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo paymentRepo;

    public PaymentServiceImpl(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @Override
    public PaymentDto createPaymentByChild(PaymentCreateDto paymentCreateDto) {
        Payment payment = PaymentMapper.INSTANCE.paymentCreateDtoToPayment(paymentCreateDto);
        payment = paymentRepo.save(payment);
        return PaymentMapper.INSTANCE.paymentToPaymentDto(payment);
    }

    @Override
    public Payment getPaymentByChildId(Long childId) {
        return paymentRepo.findById(childId).orElseThrow(() -> new RuntimeException("Ребенок с ID : " + childId + "не найден" ));
    }

    @Override
    public boolean deletePayment(Long paymentId) {
        Payment existing = paymentRepo.findById(paymentId).orElseThrow(null);
        if(existing == null) {
            return false;
        }
        paymentRepo.delete(existing);
        return  true;
    }
}
