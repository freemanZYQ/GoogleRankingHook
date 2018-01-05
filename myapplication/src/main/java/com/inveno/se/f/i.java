package com.inveno.se.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;

public class i {
    public static int a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        String typeName = activeNetworkInfo.getTypeName();
        return typeName.equalsIgnoreCase("WIFI") ? 4 : typeName.equalsIgnoreCase("MOBILE") ? TextUtils.isEmpty(Proxy.getDefaultHost()) ? c(context) ? 3 : 2 : 1 : 0;
    }

    public static int b(Context context) {
        String str;
        String str2 = "";
        int i = 7;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                str = "WIFI";
                i = 1;
            } else if (activeNetworkInfo.getType() == 0) {
                int i2;
                String subtypeName = activeNetworkInfo.getSubtypeName();
                a.d("GetNetworkType getSubtypeName:" + subtypeName);
                int subtype = activeNetworkInfo.getSubtype();
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        str = "2G";
                        i2 = 2;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case IMediaObject.TYPE_OLD_TV /*14*/:
                    case 15:
                        str = "3G";
                        i2 = 3;
                        break;
                    case 13:
                        str = "4G";
                        i2 = 4;
                        break;
                    default:
                        if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                            str = subtypeName;
                            i2 = 7;
                            break;
                        }
                        str = "3G";
                        i2 = 3;
                        break;
                }
                a.d("GetNetworkType getSubtype:" + subtype);
                i = i2;
            }
            a.d("GetNetworkType strNetworkType:" + str);
            return i;
        }
        str = str2;
        a.d("GetNetworkType strNetworkType:" + str);
        return i;
    }

    private static boolean c(Context context) {
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                return false;
            case 3:
                return true;
            case 4:
                return false;
            case 5:
                return true;
            case 6:
                return true;
            case 7:
                return false;
            case 8:
                return true;
            case 9:
                return true;
            case 10:
                return true;
            case 11:
                return false;
            case 12:
                return true;
            case 13:
                return true;
            case IMediaObject.TYPE_OLD_TV /*14*/:
                return true;
            case 15:
                return true;
            default:
                return false;
        }
    }
}
