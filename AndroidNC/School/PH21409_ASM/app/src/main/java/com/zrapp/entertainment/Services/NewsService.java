package com.zrapp.entertainment.Services;

import android.app.Activity;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.zrapp.entertainment.Activity.MainActivity;
import com.zrapp.entertainment.Activity.SignInActivity;
import com.zrapp.entertainment.Async.NewsDownload;
import com.zrapp.entertainment.Model.User;
import com.zrapp.entertainment.SQLite.DAO;

import java.util.Timer;
import java.util.TimerTask;

public class NewsService extends IntentService {
    Context context;
    DAO dao;
    public static User statusUser = null;

    public NewsService() {super("NewsService");}

    public NewsService(Context context) {
        super("NewsService");
        this.context = context;
        dao = new DAO(context);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {}

    public class LocalBinder extends Binder {
        NewsService.LocalBinder getLocalBinder() {
            return NewsService.LocalBinder.this;
        }
    }

    public void loadNews(String str, RecyclerView rcv) {
        NewsDownload download = new NewsDownload((MainActivity) context, rcv);
        download.execute(str);
    }

    public void register(User user) {
        if (!dao.isNotEXISTS(user.getUsername()))
            Toast.makeText(context, "Username đã tồn tại", Toast.LENGTH_SHORT).show();
        else {
            dao.insertUser(user);
            Toast.makeText(context, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent intent = new Intent(context, SignInActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }, 1500);
        }
    }

    public void signIn(User user) {
        if (dao.isNotEXISTS(user.getUsername()))
            Toast.makeText(context, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
        else if (!user.getPassword().equals(dao.getUser(user.getUsername()).getPassword()))
            Toast.makeText(context, "Sai mật khẩu", Toast.LENGTH_SHORT).show();
        else {
            NewsService.statusUser = dao.getUser(user.getUsername());
            Toast.makeText(context, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    ((Activity) context).finish();
//                    Intent intent = new Intent(context, MainActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
                }
            }, 1000);
        }
    }

    public Bitmap getBitmap(byte[] img) {
        return BitmapFactory.decodeByteArray(img, 0, img.length);
    }

}
