package finalProject.repository;

import finalProject.controller.TrainerController;
import finalProject.errors.ResourceNotFoundException;
import finalProject.models.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TrainerRepository {

    @Autowired
    private TrainerController trainerRepository;

    @GetMapping("/trainer")
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Trainer> findTrainerById(@PathVariable(value = "id") Long trainerId) throws ResourceNotFoundException {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer not found for this id ::" + trainerId));
        return ResponseEntity.ok().body(trainer);
    }

    //TODO: @Valid annotation should be here but cannot add it.
    @PostMapping("/trainer")
    public Trainer createTrainer(@Validated @RequestBody Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @PutMapping("/trainer/{id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable(value = "id")Long trainerId,
                                                 @Validated @RequestBody Trainer trainerDetails)
            throws ResourceNotFoundException {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer not found for this id ::" + trainerId));
        trainer.setFirstName(trainerDetails.getFirstName());
        trainer.setLastName(trainerDetails.getLastName());
        trainer.setGender(trainerDetails.getGender());
        trainer.setBirthDate(trainerDetails.getBirthDate());
        trainer.setEmail(trainerDetails.getEmail());
        trainer.setPhoneNumber(trainerDetails.getPhoneNumber());
        final Trainer updatedTrainer = trainerRepository.save(trainer);
        return ResponseEntity.ok(updatedTrainer);
    }

    @DeleteMapping("/trainer/{id}")
    public Map<String, Boolean> deleteTrainer(@PathVariable(value = "id") Long trainerId)
            throws ResourceNotFoundException {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer not found for this id ::" + trainerId));
        trainerRepository.delete(trainer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
