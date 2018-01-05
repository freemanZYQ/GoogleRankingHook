package com.b.f;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.moxiu.b.d.c;
import com.moxiu.b.d.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
    public static com.b.a.a a(Context context, JSONObject jSONObject, String str, int i, String str2) {
        boolean z = true;
        com.b.a.a aVar = new com.b.a.a();
        aVar.C = "dianou";
        aVar.H = str;
        aVar.L = i;
        aVar.S = true;
        aVar.D = jSONObject.optString("subtype", "app");
        aVar.n = jSONObject.optString("jumptype", "nothing");
        aVar.E = jSONObject.optString("showtype", "0");
        aVar.B = jSONObject.optString("id", str2);
        aVar.P = jSONObject.optString("adsource", "");
        if (TextUtils.isEmpty(aVar.P) || TextUtils.isEmpty(aVar.B)) {
            return null;
        }
        aVar.d = jSONObject.optString("title", "");
        aVar.c = jSONObject.optString("summary", "");
        aVar.b = jSONObject.optString("package", "");
        aVar.g = jSONObject.optString("icon", "");
        aVar.h = jSONObject.optString("cover", "");
        aVar.a = jSONObject.optString("targeturl", "");
        aVar.i = jSONObject.optString("downurl", "");
        aVar.q = jSONObject.optString("jumpaction", "");
        aVar.p = jSONObject.optString("jumppackage", "");
        aVar.o = jSONObject.optString("jumpuri", "");
        aVar.T = jSONObject.optString("identifier", "");
        aVar.r = jSONObject.optInt("jumpversion", 0);
        aVar.A = jSONObject.optString("httpmethod", "");
        if (jSONObject.optInt("ishot", -1) == 0) {
            z = false;
        }
        aVar.V = z;
        aVar.U = jSONObject.optInt("locate", 0);
        String optString = jSONObject.optString("adtype", "");
        if ("chg".equals(optString)) {
            aVar.O = 0;
        } else if ("exch_s".equals(optString)) {
            aVar.O = 3;
        } else if ("exch_c".equals(optString)) {
            aVar.O = 2;
        } else if ("exch_d".equals(optString)) {
            aVar.O = 1;
        }
        try {
            aVar.e = jSONObject.optString("downnum", "");
            aVar.f = jSONObject.optInt("grade", 5);
            aVar.j = jSONObject.optString("price", "");
            aVar.k = jSONObject.optString("promoprice", "");
            aVar.l = jSONObject.optString("sell", "");
        } catch (Exception e) {
        }
        try {
            JSONArray jSONArray;
            int i2;
            String string;
            if (jSONObject.has("covers")) {
                try {
                    aVar.m = new ArrayList();
                    jSONArray = jSONObject.getJSONArray("covers");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (i2 = 0; i2 < jSONArray.length(); i2++) {
                            aVar.m.add(jSONArray.optString(i2, ""));
                        }
                    }
                } catch (Exception e2) {
                }
            }
            if (jSONObject.has("exp_tracking")) {
                try {
                    aVar.s = new HashMap();
                    JSONObject jSONObject2 = jSONObject.getJSONObject("exp_tracking");
                    Iterator keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        optString = (String) keys.next();
                        JSONArray jSONArray2 = jSONObject2.getJSONArray(optString);
                        if (jSONArray2 != null && jSONArray2.length() > 0) {
                            List arrayList = new ArrayList();
                            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                arrayList.add(jSONArray2.getString(i3));
                            }
                            if (arrayList != null && arrayList.size() > 0) {
                                aVar.s.put(optString, arrayList);
                            }
                        }
                    }
                } catch (Exception e3) {
                }
            }
            if (jSONObject.has("cli_tracking")) {
                try {
                    aVar.t = new ArrayList();
                    jSONArray = jSONObject.getJSONArray("cli_tracking");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (i2 = 0; i2 < jSONArray.length(); i2++) {
                            string = jSONArray.getString(i2);
                            if (string != null && string.length() > 0) {
                                aVar.t.add(string);
                            }
                        }
                    }
                } catch (Exception e4) {
                }
            }
            if (jSONObject.has("download_tracking")) {
                try {
                    aVar.u = new ArrayList();
                    jSONArray = jSONObject.getJSONArray("download_tracking");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (i2 = 0; i2 < jSONArray.length(); i2++) {
                            string = jSONArray.getString(i2);
                            if (string != null && string.length() > 0) {
                                aVar.u.add(string);
                            }
                        }
                    }
                } catch (Exception e5) {
                }
            }
            if (jSONObject.has("install_tracking")) {
                try {
                    aVar.v = new ArrayList();
                    jSONArray = jSONObject.getJSONArray("install_tracking");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (i2 = 0; i2 < jSONArray.length(); i2++) {
                            String string2 = jSONArray.getString(i2);
                            if (string2 != null && string2.length() > 0) {
                                aVar.v.add(string2);
                            }
                        }
                    }
                } catch (Exception e6) {
                }
            }
            return ((TextUtils.isEmpty(aVar.h) || aVar.h.length() < 10) && !"rc".equals(aVar.D)) ? null : "jingdong".equals(aVar.n) ? null : (((!"third-app".equals(aVar.n) || (!TextUtils.isEmpty(aVar.p) && !TextUtils.isEmpty(aVar.o) && c.c(context, aVar.p) && aVar.r >= 0 && c.d(context, aVar.p) >= aVar.r)) && !e.a(aVar.o)) || !(TextUtils.isEmpty(aVar.a) || "dianou".equals(aVar.P))) ? ("app".equals(aVar.D) && (TextUtils.isEmpty(aVar.b) || TextUtils.isEmpty(aVar.i) || c.c(context, aVar.b))) ? null : aVar : null;
        } catch (Exception e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public static List a(Context context, JSONObject jSONObject, String str, int i) {
        List arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("adlist");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            String optString = jSONObject2.optString("type", "");
            if ("ade".equals(optString) && c.i(context).booleanValue() && !"GT-I9152".equals(Build.MODEL)) {
                try {
                    com.moxiu.gdlibrary.e eVar = (com.moxiu.gdlibrary.e) com.b.d.a.c(context, "ade");
                    if (eVar != null) {
                        eVar.G = jSONObject2.optString("thirdId", "");
                        if (!TextUtils.isEmpty(eVar.G) || eVar.G.length() >= 3) {
                            eVar.C = "ade";
                            eVar.H = str;
                            eVar.D = jSONObject2.optString("subtype", "");
                            eVar.P = jSONObject2.optString("adsource", "");
                            eVar.B = jSONObject2.optString("id", "");
                            eVar.T = jSONObject2.optString("identifier", "");
                            if (!(TextUtils.isEmpty(eVar.P) || TextUtils.isEmpty(eVar.B))) {
                                eVar.L = i2;
                                eVar.I = i;
                                eVar.S = false;
                                arrayList.add(eVar);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else if ("baidu".equals(optString) && c.i(context).booleanValue() && c.j(context).booleanValue()) {
                try {
                    com.moxiu.a.a aVar = (com.moxiu.a.a) com.b.d.a.c(context, "baidu");
                    if (aVar != null) {
                        aVar.G = jSONObject2.optString("thirdId", "");
                        if (!TextUtils.isEmpty(aVar.G) || aVar.G.length() >= 3) {
                            aVar.C = "baidu";
                            aVar.H = str;
                            aVar.D = jSONObject2.optString("subtype", "");
                            aVar.P = jSONObject2.optString("adsource", "");
                            aVar.B = jSONObject2.optString("id", "");
                            aVar.T = jSONObject2.optString("identifier", "");
                            if (!(TextUtils.isEmpty(aVar.P) || TextUtils.isEmpty(aVar.B))) {
                                aVar.L = i2;
                                aVar.I = i;
                                aVar.S = false;
                                arrayList.add(aVar);
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if ("dianou".equals(optString)) {
                com.b.a.a a = a(context, jSONObject2, str, i2, "");
                if (a != null) {
                    c.b("parse add dianou===>" + a);
                    arrayList.add(a);
                }
            }
        }
        return arrayList;
    }
}
