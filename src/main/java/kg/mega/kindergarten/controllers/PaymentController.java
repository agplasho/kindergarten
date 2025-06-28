package kg.mega.kindergarten.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kg.mega.kindergarten.models.dtos.PaymentCreateDto;
import kg.mega.kindergarten.models.dtos.PaymentDto;
import kg.mega.kindergarten.models.dtos.PaymentUpdateDto;
import kg.mega.kindergarten.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment")
public class PaymentController implements CRUDOperations<PaymentDto, PaymentCreateDto, PaymentUpdateDto>{

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @Operation(summary = "Создать транзакцию для ребенка" )
    @Override
    public PaymentDto create(PaymentCreateDto paymentCreateDto) {
        return paymentService.create (paymentCreateDto);
    }



    @Operation (summary = "Обновить оплату")
    @Override
    public PaymentDto update(@PathVariable Long paymentId, PaymentUpdateDto paymentUpdateDto) {
        return paymentService.update (paymentId,paymentUpdateDto);
    }



    @Operation (summary = "Удалить оплату")
    @Override
    public ResponseEntity<?> delete(Long id) {
        return paymentService.deletePaymentById (id);
    }


    @Operation (summary = "Получить список оплат")
    @Override
    public List<PaymentDto> allList(int page, int size) {
        return paymentService.getAllPayments (page, size);
    }



    @Operation (summary = "Найти оплату по ID")
    @Override
    public PaymentDto findById(@RequestParam Long paymentId) {
        return paymentService.findPaymentById (paymentId);
    }

}
