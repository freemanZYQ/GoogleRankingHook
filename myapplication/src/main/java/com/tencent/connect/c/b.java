package com.tencent.connect.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.open.a.j;
import com.tencent.open.d.d;

class b implements d {
    final /* synthetic */ Bundle a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ com.tencent.tauth.b d;
    final /* synthetic */ Activity e;
    final /* synthetic */ a f;

    b(a aVar, Bundle bundle, String str, String str2, com.tencent.tauth.b bVar, Activity activity) {
        this.f = aVar;
        this.a = bundle;
        this.b = str;
        this.c = str2;
        this.d = bVar;
        this.e = activity;
    }

    public void a(int i, String str) {
        if (i == 0) {
            this.a.putString("imageLocalUrl", str);
        } else if (TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c)) {
            if (this.d != null) {
                this.d.onError(new com.tencent.tauth.d(-6, "获取分享图片失败!", null));
                j.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
            }
            com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.f.d.b(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "获取分享图片失败!");
            return;
        }
        this.f.c(this.e, this.a, this.d);
    }
}
