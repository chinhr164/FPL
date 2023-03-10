package com.example.demo51;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class demo51_man2 extends AppCompatActivity {
    TextView tv1, tv2;
    Button btn1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo51_man2);

        tv1 = findViewById(R.id.demo51_man2_tv1);
        tv2 = findViewById(R.id.demo51_man2_tv2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            String t1 = bundle.getString("tk");
            String t2 = bundle.getString("mk");

            tv1.setText(t1);
            tv2.setText(t2);

            btn1 = findViewById(R.id.demo51_man2_btn1);
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(getApplicationContext(), demo51_man3.class);
                    Bundle bundle1 = new Bundle();
                    if (t1.equalsIgnoreCase("admin")
                            && t2.equalsIgnoreCase("admin"))
                        bundle1.putString("result", "Đăng nhập thành công!");
                    else
                        bundle1.putString("result", "Đăng nhập thất bại!");
                    intent1.putExtras(bundle1);
                    startActivity(intent1);
                }
            });
        }
    }

}