package com.zr.volleyapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.zr.volleyapp.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity{
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    binding=ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets)->{
      Insets systemBars=insets.getInsets(WindowInsetsCompat.Type.systemBars());
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      return insets;
    });

    String url="https://dummyjson.com/users?limit=10";
    RequestQueue queue=Volley.newRequestQueue(MainActivity.this);
    JsonObjectRequest request=new JsonObjectRequest(url, new Response.Listener<JSONObject>(){
      @Override
      public void onResponse(JSONObject response){
        try {
          binding.tvDemo.setText(response.getString("users"));
        } catch (JSONException e) {
          throw new RuntimeException(e);
        }
      }
    }, new Response.ErrorListener(){
      @Override
      public void onErrorResponse(VolleyError error){
        binding.tvDemo.setText(error.getMessage());
      }
    });
    queue.add(request);
  }
}