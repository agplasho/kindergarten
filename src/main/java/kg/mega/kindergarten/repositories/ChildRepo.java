package kg.mega.kindergarten.repositories;

import kg.mega.kindergarten.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepo extends JpaRepository<Child,Long> {
}
