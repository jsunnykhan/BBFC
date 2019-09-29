package com.nullstdio.bbfc2020.FragmentAll;


import android.app.ActionBar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nullstdio.bbfc2020.Activitys.MainActivity;
import com.nullstdio.bbfc2020.Activitys.MainMainActivity;
import com.nullstdio.bbfc2020.Adapters.PlayersAdapter;
import com.nullstdio.bbfc2020.Adapters.PlayersCatagoriesAdapter;
import com.nullstdio.bbfc2020.Adapters.TeamInformationAdapter;
import com.nullstdio.bbfc2020.R;
import com.nullstdio.bbfc2020.modelClass.Players_Informations;
import com.nullstdio.bbfc2020.modelClass.PlayesCatagories;
import com.nullstdio.bbfc2020.modelClass.TeamImager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamFragment extends Fragment  {

    private RecyclerView teamPhoto;
    private RecyclerView playerrecycler;

    DatabaseReference teamRef ;

    String[] pos = {"GoalKeeper" , "Defender" , "Midfielder" , "Forward" , "Manager"};


    String teamName;
    String imagePath;

    public TeamFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_team, container, false);


        teamPhoto = view.findViewById(R.id.teamRecycler);
        playerrecycler = view.findViewById(R.id.playerRecicler);



        teamRef = FirebaseDatabase.getInstance().getReference("teams");

        teamPhoto.setHasFixedSize(true);
        teamPhoto.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false));


        playerrecycler.setHasFixedSize(true);
        playerrecycler.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.VERTICAL , false));


        teamRef.orderByChild("team_order").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final List<TeamImager> list = new ArrayList<>();
                if (dataSnapshot.exists()){
                    for (DataSnapshot teamdata : dataSnapshot.getChildren()){
                         teamName= teamdata.child("team_name").getValue().toString();
                         imagePath = teamdata.child("team images").child("download").getValue().toString();

                        TeamImager teamDetails = new TeamImager(teamName , imagePath);
                        list.add(teamDetails);
                    }
                    TeamInformationAdapter adapter = new TeamInformationAdapter(getContext() , list);
                    teamPhoto.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mreciver, new IntentFilter("team_Name"));


        return view;
    }


    public BroadcastReceiver mreciver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
             String name = intent.getStringExtra("teamName");
             final String image = intent.getStringExtra("teamimage");



            //for defenders
            DatabaseReference refplayes = FirebaseDatabase.getInstance().getReference("playerList");

            try {


                refplayes.orderByChild("teamName").equalTo(name).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        final List<PlayesCatagories> finalList = new ArrayList<>();
                        List<Players_Informations> manager = new ArrayList<>();
                        List<Players_Informations> gk = new ArrayList<>();
                        List<Players_Informations> def = new ArrayList<>();
                        List<Players_Informations> mid = new ArrayList<>();
                        List<Players_Informations> forw = new ArrayList<>();
                        if (dataSnapshot.exists()) {

                            for (DataSnapshot data : dataSnapshot.getChildren()) {

                                String name = data.child("fullName").getValue().toString();
                                String positions = data.child("playerPosition").getValue().toString();
                                String image = data.child("images").child("round_image").getValue().toString();
                                String imageFlat = data.child("images").child("imagePath").getValue().toString();
                                String jersey = data.child("jersyNumber").getValue().toString();
                                String Nname = data.child("nickName").getValue().toString();

                                if (data.child("playerPosition").getValue().toString().equalsIgnoreCase(pos[0])) {
                                    Players_Informations ob = new Players_Informations(name, image, jersey, positions, imageFlat , Nname);
                                    gk.add(ob);
                                } else if (data.child("playerPosition").getValue().toString().equalsIgnoreCase(pos[1])) {
                                    Players_Informations ob1 = new Players_Informations(name, image, jersey, positions, imageFlat , Nname);
                                    def.add(ob1);
                                } else if (data.child("playerPosition").getValue().toString().equalsIgnoreCase(pos[2])) {
                                    Players_Informations ob2 = new Players_Informations(name, image, jersey, positions, imageFlat , Nname);
                                    mid.add(ob2);
                                } else if (data.child("playerPosition").getValue().toString().equalsIgnoreCase(pos[3])) {
                                    Players_Informations ob3 = new Players_Informations(name, image, jersey, positions, imageFlat , Nname);
                                    forw.add(ob3);
                                } else if (data.child("playerPosition").getValue().toString().equalsIgnoreCase(pos[4])) {
                                    Players_Informations ob4 = new Players_Informations(name, image, jersey, positions, imageFlat , Nname);
                                    manager.add(ob4);
                                }

                            }
                            Collections.sort(gk, Players_Informations.SORT_BY_Name);
                            Collections.sort(def, Players_Informations.SORT_BY_Name);
                            Collections.sort(mid, Players_Informations.SORT_BY_Name);
                            Collections.sort(forw, Players_Informations.SORT_BY_Name);
                            Collections.sort(manager, Players_Informations.SORT_BY_Name);

                            //
                            //
                            // database forloop end here

                            for (int i = 0; i < 5; i++) {
                                if (i == 0) {
                                    PlayesCatagories d = new PlayesCatagories(pos[i], gk);
                                    finalList.add(d);
                                } else if (i == 1) {
                                    PlayesCatagories d1 = new PlayesCatagories(pos[i], def);
                                    finalList.add(d1);
                                } else if (i == 2) {
                                    PlayesCatagories d2 = new PlayesCatagories(pos[i], mid);
                                    finalList.add(d2);
                                } else if (i == 3) {
                                    PlayesCatagories d3 = new PlayesCatagories(pos[i], forw);
                                    finalList.add(d3);
                                } else if (i == 4) {
                                    PlayesCatagories d4 = new PlayesCatagories(pos[i], manager);
                                    finalList.add(d4);
                                }
                            }

                            PlayersCatagoriesAdapter adapter = new PlayersCatagoriesAdapter(getContext(), finalList, image);
                            adapter.notifyDataSetChanged();
                            playerrecycler.setAdapter(adapter);
                        } else {
                            Toast.makeText(getContext(), "NoData Found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getContext(), databaseError + "", Toast.LENGTH_SHORT).show();
                    }
                });

            }catch (Exception e ){
                Log.d("players" , e+"");
            }
        }

    };





}
