package com.zr.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.zr.myapplication.databinding.ActivityMainBinding;
import com.zr.myapplication.databinding.DialogAddBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

  private ActivityMainBinding binding;
  private ArrayAdapter<CharSequence> arrayAdapter;
  private HttpRequest request;
  private SachAdapter adapter;

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

    arrayAdapter=ArrayAdapter.createFromResource(
            MainActivity.this,
            R.array.gioi_tinh,
            android.R.layout.simple_spinner_item);
    request=new HttpRequest();

    binding.srLayout.setOnRefreshListener(()->{
      binding.srLayout.setRefreshing(false);
      getData();
    });

    getData();

    binding.fabInsert.setOnClickListener(v->{
//      addDialog();
    });
  }

  private void getData(){
    request.callAPI().getAll().enqueue(new Callback<List<Sach>>(){
      @Override
      public void onResponse(Call<List<Sach>> call, Response<List<Sach>> response){
        if (response.isSuccessful()) {
          Toast.makeText(MainActivity.this, "Lấy dữ liệu thành oông", Toast.LENGTH_SHORT).show();
          List<Sach> list=response.body();
          show(list);
        }
      }

      @Override
      public void onFailure(Call<List<Sach>> call, Throwable t){

      }
    });
  }

  private void show(List<Sach> list){
    adapter=new SachAdapter(list, MainActivity.this, ((Sach, v)->{}));
    binding.rcvStudent.setAdapter(adapter);
  }

//    private void addDialog(){
//      DialogAddBinding addBinding=DialogAddBinding.inflate(getLayoutInflater());
//      Dialog dialog=new Dialog(MainActivity.this);
//      dialog.setContentView(addBinding.getRoot());
//      dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//
//      addBinding.dialogBtnAdd.setOnClickListener(v->{
//        String ms=addBinding.dialogEdMS.getText().toString().trim();
//        String tieude=addBinding.dialogEdTS.getText().toString().trim();
//        String tacgia=addBinding.dialogEdTG.getSelectedItem().toString().trim();
//        String nxb=addBinding.dialogEdNXB.getText().toString().trim();
//        String sotrang=addBinding.dialogEdST.getText().toString().trim();
//        String tl=addBinding.dialogEdLop.getText().toString().trim();
//        String sl=addBinding.dialogEdLop.getText().toString().trim();
//        String img=addBinding.dialogEdLop.getText().toString().trim();
//        String dg=addBinding.dialogEdLop.getText().toString().trim();
//
//        if (msv.isEmpty() || hoten.isEmpty() || gt.isEmpty() || ns.isEmpty() || kh.isEmpty() || lop.isEmpty()) {
//          Toast.makeText(this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
//        } else {
//          try {
//            double khoahoc=Double.parseDouble(kh);
//            Date ngaysinh=new SimpleDateFormat("dd-MM-yyyy").parse(ns);
//            Student student=new Student(msv, hoten, gt, ngaysinh, khoahoc, lop);
//            insertData(student);
//          } catch (Exception e) {
//            Toast.makeText(this, "Vui lòng nhập giá trị là số nguyên", Toast.LENGTH_SHORT).show();
//            Log.e("TAG Error", "addDialog: "+e.getMessage());
//          }
//        }
//      });
//
//      addBinding.dialogBtnCancel.setOnClickListener(v->{
//        dialog.dismiss();
//      });
//      dialog.show();
//    }

//    private void insertData(Student student){
//      request.callAPI().postData(student).enqueue(new Callback<Student>(){
//        @Override
//        public void onResponse(Call<Student> call, Response<Student> response){
//          if (response.isSuccessful()) {
//            Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
//          } else {
//            Toast.makeText(MainActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
//            Log.e("TAG Error", "onResponse: "+response.errorBody());
//          }
//        }
//
//        @Override
//        public void onFailure(Call<Student> call, Throwable t){
//          Toast.makeText(MainActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
//          Log.e("TAG Error", "onFailure: "+t.getMessage());
//        }
//      });
//    }

  private void dataSelect(EditText ed){
    Calendar calendar=Calendar.getInstance();
    int day=calendar.get(Calendar.DAY_OF_MONTH);
    int month=calendar.get(Calendar.MONTH);
    int year=calendar.get(Calendar.YEAR);
    DatePickerDialog picker=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener(){
      @Override
      public void onDateSet(DatePicker datePicker, int i, int i1, int i2){
        calendar.set(i, i1, i2);
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        ed.setText(dateFormat.format(calendar.getTime()));
      }
    }, year, month, day);
    picker.show();
  }
}