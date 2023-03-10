package com.example.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlite.database.MyDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edMa,edTen;
    Button btnThem;
    ListView lv;

    private ArrayList<Student> arrayList = new ArrayList<>();
    private MyAdapter adapter;
    MyDatabase db;
    String st = "Sinhvien";

    public void show(){
        Cursor mCursor = db.getData("SELECT * FROM "+st);
        arrayList.clear();
        while (mCursor.moveToNext()){
            String id = mCursor.getString(0 );
            String ma = mCursor.getString(1 );
            String name = mCursor.getString(2);
            arrayList.add(new Student(Integer.parseInt(id),ma,name));
        }

        adapter = new MyAdapter(this,arrayList,R.layout.item_listview);
        lv.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edMa = findViewById(R.id.edMa);
        edTen = findViewById(R.id.edTen);
        btnThem = findViewById(R.id.btnThem);
        lv = findViewById(R.id.lv);
        db = new MyDatabase(this);

        db.QuerryData("CREATE TABLE IF NOT EXISTS Sinhvien(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "MA VACHAR(10) ,NAME VACHAR(20))");
        show();

//      db.QuerryData("INSERT INTO Sinhvien VALUES(null,'Ph21424','Ngo Trung Hieu')");
        //db.QuerryData("DELETE FROM Sinhvien WHERE ID = 3");
        //db.QuerryData("UPDATE ...");




        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edMa.getText().toString().equalsIgnoreCase("")||edTen.getText().toString().equalsIgnoreCase("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Thông Báo");
                    builder.setMessage("Mời bạn nhập đủ thông tin!");
                    builder.setPositiveButton("OK",null);
                    builder.show();
                }else {
                    String name = edTen.getText().toString();
                    String ma = edMa.getText().toString();
                    db.QuerryData("INSERT INTO Sinhvien VALUES(NULL,'"+ma+"','"+name+"')");
                    Toast.makeText(getApplicationContext(),"Insert thành công!",Toast.LENGTH_SHORT).show();
                    show();
                }

            }
        });
    }
}