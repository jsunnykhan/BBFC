package com.nullstdio.bbfc2020.FragmentAll;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nullstdio.bbfc2020.R;

public class HistoryFragment extends Fragment {

    private Button b1;

    private Fragment fixture;
    public HistoryFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history, container, false);

        b1 = view.findViewById(R.id.clickButton);
        fixture = new PlayerInformationsFragment();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainer , fixture);
                transaction.commit();



            }

        });


        return view;
    }

}
