package com.baidu.mobads.vo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.baidu.mobads.a.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.j.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

public abstract class d implements IXAdRequestInfo {
    private String a = "android";
    protected String b = "";
    protected String c = "TODO";
    protected Context d;
    protected Activity e;
    protected SlotType f;
    protected IXAdProdInfo g;
    protected IXAdConstants h = m.a().p();
    private String i = "";
    private int j;
    private int k;
    private int l = m.a().p().getAdCreativeTypeImage();
    private String m = "LP,DL";
    private String n = "";
    private int o;
    private int p = 0;
    private int q;
    private String r = "";
    private String s = "";
    private String t = "";
    private boolean u = true;
    private long v = System.currentTimeMillis();

    public d(Context context, Activity activity, SlotType slotType) {
        Activity activity2 = null;
        if (context instanceof Activity) {
            activity2 = (Activity) context;
        }
        this.e = activity2;
        if (activity2 != null) {
            context = activity2.getApplicationContext();
        }
        this.d = context;
        if (this.e == null && activity != null) {
            this.e = activity;
        }
        this.f = slotType;
        this.g = new b(this, this.f);
        c(this.f.getValue());
    }

    protected abstract HashMap a();

    public void a(int i) {
        this.j = i;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.u = z;
    }

    public String b() {
        HashMap e = e();
        e.putAll(a());
        return m.a().i().getRequestAdUrl(this.b, e);
    }

    public void b(int i) {
        this.k = i;
    }

    public void b(String str) {
        this.m = str;
    }

    public void c(int i) {
        this.o = i;
    }

    public void c(String str) {
        this.n = str;
    }

    public IXAdProdInfo d() {
        return this.g;
    }

    public void d(int i) {
        this.q = i;
    }

    public void d(String str) {
        this.i = str;
    }

    @TargetApi(4)
    protected HashMap e() {
        Object obj;
        String str = "";
        IXAdSystemUtils n = m.a().n();
        IXAdCommonUtils m = m.a().m();
        HashMap hashMap = new HashMap();
        hashMap.put("net", "" + n.getNetworkCatagory(this.d));
        hashMap.put("u", "default");
        hashMap.put("ie", "1");
        hashMap.put(IXAdRequestInfo.AD_COUNT, "" + getN());
        hashMap.put(IXAdRequestInfo.MAX_TITLE_LENGTH, "512");
        hashMap.put(IXAdRequestInfo.MAX_CONTENT_LENGTH, "512");
        hashMap.put(IXAdRequestInfo.TEST_MODE, "1");
        hashMap.put(IXAdRequestInfo.AD_TYPE, "" + getAt());
        hashMap.put(IXAdRequestInfo.V, f() + "_" + a.c + "_" + "4.1.30");
        hashMap.put(IXAdRequestInfo.CS, "");
        hashMap.put(IXAdRequestInfo.PACKAGE, m.getAppPackage(this.d));
        hashMap.put(IXAdRequestInfo.SDK_VALID, "sdk_8.23");
        str = m.getAppId(this.d);
        hashMap.put(IXAdRequestInfo.COST_NAME, str + "_cpr");
        hashMap.put("appid", str);
        hashMap.put(IXAdRequestInfo.PHONE_TYPE, Build.MODEL);
        hashMap.put(IXAdRequestInfo.BRAND, n.getPhoneOSBrand());
        DisplayMetrics displayMetrics = m.getDisplayMetrics(this.d);
        hashMap.put(IXAdRequestInfo.DENSITY, "" + displayMetrics.density);
        hashMap.put(IXAdRequestInfo.WIDTH, "" + getW());
        hashMap.put(IXAdRequestInfo.HEIGHT, "" + getH());
        Rect screenRect = m.getScreenRect(this.d);
        hashMap.put(IXAdRequestInfo.SCREEN_WIDTH, "" + screenRect.width());
        hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + screenRect.height());
        hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(((float) getW()) / displayMetrics.density)));
        hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(((float) getH()) / displayMetrics.density)));
        hashMap.put(IXAdRequestInfo.SN, n.getSn(this.d));
        try {
            obj = "";
            List cell = n.getCell(this.d);
            if (cell.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < cell.size(); i++) {
                    String[] strArr = (String[]) cell.get(i);
                    stringBuilder.append(String.format("%s_%s_%s|", new Object[]{strArr[0], strArr[1], strArr[2]}));
                }
                obj = stringBuilder.substring(0, stringBuilder.length() - 1);
            }
        } catch (Exception e) {
            obj = "";
        }
        try {
            Object obj2;
            hashMap.put(IXAdRequestInfo.CELL_ID, obj);
            hashMap.put(IXAdRequestInfo.NETWORK_OPERATOR, n.getNetworkOperator(this.d));
            hashMap.put(IXAdRequestInfo.IMSI, m.getSubscriberId(this.d));
            try {
                str = "";
                if (n.getGPS(this.d) != null) {
                    System.currentTimeMillis();
                    str = String.format("%s_%s_%s", new Object[]{Double.valueOf(r1[0]), Double.valueOf(r1[1]), Double.valueOf(r1[2])});
                }
                obj2 = str;
            } catch (Exception e2) {
                obj2 = "";
            }
            hashMap.put(IXAdRequestInfo.GPS, obj2);
            try {
                obj2 = "";
                List wifi = n.getWIFI(this.d);
                if (wifi.size() > 0) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    for (int i2 = 0; i2 < wifi.size(); i2++) {
                        strArr = (String[]) wifi.get(i2);
                        stringBuilder2.append(String.format("%s_%s|", new Object[]{strArr[0], strArr[1]}));
                    }
                    obj = stringBuilder2.substring(0, stringBuilder2.length() - 1);
                } else {
                    obj = obj2;
                }
            } catch (Exception e3) {
                obj = obj2;
            }
            hashMap.put(IXAdRequestInfo.WIFI, obj);
            hashMap.put("swi", "" + (IXAdSystemUtils.NT_WIFI.equals(n.getNetworkType(this.d)) ? 1 : 0));
            hashMap.put("tel", "");
            try {
                hashMap.put("uk", URLEncoder.encode(getUk(), "utf-8"));
                hashMap.put("sex", URLEncoder.encode(getSex(), "utf-8"));
                hashMap.put("zip", URLEncoder.encode(getZip(), "utf-8"));
            } catch (Exception e4) {
            }
            hashMap.put("tab", n.isTablet(this.d) ? "1" : "0");
            hashMap.put("sdc", n.getAppSDC() + "," + n.getMem());
            hashMap.put(IXAdRequestInfo.ACT, getAct());
            hashMap.put("prod", getProd());
            hashMap.put(IXAdRequestInfo.OS, "android");
            hashMap.put(IXAdRequestInfo.OSV, VERSION.RELEASE);
            hashMap.put(IXAdRequestInfo.BDR, "" + VERSION.SDK_INT);
            hashMap.put("apinfo", m.getBaiduMapsInfo(this.d));
            hashMap.put("apid", getApid());
            hashMap.put("chid", m.getChannelId());
            hashMap.put("apt", "0");
            hashMap.put("ap", "" + getAp());
            hashMap.put("nt", n.getNetType(this.d));
            hashMap.put("udid", "");
            hashMap.put("ses", "" + getSes());
            hashMap.put("android_id", n.getAndroidId(this.d));
            hashMap.put("imei", n.getIMEI(this.d));
            hashMap.put("mac", n.getMacAddress(this.d));
            hashMap.put("cuid", n.getCUID(this.d));
            hashMap.put(IXAdRequestInfo.P_VER, "8.23");
            hashMap.put("req_id", m.createRequestId(this.d, getApid()));
            hashMap.put("cssid", n.isWifiConnected(this.d).booleanValue() ? n.getWifiConnected(this.d) : "");
        } catch (Exception e5) {
        }
        return hashMap;
    }

    public void e(int i) {
        this.p = i;
    }

    public String f() {
        return this.a;
    }

    public void f(int i) {
        this.l = i;
    }

    public String getAct() {
        return this.m;
    }

    public int getAp() {
        return this.p;
    }

    public String getApid() {
        return this.i;
    }

    public int getApt() {
        return this.o;
    }

    public int getAt() {
        return this.l;
    }

    public int getH() {
        return this.k;
    }

    public int getN() {
        return this.q;
    }

    public String getProd() {
        return this.n;
    }

    public long getSes() {
        return this.v;
    }

    public String getSex() {
        return this.s;
    }

    public String getUk() {
        return this.r;
    }

    public int getW() {
        return this.j;
    }

    public String getZip() {
        return this.t;
    }

    public boolean isCanClick() {
        return this.u;
    }
}
