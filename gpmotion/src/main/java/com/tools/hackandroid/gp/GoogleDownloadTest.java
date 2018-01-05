package com.tools.hackandroid.gp;

import net.luna.common.debug.LunaLog;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by bintou on 16/8/16.
 */
public class GoogleDownloadTest implements Runnable {

    String andid;

    public GoogleDownloadTest(String andid) {
        this.andid = andid;
    }


    @Override
    public void run() {
        try {
//            String downloadApk = "com.digipixie.piggy.gplay";
            String downloadApk = "com.youkia.google.csg";// 不可以
//            String downloadApk = "net.ym.game.ww2.raiden";// 可以
            String auth = "pQOsv_yvttUchm4zMK94iCVE5j4EVZ3VX9_sjXWIqJ5yOAffBi2oi9e4uW71piMcZhxqag.";
            download(auth, downloadApk, 1, 70);
        } catch (Exception e) {
            LunaLog.e(e);
        }
    }

    public void download(String auth, String packageName, int ot, int vc) throws Exception {

        @SuppressWarnings("resource")
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("https://android.clients.google.com/fdfe/purchase");
        httpPost.setHeader("Accept-Language", "en_US");
//         httpPost.setHeader("Accept-Language", "zh_HK");
        httpPost.setHeader("Authorization", "GoogleLogin auth=" + auth);
        httpPost.setHeader("X-DFE-Enabled-Experiments", "cl:billing.select_add_instrument_by_default");
        httpPost.setHeader(
                "X-DFE-Other-Targets",
                "18,19,24,36,241,300,481,501,581,636,647,744,748,855,910,12602000,12602001,12602002,12602005,12602007,12602010,12602011,12602020,12602028,12602037,12602038,12602040,12602044,12602048,12602052,12602053,12602056,12602057,12602060,12602061,12602062,12602068,12602072,12602097,12602104,12602107,12602111,12602112,12602118,12602120,12602122,12602126,12602129,12602145,12602146,12602147,12602148,12602314,12602322,12602350,12602351,12602370,12602377,12602430,12602605,12602764,12602797,12602825,12602826,12602827,12602837,12602993,12603068,12603130,12603152,12603248,12603428,12603630,12603633,12603746,12603763,12603767,12603787,12603794,12603804,12603930,12604029,12604030,12604079,12604141,12604158,12604189,12604230,12604251,12604367,12604451,12604484,12604505,12604579,12604692,12604988,12605377,12605384,12605398,12605521,12605561,12605562,12605703,12605705,12605739,12605740,12605757,12605782,12605861,12605897,12605904,12605962,12606188,12606696,12606712,12606798,12606827,12606831,12606832,12607522,12607552,12607602,12607651,12607654,12607792,12607830,12608433,12608685,12608798,12608865,12608875,12609124,12609149,12609164,12609456,12609477,12609523,12609586,12609639,12609714,12609734,12609773,12609860,12609941,12609977,12610424,12610428,12610430,12610474,12610551,12610552,12610695,12610764,12610958,12610990,12611005,12611024,12611028,12611081,12611136,12611189,12611216,12611583,12611609,12611681,12611730,12611798,12611807,12612029,12612049,12612053,12612098,12612188,12612207,12612223,12612247,12612285,12612373,12612557,12612572,12612575,12612614,12613076,12613362,12613466,12613526,12613588,12613651,12613710,12613757,12613801,12613981,12614069,12614127,12614158,12614168,12614172,12614182,12614186,12614187,12614193");
        httpPost.setHeader("X-DFE-Supported-Targets",
                "739,741,12602049,12602373,12602392,12602623,12602795,12602981,12603101,12603111,12603159");
//        httpPost.setHeader(
//                "X-DFE-Unsupported-Experiments",
//                "nocache:billing.use_charging_poller,market_emails,buyer_currency,prod_baseline,checkin.set_asset_paid_app_field,shekel_test,content_ratings,buyer_currency_in_app,nocache:encrypted_apk,recent_changes");
        httpPost.setHeader("X-Public-Android-Id", andid);
        LunaLog.d("andid: " + andid);
        httpPost.setHeader("X-DFE-Device-Id", "344ebdeef83c2d13");
        httpPost.setHeader("X-DFE-Client-Id", "am-google");
        httpPost.setHeader("X-DFE-Filter-Level", "3");
        httpPost.setHeader("X-DFE-Network-Type", "4");
        httpPost.setHeader("Host", "android.clients.google.com");
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        httpPost.setHeader("User-Agent", "Android-Finsky/5.8.11 (api=3,versionCode=80381100,sdk=19,device=mako,hardware=mako,product=occam,platformVersionRelease=4.4.4,model=Nexus%204,buildId=KTU84P,isWideScreen=0)");
        httpPost.setHeader("X-DFE-Request-Params", "timeoutMs=35000");
//		httpPost.setHeader(
//				"X-DFE-Signature-Request",
//				"nonce=IhVrfKE2vmojvd910U4fSpekJ_GqW6K1iQmjeYptkIUx1rCdf1fNii4DRczfBThMQW2n0_DKmMv2DRwxwv1EottQYGIuci6QVFOGi6nAZNl-3l1dl0bNbtCEjYlVzTZetuzj-7Jz1O78qseGceqgoYGOZcBNkItVnvYd_3dZaUeSuSc0SBJipkcDEdrwT6Mo2ys6vB0JrSkQ73Yc63zQLG6pDLHcR8H3clGLIZ1XXibJQYdpkvoYIpZmq6DodJHTTC2KddFXTwPi4g8_YOLN-sDHkQi9pEPCMAHQ_rAH7l_RQAI3FBaISxylUecTmbgg6-JrQT0X5STwnq7P8K0y8g");
//        httpPost.setHeader(
//                "X-DFE-Device-Checkin-Consistency-Token",
//                "ABFEt1X_LEc5Jkvl_-AzGVKflIT0PA-pZTQNEMNcryPdAVH_6-F2XM7djA-PJbmXmA9z2fI1SNQNhVsovSbGexbr9YvOY8A9ha7-3ktnzs7fmSWjzoCSYe39IWmAmlFUt0IR25k8_B_FGBKI75SBH0PYlJNWHLJfov4H_lXYEJ4yrTwQEzlY20VEnmf05WX1bycmZj7epJho8z9c7iGe5IP0hdK1wg3pcx16bWJZSPEi_NjKSt4aKnyCO117NkanThzt9D00cytjSzazVV-dOmFThFXuzQjeFq4avwwKSY6Fpl2MWzN0L6k");

        // ================================换HTTPconnection=================
        URL url = new URL("https://android.clients.google.com/fdfe/purchase");
        HttpsURLConnection con2 = null;
        con2 = (HttpsURLConnection) url.openConnection();
        con2.setRequestProperty("Accept-Language", "en_US");
        // httpPost.setHeader("Accept-Language", "zh_HK");
        con2.setRequestProperty("Authorization", "GoogleLogin auth=" + auth);
        con2.setRequestProperty("X-DFE-Enabled-Experiments", "cl:billing.select_add_instrument_by_default");
        con2.setRequestProperty(
                "X-DFE-Other-Targets",
                "18,19,24,36,241,300,481,501,581,636,647,744,748,855,910,12602000,12602001,12602002,12602005,12602007,12602010,12602011,12602020,12602028,12602037,12602038,12602040,12602044,12602048,12602052,12602053,12602056,12602057,12602060,12602061,12602062,12602068,12602072,12602097,12602104,12602107,12602111,12602112,12602118,12602120,12602122,12602126,12602129,12602145,12602146,12602147,12602148,12602314,12602322,12602350,12602351,12602370,12602377,12602430,12602605,12602764,12602797,12602825,12602826,12602827,12602837,12602993,12603068,12603130,12603152,12603248,12603428,12603630,12603633,12603746,12603763,12603767,12603787,12603794,12603804,12603930,12604029,12604030,12604079,12604141,12604158,12604189,12604230,12604251,12604367,12604451,12604484,12604505,12604579,12604692,12604988,12605377,12605384,12605398,12605521,12605561,12605562,12605703,12605705,12605739,12605740,12605757,12605782,12605861,12605897,12605904,12605962,12606188,12606696,12606712,12606798,12606827,12606831,12606832,12607522,12607552,12607602,12607651,12607654,12607792,12607830,12608433,12608685,12608798,12608865,12608875,12609124,12609149,12609164,12609456,12609477,12609523,12609586,12609639,12609714,12609734,12609773,12609860,12609941,12609977,12610424,12610428,12610430,12610474,12610551,12610552,12610695,12610764,12610958,12610990,12611005,12611024,12611028,12611081,12611136,12611189,12611216,12611583,12611609,12611681,12611730,12611798,12611807,12612029,12612049,12612053,12612098,12612188,12612207,12612223,12612247,12612285,12612373,12612557,12612572,12612575,12612614,12613076,12613362,12613466,12613526,12613588,12613651,12613710,12613757,12613801,12613981,12614069,12614127,12614158,12614168,12614172,12614182,12614186,12614187,12614193");
        con2.setRequestProperty("X-DFE-Supported-Targets",
                "739,741,12602049,12602373,12602392,12602623,12602795,12602981,12603101,12603111,12603159");
        // httpPost.setHeader(
        // "X-DFE-Unsupported-Experiments",
        // "nocache:billing.use_charging_poller,market_emails,buyer_currency,prod_baseline,checkin.set_asset_paid_app_field,shekel_test,content_ratings,buyer_currency_in_app,nocache:encrypted_apk,recent_changes");
        con2.setRequestProperty("X-Public-Android-Id", andid);
//		con2.setRequestProperty("X-DFE-Device-Id", androidId);
        con2.setRequestProperty("X-DFE-Device-Id", "344ebdeef83c2d13");
        con2.setRequestProperty("X-DFE-Client-Id", "am-google");
//		con2.setRequestProperty("X-DFE-MCCMNC", mccmnc);
        con2.setRequestProperty("X-DFE-Filter-Level", "3");
        con2.setRequestProperty("X-DFE-Network-Type", "4");
        con2.setRequestProperty("Host", "android.clients.google.com");
        con2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        con2.setRequestProperty("User-Agent", "Android-Finsky/5.8.11 (api=3,versionCode=80381100,sdk=19,device=mako,hardware=mako,product=occam,platformVersionRelease=4.4.4,model=Nexus%204,buildId=KTU84P,isWideScreen=0)");
        con2.setRequestProperty("X-DFE-Request-Params", "timeoutMs=35000");
//        con2.setRequestProperty("X-Ad-Id", "5047dae3-c515-480c-a38b-b32e94c9d5e9");
//        con2.setRequestProperty("X-Limit-Ad-Tracking-Enabled", "false");
        con2.setRequestProperty("Connection", "Keep-Alive");
//        con2.setRequestProperty("X-DFE-Cookie", "EAEYACICSEsoAQ");

//		con2.setRequestProperty(
//				"X-DFE-Signature-Request",
//				"nonce=IhVrfKE2vmojvd910U4fSpekJ_GqW6K1iQmjeYptkIUx1rCdf1fNii4DRczfBThMQW2n0_DKmMv2DRwxwv1EottQYGIuci6QVFOGi6nAZNl-3l1dl0bNbtCEjYlVzTZetuzj-7Jz1O78qseGceqgoYGOZcBNkItVnvYd_3dZaUeSuSc0SBJipkcDEdrwT6Mo2ys6vB0JrSkQ73Yc63zQLG6pDLHcR8H3clGLIZ1XXibJQYdpkvoYIpZmq6DodJHTTC2KddFXTwPi4g8_YOLN-sDHkQi9pEPCMAHQ_rAH7l_RQAI3FBaISxylUecTmbgg6-JrQT0X5STwnq7P8K0y8g");
//		con2.setRequestProperty(
//				"X-DFE-Device-Checkin-Consistency-Token",
//				"ABFEt1X_LEc5Jkvl_-AzGVKflIT0PA-pZTQNEMNcryPdAVH_6-F2XM7djA-PJbmXmA9z2fI1SNQNhVsovSbGexbr9YvOY8A9ha7-3ktnzs7fmSWjzoCSYe39IWmAmlFUt0IR25k8_B_FGBKI75SBH0PYlJNWHLJfov4H_lXYEJ4yrTwQEzlY20VEnmf05WX1bycmZj7epJho8z9c7iGe5IP0hdK1wg3pcx16bWJZSPEi_NjKSt4aKnyCO117NkanThzt9D00cytjSzazVV-dOmFThFXuzQjeFq4avwwKSY6Fpl2MWzN0L6k");

        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init(null, new TrustManager[]{myX509TrustManager}, null);
        con2.setSSLSocketFactory(instance.getSocketFactory());
        con2.setRequestMethod("POST");
        con2.setDoOutput(true);


        String content = "ot=" + ot + "&doc=" + packageName + "&ct=dummy-token&vc=" + vc + "&";

        con2.getOutputStream().write(content.getBytes());
        // BufferedReader input = new BufferedReader(new
        // InputStreamReader(con2.getInputStream()));
        InputStream in = con2.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = 0;
        byte[] buff = new byte[2048];
        while ((len = in.read(buff)) != -1) {
            baos.write(buff, 0, len);
        }
        byte[] data = baos.toByteArray();
        baos.close();
        in.close();
        LunaLog.d("result: " + new String(data));

        // ========================================================

//        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
//        parameters.add(new BasicNameValuePair("ot", 1 + ""));
//        parameters.add(new BasicNameValuePair("doc", packageName));
//        parameters.add(new BasicNameValuePair("vc", 20400 + ""));
//        parameters.add(new BasicNameValuePair("ct", "dummy-token"));
//
//        UrlEncodedFormEntity urlEncodedFormEntity = new
//                UrlEncodedFormEntity(parameters, "utf-8");
//
//        httpPost.setEntity(urlEncodedFormEntity);
//
//        HttpResponse httpResponse = httpClient.execute(httpPost);
//        InputStream in = httpResponse.getEntity().getContent();
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        int len = 0;
//        byte[] buff = new byte[2048];
//        while ((len = in.read(buff)) != -1) {
//            baos.write(buff, 0, len);
//        }
//        byte[] data = baos.toByteArray();
//        baos.close();
//        in.close();
//        LunaLog.d("result: " + new String(data));
    }


    private static TrustManager myX509TrustManager = new X509TrustManager() {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }
    };
}
