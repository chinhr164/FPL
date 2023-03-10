package com.zrapp.entertainment.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.zrapp.entertainment.Frag.FragMusic;
import com.zrapp.entertainment.Frag.FragNews;
import com.zrapp.entertainment.R;
import com.zrapp.entertainment.Services.NewsService;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout layout;
    NavigationView navigationView;
    BottomNavigationView bottom_Nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFrag(new FragNews());

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        layout = findViewById(R.id.drawbleLayout);

        navigationView = findViewById(R.id.nav_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Class aClass = null;
                int id = item.getItemId();
                if (id == R.id.nav_Info) {
                    if (NewsService.statusUser != null) {
                        Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Chưa đăng nhập >.<!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    switch (id) {
                        case R.id.nav_Home:
                            aClass = MainActivity.class;
                            break;

                        case R.id.nav_SignIn:
                            if (item.getTitle().equals("Đăng xuất")) {
                                NewsService.statusUser = null;
                            }
                            aClass = SignInActivity.class;
                            break;
                    }
                    Intent intent = new Intent(getApplicationContext(), aClass);
                    startActivity(intent);
                }
                return true;
            }
        });

        navSignIn();

        bottom_Nav = findViewById(R.id.bottom_nav);
        bottom_Nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.nav_news:
                        fragment = new FragNews();
                        loadFrag(fragment);
                        break;
                    case R.id.nav_music:
                        fragment = new FragMusic();
                        loadFrag(fragment);
                        break;
                }
                return true;
            }
        });
    }

    public void loadFrag(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContent, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                layout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navSignIn();
    }
    public void navSignIn() {
        MenuItem menuItem = navigationView.getMenu().findItem(R.id.nav_SignIn);
        if (NewsService.statusUser != null) {
            menuItem.setTitle("Đăng xuất");
            menuItem.setIcon(R.drawable.ic_logout);
        } else {
            menuItem.setTitle("Đăng nhập");
            menuItem.setIcon(R.drawable.ic_login);
        }
    }
}
