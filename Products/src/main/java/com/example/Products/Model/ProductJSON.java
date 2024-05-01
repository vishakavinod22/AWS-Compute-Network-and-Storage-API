package com.example.Products.Model;

import java.util.List;

public class ProductJSON {
    private String name;
    private String price;
    private boolean availability;

    public ProductJSON() {
    }

    public ProductJSON(String name, String price, boolean availability) {
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

}
