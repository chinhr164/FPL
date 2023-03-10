
package com.example.studentmanagement.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentmanagement.R;
import com.example.studentmanagement.adapter.ClassAdapter;
import com.example.studentmanagement.model.Classes;
import com.example.studentmanagement.sqLite.ZrDatabase;

import java.util.ArrayList;

public class PH21409ClassActivity extends AppCompatActivity {
    ListView lvClass;

    ArrayList<Classes> list = new ArrayList<>();
    ClassAdapter adapter;
    ZrDatabase db = new ZrDatabase(PH21409ClassActivity.this);
    public final static String TB_NAME = "CLASS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);


        db.QuerrySQL("CREATE TABLE IF NOT EXISTS " + TB_NAME + "(idC TEXT PRIMARY KEY, nameC Text)");
//        db.QuerrySQL("INSERT INTO " + TB_NAME + " VALUES('MOB5001','Lớp MOBILE 5001')");
//        db.QuerrySQL("INSERT INTO " + TB_NAME + " VALUES('MOB5002', 'Lớp MOBILE 5002')");


        lvClass = findViewById(R.id.lv_class);
        show();
        lvClass.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(PH21409ClassActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn muốn xóa?");


                builder.setNegativeButton("Xác nhận", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.QuerrySQL("DELETE FROM " + TB_NAME + " WHERE idC='" + list.get(position).getId() + "';");
                        db.QuerrySQL("DELETE FROM " + PH21409StudentActivity.TB_Student + " WHERE idC='" + list.get(position).getId() + "';");
                        Toast.makeText(PH21409ClassActivity.this, "Delete thành công!", Toast.LENGTH_SHORT).show();
                        show();
                    }
                });

                builder.setPositiveButton("Hủy", null);

                AlertDialog dialog = builder.create();
                dialog.show();

                return true;
            }
        });
    }

    public void show() {
        Cursor c = db.getData("SELECT * FROM " + TB_NAME);
        list.clear();
        while (c.moveToNext()) {
            String idC = c.getString(0);
            String nameC = c.getString(1);
            list.add(new Classes(idC, nameC));
        }
        adapter = new ClassAdapter(PH21409ClassActivity.this, list, R.layout.item_lv_class);
        lvClass.setAdapter(adapter);
    }
}