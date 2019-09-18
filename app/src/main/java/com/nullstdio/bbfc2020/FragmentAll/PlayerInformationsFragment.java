package com.nullstdio.bbfc2020.FragmentAll;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nullstdio.bbfc2020.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerInformationsFragment extends Fragment {

    private ImageView teamImage;
    private ImageView playerImage;
    private TextView jersy1;
    private TextView jersy2;
    private TextView playerName1;
    private TextView playerName2;
    private TextView nickName;
    private TextView yellow;
    private TextView red;
    private TextView positions;
    private TextView goals;
    private TextView assist;


    public PlayerInformationsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_player_informations, container, false);

        teamImage = view.findViewById(R.id.teamImage);
        playerImage = view.findViewById(R.id.playerImage);
        playerName1 = view.findViewById(R.id.playerName1);
        playerName2 = view.findViewById(R.id.fullName);
        jersy1 = view.findViewById(R.id.jersey1);
        jersy2 = view.findViewById(R.id.jersey2);
        nickName = view.findViewById(R.id.nickName);
        positions = view.findViewById(R.id.playerPosition);
        goals = view.findViewById(R.id.playerGoals);
        assist = view.findViewById(R.id.playerAssist);
        yellow = view.findViewById(R.id.yelloCard);
        red = view.findViewById(R.id.redCard);


        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bbfc-37a18.appspot.com/o/team_icon%2F20190915_045803.png?alt=media&token=d386be45-6dbf-4f4f-b5f7-89880019f0fd")
                .into(teamImage);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bbfc-37a18.appspot.com/o/players%2FpngPlayers%2Fsunnypng.png?alt=media&token=10bc1a23-9912-420a-9133-7de27425c8ac")
                .into(playerImage);

        return view;
    }

}
