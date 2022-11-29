package rw.ac.rca.smis;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "Student")
public class Student {
    private int student_id;
    private String studentName;
    private ClassRoom classRoom;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Address address;
    public  Student(){}
    public Student(int id, String studentName, Address address, ClassRoom classRoom, List<Course> courses) {
        this.student_id = id;
        this.studentName = studentName;
        this.address = address;
        this.classRoom = classRoom;
        this.courses = courses;
    }
    public int getId() {
        return student_id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setId(int id) {
        this.student_id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Address getAddress() {
        return address;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public List<Course> getCourses() {
        return courses;
    }



    private List<Course> courses;

}
