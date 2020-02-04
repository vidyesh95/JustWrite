package com.example.justwrite.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.justwrite.R;
import com.example.justwrite.adapter.RecyclerViewAdapter;
import com.example.justwrite.model.ItemsList;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Change theme according to AppBarLayout State
        AppBarLayout mAppBarLayout = root.findViewById(R.id.header_container_home);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    }
                } else if (isShow) {
                    isShow = false;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        int flags = getActivity().getWindow().getDecorView().getSystemUiVisibility(); // get current flag
                        flags = flags ^ View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; // use XOR here for remove LIGHT_STATUS_BAR from flags
                        getActivity().getWindow().getDecorView().setSystemUiVisibility(flags);
                    }
                }
            }
        });

        ArrayList<ItemsList> recyclerViewList = new ArrayList<>();
        recyclerViewList.add(new ItemsList(R.drawable.acts, "Line 9", "Line 10"));
        recyclerViewList.add(new ItemsList(R.drawable.books, "Line 11", "Line 12"));
        recyclerViewList.add(new ItemsList(R.drawable.living, "Line 13", "Line 14"));
        recyclerViewList.add(new ItemsList(R.drawable.acts, "Line 15", "Line 16"));
        recyclerViewList.add(new ItemsList(R.drawable.books, "Line 17", "Line 18"));
        recyclerViewList.add(new ItemsList(R.drawable.living, "Line 19", "Line 20"));
        recyclerViewList.add(new ItemsList(R.drawable.acts, "Line 21", "Line 22"));
        recyclerViewList.add(new ItemsList(R.drawable.books, "Line 23", "Line 24"));
        recyclerViewList.add(new ItemsList(R.drawable.living, "Line 25", "Line 26"));
        recyclerViewList.add(new ItemsList(R.drawable.acts, "Line 27", "Line 28"));
        recyclerViewList.add(new ItemsList(R.drawable.books, "Line 29", "Line 30"));
        // RecyclerView
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(recyclerViewList);
        recyclerView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // On view Destroy Change Theme to default
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = getActivity().getWindow().getDecorView().getSystemUiVisibility(); // get current flag
            if (flags == View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) {
                flags = flags ^ View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; // use XOR here for remove LIGHT_STATUS_BAR from flags
                getActivity().getWindow().getDecorView().setSystemUiVisibility(flags);
            }
        }
    }
}

