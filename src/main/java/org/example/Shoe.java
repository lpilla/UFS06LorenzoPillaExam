package org.example;

public class Car {
    private int id;
    private String brand;
    private double price;
    private double km;


    public Car(int id, String brand, double price, double km) {
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.km = km;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }
}
