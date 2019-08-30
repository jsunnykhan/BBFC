package com.nullstdio.bbfc2020.FragmentAll;


import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nullstdio.bbfc2020.R;

import static com.nullstdio.bbfc2020.R.color.gray;

public class FixtureFragment extends Fragment{

    private Button day1;
    private Button day2;
    private Button day3;

    private RecyclerView recyclerView ;
    private DatabaseReference ref1 ;
    private DatabaseReference ref2 ;
    private DatabaseReference ref3 ;

    public FixtureFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fixture, container, false);

        day1 = (Button) view.findViewById(R.id.day1);
        day2 = (Button) view.findViewById(R.id.day2);
        day3 = (Button) view.findViewById(R.id.day3);



        ref1 = FirebaseDatabase.getInstance().getReference().child("fixture").child("2019").child("day1");
        ref1.keepSynced(true);
        ref2 = FirebaseDatabase.getInstance().getReference().child("fixture").child("2019").child("day2");
        ref2.keepSynced(true);
        ref3 = FirebaseDatabase.getInstance().getReference().child("fixture").child("2019").child("day3");
        ref3.keepSynced(true);



        day1.setBackgroundDrawable(ContextCompat.getDrawable(getContext() , R.drawable.mark_button));
        collectData(ref1);




        day1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                day1.setBackgroundDrawable(ContextCompat.getDrawable(getContext() , R.drawable.mark_button));
                day2.setBackgroundDrawable(ContextCompat.getDrawable(getContext() , R.drawable.fixuter_button_design));
                day3.setBackgroundDrawable(ContextCompat.getDrawable(getContext() , R.drawable.fixuter_button_design));
                collectData(ref1);
            }
        });
day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day2.setBackgroundDrawable(ContextCompat.getDrawable(getContext() , R.drawable.mark_button));
                day1.setBackgroundDrawable(ContextCompat.getDrawable(getContext() , R.drawable.fixuter_button_design));
                day3.setBackgroundDrawable(ContextCompat.getDrawable(getContext() , R.drawable.fixuter_button_design));
                collectData(ref2);
            }
        });
day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day3.setBackgroundDrawable(ContextCompat.getDrawable(getContext() , R.drawable.mark_button));
                day2.setBackgroundDrawable(ContextCompat.getDrawable(getContext() , R.drawable.fixuter_button_design));
                day1.setBackgroundDrawable(ContextCompat.getDrawable(getContext() , R.drawable.fixuter_button_design));
                collectData(ref3);
            }
        });




        return view;
    }

    private void collectData(DatabaseReference ref) {

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
