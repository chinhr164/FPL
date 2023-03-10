package com.example.studentmanagement.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentmanagement.R;
import com.example.studentmanagement.adapter.StudentAdapter;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.sqLite.ZrDatabase;

import java.util.ArrayList;

public class PH21409StudentActivity extends AppCompatActivity {
    Spinner spinner;
    ListView lv;
    EditText txtID, txtNAME, txtBIRTH;
    Button btn;

    ArrayList<Student> listSt = new ArrayList<>();
    ZrDatabase db = new ZrDatabase(PH21409StudentActivity.this);
    public final static String TB_Student = "STUDENT";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        //Tạo bảng
        db.QuerrySQL("CREATE TABLE IF NOT EXISTS " + TB_Student
                + "(idS text PRIMARY KEY,nameS text," +
                "birthS Text,idC Text NOT NULL, FOREIGN KEY (idC) REFERENCES CLASS(idC))");
//        db.QuerrySQL("INSERT INTO " + TB_Student + " VALUES('PH21409', 'Cao Văn Chỉnh'," +
//                "'25-10-1997','CP17306')");
        //Xử lý Spinner
        ArrayList<String> arraySpinner = new ArrayList<>();
        spinner = findViewById(R.id.stList_sp);
        Cursor c = db.getData("SELECT * FROM CLASS");
        arraySpinner.clear();
        arraySpinner.add("Show All");
        while (c.moveToNext()) {
            arraySpinner.add(c.getString(1));
        }
        lv = findViewById(R.id.lv_st);
        ArrayAdapter<String> adapterSpin = new ArrayAdapter<>(PH21409StudentActivity.this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapterSpin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpin);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    parent.getChildAt(position).setBackgroundColor(Color.RED);
                    ((TextView) parent.getChildAt(position)).setTextColor(Color.WHITE);
                    show("");
                } else {
                    String path = spinner.getSelectedItem().toString();
                    show("WHERE idC IN (SELECT idc FROM " + PH21409ClassActivity.TB_NAME + " WHERE nameC = '" + path + "')");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Xử lý nút thêm
        txtID = findViewById(R.id.stList_txtId);
        txtNAME = findViewById(R.id.stList_txtName);
        txtBIRTH = findViewById(R.id.stList_txtBirth);
        btn = findViewById(R.id.calc_clear_txt_Prise);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtID.getInputType() == InputType.TYPE_TEXT_VARIATION_PASSWORD)
                    txtID.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
                else
                    txtID.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String path = spinner.getSelectedItem().toString();
//                String ID = txtID.getText().toString().toUpperCase();
//                String NAME = txtNAME.getText().toString();
//                String BIRTH = txtBIRTH.getText().toString();
//                if (txtID.getText().toString().equals("")
//                        || txtNAME.getText().toString().equals("")
//                        || txtBIRTH.getText().toString().equals("")) {
//                    Toast.makeText(PH21409StudentActivity.this, "Vui lòng điền đủ thông tin", Toast.LENGTH_SHORT).show();
//                } else {
//                    if (path.equals("Show All")) {
//                        Toast.makeText(PH21409StudentActivity.this, "Vul lòng chọn lớp", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Cursor cursor = db.getData("SELECT * FROM "
//                                + PH21409ClassActivity.TB_NAME + " WHERE nameC = '" + path + "'");
//                        cursor.moveToFirst();
//                        String idS = cursor.getString(0);
//                        if (db.getData("SELECT *" +
//                                " FROM " + TB_Student + " WHERE idS='" + ID + "';").getCount() == 0) {
//                            db.QuerrySQL("INSERT INTO " + TB_Student
//                                    + " VALUES('" + ID + "','" + NAME + "','" + BIRTH + "','" + idS + "')");
//                            txtID.setText("");
//                            txtNAME.setText("");
//                            txtBIRTH.setText("");
//                            Toast.makeText(PH21409StudentActivity.this,
//                                    "Thêm thành công\n" + ID + " - " + NAME + " - " + BIRTH, Toast.LENGTH_LONG).show();
//                        } else {
//                            Toast.makeText(PH21409StudentActivity.this,
//                                    "Mã SV " + ID + "  đã tồn tại!!", Toast.LENGTH_LONG).show();
//                        }
//
//                        Toast.makeText(PH21409StudentActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
//                        show("WHERE idC IN (SELECT idc FROM " + PH21409ClassActivity.TB_NAME + " WHERE nameC = '" + path + "')");
//                    }
//                }
//
//            }
//        });

        //Xử lý listView
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(PH21409StudentActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn muốn xóa?");


                builder.setNegativeButton("Xác nhận", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.QuerrySQL("DELETE FROM " + TB_Student + " WHERE idC='" + listSt.get(position).getClasses() + "';");
                        Toast.makeText(PH21409StudentActivity.this, "Delete thành công!", Toast.LENGTH_SHORT).show();
                        show("");
                    }
                });

                builder.setPositiveButton("Hủy", null);

                AlertDialog dialog = builder.create();
                dialog.show();

                return true;
            }
        });
    }


    public void show(String sql) {
        Cursor c = db.getData("SELECT * FROM " + TB_Student + " " + sql);
        listSt.clear();
        while (c.moveToNext()) {
            String idS = c.getString(0);
            String nameS = c.getString(1);
            String birthS = c.getString(2);
            String idC = c.getString(3);
            listSt.add(new Student(idS, nameS, birthS, idC));
        }
        StudentAdapter adapter = new StudentAdapter(this, listSt, R.layout.item_lv_st);
        lv.setAdapter(adapter);
    }


}