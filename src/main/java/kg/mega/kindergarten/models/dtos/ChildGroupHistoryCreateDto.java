package kg.mega.kindergarten.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ChildGroupHistoryCreateDto(
        Long group,
        Long child,
        LocalDateTime startDate,
        LocalDateTime endDate,
        double price
) {
}
