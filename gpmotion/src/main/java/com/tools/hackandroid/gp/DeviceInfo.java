package com.tools.hackandroid.gp;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DeviceInfo {
    private static final int LOAD_COUNT = 6000;

    private static List<DeviceInfo> list = new ArrayList<DeviceInfo>();
    private static int position = 0;

    String imei;
    String andId;
    String mac;
    long time;
    String bssid;
    String device;
    String brand;
    String model;
    String manufacturer;
    String product;
    int sw;
    int sh;
    int sd;
    String osv;
    int sdkVersion = 19;
    String serial;
    String id;
    String fingerprint;
    String radioVersion = "G900HXXU1ANG3";
    String bootloader = "G900HXXU1ANG3";
    String hardware = "universal5422";
//	String hardware = "mt6592";


    private DeviceInfo() {
    }

    public static DeviceInfo getDeviceInfo(Context context,int index) {
        synchronized (DeviceInfo.class) {
            if (list.isEmpty()) {
                loadDeviceInfos(context);
            }
        }

        return list.get(index);
    }

    public static List<DeviceInfo> getAllDeviceInfos() {
        List<DeviceInfo> list = new ArrayList<DeviceInfo>();
        InputStream is = null;
        BufferedReader reader = null;
        try {
            is = DeviceInfo.class.getResourceAsStream("devices");
            reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            while ((line = reader.readLine()) != null) {

                DeviceInfo info = new DeviceInfo();

                String[] strs = line.split("&");
                for (String str : strs) {
                    String[] kv = str.split("=");
                    switch (kv[0]) {
                        case "ei":
                            info.imei = kv[1];
                            break;

                        case "andid":
                            info.andId = kv[1];
                            break;

                        case "mac":
                            info.mac = kv[1];
                            break;

                        case "bssid":
                            info.bssid = kv[1];
                            break;

                        case "time":
                            info.time = Long.parseLong(kv[1]);
                            break;

                        case "device":
                            info.product = info.device = kv[1];
                            break;

                        case "brand":
                            info.brand = kv[1];
                            break;

                        case "sw":
                            info.sw = Integer.parseInt(kv[1]);
                            break;

                        case "sh":
                            info.sh = Integer.parseInt(kv[1]);
                            break;

                        case "sd":
                            info.sd = Integer.parseInt(kv[1]);
                            break;

                        case "osv":
//                            String s = kv[1];
//                            info.osv = s;
//                            if (s.startsWith("2.3")) {
//                                info.sdkVersion = 10;
//                            } else if (s.startsWith("4.0")) {
//                                info.sdkVersion = 15;
//                            } else if (s.startsWith("4.1")) {
//                                info.sdkVersion = 16;
//                            } else if (s.startsWith("4.2")) {
//                                info.sdkVersion = 17;
//                            } else if (s.startsWith("4.3")) {
//                                info.sdkVersion = 18;
//                            } else if (s.startsWith("4.4")) {
//                                info.sdkVersion = 19;
//                            } else {
//
//                            }
                            info.osv = "4.4.2";
                            info.sdkVersion = 19;
                            break;

                        case "dd":
                            info.model = kv[1];
                            break;

                        case "dv":
                            info.manufacturer = kv[1];
                            break;

                        case "id":
                            info.id = kv[1];
                            break;

                        case "serial":
                            info.serial = kv[1];
                            break;
                    }
                }

                createFingerprint(info);

                list.add(info);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;

    }

    private static void loadDeviceInfos(Context context) {
        position = position + LOAD_COUNT;

        InputStream is = null;
        BufferedReader reader = null;
        try {
            is = context.getAssets().open("devices");
            reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            int index = 0;
            while ((line = reader.readLine()) != null) {
                if ((position - LOAD_COUNT) > index) {
                    index++;
                    continue;
                }
                if (index == position) {
                    break;
                }
                index++;

                DeviceInfo info = new DeviceInfo();

                String[] strs = line.split("&");
                for (String str : strs) {
                    String[] kv = str.split("=");
                    switch (kv[0]) {
                        case "ei":
                            info.imei = kv[1];
                            break;

                        case "andid":
                            info.andId = kv[1];
                            break;

                        case "mac":
                            info.mac = kv[1];
                            break;

                        case "bssid":
                            info.bssid = kv[1];
                            break;

                        case "time":
                            info.time = Long.parseLong(kv[1]);
                            break;

                        case "device":
                            info.product = info.device = kv[1];
                            break;

                        case "brand":
                            info.brand = kv[1];
                            break;

                        case "sw":
                            info.sw = Integer.parseInt(kv[1]);
                            break;

                        case "sh":
                            info.sh = Integer.parseInt(kv[1]);
                            break;

                        case "sd":
                            info.sd = Integer.parseInt(kv[1]);
                            break;

                        case "osv":
                            String s = kv[1];
                            info.osv = s;
                            if (s.startsWith("2.3")) {
                                info.sdkVersion = 10;
                            } else if (s.startsWith("4.0")) {
                                info.sdkVersion = 15;
                            } else if (s.startsWith("4.1")) {
                                info.sdkVersion = 16;
                            } else if (s.startsWith("4.2")) {
                                info.sdkVersion = 17;
                            } else if (s.startsWith("4.3")) {
                                info.sdkVersion = 18;
                            } else if (s.startsWith("4.4")) {
                                info.sdkVersion = 19;
                            } else {

                            }
                            break;

                        case "dd":
                            info.model = kv[1];
                            break;

                        case "dv":
                            info.manufacturer = kv[1];
                            break;

                        case "id":
                            info.id = kv[1];
                            break;

                        case "serial":
                            info.serial = kv[1];
                            break;
                    }
                }

                createFingerprint(info);

                list.add(info);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void createFingerprint(DeviceInfo info) {
        StringBuilder sb = new StringBuilder();
        sb.append(info.brand);
        sb.append("/");
        sb.append(info.product);
        sb.append("/");
        sb.append(info.device);
        sb.append(":");
        sb.append(info.sdkVersion);
        sb.append("/");
        sb.append(info.id);
        sb.append(":user/release-keys");

        info.fingerprint = sb.toString();
    }

    @Override
    public String toString() {
        return "imei=" + imei + ",andId=" + andId + ",mac=" + mac + ",time=" + time + ",bssid=" + bssid
                + ",device=" + device + ",brand=" + brand + ",model=" + model + ",manufacturer=" + manufacturer
                + ",product=" + product + ",sw=" + sw + ",sh=" + sh + ",sd=" + sd + ",osv=" + osv
                + ",sdkVersion=" + sdkVersion + ",serial=" + serial + ",id=" + id + ",fingerprint=" + fingerprint
                + ",radioVersion=" + radioVersion + ",bootloader=" + bootloader + ",hardware=" + hardware +
                "osv: " + osv + " ,sdkVersion:  " + sdkVersion;
    }

}
