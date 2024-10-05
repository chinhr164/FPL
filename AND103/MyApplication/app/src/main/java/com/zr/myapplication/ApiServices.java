package com.zr.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiServices{

  public static final String IP="192.168.63.240";
public static String BASE_URL="http://"+IP+":3000/api/";

  @GET("Sach")
  Call<List<Sach>> getAll();  //Lấy danh sách dữ liệu

  @GET("Sach/{id}")
  Call<List<Sach>> get(@Path("id") String id);  //Lấy 1 dữ liệu

  @POST("Sach")
  Call<List<Sach>> postData(@Body Sach sach); //Thêm đối tượng mới
}
