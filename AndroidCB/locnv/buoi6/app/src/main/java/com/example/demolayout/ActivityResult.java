package com.example.demolayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityResult extends AppCompatActivity {
    TextView tvUser, tvPass, tvSubj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvUser = findViewById(R.id.result_user);
        tvPass = findViewById(R.id.result_pass);
        tvSubj = findViewById(R.id.result_subj);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        tvUser.setText(bundle.getString("user"));
        tvPass.setText(bundle.getString("pass"));
        tvSubj.setText(bundle.getString("subj"));
    }
}