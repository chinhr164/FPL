package com.example.demo51;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class demo51 extends AppCompatActivity {
    EditText ed1, ed2;
    Button btn1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.demo51_ed1);
        ed2 = findViewById(R.id.demo51_ed2);
        btn1 = findViewById(R.id.demo51_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = ed1.getText().toString();
                String password = ed2.getText().toString();

                Intent intent = new Intent(getApplicationContext(), demo51_man2.class);
                Bundle bundle = new Bundle();
                bundle.putString("tk", username);
                bundle.putString("mk", password);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getApplication();
    }
}