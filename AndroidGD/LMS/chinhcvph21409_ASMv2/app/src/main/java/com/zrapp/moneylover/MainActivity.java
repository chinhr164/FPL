package com.zrapp.moneylover;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.zrapp.moneylover.fragment.CreditsFragment;
import com.zrapp.moneylover.fragment.expense.ExpenseFragment;
import com.zrapp.moneylover.fragment.income.IncomeFragment;
import com.zrapp.moneylover.fragment.statistic.StatisticFragment;

public class MainActivity extends AppCompatActivity {
    DrawerLayout layout;
    Toolbar toolbar;
    NavigationView navigationView;
    ImageView imageView;

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.drawbleLayout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frameContent,new StatisticFragment()).commit();

        navigationView = findViewById(R.id.nav_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                Class aClass = null;
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_Income:
                        aClass = IncomeFragment.class;
                        break;

                    case R.id.nav_Expense:
                        aClass = ExpenseFragment.class;
                        break;

                    case R.id.nav_Statistic:
                        aClass = StatisticFragment.class;
                        break;

                    case R.id.nav_Introduce:
//                        Toast.makeText(MainActivity.this, "Tính năng chưa hoàn thiện", Toast.LENGTH_LONG).show();
                        aClass = CreditsFragment.class;
                        break;

                    case R.id.nav_Exit:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Thoát");
                        builder.setMessage("Bạn có chắc chắn muốn thoát chương trình?");
                        builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                Intent intent = new Intent(MainActivity.this, LauncherActivity.class);
//                                startActivity(intent);
                                finish();
                            }
                        });
                        builder.setPositiveButton("Không", null);
                        builder.show();

                    default:
                        aClass = StatisticFragment.class;
                }
                try {
                    fragment = (Fragment) aClass.newInstance();
                    fm.beginTransaction().replace(R.id.frameContent, fragment).commit();
                    layout.closeDrawer(GravityCompat.START);
                } catch (Exception e) {
                }


                imageView = findViewById(R.id.nav_info);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onClick(View view) {
                        PopupMenu popupMenu = new PopupMenu(MainActivity.this, imageView);
                        MenuInflater inflater = popupMenu.getMenuInflater();
                        inflater.inflate(R.menu.account_menu, popupMenu.getMenu());
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                if (menuItem.getItemId() == R.id.info)
                                    Toast.makeText(MainActivity.this, "Tính năng đang phát triển", Toast.LENGTH_LONG).show();
                                if (menuItem.getItemId() == R.id.signOut)
                                    Toast.makeText(MainActivity.this, "Tính năng đang phát triển", Toast.LENGTH_LONG).show();
                                return true;
                            }
                        });
                        popupMenu.show();
                    }
                });
                return true;
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                layout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}