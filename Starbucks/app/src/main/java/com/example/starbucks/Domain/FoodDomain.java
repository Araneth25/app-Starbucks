package com.example.starbucks.Domain;

public class FoodDomain {

    private String title;
    private String pic;
    private Double precio;
    private double star;

    public FoodDomain(String title, String pic, Double precio, double star) {
        this.title = title;
        this.pic = pic;
        this.precio = precio;
        this.star = star;
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
