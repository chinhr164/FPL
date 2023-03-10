package com.zrapp.moneylover.fragment.expense;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.zrapp.moneylover.R;
import com.zrapp.moneylover.SQLite.exsDAO;
import com.zrapp.moneylover.SQLite.extDAO;
import com.zrapp.moneylover.adapter.exsAdapter;
import com.zrapp.moneylover.model.ExpenseType;
import com.zrapp.moneylover.model.Expenses;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ExpenseSFragment extends Fragment {
    RecyclerView rcv;
    FloatingActionButton btnAdd;

    exsAdapter adapter;
    ArrayList<Expenses> list;
    exsDAO exsDAO;
    extDAO extDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ex_s, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        exsDAO = new exsDAO(getActivity());
        extDAO = new extDAO(getActivity());
        rcv = view.findViewById(R.id.rcv_ex_s);
        show();

        /* Bắt đầu xử lý thao tác vuốt RCV */
        swipeLeft(view);
        swipeRight();
        /* Kết thúc xử lý thao tác vuốt RCV */

        btnAdd = view.findViewById(R.id.ex_s_btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDialog();
            }
        });
    }

    public void swipeLeft(View view) {
        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int postion = viewHolder.getAdapterPosition();
                Expenses exs = list.get(postion);
                exsDAO.delete(list.get(postion).getId());
                show();
                Snackbar snackbar = Snackbar
                        .make(view, "Đã xoá", Snackbar.LENGTH_LONG)
                        .setAction("Hoàn tác", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                exsDAO.insert(exs);
                                show();
                            }
                        });
                snackbar.show();
            }
        });
        touchHelper.attachToRecyclerView(rcv);
    }

    //Xử lý vuốt sang phải - Để sửa
    public void swipeRight() {
        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int postion = viewHolder.getAdapterPosition();
                show();
                updateDialog(postion);
            }
        });
        touchHelper.attachToRecyclerView(rcv);
    }

    public void addDialog() {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_add_ex_s);

        final View mainView = getLayoutInflater().inflate(R.layout.activity_main, null);
        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dialog.dismiss();
                return true;
            }
        });

        /* Bắt đầu xử lý Loại chi */
        ArrayList<String> listType = exsDAO.getExt();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, listType);
        AutoCompleteTextView tvType = (AutoCompleteTextView) dialog.findViewById(R.id.dialog_add_ex_s_autoType);
        tvType.setAdapter(adapter);
        /* Kết thúc xử lý Loại chi */

        TextInputLayout lType, lName, lDate, lPrice, lUser;
        lType = dialog.findViewById(R.id.dialog_add_ex_s_type);
        lName = dialog.findViewById(R.id.dialog_add_ex_s_edName);
        lPrice = dialog.findViewById(R.id.dialog_add_ex_s_edPrice);
        lUser = dialog.findViewById(R.id.dialog_add_ex_s_edUser);

        lDate = dialog.findViewById(R.id.dialog_add_ex_s_edDate);
        lDate.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateSelect(lDate.getEditText());
            }
        });

        Button btn = dialog.findViewById(R.id.dialog_add_ex_s_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type, name, date, price, user;
                type = tvType.getText().toString();
                name = lName.getEditText().getText().toString();
                date = lDate.getEditText().getText().toString();
                price = lPrice.getEditText().getText().toString();
                user = lUser.getEditText().getText().toString();

                if (type.isEmpty()) {
                    lType.setError("Vui lòng chọn Loại chi");
                } else {lType.setErrorEnabled(false);}

                if (name.isEmpty()) {
                    lName.setError("Vui lòng nhập Khoản chi");
                } else {lName.setErrorEnabled(false);}

                if (date.isEmpty()) {
                    lDate.setError("Vui lòng chọn Ngày chi");
                    lDate.setErrorIconDrawable(R.drawable.ic_calendar);
                    lDate.setErrorIconOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {dateSelect(lDate.getEditText());}
                    });
                } else {lDate.setErrorEnabled(false);}

                if (price.isEmpty()) {
                    lPrice.setError("Vui lòng nhập Số tiền");
                } else {lPrice.setErrorEnabled(false);}

                if (user.isEmpty()) {
                    lUser.setError("Vui lòng nhập Người chi");
                } else {lUser.setErrorEnabled(false);}

                if (!(type.isEmpty() || name.isEmpty() || date.isEmpty() || price.isEmpty() || user.isEmpty())) {
                    Expenses exs = new Expenses();
                    exs.setId_ExT(extDAO.getALL().get(listType.indexOf(type)).getId());
                    exs.setName(name);
                    exs.setDate(date);
                    exs.setPrice(Integer.parseInt(price));
                    exs.setUser(user);
                    exsDAO.insert(exs);
                    show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    public void updateDialog(int postion) {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_update_ex_s);

        final View mainView = getLayoutInflater().inflate(R.layout.activity_main, null);
        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dialog.dismiss();
                return true;
            }
        });

        /* Bắt đầu xử lý Loại chi */
        ArrayList<String> listType = exsDAO.getExt();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, listType);
        AutoCompleteTextView tvType = (AutoCompleteTextView) dialog.findViewById(R.id.dialog_update_ex_s_autoType);
        tvType.setAdapter(adapter);
        /* Kết thúc xử lý Loại chi */

        TextInputLayout lType, lName, lDate, lPrice, lUser;
        lType = dialog.findViewById(R.id.dialog_update_ex_s_type);
        lName = dialog.findViewById(R.id.dialog_update_ex_s_edName);
        lPrice = dialog.findViewById(R.id.dialog_update_ex_s_edPrice);
        lUser = dialog.findViewById(R.id.dialog_update_ex_s_edUser);

        lDate = dialog.findViewById(R.id.dialog_update_ex_s_edDate);
        lDate.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateSelect(lDate.getEditText());
            }
        });

        // Gán lại dữ liệu
        Expenses expenses = list.get(postion);
        for (ExpenseType e : extDAO.getALL()) {
            int i = expenses.getId_ExT() - e.getId();
            if (i == 0) {
                tvType.setText(e.getName());
                break;
            }
        }
        lName.getEditText().setText(expenses.getName());
        lDate.getEditText().setText(expenses.getDate());
        lPrice.getEditText().setText(expenses.getPrice() + "");
        lUser.getEditText().setText(expenses.getUser());

        Button btn = dialog.findViewById(R.id.dialog_update_ex_s_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type, name, date, price, user;
                type = tvType.getText().toString();
                name = lName.getEditText().getText().toString();
                date = lDate.getEditText().getText().toString();
                price = lPrice.getEditText().getText().toString();
                user = lUser.getEditText().getText().toString();


                if (type.isEmpty()) {
                    lType.setError("Vui lòng chọn Loại chi");
                } else {lType.setErrorEnabled(false);}

                if (name.isEmpty()) {
                    lName.setError("Vui lòng nhập Khoản chi");
                } else {lName.setErrorEnabled(false);}

                if (date.isEmpty()) {
                    lDate.setError("Vui lòng chọn Ngày chi");
                    lDate.setErrorIconDrawable(R.drawable.ic_calendar);
                    lDate.setErrorIconOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {dateSelect(lDate.getEditText());}
                    });
                } else {lDate.setErrorEnabled(false);}

                if (price.isEmpty()) {
                    lPrice.setError("Vui lòng nhập Số tiền");
                } else {lPrice.setErrorEnabled(false);}

                if (user.isEmpty()) {
                    lUser.setError("Vui lòng nhập Người chi");
                } else {lUser.setErrorEnabled(false);}

                if (!(type.isEmpty() || name.isEmpty() || date.isEmpty() || price.isEmpty() || user.isEmpty())) {

                    Expenses exs = new Expenses();
                    exs.setId_ExT(extDAO.getALL().get(listType.indexOf(type)).getId());
                    exs.setName(name);
                    exs.setDate(date);
                    exs.setPrice(Integer.parseInt(price));
                    exs.setUser(user);
                    exsDAO.update(list.get(postion).getId(), exs);
                    show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    public void show() {
        list = exsDAO.getAll();
        adapter = new exsAdapter(list, R.layout.row_s_ex_view, getActivity());
        rcv.setAdapter(adapter);
    }

    public void dateSelect(EditText ed) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog picker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
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
