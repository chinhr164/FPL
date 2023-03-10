package com.zrapp.moneylover.pageAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zrapp.moneylover.fragment.expense.ExpenseSFragment;
import com.zrapp.moneylover.fragment.expense.ExpenseTypeFragment;
import com.zrapp.moneylover.fragment.income.IncomeSFragment;
import com.zrapp.moneylover.fragment.income.IncomeTypeFragment;

public class IncomePager extends FragmentStateAdapter {
    public IncomePager(@NonNull Fragment fragment) {
        super(fragment);
    }

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
