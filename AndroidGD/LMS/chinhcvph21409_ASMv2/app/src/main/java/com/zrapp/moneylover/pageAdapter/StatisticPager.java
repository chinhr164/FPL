package com.zrapp.moneylover.pageAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zrapp.moneylover.fragment.income.IncomeSFragment;
import com.zrapp.moneylover.fragment.income.IncomeTypeFragment;
import com.zrapp.moneylover.fragment.statistic.StatisticExpenseFragment;
import com.zrapp.moneylover.fragment.statistic.StatisticIncomeFragment;

public class StatisticPager extends FragmentStateAdapter {
    public StatisticPager(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new StatisticIncomeFragment();
            case 1:
                return new StatisticExpenseFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
