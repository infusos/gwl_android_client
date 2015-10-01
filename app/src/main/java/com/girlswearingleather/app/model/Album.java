package com.girlswearingleather.app.model;

/**
 * Created by Dani on 19/09/2015.
 */
public class Album{

    private int id;
    private int pictures;
    private String thumbnail;
    private String name;
    private String description;

    public Album(){

    }

    public Album(int id, int pictures, String thumbnail, String name, String description){
        this.id = id;
        this.pictures = pictures;
        this.thumbnail = thumbnail;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPictures() {
        return pictures;
    }

    public void setPictures(int pictures) {
        this.pictures = pictures;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
