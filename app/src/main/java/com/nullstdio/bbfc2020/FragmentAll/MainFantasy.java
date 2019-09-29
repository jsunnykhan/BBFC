package com.nullstdio.bbfc2020.FragmentAll;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nullstdio.bbfc2020.FantasyFragment.Fantasy;
import com.nullstdio.bbfc2020.FantasyFragment.PointTable;
import com.nullstdio.bbfc2020.FantasyFragment.Rules;
import com.nullstdio.bbfc2020.FantasyFragment.SignInMember;
import com.nullstdio.bbfc2020.FantasyFragment.SignUpMember;
import com.nullstdio.bbfc2020.FantasyFragment.StatisticsFantasy;
import com.nullstdio.bbfc2020.R;
import com.nullstdio.bbfc2020.Sessions.FantasyMember;

public class MainFantasy extends Fragment implements View.OnClickListener {

    private TextView scoretxt;
    private TextView moneytxt;

    private Button points;
    private Button statistic;
    private Button pickTeam;
    private Button rules;
    private Button signIn;
    private Button signUp;
    LinearLayout ab;
    CardView note;
    FantasyMember member;

    DatabaseReference reference;


    public MainFantasy() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_fantasy, container, false);


        reference = FirebaseDatabase.getInstance().getReference().child("fantasy_member");

        ab = view.findViewById(R.id.fantasyscore);
        note = view.findViewById(R.id.signUpNote);

        member = new FantasyMember(getContext());

        if (member.getKeyIsUserloggedin()){
            ab.setVisibility(View.VISIBLE);
            note.setVisibility(View.GONE);

        }



        scoretxt = view.findViewById(R.id.scoreNum);
        moneytxt = view.findViewById(R.id.moneyNum);

        points = view.findViewById(R.id.pointTable);
        statistic = view.findViewById(R.id.statisticFantasy);
        rules = view.findViewById(R.id.rules);
        pickTeam = view.findViewById(R.id.pickTeam);
        signIn = view.findViewById(R.id.signin);
        signUp = view.findViewById(R.id.signup);

        points.setOnClickListener(this);
        statistic.setOnClickListener(this);
        pickTeam.setOnClickListener(this);
        rules.setOnClickListener(this);
        signIn.setOnClickListener(this);
        signUp.setOnClickListener(this);

        return view;
    }

    public void fragmentCall(Fragment fragment){
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.addToBackStack("Fragment tag");
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signin:{
                Fragment sign = new SignInMember();
                fragmentCall(sign);
                break;
            }
            case R.id.signup:{
                Fragment signu = new SignUpMember();
                fragmentCall(signu);
                break;
            }
            case R.id.pointTable:{
                Fragment points = new PointTable();
                fragmentCall(points);
                break;
            }
            case R.id.statisticFantasy:{
                Fragment statistics = new StatisticsFantasy();
                fragmentCall(statistics);
                break;
            }
            case R.id.rules:{
                Fragment rules = new Rules();
                fragmentCall(rules);
                break;
            }
            case R.id.pickTeam:{
                if (member.getKeyIsUserloggedin()==false) {
                    Fragment fantasy = new Fantasy();
                    fragmentCall(fantasy);
                }else {
                    Fragment sign = new SignInMember();
                    fragmentCall(sign);
                }
                break;
            }

        }
    }
}
