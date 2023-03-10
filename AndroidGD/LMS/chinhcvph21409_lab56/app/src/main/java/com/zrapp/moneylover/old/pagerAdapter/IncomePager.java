package com.zrapp.moneylover.old.pagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zrapp.moneylover.old.fragment.income.IncomeSFragment;
import com.zrapp.moneylover.old.fragment.income.IncomeTypeFragment;

public class IncomePager extends FragmentStateAdapter {
    public IncomePager(@NonNull FragmentActivity fragmentActivity) {super(fragmentActivity);}

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new IncomeSFragment();
            case 1:
                return new IncomeTypeFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
