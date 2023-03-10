package com.example.usnn_bcnn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView reuslt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int stn = bundle.getInt("stn");
        int sth = bundle.getInt("sth");


        reuslt = findViewById(R.id.txtResult);
        int uc = UCLN(stn, sth);
//        int bc = BCNN(stn, sth);
        reuslt.setText("UCLN: " + uc + "\nBCNN: ");

    }

    public int UCLN(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            return a + b;
        } else {
            while (a != b) {
                if (a > b)
                    a = a - b;
                else
                    b = b - a;
            }
            return a;
        }
    }

//    public int BCNN(int a, int b) {
//        return (a * b) / UCLN(a, b);
//    }
}