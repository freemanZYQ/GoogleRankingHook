package com.mx.http.download;

import android.app.Notification.Builder;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class c extends AsyncTask {
    final /* synthetic */ DownloadNotify a;
    private Builder b;

    public c(DownloadNotify downloadNotify, Builder builder) {
        this.a = downloadNotify;
        this.b = builder;
    }

    protected Bitmap a(String... strArr) {
        Bitmap decodeResource = BitmapFactory.decodeResource(this.a.a.getResources(), 17301634);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
            httpURLConnection.setConnectTimeout(6000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            try {
                inputStream.close();
                return decodeStream;
            } catch (Exception e) {
                return decodeStream;
            }
        } catch (Exception e2) {
            return decodeResource;
        }
    }

    protected void a(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        try {
            this.b.setLargeIcon(bitmap);
        } catch (Exception e) {
            this.b.setLargeIcon(BitmapFactory.decodeResource(this.a.a.getResources(), 17301633));
        }
    }

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Bitmap) obj);
    }
}
