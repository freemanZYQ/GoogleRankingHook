package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerEventListener;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdBitmapUtils;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.d.c;
import com.baidu.mobads.openad.e.d;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import java.util.HashMap;

public class an extends c implements IXAdContainerContext {
    public IXAdContainerEventListener a;
    private Context b;
    private Activity d;
    private RelativeLayout e;
    private IXAdResponseInfo f;
    private IXAdInstanceInfo g;
    private View h;
    private IXAdProdInfo i;
    private long j = 0;
    private HashMap k = new HashMap();

    public class a extends b {
        final /* synthetic */ an a;
        private String b;
        private HashMap c;

        public a(an anVar, String str, String str2, HashMap hashMap) {
            this.a = anVar;
            super(str);
            this.b = str2;
            this.c = hashMap;
        }

        public HashMap getData() {
            return this.c;
        }
    }

    public an(Context context, Activity activity, IXAdProdInfo iXAdProdInfo, RelativeLayout relativeLayout, IXAdContainerEventListener iXAdContainerEventListener, IXAdResponseInfo iXAdResponseInfo, View view) {
        this.b = context;
        this.d = activity;
        this.i = iXAdProdInfo;
        this.e = relativeLayout;
        this.a = iXAdContainerEventListener;
        this.f = iXAdResponseInfo;
        this.g = iXAdResponseInfo.getPrimaryAdInstanceInfo();
        this.h = view;
    }

    public IOAdTimer createOAdTimer(int i) {
        return new com.baidu.mobads.openad.f.a(i);
    }

    public IOAdTimer createOAdTimer(int i, int i2) {
        return new com.baidu.mobads.openad.f.a(i, i2);
    }

    public void fireAdMetrics(String str, HashMap hashMap) {
        String addParameters = m.a().i().addParameters(str, hashMap);
        com.baidu.mobads.openad.e.a aVar = new com.baidu.mobads.openad.e.a();
        d dVar = new d(addParameters, "");
        dVar.e = 1;
        aVar.a(dVar, Boolean.valueOf(true));
    }

    public Activity getActivity() {
        if (this.d == null && this.e != null) {
            this.d = (Activity) this.e.getContext();
        }
        return this.d;
    }

    public IXAdConstants getAdConstants() {
        return m.a().p();
    }

    public IXAdContainerEventListener getAdContainerListener() {
        return this.a;
    }

    public IXAdInstanceInfo getAdInstanceInfo() {
        return this.g;
    }

    public View getAdLeadingView() {
        return this.h;
    }

    public IXAdLogger getAdLogger() {
        return m.a().f();
    }

    public RelativeLayout getAdProdBase() {
        return this.e;
    }

    public IXAdProdInfo getAdProdInfo() {
        return this.i;
    }

    public IXAdResource getAdResource() {
        return m.a().g();
    }

    public IXAdResponseInfo getAdResponseInfo() {
        return this.f;
    }

    public IXAdURIUitls getAdUitls4URI() {
        return m.a().i();
    }

    public IXAdActivityUtils getAdUtils4Activity() {
        return m.a().o();
    }

    public IXAdBitmapUtils getAdUtils4Bitmap() {
        return m.a().h();
    }

    public IXAdCommonUtils getAdUtils4Common() {
        return m.a().m();
    }

    public IXAdIOUtils getAdUtils4IO() {
        return m.a().k();
    }

    public IXAdPackageUtils getAdUtils4Package() {
        return m.a().l();
    }

    public IXAdSystemUtils getAdUtils4System() {
        return m.a().n();
    }

    public IXAdViewUtils getAdUtils4View() {
        return m.a().j();
    }

    public Context getApplicationContext() {
        return this.b;
    }

    public IBase64 getBase64() {
        return m.a().e();
    }

    public IOAdDownloaderManager getDownloaderManager(Context context) {
        return m.a().b(context);
    }

    public IXAdErrorCode getErrorCode() {
        return m.a().q();
    }

    public String getProxyVersion() {
        return "8.23";
    }

    public void processCommand(String str, HashMap hashMap) {
        if (System.currentTimeMillis() - this.j > 1000) {
            this.j = System.currentTimeMillis();
            dispatchEvent(new a(this, "process_command", str, hashMap));
        }
    }

    public void registerAdService(String str, HashMap hashMap) {
        if (!this.k.containsKey(str)) {
            this.k.put(str, Integer.valueOf(1));
            dispatchEvent(new a(this, "regsiter_adservice", str, hashMap));
        }
    }

    public void unregisterAdService(String str) {
        if (this.k.containsKey(str)) {
            this.k.remove(str);
            dispatchEvent(new a(this, "unregsiter_adservice", str, new HashMap()));
        }
    }
}
