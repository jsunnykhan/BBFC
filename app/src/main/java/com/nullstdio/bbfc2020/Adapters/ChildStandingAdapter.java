package com.nullstdio.bbfc2020.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nullstdio.bbfc2020.R;
import com.nullstdio.bbfc2020.modelClass.ChildStandingList;

import java.util.List;

public class ChildStandingAdapter extends RecyclerView.Adapter<ChildStandingAdapter.myItemViewHolder>{


    private Context context;
    private List<ChildStandingList> itemData;

    public ChildStandingAdapter(Context context, List<ChildStandingList> itemData) {
        this.context = context;
        this.itemData = itemData;
    }

    @NonNull
    @Override
    public myItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_standing_card , parent , false);
        return new myItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myItemViewHolder holder, int position) {

        holder.TeamName.setText(itemData.get(position).getTeam_name());
        holder.win.setText(itemData.get(position).getWin()+"");
        holder.draw.setText(itemData.get(position).getDraw()+"");
        holder.played.setText(itemData.get(position).getPlayed()+"");
        holder.lose.setText(itemData.get(position).getLoose()+"");
        holder.points.setText(itemData.get(position).getPoints()+"");

    }

    @Override
    public int getItemCount() {
        return itemData.size();
    }

    public class myItemViewHolder extends RecyclerView.ViewHolder {
        TextView TeamName;
        TextView win;
        TextView played;
        TextView lose;
        TextView draw;
        TextView points;


        public myItemViewHolder(@NonNull View itemView) {
            super(itemView);

            TeamName = itemView.findViewById(R.id.teamName);
            win = itemView.findViewById(R.id.win);
            played = itemView.findViewById(R.id.played);
            lose = itemView.findViewById(R.id.lost);
            draw = itemView.findViewById(R.id.draw);
            points = itemView.findViewById(R.id.points);
        }
    }
}
