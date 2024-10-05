package com.zr.bazar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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
import com.zr.bazar.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity{
  private ActivitySignUpBinding binding;
  private FirebaseAuth auth;

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    binding=ActivitySignUpBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets)->{
      Insets systemBars=insets.getInsets(WindowInsetsCompat.Type.systemBars());
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      return insets;
    });

    //Toolbar
    setSupportActionBar(binding.toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    //Register
    binding.btnRegister.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v){
        if (validate()) {
          String email=binding.edEmail.getText().toString().trim();
          String passW=binding.edPass.getText().toString().trim();
          auth=FirebaseAuth.getInstance();
          auth.createUserWithEmailAndPassword(email, passW).addOnCompleteListener(SignUp.this,
                  new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task){
              if (task.isSuccessful()) {
                clearText();
                Toast.makeText(SignUp.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
              } else {
                Log.e("TagError", "Đăng ký không thành công", task.getException());
                Toast.makeText(SignUp.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
              }
            }
          });
        }
      }
    });

    //SignIn
    binding.signIn.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v){
        Intent intent=new Intent(SignUp.this, SignIn.class);
        startActivity(intent);
      }
    });
  }

  public boolean validate(){
    String name=binding.edName.getText().toString().trim();
    String email=binding.edEmail.getText().toString().trim();
    String passW=binding.edPass.getText().toString().trim();
    if (name.isEmpty() || email.isEmpty() || passW.isEmpty()) {
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
    binding.edName.getText().clear();
    binding.edEmail.getText().clear();
    binding.edPass.getText().clear();
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