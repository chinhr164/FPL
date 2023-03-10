package com.zrapp.entertainment.Frag;

import static com.zrapp.entertainment.Services.MusicService.dao;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import com.zrapp.entertainment.Activity.InfoActivity;
import com.zrapp.entertainment.Activity.MainActivity;
import com.zrapp.entertainment.Activity.SignInActivity;
import com.zrapp.entertainment.R;
import com.zrapp.entertainment.Services.MusicService;
import com.zrapp.entertainment.Services.NewsService;
import com.zrapp.entertainment.databinding.FragMusicBinding;

public class FragMusic extends Fragment implements ImageView.OnClickListener {
    public static BottomSheetBehavior sheetMusic;
    public static FragMusicBinding binding;
    public static Animation anim;
    public static MusicService service;
    ServiceConnection sv_conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicService.LocalBinder localBinder = (MusicService.LocalBinder) iBinder;
            service = localBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {}
    };

    public FragMusic() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragMusicBinding.inflate(inflater, container, false);

//        TextView tv = getActivity().findViewById(R.id.tv_tb);
//        tv.setText(R.string.app_name);
//        tv.setGravity(Gravity.CENTER | Gravity.START);
//        BottomNavigationView bNav = getActivity().findViewById(R.id.bottom_nav);
//        bNav.setVisibility(View.GONE);

        Intent intent = new Intent(getContext(), MusicService.class);
        getContext().startService(intent);
        getContext().bindService(intent, sv_conn, Context.BIND_AUTO_CREATE);

        binding.navMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Class aClass = null;
                int id = item.getItemId();
                if (id == R.id.nav_Info) {
                    if (NewsService.statusUser != null) {
                        Intent intent = new Intent(getActivity(), InfoActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity(), "Chưa đăng nhập >.<!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    switch (id) {
                        case R.id.nav_Home:
                            aClass = MainActivity.class;
                            break;

                        case R.id.nav_SignIn:
                            if (item.getTitle().equals("Đăng xuất")) {
                                NewsService.statusUser = null;
                            }
                            aClass = SignInActivity.class;
                            break;
                    }
                    Intent intent = new Intent(getActivity(), aClass);
                    startActivity(intent);
                }
                return true;
            }
        });

        navSignIn();
        anim = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_disc);

        binding.musicBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sheetMusic.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        sheetMusic = BottomSheetBehavior.from(binding.layoutPlayer.layoutPlayer);
        sheetMusic.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_EXPANDED:
                    case BottomSheetBehavior.STATE_DRAGGING: {
                        binding.musicBar.setVisibility(View.GONE);
                        binding.musicRcv.setVisibility(View.GONE);
                        break;
                    }

                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        service.loadList(binding.musicRcv);
                        binding.musicBar.setVisibility(View.VISIBLE);
                        binding.musicRcv.setVisibility(View.VISIBLE);
                        break;
                    }
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {}
        });

        service = new MusicService(getContext());
        service.loadList(binding.musicRcv);
        service.newTrack();

        binding.layoutPlayer.musicPlay.setOnClickListener(this);
        binding.bmusicPlay.setOnClickListener(this);
        binding.layoutPlayer.fmusicPlay.setOnClickListener(this);

        binding.layoutPlayer.musicPrev.setOnClickListener(this);
        binding.bmusicPrev.setOnClickListener(this);
        binding.layoutPlayer.fmusicPrev.setOnClickListener(this);

        binding.layoutPlayer.musicNext.setOnClickListener(this);
        binding.bmusicNext.setOnClickListener(this);
        binding.layoutPlayer.fmusicNext.setOnClickListener(this);

        binding.layoutPlayer.musicShuffle.setOnClickListener(this);
        binding.layoutPlayer.musicRepeat.setOnClickListener(this);
        binding.layoutPlayer.musicFavorite.setOnClickListener(this);

        binding.layoutPlayer.musicList.setOnClickListener(this);
        binding.layoutPlayer.musicFavorite.setOnClickListener(this);
        binding.layoutPlayer.imgFavList.setOnClickListener(this);
        binding.layoutPlayer.favorBar.setOnClickListener(this);

        binding.layoutPlayer.musicSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                service.onBarProgress();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                service.onBarStopTracking();
            }
        });

        return binding.getRoot();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                binding.drawbleLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void navSignIn() {
        MenuItem menuItem = binding.navMenu.getMenu().findItem(R.id.nav_SignIn);
        if (NewsService.statusUser != null) {
            menuItem.setTitle("Đăng xuất");
            menuItem.setIcon(R.drawable.ic_logout);
        } else {
            menuItem.setTitle("Đăng nhập");
            menuItem.setIcon(R.drawable.ic_login);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.music_play:
            case R.id.bmusic_play:
            case R.id.fmusic_play:
                service.play();
                break;

            case R.id.music_prev:
            case R.id.bmusic_prev:
            case R.id.fmusic_prev:
                service.prev();
                break;

            case R.id.music_next:
            case R.id.bmusic_next:
            case R.id.fmusic_next:
                service.next();
                break;

            case R.id.music_shuffle:
                if (binding.layoutPlayer.musicShuffle.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.ic_shuffle_none).getConstantState())
                    binding.layoutPlayer.musicShuffle.setImageResource(R.drawable.ic_shuffle);
                else {
                    binding.layoutPlayer.musicShuffle.setImageResource(R.drawable.ic_shuffle_none);
                }
                break;

            case R.id.music_repeat:
                Drawable.ConstantState state = binding.layoutPlayer.musicRepeat.getDrawable().getConstantState();
                if (state == getResources().getDrawable(R.drawable.ic_repeat_none).getConstantState())
                    binding.layoutPlayer.musicRepeat.setImageResource(R.drawable.ic_repeat_one);
                if (state == getResources().getDrawable(R.drawable.ic_repeat_one).getConstantState())
                    binding.layoutPlayer.musicRepeat.setImageResource(R.drawable.ic_repeat_all);
                if (state == getResources().getDrawable(R.drawable.ic_repeat_all).getConstantState())
                    binding.layoutPlayer.musicRepeat.setImageResource(R.drawable.ic_repeat_none);
                break;

            case R.id.music_favorite:
                service.favor();
                break;

            case R.id.music_list:
                sheetMusic.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;

            case R.id.imgFavList:
                if (NewsService.statusUser == null)
                    Toast.makeText(getContext(), "Chưa đăng nhập??", Toast.LENGTH_LONG).show();
                else if (dao.getFavorList().size() == 0) {
                    Toast.makeText(getContext(), "Chưa có bài hát yêu thích", Toast.LENGTH_LONG).show();
                } else {
                    service.loadList(binding.layoutPlayer.rcvFavorite);
                    binding.layoutPlayer.layoutFavor.setVisibility(View.VISIBLE);
                    binding.layoutPlayer.layoutMusic.setVisibility(View.GONE);
                }
                break;

            case R.id.favorBar:
                service.loadList(binding.musicRcv);
                binding.layoutPlayer.layoutFavor.setVisibility(View.GONE);
                binding.layoutPlayer.layoutMusic.setVisibility(View.VISIBLE);
                break;
        }
    }
}