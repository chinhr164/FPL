package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();


        fm.beginTransaction().replace(R.id.frag_box,new Frag01());

        Button btnFrag01 = findViewById(R.id.btn_Frag01);
        btnFrag01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frag_box,new Frag01()).commit();
            }
        });

        Button btnFrag02 = findViewById(R.id.btn_Frag02);
        btnFrag02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frag_box,new Frag02()).commit();
            }
        });
    }
}