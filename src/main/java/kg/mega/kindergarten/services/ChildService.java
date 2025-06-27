package kg.mega.kindergarten.services;

import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.dtos.ChildCreateDto;
import kg.mega.kindergarten.models.dtos.ChildDto;
import kg.mega.kindergarten.models.dtos.ChildUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChildService {

    ChildDto create(ChildCreateDto childCreateDto);

    Child findById(Long child);

    ChildDto update(Long childId, ChildUpdateDto childUpdateDto);

    ResponseEntity<?> deleteById(Long id);

    List<ChildDto> getAll(int page, int size);

    ChildDto findByIdAndReturnDto(Long id);

    Child addChildToGroup(Long groupId);
}
