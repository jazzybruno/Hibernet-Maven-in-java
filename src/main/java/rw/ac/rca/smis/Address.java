package rw.ac.rca.smis;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Address")
    private Set<Student> students;

    //mapped by means the Address class will be foreign key in that table.
    //cascade type all means once one deleted we loose another one too
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Address")
    private Set<Instructor> instructors;
    public  Address(){}
    public Address(int id, String name) {
        this.address_id = id;
        this.name = name;
    }
    public int getId() {
        return address_id;
    }
    public void setStudent(Set<Student> students) {
        this.students = students;
    }

    public void setId(int id) {
        this.address_id = id;
    }

    public Set<Student> getStudent() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }



}
