package com.baidu.mobads.vo;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.j.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class XAdInstanceInfo implements Parcelable, IXAdInstanceInfo, Cloneable {
    public static final Creator CREATOR = new a();
    public static final String TAG = "XAdInstanceInfo";
    private Set A;
    private Set B;
    private Set C;
    private Set D;
    private Set E;
    private Set F;
    private Set G;
    private Set H;
    private Set I;
    private int J;
    private boolean K;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private long Q;
    private int R;
    private String S;
    private int T;
    private boolean U;
    private long V;
    private CreativeType W;
    private String X;
    private int Y;
    private boolean Z;
    private String a;
    private boolean aa;
    private boolean ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    private boolean ag;
    private String ah;
    private String ai;
    private String aj;
    private JSONArray ak;
    private boolean al;
    private boolean am;
    private String an;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private int l;
    private String m;
    private String n;
    private boolean o;
    private int p;
    @Deprecated
    private boolean q;
    @Deprecated
    private int r;
    private String s;
    private String t;
    private JSONObject u;
    private String v;
    private int w;
    private int x;
    @Deprecated
    private String y;
    private Set z;

    private XAdInstanceInfo(Parcel parcel) {
        this.b = "-1";
        this.z = new HashSet();
        this.A = new HashSet();
        this.B = new HashSet();
        this.C = new HashSet();
        this.D = new HashSet();
        this.E = new HashSet();
        this.F = new HashSet();
        this.G = new HashSet();
        this.H = new HashSet();
        this.I = new HashSet();
        this.K = true;
        this.W = CreativeType.NONE;
        this.Z = true;
        this.ab = true;
        this.ac = true;
        this.al = false;
        this.am = false;
        this.an = null;
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.P = parcel.readString();
        this.S = parcel.readString();
        this.O = parcel.readString();
        this.s = parcel.readString();
        this.ai = parcel.readString();
        this.L = parcel.readString();
        this.e = parcel.readString();
        this.k = parcel.readString();
        this.a = parcel.readString();
        this.v = parcel.readString();
        this.j = parcel.readString();
        this.i = parcel.readString();
        this.g = parcel.readString();
        this.x = parcel.readInt();
        this.w = parcel.readInt();
        this.t = parcel.readString();
        this.y = parcel.readString();
        this.h = parcel.readString();
        this.M = parcel.readString();
        this.f = parcel.readString();
        this.d = parcel.readString();
        this.X = parcel.readString();
        this.n = parcel.readString();
        this.p = parcel.readInt();
        this.ah = parcel.readString();
        this.aj = parcel.readString();
    }

    @SuppressLint({"DefaultLocale"})
    public XAdInstanceInfo(JSONObject jSONObject) {
        this.b = "-1";
        this.z = new HashSet();
        this.A = new HashSet();
        this.B = new HashSet();
        this.C = new HashSet();
        this.D = new HashSet();
        this.E = new HashSet();
        this.F = new HashSet();
        this.G = new HashSet();
        this.H = new HashSet();
        this.I = new HashSet();
        this.K = true;
        this.W = CreativeType.NONE;
        this.Z = true;
        this.ab = true;
        this.ac = true;
        this.al = false;
        this.am = false;
        this.an = null;
        this.u = jSONObject;
        try {
            String str;
            int i;
            this.V = System.currentTimeMillis();
            this.J = jSONObject.optInt(IXAdRequestInfo.ACT);
            this.v = jSONObject.optString("html", null);
            this.b = jSONObject.optString("id", "-1");
            this.c = jSONObject.optString("src", "");
            this.d = jSONObject.optString("tit", "");
            this.e = jSONObject.optString("desc", "");
            this.f = jSONObject.optString("surl", "");
            this.h = jSONObject.optString("phone", "");
            this.i = jSONObject.optString("w_picurl", "");
            this.j = jSONObject.optString("icon", "");
            this.k = jSONObject.optString("exp2", "{}");
            this.l = jSONObject.optInt("anti_tag");
            this.n = jSONObject.optString("vurl", "");
            this.p = jSONObject.optInt("duration", 0);
            this.o = jSONObject.optInt("sound", 0) != 1;
            this.q = jSONObject.optInt("iv", 0) == 1;
            this.r = jSONObject.optInt("dur", 0);
            this.s = jSONObject.optString("curl", "");
            this.t = jSONObject.optString("ori_curl", "");
            this.g = jSONObject.optString("type");
            if (this.v != null && this.v.length() > 0 && (this.v.contains("html") || this.v.contains("HTML"))) {
                this.W = CreativeType.HTML;
            } else if (this.g != null) {
                if (this.g.equals("text")) {
                    this.W = CreativeType.TEXT;
                } else if (this.g.equals("image")) {
                    if (!(this.i == null || this.i.equals(""))) {
                        int lastIndexOf = this.i.toLowerCase(Locale.getDefault()).lastIndexOf(46);
                        str = "";
                        if (lastIndexOf >= 0) {
                            str = this.i.toLowerCase(Locale.getDefault()).substring(lastIndexOf);
                        }
                        if (str.equals(".gif")) {
                            this.W = CreativeType.GIF;
                        } else {
                            this.W = CreativeType.STATIC_IMAGE;
                        }
                    }
                } else if (this.g.equals("rm")) {
                    this.W = CreativeType.RM;
                } else if (this.g.equals("video")) {
                    this.W = CreativeType.VIDEO;
                }
            }
            this.w = jSONObject.optInt(IXAdRequestInfo.WIDTH);
            this.x = jSONObject.optInt(IXAdRequestInfo.HEIGHT);
            this.y = jSONObject.optString("lb_phone", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("nwinurl");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                str = jSONObject.optString("winurl", "");
                if (!str.equals("")) {
                    this.z.add(str);
                }
            } else {
                for (i = 0; i < optJSONArray.length(); i++) {
                    this.z.add(optJSONArray.getString(i));
                }
            }
            str = jSONObject.optString("clklogurl", "");
            if (!str.equals("")) {
                this.z.add(str);
            }
            optJSONArray = jSONObject.optJSONArray("mon");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("s", "");
                    String optString2 = jSONObject2.optString("c", "");
                    a(optString);
                    b(optString2);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("monitors");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    JSONArray optJSONArray2;
                    if (str.equals("s")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            a(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("vskip")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addSkipMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("scard")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addScardMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("ccard")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addCcardMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("vstart")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addStartMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("vfullscreen")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addFullScreenMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("vclose")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addCloseMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("cstartcard")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            addCstartcardMonitorTrackers(optJSONArray2.optString(i));
                        }
                    } else if (str.equals("c")) {
                        optJSONArray2 = optJSONObject.optJSONArray(str);
                        for (i = 0; i < optJSONArray2.length(); i++) {
                            b(optJSONArray2.optString(i));
                        }
                    }
                }
            }
            this.K = true;
            this.L = jSONObject.optString("cf", "");
            this.M = jSONObject.optString("qk", "");
            this.N = this.M + "_" + new Random().nextLong() + System.currentTimeMillis() + "|";
            this.P = jSONObject.optString("appname", "");
            this.O = jSONObject.optString(IXAdRequestInfo.PACKAGE, "");
            this.Q = jSONObject.optLong("sz", 0);
            this.R = jSONObject.optInt("sb", 0);
            this.S = jSONObject.optString("apo", "");
            this.T = jSONObject.optInt("po", 0);
            this.U = jSONObject.optInt("st", 0) == 1;
        } catch (Exception e) {
            m.a().f().e(TAG, e.getMessage());
        }
    }

    final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.A.add(str);
        }
    }

    public void addCcardMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.F.add(str);
        }
    }

    public void addCloseMonitorTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.H.add(str);
        }
    }

    public void addCstartcardMonitorTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.I.add(str);
        }
    }

    public void addFullScreenMonitorTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.G.add(str);
        }
    }

    public void addScardMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.E.add(str);
        }
    }

    public void addSkipMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.D.add(str);
        }
    }

    public void addStartMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.C.add(str);
        }
    }

    final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.B.add(str);
        }
    }

    protected Object clone() {
        return super.clone();
    }

    public int describeContents() {
        return 0;
    }

    public boolean getAPOOpen() {
        return this.am;
    }

    public int getActionType() {
        return this.J;
    }

    public String getAdId() {
        return this.b;
    }

    public String getAdSource() {
        return this.c;
    }

    public int getAntiTag() {
        return this.l;
    }

    public String getAppName() {
        return this.P;
    }

    public String getAppOpenStrs() {
        return this.S;
    }

    public String getAppPackageName() {
        return this.O;
    }

    public long getAppSize() {
        return this.Q;
    }

    public List getCcardTrackers() {
        return new ArrayList(this.F);
    }

    public String getClickThroughUrl() {
        return this.s;
    }

    public String getClklogurl() {
        return this.ai;
    }

    public List getCloseTrackers() {
        return new ArrayList(this.H);
    }

    public String getConfirmBorderPercent() {
        return this.L;
    }

    public long getCreateTime() {
        return this.V;
    }

    public CreativeType getCreativeType() {
        return this.W;
    }

    public List getCstartcardTrackers() {
        return new ArrayList(this.I);
    }

    public String getDescription() {
        return this.e;
    }

    public int getDlTunnel() {
        return this.Y;
    }

    public String getExp2ForSingleAd() {
        return this.k;
    }

    public List getFullScreenTrackers() {
        return new ArrayList(this.G);
    }

    public String getFwt() {
        return this.a;
    }

    public int getHoursInADayToShowAd() {
        return this.r;
    }

    public String getHtmlSnippet() {
        return this.v;
    }

    public String getIconUrl() {
        return this.j;
    }

    public Set getImpressionUrls() {
        return this.z;
    }

    public String getLocalCreativeURL() {
        return this.m;
    }

    public int getMainMaterialHeight() {
        return this.x;
    }

    public int getMainMaterialWidth() {
        return this.w;
    }

    public String getMainPictureUrl() {
        return this.i;
    }

    public String getMaterialType() {
        return this.g;
    }

    public JSONArray getNwinurl() {
        return this.ak;
    }

    public String getOriginClickUrl() {
        return this.t;
    }

    public JSONObject getOriginJsonObject() {
        return this.u;
    }

    public String getPage() {
        return this.an;
    }

    public String getPhoneForLocalBranding() {
        return this.y;
    }

    public String getPhoneNumber() {
        return this.h;
    }

    public int getPointsForWall() {
        return this.T;
    }

    public String getQueryKey() {
        return this.M;
    }

    public List getScardTrackers() {
        return new ArrayList(this.E);
    }

    public List getSkipTrackers() {
        return new ArrayList(this.D);
    }

    public String getSponsorUrl() {
        return this.f;
    }

    public List getStartTrackers() {
        return new ArrayList(this.C);
    }

    public int getSwitchButton() {
        return this.R;
    }

    public List getThirdClickTrackingUrls() {
        return new ArrayList(this.B);
    }

    public List getThirdImpressionTrackingUrls() {
        return new ArrayList(this.A);
    }

    public String getTitle() {
        return this.d;
    }

    public String getUniqueId() {
        return this.N;
    }

    public String getUrl() {
        return this.X;
    }

    public int getVideoDuration() {
        return this.p;
    }

    public String getVideoUrl() {
        return this.n;
    }

    public String getVurl() {
        return this.ah;
    }

    public String getWinurl() {
        return this.aj;
    }

    public boolean isActionOnlyWifi() {
        return this.K;
    }

    public boolean isAutoOpen() {
        return this.ab;
    }

    public boolean isCanCancel() {
        return this.af;
    }

    public boolean isCanDelete() {
        return this.ag;
    }

    public boolean isClose() {
        return this.aa;
    }

    public boolean isIconVisibleForImageType() {
        return this.q;
    }

    public boolean isInapp() {
        return this.Z;
    }

    public boolean isPopNotif() {
        return this.ac;
    }

    public boolean isSecondConfirmed() {
        return this.al;
    }

    public boolean isTaskDoneForWall() {
        return this.U;
    }

    public boolean isTooLarge() {
        return this.ae;
    }

    public Boolean isValid() {
        return Boolean.valueOf(!"-1".equalsIgnoreCase(getAdId()));
    }

    public boolean isVideoMuted() {
        return this.o;
    }

    public boolean isWifiTargeted() {
        return this.ad;
    }

    public void setAPOOpen(boolean z) {
        this.am = z;
    }

    public void setActionOnlyWifi(boolean z) {
        this.K = z;
    }

    public void setActionType(int i) {
        this.J = i;
    }

    public void setAdId(String str) {
        this.b = str;
    }

    public void setAdSource(String str) {
        this.c = str;
    }

    public void setAntiTag(int i) {
        this.l = i;
    }

    public void setAppName(String str) {
        this.P = str;
    }

    public void setAppOpenStrs(String str) {
        this.S = str;
    }

    public void setAppPackageName(String str) {
        this.O = str;
    }

    public void setAppSize(long j) {
        this.Q = j;
    }

    public void setAutoOpen(boolean z) {
        this.ab = z;
    }

    public void setCanCancel(boolean z) {
        this.af = z;
    }

    public void setCanDelete(boolean z) {
        this.ag = z;
    }

    public void setCcardTrackers(List list) {
        this.F.addAll(list);
    }

    public void setClickThroughUrl(String str) {
        this.s = str;
    }

    public void setClklogurl(String str) {
        this.ai = str;
    }

    public void setClose(boolean z) {
        this.aa = z;
    }

    public void setCloseTrackers(List list) {
        this.H.clear();
        this.H.addAll(list);
    }

    public void setConfirmBorderPercent(String str) {
        this.L = str;
    }

    public void setCreateTime(long j) {
        this.V = j;
    }

    public void setCreativeType(CreativeType creativeType) {
        this.W = creativeType;
    }

    public void setCstartcardTrackers(List list) {
        this.I.clear();
        this.I.addAll(list);
    }

    public void setDescription(String str) {
        this.e = str;
    }

    public void setDlTunnel(int i) {
        this.Y = i;
    }

    public void setExp2ForSingleAd(String str) {
        this.k = str;
    }

    public void setFullScreenTrackers(List list) {
        this.G.addAll(list);
    }

    public void setFwt(String str) {
        this.a = str;
    }

    public void setHoursInADayToShowAd(int i) {
        this.r = i;
    }

    public void setHtmlSnippet(String str) {
        this.v = str;
    }

    public void setIconUrl(String str) {
        this.j = str;
    }

    public void setIconVisibleForImageType(boolean z) {
        this.q = z;
    }

    public void setImpressionUrls(Set set) {
        this.z = set;
    }

    public void setInapp(boolean z) {
        this.Z = z;
    }

    public void setLocalCreativeURL(String str) {
        this.m = str;
    }

    public void setMainMaterialHeight(int i) {
        this.x = i;
    }

    public void setMainMaterialWidth(int i) {
        this.w = i;
    }

    public void setMainPictureUrl(String str) {
        this.i = str;
    }

    public void setMaterialType(String str) {
        this.g = str;
    }

    public void setNwinurl(JSONArray jSONArray) {
        this.ak = jSONArray;
    }

    public void setOriginClickUrl(String str) {
        this.t = str;
    }

    public void setPage(String str) {
        this.an = str;
    }

    public void setPhoneForLocalBranding(String str) {
        this.y = str;
    }

    public void setPhoneNumber(String str) {
        this.h = str;
    }

    public void setPointsForWall(int i) {
        this.T = i;
    }

    public void setPopNotif(boolean z) {
        this.ac = z;
    }

    public void setQueryKey(String str) {
        this.M = str;
    }

    public void setScardTrackers(List list) {
        this.E.addAll(list);
    }

    public void setSecondConfirmed(boolean z) {
        this.al = z;
    }

    public void setSkipTrackers(List list) {
        this.D.addAll(list);
    }

    public void setSponsorUrl(String str) {
        this.f = str;
    }

    public void setStartTrackers(List list) {
        this.C.clear();
        this.C.addAll(list);
    }

    public void setSwitchButton(int i) {
        this.R = i;
    }

    public void setTaskDoneForWall(boolean z) {
        this.U = z;
    }

    public void setThirdClickTrackingUrls(Set set) {
        this.B = set;
    }

    public void setThirdImpressionTrackingUrls(Set set) {
        this.A = set;
    }

    public void setTitle(String str) {
        this.d = str;
    }

    public void setTooLarge(boolean z) {
        this.ae = z;
    }

    public void setUrl(String str) {
        this.X = str;
    }

    public void setVideoDuration(int i) {
        this.p = i;
    }

    public void setVideoMuted(boolean z) {
        this.o = z;
    }

    public void setVideoUrl(String str) {
        this.n = str;
    }

    public void setVurl(String str) {
        this.ah = str;
    }

    public void setWifiTargeted(boolean z) {
        this.ad = z;
    }

    public void setWinurl(String str) {
        this.aj = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.P);
        parcel.writeString(this.S);
        parcel.writeString(this.O);
        parcel.writeString(this.s);
        parcel.writeString(this.ai);
        parcel.writeString(this.L);
        parcel.writeString(this.e);
        parcel.writeString(this.k);
        parcel.writeString(this.a);
        parcel.writeString(this.v);
        parcel.writeString(this.j);
        parcel.writeString(this.i);
        parcel.writeString(this.g);
        parcel.writeInt(this.x);
        parcel.writeInt(this.w);
        parcel.writeString(this.t);
        parcel.writeString(this.y);
        parcel.writeString(this.h);
        parcel.writeString(this.M);
        parcel.writeString(this.f);
        parcel.writeString(this.d);
        parcel.writeString(this.X);
        parcel.writeString(this.n);
        parcel.writeInt(this.p);
        parcel.writeString(this.ah);
        parcel.writeString(this.aj);
    }
}
