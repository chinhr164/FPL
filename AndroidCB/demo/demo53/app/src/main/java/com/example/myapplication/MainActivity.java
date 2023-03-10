package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.demo51_lv);
        //Nguồn dữ liệu
        List<Product> list = new ArrayList<>();
        list.add(new Product("11", "SP11", 111, R.drawable.ic_launcher_foreground));
        list.add(new Product("22", "SP22", 222, R.drawable.ic_launcher_foreground));
        list.add(new Product("33", "SP33", 333, R.drawable.ic_launcher_foreground));
        list.add(new Product("44", "SP44", 444, R.drawable.ic_launcher_foreground));
        list.add(new Product("55", "SP55", 555, R.drawable.ic_launcher_foreground));
        list.add(new Product("66", "SP66", 666, R.drawable.ic_launcher_foreground));

        //gọi hàm tạo database Sqlite
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this);//Tạo database
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();//Cho phép ghi
        //
        ContentValues values = new ContentValues();//Tạo đối tượng chứa dữ liệu
        values.put("id", "10");
        values.put("name", "Zr");
        values.put("price", 1111);
        values.put("image", Color.RED);
        //Thực thi insert
        db.insert("PRODUCT", null, values);
        //Tạo adapter
        Demo51Adapter adapter = new Demo51Adapter(this,R.layout.item_row,list);
        lv.setAdapter(adapter);
    }
}