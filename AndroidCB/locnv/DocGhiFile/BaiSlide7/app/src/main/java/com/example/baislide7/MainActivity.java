package com.example.baislide7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Magnifier;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ghiVaoBoNhoCache(View view) {
        try {
            String data = "Thu ghi vao cache"; // bien string dung de luu thu
            String nameFile = "abc.cache";     //ten file cache
            File cacheFileDir = getCacheDir();  // lay vij tri thu muc cache
            File cacheFile = new File(cacheFileDir, nameFile);   //
            cacheFile.createNewFile();  //Tao file
            FileOutputStream stream = new FileOutputStream(cacheFile); //mo ket noi vao file de tien hanh ghi
            stream.write(data.getBytes()); // ghi du lieeu tu data vao file cache dang byes
            stream.close(); // dong ket noi
            Toast.makeText(this, "Ghi thành công!!!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
        }
    }

    public void docTUBoNhoCache(View view) {
        try {
            String nameFile = "abc.cache";     //ten file cache
            File cacheFileDir = getCacheDir();  // lay vij tri thu muc cache
            File cacheFile = new File(cacheFileDir, nameFile);   //
            cacheFile.createNewFile();  //Tao file
            FileInputStream stream = new FileInputStream(cacheFile); //mo ket noi vao file de tien hanh ghi
            Scanner scanner = new Scanner(stream);
            String dulieu = "";
            while (scanner.hasNext()) {
                dulieu = dulieu + scanner.nextLine();
            }
            scanner.close();

            Toast.makeText(this, dulieu, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
        }
    }

    public void ghiVaoBoNhoTrong(View view) {
        try {
            String data = " trung hieu test thu";
            String nameFile = "xinxin.txt";
            FileOutputStream fos = openFileOutput(nameFile, MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
            Toast.makeText(this, "Ghi thành công!!!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
        }
    }

    public void docTUBoNhoTrong(View view) {
        try {
            String nameFile = "xinxin.txt";
            FileInputStream fos = openFileInput(nameFile);

            Scanner scanner = new Scanner(fos);
            String dulieu = "";
            while (scanner.hasNext()) {
                dulieu = dulieu + scanner.nextLine();
            }
            scanner.close();
            Toast.makeText(this, dulieu, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
        }
    }

    public void ghiVaoBoNhoSharePre(View view) {
        String name = "van chinh";
        int age = 18;
        boolean gt = true;
        SharedPreferences preferences = getSharedPreferences("test.txt", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("gt", gt);
        editor.putInt("tuoi", age);
        editor.putString("name", name);
        editor.commit(); //== Save
        Toast.makeText(this, "Ghi thành công!!!", Toast.LENGTH_SHORT).show();
    }

    public void docTuBoNhoSharePre(View view) {
        SharedPreferences preferences = getSharedPreferences("test.txt", MODE_PRIVATE);
        String name = preferences.getString("name", null);
        int age = preferences.getInt("tuoi", -1);
        Boolean gt = preferences.getBoolean("gt", false);

        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(" - ");
        builder.append(age);
        builder.append(" - ");
        builder.append(gt);
        Toast.makeText(this, builder.toString(), Toast.LENGTH_SHORT).show();
    }

    public void ghiVaoTheNho(View view) {
        // 1: kiem tra xin quyen ghi tu nguoi dung app
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    999);
        } else {
            try {
                String path = Environment.getExternalStorageDirectory()
                        .getAbsolutePath()
                        + "/file.txt";
                FileOutputStream outputStream = new FileOutputStream(path);
                String data = "test thu vao the nho";
                outputStream.write(data.getBytes());
                outputStream.close();
            } catch (Exception e) {

            }
        }
    }

    public void docTuTheNho(View view) {
        // 1: kiem tra xin quyen ghi tu nguoi dung app
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 999);
        } else {
            try {
                String path = Environment.getExternalStorageDirectory()
                        .getAbsolutePath() + "/file.txt";
                FileInputStream stream = new FileInputStream(path);
                String data = "";
                Scanner scanner = new Scanner(stream);
                String duLieu = "";
                while (scanner.hasNext()) {
                    duLieu = duLieu + scanner.nextLine();
                }
                scanner.close();
                Toast.makeText(this, duLieu, Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
            }
        }
    }
}