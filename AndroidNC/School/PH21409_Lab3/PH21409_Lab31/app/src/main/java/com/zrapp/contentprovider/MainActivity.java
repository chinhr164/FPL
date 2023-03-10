package com.zrapp.contentprovider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottom_Nav;

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //readContact
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, 100);
                }
            }
        }

        //readBookmark

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFrag(new FragmentContact());

        bottom_Nav = findViewById(R.id.bottom_nav);
        bottom_Nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.nav_contact:
                        fragment = new FragmentContact();
                        loadFrag(fragment);
                        break;
                    case R.id.nav_bookmark:
                        fragment = new FragmentBookmark();
                        loadFrag(fragment);
                        break;
                    case R.id.nav_calllog:
                        fragment = new FragmentCallLog();
                        loadFrag(fragment);
                        break;
                    case R.id.nav_media:
                        fragment = new FragmentMedia();
                        loadFrag(fragment);
                        break;
                }
                return true;
            }
        });
    }

    public void loadFrag(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_content,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}