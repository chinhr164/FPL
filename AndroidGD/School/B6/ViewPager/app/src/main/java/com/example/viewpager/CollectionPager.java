package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CollectionPager extends FragmentStateAdapter {

    public CollectionPager(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position){
           case 0: return new Frag01();
           case 1: return new Frag02();
       }
       return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
