package com.example.demo43;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1. Tạo nguồn dữ liệu
        List<Contact> arrs = new ArrayList<>();
        arrs.add(new Contact(Color.YELLOW, "An", "A0912345678"));
        arrs.add(new Contact(Color.RED, "BInh", "B0912345678"));
        arrs.add(new Contact(Color.GRAY, "Cong", "C0912345678"));
        arrs.add(new Contact(Color.GREEN, "Dung", "D0912345678"));
        arrs.add(new Contact(Color.CYAN, "Em", "E0912345678"));
        //2. Goi adapter

        Adapter adapter = new Adapter(this, R.layout.itemrow, arrs);

        //3. Dua du lieu len listview
        lv.setAdapter(adapter);
        Log.i("mothaiba", "onCreate: ");
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
