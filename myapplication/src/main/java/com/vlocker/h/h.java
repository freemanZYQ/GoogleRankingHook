package com.vlocker.h;

import android.content.Context;
import android.os.IBinder;
import android.os.IHardwareService;
import android.os.IHardwareService.Stub;
import android.os.RemoteException;

public class h extends a {
    IHardwareService a;
    boolean b = false;

    public h(Context context) {
    }

    public boolean a() {
        try {
            this.a = Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"hardware"}));
            this.a.setFlashlightEnabled(false);
            this.a.setFlashlightEnabled(false);
            return true;
        } catch (Exception e) {
            return false;
        } catch (NoClassDefFoundError e2) {
            return false;
        }
    }

    public boolean a(b bVar) {
        if (b()) {
            e();
            bVar.a(false);
        } else {
            d();
            bVar.a(true);
        }
        return false;
    }

    public boolean b() {
        return this.b;
    }

    public void d() {
        try {
            this.a.setFlashlightEnabled(true);
            this.b = true;
        } catch (RemoteException e) {
        }
    }

    public void e() {
        try {
            this.a.setFlashlightEnabled(false);
            this.b = false;
        } catch (RemoteException e) {
        }
    }
}
