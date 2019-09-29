package com.nullstdio.bbfc2020.Sessions;

import android.content.Context;
import android.content.SharedPreferences;

public class FantasyMember {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private static final String Tag = TeamNameSession.class.getSimpleName();
    private static final String Name = "userName";

    Context context;

    private static  final String KEY_IS_USERLOGGEDIN ="user";

    public FantasyMember(Context context){
        this.context = context ;
        sharedPreferences = context.getSharedPreferences(Name , Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setuserLogged(boolean user){
        editor.putBoolean(KEY_IS_USERLOGGEDIN,user);
        editor.commit();
    }

    public  boolean getKeyIsUserloggedin() {
        return sharedPreferences.getBoolean(KEY_IS_USERLOGGEDIN , false);
    }
}
