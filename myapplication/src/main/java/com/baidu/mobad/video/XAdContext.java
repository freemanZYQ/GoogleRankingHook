package com.baidu.mobad.video;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.ActivityState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.ScreenSizeMode;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.VideoState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.VisitorAction;
import com.baidu.mobads.interfaces.IXAdContext;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInternalConstants;
import com.baidu.mobads.interfaces.IXAdManager;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.d.c;
import com.baidu.mobads.openad.e.a;
import com.baidu.mobads.openad.e.d;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class XAdContext implements IXAdContext {
    public static final String TAG = "XAdContext";
    int a = 0;
    int b = 0;
    private HashMap c = new HashMap();
    private ScreenSizeMode d = ScreenSizeMode.FULL_SCREEN;
    private VideoState e = VideoState.IDLE;
    private ActivityState f = ActivityState.CREATE;
    private VisitorAction g;
    private double h;
    private int i;
    private int j;
    private Context k;
    private String l;
    private Location m;
    protected IXAdLogger mAdLogger;
    private Activity n;
    private RelativeLayout o;
    private final IOAdEventDispatcher p;
    private final XAdSlotManager q;

    public class AdSlotEventListener implements IOAdEventListener {
        public static final String TAG = "AdSlotEventListener";
        private final Context a;
        private final IXAdProd b;
        private final IOAdEventDispatcher c;

        public AdSlotEventListener(Context context, IXAdProd iXAdProd, IOAdEventDispatcher iOAdEventDispatcher) {
            this.a = context;
            this.b = iXAdProd;
            this.c = iOAdEventDispatcher;
        }

        public void run(final IOAdEvent iOAdEvent) {
            m.a().f().i(TAG, iOAdEvent.getType());
            m.a().m().a(new Runnable(this) {
                final /* synthetic */ AdSlotEventListener b;

                public void run() {
                    if (iOAdEvent.getType().equals(b.COMPLETE)) {
                        this.b.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, this.b.b));
                    }
                    if (iOAdEvent.getType().equals(IXAdEvent.AD_STARTED)) {
                        if (this.b.b.getProdBase() != null) {
                            this.b.b.getProdBase().setVisibility(0);
                        }
                        this.b.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_SLOT_STARTED, this.b.b));
                    }
                    if (iOAdEvent.getType().equals("AdUserClick")) {
                        this.b.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_SLOT_CLICKED, this.b.b));
                    }
                    if (iOAdEvent.getType().equals(IXAdEvent.AD_STOPPED)) {
                        if (this.b.b.getProdBase() != null) {
                            this.b.b.getProdBase().setVisibility(4);
                        }
                        this.b.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_SLOT_ENDED, this.b.b));
                    }
                    if (iOAdEvent.getType().equals(IXAdEvent.AD_ERROR)) {
                        if (this.b.b.getProdBase() != null) {
                            this.b.b.getProdBase().setVisibility(4);
                        }
                        this.b.c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_ERROR, this.b.b));
                    }
                }
            });
        }
    }

    public XAdContext(Context context, String str, Location location) {
        this.k = context;
        this.l = str;
        this.m = location;
        this.p = new c();
        this.q = new XAdSlotManager();
        this.mAdLogger = m.a().f();
    }

    private void a(Set set) {
        a aVar = new a();
        for (String dVar : set) {
            d dVar2 = new d(dVar, "");
            dVar2.e = 1;
            aVar.a(dVar2, Boolean.valueOf(true));
        }
    }

    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.p.addEventListener(str, iOAdEventListener);
    }

    public void dispatchEvent(IOAdEvent iOAdEvent) {
    }

    public void dispose() {
    }

    public Activity getActivity() {
        return this.n;
    }

    public Object getParameter(String str) {
        return this.c.get(str);
    }

    public IXAdProd getSlotById(String str) {
        return this.q.retrieveAdSlotById(str);
    }

    public IXAdManager getXAdManager() {
        return null;
    }

    public IXLinearAdSlot newPrerollAdSlot(String str, int i, int i2) {
        if (!this.q.containsAdSlot(str).booleanValue()) {
            IXAdProd bVar = new com.baidu.mobads.production.h.b(this.n, str);
            bVar.setActivity(this.n);
            bVar.setAdSlotBase(this.o);
            bVar.setId(str);
            IOAdEventListener adSlotEventListener = new AdSlotEventListener(this.k, bVar, this.p);
            bVar.removeAllListeners();
            bVar.addEventListener(b.COMPLETE, adSlotEventListener);
            bVar.addEventListener(IXAdEvent.AD_STARTED, adSlotEventListener);
            bVar.addEventListener(IXAdEvent.AD_STOPPED, adSlotEventListener);
            bVar.addEventListener(IXAdEvent.AD_ERROR, adSlotEventListener);
            bVar.addEventListener("AdUserClick", adSlotEventListener);
            this.q.addAdSlot(bVar);
        }
        return this.q.retrievePrerollAdSlot();
    }

    public void notifyVisitorAction(VisitorAction visitorAction) {
        this.g = visitorAction;
    }

    public void removeEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.p.removeEventListener(str, iOAdEventListener);
    }

    public void setActivity(Activity activity) {
        if (activity != null && this.n == null) {
            this.n = activity;
            if (this.k == null) {
                this.k = this.n.getApplicationContext();
            }
        }
    }

    public void setActivityState(ActivityState activityState) {
        this.f = activityState;
        this.mAdLogger.i(TAG, activityState.getValue());
        IXAdProd retrievePrerollAdSlot = this.q.retrievePrerollAdSlot();
        if (retrievePrerollAdSlot != null) {
            if (activityState == ActivityState.PAUSE) {
                retrievePrerollAdSlot.pause();
            }
            if (activityState == ActivityState.RESUME) {
                retrievePrerollAdSlot.resume();
            }
        }
    }

    public void setAdCreativeLoadingTimeout(int i) {
        this.j = i;
    }

    public void setAdServerRequestingTimeout(int i) {
        this.i = i;
    }

    public void setContentVideoPlayheadTime(double d) {
        this.h = d;
    }

    public void setContentVideoScreenMode(ScreenSizeMode screenSizeMode) {
        this.d = screenSizeMode;
        IXAdProd retrievePrerollAdSlot = this.q.retrievePrerollAdSlot();
        if (this.d == ScreenSizeMode.FULL_SCREEN && retrievePrerollAdSlot != null && retrievePrerollAdSlot.getSlotState() == SlotState.PLAYING) {
            IXAdInstanceInfo currentAdInstance = retrievePrerollAdSlot.getCurrentAdInstance();
            if (currentAdInstance != null) {
                int playheadTime = (int) retrievePrerollAdSlot.getCurrentXAdContainer().getPlayheadTime();
                IXAdURIUitls i = m.a().i();
                List arrayList = new ArrayList();
                List fullScreenTrackers = currentAdInstance.getFullScreenTrackers();
                for (int i2 = 0; i2 < fullScreenTrackers.size(); i2++) {
                    arrayList.add(i.addParameter((String) fullScreenTrackers.get(i2), "progress", "" + playheadTime));
                }
                currentAdInstance.setFullScreenTrackers(arrayList);
                Set hashSet = new HashSet();
                hashSet.addAll(currentAdInstance.getFullScreenTrackers());
                a(hashSet);
            }
        }
    }

    public void setContentVideoState(VideoState videoState) {
        this.e = videoState;
    }

    public void setParameter(String str, Object obj) {
        this.c.put(str, obj);
    }

    public void setVideoDisplayBase(RelativeLayout relativeLayout) {
        this.o = relativeLayout;
        setActivity((Activity) this.o.getContext());
        new Handler(getActivity().getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ XAdContext a;

            {
                this.a = r1;
            }

            public void run() {
                IXAdProd retrievePrerollAdSlot = this.a.q.retrievePrerollAdSlot();
                if (retrievePrerollAdSlot != null && retrievePrerollAdSlot.getSlotState() == SlotState.PLAYING) {
                    retrievePrerollAdSlot.resize();
                }
            }
        });
    }

    public void setVideoDisplayBaseHeight(int i) {
        this.b = i;
    }

    public void setVideoDisplayBaseWidth(int i) {
        this.a = i;
    }

    public void submitRequest() {
        IXAdProd retrievePrerollAdSlot = this.q.retrievePrerollAdSlot();
        if (this.i > 0 && this.j > 0) {
            HashMap parameter = retrievePrerollAdSlot.getParameter();
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_AD_REQUESTING_TIMEOUT, "" + this.i);
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_AD_CREATIVE_LOADING_TIMEOUT, "" + this.j);
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_BASE_WIDTH, "" + this.a);
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_BASE_HEIGHT, "" + this.b);
            retrievePrerollAdSlot.setParameter(parameter);
        }
        retrievePrerollAdSlot.request();
    }
}
