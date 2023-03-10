package com.zrapp.xmlparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ProductDTO> list = null;
        ProductLoader loader = new ProductLoader();

        try {
            InputStream inputStream = getAssets().open("products.xml");

            list = loader.getProductDTOList( inputStream );

            for(int i = 0; i< list.size(); i++){
                Log.d("zzz", "San pham: " + list.get(i).toString()   );
            }

            //-------- đưa lên listview
            ArrayAdapter<ProductDTO> adapter = new ArrayAdapter<ProductDTO>(
                    MainActivity.this,
                    android.R.layout.simple_list_item_1,
                    list
            );
            ListView lv =  findViewById(R.id.lv01);
            lv.setAdapter(adapter);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}