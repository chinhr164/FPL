package com.example.customview_recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_prod;
    ArrayList<Product> list = new ArrayList<>();
    ProductAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_prod = findViewById(R.id.lv_prod);
        list.add(new Product(1,"Máy tính",R.drawable.ic_launcher_background));
        list.add(new Product(2,"Điện thoại",R.drawable.ic_launcher_background));
        list.add(new Product(3,"Máy giặt",R.drawable.ic_launcher_background));

        adapter = new ProductAdapter(list);
        lv_prod.setAdapter(adapter);
        lv_prod.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}