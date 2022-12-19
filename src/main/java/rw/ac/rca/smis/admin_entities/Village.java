package rw.ac.rca.smis.admin_entities;

import javax.persistence.*;

@Entity
@Table(name = "villages")
public class Village {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int village_id;

    @ManyToOne
    @JoinColumn(name = "cell_id")
    private Cell cell;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
    private String villageName;

    public Village(){

    }

    public Village(Cell cell, Sector sector, District district, Province province, String villageName) {
        this.cell = cell;
        this.sector = sector;
        this.district = district;
        this.province = province;
        this.villageName = villageName;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
}
