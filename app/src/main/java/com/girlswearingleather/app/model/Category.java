package com.girlswearingleather.app.model;

/**
 * Created by Dani on 19/09/2015.
 */
public class Category{

    private String name;
    private int image;

    public Category(String name, int image){
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
