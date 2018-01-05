package com.tencent.connect.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.b.c;
import com.tencent.connect.common.b;
import com.tencent.open.TDialog;
import com.tencent.open.a.j;
import com.tencent.open.d.e;
import com.tencent.open.d.p;
import com.tencent.open.d.u;
import com.tencent.tauth.d;
import java.io.File;

public class a extends b {
    public String a = "";

    public a(Context context, c cVar) {
        super(cVar);
    }

    private void b(Activity activity, Bundle bundle, com.tencent.tauth.b bVar) {
        j.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- start.");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        j.a("openSDK_LOG.QQShare", "shareToMobileQQ -- imageUrl: " + string);
        if (TextUtils.isEmpty(string)) {
            c(activity, bundle, bVar);
        } else if (!u.e(string)) {
            bundle.putString("imageUrl", null);
            if (p.b(activity, "4.3.0") < 0) {
                j.b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is < 4.3.0 ");
                c(activity, bundle, bVar);
            } else {
                j.b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is > 4.3.0 ");
                d.a((Context) activity, string, new c(this, bundle, string2, string3, bVar, activity));
            }
        } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            if (bVar != null) {
                bVar.onError(new d(-6, "分享图片失败，检测不到SD卡!", null));
                j.e("openSDK_LOG.QQShare", "分享图片失败，检测不到SD卡!");
            }
            com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.d.b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享图片失败，检测不到SD卡!");
            return;
        } else if (p.b(activity, "4.3.0") >= 0) {
            c(activity, bundle, bVar);
        } else {
            new com.tencent.open.d.a(activity).a(string, new b(this, bundle, string2, string3, bVar, activity));
        }
        j.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
    }

    private void c(Activity activity, Bundle bundle, com.tencent.tauth.b bVar) {
        j.c("openSDK_LOG.QQShare", "doShareToQQ() -- start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
        Object string = bundle.getString("imageUrl");
        Object string2 = bundle.getString("title");
        Object string3 = bundle.getString("summary");
        Object string4 = bundle.getString("targetUrl");
        Object string5 = bundle.getString("audio_url");
        int i = bundle.getInt("req_type", 1);
        int i2 = bundle.getInt("cflag", 0);
        Object string6 = bundle.getString("share_qq_ext_str");
        String b = u.b((Context) activity);
        if (b == null) {
            b = bundle.getString("appName");
        }
        Object string7 = bundle.getString("imageLocalUrl");
        Object b2 = this.d.b();
        Object d = this.d.d();
        j.a("openSDK_LOG.QQShare", "doShareToQQ -- openid: " + d);
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&image_url=" + Base64.encodeToString(u.g(string), 2));
        }
        if (!TextUtils.isEmpty(string7)) {
            stringBuffer.append("&file_data=" + Base64.encodeToString(u.g(string7), 2));
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&title=" + Base64.encodeToString(u.g(string2), 2));
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&description=" + Base64.encodeToString(u.g(string3), 2));
        }
        if (!TextUtils.isEmpty(b2)) {
            stringBuffer.append("&share_id=" + b2);
        }
        if (!TextUtils.isEmpty(string4)) {
            stringBuffer.append("&url=" + Base64.encodeToString(u.g(string4), 2));
        }
        if (!TextUtils.isEmpty(b)) {
            if (b.length() > 20) {
                b = b.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(u.g(b), 2));
        }
        if (!TextUtils.isEmpty(d)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(u.g(d), 2));
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuffer.append("&audioUrl=" + Base64.encodeToString(u.g(string5), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(u.g(String.valueOf(i)), 2));
        if (!TextUtils.isEmpty(string6)) {
            stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(u.g(string6), 2));
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(u.g(String.valueOf(i2)), 2));
        j.a("openSDK_LOG.QQShare", "doShareToQQ -- url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(e.a(), this.d, "requireApi", "shareToNativeQQ");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra("pkg_name", activity.getPackageName());
        if (p.b(activity, "4.6.0") < 0) {
            j.c("openSDK_LOG.QQShare", "doShareToQQ, qqver below 4.6.");
            if (a(intent)) {
                com.tencent.connect.common.c.a().a(11103, bVar);
                a(activity, intent, 11103);
            }
        } else {
            j.c("openSDK_LOG.QQShare", "doShareToQQ, qqver greater than 4.6.");
            if (com.tencent.connect.common.c.a().a("shareToQQ", bVar) != null) {
                j.c("openSDK_LOG.QQShare", "doShareToQQ, last listener is not null, cancel it.");
            }
            if (a(intent)) {
                a(activity, 10103, intent, true);
            }
        }
        if (a(intent)) {
            com.tencent.open.b.d.a().a(this.d.d(), this.d.b(), "ANDROIDQQ.SHARETOQQ.XX", "10", "3", "0", this.a, "0", "1", "0");
            com.tencent.open.b.d.a().a(0, "SHARE_CHECK_SDK", "1000", this.d.b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            com.tencent.open.b.d.a().a(this.d.d(), this.d.b(), "ANDROIDQQ.SHARETOQQ.XX", "10", "3", "1", this.a, "0", "1", "0");
            com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.d.b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        j.c("openSDK_LOG.QQShare", "doShareToQQ() --end");
    }

    public void a(Activity activity, Bundle bundle, com.tencent.tauth.b bVar) {
        j.c("openSDK_LOG.QQShare", "shareToQQ() -- start.");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        String string4 = bundle.getString("targetUrl");
        String string5 = bundle.getString("imageLocalUrl");
        int i = bundle.getInt("req_type", 1);
        j.c("openSDK_LOG.QQShare", "shareToQQ -- type: " + i);
        switch (i) {
            case 1:
                this.a = "1";
                break;
            case 2:
                this.a = "3";
                break;
            case 5:
                this.a = "2";
                break;
            case 6:
                this.a = "4";
                break;
        }
        if (i == 6) {
            if (p.b(activity, "5.0.0") < 0) {
                bVar.onError(new d(-15, "手Q版本过低，应用分享只支持手Q5.0及其以上版本", null));
                j.e("openSDK_LOG.QQShare", "shareToQQ, app share is not support below qq5.0.");
                com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.d.b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, app share is not support below qq5.0.");
                return;
            }
            string4 = String.format("http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1", new Object[]{this.d.b(), "mqq"});
            bundle.putString("targetUrl", string4);
        }
        if (u.a() || p.b(activity, "4.5.0") >= 0) {
            if (i == 5) {
                if (p.b(activity, "4.3.0") < 0) {
                    bVar.onError(new d(-6, "低版本手Q不支持该项功能!", null));
                    j.e("openSDK_LOG.QQShare", "shareToQQ, version below 4.3 is not support.");
                    com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.d.b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, version below 4.3 is not support.");
                    return;
                } else if (!u.f(string5)) {
                    bVar.onError(new d(-6, "非法的图片地址!", null));
                    j.e("openSDK_LOG.QQShare", "shareToQQ -- error: 非法的图片地址!");
                    com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.d.b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "非法的图片地址!");
                    return;
                }
            }
            if (i != 5) {
                if (TextUtils.isEmpty(string4) || !(string4.startsWith("http://") || string4.startsWith("https://"))) {
                    bVar.onError(new d(-6, "传入参数有误!", null));
                    j.e("openSDK_LOG.QQShare", "shareToQQ, targetUrl is empty or illegal..");
                    com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.d.b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, targetUrl is empty or illegal..");
                    return;
                } else if (TextUtils.isEmpty(string2)) {
                    bVar.onError(new d(-6, "title不能为空!", null));
                    j.e("openSDK_LOG.QQShare", "shareToQQ, title is empty.");
                    com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.d.b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, title is empty.");
                    return;
                }
            }
            if (TextUtils.isEmpty(string) || string.startsWith("http://") || string.startsWith("https://") || new File(string).exists()) {
                if (!TextUtils.isEmpty(string2) && string2.length() > 45) {
                    bundle.putString("title", u.a(string2, 45, null, null));
                }
                if (!TextUtils.isEmpty(string3) && string3.length() > 60) {
                    bundle.putString("summary", u.a(string3, 60, null, null));
                }
                if (u.a((Context) activity)) {
                    j.c("openSDK_LOG.QQShare", "shareToQQ, support share");
                    b(activity, bundle, bVar);
                } else {
                    try {
                        j.d("openSDK_LOG.QQShare", "shareToQQ, don't support share, will show download dialog");
                        new TDialog(activity, "", a(""), null, this.d).show();
                    } catch (Throwable e) {
                        j.a("openSDK_LOG.QQShare", " shareToQQ, TDialog.show not in main thread", e);
                        e.printStackTrace();
                        bVar.onError(new d(-6, "没有在主线程调用！", null));
                    }
                }
                j.c("openSDK_LOG.QQShare", "shareToQQ() -- end.");
                return;
            }
            bVar.onError(new d(-6, "非法的图片地址!", null));
            j.e("openSDK_LOG.QQShare", "shareToQQ, image url is emprty or illegal.");
            com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.d.b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, image url is emprty or illegal.");
            return;
        }
        bVar.onError(new d(-6, "分享图片失败，检测不到SD卡!", null));
        j.e("openSDK_LOG.QQShare", "shareToQQ sdcard is null--end");
        com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.d.b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ sdcard is null");
    }
}
