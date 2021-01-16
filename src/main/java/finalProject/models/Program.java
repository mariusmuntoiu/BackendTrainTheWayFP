package finalProject.models;

import javax.persistence.*;

@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long programID;

    private String progName;
    private String category;
    private String description;
    @ManyToOne
    @JoinColumn(name ="trainerID")
    private Trainer trainer;

    public Program() {


    }

    public long getProgramID() {
        return programID;
    }

    public void setProgramID(long programID) {
        this.programID = programID;
    }

    public String getProgName() {
        return progName;
    }

    public void setProgName(String name) {
        this.progName = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Program(long programID, String progName, String category, String description, Trainer trainer) {
        this.programID = programID;
        this.progName = progName;
        this.category = category;
        this.description = description;
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return "Program{" +
                "programID=" + programID +
                ", name='" + progName + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", trainer=" + trainer +
                '}';
    }


}



