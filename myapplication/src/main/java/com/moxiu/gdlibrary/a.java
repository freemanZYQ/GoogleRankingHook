package com.moxiu.gdlibrary;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.moxiu.b.b.b;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.MultiProcessFlag;
import com.qq.e.ads.nativ.NativeAD;
import com.qq.e.ads.splash.SplashAD;

public class a {
    public static void a(Activity activity, com.moxiu.b.a.a aVar, b bVar) {
        if (aVar != null) {
            try {
                if (aVar.Q != null && !TextUtils.isEmpty(aVar.F) && !TextUtils.isEmpty(aVar.G)) {
                    SplashAD splashAD = new SplashAD(activity, aVar.Q, aVar.F, aVar.G, new c(bVar, aVar));
                }
            } catch (Exception e) {
            } catch (Error e2) {
            }
        }
    }

    public static void a(Context context, com.moxiu.b.a.a aVar, com.moxiu.b.b.a aVar2) {
        try {
            MultiProcessFlag.setMultiProcess(true);
            NativeAD nativeAD = new NativeAD(context, aVar.F, aVar.G, new b(aVar2, aVar));
            nativeAD.setDownAPPConfirmPolicy(DownAPPConfirmPolicy.NOConfirm);
            nativeAD.loadAD(aVar.I);
        } catch (Error e) {
            e.printStackTrace();
        }
    }
}
