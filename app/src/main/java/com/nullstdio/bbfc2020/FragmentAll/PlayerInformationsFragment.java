package com.nullstdio.bbfc2020.FragmentAll;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nullstdio.bbfc2020.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerInformationsFragment extends Fragment {

    private ImageView teamImage;
    private ImageView playerImage;

    public PlayerInformationsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_player_informations, container, false);

        teamImage = view.findViewById(R.id.teamImage);
        playerImage = view.findViewById(R.id.playerImage);


        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bbfc-37a18.appspot.com/o/team_icon%2F20190915_045803.png?alt=media&token=d386be45-6dbf-4f4f-b5f7-89880019f0fd")
                .into(teamImage);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/bbfc-37a18.appspot.com/o/players%2FpngPlayers%2Fsunnypng.png?alt=media&token=10bc1a23-9912-420a-9133-7de27425c8ac")
                .into(playerImage);

        return view;
    }

}
