package org.example;

public class Shoe {
    private static int id=0;
    private int shoeId;

    private String name;

    private double price;
    private String genre;

    public Shoe(String name, double price, String genre) {
        this.shoeId = ++id;
        this.name = name;
        this.price = price;
        this.genre = genre;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Shoe.id = id;
    }

    public int getShoeId() {
        return shoeId;
    }

    public void setShoeId(int shoeId) {
        this.shoeId = shoeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}