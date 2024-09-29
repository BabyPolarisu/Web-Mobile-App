package com.example.lab11_smooties.model;

public class Drink {
    private String drink_image;
    private String drink_name;
    private String drink_nutrient;
    private String detail;
    private int drink_price;

    public String getDrink_image() {
        return drink_image;
    }
    public void setDrink_image(String drink_image) {
        this.drink_image = drink_image;
    }

    public String getDrink_name() { return drink_name; }
    public void setDrink_name(String drink_name) {
        this.drink_name = drink_name;
    }

    public String getDrink_nutrient() {
        return drink_nutrient;
    }
    public void setDrink_nutrient(String drink_nutrient) {
        this.drink_nutrient = drink_nutrient;
    }

    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getDrink_price() {
        return drink_price;
    }
    public void setDrink_price(int drink_price) {
        this.drink_price = drink_price;
    }
}
