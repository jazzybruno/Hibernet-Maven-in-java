package rw.ac.rca.smis.orm;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;
    private String studentName;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

//    private List<Course> courses;
    public  Student(){}
    public Student( String studentName) {
        this.studentName = studentName;
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

//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }

    public Address getAddress() {
        return address;
    }



//    public List<Course> getCourses() {
//        return courses;
//    }





}
