package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Currency;

public class MainActivity extends AppCompatActivity {
    public static ListView lv;
    Button btnAdd;
    public ArrayList<CalendalObj> list = new ArrayList<>();
    public static ZrAdapter adapter;
    public static ZrDatabase db;
    public final static String TB_NAME = "NOTE";

    public void show() {
        Cursor c = db.getData("SELECT * FROM " + TB_NAME);
        list.clear();
        while (c.moveToNext()) {
            int ID = c.getInt(0);
            String contentT = c.getString(1);
            String timeT = c.getString(2);
            list.add(new CalendalObj(contentT, timeT));
        }
        c.close();
        adapter = new ZrAdapter(this, R.layout.item_row, list);
        lv.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.main_lv);
        db = new ZrDatabase(this);
        db.queryData("CREATE TABLE IF NOT EXISTS " + TB_NAME +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, contentT TEXT, timeT TEXT)");
//        db.queryData("INSERT INTO " + TB_NAME +
//                " VALUES(null,'Ăn trưa với Ngọc Trinh lúc 12h30','14-06-2022')");
//        db.queryData("INSERT INTO " + TB_NAME +
//                " VALUES(null,'Hẹn hò cùng Emma Waston lúc 20h30','14-06-2022')");
        show();
        btnAdd = findViewById(R.id.main_btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GhiNho.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        show();
    }
}