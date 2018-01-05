package com.moxiu.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.RequestParameters.Builder;
import com.baidu.mobads.SplashAd;
import com.moxiu.b.a.a;

public class b {
    public static void a(Activity activity, a aVar, com.moxiu.b.b.b bVar) {
        if (aVar != null) {
            try {
                if (aVar.Q != null && !TextUtils.isEmpty(aVar.F) && !TextUtils.isEmpty(aVar.G)) {
                    SplashAd splashAd = new SplashAd(activity, aVar.Q, new d(bVar, aVar), aVar.G, true);
                }
            } catch (Exception e) {
            } catch (Error e2) {
            }
        }
    }

    public static void a(Context context, a aVar, com.moxiu.b.b.a aVar2) {
        try {
            new BaiduNative(context, aVar.G, new c(aVar, aVar2)).makeRequest(new Builder().downloadAppConfirmPolicy(3).confirmDownloading(false).build());
        } catch (Error e) {
            e.printStackTrace();
        }
    }
}
