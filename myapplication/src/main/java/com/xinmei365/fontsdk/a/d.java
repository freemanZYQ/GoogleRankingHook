package com.xinmei365.fontsdk.a;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xinmei365.fontsdk.FontCenter;
import com.xinmei365.fontsdk.bean.FailureInfo;
import com.xinmei365.fontsdk.bean.Font;
import com.xinmei365.fontsdk.c.e;
import com.xinmei365.fontsdk.c.f;
import com.xinmei365.fontsdk.c.h;
import com.xinmei365.fontsdk.c.i;
import com.xinmei365.fontsdk.callback.FontScanCallBack;
import com.xinmei365.fontsdk.callback.FontTypefaceCallBack;
import com.xinmei365.fontsdk.callback.IHttpCallBack;
import com.xinmei365.fontsdk.download.DownloadInfo;
import com.xinmei365.fontsdk.download.DownloadListener;
import com.xinmei365.fontsdk.download.b;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class d {
    static Handler mHandler = new AnonymousClass6(Looper.getMainLooper());

    final class AnonymousClass1 implements DownloadListener {
        final /* synthetic */ Font P;

        AnonymousClass1(Font font) {
            this.P = font;
        }

        public void canceled(DownloadInfo downloadInfo) {
        }

        public void failed(DownloadInfo downloadInfo, int i) {
        }

        public void paused(DownloadInfo downloadInfo) {
        }

        public void prepared(DownloadInfo downloadInfo) {
        }

        public void processing(DownloadInfo downloadInfo) {
        }

        public void successed(DownloadInfo downloadInfo) {
            e.t(this.P.getFontIdNo());
        }

        public void waited(DownloadInfo downloadInfo) {
        }
    }

    final class AnonymousClass2 extends AsyncTask {
        final /* synthetic */ FontScanCallBack ab;

        AnonymousClass2(FontScanCallBack fontScanCallBack) {
            this.ab = fontScanCallBack;
        }

        protected void a(ArrayList arrayList) {
            super.onPostExecute(arrayList);
            if (arrayList == null || arrayList.size() < 0) {
                this.ab.onFailure("you have not install font or save cache file");
            } else {
                this.ab.onSuccess(arrayList);
            }
        }

        protected ArrayList c(Void... voidArr) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(d.a(true));
            Collection b = d.a(false);
            Iterator it = b.iterator();
            while (it.hasNext()) {
                if (!c.p(((Font) it.next()).getFontIdNo())) {
                    it.remove();
                }
            }
            arrayList.addAll(b);
            return arrayList;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return c((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            a((ArrayList) obj);
        }

        protected void onPreExecute() {
            super.onPreExecute();
        }
    }

    final class AnonymousClass4 implements IHttpCallBack {
        final /* synthetic */ DownloadListener ac;

        AnonymousClass4(DownloadListener downloadListener) {
            this.ac = downloadListener;
        }

        public void o(String str) {
            if (str != null && !str.isEmpty()) {
                com.xinmei365.fontsdk.a.f = str;
                d.a(str, this.ac);
            }
        }

        public void onErr(int i, String str) {
            if (this.ac != null) {
                this.ac.failed(null, 0);
            }
        }

        public /* synthetic */ void onSuccess(Object obj) {
            o((String) obj);
        }
    }

    final class AnonymousClass5 implements DownloadListener {
        final /* synthetic */ String ad;

        AnonymousClass5(String str) {
            this.ad = str;
        }

        public void canceled(DownloadInfo downloadInfo) {
        }

        public void failed(DownloadInfo downloadInfo, int i) {
        }

        public void paused(DownloadInfo downloadInfo) {
        }

        public void prepared(DownloadInfo downloadInfo) {
        }

        public void processing(DownloadInfo downloadInfo) {
        }

        public void successed(DownloadInfo downloadInfo) {
            d.c(this.ad, "com.ningso.easyfont");
        }

        public void waited(DownloadInfo downloadInfo) {
        }
    }

    final class AnonymousClass6 extends Handler {
        AnonymousClass6(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Map map = (Map) message.obj;
            FontTypefaceCallBack fontTypefaceCallBack = (FontTypefaceCallBack) map.get("callback");
            String str = (String) map.get("fontIdNo");
            if (fontTypefaceCallBack != null) {
                switch (message.what) {
                    case -1:
                        fontTypefaceCallBack.onFailure(new FailureInfo(1009, (String) map.get("errorMsg")));
                        return;
                    case 0:
                        fontTypefaceCallBack.onSuccess(str, (Typeface) map.get("typeface"));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    final class AnonymousClass7 extends Thread {
        final /* synthetic */ Font P;
        final /* synthetic */ FontTypefaceCallBack ae;

        AnonymousClass7(Font font, FontTypefaceCallBack fontTypefaceCallBack) {
            this.P = font;
            this.ae = fontTypefaceCallBack;
        }

        public void run() {
            Map hashMap;
            try {
                d.a(this.P);
                Object obj = null;
                String thumbnailLocalPath = this.P.getThumbnailLocalPath();
                if (!(thumbnailLocalPath == null || "".equals(thumbnailLocalPath))) {
                    File file = new File(thumbnailLocalPath);
                    if (file.exists() && file.length() != 0) {
                        try {
                            obj = Typeface.createFromFile(thumbnailLocalPath);
                        } catch (Exception e) {
                            e.c(e.getMessage());
                            obj = Typeface.DEFAULT;
                        }
                    }
                }
                if (obj == null) {
                    obj = Typeface.DEFAULT;
                }
                hashMap = new HashMap();
                hashMap.put("callback", this.ae);
                hashMap.put("typeface", obj);
                hashMap.put("fontIdNo", this.P.getFontIdNo());
                d.mHandler.obtainMessage(0, hashMap).sendToTarget();
            } catch (Exception e2) {
                e.c(e2.getMessage());
                hashMap = new HashMap();
                hashMap.put("callback", this.ae);
                hashMap.put("fontIdNo", this.P.getFontIdNo());
                hashMap.put("errorMsg", e2.toString());
                d.mHandler.obtainMessage(-1, hashMap).sendToTarget();
            }
        }
    }

    class a implements com.xinmei365.fontsdk.download.e {
        private Font af;

        private a(Font font) {
            this.af = font;
        }

        public void i() {
            Font.unzip(this.af);
        }
    }

    private static ArrayList a(boolean z) {
        Closeable bufferedReader;
        IOException e;
        Throwable th;
        String str = z ? com.xinmei365.fontsdk.c.a.aq : com.xinmei365.fontsdk.c.a.ay;
        ArrayList arrayList = new ArrayList();
        if (i.D()) {
            File file = new File(str);
            if (!file.exists()) {
                return arrayList;
            }
            File[] listFiles = file.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.endsWith(".font") || str.endsWith(".meta");
                }
            });
            if (listFiles == null) {
                return arrayList;
            }
            for (File fileReader : listFiles) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(fileReader));
                    try {
                        str = bufferedReader.readLine();
                        if (str != null) {
                            Font createFontByString = Font.createFontByString(str, z);
                            if (createFontByString != null) {
                                arrayList.add(createFontByString);
                            }
                        }
                        com.xinmei365.fontsdk.c.d.a(bufferedReader);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            com.xinmei365.fontsdk.c.d.a(bufferedReader);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedReader = null;
                    e.printStackTrace();
                    com.xinmei365.fontsdk.c.d.a(bufferedReader);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            }
        }
        return arrayList;
        com.xinmei365.fontsdk.c.d.a(bufferedReader);
        throw th;
    }

    private static void a(Font font) {
        Closeable fileOutputStream;
        HttpURLConnection httpURLConnection;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        Closeable closeable = null;
        if (TextUtils.isEmpty(font.getThumbnailLocalPath())) {
            throw new RuntimeException("You haven't set the preview text in font management background.");
        }
        File file = new File(font.getThumbnailLocalPath());
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            try {
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(font.getFontPreViewTextTtfUrl()).openConnection();
                try {
                    httpURLConnection3.setConnectTimeout(10000);
                    httpURLConnection3.setRequestMethod("GET");
                    long contentLength = (long) httpURLConnection3.getContentLength();
                    File file2 = new File(font.getThumbnailLocalPath());
                    if (file2.exists() && file2.length() == contentLength) {
                        httpURLConnection3.disconnect();
                        e.a("The file which we want to download was already here.");
                        com.xinmei365.fontsdk.c.d.a(null);
                        com.xinmei365.fontsdk.c.d.a(null);
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                            return;
                        }
                        return;
                    }
                    file2.createNewFile();
                    Closeable inputStream = httpURLConnection3.getInputStream();
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Throwable th2) {
                        fileOutputStream = inputStream;
                        httpURLConnection = httpURLConnection3;
                        th = th2;
                        httpURLConnection2 = httpURLConnection;
                        com.xinmei365.fontsdk.c.d.a(closeable);
                        com.xinmei365.fontsdk.c.d.a(fileOutputStream);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        com.xinmei365.fontsdk.c.d.a(fileOutputStream);
                        com.xinmei365.fontsdk.c.d.a(inputStream);
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                    } catch (Throwable th22) {
                        closeable = fileOutputStream;
                        fileOutputStream = inputStream;
                        Throwable th3 = th22;
                        httpURLConnection2 = httpURLConnection3;
                        th = th3;
                        com.xinmei365.fontsdk.c.d.a(closeable);
                        com.xinmei365.fontsdk.c.d.a(fileOutputStream);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th222) {
                    fileOutputStream = null;
                    httpURLConnection = httpURLConnection3;
                    th = th222;
                    httpURLConnection2 = httpURLConnection;
                    com.xinmei365.fontsdk.c.d.a(closeable);
                    com.xinmei365.fontsdk.c.d.a(fileOutputStream);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection2 = null;
                fileOutputStream = null;
                com.xinmei365.fontsdk.c.d.a(closeable);
                com.xinmei365.fontsdk.c.d.a(fileOutputStream);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        }
    }

    public static void a(FontScanCallBack fontScanCallBack) {
        if (fontScanCallBack == null) {
            throw new RuntimeException("FontScanCallBack can not be null!");
        }
        new AnonymousClass2(fontScanCallBack).execute(new Void[0]);
    }

    private static void a(String str, DownloadListener downloadListener) {
        String str2 = com.xinmei365.fontsdk.c.a.aq + f.A(str) + ".apk";
        if (downloadListener == null) {
            downloadListener = new AnonymousClass5(str2);
        }
        if (str == null || str.isEmpty()) {
            downloadListener.failed(null, 0);
            return;
        }
        b b = b.b(FontCenter.context);
        com.xinmei365.fontsdk.download.d d = b.d(str);
        if (d == null) {
            d = b.a(str, str2);
        }
        d.b(downloadListener);
        b.a(d);
    }

    public static void addDownloadFontListener(Font font, DownloadListener downloadListener) {
        if (downloadListener != null && font != null) {
            com.xinmei365.fontsdk.download.d d = b.b(FontCenter.context).d(font.getFontDownloadUrl());
            if (d != null) {
                d.b(downloadListener);
            }
        }
    }

    private static void c(String str, String str2) {
        if (str != null && !str.isEmpty() && new File(str).exists()) {
            try {
                if (h.b(FontCenter.context, str2)) {
                    h.c(FontCenter.context, str2);
                    return;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse("file://" + str), "application/vnd.android.package-archive");
                intent.addFlags(268435456);
                FontCenter.context.startActivity(intent);
            } catch (Exception e) {
            }
        }
    }

    public static void cancelDownloadFont(Font font) {
        if (font != null) {
            String fontDownloadUrl = font.getFontDownloadUrl();
            b b = b.b(FontCenter.context);
            b.d(b.d(fontDownloadUrl));
        }
    }

    public static void downloadFont(Font font) {
        downloadFont(font, null);
    }

    public static void downloadFont(Font font, DownloadListener downloadListener) {
        if (font != null) {
            File file = new File(com.xinmei365.fontsdk.c.a.aq);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = com.xinmei365.fontsdk.c.a.aq + f.A(font.getFontDownloadUrl()) + "." + "zip";
            b b = b.b(FontCenter.context);
            com.xinmei365.fontsdk.download.d d = b.d(font.getFontDownloadUrl());
            if (d == null) {
                d = b.a(font.getFontDownloadUrl(), str);
                d.setPriority(2);
                d.d().setDownloadObj(font);
                d.a(new a(font));
                e.s(font.getFontIdNo());
            }
            if (downloadListener != null) {
                d.b(downloadListener);
            }
            d.b(new AnonymousClass1(font));
            b.a(d);
        }
    }

    public static void downloadFontManager(DownloadListener downloadListener) {
        if (h.b(FontCenter.context, "com.ningso.easyfont")) {
            try {
                h.c(FontCenter.context, "com.ningso.easyfont");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            h.d(FontCenter.context, "com.ningso.easyfont");
        } catch (Exception e2) {
            if (com.xinmei365.fontsdk.a.f == null || com.xinmei365.fontsdk.a.f.isEmpty()) {
                File file = new File(com.xinmei365.fontsdk.c.a.aq);
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.xinmei365.fontsdk.b.e eVar = new com.xinmei365.fontsdk.b.e(FontCenter.context, String.format("http://cdn.sdk.galaxyfont.com/flow/move?appKey=%s", new Object[]{com.xinmei365.fontsdk.a.e}));
                eVar.a(new AnonymousClass4(downloadListener));
                eVar.z();
                return;
            }
            a(com.xinmei365.fontsdk.a.f, downloadListener);
        }
    }

    public static void getAllFontList(int i, int i2, IHttpCallBack iHttpCallBack) {
        if (i <= 0) {
            iHttpCallBack.onErr(1006, "currentPage minimum is 1");
            return;
        }
        com.xinmei365.fontsdk.b.a aVar = new com.xinmei365.fontsdk.b.a(FontCenter.context, String.format("http://cdn.sdk.galaxyfont.com/font/list?appKey=%s&currPage=%s&offset=%s&type=%s", new Object[]{com.xinmei365.fontsdk.a.e, i + "", i2 + "", "zip"}));
        aVar.a(iHttpCallBack);
        aVar.z();
    }

    public static void getAllTagList(IHttpCallBack iHttpCallBack) {
        com.xinmei365.fontsdk.b.d dVar = new com.xinmei365.fontsdk.b.d(FontCenter.context, String.format(" http://cdn.sdk.galaxyfont.com/tag/list?appKey=%s", new Object[]{com.xinmei365.fontsdk.a.e}));
        dVar.a(iHttpCallBack);
        dVar.z();
    }

    public static void getFontListByTag(String[] strArr, int i, int i2, IHttpCallBack iHttpCallBack) {
        if (i <= 0) {
            iHttpCallBack.onErr(1006, "currentPage minimum is 1");
            return;
        }
        String format = String.format("http://cdn.sdk.galaxyfont.com/font/list?appKey=%s&currPage=%s&offset=%s&type=%s", new Object[]{com.xinmei365.fontsdk.a.e, i + "", i2 + "", "zip"});
        if (strArr != null) {
            StringBuilder stringBuilder = new StringBuilder(format);
            for (String append : strArr) {
                stringBuilder.append("&tagName[]=").append(append);
            }
            format = stringBuilder.toString();
        }
        com.xinmei365.fontsdk.b.a aVar = new com.xinmei365.fontsdk.b.a(FontCenter.context, format);
        aVar.a(iHttpCallBack);
        aVar.z();
    }

    public static void getPreviewTypeface(Font font, FontTypefaceCallBack fontTypefaceCallBack) {
        if (TextUtils.isEmpty(font.getFontPreViewTextTtfUrl())) {
            if (fontTypefaceCallBack != null) {
                fontTypefaceCallBack.onFailure(new FailureInfo(1005, "this font " + font.getFontName() + " You haven't set the preview text in font management background."));
            }
        } else if (new File(font.getThumbnailLocalPath()).exists()) {
            try {
                fontTypefaceCallBack.onSuccess(font.getFontIdNo(), Typeface.createFromFile(new File(font.getThumbnailLocalPath())));
            } catch (Exception e) {
                e.printStackTrace();
                fontTypefaceCallBack.onFailure(null);
            }
        } else {
            new AnonymousClass7(font, fontTypefaceCallBack).start();
        }
    }

    public static void pauseDownloadFont(Font font) {
        if (font != null) {
            String fontDownloadUrl = font.getFontDownloadUrl();
            b b = b.b(FontCenter.context);
            b.e(b.d(fontDownloadUrl));
        }
    }

    public static void removeDownloadFontListener(Font font, DownloadListener downloadListener) {
        if (downloadListener != null && font != null) {
            com.xinmei365.fontsdk.download.d d = b.b(FontCenter.context).d(font.getFontDownloadUrl());
            if (d != null) {
                d.c(downloadListener);
            }
        }
    }
}
