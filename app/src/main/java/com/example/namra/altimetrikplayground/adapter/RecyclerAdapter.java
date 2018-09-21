package com.example.namra.altimetrikplayground.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.namra.altimetrikplayground.Categories;
import com.example.namra.altimetrikplayground.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    private Categories categories;
    TextView id,title;
    View view;

    public void setMapList(Categories categories) {
        this.categories = categories;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_adapter, parent,false);
        return new RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onViewRecycled(RecyclerAdapter.ViewHolder holder) {
        super.onViewRecycled(holder);
    }



    @Override
    public int getItemCount() {
        if (categories == null)
        {

           return 0;
        }
        else
            return getItemCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView id,title;

        public ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tvId);
            title = itemView.findViewById(R.id.title);
        }
    }
    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        holder.id.setText(categories.getId());
        holder.title.setText(categories.getTitle());
    }
}

