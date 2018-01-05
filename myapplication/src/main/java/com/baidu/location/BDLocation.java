package com.baidu.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.location.a.a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class BDLocation implements Parcelable {
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final Creator CREATOR = new b();
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
    public static final int TypeCacheLocation = 65;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeServerError = 167;
    private int A;
    private String B;
    private int C;
    private String D;
    private List E;
    private int a;
    private String b;
    private double c;
    private double d;
    private boolean e;
    private double f;
    private boolean g;
    private float h;
    private boolean i;
    private float j;
    private boolean k;
    private int l;
    private float m;
    private String n;
    private boolean o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private a u;
    private String v;
    private String w;
    private String x;
    private boolean y;
    private int z;

    public BDLocation() {
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new a().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = null;
    }

    private BDLocation(Parcel parcel) {
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new a().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = null;
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readDouble();
        this.d = parcel.readDouble();
        this.f = parcel.readDouble();
        this.h = parcel.readFloat();
        this.j = parcel.readFloat();
        this.l = parcel.readInt();
        this.m = parcel.readFloat();
        this.v = parcel.readString();
        this.z = parcel.readInt();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.B = parcel.readString();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        parcel.readString();
        String readString7 = parcel.readString();
        this.u = new a().country(readString7).countryCode(parcel.readString()).province(readString).city(readString2).cityCode(readString6).district(readString3).street(readString4).streetNumber(readString5).build();
        boolean[] zArr = new boolean[7];
        this.C = parcel.readInt();
        this.D = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.A = parcel.readInt();
        try {
            parcel.readBooleanArray(zArr);
            this.e = zArr[0];
            this.g = zArr[1];
            this.i = zArr[2];
            this.k = zArr[3];
            this.o = zArr[4];
            this.t = zArr[5];
            this.y = zArr[6];
        } catch (Exception e) {
        }
        List arrayList = new ArrayList();
        parcel.readList(arrayList, Poi.class.getClassLoader());
        if (arrayList.size() == 0) {
            this.E = null;
        } else {
            this.E = arrayList;
        }
    }

    public BDLocation(BDLocation bDLocation) {
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new a().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = null;
        this.a = bDLocation.a;
        this.b = bDLocation.b;
        this.c = bDLocation.c;
        this.d = bDLocation.d;
        this.e = bDLocation.e;
        this.f = bDLocation.f;
        this.g = bDLocation.g;
        this.h = bDLocation.h;
        this.i = bDLocation.i;
        this.j = bDLocation.j;
        this.k = bDLocation.k;
        this.l = bDLocation.l;
        this.m = bDLocation.m;
        this.n = bDLocation.n;
        this.o = bDLocation.o;
        this.p = bDLocation.p;
        this.t = bDLocation.t;
        this.u = new a().country(bDLocation.u.country).countryCode(bDLocation.u.countryCode).province(bDLocation.u.province).city(bDLocation.u.city).cityCode(bDLocation.u.cityCode).district(bDLocation.u.district).street(bDLocation.u.street).streetNumber(bDLocation.u.streetNumber).build();
        this.v = bDLocation.v;
        this.w = bDLocation.w;
        this.x = bDLocation.x;
        this.A = bDLocation.A;
        this.z = bDLocation.z;
        this.y = bDLocation.y;
        this.B = bDLocation.B;
        this.C = bDLocation.C;
        this.D = bDLocation.D;
        this.q = bDLocation.q;
        this.r = bDLocation.r;
        this.s = bDLocation.s;
        if (bDLocation.E == null) {
            this.E = null;
            return;
        }
        List arrayList = new ArrayList();
        for (int i = 0; i < bDLocation.E.size(); i++) {
            Poi poi = (Poi) bDLocation.E.get(i);
            arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank()));
        }
        this.E = arrayList;
    }

    public BDLocation(String str) {
        String str2 = null;
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new a().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = null;
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                int parseInt = Integer.parseInt(jSONObject2.getString("error"));
                setLocType(parseInt);
                setTime(jSONObject2.getString("time"));
                JSONObject jSONObject3;
                if (parseInt == 61) {
                    jSONObject3 = jSONObject.getJSONObject("content");
                    jSONObject = jSONObject3.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject.getString("x")));
                    setRadius(Float.parseFloat(jSONObject3.getString("radius")));
                    setSpeed(Float.parseFloat(jSONObject3.getString("s")));
                    setDirection(Float.parseFloat(jSONObject3.getString("d")));
                    setSatelliteNumber(Integer.parseInt(jSONObject3.getString(IXAdRequestInfo.AD_COUNT)));
                    if (jSONObject3.has(IXAdRequestInfo.HEIGHT)) {
                        try {
                            setAltitude(jSONObject3.getDouble(IXAdRequestInfo.HEIGHT));
                        } catch (Exception e) {
                        }
                    }
                    try {
                        if (jSONObject3.has("in_cn")) {
                            setLocationWhere(Integer.parseInt(jSONObject3.getString("in_cn")));
                        } else {
                            setLocationWhere(1);
                        }
                    } catch (Exception e2) {
                    }
                    if (this.A == 0) {
                        setCoorType("wgs84");
                    } else {
                        setCoorType("gcj02");
                    }
                } else if (parseInt == TypeNetWorkLocation) {
                    JSONObject jSONObject4 = jSONObject.getJSONObject("content");
                    jSONObject = jSONObject4.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject.getString("x")));
                    setRadius(Float.parseFloat(jSONObject4.getString("radius")));
                    if (jSONObject4.has("sema")) {
                        Object string;
                        jSONObject2 = jSONObject4.getJSONObject("sema");
                        if (jSONObject2.has("aptag")) {
                            string = jSONObject2.getString("aptag");
                            if (TextUtils.isEmpty(string)) {
                                this.q = "";
                            } else {
                                this.q = string;
                            }
                        }
                        if (jSONObject2.has("aptagd")) {
                            JSONArray jSONArray = jSONObject2.getJSONObject("aptagd").getJSONArray("pois");
                            List arrayList = new ArrayList();
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                                arrayList.add(new Poi(jSONObject5.getString("pid"), jSONObject5.getString("pname"), jSONObject5.getDouble("pr")));
                            }
                            this.E = arrayList;
                        }
                        if (jSONObject2.has("poiregion")) {
                            string = jSONObject2.getString("poiregion");
                            if (!TextUtils.isEmpty(string)) {
                                this.r = string;
                            }
                        }
                        if (jSONObject2.has("regular")) {
                            string = jSONObject2.getString("regular");
                            if (!TextUtils.isEmpty(string)) {
                                this.s = string;
                            }
                        }
                    }
                    if (jSONObject4.has("addr")) {
                        String[] split = jSONObject4.getString("addr").split(",");
                        int length = split.length;
                        String str3 = length > 0 ? split[0] : null;
                        String str4 = length > 1 ? split[1] : null;
                        String str5 = length > 2 ? split[2] : null;
                        String str6 = length > 3 ? split[3] : null;
                        String str7 = length > 4 ? split[4] : null;
                        String str8 = length > 5 ? split[5] : null;
                        String str9 = length > 6 ? split[6] : null;
                        if (length > 7) {
                            str2 = split[7];
                        }
                        this.u = new a().country(str9).countryCode(str2).province(str3).city(str4).cityCode(str8).district(str5).street(str6).streetNumber(str7).build();
                        this.o = true;
                    } else {
                        this.o = false;
                        setAddrStr(null);
                    }
                    if (jSONObject4.has("floor")) {
                        this.v = jSONObject4.getString("floor");
                        if (TextUtils.isEmpty(this.v)) {
                            this.v = null;
                        }
                    }
                    if (jSONObject4.has("loctp")) {
                        this.B = jSONObject4.getString("loctp");
                        if (TextUtils.isEmpty(this.B)) {
                            this.B = null;
                        }
                    }
                    if (jSONObject4.has("bldgid")) {
                        this.w = jSONObject4.getString("bldgid");
                        if (TextUtils.isEmpty(this.w)) {
                            this.w = null;
                        }
                    }
                    if (jSONObject4.has("bldg")) {
                        this.x = jSONObject4.getString("bldg");
                        if (TextUtils.isEmpty(this.x)) {
                            this.x = null;
                        }
                    }
                    if (jSONObject4.has("ibav")) {
                        str2 = jSONObject4.getString("ibav");
                        if (TextUtils.isEmpty(str2)) {
                            this.z = 0;
                        } else if (str2.equals("0")) {
                            this.z = 0;
                        } else {
                            this.z = Integer.valueOf(str2).intValue();
                        }
                    }
                    try {
                        if (jSONObject4.has("in_cn")) {
                            setLocationWhere(Integer.parseInt(jSONObject4.getString("in_cn")));
                        } else {
                            setLocationWhere(1);
                        }
                    } catch (Exception e3) {
                    }
                    if (this.A == 0) {
                        setCoorType("wgs84");
                    } else {
                        setCoorType("gcj02");
                    }
                } else if (parseInt == 66 || parseInt == 68) {
                    jSONObject3 = jSONObject.getJSONObject("content");
                    jSONObject = jSONObject3.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject.getString("y")));
                    setLongitude(Double.parseDouble(jSONObject.getString("x")));
                    setRadius(Float.parseFloat(jSONObject3.getString("radius")));
                    a(Boolean.valueOf(Boolean.parseBoolean(jSONObject3.getString("isCellChanged"))));
                    setCoorType("gcj02");
                } else if (parseInt == TypeServerError) {
                    setLocationWhere(2);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                this.a = 0;
                this.o = false;
            }
        }
    }

    private String a() {
        return this.D;
    }

    private void a(Boolean bool) {
        this.t = bool.booleanValue();
    }

    private static String b() {
        return Build.MODEL;
    }

    public int describeContents() {
        return 0;
    }

    public String getAdUrl(String str) {
        String valueOf = String.valueOf(this.c);
        String valueOf2 = String.valueOf(this.d);
        String a = a();
        return "http://lba.baidu.com/" + "?a=" + Jni.E("ak=" + str + "&" + "lat=" + valueOf + "&" + "lng=" + valueOf2 + "&" + "cu=" + a + "&" + "mb=" + b());
    }

    public String getAddrStr() {
        return this.u.address;
    }

    public a getAddress() {
        return this.u;
    }

    public double getAltitude() {
        return this.f;
    }

    public String getBuildingID() {
        return this.w;
    }

    public String getBuildingName() {
        return this.x;
    }

    public String getCity() {
        return this.u.city;
    }

    public String getCityCode() {
        return this.u.cityCode;
    }

    public String getCoorType() {
        return this.n;
    }

    public String getCountry() {
        return this.u.country;
    }

    public String getCountryCode() {
        return this.u.countryCode;
    }

    public float getDerect() {
        return this.m;
    }

    public float getDirection() {
        return this.m;
    }

    public String getDistrict() {
        return this.u.district;
    }

    public String getFloor() {
        return this.v;
    }

    public double getLatitude() {
        return this.c;
    }

    public int getLocType() {
        return this.a;
    }

    public String getLocationDescribe() {
        return this.q;
    }

    public int getLocationWhere() {
        return this.A;
    }

    public double getLongitude() {
        return this.d;
    }

    public String getNetworkLocationType() {
        return this.B;
    }

    public int getOperators() {
        return this.C;
    }

    public List getPoiList() {
        return this.E;
    }

    public String getProvince() {
        return this.u.province;
    }

    public float getRadius() {
        return this.j;
    }

    public int getSatelliteNumber() {
        this.k = true;
        return this.l;
    }

    public String getSemaAptag() {
        return this.q;
    }

    public float getSpeed() {
        return this.h;
    }

    public String getStreet() {
        return this.u.street;
    }

    public String getStreetNumber() {
        return this.u.streetNumber;
    }

    public String getTime() {
        return this.b;
    }

    public boolean hasAddr() {
        return this.o;
    }

    public boolean hasAltitude() {
        return this.e;
    }

    public boolean hasRadius() {
        return this.i;
    }

    public boolean hasSateNumber() {
        return this.k;
    }

    public boolean hasSpeed() {
        return this.g;
    }

    public void internalSet(int i, String str) {
        if (str != null && i == 0) {
            this.D = str;
        }
    }

    public boolean isCellChangeFlag() {
        return this.t;
    }

    public boolean isIndoorLocMode() {
        return this.y;
    }

    public int isParkAvailable() {
        return this.z;
    }

    public void setAddr(a aVar) {
        if (aVar != null) {
            this.u = aVar;
            this.o = true;
        }
    }

    public void setAddrStr(String str) {
        this.p = str;
        if (str == null) {
            this.o = false;
        } else {
            this.o = true;
        }
    }

    public void setAltitude(double d) {
        this.f = d;
        this.e = true;
    }

    public void setBuildingID(String str) {
        this.w = str;
    }

    public void setBuildingName(String str) {
        this.x = str;
    }

    public void setCoorType(String str) {
        this.n = str;
    }

    public void setDirection(float f) {
        this.m = f;
    }

    public void setFloor(String str) {
        this.v = str;
    }

    public void setIndoorLocMode(boolean z) {
        this.y = z;
    }

    public void setLatitude(double d) {
        this.c = d;
    }

    public void setLocType(int i) {
        this.a = i;
    }

    public void setLocationDescribe(String str) {
        this.q = str;
    }

    public void setLocationWhere(int i) {
        this.A = i;
    }

    public void setLongitude(double d) {
        this.d = d;
    }

    public void setNetworkLocationType(String str) {
        this.B = str;
    }

    public void setOperators(int i) {
        this.C = i;
    }

    public void setParkAvailable(int i) {
        this.z = i;
    }

    public void setPoiList(List list) {
        this.E = list;
    }

    public void setRadius(float f) {
        this.j = f;
        this.i = true;
    }

    public void setSatelliteNumber(int i) {
        this.l = i;
    }

    public void setSpeed(float f) {
        this.h = f;
        this.g = true;
    }

    public void setTime(String str) {
        this.b = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.d);
        parcel.writeDouble(this.f);
        parcel.writeFloat(this.h);
        parcel.writeFloat(this.j);
        parcel.writeInt(this.l);
        parcel.writeFloat(this.m);
        parcel.writeString(this.v);
        parcel.writeInt(this.z);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.B);
        parcel.writeString(this.u.province);
        parcel.writeString(this.u.city);
        parcel.writeString(this.u.district);
        parcel.writeString(this.u.street);
        parcel.writeString(this.u.streetNumber);
        parcel.writeString(this.u.cityCode);
        parcel.writeString(this.u.address);
        parcel.writeString(this.u.country);
        parcel.writeString(this.u.countryCode);
        parcel.writeInt(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.A);
        parcel.writeBooleanArray(new boolean[]{this.e, this.g, this.i, this.k, this.o, this.t, this.y});
        parcel.writeList(this.E);
    }
}
