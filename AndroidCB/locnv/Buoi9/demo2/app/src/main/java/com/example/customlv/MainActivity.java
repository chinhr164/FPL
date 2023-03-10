package com.example.customlv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private ArrayList<Food> list = new ArrayList<>();
    private FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        list.add(new Food("Sườn xào cay đắng", 30000, R.mipmap.ic_launcher));
        list.add(new Food("Trứng rán bóng đêm", 15000, R.mipmap.ic_launcher));
        list.add(new Food("Đậu phụ lòng nhau", 1000000, R.mipmap.ic_launcher));

        adapter = new FoodAdapter(this, list, R.layout.item_row);
        lv.setAdapter(adapter);
    }
}