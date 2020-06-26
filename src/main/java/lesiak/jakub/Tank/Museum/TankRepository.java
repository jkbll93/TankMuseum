package lesiak.jakub.Tank.Museum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface TankRepository extends JpaRepository<Tank, String> {

    List<Tank> findAllById(String id);
}