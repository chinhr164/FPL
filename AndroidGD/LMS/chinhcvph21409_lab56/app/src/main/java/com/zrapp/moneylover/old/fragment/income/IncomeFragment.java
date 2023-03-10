package com.zrapp.moneylover.old.fragment.income;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.zrapp.moneylover.old.MainActivity;
import com.zrapp.moneylover.old.R;
import com.zrapp.moneylover.old.fragment.expense.ExpenseFragment;
import com.zrapp.moneylover.old.pagerAdapter.IncomePager;

public class IncomeFragment extends AppCompatActivity {
    ViewPager2 pager;
    IncomePager adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_in);

        MainActivity.toolbar = findViewById(R.id.toolbar_in);
        setSupportActionBar(MainActivity.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        pager = findViewById(R.id.vp_in);
        adapter = new IncomePager(IncomeFragment.this);
        pager.setAdapter(adapter);

        TabLayout layout = findViewById(R.id.tabl_in);
        new TabLayoutMediator(layout, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Khoản thu"); break;
                    case 1:
                        tab.setText("Loại thu"); break;
                }
            }
        }).attach();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Class aClass = null;
        int item_menu = item.getItemId();
        switch (item_menu) {
            case android.R.id.home:
                aClass = MainActivity.class;
                break;
            case R.id.expense:
                aClass = ExpenseFragment.class;
                break;

            case R.id.income:
                aClass = IncomeFragment.class;
                break;
        }
        Intent intent = new Intent(IncomeFragment.this, aClass);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
