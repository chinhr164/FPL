package com.zrapp.noteclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    NoteAdapter adapter;
    ArrayList<Notes> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv = findViewById(R.id.rcv);
        list = new ArrayList<>();
        show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        show();
    }

    public void show() {
        Uri uri0001 = Uri.parse("content://com.zrapp.notecontent/tb_GhiChu");
        Cursor c = getContentResolver().query(uri0001, null, null, null, null);
        list.clear();
        c.moveToFirst();
        while (!c.isAfterLast()) {
            Notes note = new Notes();
            note.setId(c.getInt(0));
            note.setTitle(c.getString(1));
            note.setContent(c.getString(2));
            list.add(note);
            c.moveToNext();
        }
        adapter = new NoteAdapter(list, R.layout.row_item_view, MainActivity.this);
        rcv.setAdapter(adapter);
    }
}