package com.example.ptb2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PH21409MainActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double a = Double.parseDouble(ed1.getText().toString());
                    double b = Double.parseDouble(ed2.getText().toString());
                    double c = Double.parseDouble(ed3.getText().toString());

                    Intent intent = new Intent(getApplicationContext(), PH21409Result.class);
                    intent.putExtra("a", a);
                    intent.putExtra("b", b);
                    intent.putExtra("c", c);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(PH21409MainActivity.this, "Vui lòng nhập số", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}