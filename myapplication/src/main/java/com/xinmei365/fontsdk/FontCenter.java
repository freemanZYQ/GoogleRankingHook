package com.xinmei365.fontsdk;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import com.xinmei365.fontsdk.a.a;
import com.xinmei365.fontsdk.a.d;
import com.xinmei365.fontsdk.bean.Font;
import com.xinmei365.fontsdk.c.e;
import com.xinmei365.fontsdk.callback.FontScanCallBack;
import com.xinmei365.fontsdk.callback.FontTypefaceCallBack;
import com.xinmei365.fontsdk.callback.IHttpCallBack;
import com.xinmei365.fontsdk.download.DownloadListener;

public class FontCenter {
    private static FontCenter a;
    private static boolean b;
    private static a c;
    public static Context context;

    public static synchronized FontCenter getInstance() {
        FontCenter fontCenter;
        synchronized (FontCenter.class) {
            if (a == null) {
                a = new FontCenter();
                e.b("fontsdk VersionCode=20,VersionName=2.2.5");
            }
            if (b) {
                fontCenter = a;
            } else {
                throw new RuntimeException("Please invoke FontCenter.initFontCenter(appkey,application) before use this!");
            }
        }
        return fontCenter;
    }

    public static void init(Application application) {
        if (application == null) {
            b = false;
            Log.e("YiziyunSDK", "FontCenter.initFontCenter exception, application = null");
            return;
        }
        String a = a.a((Context) application);
        if (TextUtils.isEmpty(a)) {
            throw new RuntimeException("Please check your appkey before use this!");
        } else if (a.a(a)) {
            context = application.getApplicationContext();
            c = new a(context);
            b = true;
            com.xinmei365.fontsdk.a.e.c(context);
        } else {
            b = false;
            Log.e("YiziyunSDK", "FontCenter.initFontCenter exception, appKey parameter error");
        }
    }

    public static void initFontCenter(String str, Application application) {
        if (application == null) {
            b = false;
            Log.e("YiziyunSDK", "FontCenter.initFontCenter exception, application = null");
        } else if (a.a(str)) {
            context = application.getApplicationContext();
            c = new a(context);
            b = true;
            com.xinmei365.fontsdk.a.e.c(context);
        } else {
            b = false;
            Log.e("YiziyunSDK", "FontCenter.initFontCenter exception, appKey parameter error");
        }
    }

    public void addDownloadFontListener(Font font, DownloadListener downloadListener) {
        d.addDownloadFontListener(font, downloadListener);
    }

    public void cancelDownloadFont(Font font) {
        d.cancelDownloadFont(font);
    }

    public boolean cleanCloudCache() {
        return c.cleanCloudCache();
    }

    public void downloadFont(Font font) {
        d.downloadFont(font);
    }

    public void downloadFont(Font font, DownloadListener downloadListener) {
        d.downloadFont(font, downloadListener);
    }

    public void downloadFontManager() {
        d.downloadFontManager(null);
    }

    public void downloadFontManager(DownloadListener downloadListener) {
        d.downloadFontManager(downloadListener);
    }

    public void enableLog(boolean z) {
        e.enableLog(z);
    }

    public void getAllFontList(int i, int i2, IHttpCallBack iHttpCallBack) {
        d.getAllFontList(i, i2, iHttpCallBack);
    }

    public void getAllTagList(IHttpCallBack iHttpCallBack) {
        d.getAllTagList(iHttpCallBack);
    }

    public long getCloudCacheSize() {
        return c.getCloudCacheSize();
    }

    public void getCloudFont() {
    }

    public void getCloudTypeface(Font font, String str, FontTypefaceCallBack fontTypefaceCallBack) {
        c.getCloudTypeface(font, str, fontTypefaceCallBack);
    }

    public void getCloudTypeface(String str, String str2, FontTypefaceCallBack fontTypefaceCallBack) {
        c.getCloudTypeface(str, str2, fontTypefaceCallBack);
    }

    public String getFolder_cache() {
        return com.xinmei365.fontsdk.c.a.as;
    }

    public String getFolder_font() {
        return com.xinmei365.fontsdk.c.a.aq;
    }

    public void getFontListByTag(String[] strArr, int i, int i2, IHttpCallBack iHttpCallBack) {
        d.getFontListByTag(strArr, i, i2, iHttpCallBack);
    }

    public void getLocalFontList(FontScanCallBack fontScanCallBack) {
        d.a(fontScanCallBack);
    }

    public void getPreviewTypeface(Font font, FontTypefaceCallBack fontTypefaceCallBack) {
        d.getPreviewTypeface(font, fontTypefaceCallBack);
    }

    public void onUse() {
        com.xinmei365.fontsdk.a.e.q();
    }

    public void pauseDownloadFont(Font font) {
        d.pauseDownloadFont(font);
    }

    public void removeDownloadFontListener(Font font, DownloadListener downloadListener) {
        d.removeDownloadFontListener(font, downloadListener);
    }

    public void setAppKey(String str) {
        if (a.a(str)) {
            a.e = str;
        } else {
            Log.e("YiziyunSDK", "FontCenter.setAppKey exception, appKey parameter error");
        }
    }

    public void setAutoCloudFont(Font font) {
        c.setAutoCloudFont(font);
    }

    public void setAutoCloudFontKey(String str) {
        c.k(str);
    }

    public void setAutoCloudTextView(TextView textView) {
        c.setAutoCloudTextView(textView);
    }

    public void setFolder_cache(String str) {
        com.xinmei365.fontsdk.c.a.as = str;
    }

    public void setFolder_font(String str) {
        com.xinmei365.fontsdk.c.a.aq = str;
    }

    public void startAutoCloudText(Font font, TextView textView) {
        c.startAutoCloudText(font, textView);
    }

    public void stopAutoCloudText() {
        c.stopAutoCloudText();
    }
}
