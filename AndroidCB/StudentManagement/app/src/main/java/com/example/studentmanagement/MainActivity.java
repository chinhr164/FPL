package com.example.studentmanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnView, btnManage, dialogBtnClear, dialogBtnSave;
    EditText dialogTxtName, dialogTxtId;
    AlertDialog.Builder dialogB;
    AlertDialog dialog;

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
                Intent intent = new Intent(getApplicationContext(), ClassList.class);
                startActivity(intent);
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
            @Override
            public void onClick(View v) {
                String id = dialogTxtId.getText().toString();
                String name = dialogTxtId.getText().toString();
                dialogTxtName.getText();
                Toast.makeText(MainActivity.this,
                        "Thêm thành công\n" + id + " - " + name, Toast.LENGTH_LONG).show();
            }
        });
    }
}