package com.example.testapp;

public class FoodItem {

    private String name;
    private String thumbnail;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public FoodItem(){

    }

    public FoodItem(String name,String thumbnail){
        this.name = name;
        this.thumbnail = thumbnail;
    }


}
