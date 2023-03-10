package com.zrapp.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        EditText editText = findViewById(R.id.edit);
        Button btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckActivity.this, SaleBroadcast.class);
                intent.putExtra("str", editText.getText().toString());
                sendBroadcast(intent);
            }
        });
    }
}