package finalProject.repository;

import finalProject.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepo extends JpaRepository<Trainer, Long> {
}
