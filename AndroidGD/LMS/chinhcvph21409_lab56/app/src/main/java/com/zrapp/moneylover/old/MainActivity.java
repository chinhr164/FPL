package com.zrapp.moneylover.old;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.zrapp.moneylover.old.fragment.expense.ExpenseFragment;
import com.zrapp.moneylover.old.fragment.income.IncomeFragment;

public class MainActivity extends AppCompatActivity {
    public static Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
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
        Intent intent = new Intent(MainActivity.this, aClass);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}