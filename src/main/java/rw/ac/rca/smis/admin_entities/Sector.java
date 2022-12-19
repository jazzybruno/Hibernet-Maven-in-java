package rw.ac.rca.smis.admin_entities;

import javax.persistence.*;

@Entity
@Table(name = "sectors")
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sector_id;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;
    private String sectorName;
    private int cells;

    public Sector(){

    }

    public Sector(Province province, District district, String sectorName, int cells) {
        this.province = province;
        this.district = district;
        this.sectorName = sectorName;
        this.cells = cells;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public int getCells() {
        return cells;
    }

    public void setCells(int cells) {
        this.cells = cells;
    }
}
