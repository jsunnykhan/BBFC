package com.nullstdio.bbfc2020.modelClass;

public class HomeModel {

     String title ;
     String image_path;

    public HomeModel() {
    }

    public HomeModel(String image_path, String title) {
        this.title = title;
        this.image_path = image_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}
