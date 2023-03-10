package com.zrapp.notecontent;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NoteContentProvider extends ContentProvider {
    public static String AUTHOR = "com.zrapp.notecontent";
    public static String TB_GhiChu = "tb_GhiChu";

    UriMatcher uriMatcher;
    DAO dao;
    Cursor cursor;

    @Override
    public boolean onCreate() {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHOR, TB_GhiChu, 1);
        uriMatcher.addURI(AUTHOR, TB_GhiChu + "/#", 2);

        dao = new DAO(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        int code_uri_matcher = uriMatcher.match(uri);

        switch (code_uri_matcher) {
            case 1:
                cursor = dao.providerSelectAll(strings, s, strings1, s1);
                break;

            case 2:
                String strWhere = "id = " + uri.getPathSegments().get(1);
                cursor = dao.providerSelectAll(strings, strWhere, strings1, s1);
                break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
