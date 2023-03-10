package com.example.usnn_bcnn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.edStn);
        ed2 = findViewById(R.id.edSth);
        btn = findViewById(R.id.btnResult);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stn = Integer.parseInt(ed1.getText().toString());
                int sth = Integer.parseInt(ed2.getText().toString());

                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("stn",stn);
                bundle.putInt("sth", sth);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}