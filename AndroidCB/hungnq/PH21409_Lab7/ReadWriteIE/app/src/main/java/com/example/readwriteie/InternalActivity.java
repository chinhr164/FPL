package com.example.readwriteie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class InternalActivity extends AppCompatActivity {

    TextView inte_tv;
    EditText inte_ed;
    Button inte_btnRead, inte_btnWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);

        inte_tv = findViewById(R.id.inte_tv);
        inte_ed = findViewById(R.id.inte_ed);

        inte_btnRead = findViewById(R.id.inte_btnRead);
        inte_btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readInte();
            }
        });

        inte_btnWrite = findViewById(R.id.inte_btnWrite);
        inte_btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeInte();
                inte_ed.setText("");
            }
        });
    }

    public void writeInte() {
        if (inte_ed.getText().toString().equals(""))
            Toast.makeText(this, "Vui lòng nhập thông tin", Toast.LENGTH_SHORT).show();
        else {
            try {
                String data = inte_ed.getText().toString();
                String nameFile = "inte.txt";
                FileOutputStream fos = openFileOutput(nameFile, MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();
                Toast.makeText(this, "Ghi thành công!!!", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
            }
        }
    }

    public void readInte() {
        try {
            String nameFile = "inte.txt";
            FileInputStream fos = openFileInput(nameFile);

            Scanner scanner = new Scanner(fos);
            StringBuilder data = new StringBuilder();
            while (scanner.hasNext()) {
                data.append(scanner.nextLine());
            }
            scanner.close();
            inte_tv.setText(data);
        } catch (Exception e) {
        }
    }
}
