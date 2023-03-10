package lam.fpoly.listviewpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ListView idList;
private ArrayList<FoodObject> list = new ArrayList<>();
private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idList = findViewById(R.id.idList);

        //tạo đối tượng Oject và add vào mảng
        list.add(new FoodObject("Cá Rô đồng","60.000",R.mipmap.ic_launcher));
        list.add(new FoodObject("Cá Chép","80.000",R.mipmap.ic_launcher));
        list.add(new FoodObject("Cá Khô","30.000",R.mipmap.ic_launcher));

        myAdapter = new MyAdapter(this,list,R.layout.layoutitem);
        idList.setAdapter(myAdapter);
    }
}