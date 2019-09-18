package com.nullstdio.bbfc2020.modelClass;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Comparator;

public class Players_Informations {


    private String fullName;
    private String imagePath;
    private String jersyNumber;
    private String playerPosition;


    public Players_Informations() {
        // Empty constructor
    }


    public Players_Informations(String fullName , String imagePath, String jersyNumber, String playerPosition) {
        this.fullName = fullName;
        this.imagePath = imagePath;
        this.jersyNumber = jersyNumber;
        this.playerPosition = playerPosition;
    }

    public static final Comparator<Players_Informations> SORT_BY_Name = new Comparator<Players_Informations>() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public int compare(Players_Informations o1, Players_Informations o2) {

            return o1.fullName.compareTo(o2.fullName);

        }
    };


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
