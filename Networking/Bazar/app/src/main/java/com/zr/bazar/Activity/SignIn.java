package com.zr.bazar.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.zr.bazar.R;
import com.zr.bazar.databinding.ActivitySignInBinding;

public class SignIn extends AppCompatActivity{
  private ActivitySignInBinding binding;
  private FirebaseAuth auth;

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    binding=ActivitySignInBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets)->{
      Insets systemBars=insets.getInsets(WindowInsetsCompat.Type.systemBars());
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      return insets;
    });

    setSupportActionBar(binding.toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    //Fill email & pass
    if (restorePreData()){
      SharedPreferences preferences=getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
      binding.edEmail.setText(preferences.getString("email",""));
      binding.edPass.setText(preferences.getString("pass",""));
      binding.chkPassW.setChecked(restorePreData());
    }


    //Button Login
    binding.btnLogin.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v){
        if (validate()) {
          //Remember Pass?
          if (binding.chkPassW.isChecked()) {
            savePrefsData();
          } else {
            clearPrefsData();
          }

          //Get user
          String email=binding.edEmail.getText().toString().trim();
          String passW=binding.edPass.getText().toString().trim();
          auth=FirebaseAuth.getInstance();
          auth.signInWithEmailAndPassword(email, passW).addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task){
              if (task.isSuccessful()) {
                FirebaseUser user=auth.getCurrentUser();
                clearText();
                Toast.makeText(SignIn.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignIn.this, MainActivity.class));
              } else {
                Log.e("TagError", "Đăng nhập không thành công", task.getException());
                Toast.makeText(SignIn.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
              }
            }
          });
        }
      }
    });

    //Button Forgot
    binding.tvForgotPass.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v){
        Toast.makeText(SignIn.this, "Chưa phát triển", Toast.LENGTH_SHORT).show();
      }
    });

    //Button SignUp
    binding.signUp.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v){
        Intent intent=new Intent(SignIn.this, SignUp.class);
        startActivity(intent);
      }
    });

    //Google Auth
    binding.btnGoogle.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v){
        Toast.makeText(SignIn.this, "Chưa phát triển", Toast.LENGTH_SHORT).show();
      }
    });
  }

  public boolean validate(){
    String email=binding.edEmail.getText().toString().trim();
    String passW=binding.edPass.getText().toString().trim();
    if (email.isEmpty() || passW.isEmpty()) {
      binding.tvError.setText("Vui lòng nhập đủ thông tin");
      binding.tvError.setVisibility(View.VISIBLE);
      return false;
    } else if (!email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")) {
      binding.tvError.setText("Sai định dạng email");
      binding.tvError.setVisibility(View.VISIBLE);
      return false;
    } else {
      binding.tvError.setVisibility(View.GONE);
    }
    return true;
  }

  public void clearText(){
    binding.edEmail.getText().clear();
    binding.edPass.getText().clear();
  }

  private boolean restorePreData(){
    SharedPreferences preferences=getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
    return preferences.getBoolean("chkPass", false);
  }

  private void savePrefsData(){
    SharedPreferences preferences=getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
    SharedPreferences.Editor editor=preferences.edit();
    editor.putBoolean("chkPass", binding.chkPassW.isChecked());
    editor.putString("email", binding.edEmail.getText().toString().trim());
    editor.putString("pass", binding.edPass.getText().toString().trim());
    editor.apply();
  }

  private void clearPrefsData(){
    SharedPreferences preferences=getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
    SharedPreferences.Editor editor=preferences.edit();
    editor.putBoolean("chkPass", binding.chkPassW.isChecked());
    editor.remove("email");
    editor.remove("pass");
    editor.apply();
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item){
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
    }
    return super.onOptionsItemSelected(item);
  }
}