package com.vlocker.m;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.qq.e.comm.constants.Constants.KEYS;
import com.vlocker.c.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.util.InetAddressUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class ab {
    public static String a() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (it2.hasNext()) {
                    InetAddress inetAddress = (InetAddress) it2.next();
                    if (!inetAddress.isLoopbackAddress() && InetAddressUtils.isIPv4Address(inetAddress.getHostAddress())) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static String a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    public static HttpResponse a(String str) {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(10000));
        return defaultHttpClient.execute(new HttpGet(str));
    }

    public static void a(Context context) {
        Thread acVar = new ac(context);
        acVar.setDaemon(true);
        acVar.start();
    }

    public static void b(Context context) {
        Thread adVar = new ad(context);
        adVar.setPriority(3);
        adVar.start();
    }

    public static synchronized JSONObject c(Context context) {
        JSONObject jSONObject;
        synchronized (ab.class) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(IXAdRequestInfo.ACT, "region");
                jSONObject.put("type", KEYS.BIZ);
                jSONObject.put("lnglat", e(context));
                jSONObject.put("mac", d(context));
                jSONObject.put("bsc", f(context));
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
            }
        }
        return jSONObject;
    }

    public static String d(Context context) {
        String str = "";
        WifiManager wifiManager = (WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI);
        if (wifiManager != null) {
            List scanResults = wifiManager.getScanResults();
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (!(scanResults == null || connectionInfo == null)) {
                int i = 0;
                while (i < scanResults.size()) {
                    ScanResult scanResult = (ScanResult) scanResults.get(i);
                    i++;
                    str = connectionInfo.getBSSID().equals(scanResult.BSSID) ? scanResult.BSSID : str;
                }
            }
        }
        return str;
    }

    public static String e(Context context) {
        double doubleValue = a.a(context).K().doubleValue();
        double doubleValue2 = a.a(context).L().doubleValue();
        return (doubleValue == -1.0d || doubleValue2 == -1.0d) ? "" : doubleValue2 + "," + doubleValue;
    }

    public static String f(Context context) {
        try {
            int baseStationId;
            int networkId;
            int systemId;
            int parseInt;
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String networkOperator;
            if (telephonyManager.getPhoneType() == 2) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                networkOperator = telephonyManager.getNetworkOperator();
                baseStationId = cdmaCellLocation.getBaseStationId();
                networkId = cdmaCellLocation.getNetworkId();
                systemId = cdmaCellLocation.getSystemId();
                parseInt = Integer.parseInt(networkOperator.substring(0, 3));
            } else {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                networkOperator = telephonyManager.getNetworkOperator();
                baseStationId = gsmCellLocation.getCid();
                networkId = gsmCellLocation.getLac();
                systemId = Integer.parseInt(networkOperator.substring(3));
                parseInt = Integer.parseInt(networkOperator.substring(0, 3));
            }
            return parseInt + "," + systemId + "," + networkId + "," + baseStationId;
        } catch (Exception e) {
            return "";
        }
    }
}
