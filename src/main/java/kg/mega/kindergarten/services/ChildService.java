package kg.mega.kindergarten.services;

import kg.mega.kindergarten.models.Child;
import kg.mega.kindergarten.models.dtos.ChildCreateDto;
import kg.mega.kindergarten.models.dtos.ChildDto;

import java.util.List;

public interface ChildService {
    ChildDto createChild(ChildCreateDto childCreateDto);

    Child findChildById(Long id);

    List<Child> findAllChildrenById(int page, int size);

    ChildDto updateChild(ChildDto childDto);


    boolean deleteChild(Long id);
}
