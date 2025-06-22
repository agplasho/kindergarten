package kg.mega.kindergarten.services;

import kg.mega.kindergarten.models.Parent;
import kg.mega.kindergarten.models.dtos.ParentCreateDto;
import kg.mega.kindergarten.models.dtos.ParentDto;

import java.util.Collection;
import java.util.List;

public interface ParentService {
    ParentDto createParent(ParentCreateDto parentCreateDto);

    Parent findParentById(Long id);

    List<Parent> findAllParentsById(int page, int size);

    ParentDto updateParent(ParentDto parentDto);

    boolean deleteParentById(Long id);
}
