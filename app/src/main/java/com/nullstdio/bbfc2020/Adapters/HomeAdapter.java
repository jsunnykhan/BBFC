package com.nullstdio.bbfc2020.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nullstdio.bbfc2020.R;
import com.nullstdio.bbfc2020.modelClass.HomeModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Holder> {


     Context context;
     ArrayList<HomeModel> homeModels ;

    public HomeAdapter(Context context, ArrayList<HomeModel> homeModels) {
        this.context = context;
        this.homeModels = homeModels;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dashboard_layout , parent , false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.textView.setText(homeModels.get(position).getTitle());
        String path = homeModels.get(position).getImage_path();

        Toast.makeText(context, path, Toast.LENGTH_LONG).show();
        Picasso.get().
                load(path).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return homeModels.size() ;
    }


    class Holder extends RecyclerView.ViewHolder {


        ImageView imageView ;
        TextView textView ;
        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.dash_iv);
            textView = itemView.findViewById(R.id.dash_tv);
        }
    }

}
