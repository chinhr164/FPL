package com.example.viewpager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Frag01 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //khởi tạo layout Fragment
        return inflater.inflate(R.layout.frag01, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //Các lệnh tương tác với view
        super.onViewCreated(view, savedInstanceState);
        Button btnF1 = view.findViewById(R.id.btnF1);
        btnF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                @SuppressLint("ResourceType") Frag02 frag02 = (Frag02) fm.findFragmentById(R.layout.frag02);
                frag02.tv_frag02.setText("Gửi dữ liệu thành công");
            }
        });
    }
}
