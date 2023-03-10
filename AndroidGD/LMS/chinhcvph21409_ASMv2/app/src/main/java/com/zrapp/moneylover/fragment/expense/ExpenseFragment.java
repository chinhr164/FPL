package com.zrapp.moneylover.fragment.expense;

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
import com.zrapp.moneylover.pageAdapter.ExpensePager;

public class ExpenseFragment extends Fragment {
    ViewPager2 pager;
    ExpensePager adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ex, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pager = view.findViewById(R.id.vp_ex);
        adapter = new ExpensePager(this);
        pager.setAdapter(adapter);

        TabLayout layout = view.findViewById(R.id.tabl_ex);
        new TabLayoutMediator(layout, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0: tab.setText("Khoản chi"); break;
                    case 1: tab.setText("Loại chi"); break;
                }
            }
        }).attach();
    }
}
