package com.zrapp.moneylover.old.pagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zrapp.moneylover.old.fragment.expense.ExpenseSFragment;
import com.zrapp.moneylover.old.fragment.expense.ExpenseTypeFragment;

public class ExpensePager extends FragmentStateAdapter {
    public ExpensePager(@NonNull FragmentActivity fragmentActivity) {super(fragmentActivity);}

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ExpenseSFragment();
            case 1:
                return new ExpenseTypeFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
