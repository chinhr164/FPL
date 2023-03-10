package com.zrapp.contentprovider;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FragmentMedia extends Fragment {
    public FragmentMedia() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_media, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> list = new ArrayList<>();
        String[] projection = {
                MediaStore.MediaColumns.DISPLAY_NAME,
                MediaStore.MediaColumns.DATE_ADDED,
                MediaStore.MediaColumns.DATA
        };
        Cursor c = getContext().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            String s = "";
            s += c.getString(0) + " - ";
            String date = c.getString(1);
            long seconds = Long.parseLong(date);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            s += formatter.format(new Date(seconds));
            s += " - " + c.getString(2);
            s += "\n";

            c.moveToNext();
            list.add(s);
        }
        c.close();
        ListView lv = view.findViewById(R.id.lv_media);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
    }
}