package finalProject.controller;


import finalProject.errors.ResourceNotFoundException;
import finalProject.models.Program;
import finalProject.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class ProgramController {

    @Autowired
    private ProgramRepository programRepository;

    @GetMapping("/program")
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    @GetMapping("/program/{programID}")
    public ResponseEntity<Program> findProgramById(@PathVariable(value ="programID")Long programId)
        throws ResourceNotFoundException {
        Program program = programRepository.findById(programId)
                .orElseThrow(() -> new ResourceNotFoundException("Program not found for this id::"+ programId));
        return ResponseEntity.ok().body(program);
    }

    @PostMapping("/program")
    public Program addProgram(@Valid @RequestBody Program program){
        programRepository.save(program);
        return program;
    }

    @PutMapping("/program")
    public ResponseEntity<Program> updateProgram(
                                                 @Valid @RequestBody Program programDetails)
        throws ResourceNotFoundException {
        Program program = programRepository.findById(programDetails.getProgramID())
                .orElseThrow(()-> new ResourceNotFoundException("Program not found for this id::"+ programDetails.getProgramID()));
        program.setProgramID(programDetails.getProgramID());
        program.setProgName(programDetails.getProgName());
        program.setCategory(programDetails.getCategory());
        program.setDescription(programDetails.getDescription());
        program.setTrainer(programDetails.getTrainer());
        final Program updatedProgram = programRepository.save(program);
        return ResponseEntity.ok(updatedProgram);
    }

    @DeleteMapping("/program/{programID}")
    public Map<String, Boolean> deleteProgram(@PathVariable(value ="programID") Long programID)
        throws ResourceNotFoundException {
        Program program = programRepository.findById(programID)
                .orElseThrow(()-> new ResourceNotFoundException("Program not found for this id::"+ programID));
        programRepository.delete(program);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
