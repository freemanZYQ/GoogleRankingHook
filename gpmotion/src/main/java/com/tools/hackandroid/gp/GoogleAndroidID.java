package com.tools.hackandroid.gp;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import com.google.protobuf.micro.CodedOutputStreamMicro;

import net.luna.common.debug.LunaLog;
import net.luna.common.util.NetWorkUtil;
import net.luna.common.util.ScreenUtils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by bintou on 16/8/17.
 */
public class GoogleAndroidID {

    Context context;

    public GoogleAndroidID(Context context) {
        this.context = context;
    }

    public String[] getAndroidId(String auth, Locale locale, String email)
            throws Exception {
        System.out.println(auth);
        TelephonyManager tm = (TelephonyManager) context.getSystemService(
                Context.TELEPHONY_SERVICE);

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        WifiManager wm = (WifiManager) context.getSystemService(
                Context.WIFI_SERVICE);

        String fingerprint = Build.FINGERPRINT;
        LunaLog.d("fingerprint: " + Build.FINGERPRINT);

        String radio = Build.getRadioVersion();

        String bootloader = Build.BOOTLOADER;
        String hardware = Build.HARDWARE;
        String brand = Build.BRAND;
        String device = Build.DEVICE;
        String model = Build.MODEL;
        String manufacturer = Build.MANUFACTURER;
        String product = Build.PRODUCT;
        long timestamp = Build.TIME / 1000;
        int sdkVersion = Build.VERSION.SDK_INT;
        boolean otaInstalled = false;
        String clientId = "android-google";
        int gsfVersionCode = 19;
        String otaCert = "71Q6Rn2DDZl1zPDVaaeEHItd+Yg=";

        String roaming = "WIFI";
        String imei = NetWorkUtil.getImei();
        LunaLog.d("imei: "+imei);


        String mac = null;

        if (wm != null) {
            WifiInfo wi = wm.getConnectionInfo();
            if (wi != null) {
                mac = wi.getMacAddress();
                if (mac != null) {
                    mac = mac.replaceAll(":", "");
                }
            }
        }

        String bssid = NetWorkUtil.getWifiSsid();
        LunaLog.d("bssid : " + bssid + "   mac: " + mac);
        int density = ScreenUtils.densityDpi(context);
        int width = ScreenUtils.widthPixels(context);
        int height = ScreenUtils.heightPixels(context);

        @SuppressWarnings("unused")
        long securityToken = 1859905491218400730l;
        long androidId = 0l;
        long loggingId = new Random().nextLong();

        ContentResolver resolver = context.getContentResolver();

        String digest = gsGetString(resolver, "digest", null);
        LunaLog.d("digest: " + digest);
        String serial = Build.SERIAL;
        int userSerialNumber = 0;
        int userNumber = 0;

        String ua = "Android-Checkin/2.0 (" + Build.DEVICE + " " + Build.ID + ")" + "; gzip";

        CheckIn.AndroidBuildProto androidBuildProto = new CheckIn.AndroidBuildProto();
        androidBuildProto.setId(fingerprint);
        androidBuildProto.setRadio(radio);
        androidBuildProto.setBootloader(bootloader);
        androidBuildProto.setProduct(hardware);
        androidBuildProto.setCarrier(brand);
        androidBuildProto.setDevice(device);
        androidBuildProto.setModel(model);
        androidBuildProto.setManufacturer(manufacturer);
        androidBuildProto.setBuildProduct(product);
        androidBuildProto.setTimestamp(timestamp);
        androidBuildProto.setSdkVersion(sdkVersion);
        androidBuildProto.setOtaInstalled(otaInstalled);
        androidBuildProto.setClient(clientId);
        androidBuildProto.setGoogleServices(gsfVersionCode);

        CheckIn.AndroidCheckinProto androidCheckinProto = new CheckIn.AndroidCheckinProto();
        androidCheckinProto.setBuild(androidBuildProto);
        androidCheckinProto.setCellOperator(tm.getNetworkOperator());
        androidCheckinProto.setSimOperator(tm.getSimOperator());
        androidCheckinProto.setRoaming(roaming);
        androidCheckinProto.setUserNumber(userNumber);

        CheckIn.DeviceConfigurationProto deviceConfigurationProto = new CheckIn.DeviceConfigurationProto();
        deviceConfigurationProto.setTouchScreen(3);
        deviceConfigurationProto.setKeyboard(1);
        deviceConfigurationProto.setNavigation(1);
        deviceConfigurationProto.setScreenLayout(2);
        deviceConfigurationProto.setHasHardKeyboard(false);
        deviceConfigurationProto.setHasFiveWayNavigation(false);
        deviceConfigurationProto.setScreenDensity(density);
        deviceConfigurationProto.setScreenWidth(width);
        deviceConfigurationProto.setScreenHeight(height);
        deviceConfigurationProto.setGlEsVersion(0x00030000);
        for (String str : SharedLibraryFactory.getSharedLibs()) {
            deviceConfigurationProto.addSystemSharedLibrary(str);
        }
        for (String str : FeatureInfoFactory.getAllFeatureInfos(Build.VERSION.SDK_INT)) {
            deviceConfigurationProto.addSystemAvailableFeature(str);
        }
        deviceConfigurationProto.addNativePlatform("armeabi-v7a");
        deviceConfigurationProto.addNativePlatform("armeabi");
        for (String str : LocaleFactory.getAllLocales()) {
            deviceConfigurationProto.addSystemSupportedLocale(str);
        }
        for (String str : SharedLibraryFactory.getExtensions()) {
            deviceConfigurationProto.addGlExtension(str);
        }

        CheckIn.AndroidCheckinRequest androidCheckinRequest = new CheckIn.AndroidCheckinRequest();
        androidCheckinRequest.setCheckin(androidCheckinProto);
        androidCheckinRequest.setFragment(0);
        androidCheckinRequest.addOtaCert(otaCert);
        androidCheckinRequest.setMeid(imei);
        androidCheckinRequest.addMacAddr(mac);
        androidCheckinRequest.addMacAddrType("wifi");
//        androidCheckinRequest.addMacAddr(bssid);
//        androidCheckinRequest.addMacAddrType("wifi");
        androidCheckinRequest.setLocale(locale.toString());

        androidCheckinRequest.setId(androidId);
        androidCheckinRequest.setVersion(3);

        androidCheckinRequest.setLoggingId(loggingId);
        androidCheckinRequest.setDigest(digest);
        androidCheckinRequest.setSerialNumber(serial);

        androidCheckinRequest.setUserSerialNumber(userSerialNumber);

        androidCheckinRequest.addAccountCookie("[" + email + "]");
        androidCheckinRequest.addAccountCookie(auth);

        androidCheckinRequest.setTimeZone(TimeZone.getDefault().getID());
        androidCheckinRequest.setDeviceConfiguration(deviceConfigurationProto);

        @SuppressWarnings("resource")
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("https://android.clients.google.com/checkin");
        httpPost.addHeader("User-Agent", ua);
        httpPost.addHeader("Content-type", "application/x-protobuffer");
        httpPost.addHeader("Accept-Encoding", "gzip");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPOutputStream gzipos = new GZIPOutputStream(baos);
        CodedOutputStreamMicro cosm = CodedOutputStreamMicro.newInstance(gzipos);
        androidCheckinRequest.writeTo(cosm);
        cosm.flush();
        gzipos.finish();
        gzipos.close();
        baos.flush();
        baos.close();


        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(baos.toByteArray());
        byteArrayEntity.setContentEncoding("gzip");
        httpPost.setEntity(byteArrayEntity);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity entity = httpResponse.getEntity();
        InputStream in = entity.getContent();

        if (entity.getContentEncoding().getValue().contains("gzip")) {
            in = new GZIPInputStream(in);
        }

        baos = new ByteArrayOutputStream();
        int len = 0;
        byte[] buff = new byte[2048];
        while ((len = in.read(buff)) != -1) {
            baos.write(buff, 0, len);
        }
        byte[] data = baos.toByteArray();
        baos.close();
        in.close();

        // System.out.println();.
        // System.out.println(new String(data));
        // System.out.println();
        CheckIn.AndroidCheckinResponse androidCheckinResponse;
        try {
            androidCheckinResponse = CheckIn.AndroidCheckinResponse.parseFrom(data);
        } catch (Exception e) {
            System.out.println(new String(data));
            throw e;
        }
        LunaLog.d("android id:" + androidCheckinResponse.getAndroidId());
        LunaLog.d("device data version info:" + androidCheckinResponse.getDeviceDataVersionInfo());
        LunaLog.d("getSecurityToken:  " + androidCheckinResponse.getSecurityToken());
        LunaLog.d("getDigest: " + androidCheckinResponse.getDigest());
        return new String[]{Long.toString(androidCheckinResponse.getAndroidId(), 16),
                androidCheckinResponse.getDeviceDataVersionInfo()};
    }


    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");

    public static String gsGetString(ContentResolver contentResolver, String str, String str2) {
        String str3;

        Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    str3 = query.getString(1);
                    if (str3 != null) {
                        str2 = str3;
                    }
                    if (query != null) {
                        query.close();
                    }
                }
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
            }
        }
        if (query != null) {
            query.close();
        }


        return str2;
    }

}
