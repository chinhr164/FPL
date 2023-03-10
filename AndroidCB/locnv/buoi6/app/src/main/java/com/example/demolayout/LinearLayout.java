package com.example.demolayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LinearLayout extends AppCompatActivity {
    EditText edUser, edPass;
    CheckBox chkjAndroid, chkjPHP;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        edUser = findViewById(R.id.ln_edUser);
        edPass = findViewById(R.id.ln_edPass);
        chkjAndroid = findViewById(R.id.ln_chkAndroid);
        chkjPHP = findViewById(R.id.ln_chkPHP);
        btnRegister = findViewById(R.id.ln_btnR);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edUser.getText().toString();
                String pass = edPass.getText().toString();
                String subj = chkjAndroid.isChecked() && chkjAndroid.isChecked()
                        ? "Android, PHP" : (chkjAndroid.isChecked() ? "Android"
                        : (chkjPHP.isChecked()
                        ? "PHP"
                        : "Không có"));

                Intent intent = new Intent(getApplicationContext(), ActivityResult.class);
                Bundle bundle = new Bundle();
                bundle.putString("user", user);
                bundle.putString("pass", pass);
                bundle.putString("subj", subj);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}