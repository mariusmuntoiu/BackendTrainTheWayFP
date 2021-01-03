package finalProject.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long trainerID;

    private String name;
    private String gym;
    private String email;
    private long age;


    protected Trainer() {
    }

    public Trainer(long trainerID,
                   String name,
                   String gym,
                   String email,
                   long age) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.trainerID = trainerID;
        this.gym = gym;

    }



    public long getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(long trainerID) {
        this.trainerID = trainerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainerID=" + trainerID +
                ", name='" + name + '\'' +
                ", gym='" + gym + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

}





