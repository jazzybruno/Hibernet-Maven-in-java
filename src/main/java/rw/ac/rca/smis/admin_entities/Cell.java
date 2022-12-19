package rw.ac.rca.smis.admin_entities;

import javax.persistence.*;

@Entity
@Table(name = "cells")
public class Cell {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cell_id;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
    private String cellName;
    private int villages;

    public Cell(){

    }

    public Cell(Sector sector, District district, Province province, String cellName, int villages) {
        this.sector = sector;
        this.district = district;
        this.province = province;
        this.cellName = cellName;
        this.villages = villages;
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

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public int getVillages() {
        return villages;
    }

    public void setVillages(int villages) {
        this.villages = villages;
    }
}
