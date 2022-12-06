package rw.ac.rca.smis.orm;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;
    private String name;

    private String street;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private Set<Student> students;

    //mapped by means the Address class will be foreign key in that table.
    //cascade type all means once one deleted we loose another one too
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private Set<Instructor> instructors;
    public  Address(){}
    public Address(String name , String street) {
        this.name = name;
        this.street = street;
    }
    public int getId() {
        return address_id;
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


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
