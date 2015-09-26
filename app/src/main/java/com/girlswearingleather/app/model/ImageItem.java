package com.girlswearingleather.app.model;

/**
 * Created by Dani on 26/09/2015.
 */
public class ImageItem {
    private int id;
    private String small;
    private String medium;
    private String large;

    public ImageItem(int id, String small, String medium, String large){
        this.id = id;
        this.small = small;
        this.medium =medium;
        this.large = large;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
