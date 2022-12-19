package rw.ac.rca.smis.admin_entities;

import javax.persistence.*;

@Entity
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int district_id;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
    private String district_name;
    private int sectors;

    public District(){

    }


    public District( Province province, String district_name, int sectors) {
        this.province = province;
        this.district_name = district_name;
        this.sectors = sectors;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public int getSectors() {
        return sectors;
    }

    public void setSectors(int sectors) {
        this.sectors = sectors;
    }
}
