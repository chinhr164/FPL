package com.example.readwriteie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExternalActivity extends AppCompatActivity {
    TextView exte_tv;
    EditText exte_ed;
    Button exte_btnRead, exte_btnWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);

        exte_tv = findViewById(R.id.exte_tv);
        exte_ed = findViewById(R.id.exte_ed);

        exte_btnRead = findViewById(R.id.exte_btnRead);
        exte_btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readExte();
            }
        });

        exte_btnWrite = findViewById(R.id.exte_btnWrite);
        exte_btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExte();
                exte_ed.setText("");
            }
        });
    }

    public void writeExte() {
        if ((exte_ed.getText() + "").equals(""))
            Toast.makeText(this, "Vui lòng nhập thông tin", Toast.LENGTH_SHORT).show();
        else {
            if (ContextCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(ExternalActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        999);
            } else {
                try {
                    String path = Environment.getExternalStorageDirectory()
                            .getAbsolutePath()
                            + "/file.txt";
                    FileOutputStream outputStream = new FileOutputStream(path);
                    String data = "" + exte_ed.getText();
                    outputStream.write(data.getBytes());
                    outputStream.close();
                    Toast.makeText(ExternalActivity.this, "Ghi thành công", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(ExternalActivity.this, "Exception", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

    public void readExte() {
        if (ContextCompat.checkSelfPermission(ExternalActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ExternalActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 999);
        } else {
            try {
                String path = Environment.getExternalStorageDirectory()
                        .getAbsolutePath() + "/file.txt";
                FileInputStream stream = new FileInputStream(path);
                Scanner scanner = new Scanner(stream);
                String data = "";
                while (scanner.hasNext()) {
                    data += (scanner.nextLine());
                }
                scanner.close();
                exte_tv.setText(data);
            } catch (Exception e) {
            }
        }
    }
}
