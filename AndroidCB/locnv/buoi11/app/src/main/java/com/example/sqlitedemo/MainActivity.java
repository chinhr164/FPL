package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText txtName, txtId;
    private Button btnAdd;
    private ListView lv;

    private ArrayList<Student> list = new ArrayList<>();
    private ZrDatabase db;
    private StudentAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId = findViewById(R.id.d61_edId);
        txtName = findViewById(R.id.d61_edName);
        lv = findViewById(R.id.d61_lv);
        btnAdd = findViewById(R.id.d61_btnAdd);

        db = new ZrDatabase(this);
        db.QueryData("CREATE TABLE IF NOT EXISTS SinhVien(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT(20)," +
                "MASV TEXT(10));");
        db.QueryData("INSERT INTO SinhVien VALUES(" +
                "null," +
                "Cao Van Chinh" +
                "PH21409;");

        Cursor c = db.getData("Select * From SinhVien");
        while (c.moveToNext()) {
            String name = c.getString(2);
            Toast.makeText(this, "Tên: " + name, Toast.LENGTH_SHORT).show();
        }

    }
}