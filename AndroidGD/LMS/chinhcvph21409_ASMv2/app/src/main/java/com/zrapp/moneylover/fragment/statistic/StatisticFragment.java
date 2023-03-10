package com.zrapp.moneylover.fragment.statistic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.zrapp.moneylover.R;
import com.zrapp.moneylover.pageAdapter.IncomePager;
import com.zrapp.moneylover.pageAdapter.StatisticPager;


public class StatisticFragment extends Fragment {
    ViewPager2 pager;
    StatisticPager adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_st,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pager = view.findViewById(R.id.vp_st);
        adapter = new StatisticPager(this);
        pager.setAdapter(adapter);

        TabLayout layout = view.findViewById(R.id.tabl_st);
        new TabLayoutMediator(layout, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0: tab.setText("Thống kê thu"); break;
                    case 1: tab.setText("Thống kê chi"); break;
                }
            }
        }).attach();
    }
}
