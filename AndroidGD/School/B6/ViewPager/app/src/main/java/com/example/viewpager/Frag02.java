package com.example.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag02 extends Fragment {
    public TextView tv_frag02;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //khởi tạo layout Fragment
        return inflater.inflate(R.layout.frag02, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //Các lệnh tương tác với view
        super.onViewCreated(view, savedInstanceState);
        tv_frag02 = view.findViewById(R.id.tv_Frag02);
    }
}
