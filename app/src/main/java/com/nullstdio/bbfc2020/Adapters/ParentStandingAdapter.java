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
import com.nullstdio.bbfc2020.modelClass.ChildStandingList;
import com.nullstdio.bbfc2020.modelClass.ParentsStandingList;

import java.util.List;

public class ParentStandingAdapter extends RecyclerView.Adapter<ParentStandingAdapter.myViewHolde> {

    private Context context;
    private List<ParentsStandingList> groupItems;

    public ParentStandingAdapter(Context context, List<ParentsStandingList> groupItems) {
        this.context = context;
        this.groupItems = groupItems;
    }

    @NonNull
    @Override
    public myViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.parents_standing_cart , parent , false);
        return new myViewHolde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolde holder, int position) {

        holder.textView.setText("Group "+groupItems.get(position).getGroupName());


        List<ChildStandingList> data = groupItems.get(position).getGroupChild();

        ChildStandingAdapter myItemAdapter = new ChildStandingAdapter(context , data);

        holder.groupRe.setHasFixedSize(true);
        holder.groupRe.setLayoutManager(new LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false));
        holder.groupRe.setAdapter(myItemAdapter);

        holder.groupRe.setNestedScrollingEnabled(false);
    }

    @Override
    public int getItemCount() {
        return (groupItems != null ? groupItems.size() : 0 );
    }





    public class myViewHolde extends RecyclerView.ViewHolder {
        TextView textView;
        RecyclerView groupRe;

        public myViewHolde(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.groupName);
            groupRe = itemView.findViewById(R.id.parentsStandingRecycler);
        }
    }
}
