package com.nullstdio.bbfc2020.modelClass;

public class TeamImager {

    private String teamName;
    private String imagePath;

    public TeamImager(String teamName, String imagePath) {
        this.teamName = teamName;
        this.imagePath = imagePath;
    }

    public TeamImager() {
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
