package com.nullstdio.bbfc2020.FragmentAll;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nullstdio.bbfc2020.Activitys.MainActivity;
import com.nullstdio.bbfc2020.Adapters.ParentStandingAdapter;
import com.nullstdio.bbfc2020.R;
import com.nullstdio.bbfc2020.modelClass.ChildStandingList;
import com.nullstdio.bbfc2020.modelClass.ParentsStandingList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandingFragment extends Fragment {

    RecyclerView recyclerView;

    DatabaseReference ref ;

    TextView textView;

    public StandingFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_standing, container, false);

        textView = view.findViewById(R.id.dataUpdate);

        recyclerView = view.findViewById(R.id.statsRecycler);
        ref = FirebaseDatabase.getInstance().getReference().child("_groups");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    final List<ParentsStandingList> parents = new ArrayList<>();
                    for (DataSnapshot  parentsData: dataSnapshot.getChildren()){

                        final String key =  parentsData.getKey().toString();
                        final String groupName =  parentsData.child("groupName").getValue().toString();
                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("_groups").child(key).child("groupChild");
                        reference.orderByChild("points").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                if (dataSnapshot.exists()){
                                    textView.setVisibility(View.GONE);

                                    final List<ChildStandingList> child = new ArrayList<ChildStandingList>();
                                    for (DataSnapshot childData : dataSnapshot.getChildren()){
                                        ChildStandingList itemData = childData.getValue(ChildStandingList.class);
                                        child.add(itemData);
                                    }
                                    Collections.reverse(child);
                                    parents.add(new ParentsStandingList(groupName ,  child));

                                    ParentStandingAdapter adapter = new ParentStandingAdapter(getContext() , parents);
                                    recyclerView.setAdapter(adapter);
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                }else{
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Groups Are not fix yet");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







        return view;
    }

}
