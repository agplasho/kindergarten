package kg.mega.kindergarten.services;

import kg.mega.kindergarten.models.Parent;
import kg.mega.kindergarten.models.dtos.ParentCreateDto;
import kg.mega.kindergarten.models.dtos.ParentDto;
import kg.mega.kindergarten.models.dtos.ParentUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

public interface ParentService {
    ParentDto create(ParentCreateDto parentCreateDto);

    List<Parent> findParentByIds(List<Long> parentsIds);

    ParentDto findById(Long parentId);


    List<ParentDto> findAll(int page, int size);

    ResponseEntity<?> deleteById(Long id);

    ParentDto update(Long parentId, ParentUpdateDto parentUpdateDto);
}
