package com.example.starbucks.Domain;

import java.io.Serializable;

public class FoodDomain implements Serializable {

    private String title;
    private String description;
    private String pic;
    private Double precio;
    private double star;
    private int numberCart;


    public FoodDomain(String title, String pic, Double precio, double star) {
        this.title = title;
        this.pic = pic;
        this.precio = precio;
        this.star = star;
    }

    public FoodDomain(String title, String description, String pic, Double precio, double star) {
        this.title = title;
        this.description = description;
        this.pic = pic;
        this.precio = precio;
        this.star = star;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberCart() {
        return numberCart;
    }

    public void setNumberCart(int numberCart) {
        this.numberCart = numberCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }
}
