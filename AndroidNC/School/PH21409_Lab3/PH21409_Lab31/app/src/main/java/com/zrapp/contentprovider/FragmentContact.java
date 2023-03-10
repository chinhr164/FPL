package com.zrapp.contentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentContact extends Fragment {

    public FragmentContact() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> list = new ArrayList<>();
        list.clear();
        Cursor c = getContext().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            String s = "";
            String idColName = ContactsContract.Contacts._ID;
            int idIndex = c.getColumnIndex(idColName);
            s = c.getString(idIndex) + " - ";
            String nameColName = ContactsContract.Contacts.DISPLAY_NAME;
            int nameIndex = c.getColumnIndex(nameColName);
            s += c.getString(nameIndex);
            c.moveToNext();
            list.add(s);
        }
        c.close();
        ListView lv = view.findViewById(R.id.lv_contact);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
    }
}