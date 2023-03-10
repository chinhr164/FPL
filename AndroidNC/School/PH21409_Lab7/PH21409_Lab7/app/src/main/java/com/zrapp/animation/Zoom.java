package com.zrapp.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.zrapp.animation.databinding.ActivityZoomBinding;

import java.lang.annotation.Annotation;
import java.util.Timer;
import java.util.TimerTask;

public class Zoom extends AppCompatActivity implements View.OnClickListener {
    private ActivityZoomBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityZoomBinding.inflate(getLayoutInflater());

        binding.zBtnRotation.setOnClickListener(this);
        binding.zBtnMoving.setOnClickListener(this);
        binding.zBtnZoom.setOnClickListener(this);

        setContentView(binding.getRoot());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zBtnRotation:
                binding.zBtn.setVisibility(View.INVISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.zBtn.setVisibility(View.VISIBLE);
                    }
                },3000);
                int degree = 360;
                if (binding.image.getRotation() == 360)
                    degree = 0;
                ObjectAnimator animR = ObjectAnimator.ofFloat(binding.image, "rotation", degree);
                animR.setDuration(3000);
                animR.start();
                break;

            case R.id.zBtnMoving:
                binding.zBtn.setVisibility(View.INVISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.zBtn.setVisibility(View.VISIBLE);
                    }
                },6000);
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(Zoom.this,R.animator.moving);
                set.setTarget(binding.image);
                set.start();
                break;

            case R.id.zBtnZoom:
                binding.zBtn.setVisibility(View.INVISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.zBtn.setVisibility(View.VISIBLE);
                    }
                },8000);
                Animation animZ = AnimationUtils.loadAnimation(Zoom.this, R.anim.zoom);
                binding.image.startAnimation(animZ);
                break;
        }
    }
}