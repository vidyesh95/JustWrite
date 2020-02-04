package com.example.justwrite;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Homefragment extends Fragment {
    private  RecyclerView mrecyclerView;
    private  RecyclerView.Adapter madapter;
    private RecyclerView.LayoutManager mlayoutManager;
    public ImageView imageView;
    public TextView textView;
    public TextView textView2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        mrecyclerView = (RecyclerView) view.findViewById(R.id.view_id);
        mlayoutManager = new LinearLayoutManager(this.getActivity());
        mrecyclerView.setLayoutManager(mlayoutManager);
        return view;


    }


}

