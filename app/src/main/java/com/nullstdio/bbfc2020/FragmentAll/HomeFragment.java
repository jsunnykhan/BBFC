package com.nullstdio.bbfc2020.FragmentAll;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.nullstdio.bbfc2020.Adapters.HomeAdapter;
import com.nullstdio.bbfc2020.R;
import com.nullstdio.bbfc2020.modelClass.HomeModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {


    private RecyclerView recyclerView ;
    private DatabaseReference reference ;
    ArrayList<HomeModel> list ;
    HomeAdapter adapter ;


    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.homeRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("home");


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        reference.addValueEventListener(new ValueEventListener() {

            DatabaseReference ref = reference.push();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list = new ArrayList<HomeModel>();

                if (dataSnapshot.exists()){
                    for (DataSnapshot data : dataSnapshot.getChildren()){

                        HomeModel re = data.getValue(HomeModel.class);
                        list.add(re);
                    }


                    adapter = new HomeAdapter(getContext() , list);
                    recyclerView.setAdapter(adapter);
                }else {
                    Toast.makeText(getContext(), "No Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        return view;
    }

}
