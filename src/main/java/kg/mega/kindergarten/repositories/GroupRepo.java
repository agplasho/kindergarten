package kg.mega.kindergarten.repositories;


import kg.mega.kindergarten.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Group,Long> {

}
