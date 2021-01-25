package finalProject.controller;

import finalProject.repository.TrainerRepository;
import finalProject.errors.ResourceNotFoundException;
import finalProject.models.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrainerController {

    @Autowired
     private TrainerRepository trainerRepository;

    @GetMapping("/trainer")
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @GetMapping("/trainer/{trainerID}")
    public ResponseEntity<Trainer> findTrainerById(
            @PathVariable(value = "trainerID") Long trainerId)
            throws ResourceNotFoundException {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Trainer not found for this id ::" + trainerId));
        return ResponseEntity.ok().body(trainer);
    }

    @PostMapping("/trainer")
    public Trainer addTrainer(@Valid @RequestBody Trainer trainer) {
         trainerRepository.save(trainer);
         return trainer;
    }

   // //TODO: @Valid annotation should be here but cannot add it(FIXED).
    //  @PostMapping("/trainer")
    //  public Trainer createTrainer(@Valid @RequestBody Trainer trainer) {
    // return trainerRepository.save(trainer);
   // }

    @PutMapping("/trainer")
    public ResponseEntity<Trainer> updateTrainer(
                                                 @Valid @RequestBody Trainer trainerDetails)
            throws ResourceNotFoundException {
        Trainer trainer = trainerRepository.findById(trainerDetails.getTrainerID())
                .orElseThrow(() -> new ResourceNotFoundException("Trainer not found for this id ::" + trainerDetails.getTrainerID()));
        trainer.setTrainerID(trainerDetails.getTrainerID());
        trainer.setName(trainerDetails.getName());
        trainer.setAge(trainerDetails.getAge());
        trainer.setGym(trainerDetails.getGym());
        trainer.setEmail(trainerDetails.getEmail());
        trainer.setPhotoFile(trainerDetails.getPhotoFile());
        final Trainer updatedTrainer = trainerRepository.save(trainer);
        return ResponseEntity.ok(updatedTrainer);
    }

    @DeleteMapping("/trainer/{trainerID}")
    public Map<String, Boolean> deleteTrainer(@PathVariable(value = "trainerID") Long trainerId)
            throws ResourceNotFoundException {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer not found for this id ::" + trainerId));
        trainerRepository.delete(trainer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
