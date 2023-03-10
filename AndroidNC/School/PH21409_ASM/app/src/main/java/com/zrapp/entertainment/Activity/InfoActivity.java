package com.zrapp.entertainment.Activity;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.zrapp.entertainment.Model.User;
import com.zrapp.entertainment.R;
import com.zrapp.entertainment.SQLite.DAO;
import com.zrapp.entertainment.Services.MusicService;
import com.zrapp.entertainment.Services.NewsService;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class InfoActivity extends AppCompatActivity {
    DrawerLayout layout;
    Toolbar toolbar;
    NavigationView navigationView;
    AppBarLayout appBarLayout;
    ImageView img_ava, img_ava_appbar, img_cover, info_nav;
    EditText info_name, info_tel, info_email;
    TextView info_name_appbar, info_username;
    Button btn;
    DAO dao;
    NewsService service;
    ServiceConnection sv_conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicService.LocalBinder localBinder = (MusicService.LocalBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {}
    };
    ImageView dialog_IMG;
    int REQUEST_CODE_CAMERA = 123;
    int REQUEST_CODE_FOLDER = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        findView();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) - appBarLayout.getTotalScrollRange() == 0) {
                    //  Collapsed
                    toolbar.setVisibility(View.VISIBLE);
                } else {
                    //Expanded
                    toolbar.setVisibility(View.INVISIBLE);
                }
            }
        });

        fillData();

        info_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.openDrawer(GravityCompat.START);
            }
        });

        img_ava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIMG(R.id.img_ava);
            }
        });

        img_cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIMG(R.id.img_cover);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn.getText().equals("Đổi thông tin")) {
                    btn.setText("Lưu thông tin");
                    info_name.setEnabled(true);
                    info_tel.setEnabled(true);
                    info_email.setEnabled(true);
                } else {
                    btn.setText("Đổi thông tin");
                    String name = info_name.getText().toString();
                    String tel = info_tel.getText().toString();
                    String email = info_email.getText().toString();
                    if (name.isEmpty() || tel.isEmpty() || email.isEmpty()) {
                        Toast.makeText(InfoActivity.this, "Vui lòng nhập đủ thông tin!!", Toast.LENGTH_SHORT).show();
                    } else {
                        User user = new User(name, tel, email);
                        dao.updateUser(user, NewsService.statusUser.getUsername());
                        info_name.setEnabled(false);
                        info_tel.setEnabled(false);
                        info_email.setEnabled(false);
                        info_name_appbar.setText(name);
                        NewsService.statusUser = dao.getUser(info_username.getText().toString());
                    }
                }
            }
        });

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.password_change, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                layout.openDrawer(GravityCompat.START);
                return true;
            case R.id.info_password:
                changePassword();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void findView() {
        layout = findViewById(R.id.drawbleLayout);
        toolbar = findViewById(R.id.itoolbar);
        appBarLayout = findViewById(R.id.appBar);
        navigationView = findViewById(R.id.nav_menu);
        info_name = findViewById(R.id.info_name);
        info_username = findViewById(R.id.info_username);
        info_tel = findViewById(R.id.info_tel);
        info_email = findViewById(R.id.info_email);
        info_name_appbar = findViewById(R.id.info_name_appbar);
        img_ava = findViewById(R.id.img_ava);
        img_cover = findViewById(R.id.img_cover);
        img_ava_appbar = findViewById(R.id.img_ava_appbar);
        info_nav = findViewById(R.id.info_nav);
        btn = findViewById(R.id.info_btn);
        dao = new DAO(this);
        service = new NewsService();
        Intent intentService = new Intent(InfoActivity.this, MusicService.class);
        bindService(intentService, sv_conn, Context.BIND_AUTO_CREATE);
        service = new NewsService(this);
    }

    public void fillData() {
        User user = NewsService.statusUser;
        info_name.setText(user.getName());
        info_tel.setText(user.getTel());
        info_email.setText(user.getEmail());
        info_name_appbar.setText(user.getName());
        info_username.setText(user.getUsername());
        img_ava.setImageBitmap(service.getBitmap(user.getAvatar()));
        img_ava_appbar.setImageBitmap(service.getBitmap(user.getAvatar()));
        img_cover.setImageBitmap(service.getBitmap(user.getCover()));
    }

    public void changePassword() {
        final View mainView = getLayoutInflater().inflate(R.layout.activity_info, null);
        Dialog dialog = new Dialog(InfoActivity.this);
        dialog.setContentView(R.layout.dialog_password_change);
        dialog.show();
        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                dialog.dismiss();
                return true;
            }
        });

        TextInputLayout lCurrent = dialog.findViewById(R.id.change_current);
        TextInputLayout lNew = dialog.findViewById(R.id.change_new);
        TextInputLayout lConfirm = dialog.findViewById(R.id.change_confirm);
        Button btnC = dialog.findViewById(R.id.change_btn);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current = lCurrent.getEditText().getText().toString();
                String newP = lNew.getEditText().getText().toString();
                String confirm = lConfirm.getEditText().getText().toString();

                if (current.isEmpty() || newP.isEmpty() || confirm.isEmpty()) {
                    Toast.makeText(InfoActivity.this, "Chưa nhập đủ kìa cha -.-!", Toast.LENGTH_SHORT).show();
                } else if (!current.equals(NewsService.statusUser.getPassword())) {
                    Toast.makeText(InfoActivity.this, "Quên mật khẩu cũ rồi à -.-!", Toast.LENGTH_SHORT).show();
                } else if (!newP.equals(confirm)) {
                    Toast.makeText(InfoActivity.this, "Nản, xem lại xác nhận mật khẩu mau -.-!", Toast.LENGTH_SHORT).show();
                } else {
                    dao.updatePass(newP, NewsService.statusUser.getUsername());
                    Toast.makeText(InfoActivity.this, "Đổi mật khẩu thành công ^.^!!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            dialog_IMG.setImageBitmap(bitmap);

        }
        if (requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {
                InputStream is = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                dialog_IMG.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void setIMG(int id) {
        final View mainView = getLayoutInflater().inflate(R.layout.activity_info, null);
        Dialog dialog = new Dialog(InfoActivity.this);
        dialog.setContentView(R.layout.dialog_img_update);
        dialog.show();
        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                dialog.dismiss();
                return true;
            }
        });

        dialog_IMG = dialog.findViewById(R.id.dialog_IMG);

        ImageButton img_upload = dialog.findViewById(R.id.img_upload);
        img_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_FOLDER);
            }
        });

        ImageButton img_camera = dialog.findViewById(R.id.img_camera);
        img_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
            }
        });

        Button btnSave = dialog.findViewById(R.id.dialog_btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BitmapDrawable drawable = null;
                try {
                    drawable = (BitmapDrawable) dialog_IMG.getDrawable();
                } catch (Exception ex) {
                    Toast.makeText(InfoActivity.this, "Vui lòng điền đủ thông tin", Toast.LENGTH_LONG).show();
                }
                Bitmap bitmap = drawable.getBitmap();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                byte[] img = byteArray.toByteArray();

                if (id == R.id.img_ava) {
                    img_ava.setImageBitmap(bitmap);
                    img_ava_appbar.setImageBitmap(bitmap);
                    dao.updateIMG("avatar", NewsService.statusUser, img);
                }

                if (id == R.id.img_cover) {
                    img_cover.setImageBitmap(bitmap);
                    dao.updateIMG("cover", NewsService.statusUser, img);
                }
                dialog.dismiss();
            }
        });
    }
}