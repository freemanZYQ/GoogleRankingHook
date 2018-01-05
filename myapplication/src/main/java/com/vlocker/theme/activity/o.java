package com.vlocker.theme.activity;

import android.os.Message;
import com.baidu.location.LocationClientOption;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

class o implements Runnable {
    final /* synthetic */ ThemeDetailActivity a;

    o(ThemeDetailActivity themeDetailActivity) {
        this.a = themeDetailActivity;
    }

    public void run() {
        Message message;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a.B).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.connect();
            this.a.a(new JSONObject(ThemeDetailActivity.a(httpURLConnection.getInputStream())));
            message = new Message();
            message.what = LocationClientOption.MIN_SCAN_SPAN;
            this.a.y.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
            message = new Message();
            message.what = LocationClientOption.MIN_SCAN_SPAN;
            this.a.y.sendMessage(message);
        }
    }
}
