package com.nullstdio.bbfc2020.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import com.nullstdio.bbfc2020.FragmentAll.PlayerInformationsFragment;
import com.nullstdio.bbfc2020.Interface.OnPlayerClick;
import com.nullstdio.bbfc2020.R;
import com.nullstdio.bbfc2020.modelClass.Players_Informations;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>{

    List<Players_Informations> players ;
    Context context ;
    String image;

    public PlayersAdapter(Context context , List<Players_Informations> players , String image) {
        this.players = players;
        this.context = context;
        this.image = image;
    }

    @NonNull
    @Override
    public PlayersAdapter.PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parents, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.player_def_mid_for , parents , false);
        return new PlayersAdapter.PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PlayersAdapter.PlayerViewHolder holder, int position) {


        try {
            holder.name.setText(players.get(position).getFullName());
            holder.jersy.setText(players.get(position).getJersyNumber());
            String path = players.get(position).getImagePath();
            Picasso.get().load(path).into(holder.imageView);
        }catch (Exception e){

        }

        holder.setOnPlayerListener(new OnPlayerClick() {
            @Override
            public void onPlayerClick(View view, int position) {


                Context mcontext = view.getContext();

                    String name = players.get(position).getFullName();
                    String jer = players.get(position).getJersyNumber();
                    String posi = players.get(position).getPlayerPosition();
                    String playerImage = players.get(position).getImageFlat();
                    String Nname = players.get(position).getNname();


                    Bundle args = new Bundle();
                    args.putString("p_name", name);
                    args.putString("p_jer", jer);
                    args.putString("p_posi", posi);
                    args.putString("p_playerImage", playerImage);
                    args.putString("p_teamImage", image);
                    args.putString("p_Nname", Nname);

                    //set Fragmentclass Arguments
                    PlayerInformationsFragment fragment = new PlayerInformationsFragment();
                    fragment.setArguments(args);


                    FragmentTransaction fragmentTransaction = ((FragmentActivity)mcontext).getSupportFragmentManager().beginTransaction();

                    fragmentTransaction.replace(R.id.fragmentContainer, fragment);
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);


                    fragmentTransaction.addToBackStack("Fragment tag");


                    fragmentTransaction.commit();






            }
        });



    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name;
        TextView jersy;
        CircleImageView imageView;
        OnPlayerClick playerClick;

        public void setOnPlayerListener ( OnPlayerClick playerClick){
            this.playerClick = playerClick;
        }


        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.playersName);

            jersy = itemView.findViewById(R.id.jersey);
            imageView = itemView.findViewById(R.id.playerCircleImage);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            playerClick.onPlayerClick(view , getAdapterPosition());
        }
    }

}
