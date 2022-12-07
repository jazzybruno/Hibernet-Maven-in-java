package rw.ac.rca.smis.orm;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "instructor")
public class Instructor extends Person {
    private char gender;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany( cascade = CascadeType.ALL , mappedBy = "instructor")
    private List<Course> courses;

    public Instructor(){}


    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }


    public char getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

//    public List<Course> getCourses() {
//        return courses;
//    }

}
