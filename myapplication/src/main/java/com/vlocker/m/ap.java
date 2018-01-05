package com.vlocker.m;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Vibrator;
import com.vlocker.c.a;
import java.util.HashMap;
import java.util.Map.Entry;

public class ap {
    private static ap g = null;
    private SoundPool a = new SoundPool(4, this.f, 100);
    private HashMap b;
    private AudioManager c;
    private Context d;
    private at e;
    private int f = b();

    private ap(Context context) {
        this.d = context.getApplicationContext();
        if (this.a == null) {
            throw new RuntimeException("mSoundPool return null in SoundManager constructor");
        }
        this.b = new HashMap();
        this.c = (AudioManager) this.d.getSystemService("audio");
        this.a.setOnLoadCompleteListener(new aq(this));
    }

    public static ap a(Context context) {
        if (g == null) {
            synchronized (ap.class) {
                if (g == null) {
                    try {
                        g = new ap(context);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return g;
    }

    private static String a() {
        return Build.MANUFACTURER;
    }

    public static void a(Context context, String[] strArr) {
        int random = (int) ((Math.random() * 10.0d) % ((double) strArr.length));
        String o = a.a(context).o();
        if (o != null) {
            a(context).b(context.getFilesDir().getPath() + "/theme/" + o + "/" + strArr[random]);
        }
    }

    private synchronized void a(String str, at atVar) {
        try {
            this.e = atVar;
            this.b.put(str, Integer.valueOf(this.a.load(this.d.getAssets().openFd(str), 1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int b() {
        return 1;
    }

    public static void b(Context context) {
        try {
            Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
            long[] jArr = new long[]{250, 300};
            if (vibrator != null) {
                vibrator.vibrate(jArr, -1);
            }
        } catch (Exception e) {
        }
    }

    private synchronized void b(String str, at atVar) {
        try {
            this.e = atVar;
            this.b.put(str, Integer.valueOf(this.a.load(str, 1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str) {
        if (this.c != null) {
            int i;
            float streamVolume = ((float) this.c.getStreamVolume(2)) / ((float) this.c.getStreamMaxVolume(2));
            if (a().contains("GiONEE")) {
                streamVolume /= 4.0f;
            }
            for (Entry key : this.b.entrySet()) {
                if (((String) key.getKey()).equals(str)) {
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                a(str, new ar(this, str, streamVolume));
            } else {
                this.a.play(((Integer) this.b.get(str)).intValue(), streamVolume, streamVolume, 1, 0, 1.0f);
            }
        }
    }

    public void b(String str) {
        int i;
        float streamVolume = ((float) this.c.getStreamVolume(2)) / ((float) this.c.getStreamMaxVolume(2));
        if (a().contains("GiONEE")) {
            streamVolume /= 4.0f;
        }
        for (Entry key : this.b.entrySet()) {
            if (((String) key.getKey()).equals(str)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i == 0) {
            b(str, new as(this, str, streamVolume));
        } else {
            this.a.play(((Integer) this.b.get(str)).intValue(), streamVolume, streamVolume, 1, 0, 1.0f);
        }
    }
}
