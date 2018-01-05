package com.a.a;

import android.graphics.Point;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class a {
    private static String c = "MzFingerManager";
    private static Bundle k;
    private static Bundle l;
    HandlerThread a;
    private int b = Integer.MIN_VALUE;
    private boolean d = false;
    private q e;
    private n f;
    private f g;
    private c h;
    private e i;
    private l j;
    private d m;
    private m n;

    private a(IBinder iBinder, Looper looper) {
        this.e = r.a(iBinder);
        if (looper == null) {
            Log.d(c, " create--------HandlerThread  ");
            this.a = new HandlerThread("result_handler");
            this.a.start();
            looper = this.a.getLooper();
        }
        Log.e(c, "get fp method time, mService = " + this.e);
        f fVar = new f(this, looper);
        k = new Bundle();
        l = new Bundle();
        this.f = new b(this);
        if (this.e == null || !this.e.a(this.f)) {
            throw new RuntimeException();
        }
        this.g = fVar;
    }

    public static a a() {
        try {
            return new a((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"fingerprints_service"}), Looper.myLooper());
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
            return null;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return null;
        } catch (RuntimeException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    private void g() {
        int i = l.getInt("progress");
        int i2 = l.getInt("next_direction");
        int i3 = l.getInt("acceptance");
        boolean z = l.getInt("stitched") != 0;
        boolean z2 = l.getInt("immobile") != 0;
        int i4 = l.getInt("reject_reason");
        int i5 = l.getInt("maskNumber");
        boolean z3 = false;
        boolean z4 = false;
        switch (i4) {
            case 1:
            case IMediaObject.TYPE_LOCATION_SHARE /*17*/:
                z4 = true;
                break;
            case 16:
                z3 = true;
                break;
        }
        k kVar = new k(this, i3, z, z2, new j(this, z3, z4));
        Point point = new Point(l.getIntArray("lastTouch")[0], l.getIntArray("lastTouch")[1]);
        Point point2 = new Point(l.getIntArray("lastTouch")[2], l.getIntArray("lastTouch")[3]);
        Point point3 = new Point(l.getIntArray("lastTouch")[4], l.getIntArray("lastTouch")[5]);
        Point point4 = new Point(l.getIntArray("lastTouch")[6], l.getIntArray("lastTouch")[7]);
        Point point5 = new Point(l.getIntArray("nextTouch")[0], l.getIntArray("nextTouch")[1]);
        Point point6 = new Point(l.getIntArray("nextTouch")[2], l.getIntArray("nextTouch")[3]);
        Point point7 = new Point(l.getIntArray("nextTouch")[4], l.getIntArray("nextTouch")[5]);
        Point point8 = new Point(l.getIntArray("nextTouch")[6], l.getIntArray("nextTouch")[7]);
        i iVar = new i(this, point, point2, point3, point4);
        i iVar2 = new i(this, point5, point6, point7, point8);
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < i5; i6++) {
            arrayList.add(new i(this, new Point(l.getIntArray("maskList")[(i6 * 8) + 0], l.getIntArray("maskList")[(i6 * 8) + 1]), new Point(l.getIntArray("maskList")[(i6 * 8) + 2], l.getIntArray("maskList")[(i6 * 8) + 3]), new Point(l.getIntArray("maskList")[(i6 * 8) + 4], l.getIntArray("maskList")[(i6 * 8) + 5]), new Point(l.getIntArray("maskList")[(i6 * 8) + 6], l.getIntArray("maskList")[(i6 * 8) + 7])));
        }
        this.i.a(new g(this, i, i2, kVar, iVar, iVar2, new h(this, arrayList, i5)));
    }

    public void a(l lVar, int[] iArr) {
        if (iArr != null && lVar != null) {
            this.j = lVar;
            try {
                this.e.a(this.f, iArr);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void b() {
        Log.i(c, " release--------              ");
        if (this.a != null) {
            Log.i(c, " release--------  mzHanderThread");
            this.a.quit();
            this.a = null;
        }
        try {
            this.e.c(this.f);
            if (this.h != null) {
                this.h = null;
            }
            if (!(this.i == null || this.d)) {
                this.i = null;
            }
            if (this.j != null) {
                this.j = null;
            }
            this.n = null;
            this.f = null;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int[] c() {
        try {
            Log.i(c, "getIds      ");
            return this.e.d(this.f);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}
