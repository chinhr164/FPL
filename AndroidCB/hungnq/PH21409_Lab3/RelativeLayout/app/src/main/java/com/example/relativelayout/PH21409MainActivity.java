package com.example.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PH21409MainActivity extends AppCompatActivity {
    EditText ed1, ed2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.edUsername);
        ed2 = findViewById(R.id.edPassword);

        btn = findViewById(R.id.btnSignIn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ed1.getText().toString();
                String password = ed2.getText().toString();

                if (username.equals("admin") && password.equals("admin"))
                    Toast.makeText(PH21409MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(PH21409MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}