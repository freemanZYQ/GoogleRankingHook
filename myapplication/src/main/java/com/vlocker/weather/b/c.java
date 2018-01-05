package com.vlocker.weather.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.qq.e.comm.constants.ErrorCode.AdError;
import com.vlocker.c.a;
import com.vlocker.weather.e.j;

public class c {
    public static c a;
    private static String b = "extra_force_location";
    private Handler c;
    private Runnable d;
    private Context e;
    private LocationClient f = null;
    private BDLocationListener g = new e(this);

    private c(Context context) {
        this.e = context;
        a();
    }

    public static c a(Context context) {
        if (a == null) {
            a = new c(context);
        }
        return a;
    }

    private void a(BDLocation bDLocation, int i) {
        if (bDLocation != null) {
            double doubleValue = a.a(this.e).K().doubleValue();
            double doubleValue2 = a.a(this.e).L().doubleValue();
            boolean H = a.a(this.e).H();
            double a = j.a(doubleValue, doubleValue2, bDLocation.getLatitude(), bDLocation.getLongitude());
            if (H || Double.isNaN(doubleValue) || Double.isNaN(doubleValue2) || a > ((double) j.a()) || c(this.e)) {
                b(bDLocation, i);
            }
        }
    }

    public static void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.vlocker.service.ACTION_LOCATION_UPDATE");
            ((AlarmManager) context.getSystemService("alarm")).setRepeating(0, System.currentTimeMillis() + 5000, 14400000, PendingIntent.getBroadcast(context, 0, intent, 268435456));
        } catch (Exception e) {
        }
    }

    private void b(BDLocation bDLocation, int i) {
        new g(this, bDLocation, i).start();
    }

    private void c() {
        this.f = new LocationClient(this.e);
        this.f.registerLocationListener(this.g);
        Log.e("liu---", "initLocation option");
        LocationClientOption locationClientOption = new LocationClientOption();
        locationClientOption.setAddrType("all");
        locationClientOption.setCoorType("gcj02");
        locationClientOption.setScanSpan(AdError.PLACEMENT_ERROR);
        this.f.setLocOption(locationClientOption);
    }

    public static boolean c(Context context) {
        return System.currentTimeMillis() - a.a(context).d(0) >= 14400000;
    }

    private void d() {
        try {
            this.c.post(new f(this));
        } catch (Exception e) {
        }
    }

    public void a() {
        Log.e("liu---", "onCreate");
        this.c = new Handler();
    }

    public void a(boolean z) {
        Object obj = 1;
        Object obj2 = null;
        Log.e("liu---", "onHandleIntent isForce=" + z);
        if (!j.d(this.e)) {
            obj2 = 1;
        }
        if (!a.a(this.e).I()) {
            obj2 = 1;
        }
        if (obj2 != null) {
            d(this.e);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long d = a.a(this.e).d(0);
        boolean H = a.a(this.e).H();
        Log.e("liu---", "forceUpdate=" + z + ";isCityCodeEmpty=" + H + ";lastUpdateTime=" + d);
        if (z || currentTimeMillis - d >= 14400000 || H) {
            this.d = new d(this);
            this.c.removeCallbacks(this.d);
            this.c.post(this.d);
        } else {
            obj = obj2;
        }
        if (obj == null) {
            d(this.e);
        }
    }

    public void b() {
        Log.e("liu---", "onDestroy");
        try {
            if (this.f != null) {
                this.f.unRegisterLocationListener(this.g);
                this.f.stop();
                this.f = null;
            }
        } catch (Exception e) {
        }
    }

    public void d(Context context) {
        Log.e("liu---", "stopService1");
        b();
        com.vlocker.b.j.j();
        Log.e("liu---", "stopService2");
    }
}
