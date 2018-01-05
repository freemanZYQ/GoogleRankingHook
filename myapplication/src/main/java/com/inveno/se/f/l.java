package com.inveno.se.f;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import java.net.NetworkInterface;
import java.util.Collections;

public class l {
    private static String a() {
        try {
            String str = "wlan0";
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                    return stringBuilder.toString();
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        String b = m.b("imei", "", context);
        if (!k.a(b)) {
            return b;
        }
        try {
            b = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            b = "";
        }
        m.a("imei", b, context);
        return b;
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        String b = m.b("mac", "", context);
        if (!k.a(b)) {
            return b;
        }
        b = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
        if (!k.b(b)) {
            return "";
        }
        if (b.equals("02:00:00:00:00:00")) {
            b = a();
            if (b.equals("02:00:00:00:00:00")) {
                b = "";
            }
        }
        m.a("mac", b, context);
        return b;
    }

    public static String c(Context context) {
        if (context == null) {
            return "";
        }
        String b = m.b("providersName", "", context);
        if (!k.a(b)) {
            return b;
        }
        String subscriberId;
        try {
            subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            subscriberId = "";
        }
        a.a("op", "imsi:" + subscriberId);
        if (k.b(subscriberId)) {
            if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002") || subscriberId.startsWith("46007")) {
                return "CMCC";
            }
            if (subscriberId.startsWith("46001") || subscriberId.startsWith("46006")) {
                return "CUCC";
            }
            if (subscriberId.startsWith("46003") || subscriberId.startsWith("46005")) {
                return "CTCC";
            }
        }
        return b;
    }
}
