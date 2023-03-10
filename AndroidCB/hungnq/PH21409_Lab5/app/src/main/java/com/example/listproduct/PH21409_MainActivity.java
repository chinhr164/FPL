package com.example.listproduct;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PH21409_MainActivity extends AppCompatActivity {
    private ListView lv;
    private ArrayList<Product> list = new ArrayList<>();
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        list.add(new Product("P001", "Cơm chiên Hoàng Bào",
                30000, R.drawable.com_chien_hoang_bao));
        list.add(new Product("P002", "Rồng xanh vượt đại dương",
                15000, R.drawable.rong_xanh_vuot_dai_duong));
        list.add(new Product("P003", "Vũ nữ chân dài",
                45000, R.drawable.vu_nu_chan_dai));

        adapter = new ProductAdapter(this,list, R.layout.item_row);
        lv.setAdapter(adapter);

        SQLiteHelper helper = new SQLiteHelper(this);
        SQLiteDatabase database = helper.getReadableDatabase();
        database.close();
    }
}