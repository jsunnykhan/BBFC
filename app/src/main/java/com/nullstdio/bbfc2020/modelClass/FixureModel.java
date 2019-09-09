package com.nullstdio.bbfc2020.modelClass;

public class FixureModel {

    private String Date;
    private String matchId;
    private boolean Ascore;
    private boolean Bscore;
    private String TeamAName;
    private String TeamBName;
    private String Time;
    private String scoreteamA ;
    private String scoreteamB ;

    public FixureModel() {
    }

    public FixureModel(String Date, String matchId, boolean Ascore,boolean Bscore, String TeamAName, String TeamBName, String Time,String scoreteamA ,String scoreteamB) {
        this.Date = Date;
        this.matchId = matchId;
        this.Ascore = Ascore;
        this.Bscore = Bscore;
        this.TeamAName = TeamAName;
        this.TeamBName = TeamBName;
        this.Time = Time;
        this.scoreteamA = scoreteamA;
        this.scoreteamB = scoreteamB;

    }

    public void setTeamAName(String teamAName) {
        TeamAName = teamAName;
    }

    public void setTeamBName(String teamBName) {
        TeamBName = teamBName;
    }

    public String getScoreteamA() {
        return scoreteamA;
    }

    public void setScoreteamA(String scoreteamA) {
        this.scoreteamA = scoreteamA;
    }

    public String getScoreteamB() {
        return scoreteamB;
    }

    public void setScoreteamB(String scoreteamB) {
        this.scoreteamB = scoreteamB;
    }

    public boolean isAscore() {
        return Ascore;
    }

    public void setAscore(boolean ascore) {
        Ascore = ascore;
    }

    public boolean isBscore() {
        return Bscore;
    }

    public void setBscore(boolean bscore) {
        Bscore = bscore;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }


    public String getTeamAName() {
        return TeamAName;
    }

    public void setTeamA(String teamAName) {
        TeamAName = teamAName;
    }

    public String getTeamBName() {
        return TeamBName;
    }

    public void setTeamB(String teamBName) {
        TeamBName = teamBName;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
