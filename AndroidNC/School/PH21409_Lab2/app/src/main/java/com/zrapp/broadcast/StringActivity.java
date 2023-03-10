package com.zrapp.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);

        EditText editText = findViewById(R.id.edit);
        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StringActivity.this, StringBroadCast.class);
                intent.putExtra("str", editText.getText().toString());
                sendBroadcast(intent);
            }
        });
    }
}