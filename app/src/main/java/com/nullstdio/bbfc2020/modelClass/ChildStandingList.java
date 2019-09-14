package com.nullstdio.bbfc2020.modelClass;

public class ChildStandingList {


    private String team_name;
    private String group;
    private int draw;
    private int loose;
    private int played;
    private int points;
    private int win;

    public ChildStandingList() {
    }

    public ChildStandingList(String team_name, String group, int draw, int loose, int played, int points, int win) {
        this.team_name = team_name;
        this.group = group;
        this.draw = draw;
        this.loose = loose;
        this.played = played;
        this.points = points;
        this.win = win;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLoose() {
        return loose;
    }

    public void setLoose(int loose) {
        this.loose = loose;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }


}
