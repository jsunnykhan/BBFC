package com.nullstdio.bbfc2020.FragmentAll;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.nullstdio.bbfc2020.R;

public class Fantasy extends Fragment {

    private Spinner spinner;

    private LinearLayout f1,f2,f3,m1,m2,m3,m4,m5,d1,d2,d3,d4,d5;


    String[] teamFormation = {"4-3-3","4-4-2","4-5-1","5-4-1","3-4-3","3-5-2","5-3-2"};



    public Fantasy() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_fantasy, container, false);


        //Forward layout
        f1 = (LinearLayout) view.findViewById(R.id.f1) ;
        f2 = (LinearLayout) view.findViewById(R.id.f2) ;
        f3 = (LinearLayout) view.findViewById(R.id.f3) ;
        //midfeilder Layout
        m1 = (LinearLayout) view.findViewById(R.id.m1) ;
        m2 = (LinearLayout) view.findViewById(R.id.m2) ;
        m3 = (LinearLayout) view.findViewById(R.id.m3) ;
        m4 = (LinearLayout) view.findViewById(R.id.m4) ;
        m5 = (LinearLayout) view.findViewById(R.id.m5) ;
        //defence layout
        d1 = (LinearLayout) view.findViewById(R.id.d1) ;
        d2 = (LinearLayout) view.findViewById(R.id.d2) ;
        d3 = (LinearLayout) view.findViewById(R.id.d3) ;
        d4 = (LinearLayout) view.findViewById(R.id.d4) ;
        d5 = (LinearLayout) view.findViewById(R.id.d5) ;

        spinner = view.findViewById(R.id.formationSp);
        ArrayAdapter adapter = new ArrayAdapter(getContext() , android.R.layout.simple_spinner_item,teamFormation );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (teamFormation[i]){
                    case "4-3-3":{
                        d1.setVisibility(View.VISIBLE);
                        d2.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.VISIBLE);
                        d4.setVisibility(View.VISIBLE);
                        d5.setVisibility(View.GONE);//gone

                        m1.setVisibility(View.GONE);//gone
                        m2.setVisibility(View.VISIBLE);
                        m3.setVisibility(View.VISIBLE);
                        m4.setVisibility(View.VISIBLE);
                        m5.setVisibility(View.GONE);//gone

                        f1.setVisibility(View.VISIBLE);
                        f2.setVisibility(View.VISIBLE);
                        f3.setVisibility(View.VISIBLE);

                        break;
                    }
                    case "4-4-2":{
                        d1.setVisibility(View.VISIBLE);
                        d2.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.VISIBLE);
                        d4.setVisibility(View.VISIBLE);
                        d5.setVisibility(View.GONE);//gone

                        m1.setVisibility(View.VISIBLE);
                        m2.setVisibility(View.VISIBLE);
                        m3.setVisibility(View.VISIBLE);
                        m4.setVisibility(View.VISIBLE);
                        m5.setVisibility(View.GONE);//gone

                        f1.setVisibility(View.VISIBLE);
                        f2.setVisibility(View.VISIBLE);
                        f3.setVisibility(View.GONE);//gone

                        break;
                    }
                    case "4-5-1":{
                        d1.setVisibility(View.VISIBLE);
                        d2.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.VISIBLE);
                        d4.setVisibility(View.VISIBLE);
                        d5.setVisibility(View.GONE);//gone

                        m1.setVisibility(View.VISIBLE);
                        m2.setVisibility(View.VISIBLE);
                        m3.setVisibility(View.VISIBLE);
                        m4.setVisibility(View.VISIBLE);
                        m5.setVisibility(View.VISIBLE);

                        f1.setVisibility(View.VISIBLE);
                        f2.setVisibility(View.GONE);//Gone
                        f3.setVisibility(View.GONE);//Gone

                        break;
                    }
                    case "5-4-1":{
                        d1.setVisibility(View.VISIBLE);
                        d2.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.VISIBLE);
                        d4.setVisibility(View.VISIBLE);
                        d5.setVisibility(View.VISIBLE);

                        m1.setVisibility(View.VISIBLE);
                        m2.setVisibility(View.VISIBLE);
                        m3.setVisibility(View.VISIBLE);
                        m4.setVisibility(View.VISIBLE);
                        m5.setVisibility(View.GONE);//gone

                        f1.setVisibility(View.VISIBLE);
                        f2.setVisibility(View.GONE);//gone
                        f3.setVisibility(View.GONE);//gone

                        break;
                    }
                    case "3-4-3":{
                        d1.setVisibility(View.GONE);//gone
                        d2.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.VISIBLE);
                        d4.setVisibility(View.VISIBLE);
                        d5.setVisibility(View.GONE);//gone

                        m1.setVisibility(View.VISIBLE);
                        m2.setVisibility(View.VISIBLE);
                        m3.setVisibility(View.VISIBLE);
                        m4.setVisibility(View.VISIBLE);
                        m5.setVisibility(View.GONE);//gone

                        f1.setVisibility(View.VISIBLE);
                        f2.setVisibility(View.VISIBLE);
                        f3.setVisibility(View.VISIBLE);

                        break;
                    }
                    case "3-5-2":{
                        d1.setVisibility(View.GONE);//gone
                        d2.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.VISIBLE);
                        d4.setVisibility(View.VISIBLE);
                        d5.setVisibility(View.GONE);//gone

                        m1.setVisibility(View.VISIBLE);
                        m2.setVisibility(View.VISIBLE);
                        m3.setVisibility(View.VISIBLE);
                        m4.setVisibility(View.VISIBLE);
                        m5.setVisibility(View.VISIBLE);

                        f1.setVisibility(View.VISIBLE);
                        f2.setVisibility(View.VISIBLE);
                        f3.setVisibility(View.GONE);//gone

                        break;
                    }
                    case "5-3-2":{
                        d1.setVisibility(View.VISIBLE);
                        d2.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.VISIBLE);
                        d4.setVisibility(View.VISIBLE);
                        d5.setVisibility(View.VISIBLE);

                        m1.setVisibility(View.GONE);//gone
                        m2.setVisibility(View.VISIBLE);
                        m3.setVisibility(View.VISIBLE);
                        m4.setVisibility(View.VISIBLE);
                        m5.setVisibility(View.GONE);//gone

                        f1.setVisibility(View.VISIBLE);
                        f2.setVisibility(View.VISIBLE);
                        f3.setVisibility(View.GONE);//gone

                        break;
                    }

                    default:{
                        Toast.makeText(getContext(), "server Fault", Toast.LENGTH_SHORT).show();
                        break;
                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return view;
    }

}
