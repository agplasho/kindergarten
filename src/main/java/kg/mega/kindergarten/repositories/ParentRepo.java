package kg.mega.kindergarten.repositories;

import kg.mega.kindergarten.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepo extends JpaRepository<Parent,Long> {
}
