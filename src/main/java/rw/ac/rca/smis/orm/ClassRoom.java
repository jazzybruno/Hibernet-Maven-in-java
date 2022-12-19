package rw.ac.rca.smis.orm;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class_room")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int class_id;
    private int capacity;
    private String className;
    private String schoolName;

    public int getCapacity() {
        return capacity;
    }

    public ClassRoom(int capacity , String className , String schoolName){
        this.capacity = capacity;
        this.className = className;
        this.schoolName = schoolName;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
