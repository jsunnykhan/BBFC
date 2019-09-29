package com.nullstdio.bbfc2020.modelClass;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Comparator;

public class Players_Informations {


    private String fullName;
    private String imagePath;
    private String jersyNumber;
    private String playerPosition;
    private String imageFlat;
    private String  Nname;


    public Players_Informations() {
        // Empty constructor
    }


    public Players_Informations(String fullName , String imagePath, String jersyNumber, String playerPosition , String imageFlat ,String Nname) {
        this.fullName = fullName;
        this.imagePath = imagePath;
        this.jersyNumber = jersyNumber;
        this.playerPosition = playerPosition;
        this.imageFlat = imageFlat;
        this.Nname = Nname;
    }

    public static final Comparator<Players_Informations> SORT_BY_Name = new Comparator<Players_Informations>() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public int compare(Players_Informations o1, Players_Informations o2) {

            return o1.fullName.compareTo(o2.fullName);

        }
    };

    public String getNname() {
        return Nname;
    }

    public void setNname(String nname) {
        Nname = nname;
    }

    public String getImageFlat() {
        return imageFlat;
    }

    public void setImageFlat(String imageFlat) {
        this.imageFlat = imageFlat;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getJersyNumber() {
        return jersyNumber;
    }

    public void setJersyNumber(String jersyNumber) {
        this.jersyNumber = jersyNumber;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }
}
