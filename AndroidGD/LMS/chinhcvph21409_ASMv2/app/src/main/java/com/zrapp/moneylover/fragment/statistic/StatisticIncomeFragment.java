package com.zrapp.moneylover.fragment.statistic;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.zrapp.moneylover.R;
import com.zrapp.moneylover.SQLite.DbHelper;
import com.zrapp.moneylover.SQLite.insDAO;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class StatisticIncomeFragment extends Fragment {
    EditText ed_dateIn, ed_dateOut;
    ImageView btn_dateIn, btn_dateOut;
    Button btn_Fill;

    TextView tv_Qty, tv_Price;
    insDAO insDAO;

    Calendar calendar;
    int day, month, year;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_st_in, container, false);

        insDAO = new insDAO(getActivity());

        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        ed_dateIn = view.findViewById(R.id.ed_st_in_dateIn);
        ed_dateIn.setText(year + "-" +
                ((month + 1) > 9 ? (month + 1) : "0" + (month + 1)) + "-" +
                (day > 9 ? day : "0" + day));

        btn_dateIn = view.findViewById(R.id.btn_st_in_dateIn);
        btn_dateIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateSelect(ed_dateIn);
            }
        });

        ed_dateOut = view.findViewById(R.id.ed_st_in_dateOut);
        ed_dateOut.setText(year + "-" +
                ((month + 1) > 9 ? (month + 1) : "0" + (month + 1)) + "-" +
                (day > 9 ? day : "0" + day));

        btn_dateOut = view.findViewById(R.id.btn_st_in_dateOut);
        btn_dateOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateSelect(ed_dateOut);
            }
        });

        tv_Qty = view.findViewById(R.id.tv_st_in_qty);
        tv_Price = view.findViewById(R.id.tv_st_in_price);
        btn_Fill = view.findViewById(R.id.ed_st_in_btnFill);
        btn_Fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dateIn = ed_dateIn.getText().toString().trim();
                String dateOut = ed_dateOut.getText().toString().trim();

                String qty = insDAO.getSumQty(dateIn, dateOut);
                String price = NumberFormat.getInstance(new Locale("vi","VN")).format(insDAO.getSumPrice(dateIn, dateOut));

                tv_Qty.setText(qty);
                tv_Price.setText(price);
            }
        });

        return view;
    }

    public void dateSelect(EditText ed) {
        DatePickerDialog picker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i, i1, i2);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                ed.setText(dateFormat.format(calendar.getTime()));
            }
        }, year, month, day);
        picker.show();
    }
}