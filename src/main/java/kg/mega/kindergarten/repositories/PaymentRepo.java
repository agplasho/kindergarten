package kg.mega.kindergarten.repositories;

import kg.mega.kindergarten.models.Payment;
import kg.mega.kindergarten.models.dtos.PaymentDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    @Query("select new kg.mega.kindergarten.models.dtos.PaymentDto (u.id, u.child,u.paymentSum,u.paymentDate, u.period, u.paymentType, u.active) from Payment u")
    List<PaymentDto> findAllPayments(Pageable pageable);
}
