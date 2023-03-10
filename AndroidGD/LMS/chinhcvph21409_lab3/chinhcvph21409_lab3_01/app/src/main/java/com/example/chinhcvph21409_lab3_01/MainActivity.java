package com.example.chinhcvph21409_lab3_01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageView ibtn_add, ibtn_view;
    RecyclerView rcv_user;
    public static UserAdapter adapter;
    public static ArrayList<User> list;
    public static UserDatabase db;

    Dialog dialog;

    ImageView dialog_IMG;
    int REQUEST_CODE_CAMERA = 123;
    int REQUEST_CODE_FOLDER = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_user = findViewById(R.id.rcv_user);
        list = new ArrayList<>();
        adapter = new UserAdapter(list, R.layout.row_grid_view, MainActivity.this);
        rcv_user.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        rcv_user.setLayoutManager(gridLayoutManager);
        ibtn_view = findViewById(R.id.ibtn_view);
        ibtn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rcv_user.getLayoutManager() == gridLayoutManager) {
                    rcv_user.setLayoutManager(linearLayoutManager);
                    ibtn_view.setImageResource(R.drawable.ic_grid_view);
                    adapter = new UserAdapter(list, R.layout.row_linear_view, MainActivity.this);
                    rcv_user.setAdapter(adapter);
                } else {
                    rcv_user.setLayoutManager(gridLayoutManager);
                    ibtn_view.setImageResource(R.drawable.ic_list_view);
                    adapter = new UserAdapter(list, R.layout.row_grid_view, MainActivity.this);
                    rcv_user.setAdapter(adapter);
                }
            }
        });


        db = new UserDatabase(this, "QuanLy.sqlite", null, 1);
        db.QueryData("CREATE TABLE IF NOT EXISTS User(Id TEXT PRIMARY KEY, Name VARCHAR(50), Img BLOB)");
        Show();

        ibtn_add = findViewById(R.id.ibtn_add);
        ibtn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAddClassDialog();
            }
        });

        //Chuyển đổi giữa hai RecycleView
    }

    @Override
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

    public void createAddClassDialog() {
        final View mainView = getLayoutInflater().inflate(R.layout.activity_main, null);
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_add_user);
        dialog.show();
        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                dialog.dismiss();
                return true;
            }
        });

        TextView dialogTxtName = dialog.findViewById(R.id.dialog_txtName);
        TextView dialogTxtId = dialog.findViewById(R.id.dialog_txtId);
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

        Button dialogBtnClear = dialog.findViewById(R.id.dialog_btnClear);
        dialogBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogTxtName.setText("");
                dialogTxtId.setText("");
                dialog_IMG.setImageResource(R.drawable.ic_empty);
            }
        });


        Button dialogBtnSave = dialog.findViewById(R.id.dialog_btnSave);
        dialogBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = dialogTxtName.getText().toString().trim();
                String id = dialogTxtId.getText().toString().trim().toUpperCase(Locale.ROOT);

                //Chuyển ImageView -> byte[]
                BitmapDrawable drawable = null;
                try {
                    drawable = (BitmapDrawable) dialog_IMG.getDrawable();
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Vui lòng điền đủ thông tin", Toast.LENGTH_LONG).show();
                }

                if (name.isEmpty() || id.isEmpty() || drawable == null)
                    Toast.makeText(MainActivity.this, "Vui lòng điền đủ thông tin", Toast.LENGTH_LONG).show();
                else if (db.GetData("SELECT * FROM User WHERE Id = '" + id + "'").getCount() != 0) {
                    Toast.makeText(MainActivity.this, "Đã tồn tại Mã Id!", Toast.LENGTH_LONG).show();
                } else {
                    //Chuyển ImageView -> byte[]
                    Bitmap bitmap = drawable.getBitmap();
                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                    byte[] img = byteArray.toByteArray();


                    db.InsertData(id, name, img);
                    Show();
                    Toast.makeText(MainActivity.this, "Thêm thành công!!", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                }
            }
        });
    }

    public static void Show() {
        Cursor c = db.GetData("SELECT * FROM User");
        list.clear();
        while (c.moveToNext()) {
            User user = new User();
            user.setId(c.getString(0));
            user.setName(c.getString(1));
            user.setImg_res(c.getBlob(2));
            list.add(user);
        }
        c.close();
        adapter.notifyDataSetChanged();
    }
}