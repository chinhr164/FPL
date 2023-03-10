package com.example.studentmanagement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studentmanagement.R;
import com.example.studentmanagement.sqLite.ZrDatabase;

public class PH21409MainActivity extends AppCompatActivity {
    Button btnAdd, btnView, btnManage, dialogBtnClear, dialogBtnSave;
    EditText dialogTxtName, dialogTxtId;
    AlertDialog.Builder dialogB;
    AlertDialog dialog;
    ZrDatabase db = new ZrDatabase(PH21409MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.main_btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAddClassDialog();
            }
        });

        btnView = findViewById(R.id.main_btnView);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(PH21409MainActivity.this, PH21409ClassActivity.class);
                startActivity(intent1);
            }
        });

        btnManage = findViewById(R.id.main_btnManage);
        btnManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), PH21409StudentActivity.class);
                startActivity(it);
            }
        });
    }

    public void createAddClassDialog() {
        dialogB = new AlertDialog.Builder(this);
        final View addClassPopupView = getLayoutInflater().inflate(R.layout.dialog_add_class, null);
        final View mainView = getLayoutInflater().inflate(R.layout.activity_main, null);
        dialogB.setView(addClassPopupView);
        dialog = dialogB.create();
        dialog.show();
        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                dialog.dismiss();
                return true;
            }
        });

        dialogTxtName = addClassPopupView.findViewById(R.id.dialog_txtName);
        dialogTxtId = addClassPopupView.findViewById(R.id.dialog_txtId);

        dialogBtnClear = addClassPopupView.findViewById(R.id.dialog_btnClear);
        dialogBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTxtId.setText("");
                dialogTxtName.setText("");
            }
        });

        dialogBtnSave = addClassPopupView.findViewById(R.id.dialog_btnSave);
        dialogBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override/**/
            public void onClick(View v) {
                String id = dialogTxtId.getText().toString().toUpperCase();
                String name = dialogTxtName.getText().toString();
                if (id.equals("") || name.equals("")) {
                    Toast.makeText(PH21409MainActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {

                    if (db.getData("SELECT *" +
                            " FROM " + PH21409ClassActivity.TB_NAME + " WHERE idC='" + id + "';").getCount() == 0) {
                        db.QuerrySQL("INSERT INTO " + PH21409ClassActivity.TB_NAME + " VALUES('" + id + "', '" + name + "')");
                        dialogTxtId.setText("");
                        dialogTxtName.setText("");
                        Toast.makeText(PH21409MainActivity.this,
                                "Thêm thành công\n" + id + " - " + name, Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    } else {
                        Toast.makeText(PH21409MainActivity.this,
                                "Mã lớp " + id + "  đã tồn tại!!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}