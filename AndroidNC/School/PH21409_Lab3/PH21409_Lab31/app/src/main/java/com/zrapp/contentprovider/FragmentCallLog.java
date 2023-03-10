package com.zrapp.contentprovider;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
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

public class FragmentCallLog extends Fragment {

    public FragmentCallLog() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_call_log, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> list = new ArrayList<>();
        String[] projection = new String[]{
                CallLog.Calls.DATE,
                CallLog.Calls.NUMBER,
                CallLog.Calls.DURATION
        };
        Cursor c = getContext().getContentResolver().query(
                CallLog.Calls.CONTENT_URI,
                projection,
                CallLog.Calls.DURATION + "<?", new String[]{"30"},
                CallLog.Calls.DATE + " Asc");
        c.moveToFirst();
        while (!c.isAfterLast()) {
            String s = "";
            String date = c.getString(0);
            long seconds = Long.parseLong(date);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy HH:mm");
            s = formatter.format(new Date(seconds));
            for (int i = 1; i < c.getColumnCount(); i++) {
                s += " - " + c.getString(i);
            }
            s += "s";
            s += "\n";
            c.moveToNext();
            list.add(s);
        }
        c.close();
        ListView lv = view.findViewById(R.id.lv_call_log);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
    }
}