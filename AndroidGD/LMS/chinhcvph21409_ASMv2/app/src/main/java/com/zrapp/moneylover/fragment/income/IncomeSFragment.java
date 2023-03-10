package com.zrapp.moneylover.fragment.income;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
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

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.zrapp.moneylover.R;
import com.zrapp.moneylover.SQLite.insDAO;
import com.zrapp.moneylover.SQLite.intDAO;
import com.zrapp.moneylover.adapter.exsAdapter;
import com.zrapp.moneylover.adapter.insAdapter;
import com.zrapp.moneylover.model.ExpenseType;
import com.zrapp.moneylover.model.Expenses;
import com.zrapp.moneylover.model.IncomeType;
import com.zrapp.moneylover.model.Incomes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class IncomeSFragment extends Fragment {
    RecyclerView rcv;
    FloatingActionButton btnAdd;

    insAdapter adapter;
    ArrayList<Incomes> list;
    insDAO insDAO;
    intDAO intDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_in_s, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        insDAO = new insDAO(getActivity());
        intDAO = new intDAO(getActivity());
        rcv = view.findViewById(R.id.rcv_in_s);
        show();

        /* Bắt đầu xử lý thao tác vuốt RCV */
        swipeLeft(view);
        swipeRight();
        /* Kết thúc xử lý thao tác vuốt RCV */

        btnAdd = view.findViewById(R.id.in_s_btnAdd);
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
                Incomes incomes = list.get(postion);
                insDAO.delete(list.get(postion).getId());
                show();
                Snackbar snackbar = Snackbar
                        .make(view, "Đã xoá", Snackbar.LENGTH_LONG)
                        .setAction("Hoàn tác", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                insDAO.insert(incomes);
                                show();
                            }
                        });
                snackbar.show();
            }
        });
        touchHelper.attachToRecyclerView(rcv);
    }

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
        dialog.setContentView(R.layout.dialog_add_in_s);

        final View mainView = getLayoutInflater().inflate(R.layout.activity_main, null);
        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dialog.dismiss();
                return true;
            }
        });

        /* Bắt đầu xử lý Loại chi */
        ArrayList<String> listType = insDAO.getInt();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, listType);
        AutoCompleteTextView tvType = (AutoCompleteTextView) dialog.findViewById(R.id.dialog_add_in_s_autoType);
        tvType.setAdapter(adapter);
        /* Kết thúc xử lý Loại chi */

        TextInputLayout lType, lName, lDate, lPrice, lUser;
        lType = dialog.findViewById(R.id.dialog_add_in_s_type);
        lName = dialog.findViewById(R.id.dialog_add_in_s_edName);
        lPrice = dialog.findViewById(R.id.dialog_add_in_s_edPrice);
        lUser = dialog.findViewById(R.id.dialog_add_in_s_edUser);

        lDate = dialog.findViewById(R.id.dialog_add_in_s_edDate);
        lDate.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateSelect(lDate.getEditText());
            }
        });

        Button btn = dialog.findViewById(R.id.dialog_add_in_s_btn);
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
                    lType.setError("Vui lòng chọn Loại thu");
                } else {lType.setErrorEnabled(false);}

                if (name.isEmpty()) {
                    lName.setError("Vui lòng nhập Khoản thu");
                } else {lName.setErrorEnabled(false);}

                if (date.isEmpty()) {
                    lDate.setError("Vui lòng chọn Ngày thu");
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
                    lUser.setError("Vui lòng nhập Người thu");
                } else {lUser.setErrorEnabled(false);}

                if (!(type.isEmpty() || name.isEmpty() || date.isEmpty() || price.isEmpty() || user.isEmpty())) {
                    Incomes incomes = new Incomes();
                    incomes.setId_InT(intDAO.getALL().get(listType.indexOf(type)).getId());
                    incomes.setName(name);
                    incomes.setDate(date);
                    incomes.setPrice(Integer.parseInt(price));
                    incomes.setUser(user);
                    insDAO.insert(incomes);
                    show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    public void updateDialog(int postion) {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_update_in_s);

        final View mainView = getLayoutInflater().inflate(R.layout.activity_main, null);
        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dialog.dismiss();
                return true;
            }
        });

        /* Bắt đầu xử lý Loại chi */
        ArrayList<String> listType = insDAO.getInt();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, listType);
        AutoCompleteTextView tvType = (AutoCompleteTextView) dialog.findViewById(R.id.dialog_update_in_s_autoType);
        tvType.setAdapter(adapter);
        /* Kết thúc xử lý Loại chi */

        TextInputLayout lType, lName, lDate, lPrice, lUser;
        lType = dialog.findViewById(R.id.dialog_update_in_s_type);
        lName = dialog.findViewById(R.id.dialog_update_in_s_edName);
        lPrice = dialog.findViewById(R.id.dialog_update_in_s_edPrice);
        lUser = dialog.findViewById(R.id.dialog_update_in_s_edUser);

        lDate = dialog.findViewById(R.id.dialog_update_in_s_edDate);
        lDate.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateSelect(lDate.getEditText());
            }
        });

        // Gán lại dữ liệu
        Incomes incomes = list.get(postion);
        for (IncomeType in : intDAO.getALL()) {
            int i = incomes.getId_InT() - in.getId();
            if (i == 0) {
                tvType.setText(in.getName());
                break;
            }
        }
        lName.getEditText().setText(incomes.getName());
        lDate.getEditText().setText(incomes.getDate());
        lPrice.getEditText().setText(incomes.getPrice() + "");
        lUser.getEditText().setText(incomes.getUser());

        Button btn = dialog.findViewById(R.id.dialog_update_in_s_btn);
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
                    lType.setError("Vui lòng chọn Loại thu");
                } else {lType.setErrorEnabled(false);}

                if (name.isEmpty()) {
                    lName.setError("Vui lòng nhập Khoản thu");
                } else {lName.setErrorEnabled(false);}

                if (date.isEmpty()) {
                    lDate.setError("Vui lòng chọn Ngày thu");
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
                    lUser.setError("Vui lòng nhập Người thu");
                } else {lUser.setErrorEnabled(false);}

                if (!(type.isEmpty() || name.isEmpty() || date.isEmpty() || price.isEmpty() || user.isEmpty())) {
                    Incomes incomes = new Incomes();
                    incomes.setId_InT(intDAO.getALL().get(listType.indexOf(type)).getId());
                    incomes.setName(name);
                    incomes.setDate(date);
                    incomes.setPrice(Integer.parseInt(price));
                    incomes.setUser(user);
                    insDAO.update(list.get(postion).getId(), incomes);
                    show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    public void show() {
        list = insDAO.getAll();
        adapter = new insAdapter(list, R.layout.row_s_in_view, getActivity());
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
