package com.nullstdio.bbfc2020.FragmentAll;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nullstdio.bbfc2020.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerInformationsFragment extends Fragment {


    public PlayerInformationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player_informations, container, false);
    }

}