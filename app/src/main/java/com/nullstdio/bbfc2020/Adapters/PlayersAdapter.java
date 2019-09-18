package com.nullstdio.bbfc2020.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nullstdio.bbfc2020.R;
import com.nullstdio.bbfc2020.modelClass.Players_Informations;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>{

    List<Players_Informations> players ;
    Context context ;

    public PlayersAdapter(Context context , List<Players_Informations> players ) {
        this.players = players;
        this.context = context;
    }

    @NonNull
    @Override
    public PlayersAdapter.PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parents, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.player_def_mid_for , parents , false);
        return new PlayersAdapter.PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayersAdapter.PlayerViewHolder holder, int position) {


        try {
            holder.name.setText(players.get(position).getFullName());
            holder.jersy.setText(players.get(position).getJersyNumber());
            String path = players.get(position).getImagePath();
            Picasso.get().load(path).into(holder.imageView);
        }catch (Exception e){

        }



    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView jersy;
        CircleImageView imageView;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.playersName);

            jersy = itemView.findViewById(R.id.jersey);
            imageView = itemView.findViewById(R.id.playerCircleImage);
        }
    }

}
