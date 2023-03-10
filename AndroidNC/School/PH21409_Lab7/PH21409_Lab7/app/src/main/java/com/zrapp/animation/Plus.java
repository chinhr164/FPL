package com.zrapp.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.zrapp.animation.databinding.ActivityPlusBinding;

public class Plus extends AppCompatActivity {
    private ActivityPlusBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPlusBinding.inflate(getLayoutInflater());

        Animation animLogo = AnimationUtils.loadAnimation(Plus.this, R.anim.logo);
        binding.pIMG.startAnimation(animLogo);
        Animator animNews = AnimatorInflater.loadAnimator(Plus.this, R.animator.news);
        animNews.setTarget(binding.pTvNews);
        animNews.start();
        Animator animMusic = AnimatorInflater.loadAnimator(Plus.this, R.animator.music);
        animMusic.setTarget(binding.pTvMusic);
        animMusic.start();
        Animator animAccount = AnimatorInflater.loadAnimator(Plus.this, R.animator.account);
        animAccount.setTarget(binding.pTvAcount);
        animAccount.start();
        Animator animName = AnimatorInflater.loadAnimator(Plus.this, R.animator.name);
        animName.setTarget(binding.pTvName);
        animName.start();

        setContentView(binding.getRoot());
    }
}