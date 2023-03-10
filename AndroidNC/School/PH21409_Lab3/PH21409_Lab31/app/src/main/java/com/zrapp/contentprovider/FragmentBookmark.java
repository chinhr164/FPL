package com.zrapp.contentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentBookmark extends Fragment {

    public FragmentBookmark() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bookmark, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> list = new ArrayList<>();
        list.add("Chưa code được!!!");
        ListView lv = view.findViewById(R.id.lv_bookmark);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
    }
}