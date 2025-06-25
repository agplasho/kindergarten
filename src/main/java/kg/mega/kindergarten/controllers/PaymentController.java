package kg.mega.kindergarten.controllers;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kg.mega.kindergarten.models.dtos.PaymentCreateDto;
import kg.mega.kindergarten.models.dtos.PaymentDto;
import kg.mega.kindergarten.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody PaymentCreateDto paymentCreateDto) {
        return ResponseEntity.ok(paymentService.createPaymentByChild(paymentCreateDto));
    }
    @GetMapping("/get_payment_by_child_id{childId}")
    public ResponseEntity<?> getPaymentByChild(@PathVariable Long childId){
        return ResponseEntity.ok(paymentService.getPaymentByChildId(childId));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePayment(@RequestParam Long paymentId){
        return ResponseEntity.ok(paymentService.deletePayment(paymentId));
    }

}
