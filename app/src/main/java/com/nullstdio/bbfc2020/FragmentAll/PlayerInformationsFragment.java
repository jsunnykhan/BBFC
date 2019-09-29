package com.nullstdio.bbfc2020.FragmentAll;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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


        Bundle arg = getArguments();

        if (arg != null){

            String name = arg.getString("p_name");
            String jersy = arg.getString("p_jer");
            String positi = arg.getString("p_posi");
            String p_Image = arg.getString("p_playerImage");
            String p_TImage = arg.getString("p_teamImage");
            String p_Nname = arg.getString("p_Nname");

            playerName1.setText(name);
            playerName2.setText(name);
            jersy1.setText(jersy);
            jersy2.setText(jersy);
            positions.setText(positi);
            nickName.setText(p_Nname);

            try {
                Picasso.get().load(p_TImage).into(teamImage);
                Picasso.get().load(p_Image).into(playerImage);
            }catch (Exception e){

            }






        }




        return view;
    }

}
