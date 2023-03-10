package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv_prod;
    ArrayList<Product> list = new ArrayList<>();
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_prod = findViewById(R.id.rcv_prod);
        list.add(new Product(1, "Máy tính", R.drawable.ic_launcher_background));
        list.add(new Product(2, "Điện thoại", R.drawable.ic_launcher_background));
        list.add(new Product(3, "Máy giặt", R.drawable.ic_launcher_background));

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        adapter = new ProductAdapter(list);
        rcv_prod.setAdapter(adapter);
        rcv_prod.setLayoutManager(layoutManager);
    }
}