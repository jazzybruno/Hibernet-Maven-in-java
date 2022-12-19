package rw.ac.rca.smis.admin_entities;

import javax.persistence.*;

@Entity
@Table(name = "provinces")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int province_id;
    private String province_name;
    private int districts;

    public Province(){

    }

    public Province(String province_name , int districts){
        this.province_name = province_name;
        this.districts = districts;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public int getDistricts() {
        return districts;
    }

    public void setDistricts(int districts) {
        this.districts = districts;
    }
}
