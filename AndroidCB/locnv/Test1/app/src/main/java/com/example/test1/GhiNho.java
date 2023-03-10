package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GhiNho extends AppCompatActivity {
    EditText txtNoiDung, txtNgayThang;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghi_nho);

        txtNoiDung = findViewById(R.id.txtNoiDung);
        txtNgayThang = findViewById(R.id.txtNgayThang);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNoiDung.getText().toString().equals("")
                        || txtNgayThang.getText().toString().equals("")) {
                    Toast.makeText(GhiNho.this, "Vui lòng điền đủ!", Toast.LENGTH_LONG).show();
                } else {
                    MainActivity.db.queryData("INSERT INTO " + MainActivity.TB_NAME + " VALUES(null,'"
                            + txtNoiDung.getText().toString() + "','"
                            + txtNgayThang.getText().toString() + "')");
                    Toast.makeText(GhiNho.this, "Thành công!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(GhiNho.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}