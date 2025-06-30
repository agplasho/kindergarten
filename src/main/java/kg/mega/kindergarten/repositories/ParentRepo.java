package kg.mega.kindergarten.repositories;

import kg.mega.kindergarten.models.Parent;
import kg.mega.kindergarten.models.dtos.ParentDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepo extends JpaRepository<Parent,Long> {
    @Query("select u from Parent u where u.id in ?1")
    List<Parent> findAllByIds(List<Long> parentsIds);


    @Query ("select new kg.mega.kindergarten.models.dtos.ParentDto (u.id, u.firstName, u.lastName,  u.role, u.contact, u.active) from Parent u")
    List<ParentDto> findAllParents(Pageable pageable);
}
