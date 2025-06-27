package kg.mega.kindergarten.services;

import kg.mega.kindergarten.models.dtos.ChildGroupHistoryCreateDto;
import kg.mega.kindergarten.models.dtos.ChildGroupHistoryDto;
import kg.mega.kindergarten.models.dtos.ChildGroupHistoryUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChildGroupHistoryService {

    ChildGroupHistoryDto create(ChildGroupHistoryCreateDto childGroupHistoryCreateDto);

    ChildGroupHistoryDto update(Long id, ChildGroupHistoryUpdateDto updatedDto);

    ResponseEntity<?> delete(Long id);

    List<ChildGroupHistoryDto> getAll(int page, int size);

    ChildGroupHistoryDto findById(Long id);
}
