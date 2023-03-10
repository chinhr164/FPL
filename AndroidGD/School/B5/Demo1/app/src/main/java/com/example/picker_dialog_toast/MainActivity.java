package com.example.picker_dialog_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText ed_name, ed_birth, ed_email, ed_tk, ed_mk, ed_xnmk;
    ImageView ibtn_calendar;
    Button btn_dk;

    Calendar calendar;
    int day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_name = findViewById(R.id.ed_name);
        ed_birth = findViewById(R.id.ed_birth);
        ed_email = findViewById(R.id.ed_email);
        ed_tk = findViewById(R.id.ed_tk);
        ed_mk = findViewById(R.id.ed_mk);
        ed_xnmk = findViewById(R.id.ed_xnmk);

        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        ed_birth.setText(year + "-" + ((month + 1) > 9 ? (month + 1) : "0" + (month + 1)) + "-" + day);

        ibtn_calendar = findViewById(R.id.ibtn_calendar);
        ibtn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateSelect(ed_birth);
            }
        });

        btn_dk = findViewById(R.id.btn_dk);
        btn_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ed_name.getText().toString().trim();
                String birth = ed_birth.getText().toString().trim();
                String email = ed_email.getText().toString().trim();
                String tk = ed_tk.getText().toString().trim();
                String mk = ed_mk.getText().toString().trim();
                String xnmk = ed_xnmk.getText().toString().trim();

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date obj = format.parse(birth);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    birth = dateFormat.format(obj);

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (name.isEmpty() || email.isEmpty() || tk.isEmpty() || mk.isEmpty() || xnmk.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng điền đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if (!mk.equals(xnmk)) {
                    Toast.makeText(MainActivity.this, "Nhập lại mật khẩu chưa đúng", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
                    Log.i("Thông tin", "Họ tên: " + name);
                    Log.i("Thông tin", "Ngày sinh: " + birth);
                    Log.i("Thông tin", "Email: " + name);
                    Log.i("Thông tin", "Tài khoản: " + tk);
                    Log.i("Thông tin", "Mật khẩu: " + mk);
                }
            }
        });
    }

    public void dateSelect(EditText ed) {
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i, i1, i2);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                ed.setText(format.format(calendar.getTime()));
            }
        }, year, month, day);
        dialog.show();
    }
}