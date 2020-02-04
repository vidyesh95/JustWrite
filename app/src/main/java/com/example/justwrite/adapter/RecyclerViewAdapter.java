package com.example.justwrite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.justwrite.R;
import com.example.justwrite.model.ItemsList;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<ItemsList> itemsLists;

    public static class  ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public TextView textView2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
                imageView = itemView.findViewById(R.id.image);
                textView = itemView.findViewById(R.id.text);
                textView2 = itemView.findViewById(R.id.text2);
        }
    }

    public RecyclerViewAdapter(ArrayList<ItemsList> recyclerViewList) {
        itemsLists = recyclerViewList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        ViewHolder recyclerViewViewHolder = new ViewHolder(v);
        return recyclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemsList currentItem = itemsLists.get(position);
        holder.imageView.setImageResource(currentItem.getmImage());
        holder.textView.setText(currentItem.getmText1());
        holder.textView2.setText(currentItem.getmText2());
    }

    @Override
    public int getItemCount() {
        return itemsLists.size();
    }
}
