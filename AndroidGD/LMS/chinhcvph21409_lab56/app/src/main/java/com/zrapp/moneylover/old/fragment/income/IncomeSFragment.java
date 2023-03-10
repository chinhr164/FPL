package com.zrapp.moneylover.old.fragment.income;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zrapp.moneylover.old.R;

public class IncomeSFragment extends Fragment {
    FloatingActionButton btnAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_in_s, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnAdd = view.findViewById(R.id.in_s_btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDialog();
            }
        });
    }

    public void addDialog() {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_add_in_s);

        final View mainView = getLayoutInflater().inflate(R.layout.activity_main, null);
        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dialog.dismiss();
                return true;
            }
        });

        Button btn = dialog.findViewById(R.id.dialog_add_in_s_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Thêm thành công", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}