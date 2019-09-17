package com.nullstdio.bbfc2020.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nullstdio.bbfc2020.R;
import com.nullstdio.bbfc2020.modelClass.Players_Informations;
import com.nullstdio.bbfc2020.modelClass.PlayesCatagories;

import java.util.List;

public class PlayersCatagoriesAdapter extends RecyclerView.Adapter<PlayersCatagoriesAdapter.myCatagoriesViewHolder> {


    private Context context;
    private List<PlayesCatagories> groupItems;

    public PlayersCatagoriesAdapter(Context context, List<PlayesCatagories> groupItems) {
        this.context = context;
        this.groupItems = groupItems;
    }
    @NonNull
    @Override
    public myCatagoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.players_catagories , parent , false);
        return new myCatagoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myCatagoriesViewHolder holder, int position) {

        holder.header.setText(groupItems.get(position).getCatagories()+"s");


        List<Players_Informations> data = groupItems.get(position).getLists();

        PlayersAdapter myItemAdapter = new PlayersAdapter(context , data);

        holder.playersRe.setHasFixedSize(true);
        holder.playersRe.setLayoutManager(new LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false));
        holder.playersRe.setAdapter(myItemAdapter);

        holder.playersRe.setNestedScrollingEnabled(false);
    }

    @Override
    public int getItemCount() {
        return groupItems.size();
    }

    public class myCatagoriesViewHolder extends RecyclerView.ViewHolder{
        TextView header;
        RecyclerView playersRe;
        public myCatagoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.header);
            playersRe = itemView.findViewById(R.id.playerRe);
        }
    }
}
