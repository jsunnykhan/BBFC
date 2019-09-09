package com.nullstdio.bbfc2020.modelClass;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DatabasePlayerAndScore {

    String playername;
    String matchId;
    String teamName;
    Context context;
    int score = 0;




    public DatabasePlayerAndScore(Context context , String matchId, String teamName) {
        this.matchId = matchId;
        this.teamName = teamName;
        this.context = context ;

        dataretrive();

    }

    public int dataretrive(){

        DatabaseReference scoreref = FirebaseDatabase.getInstance().getReference().child("fixture");

        DatabaseReference rek = scoreref.child("2019").child("Day 1").child("-Lmpdw7kWXh5EtxYZfrG").child("Anirban 11").child("Score");
        rek.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             score = (int) dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return score;
    }
}
