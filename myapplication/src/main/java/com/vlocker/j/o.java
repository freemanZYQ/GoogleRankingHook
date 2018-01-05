package com.vlocker.j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.lang.reflect.Method;

public class o {
    private Context a;
    private AudioManager b = ((AudioManager) this.a.getSystemService("audio"));

    public o(Context context) {
        this.a = context;
    }

    @TargetApi(19)
    private void a(int i, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                b(i, str);
            } else if (VERSION.SDK_INT >= 19) {
                long uptimeMillis = SystemClock.uptimeMillis() - 1;
                this.b.dispatchMediaKeyEvent(new KeyEvent(uptimeMillis, uptimeMillis, 0, i, 0));
                uptimeMillis = SystemClock.uptimeMillis() - 1;
                this.b.dispatchMediaKeyEvent(new KeyEvent(uptimeMillis, uptimeMillis, 1, i, 0));
            } else {
                IBinder iBinder = (IBinder) Class.forName("android.os.ServiceManager").getDeclaredMethod("checkService", new Class[]{String.class}).invoke(null, new Object[]{"audio"});
                Object invoke = Class.forName("android.media.IAudioService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{iBinder});
                Method declaredMethod = Class.forName("android.media.IAudioService").getDeclaredMethod("dispatchMediaKeyEvent", new Class[]{KeyEvent.class});
                if (declaredMethod != null) {
                    declaredMethod.invoke(invoke, new Object[]{new KeyEvent(0, i)});
                    declaredMethod.invoke(invoke, new Object[]{new KeyEvent(1, i)});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(int i, String str) {
        String str2 = "togglepause";
        if (126 == i || 127 == i || 85 == i) {
            str2 = "pause";
        } else if (88 == i) {
            str2 = "previous";
        } else if (87 == i) {
            str2 = "next";
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", null);
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(uptimeMillis, uptimeMillis, 0, i, 0));
        intent.putExtra("command", str2);
        intent.setPackage(str);
        this.a.sendOrderedBroadcast(intent, null);
        intent = new Intent("android.intent.action.MEDIA_BUTTON", null);
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(uptimeMillis, uptimeMillis, 1, i, 0));
        intent.putExtra("command", str2);
        intent.setPackage(str);
        this.a.sendOrderedBroadcast(intent, null);
    }

    @TargetApi(11)
    public void a(String str) {
        a(85, str);
    }

    public boolean a() {
        return this.b.isMusicActive();
    }

    public void b(String str) {
        a(85, str);
    }

    public void c(String str) {
        a(87, str);
    }

    public void d(String str) {
        a(88, str);
    }
}
