package com.zrapp.animationsample;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.tv.TvContentRating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Xử lý hiệu ứng XML
//                AnimatorSet animatorSet =
//                        (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.anim_demo);
//                animatorSet.setTarget(tv);
//                animatorSet.start();

                //Tạo hiệu ứng
                AnimatorSet set = new AnimatorSet();
                ObjectAnimator animRight = ObjectAnimator.ofFloat(tv, "x", tv.getX(), 500);
                animRight.setDuration(2000);
                ObjectAnimator animRotationX = ObjectAnimator.ofFloat(tv, "rotationX", tv.getRotationX(), 360f);
                animRotationX.setDuration(2000);

                set.playTogether(animRight, animRotationX);
                set.start();
            }
        });
    }
}