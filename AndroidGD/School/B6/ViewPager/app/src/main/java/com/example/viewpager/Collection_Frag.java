package com.example.viewpager;

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

public class Collection_Frag extends Fragment {
    ViewPager2 pager2;
    CollectionPager adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.collection_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pager2 = view.findViewById(R.id.pager);
        adapter = new CollectionPager(this);
        pager2.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id.tab);
        new TabLayoutMediator(tabLayout, pager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0: tab.setText("Frag 01"); break;
                    case 1: tab.setText("Frag 02"); break;
                }
                tab.setIcon(android.R.drawable.ic_btn_speak_now);
            }
        }).attach();

    }


}
