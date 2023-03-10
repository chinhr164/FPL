package com.zrapp.entertainment.Async;

import android.os.AsyncTask;

import androidx.recyclerview.widget.RecyclerView;

import com.zrapp.entertainment.Activity.MainActivity;
import com.zrapp.entertainment.Adapter.NewsAdapter;
import com.zrapp.entertainment.Loader.NewsLoader;
import com.zrapp.entertainment.Model.News;
import com.zrapp.entertainment.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NewsDownload extends AsyncTask<String, Void, ArrayList<News>> {
    MainActivity activity;
    RecyclerView rcv;

    public NewsDownload(MainActivity activity, RecyclerView rcv) {
        this.activity = activity;
        this.rcv = rcv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<News> doInBackground(String... strings) {
        NewsLoader loader = new NewsLoader();
        ArrayList<News> list = new ArrayList<>();
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
    protected void onPostExecute(ArrayList<News> news) {
        super.onPostExecute(news);
        NewsAdapter adapter = new NewsAdapter(news, activity, R.layout.item_row_news);
        rcv.setAdapter(adapter);
    }
}
