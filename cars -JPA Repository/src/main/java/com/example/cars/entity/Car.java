package com.example.cars.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="masini")
public class Car {

    @Id
    private String licensePlate;
    private String brand;
    private Integer anFabricatie;
    private String culoare;
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

    @Override
    public String toString() {
        return licensePlate + " " +
                brand + " " +
                anFabricatie + " " +
                culoare + " " +
                nrKm;
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
}
