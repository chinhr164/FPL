package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PH21409MainActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        final String[] list = new String[]{"Android cơ bản", "Android nâng cao",
                "Thiết kế giao diện Android", "Test và triển khai ứng dụng Android", "NodeJS",
                "Game 2D"};

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this
        ,android.R.layout.simple_list_item_1, list);

        lv.setAdapter(adapter);

    }
}