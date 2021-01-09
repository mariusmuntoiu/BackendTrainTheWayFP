package finalProject.models;

import javax.persistence.*;

@Entity
public class Program {
    @Id
    @GeneratedValue
    private long programID;

    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Program(long programID, String name, String category, String description, Trainer trainer) {
        this.programID = programID;
        this.name = name;
        this.category = category;
        this.description = description;
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return "Program{" +
                "programID=" + programID +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", trainer=" + trainer +
                '}';
    }


}



