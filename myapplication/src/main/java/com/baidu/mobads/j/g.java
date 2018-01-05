package com.baidu.mobads.j;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.openad.c.d;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

public class g {
    protected final long a = 604800000;
    private Context b;

    class a implements Observer {
        final /* synthetic */ g a;
        private final Handler b;
        private final String c;

        public a(g gVar, Handler handler, String str) {
            this.a = gVar;
            this.b = handler;
            this.c = str;
        }

        public void update(Observable observable, Object obj) {
            IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
            if (iOAdDownloader.getState() == DownloadStatus.COMPLETED) {
                this.a.a(this.b, iOAdDownloader.getOutputPath());
                this.a.a(this.c);
            }
            if (iOAdDownloader.getState() == DownloadStatus.ERROR) {
                this.a.a(this.b);
                this.a.a(this.c);
            }
        }
    }

    public g(Context context) {
        this.b = context;
    }

    private void a(Handler handler) {
        a(handler, Boolean.valueOf(false), null);
    }

    private void a(Handler handler, Boolean bool, String str) {
        try {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 0;
            Bundle bundle = new Bundle();
            bundle.putBoolean("caching_result", bool.booleanValue());
            bundle.putString("local_creative_url", str);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
        } catch (Throwable e) {
            j.a().d(e);
        }
    }

    private void a(Handler handler, String str) {
        a(handler, Boolean.valueOf(true), str);
    }

    public void a(String str) {
        new Thread(new h(this, str)).start();
    }

    public void a(String str, String str2, String str3, Handler handler) {
        File file = new File(str2 + str3);
        if (file.exists()) {
            a(handler, file.getAbsolutePath());
            return;
        }
        try {
            IOAdDownloader createSimpleFileDownloader = d.a(this.b).createSimpleFileDownloader(new URL(str), str2, str3, false);
            createSimpleFileDownloader.addObserver(new a(this, handler, str2));
            createSimpleFileDownloader.start();
        } catch (MalformedURLException e) {
            a(handler);
        }
    }
}
