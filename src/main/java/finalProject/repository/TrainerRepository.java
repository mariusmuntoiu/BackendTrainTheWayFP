package finalProject.repository;

import finalProject.models.Program;
import finalProject.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
   // public List<Program> findByTrainerId(String trainerID);
}
