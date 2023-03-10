package com.zrapp.entertainment.SQLite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.zrapp.entertainment.Model.Song;
import com.zrapp.entertainment.Model.User;
import com.zrapp.entertainment.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DAO {
    Context context;
    private DbHelper dbHelper;

    public DAO(Context context) {
        this.context = context;
        this.dbHelper = new DbHelper(context);
    }

    @SuppressLint("Range")
    public User getUser(String str) {
        User user = new User();
        Cursor c = dbHelper.getData("SELECT * FROM User WHERE username = '" + str + "'");
        c.moveToFirst();
        user.setUsername(c.getString(0));
        user.setPassword(c.getString(1));
        user.setName(c.getString(2));
        user.setTel(c.getString(3));
        user.setEmail(c.getString(4));
        user.setAvatar(c.getBlob(c.getColumnIndex("avatar")));
        user.setCover(c.getBlob(c.getColumnIndex("cover")));
        return user;
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO User VALUES(?,?,?,?,?,?,?)";
        SQLiteStatement statement = dbHelper.queryData().compileStatement(sql);
        statement.bindString(1, user.getUsername());
        statement.bindString(2, user.getPassword());
        statement.bindString(3, user.getName());
        statement.bindString(4, user.getTel());
        statement.bindString(5, user.getEmail());
        statement.bindBlob(6, getBlob(R.drawable.ava_default));
        statement.bindBlob(7, getBlob(R.drawable.cover_default));
        statement.executeInsert();
    }

    public void updateUser(User user, String username) {
        String sql = "UPDATE User SET " +
                "name=?," +
                "tel=?," +
                "email=? " +
                "WHERE username=?";
        SQLiteStatement statement = dbHelper.queryData().compileStatement(sql);
        statement.bindString(1, user.getName());
        statement.bindString(2, user.getTel());
        statement.bindString(3, user.getEmail());
        statement.bindString(4, username);
        statement.executeUpdateDelete();
    }

    public void updateIMG(String str, User user, byte[] img) {
        String sql = "UPDATE User SET " +
                str + "=? " +
                "WHERE username=?";
        SQLiteStatement statement = dbHelper.queryData().compileStatement(sql);
        statement.bindBlob(1, img);
        statement.bindString(2, user.getUsername());
        statement.executeUpdateDelete();
    }

    public void updatePass(String pass, String username) {
        String sql = "UPDATE User SET " +
                "password=? " +
                "WHERE username=?";
        SQLiteStatement statement = dbHelper.queryData().compileStatement(sql);
        statement.bindString(1, pass);
        statement.bindString(2, username);
        statement.executeUpdateDelete();
    }

    public boolean isNotEXISTS(String str) {
        if (dbHelper.getData("SELECT * FROM User WHERE username = '" + str + "'").getCount() == 0)
            return true;
        return false;
    }

    public byte[] getBlob(int img) {
        //Chuyển ImageView -> byte[]
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), img);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
        return byteArray.toByteArray();
    }

    public ArrayList<Song> getFavorList() {
        ArrayList<Song> list = new ArrayList<>();
        Cursor c = dbHelper.getData("SELECT * FROM Favor");
        c.moveToFirst();
        while (!c.isAfterLast()) {
            Song song = new Song();
            song.setId(c.getInt(0));
            song.setTitle(c.getString(1));
            song.setArtist(c.getString(2));
            song.setPath(c.getString(3));
//            song.setFavorite(c.getLong(4));
            list.add(song);
            c.moveToNext();
        }
        c.close();
        return list;
    }

    public void insertFavorSong(Song song) {
        String sql = "INSERT INTO Favor VALUES(null,?,?,?)";
        SQLiteStatement statement = dbHelper.queryData().compileStatement(sql);
        statement.bindString(1, song.getTitle());
        statement.bindString(2, song.getArtist());
        statement.bindString(3, song.getPath());
//        statement.bindLong(3, song.getFavorite());
        statement.executeInsert();
    }

    public void deleteFavor(double id) {
        String sql = "DELETE FROM Favor WHERE id = ?";
        SQLiteStatement statement = dbHelper.queryData().compileStatement(sql);
        statement.bindDouble(1, id);
        statement.executeUpdateDelete();
    }
}
