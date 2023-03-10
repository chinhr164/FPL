
package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ClassList extends AppCompatActivity {
    ListView lvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        lvContent = findViewById(R.id.stl_lvContent);
        List<Classes> list = new ArrayList<>();
        int size = list.size();
        list.add(new Classes(String.valueOf(++size), "MOB5001", "Lớp MOBILE 5001"));
        list.add(new Classes(String.valueOf(++size), "MOB5002", "Lớp MOBILE 5002"));

        ClassAdapter adapter = new ClassAdapter(this, R.layout.item_listview, list);
        lvContent.setAdapter(adapter);
        lvContent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ClassList.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn muốn xoá ?");

                builder.setNegativeButton("Xác nhận", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });


                builder.setPositiveButton("Huỷ", null);


                AlertDialog dialog = builder.create();
                dialog.show();

                return true;
            }
        });
    }
}