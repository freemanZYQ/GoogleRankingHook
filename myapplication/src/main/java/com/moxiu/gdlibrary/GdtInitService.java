package com.moxiu.gdlibrary;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.MultiProcessFlag;
import com.qq.e.ads.nativ.NativeAD;

public class GdtInitService extends Service {
    private NativeAD a;

    private void a() {
        try {
            MultiProcessFlag.setMultiProcess(true);
            this.a = new NativeAD(this, "221632", "6060206699956071", new d(this));
            this.a.setDownAPPConfirmPolicy(DownAPPConfirmPolicy.NOConfirm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        a();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        a();
        return super.onStartCommand(intent, i, i2);
    }
}
