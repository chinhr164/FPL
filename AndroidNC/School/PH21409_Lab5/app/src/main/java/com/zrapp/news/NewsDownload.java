package com.zrapp.news;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NewsDownload extends AsyncTask<String, Void, ArrayList<NewsDTO>> {
    MainActivity activity;

    public NewsDownload(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected ArrayList<NewsDTO> doInBackground(String... strings) {
        NewsLoader loader = new NewsLoader();
        ArrayList<NewsDTO> list = new ArrayList<>();

        String urlRss = strings[0];
        try {
            URL url = new URL(urlRss);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                InputStream inputStream = urlConnection.getInputStream();
                list = loader.getList(inputStream);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void onPostExecute(ArrayList<NewsDTO> newsDTOS) {
        super.onPostExecute(newsDTOS);
        NewsAdapter adapter = new NewsAdapter(newsDTOS, activity, R.layout.item_row_web);
        RecyclerView rcv = activity.findViewById(R.id.rcv);
        rcv.setAdapter(adapter);
    }
}
