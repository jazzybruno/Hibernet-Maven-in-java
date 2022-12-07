package rw.ac.rca.smis.orm;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "student")
public class Student extends Person {


    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany( cascade = CascadeType.ALL , mappedBy = "student")
    private List<Course> courses;

    public  Student(){}




    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Address getAddress() {
        return address;
    }



    public List<Course> getCourses() {
        return courses;
    }





}
