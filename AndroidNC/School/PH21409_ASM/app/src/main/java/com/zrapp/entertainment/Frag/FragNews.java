package com.zrapp.entertainment.Frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.zrapp.entertainment.Pager.NewsPager;
import com.zrapp.entertainment.R;

public class FragNews extends Fragment {
    public FragNews() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Xử lý Actionbar
//        TextView tv = getActivity().findViewById(R.id.tv_tb);
//        tv.setText("vnExpress");
//        tv.setTextSize(25);
//        tv.setGravity(Gravity.CENTER);

        ViewPager2 pager = view.findViewById(R.id.vp_news);
        NewsPager adapter = new NewsPager(this);
        pager.setAdapter(adapter);

        TabLayout layout = view.findViewById(R.id.tabl_news);
        new TabLayoutMediator(layout, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Số hoá");
                        break;
                    case 1:
                        tab.setText("Đời sống");
                        break;
                    case 2:
                        tab.setText("Du lịch");
                        break;
                }
            }
        }).attach();
    }
}
