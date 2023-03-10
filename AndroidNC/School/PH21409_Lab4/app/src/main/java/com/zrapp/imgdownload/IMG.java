package com.zrapp.imgdownload;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class IMG extends AppCompatActivity {

    String TAG = "KiểmTraNetwork";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);

        TextInputLayout lbUrl = findViewById(R.id.Url);
        Button btnDownload = findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkNetwork()) {
                    String link = lbUrl.getEditText().getText().toString();
                    if (link.isEmpty()) {
                        Toast.makeText(IMG.this, "Chưa điền link mà >.<!", Toast.LENGTH_LONG).show();
                    } else {
                        new DownloadImg().execute(link);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Đã kết nối Internet đâu >.<!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean checkNetwork() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        boolean isWifi = netInfo.isConnected();
        netInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobile = netInfo.isConnected();
        if (isWifi)
            Log.i(TAG, "checkNetwork: Kết nối WIFI");
        if (isMobile)
            Log.i(TAG, "checkNetwork: Kết nối MOBILE");
        return isWifi || isMobile;
    }

    class DownloadImg extends AsyncTask<String, Void, Bitmap> {
        InputStream inputStream;
        Bitmap bitmap;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("KiểmTraDownload", "onPreExecute: bắt đầu download ");
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Log.d("KiểmTraDownload", "doInBackground: đang download " + strings[0]);
            try {
                URL url = new URL(strings[0]);
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();

                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.connect();

                int status = httpsURLConnection.getResponseCode();
                if (status == HttpsURLConnection.HTTP_OK) {
                    inputStream = httpsURLConnection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                }
                httpsURLConnection.disconnect();
                inputStream.close();
                Log.i(TAG, "doInBackground: dừng");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            Log.d("KiểmTraDownload", "onPostExecute: Download xong rồi ");
            ImageView imageView = findViewById(R.id.imgV);
            imageView.setImageBitmap(bitmap);
        }
    }
}