package com.zrapp.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

import com.zrapp.animation.databinding.ActivitySlideShowBinding;

public class SlideShow extends AppCompatActivity implements View.OnClickListener, Animator.AnimatorListener {
    private ActivitySlideShowBinding binding;
    int postion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySlideShowBinding.inflate(getLayoutInflater());

        binding.sBtnAll.setOnClickListener(this);
        binding.sBtnPrev.setOnClickListener(this);
        binding.sBtnNext.setOnClickListener(this);

        setContentView(binding.getRoot());
    }

    @Override
    public void onClick(View view) {
        final AnimatorSet[] anim = {null};
        switch (view.getId()) {
            case R.id.sBtnAll:
                postion = 0;
                anim[0] = (AnimatorSet) AnimatorInflater.loadAnimator(SlideShow.this, R.animator.all_hide);
                anim[0].setTarget(binding.layout);
                anim[0].start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onAnimationEnd(anim[0]);
                        anim[0] = (AnimatorSet) AnimatorInflater.loadAnimator(SlideShow.this, R.animator.all_show);
                        anim[0].setTarget(binding.layout);
                        anim[0].start();
                    }
                }, 2000);
                break;

            case R.id.sBtnPrev:
                postion--;
                if (postion <= 0)
                    postion = 5;
                anim[0] = (AnimatorSet) AnimatorInflater.loadAnimator(SlideShow.this, R.animator.prev_hide);
                anim[0].setTarget(binding.layout);
                anim[0].start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onAnimationEnd(anim[0]);
                        anim[0] = (AnimatorSet) AnimatorInflater.loadAnimator(SlideShow.this, R.animator.prev_show);
                        anim[0].setTarget(binding.layout);
                        anim[0].start();
                    }
                }, 2000);
                break;

            case R.id.sBtnNext:
                postion++;
                if (postion == 6)
                    postion = 1;
                anim[0] = (AnimatorSet) AnimatorInflater.loadAnimator(SlideShow.this, R.animator.next_hide);
                anim[0].setTarget(binding.layout);
                anim[0].start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onAnimationEnd(anim[0]);
                        anim[0] = (AnimatorSet) AnimatorInflater.loadAnimator(SlideShow.this, R.animator.next_show);
                        anim[0].setTarget(binding.layout);
                        anim[0].start();
                    }
                }, 2000);
                break;

        }
    }

    @Override
    public void onAnimationEnd(Animator animator) {
        setIMG(postion);
    }

    public void setIMG(int postion) {
        switch (postion) {
            case 0:
                binding.imageS.setImageResource(R.drawable.all);
                binding.sTV.setText("Assassin Code");
                break;

            case 1:
                binding.imageS.setImageResource(R.drawable.khang);
                binding.sTV.setText("Đinh Viết Khang");
                break;

            case 2:
                binding.imageS.setImageResource(R.drawable.ngoc_hai);
                binding.sTV.setText("Hà Thị Ngọc Hải");
                break;

            case 3:
                binding.imageS.setImageResource(R.drawable.chinh);
                binding.sTV.setText("Cao Văn Chỉnh");
                break;

            case 4:
                binding.imageS.setImageResource(R.drawable.trung_hieu);
                binding.sTV.setText("Ngô Trung Hiếu");
                break;

            case 5:
                binding.imageS.setImageResource(R.drawable.xhieu);
                binding.sTV.setText("Đỗ Xuân Hiếu");
                break;

        }
    }

    @Override
    public void onAnimationCancel(Animator animator) {}

    @Override
    public void onAnimationRepeat(Animator animator) {}

    @Override
    public void onAnimationStart(Animator animator) {}
}