package kg.mega.kindergarten.mappers;

import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.Payment;
import kg.mega.kindergarten.models.dtos.PaymentCreateDto;
import kg.mega.kindergarten.models.dtos.PaymentDto;
import kg.mega.kindergarten.models.dtos.PaymentUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    @Mapping(source = "child", target = "child")
    @Mapping(target = "id", ignore = true)
    Payment paymentCreateDtoToPayment(PaymentCreateDto paymentCreateDto, Child child);
    PaymentDto paymentToPaymentDto(Payment payment);

    @Mapping(source = "child", target = "child")
    @Mapping(source = "paymentUpdateDto.active", target = "active")
    Payment paymentUpdateDtoToPayment(PaymentUpdateDto paymentUpdateDto, Child child);

    @Mapping(source = "child", target = "child")
    @Mapping(source = "paymentUpdateDto.active", target = "active")
    void updatePaymentByDto(PaymentUpdateDto paymentUpdateDto, Child child,@MappingTarget Payment payment);


}
