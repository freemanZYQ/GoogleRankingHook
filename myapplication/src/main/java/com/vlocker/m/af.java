package com.vlocker.m;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

public class af extends PhoneStateListener {
    static int a = 0;
    static int b = 0;
    private static TelephonyManager c;
    private static af d = null;

    private af() {
    }

    private int a(SignalStrength signalStrength) {
        if (signalStrength == null) {
            return 0;
        }
        int a;
        if (signalStrength.isGsm()) {
            a = a(signalStrength, "getLteLevel");
            return a == 0 ? a(signalStrength, "getGsmLevel") : a;
        } else {
            a = a(signalStrength, "getCdmaLevel");
            int a2 = a(signalStrength, "getEvdoLevel");
            return a2 != 0 ? a == 0 ? a2 : a >= a2 ? a2 : a : a;
        }
    }

    private int a(SignalStrength signalStrength, String str) {
        int i = 0;
        try {
            i = Integer.parseInt(String.valueOf(signalStrength.getClass().getMethod(str, new Class[0]).invoke(signalStrength, new Object[0])));
        } catch (Exception e) {
        }
        return i;
    }

    public static af a(Context context) {
        if (d == null) {
            d = new af();
            c = (TelephonyManager) context.getSystemService("phone");
            c.listen(d, 256);
            if (c.getCellLocation() != null) {
                d.onCellLocationChanged(c.getCellLocation());
            }
        }
        return d;
    }

    public int a() {
        return b;
    }

    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength != null && a != a(signalStrength, "getDbm")) {
            a = a(signalStrength, "getDbm");
            b = a(signalStrength);
        }
    }
}
