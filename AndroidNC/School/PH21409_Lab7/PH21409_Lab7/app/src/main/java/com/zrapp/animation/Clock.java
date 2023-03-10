package com.zrapp.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;

import com.zrapp.animation.databinding.ActivityClockBinding;

public class Clock extends AppCompatActivity {
    private ActivityClockBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityClockBinding.inflate(getLayoutInflater());

        Animation animH = AnimationUtils.loadAnimation(Clock.this,R.anim.hour);
        Animation animM = AnimationUtils.loadAnimation(Clock.this,R.anim.minutes);
        Animation animS = AnimationUtils.loadAnimation(Clock.this,R.anim.second);
        AnimationSet set = new AnimationSet(true);
        binding.cBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cBtn.getText().toString().equalsIgnoreCase("start")){
                    binding.cBtn.setText("Reset");
                    binding.hour.startAnimation(animH);
                    binding.minute.startAnimation(animM);
                    binding.second.startAnimation(animS);

                }else {
                    binding.cBtn.setText("Start");
                    binding.hour.clearAnimation();
                    binding.minute.clearAnimation();
                    binding.second.clearAnimation();
                }

            }
        });
        setContentView(binding.getRoot());
    }
}