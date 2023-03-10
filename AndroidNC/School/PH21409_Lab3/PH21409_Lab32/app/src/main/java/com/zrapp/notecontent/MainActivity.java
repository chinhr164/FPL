package com.zrapp.notecontent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    FloatingActionButton btnAdd;

    NoteAdapter adapter;
    ArrayList<Notes> list;
    DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao = new DAO(MainActivity.this);
        rcv = findViewById(R.id.rcv);
        show();

        /*Bắt đầu xử lý thao tác vuốt RCV*/
        swipeLeft(getCurrentFocus());
        swipeRight();
        /*Kết thúc xử lý thao tác vuốt RCV*/

        btnAdd = findViewById(R.id.btnAdd);
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
                dao.delete(list.get(postion).getId());
                show();
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
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_add);

        final View mainView = getLayoutInflater().inflate(R.layout.activity_main, null);
        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dialog.dismiss();
                return true;
            }
        });

        TextInputLayout lTitle, lContent, lDate;
        lTitle = dialog.findViewById(R.id.dialog_add_Title);
        lContent = dialog.findViewById(R.id.dialog_add_Content);

        lDate = dialog.findViewById(R.id.dialog_add_Date);
        lDate.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateSelect(lDate.getEditText());
            }
        });

        Button btn = dialog.findViewById(R.id.dialog_add_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title, content, date;
                title = lTitle.getEditText().getText().toString();
                content = lContent.getEditText().getText().toString();
                date = lDate.getEditText().getText().toString();


                if (title.isEmpty()) {
                    lTitle.setError("Vui lòng nhập Tiêu đề");
                } else {lTitle.setErrorEnabled(false);}

                if (content.isEmpty()) {
                    lContent.setError("Vui lòng nhập Nội dung");
                } else {lContent.setErrorEnabled(false);}

                if (date.isEmpty()) {
                    lDate.setError("Vui lòng chọn Ngày chi");
                    lDate.setErrorIconDrawable(R.drawable.ic_calendar);
                    lDate.setErrorIconOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {dateSelect(lDate.getEditText());}
                    });
                } else {lDate.setErrorEnabled(false);}


                if (!(title.isEmpty() || content.isEmpty() || date.isEmpty())) {
                    Notes note = new Notes();
                    note.setTieuDe(title);
                    note.setNgayThang(date);
                    note.setNoiDung(content);
                    dao.insert(note);
                    show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }


    public void updateDialog(int postion) {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_update);

        final View mainView = getLayoutInflater().inflate(R.layout.activity_main, null);
        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dialog.dismiss();
                return true;
            }
        });

        TextInputLayout lTitle, lContent, lDate;
        lTitle = dialog.findViewById(R.id.dialog_update_Title);
        lContent = dialog.findViewById(R.id.dialog_update_Content);

        lDate = dialog.findViewById(R.id.dialog_update_Date);
        lDate.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateSelect(lDate.getEditText());
            }
        });

        // Gán lại dữ liệu
        Notes n = list.get(postion);
        lTitle.getEditText().setText(n.getTieuDe());
        lContent.getEditText().setText(n.getNoiDung());
        lDate.getEditText().setText(n.getNgayThang());

        Button btn = dialog.findViewById(R.id.dialog_update_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title, content, date;
                title = lTitle.getEditText().getText().toString();
                content = lContent.getEditText().getText().toString();
                date = lDate.getEditText().getText().toString();


                if (title.isEmpty()) {
                    lTitle.setError("Vui lòng nhập Tiêu đề");
                } else {lTitle.setErrorEnabled(false);}

                if (content.isEmpty()) {
                    lContent.setError("Vui lòng nhập Nội dung");
                } else {lContent.setErrorEnabled(false);}

                if (date.isEmpty()) {
                    lDate.setError("Vui lòng chọn Ngày chi");
                    lDate.setErrorIconDrawable(R.drawable.ic_calendar);
                    lDate.setErrorIconOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {dateSelect(lDate.getEditText());}
                    });
                } else {lDate.setErrorEnabled(false);}


                if (!(title.isEmpty() || content.isEmpty() || date.isEmpty())) {
                    Notes note = new Notes();
                    note.setTieuDe(title);
                    note.setNgayThang(date);
                    note.setNoiDung(content);
                    dao.update(list.get(postion).getId(), note);
                    show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    public void show() {
        list = dao.getAll();
        adapter = new NoteAdapter(list, R.layout.row_item_view, MainActivity.this);
        rcv.setAdapter(adapter);
    }

    public void dateSelect(EditText ed) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog picker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
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