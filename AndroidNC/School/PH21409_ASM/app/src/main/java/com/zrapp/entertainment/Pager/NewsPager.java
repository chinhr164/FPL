package com.zrapp.entertainment.Pager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zrapp.entertainment.Frag.FragNewsICT;
import com.zrapp.entertainment.Frag.FragNewsLife;
import com.zrapp.entertainment.Frag.FragNewsTravel;

public class NewsPager extends FragmentStateAdapter {
    public NewsPager(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragNewsICT();
            case 1:
                return new FragNewsLife();
            case 2:
                return new FragNewsTravel();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
