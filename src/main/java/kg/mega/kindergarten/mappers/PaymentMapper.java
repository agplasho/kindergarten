package kg.mega.kindergarten.mappers;

import kg.mega.kindergarten.models.Payment;
import kg.mega.kindergarten.models.dtos.PaymentCreateDto;
import kg.mega.kindergarten.models.dtos.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    Payment paymentCreateDtoToPayment(PaymentCreateDto paymentCreateDto);

    PaymentDto paymentToPaymentDto(Payment payment);

    Payment paymentDtoToPayment(Payment payment);


}
