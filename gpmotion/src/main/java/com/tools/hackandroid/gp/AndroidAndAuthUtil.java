package com.tools.hackandroid.gp;

import android.os.Environment;

import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.tools.hackandroid.util.FileUtil;

import net.luna.common.debug.LunaLog;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by bintou on 2016/10/20.
 */

public class AndroidAndAuthUtil {

    public static String[] getAndroidId(String auth, DeviceInfo info, String mccmnc, Locale locale, String email)
            throws Exception {
        LunaLog.d(auth);

        LunaLog.d("==========================  device info =============================");
        LunaLog.d(info.toString());

        String fingerprint = info.fingerprint;
        String radio = info.radioVersion;

        String bootloader = info.bootloader;
        String hardware = info.hardware;
        String brand = info.brand;
        String device = info.device;
        String model = info.model;
        String manufacturer = info.manufacturer;
        String product = info.product;
        String buildId = info.id;
        long timestamp = info.time / 1000;
        int sdkVersion = info.sdkVersion;
        boolean otaInstalled = false;
        String clientId = "android-google";
        int gsfVersionCode = 19;
        String otaCert = "71Q6Rn2DDZl1zPDVaaeEHItd+Yg=";

        String networkOperator = mccmnc;
        String simOperator = mccmnc;
        String roaming = "wifi";

        String imei = info.imei;
        String mac = info.mac;
        String bssid = info.bssid;

        int density = info.sd;
        int width = info.sw;
        int height = info.sh;

        @SuppressWarnings("unused")
        long securityToken = 1859905491218400730l;
        long androidId = 0l;
        long loggingId = new Random().nextLong();
        String digest = "1-17b5e29f5e93cf14f4cdcc7e601f7c50cb0a7d23";
        String serial = info.serial;
        int userSerialNumber = 0;
        int userNumber = 0;

        String ua = "Android-Checkin/2.0 (" + device + " " + buildId + ")" + "; gzip";
        LunaLog.d(ua);
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
        androidCheckinProto.setCellOperator(networkOperator);
        androidCheckinProto.setSimOperator(simOperator);
        androidCheckinProto.setRoaming(roaming);
        androidCheckinProto.setUserNumber(userNumber);

        CheckIn.DeviceConfigurationProto deviceConfigurationProto = new CheckIn.DeviceConfigurationProto();
        deviceConfigurationProto.setTouchScreen(3);
        deviceConfigurationProto.setKeyboard(1);
        deviceConfigurationProto.setNavigation(1);
        deviceConfigurationProto.setMaxApkDownloadSizeMb(1000);
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
        for (String str : FeatureInfoFactory.getAllFeatureInfos(info.sdkVersion)) {
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
        androidCheckinRequest.addMacAddrType("ethernet");
        androidCheckinRequest.addMacAddr(bssid);
        androidCheckinRequest.addMacAddrType("wifi");
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

        org.apache.http.HttpResponse httpResponse = httpClient.execute(httpPost);
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

        // LunaLog.d();
        // LunaLog.d(new String(data));
        // LunaLog.d();
        CheckIn.AndroidCheckinResponse androidCheckinResponse;
        try {
            androidCheckinResponse = CheckIn.AndroidCheckinResponse.parseFrom(data);
        } catch (Exception e) {
            LunaLog.d("获取AndroidID失败");
            LunaLog.d(new String(data));
            throw e;
        }
        LunaLog.d("android id:" + androidCheckinResponse.getAndroidId());
        LunaLog.d("device data version info:" + androidCheckinResponse.getDeviceDataVersionInfo());
        LunaLog.d("getSecurityToken(): " + androidCheckinResponse.getSecurityToken());
        LunaLog.d("getDigest() :  " + androidCheckinResponse.getDigest());
        return new String[]{Long.toString(androidCheckinResponse.getAndroidId(), 16),
                androidCheckinResponse.getDeviceDataVersionInfo()};
    }

    public static String loginGSF(String email, String password, DeviceInfo deviceInfo, String versionName, String versionCode, String country) throws Exception {
        @SuppressWarnings("resource")
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("https://android.clients.google.com/auth");
        httpPost.setHeader("Accept-Language", "en_US");
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        StringBuilder sb = new StringBuilder("Android-Finsky/");
        sb.append(versionName);
        sb.append(" (api=3,versionCode=");
        sb.append(versionCode);
        sb.append(",sdk=");
        sb.append(deviceInfo.sdkVersion);
        sb.append(",device=");
        sb.append(deviceInfo.device);
        sb.append(",hardware=");
        sb.append(deviceInfo.hardware);
        sb.append(",product=");
        sb.append(deviceInfo.product);
        sb.append(",platformVersionRelease=");
        sb.append(deviceInfo.osv);
        sb.append(",model=");
        sb.append(deviceInfo.model);
        sb.append(",buildId=");
        sb.append(deviceInfo.id);
        sb.append(",isWideScreen=0");
        sb.append(")");
        httpPost.setHeader("User-Agent", sb.toString());


        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("Email", email));
        parameters.add(new BasicNameValuePair("Passwd", password));
        parameters.add(new BasicNameValuePair("client_sig", "38918A453D07199354F8B19AF05EC6562CED5788"));
        parameters.add(new BasicNameValuePair("accountType", "HOSTED_OR_GOOGLE"));
        parameters.add(new BasicNameValuePair("service", "ac2dm"));
        parameters.add(new BasicNameValuePair("has_permission", "1"));
        parameters.add(new BasicNameValuePair("source", "android"));
        parameters.add(new BasicNameValuePair("app", "com.google.android.gsf"));
        parameters.add(new BasicNameValuePair("device_country", country));
        parameters.add(new BasicNameValuePair("operatorCountry", country));
        parameters.add(new BasicNameValuePair("sdk_version", deviceInfo.sdkVersion + ""));

        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(parameters, "utf-8");

        httpPost.setEntity(urlEncodedFormEntity);

        org.apache.http.HttpResponse httpResponse = httpClient.execute(httpPost);
        InputStream in = httpResponse.getEntity().getContent();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = 0;
        byte[] buff = new byte[2048];
        while ((len = in.read(buff)) != -1) {
            baos.write(buff, 0, len);
        }
        byte[] data = baos.toByteArray();
        baos.close();
        in.close();

        String msg = new String(data);
        String[] strs = msg.split("\n");
        if (msg.contains("accounts/answer/40695")) {
            String param = "email=" + email + "&gplus=1&reason=disabled&available=0";
//            NetworkUtils.saveAccount(param);
            //该账号加入黑名单
            LunaLog.d("该账号加入黑名单");
            File blackListFile = Environment.getExternalStoragePublicDirectory("/gregister/blackList.txt");
            FileUtil.writeLine2File(blackListFile, email);
        }
        LunaLog.d(email + "---" + msg);
        if (msg.contains("Error=")) {
            return "error";
        }
        for (String s : strs) {
            if (s.contains("Auth=")) {
                return s.replace("Auth=", "");
            }
        }
        return null;
    }


}