package rw.ac.rca.smis;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date dob;
    private char gender;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private List<Course> courses;
    public int getId() {
        return id;
    }

    public Instructor(){}
    public Instructor(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Date getDob() {
        return dob;
    }

    public char getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

    public List<Course> getCourses() {
        return courses;
    }

}
