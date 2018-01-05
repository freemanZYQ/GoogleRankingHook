package com.xinmei365.fontsdk.bean;

import android.graphics.Typeface;
import android.text.TextUtils;
import com.xinmei365.fontsdk.FontCenter;
import com.xinmei365.fontsdk.c.a;
import com.xinmei365.fontsdk.c.b;
import com.xinmei365.fontsdk.c.c;
import com.xinmei365.fontsdk.c.e;
import com.xinmei365.fontsdk.c.f;
import com.xinmei365.fontsdk.callback.FontTypefaceCallBack;
import com.xinmei365.fontsdk.download.DownloadInfo;
import com.xinmei365.fontsdk.download.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Font implements Serializable {
    public static final int FROME_EASYFONT = 4;
    public static final int FROM_TTF = 2;
    public static final int FROM_YIZIYUN = 0;
    public static final int FROM_ZITIGUANJIA = 1;
    private String fontDownloadUrl;
    private int fontFromType;
    private String fontIdNo;
    private String[] fontImg;
    private String fontLocalPath;
    private String fontName;
    private String fontPreViewTextTtfUrl;
    private String fontPreviewText;
    private long fontSize;
    private String[] fontTag;
    private boolean isLocalFont;
    private String thumbnailLocalPath = "";

    private Font() {
    }

    public static Font createFontByEasyFont(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject == null) {
            return null;
        }
        Font font;
        try {
            font = new Font();
            font.fontIdNo = jSONObject.getString("fontIdNo");
            font.fontName = jSONObject.getString("fontName");
            font.fontSize = jSONObject.optLong("fontSize");
            font.fontDownloadUrl = jSONObject.getString("fontDownloadUrl");
            font.fontPreviewText = jSONObject.optString("fontPreviewText");
            font.fontLocalPath = jSONObject.optString("fontLocalPath");
            font.fontPreViewTextTtfUrl = jSONObject.optString("fontPreviewTextTtfUrl");
            font.isLocalFont = true;
            font.fontFromType = 4;
            if (!TextUtils.isEmpty(font.getFontPreViewTextTtfUrl())) {
                font.setThumbnailLocalPath(a.ax + f.A(font.getFontPreViewTextTtfUrl()) + ".dat");
            }
            if (jSONObject.has("fontTag")) {
                JSONArray jSONArray = jSONObject.getJSONArray("fontTag");
                if (jSONArray.length() != 0) {
                    String[] strArr = new String[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        strArr[i2] = jSONArray.getString(i2);
                    }
                    font.fontTag = strArr;
                }
            }
            if (jSONObject.has("fontImg")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("fontImg");
                if (jSONArray2.length() != 0) {
                    String[] strArr2 = new String[jSONArray2.length()];
                    while (i < jSONArray2.length()) {
                        strArr2[i] = jSONArray2.getString(i);
                        i++;
                    }
                    font.fontImg = strArr2;
                }
            }
        } catch (Exception e) {
            font = null;
        }
        return font;
    }

    public static Font createFontByJSONObject(JSONObject jSONObject) {
        int i = 0;
        if (jSONObject == null) {
            return null;
        }
        Font font = new Font();
        try {
            font.fontIdNo = jSONObject.getString("fontIdNo");
            font.fontName = jSONObject.getString("fontName");
            font.fontDownloadUrl = jSONObject.optString("fontDownloadUrl");
            font.fontSize = jSONObject.optLong("fontSize", 0);
            font.fontPreviewText = jSONObject.optString("fontPreviewText");
            if (jSONObject.has("fontPreviewTextTtfUrl")) {
                font.fontPreViewTextTtfUrl = jSONObject.getString("fontPreviewTextTtfUrl");
                if (!TextUtils.isEmpty(font.getFontPreViewTextTtfUrl())) {
                    font.setThumbnailLocalPath(a.as + f.A(font.getFontPreViewTextTtfUrl()) + ".dat");
                }
            }
            if (jSONObject.has("fontTag")) {
                JSONArray jSONArray = jSONObject.getJSONArray("fontTag");
                if (jSONArray.length() != 0) {
                    String[] strArr = new String[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        strArr[i2] = jSONArray.getString(i2);
                    }
                    font.fontTag = strArr;
                }
            }
            if (jSONObject.has("fontImg")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("fontImg");
                if (jSONArray2.length() != 0) {
                    String[] strArr2 = new String[jSONArray2.length()];
                    while (i < jSONArray2.length()) {
                        strArr2[i] = jSONArray2.getString(i);
                        i++;
                    }
                    font.fontImg = strArr2;
                }
            }
            if (jSONObject.has("localPath")) {
                font.fontLocalPath = jSONObject.optString("localPath");
                if (new File(font.fontLocalPath).exists()) {
                    font.isLocalFont = true;
                }
            } else {
                try {
                    String stringBuffer = new StringBuffer(a.aq).append(f.A(font.getFontDownloadUrl()).trim()).append(".font").toString();
                    String stringBuffer2 = new StringBuffer(a.aq).append(font.getFontName()).append(".ttf").toString();
                    if (new File(stringBuffer).exists() && new File(stringBuffer2).exists()) {
                        font.fontLocalPath = stringBuffer2;
                        font.isLocalFont = true;
                    }
                } catch (Exception e) {
                    e.c(e);
                }
            }
            font.fontFromType = 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            font = null;
        }
        return font;
    }

    public static Font createFontByString(String str, boolean z) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return z ? createFontByJSONObject(jSONObject) : createFontByEasyFont(jSONObject);
        } catch (JSONException e) {
            e.c(e);
            return null;
        }
    }

    public static ArrayList createFontsByJSONArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(createFontByJSONObject(jSONArray.getJSONObject(i)));
            } catch (Exception e) {
                e.c(e);
            }
        }
        return arrayList;
    }

    public static JSONObject createJSONObjectByFont(Font font) {
        if (font == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontName", font.getFontName());
            jSONObject.put("fontIdNo", font.getFontIdNo());
            jSONObject.put("fontSize", font.getFontSize());
            jSONObject.put("fontDownloadUrl", font.getFontDownloadUrl());
            jSONObject.put("fontPreviewText", font.getFontPreviewText());
            jSONObject.put("fontImg", b.a(font.getFontImg()));
            jSONObject.put("fontTag", b.a(font.getFontTag()));
            jSONObject.put("fontPreviewTextTtfUrl", font.getFontPreViewTextTtfUrl());
            jSONObject.put("fontLocalPath", font.getFontLocalPath());
        } catch (JSONException e) {
            jSONObject = null;
        }
        return jSONObject;
    }

    public static void unzip(Font font) {
        try {
            String str = a.aq;
            String A = f.A(font.getFontDownloadUrl());
            String trim = f.A(font.getFontDownloadUrl()).trim();
            String str2 = str + A + "." + "zip";
            InputStream inputStream = null;
            try {
                InputStream fileInputStream = new FileInputStream(new File(str2));
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            font.fontLocalPath = str + font.getFontName() + ".ttf";
            if (c.a(str2, str, font.getFontName())) {
                c.deleteFile(str2);
            }
            A = str + trim + ".font";
            c.a(font, A);
            try {
                if (new File(A).exists() && new File(font.fontLocalPath).exists()) {
                    font.isLocalFont = true;
                }
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
            throw new Exception("Unzip the font file failure");
        }
    }

    public boolean delete() {
        boolean z = true;
        if (!this.isLocalFont) {
            return true;
        }
        if (this.fontFromType == 4) {
            return com.xinmei365.fontsdk.a.c.q(this.fontIdNo);
        }
        String trim = f.A(this.fontDownloadUrl).trim();
        boolean z2 = c.f(a.aq, new StringBuilder().append(trim).append(".font").toString()) && c.deleteFile(this.fontLocalPath);
        if (z2) {
            this.isLocalFont = false;
            this.fontLocalPath = null;
        }
        z2 = c.f(a.aq, new StringBuilder().append(trim).append(".zip").toString()) || c.f(a.aq, trim + ".apk");
        z2 = z2 && c.f(a.aq, trim + ".meta");
        trim = a.aq + getFontName() + "-zh.ttf";
        String str = a.aq + getFontName() + "-en.ttf";
        z2 = z2 && c.deleteFile(trim);
        if (!(z2 && c.deleteFile(str))) {
            z = false;
        }
        if (!z) {
            return z;
        }
        this.isLocalFont = false;
        this.fontLocalPath = null;
        return z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Font font = (Font) obj;
        return this.fontIdNo != null ? this.fontIdNo.equals(font.fontIdNo) : font.fontIdNo == null;
    }

    public String getFontDownloadUrl() {
        return this.fontDownloadUrl;
    }

    public int getFontFromType() {
        return this.fontFromType;
    }

    public String getFontIdNo() {
        return this.fontIdNo;
    }

    public String[] getFontImg() {
        return this.fontImg;
    }

    public String getFontLocalPath() {
        return this.fontLocalPath;
    }

    public String getFontName() {
        return this.fontName;
    }

    public String getFontPreViewTextTtfUrl() {
        return this.fontPreViewTextTtfUrl;
    }

    public String getFontPreviewText() {
        return this.fontPreviewText;
    }

    public long getFontSize() {
        return this.fontSize;
    }

    public FontStatus getFontState() {
        if (this.fontDownloadUrl != null) {
            d d = com.xinmei365.fontsdk.download.b.b(FontCenter.context).d(this.fontDownloadUrl);
            if (d != null) {
                DownloadInfo d2 = d.d();
                if (d2 != null) {
                    int status = d2.getStatus();
                    return (status == 0 || status == 1) ? FontStatus.PREPARE : (status == 2 || status == 5) ? FontStatus.PROCESS : status == 3 ? FontStatus.PAUSE : status == 7 ? FontStatus.LOCAL : FontStatus.ONLINE;
                }
            } else if (this.fontLocalPath == null || !this.isLocalFont) {
                return FontStatus.ONLINE;
            } else {
                return (new File(new StringBuilder().append(a.aq).append(f.A(this.fontDownloadUrl).trim()).append(".font").toString()).exists() && new File(this.fontLocalPath).exists()) ? FontStatus.LOCAL : FontStatus.ONLINE;
            }
        }
        return FontStatus.ERROR;
    }

    public String[] getFontTag() {
        return this.fontTag;
    }

    public void getPreviewTypeface(FontTypefaceCallBack fontTypefaceCallBack) {
        if (fontTypefaceCallBack != null) {
            if (isLocalFont()) {
                Typeface c = com.xinmei365.fontsdk.a.c(this.fontLocalPath);
                if (c != null) {
                    fontTypefaceCallBack.onSuccess(this.fontIdNo, c);
                    return;
                }
            }
            FontCenter.getInstance().getCloudTypeface(this, this.fontPreviewText, fontTypefaceCallBack);
        }
    }

    public String getThumbnailLocalPath() {
        return this.thumbnailLocalPath;
    }

    public void getTypeface(FontTypefaceCallBack fontTypefaceCallBack) {
        if (fontTypefaceCallBack != null) {
            if (isLocalFont()) {
                Typeface c = com.xinmei365.fontsdk.a.c(this.fontLocalPath);
                if (c != null) {
                    fontTypefaceCallBack.onSuccess(this.fontIdNo, c);
                    return;
                }
                return;
            }
            fontTypefaceCallBack.onFailure(new FailureInfo(FailureInfo.ERROR_DOWNLOAD_FAILURE, "The font is not downloaded to local"));
        }
    }

    public int hashCode() {
        return this.fontIdNo != null ? this.fontIdNo.hashCode() : 0;
    }

    public boolean isLocalFont() {
        return this.isLocalFont;
    }

    public void setFontPreViewTextTtfUrl(String str) {
        this.fontPreViewTextTtfUrl = str;
    }

    public void setThumbnailLocalPath(String str) {
        this.thumbnailLocalPath = str;
    }
}
