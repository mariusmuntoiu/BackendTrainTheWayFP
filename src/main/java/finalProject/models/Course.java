package finalProject.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long courseId;
    private String csName;
    private Date csDate;
    private String details;
    @ManyToMany
    @JsonIgnoreProperties("courses")
    @JoinTable(
            name = "trainer_list",
            joinColumns = @JoinColumn(name ="course_id", referencedColumnName = "courseid"),
            inverseJoinColumns = @JoinColumn(name ="trainer_id", referencedColumnName = "trainerid")
    )
    private Set<Trainer> trainerLs = new HashSet<>();

    public Course(){

    }

    public Course(long courseId, String csName, Date csDate, String details, Set<Trainer> trainerLs) {
        this.courseId = courseId;
        this.csName = csName;
        this.csDate = csDate;
        this.details = details;
        this.trainerLs = trainerLs;
    }

    public Course(String csName) {
        this.csName = csName;
    }

    public void trainerLs(Trainer trainer) {
        trainerLs.add(trainer);
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCsName() {
        return csName;
    }

    public void setCsName(String csName) {
        this.csName = csName;
    }

    public Date getCsDate() {
        return csDate;
    }

    public void setCsDate(Date csDate) {
        this.csDate = csDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Set<Trainer> getTrainerLs() {
        return trainerLs;
    }

    public void setTrainerLs(Set<Trainer> trainerLs) {
        this.trainerLs = trainerLs;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", csName='" + csName + '\'' +
                ", csDate=" + csDate +
                ", details='" + details + '\'' +
                ", trainerLs=" + trainerLs +
                '}';
    }
}
