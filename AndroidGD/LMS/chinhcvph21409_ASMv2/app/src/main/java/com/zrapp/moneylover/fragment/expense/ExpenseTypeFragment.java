package com.zrapp.moneylover.fragment.expense;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.zrapp.moneylover.SQLite.extDAO;
import com.zrapp.moneylover.adapter.extAdapter;
import com.zrapp.moneylover.model.ExpenseType;

import java.util.ArrayList;

public class ExpenseTypeFragment extends Fragment {
    RecyclerView rcv;
    FloatingActionButton btnAdd;

    extAdapter adapter;
    ArrayList<ExpenseType> list;
    extDAO extDAO;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ex_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        extDAO = new extDAO(getActivity());
        rcv = view.findViewById(R.id.rcv_ex_type);
        show();

        /* Bắt đầu xử lý thao tác vuốt RCV */
        swipeLeft(view);
        swipeRight();
        /* Kết thúc xử lý thao tác vuốt RCV */

        btnAdd = view.findViewById(R.id.ex_t_btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDialog();
            }
        });
    }

    //Xử lý vuốt sang trái - Để xoá
    public void swipeLeft(View view) {
        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int postion = viewHolder.getAdapterPosition();
                if (extDAO.getExs(list.get(postion).getId()).size() != 0) {
                    Toast.makeText(getActivity(), "Không xoá được - Tồn tại khoản chi", Toast.LENGTH_LONG).show();
                    show();
                } else {
                    String type = list.get(postion).getName();
                    extDAO.delete(list.get(postion).getId());
                    show();
                    Snackbar snackbar = Snackbar
                            .make(view, "Đã xoá", Snackbar.LENGTH_LONG)
                            .setAction("Hoàn tác", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    extDAO.insert(type);
                                    show();
                                }
                            });
                    snackbar.show();
                }
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
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_add_ex_t);

        final View mainView = getLayoutInflater().inflate(R.layout.activity_main, null);
        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dialog.dismiss();
                return true;
            }
        });

        TextInputLayout layout = dialog.findViewById(R.id.dialog_add_ex_t_ed);
        EditText ed = layout.getEditText();
        Button btn = dialog.findViewById(R.id.dialog_add_ex_t_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed.getText().toString().isEmpty()) {
                    layout.setError("Vui lòng nhập loại chi");
                } else {
                    extDAO.insert(ed.getText().toString());
                    show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    public void updateDialog(int postion) {
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_update_ex_t);

        final View mainView = getLayoutInflater().inflate(R.layout.activity_main, null);
        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dialog.dismiss();
                return true;
            }
        });

        TextInputLayout layout = dialog.findViewById(R.id.dialog_update_ex_t_ed);
        EditText ed = layout.getEditText();
        Button btn = dialog.findViewById(R.id.dialog_update_ex_t_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed.getText().toString().isEmpty()) {
                    layout.setError("Vui lòng nhập loại chi");
                } else {
                    extDAO.update(list.get(postion).getId(), ed.getText().toString());
                    show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }


    public void show() {
        list = extDAO.getALL();
        adapter = new extAdapter(list, R.layout.row_t_view, getActivity());
        rcv.setAdapter(adapter);
    }
}
