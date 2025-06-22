package kg.mega.kindergarten.repositories;

import kg.mega.kindergarten.models.AgeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgeGroupRepo  extends JpaRepository<AgeGroup,Long> {
}
