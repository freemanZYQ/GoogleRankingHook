package com.baidu.mobads.production;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerEventListener;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.e.a;
import com.baidu.mobads.openad.e.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public class o implements IXAdContainerEventListener {
    private Context a;
    private final a b;
    private AtomicBoolean c;
    private AtomicBoolean d;
    private AtomicBoolean e;
    private AtomicBoolean f;
    private int g = 0;
    private int h = 2;
    private int i = 15;
    private int j = 0;
    private int k = 2;
    private int l = 15;

    public o(Context context, a aVar) {
        this.a = context;
        this.b = aVar;
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
    }

    private void a(Context context, String str) {
        try {
            this.j = 0;
            Timer timer = new Timer();
            timer.schedule(new q(this, m.a().l(), context, str, timer), 0, 1000);
        } catch (Exception e) {
        }
    }

    private void a(Context context, String str, String str2) {
        try {
            this.g = 0;
            Timer timer = new Timer();
            timer.schedule(new p(this, m.a().l(), context, str2, timer, str), 0, 1000);
        } catch (Exception e) {
        }
    }

    private void a(Set set) {
        a aVar = new a();
        for (String dVar : set) {
            d dVar2 = new d(dVar, "");
            dVar2.e = 1;
            aVar.a(dVar2, Boolean.valueOf(true));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdClicked(com.baidu.mobads.interfaces.IXAdContainer r21, com.baidu.mobads.interfaces.IXAdInstanceInfo r22, java.lang.Boolean r23, java.util.HashMap r24) {
        /*
        r20 = this;
        r4 = com.baidu.mobads.j.m.a();
        r8 = r4.m();
        r4 = com.baidu.mobads.j.m.a();
        r12 = r4.p();
        r4 = com.baidu.mobads.j.m.a();
        r4 = r4.l();
        r0 = r20;
        r13 = r0.b;
        r5 = r21.getAdContainerContext();
        r14 = r5.getAdResource();
        r5 = 0;
        r7 = java.lang.Boolean.valueOf(r5);
        r9 = r22.getClickThroughUrl();
        r10 = r22.getActionType();
        r11 = new java.util.ArrayList;
        r11.<init>();
        r15 = r22.getThirdClickTrackingUrls();
        r5 = 0;
        r6 = r5;
    L_0x003c:
        r5 = r15.size();
        if (r6 >= r5) goto L_0x0067;
    L_0x0042:
        r5 = r15.get(r6);
        r5 = (java.lang.String) r5;
        r16 = "\\$\\{PROGRESS\\}";
        r18 = r21.getPlayheadTime();
        r0 = r18;
        r0 = (int) r0;
        r17 = r0;
        r17 = java.lang.String.valueOf(r17);
        r0 = r16;
        r1 = r17;
        r5 = r5.replaceAll(r0, r1);
        r11.add(r5);
        r5 = r6 + 1;
        r6 = r5;
        goto L_0x003c;
    L_0x0067:
        r5 = new java.util.HashSet;
        r5.<init>();
        r5.addAll(r11);
        r0 = r20;
        r0.a(r5);
        r5 = r12.getActTypeOpenExternalApp();
        if (r10 != r5) goto L_0x0193;
    L_0x007a:
        r5 = 1;
        r11 = java.lang.Boolean.valueOf(r5);
        r5 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00ea }
        r5.<init>(r9);	 Catch:{ Exception -> 0x00ea }
        r10 = r5;
    L_0x0085:
        r5 = "page";
        r6 = "";
        r6 = r10.optString(r5, r6);
        r5 = r13.getApplicationContext();
        r7 = r22.getAppPackageName();
        r8 = 366; // 0x16e float:5.13E-43 double:1.81E-321;
        r9 = "fb_act";
        r15 = 0;
        r9 = r10.optInt(r9, r15);
        r4 = r4.sendAPOInfo(r5, r6, r7, r8, r9);
        if (r4 == 0) goto L_0x010f;
    L_0x00a7:
        r4 = r23.booleanValue();
        if (r4 == 0) goto L_0x00b7;
    L_0x00ad:
        r4 = new com.baidu.mobads.command.b.a;
        r0 = r22;
        r4.<init>(r13, r0, r14, r6);
        r4.a();
    L_0x00b7:
        r4 = r13.getApplicationContext();
        r5 = r22.getAppPackageName();
        r0 = r20;
        r0.a(r4, r6, r5);
        r4 = r11;
    L_0x00c5:
        r4 = r4.booleanValue();
        if (r4 == 0) goto L_0x00da;
    L_0x00cb:
        r0 = r20;
        r4 = r0.b;
        r5 = new com.baidu.mobads.f.a;
        r6 = "AdClickThru";
        r5.<init>(r6);
        r4.dispatchEvent(r5);
    L_0x00da:
        r0 = r20;
        r4 = r0.b;
        r5 = new com.baidu.mobads.f.a;
        r6 = "AdUserClick";
        r5.<init>(r6);
        r4.dispatchEvent(r5);
    L_0x00e9:
        return;
    L_0x00ea:
        r5 = move-exception;
        r5 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0297 }
        r6 = r22.getAppOpenStrs();	 Catch:{ Exception -> 0x0297 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0297 }
        r6 = new com.baidu.mobads.openad.e.a;	 Catch:{ Exception -> 0x0297 }
        r6.<init>();	 Catch:{ Exception -> 0x0297 }
        r7 = new com.baidu.mobads.openad.e.d;	 Catch:{ Exception -> 0x0297 }
        r8 = "";
        r7.<init>(r9, r8);	 Catch:{ Exception -> 0x0297 }
        r8 = 1;
        r7.e = r8;	 Catch:{ Exception -> 0x0297 }
        r8 = 1;
        r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ Exception -> 0x0297 }
        r6.a(r7, r8);	 Catch:{ Exception -> 0x0297 }
        r10 = r5;
        goto L_0x0085;
    L_0x010f:
        r4 = "fb_act";
        r5 = 0;
        r4 = r10.optInt(r4, r5);
        r5 = new org.json.JSONObject;
        r5.<init>();
        r7 = new com.baidu.mobads.vo.XAdInstanceInfo;
        r7.<init>(r5);
        r5 = r12.getActTypeLandingPage();
        if (r4 != r5) goto L_0x0153;
    L_0x0127:
        r4 = r12.getActTypeLandingPage();
        r7.setActionType(r4);
        r4 = "fallback";
        r5 = "";
        r4 = r10.optString(r4, r5);
        r7.setClickThroughUrl(r4);
        r4 = r22.getTitle();
        r7.setTitle(r4);
        r4 = 1;
        r7.setInapp(r4);
        r0 = r20;
        r1 = r21;
        r2 = r23;
        r3 = r24;
        r0.onAdClicked(r1, r7, r2, r3);
        goto L_0x00b7;
    L_0x0153:
        r5 = r12.getActTypeDownload();
        if (r4 != r5) goto L_0x00b7;
    L_0x0159:
        r4 = r12.getActTypeDownload();
        r7.setActionType(r4);
        r4 = "fallback";
        r5 = "";
        r4 = r10.optString(r4, r5);
        r7.setClickThroughUrl(r4);
        r4 = r22.getTitle();
        r7.setTitle(r4);
        r4 = 1;
        r7.setInapp(r4);
        r4 = 1;
        r7.setAPOOpen(r4);
        r7.setPage(r6);
        r4 = r22.getAppPackageName();
        r7.setAppPackageName(r4);
        r0 = r20;
        r1 = r21;
        r2 = r23;
        r3 = r24;
        r0.onAdClicked(r1, r7, r2, r3);
        goto L_0x00b7;
    L_0x0193:
        r4 = r12.getActTypeDownload();
        if (r10 != r4) goto L_0x01b0;
    L_0x0199:
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r5 = r23.booleanValue();
        if (r5 == 0) goto L_0x00c5;
    L_0x01a4:
        r5 = new com.baidu.mobads.command.a.a;
        r0 = r22;
        r5.<init>(r13, r0, r14);
        r5.a();
        goto L_0x00c5;
    L_0x01b0:
        r4 = r12.getActTypeLandingPage();
        if (r10 == r4) goto L_0x01bc;
    L_0x01b6:
        r4 = r12.getActTypeOpenMap();
        if (r10 != r4) goto L_0x01f8;
    L_0x01bc:
        r0 = r20;
        r4 = r0.b;
        r4 = r4.getProdInfo();
        r4 = r4.getProdType();
        r5 = r12.getProductionTypeSplash();
        if (r4 == r5) goto L_0x029c;
    L_0x01ce:
        r4 = 1;
        r4 = java.lang.Boolean.valueOf(r4);
    L_0x01d3:
        r5 = r23.booleanValue();
        if (r5 == 0) goto L_0x00c5;
    L_0x01d9:
        r5 = r22.isInapp();
        if (r5 == 0) goto L_0x01eb;
    L_0x01df:
        r5 = new com.baidu.mobads.command.c.a;
        r0 = r22;
        r5.<init>(r13, r0, r14, r9);
        r5.a();
        goto L_0x00c5;
    L_0x01eb:
        r5 = r21.getAdContainerContext();
        r5 = r5.getApplicationContext();
        r8.browserOutside(r5, r9);
        goto L_0x00c5;
    L_0x01f8:
        r4 = r12.getActTypeMakeCall();
        if (r10 == r4) goto L_0x020a;
    L_0x01fe:
        r4 = r12.getActTypeSendSMS();
        if (r10 == r4) goto L_0x020a;
    L_0x0204:
        r4 = r12.getActTypeSendMail();
        if (r10 != r4) goto L_0x0285;
    L_0x020a:
        r4 = 1;
        r7 = java.lang.Boolean.valueOf(r4);
        r4 = r23.booleanValue();
        if (r4 == 0) goto L_0x021f;
    L_0x0215:
        r4 = new com.baidu.mobads.command.b.a;
        r0 = r22;
        r4.<init>(r13, r0, r14, r9);
        r4.a();
    L_0x021f:
        r4 = r12.getActTypeMakeCall();
        if (r10 != r4) goto L_0x0294;
    L_0x0225:
        r4 = r13.getApplicationContext();
        r4 = r4.getPackageManager();
        r5 = new android.content.Intent;
        r6 = "android.intent.action.VIEW";
        r5.<init>(r6);
        r6 = android.net.Uri.parse(r9);
        r5.setData(r6);
        r6 = 64;
        r9 = r4.queryIntentActivities(r5, r6);
        if (r9 == 0) goto L_0x0274;
    L_0x0244:
        r4 = r9.size();
        if (r4 <= 0) goto L_0x0274;
    L_0x024a:
        r5 = 0;
        r8 = 1;
        r4 = 0;
        r6 = r5;
        r5 = r4;
    L_0x024f:
        r4 = r9.size();
        if (r5 >= r4) goto L_0x029a;
    L_0x0255:
        r4 = 1;
        if (r5 < r4) goto L_0x0277;
    L_0x0258:
        r4 = r9.get(r5);
        r4 = (android.content.pm.ResolveInfo) r4;
        r4 = r4.activityInfo;
        r4 = r4.processName;
        r4 = r6.equals(r4);
        if (r4 != 0) goto L_0x0277;
    L_0x0268:
        r4 = 0;
    L_0x0269:
        if (r4 == 0) goto L_0x0274;
    L_0x026b:
        r4 = r13.getApplicationContext();
        r0 = r20;
        r0.a(r4, r6);
    L_0x0274:
        r4 = r7;
        goto L_0x00c5;
    L_0x0277:
        r4 = r9.get(r5);
        r4 = (android.content.pm.ResolveInfo) r4;
        r4 = r4.activityInfo;
        r6 = r4.processName;
        r4 = r5 + 1;
        r5 = r4;
        goto L_0x024f;
    L_0x0285:
        r4 = r12.getActTypeNothing2Do();
        if (r10 != r4) goto L_0x028e;
    L_0x028b:
        r4 = r7;
        goto L_0x00c5;
    L_0x028e:
        r4 = r12.getActTypeRichMedia();
        if (r10 != r4) goto L_0x0294;
    L_0x0294:
        r4 = r7;
        goto L_0x00c5;
    L_0x0297:
        r4 = move-exception;
        goto L_0x00e9;
    L_0x029a:
        r4 = r8;
        goto L_0x0269;
    L_0x029c:
        r4 = r7;
        goto L_0x01d3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.production.o.onAdClicked(com.baidu.mobads.interfaces.IXAdContainer, com.baidu.mobads.interfaces.IXAdInstanceInfo, java.lang.Boolean, java.util.HashMap):void");
    }

    public void onAdCustomEvent(String str, IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdDurationChange(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdError(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
            if (hashMap != null) {
                IXAdConstants p = m.a().p();
                com.baidu.mobads.c.a.a().a(hashMap.get(p.getInfoKeyErrorCode()) + "," + hashMap.get(p.getInfoKeyErrorMessage()) + "," + hashMap.get(p.getInfoKeyErrorModule()));
            }
            this.e.set(true);
            this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_ERROR, hashMap));
        }
    }

    public void onAdExpandedChange(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdImpression(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap hashMap) {
        a(iXAdInstanceInfo.getImpressionUrls());
    }

    public void onAdInteraction(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdLinearChange(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdLoaded(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap hashMap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.b.a(iXAdContainer, hashMap);
        } else {
            new Handler(this.a.getMainLooper()).post(new r(this, iXAdContainer, hashMap));
        }
    }

    public void onAdPaused(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_PAUSED));
    }

    public void onAdPlaying(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_PLAYING));
    }

    public void onAdRemainingTimeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdSizeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdSkippableStateChange(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdSkipped(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdStarted(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap hashMap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.b.b(iXAdContainer, hashMap);
        } else {
            new Handler(this.a.getMainLooper()).post(new s(this, iXAdContainer, hashMap));
        }
    }

    public void onAdStoped(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, Boolean bool2, HashMap hashMap) {
        Set hashSet = new HashSet();
        hashSet.addAll(iXAdInstanceInfo.getCloseTrackers());
        a(hashSet);
        if (bool2.booleanValue()) {
            IXAdContainerContext adContainerContext = iXAdContainer.getAdContainerContext();
            this.b.a(adContainerContext.getAdResponseInfo(), adContainerContext.getAdInstanceInfo());
            return;
        }
        this.b.e(iXAdContainer, hashMap);
        this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_STOPPED));
    }

    public void onAdUserAcceptInvitation(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdUserClosed(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        this.b.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_USER_CLOSE));
    }

    public void onAdUserMinimize(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdVideoComplete(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdVideoFirstQuartile(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdVideoMidpoint(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdVideoStart(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdVideoThirdQuartile(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }

    public void onAdVolumeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap) {
        if (!this.e.get()) {
        }
    }
}
