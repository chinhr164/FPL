package com.example.ssreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class PH21409MainActivity extends AppCompatActivity {
    private EditText txtUser, txtPass;
    private CheckBox chkR;
    private Button btnSignIn;
    private SharedPreferences saveP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser = findViewById(R.id.edId);
        txtPass = findViewById(R.id.edPass);
        chkR = findViewById(R.id.chkRemember);
        btnSignIn = findViewById(R.id.btnSignin);
        saveP = getSharedPreferences("SavePass", MODE_PRIVATE);
        txtUser.setText(saveP.getString("user", ""));
        txtPass.setText(saveP.getString("pass", ""));
        chkR.setChecked(saveP.getBoolean("chk", false));

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtUser.getText().toString();
                String pass = txtPass.getText().toString();
                SharedPreferences.Editor editor = saveP.edit();
                editor.putBoolean("chk", chkR.isChecked());
                if (user.equals("ChinhR") && pass.equals("123@chinh")) {
                    Toast.makeText(PH21409MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    if (chkR.isChecked()) {
                        editor.putString("user", user);
                        editor.putString("pass", pass);
                    } else {
                        editor.remove("user");
                        editor.remove("pass");
                        editor.remove("chk");
                    }
                    Intent intent = new Intent(getApplicationContext(), AlertActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(PH21409MainActivity.this, "Username, password is incorrect!!", Toast.LENGTH_SHORT).show();
                }
                editor.commit();
            }
        });
    }

}