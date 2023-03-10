package com.zrapp.entertainment.Frag;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.zrapp.entertainment.R;
import com.zrapp.entertainment.Services.NewsService;

public class FragNewsICT extends Fragment {
    RecyclerView rcv;
    NewsService service;
    ServiceConnection sv_conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            NewsService.LocalBinder localBinder = (NewsService.LocalBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {}
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_news_ict, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        service = new NewsService();
        Intent intentService = new Intent(getActivity(), NewsService.class);
        getContext().bindService(intentService, sv_conn, Context.BIND_AUTO_CREATE);
        service = new NewsService(getContext());
        rcv = view.findViewById(R.id.rcv_news_ict);
        service.loadNews("https://vnexpress.net/rss/so-hoa.rss", rcv);
    }
}

