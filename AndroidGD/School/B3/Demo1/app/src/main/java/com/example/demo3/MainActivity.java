package com.example.demo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Hiển thị danh sách màu saucsư lên spinner

    Spinner spinner, spin_prod;
    ListView lv_prod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-- làm việc với Spinner
        spinner = findViewById(R.id.spin_color);
        String[] color = {"xanh", "đỏ", "tím", "vàng"};
        ArrayAdapter<String> spin = new ArrayAdapter<String>
                (MainActivity.this, android.R.layout.simple_spinner_item, color);
        spin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spin);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, color[i], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //-- làm việc với simple adapter
        //--- ánh xạ view
        spin_prod = findViewById(R.id.spin_prod);
        lv_prod = findViewById(R.id.lv_prod);

        //--- tạo mảng thuộc tính
        String[] from = {"id", "name", "img_res"};
        //--- mảng các view
        int[] to = {R.id.prod_id, R.id.prod_name, R.id.img_prod};

        //--- tạo list
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        ArrayList<Product> list_prod = new ArrayList<>();
        Product p = new Product(24, "Cao Văn Chỉnh", R.drawable.image_send);
        list_prod.add(p);
        Product p2 = new Product(23, "Nguyễn Thị Mỹ Hạnh", R.drawable.image_receive);
        list_prod.add(p2);
        for (Product prod : list_prod) {
            HashMap<String, Object> hp = new HashMap<>();
            hp.put("id", prod.getId());
            hp.put("name", prod.getName());
            hp.put("img_res", prod.getImg_res());
            list.add(hp);
        }

        //
        SimpleAdapter adapter =
                new SimpleAdapter(MainActivity.this, list, R.layout.layout_item, from, to);
        spin_prod.setAdapter(adapter);
        lv_prod.setAdapter(adapter);
    }
}