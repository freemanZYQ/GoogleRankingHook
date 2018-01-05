package com.qq.e.ads.splash;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.ErrorCode.InitError;
import com.qq.e.comm.constants.ErrorCode.OtherError;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public final class SplashAD {
    private NSPVI a;
    private SplashADListener b;

    class ADListenerAdapter implements ADListener {
        private /* synthetic */ SplashAD a;

        private ADListenerAdapter(SplashAD splashAD) {
            this.a = splashAD;
        }

        public void onADEvent(ADEvent aDEvent) {
            if (this.a.b == null) {
                GDTLogger.e("SplashADListener == null");
                return;
            }
            switch (aDEvent.getType()) {
                case 1:
                    this.a.b.onADDismissed();
                    return;
                case 2:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.a.b.onNoAD(((Integer) aDEvent.getParas()[0]).intValue());
                        return;
                    } else {
                        GDTLogger.e("Splash ADEvent error,");
                        return;
                    }
                case 3:
                    this.a.b.onADPresent();
                    return;
                case 4:
                    this.a.b.onADClicked();
                    return;
                default:
                    return;
            }
        }
    }

    public SplashAD(Activity activity, ViewGroup viewGroup, String str, String str2, SplashADListener splashADListener) {
        this(activity, viewGroup, str, str2, splashADListener, 0);
    }

    public SplashAD(Activity activity, ViewGroup viewGroup, String str, String str2, SplashADListener splashADListener, int i) {
        this.b = splashADListener;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || viewGroup == null || activity == null) {
            GDTLogger.e(String.format("SplashAd Constructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
            a(splashADListener, InitError.INIT_AD_ERROR);
        } else if (a.a((Context) activity)) {
            try {
                if (GDTADManager.getInstance().initWith(activity, str)) {
                    this.a = GDTADManager.getInstance().getPM().getPOFactory().getNativeSplashAdView(activity, str, str2);
                    if (this.a != null) {
                        this.a.setFetchDelay(i);
                        this.a.setAdListener(new ADListenerAdapter());
                        this.a.fetchAndShowIn(viewGroup);
                        return;
                    }
                    GDTLogger.e("SplashAdView created by factory return null");
                    a(splashADListener, InitError.GET_INTERFACE_ERROR);
                    return;
                }
                GDTLogger.e("Fail to Init GDT AD SDK,report logcat info filter by gdt_ad_mob");
                a(splashADListener, InitError.INIT_ADMANGER_ERROR);
            } catch (Throwable e) {
                GDTLogger.e("Fail to init splash plugin", e);
                a(splashADListener, InitError.INIT_PLUGIN_ERROR);
            } catch (Throwable e2) {
                GDTLogger.e("Unknown Exception", e2);
                a(splashADListener, OtherError.UNKNOWN_ERROR);
            }
        } else {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            a(splashADListener, InitError.INIT_AD_ERROR);
        }
    }

    private static void a(SplashADListener splashADListener, int i) {
        if (splashADListener != null) {
            splashADListener.onNoAD(i);
        }
    }
}
