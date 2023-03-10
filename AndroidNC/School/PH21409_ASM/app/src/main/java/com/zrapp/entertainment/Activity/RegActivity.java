package com.zrapp.entertainment.Activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.zrapp.entertainment.Model.User;
import com.zrapp.entertainment.R;
import com.zrapp.entertainment.Services.NewsService;

public class RegActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout layout;
    NavigationView navigationView;
    TextInputLayout lUser, lPass, lName, lTel, lEmail;
    Button btnReg;
    NewsService service;
    ServiceConnection sv_conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            NewsService.LocalBinder localBinder = (NewsService.LocalBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

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

        //Xử lý đăng ký
        service = new NewsService();
        Intent intentService = new Intent(RegActivity.this, NewsService.class);
        bindService(intentService, sv_conn, Context.BIND_AUTO_CREATE);
        service = new NewsService(RegActivity.this);

        lUser = findViewById(R.id.reg_username);
        lPass = findViewById(R.id.reg_password);
        lName = findViewById(R.id.reg_name);
        lTel = findViewById(R.id.reg_tel);
        lEmail = findViewById(R.id.reg_email);
        btnReg = findViewById(R.id.reg_btn);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = lUser.getEditText().getText().toString();
                String pass = lPass.getEditText().getText().toString();
                String name = lName.getEditText().getText().toString();
                String tel = lTel.getEditText().getText().toString();
                String email = lEmail.getEditText().getText().toString();

                if (user.isEmpty() || pass.isEmpty() || name.isEmpty() || tel.isEmpty() || email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Chua nhập đủ đâu nha >.<!!", Toast.LENGTH_LONG).show();
                } else {
                    User userT = new User();
                    userT.setUsername(user);
                    userT.setPassword(pass);
                    userT.setName(name);
                    userT.setTel(tel);
                    userT.setEmail(email);
                    service.register(userT);
                }
            }
        });
        navSignIn();
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

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                layout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}