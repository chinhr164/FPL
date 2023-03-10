package com.example.ph21409_final_cp17306;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PH21409_Database_CP17306 extends SQLiteOpenHelper {
        private static final String PH21409_DB_NAME_CP17306 = "ProductManage";
        private static final int PH21409_VERSION_CP17306 = 1;

        public PH21409_Database_CP17306(Context context) {
            super(context, PH21409_DB_NAME_CP17306, null, PH21409_VERSION_CP17306);
        }

        public void PH21409_queryData(String sql) {
            SQLiteDatabase PH21409_db_CP17306 = getWritableDatabase();
            PH21409_db_CP17306.execSQL(sql);
        }

        public Cursor PH21409_getData(String sql) {
            SQLiteDatabase PH21409_db_CP17306 = getWritableDatabase();
            return PH21409_db_CP17306.rawQuery(sql, null);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

