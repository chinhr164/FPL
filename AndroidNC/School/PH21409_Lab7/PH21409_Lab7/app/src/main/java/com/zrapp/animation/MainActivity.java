package com.zrapp.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zrapp.animation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.btnZoom.setOnClickListener(this);
        binding.btnSlideShow.setOnClickListener(this);
        binding.btnClock.setOnClickListener(this);
        binding.btnPlus.setOnClickListener(this);

        setContentView(binding.getRoot());
    }

    @Override
    public void onClick(View view) {
        Class aclass = null;
        switch (view.getId()) {
            case R.id.btnZoom:
                aclass = new Zoom().getClass();
                break;

            case R.id.btnSlideShow:
                aclass = new SlideShow().getClass();
                break;

            case R.id.btnClock:
                aclass = new Clock().getClass();
                break;

            case R.id.btnPlus:
                aclass = new Plus().getClass();
                break;
        }
        Intent intent = new Intent(getApplicationContext(), aclass);
        startActivity(intent);
    }
}