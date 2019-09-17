package com.nullstdio.bbfc2020.Sessions;

import android.content.Context;
import android.content.SharedPreferences;

public class TeamNameSession {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private static final String Tag = TeamNameSession.class.getSimpleName();
    private static final String Name = "teams";

    Context context;

    private static  final String KEY_IS_TEAMNAME ="name";


    public TeamNameSession(Context context){
        this.context = context ;
        sharedPreferences = context.getSharedPreferences(Name , Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    public void setTeamName(String teamName){
        editor.putString(KEY_IS_TEAMNAME,teamName);
        editor.commit();
    }

    public  String getTeamName() {
        return sharedPreferences.getString(KEY_IS_TEAMNAME , null);
    }
}
