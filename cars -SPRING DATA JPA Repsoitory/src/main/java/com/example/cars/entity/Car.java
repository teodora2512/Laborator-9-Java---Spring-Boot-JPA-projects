package com.example.cars.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="masini")
public class Car {

    @Id
    @Column(name="license_plate", nullable=false, unique=true, length=20)
    private String licensePlate;

    @Column(name="brand", nullable=false, length=50)
    private String brand;

    @Column(name="an_fabricatie", nullable=false)
    private Integer anFabricatie;

    @Column(name="culoare", length = 30)
    private String culoare;

    @Column(name="nr_km",nullable = false)
    private Integer nrKm;

    public Car(String licensePlate, String brand, Integer anFabricatie, String culoare, Integer nrKm) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.anFabricatie = anFabricatie;
        this.culoare = culoare;
        this.nrKm = nrKm;
    }

    public Car() {
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(Integer anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public Integer getNrKm() {
        return nrKm;
    }

    public void setNrKm(Integer nrKm) {
        this.nrKm = nrKm;
    }

    @Override
    public String toString() {
        return licensePlate +" "+
                brand+" "+
                anFabricatie+" "+
                culoare+" "+
                nrKm;
    }
}
