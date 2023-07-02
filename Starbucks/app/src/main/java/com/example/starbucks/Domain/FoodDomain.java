package com.example.starbucks.Domain;

public class FoodDomain {

    private String title;
    private String pic;
    private Double star;

    public FoodDomain(String title, String pic, Double star) {
        this.title = title;
        this.pic = pic;
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

    public Double getStar() {
        return star;
    }

    public void setStar(Double star) {
        this.star = star;
    }
}
