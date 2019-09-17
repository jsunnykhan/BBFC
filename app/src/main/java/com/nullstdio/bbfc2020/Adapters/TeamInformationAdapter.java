package com.nullstdio.bbfc2020.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.nullstdio.bbfc2020.Interface.OnNoteListener;
import com.nullstdio.bbfc2020.R;
import com.nullstdio.bbfc2020.modelClass.TeamImager;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamInformationAdapter extends RecyclerView.Adapter<TeamInformationAdapter.myTeamViewHolder> {

    private Context context;
    private List<TeamImager> itemData;

    String name;


    public TeamInformationAdapter(Context context, List<TeamImager> itemData) {
        this.context = context;
        this.itemData = itemData;
    }

    @NonNull
    @Override
    public myTeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.teamimage_name , parent , false);
        return new myTeamViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myTeamViewHolder holder, int position) {

        String imagepath = itemData.get(position).getImagePath();
        Picasso.get().
                load(imagepath).into(holder.imageView);


        holder.setOnNoteListener(new OnNoteListener() {
            @Override
            public void onNoteClick(View view, int position) {
                name = itemData.get(position).getTeamName() ;
                Intent intent = new Intent("team_Name");
                intent.putExtra("teamName" , name);
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemData.size();
    }

    public class myTeamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        View vie;

        OnNoteListener onNoteListener;

        public void setOnNoteListener ( OnNoteListener onNoteListener){
            this.onNoteListener = onNoteListener;
        }


        public myTeamViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.teamImage);
            vie = itemView.findViewById(R.id.vie);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(view , getAdapterPosition());

        }
    }
}
