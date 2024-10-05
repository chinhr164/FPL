package com.zr.bazar.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.zr.bazar.Adapter.IntroViewPagerAdapter;
import com.zr.bazar.Model.ScreenItem;
import com.zr.bazar.R;
import com.zr.bazar.databinding.ActivityOnBroadingBinding;

import java.util.ArrayList;
import java.util.List;

public class OnBroading extends AppCompatActivity{
  private ActivityOnBroadingBinding binding;
  IntroViewPagerAdapter viewPagerAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    binding=ActivityOnBroadingBinding.inflate(getLayoutInflater());
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//    if (restorePreData()) {
//      Intent intent = new Intent(getApplicationContext(), SignIn.class);
//      startActivity(intent);
//      finish();
//    }

    setContentView(binding.getRoot());
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets)->{
      Insets systemBars=insets.getInsets(WindowInsetsCompat.Type.systemBars());
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      return insets;
    });

    //Data
    final List<ScreenItem> list = new ArrayList<>();
    list.add(new ScreenItem("Now reading books will be easier","Discover new worlds, join a vibrant reading community. Start your reading adventure effortlessly with us.",R.drawable.on_broading1));
    list.add(new ScreenItem("Your Bookish Soulmate Awaits","Let us be your guide to the perfect read. Discover books tailored to your tastes for a truly rewarding experience.",R.drawable.on_broading2));
    list.add(new ScreenItem("Start Your Adventure","Ready to embark on a quest for inspiration and knowledge? Your adventure begins now. Let's go!",R.drawable.on_broading3));

    //Setup Viewpager
    viewPagerAdapter = new IntroViewPagerAdapter(this,list);
    binding.screenViewpager.setAdapter(viewPagerAdapter);

    //Setup tab indicator
    binding.tabIndicator.setupWithViewPager(binding.screenViewpager);

    //Button Next
    binding.btnNext.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v){
        binding.screenViewpager.setCurrentItem(binding.screenViewpager.getCurrentItem()+1,true);
      }
    });

    binding.tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
      @Override
      public void onTabSelected(TabLayout.Tab tab){
        if (tab.getPosition()==list.size()-1){
          loadLastScreen();
        }else loadScreen();
      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab){
      }

      @Override
      public void onTabReselected(TabLayout.Tab tab){
      }
    });

    //Button Get Started
    binding.btnGetStarted.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), SignIn.class);
        startActivity(intent);
//        savePrefsData();
        finish();
      }
    });

  }

  private boolean restorePreData(){
    SharedPreferences preferences=getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
    Boolean isIntroActivityOpenedBefore=preferences.getBoolean("isIntroOpened", false);
    return isIntroActivityOpenedBefore;
  }

  private void savePrefsData(){
    SharedPreferences preferences=getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
    SharedPreferences.Editor editor=preferences.edit();
    editor.putBoolean("isIntroOpened", true);
    editor.apply();
  }

  private void loadScreen(){
    binding.linearLayoutNext.setVisibility(View.VISIBLE);
    binding.linearLayoutGetStarted.setVisibility(View.INVISIBLE);
  }

  private void loadLastScreen(){
    binding.linearLayoutNext.setVisibility(View.INVISIBLE);
    binding.linearLayoutGetStarted.setVisibility(View.VISIBLE);
  }
}