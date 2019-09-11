package com.nullstdio.bbfc2020.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nullstdio.bbfc2020.R;
import com.nullstdio.bbfc2020.modelClass.DatabasePlayerAndScore;
import com.nullstdio.bbfc2020.modelClass.FixureModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FixtureAdapter extends RecyclerView.Adapter<FixtureAdapter.holder> {
    private Context context;
    ArrayList<FixureModel> models;

    String nameA;
    String nameB;
    String date;
    String time;
    String scTeamA;
    String scTeamB;
    String matchId;
    boolean scoreA;
    boolean scoreB;




    public FixtureAdapter(Context context, ArrayList<FixureModel> models) {
        this.context = context;
        this.models = models;
    }


    @NonNull
    @Override
    public FixtureAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fixure_support_layout , parent , false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

        nameA = models.get(position).getTeamAName();
        nameB = models.get(position).getTeamBName();
        date = models.get(position).getDate();
        time = models.get(position).getTime();
        matchId = models.get(position).getMatchId();
        scoreA = models.get(position).isAscore();
        scoreB = models.get(position).isBscore();

        scTeamA = models.get(position).getScoreteamA();
        scTeamB = models.get(position).getScoreteamB();


        holder.teamAName.setText(nameA);
        holder.teamBName.setText(nameB);

        if (scoreA == true || scoreB == true ){

            holder.dateScore.setText(scTeamA+" - "+scTeamB);

        }else {

            holder.dateScore.setText(date);
            holder.timeAndInvisible.setText(time);

        }



    }

    @Override
    public int getItemCount() {
        return models.size();
    }


    class holder extends RecyclerView.ViewHolder {

        ImageView teamA;
        ImageView teamB;

        TextView teamAName;
        TextView teamBName;
        TextView dateScore;
        TextView timeAndInvisible;
        public holder(@NonNull View itemView) {
            super(itemView);

            teamA = itemView.findViewById(R.id.teamA);
            teamB = itemView.findViewById(R.id.teamB);
            teamAName = itemView.findViewById(R.id.teamAName);
            teamBName = itemView.findViewById(R.id.teamBName);
            dateScore = itemView.findViewById(R.id.dateAndScore);
            timeAndInvisible = itemView.findViewById(R.id.timeAndInvisible);

        }


    }
}
