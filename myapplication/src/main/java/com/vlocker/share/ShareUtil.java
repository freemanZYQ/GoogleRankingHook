package com.vlocker.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.webkit.JavascriptInterface;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.vlocker.c.a;
import com.vlocker.k.d;
import com.vlocker.m.y;
import com.vlocker.security.MoSecurityApplication;
import org.json.JSONObject;

public class ShareUtil {
    public static final int TYPE_REDPACKET = 1;
    private static ShareUtil sInstance;
    public boolean isShareThemeShowing;
    private Context mContext = MoSecurityApplication.a();
    private h mShareWraper;

    public static ShareUtil getInstance() {
        if (sInstance == null) {
            sInstance = new ShareUtil();
        }
        return sInstance;
    }

    private boolean isApkExist(String str) {
        try {
            return this.mContext.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private void shareRedPacket() {
        if (isShareAppExist()) {
            Intent intent = new Intent(this.mContext, ShareActivity.class);
            try {
                JSONObject jSONObject = new JSONObject(a.a(this.mContext).bM()).getJSONObject("data").getJSONObject("packet_notice");
                if (jSONObject != null) {
                    intent.putExtra("url", jSONObject.getString("url") + d.a(this.mContext).d(0));
                    intent.putExtra("title", jSONObject.getString("title"));
                    intent.putExtra("content", jSONObject.getString("desc"));
                    intent.putExtra("bmp", jSONObject.getString("preview"));
                    intent.putExtra("from", "hongbao");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            intent.addFlags(268435456);
            this.mContext.startActivity(intent);
        }
    }

    public void hideShareTheme() {
        if (this.isShareThemeShowing && this.mShareWraper != null) {
            this.mShareWraper.a();
            this.mShareWraper = null;
        }
    }

    public boolean isShareAppExist() {
        return isApkExist("com.tencent.mobileqq") || isApkExist(WXApp.WXAPP_PACKAGE_NAME) || isApkExist("com.sina.weibo");
    }

    @JavascriptInterface
    public void shareByWeb(int i) {
        switch (i) {
            case 1:
                shareRedPacket();
                return;
            default:
                return;
        }
    }

    public void shareTheme(Activity activity) {
        a a = a.a((Context) activity);
        Intent intent = new Intent();
        String n = a.n();
        String str = "";
        if (n != null && n.length() > 28) {
            int indexOf = n.indexOf(".mx");
            str = n.substring(indexOf - 24, indexOf);
        }
        intent.putExtra("url", "http://mobile.moxiu.com/misc/?do=Vlocker.Theme.Share&id=" + str);
        intent.putExtra("title", y.d(activity, a.n()));
        intent.putExtra("bmp", a.n());
        this.isShareThemeShowing = true;
        this.mShareWraper = new h();
        this.mShareWraper.a(activity, intent);
    }
}
