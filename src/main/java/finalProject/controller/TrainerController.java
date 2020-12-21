package finalProject.controller;

import finalProject.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerController extends JpaRepository<Trainer, Long> {
}
