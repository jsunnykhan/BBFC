package com.nullstdio.bbfc2020.modelClass;

import java.util.List;

public class PlayesCatagories {

    String catagories ;
    List<Players_Informations> lists;

    public PlayesCatagories(String catagories, List<Players_Informations> lists) {
        this.catagories = catagories;
        this.lists = lists;
    }

    public PlayesCatagories() {
    }

    public String getCatagories() {
        return catagories;
    }

    public void setCatagories(String catagories) {
        this.catagories = catagories;
    }

    public List<Players_Informations> getLists() {
        return lists;
    }

    public void setLists(List<Players_Informations> lists) {
        this.lists = lists;
    }
}
