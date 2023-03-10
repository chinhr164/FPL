package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txtContent;
    private Button btn;
    private Animation animationUp;
    private Animation animationDown;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtContent = (TextView) findViewById(R.id.content);
//        txtContent.setVisibility(View.INVISIBLE);

        animationUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        animationDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);

        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Toast.makeText(MainActivity.this, "Được rồi", Toast.LENGTH_LONG).show();
            }
        });

        touchHelper.

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtContent.isShown()) {
                    txtContent.setVisibility(View.GONE);
                    txtContent.startAnimation(animationUp);
                } else {
                    txtContent.setVisibility(View.VISIBLE);
                    txtContent.startAnimation(animationDown);
                }
            }
        });
    }
}