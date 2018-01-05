package com.baidu.mobad.feeds;

import android.content.Context;
import android.view.View;
import com.baidu.mobad.feeds.RequestParameters.Builder;
import com.baidu.mobads.h.q;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.c.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaiduNative {
    private final Context a;
    private final String b;
    private a c;
    private BaiduNativeNetworkListener d;
    private BaiduNativeEventListener e;

    public interface BaiduNativeEventListener {
        void onClicked();

        void onImpressionSended();
    }

    public interface BaiduNativeNetworkListener {
        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeLoad(List list);
    }

    class CustomIOAdEventListener implements IOAdEventListener {
        final /* synthetic */ BaiduNative a;
        private IXAdFeedsRequestParameters b;

        public CustomIOAdEventListener(BaiduNative baiduNative, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
            this.a = baiduNative;
            this.b = iXAdFeedsRequestParameters;
        }

        public void run(IOAdEvent iOAdEvent) {
            if (IXAdEvent.AD_STARTED.equals(iOAdEvent.getType())) {
                this.a.c.removeAllListeners();
                if (this.a.d != null) {
                    final List arrayList = new ArrayList();
                    HashSet hashSet = new HashSet();
                    IXAdConstants p = m.a().p();
                    for (int i = 0; i < this.a.c.m().size(); i++) {
                        boolean z;
                        boolean z2;
                        XAdNativeResponse xAdNativeResponse;
                        IXAdInstanceInfo iXAdInstanceInfo = (IXAdInstanceInfo) this.a.c.m().get(i);
                        String appPackageName = iXAdInstanceInfo.getAppPackageName();
                        if (iXAdInstanceInfo.getActionType() == p.getActTypeDownload()) {
                            if (appPackageName == null || appPackageName.equals("") || appPackageName.equals("null") || hashSet.contains(appPackageName)) {
                                z = false;
                                z2 = true;
                                if (z2) {
                                    xAdNativeResponse = new XAdNativeResponse(iXAdInstanceInfo, this.a, this.b, this.a.c.getCurrentXAdContainer());
                                    if (z) {
                                        xAdNativeResponse.setIsDownloadApp(false);
                                    }
                                    arrayList.add(xAdNativeResponse);
                                }
                            } else {
                                hashSet.add(appPackageName);
                                if (m.a().l().isInstalled(this.a.a, appPackageName)) {
                                    z = true;
                                    z2 = false;
                                    if (z2) {
                                        xAdNativeResponse = new XAdNativeResponse(iXAdInstanceInfo, this.a, this.b, this.a.c.getCurrentXAdContainer());
                                        if (z) {
                                            xAdNativeResponse.setIsDownloadApp(false);
                                        }
                                        arrayList.add(xAdNativeResponse);
                                    }
                                }
                            }
                        }
                        z = false;
                        z2 = false;
                        if (z2) {
                            xAdNativeResponse = new XAdNativeResponse(iXAdInstanceInfo, this.a, this.b, this.a.c.getCurrentXAdContainer());
                            if (z) {
                                xAdNativeResponse.setIsDownloadApp(false);
                            }
                            arrayList.add(xAdNativeResponse);
                        }
                    }
                    m.a().m().a(new Runnable(this) {
                        final /* synthetic */ CustomIOAdEventListener b;

                        public void run() {
                            this.b.a.d.onNativeLoad(arrayList);
                        }
                    });
                }
            }
            if (IXAdEvent.AD_ERROR.equals(iOAdEvent.getType())) {
                this.a.c.removeAllListeners();
                String str = (String) iOAdEvent.getData().get(b.EVENT_MESSAGE);
                if (this.a.d != null) {
                    m.a().m().a(new Runnable(this) {
                        final /* synthetic */ CustomIOAdEventListener a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            this.a.a.d.onNativeFail(NativeErrorCode.LOAD_AD_FAILED);
                        }
                    });
                }
            }
        }
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener) {
        this.a = context;
        m.a().a(context.getApplicationContext());
        this.b = str;
        this.d = baiduNativeNetworkListener;
        q.a(context).a();
        this.c = new a(this.a, str);
    }

    public static void setAppSid(Context context, String str) {
        m.a().m().setAppId(str);
    }

    public void destroy() {
    }

    protected void handleClick(View view, IXAdInstanceInfo iXAdInstanceInfo, int i, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.a(view, iXAdInstanceInfo, i, iXAdFeedsRequestParameters);
    }

    protected void handleClick(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.b(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnClickAd(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.d(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnClose(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.a(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnComplete(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.c(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnError(Context context, int i, int i2, IXAdInstanceInfo iXAdInstanceInfo) {
        this.c.a(context, i, i2, iXAdInstanceInfo);
    }

    protected void handleOnFullScreen(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.b(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnStart(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.b(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected boolean isAdAvailable(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        return this.c.a(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public void makeRequest() {
        makeRequest((RequestParameters) null);
    }

    public void makeRequest(RequestParameters requestParameters) {
        Object build;
        if (requestParameters == null) {
            build = new Builder().build();
        }
        build.mPlacementId = this.b;
        IOAdEventListener customIOAdEventListener = new CustomIOAdEventListener(this, build);
        this.c.addEventListener(IXAdEvent.AD_STARTED, customIOAdEventListener);
        this.c.addEventListener(IXAdEvent.AD_ERROR, customIOAdEventListener);
        this.c.a(build);
        this.c.request();
    }

    protected void recordImpression(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.a(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    @Deprecated
    public void setNativeEventListener(BaiduNativeEventListener baiduNativeEventListener) {
        this.e = baiduNativeEventListener;
    }
}
