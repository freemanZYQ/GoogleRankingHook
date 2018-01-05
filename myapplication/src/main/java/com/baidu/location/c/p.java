package com.baidu.location.c;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

enum p extends b {
    p(String str, int i, String str2, String str3, String str4, int i2, int i3) {
        super(str, i, str2, str3, str4, i2, i3);
    }

    List a(JSONObject jSONObject, String str, int i) {
        Iterator keys = jSONObject.keys();
        List arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        while (keys.hasNext()) {
            JSONArray jSONArray;
            JSONArray jSONArray2 = null;
            StringBuffer stringBuffer2 = new StringBuffer();
            String str2 = (String) keys.next();
            b.b(stringBuffer, str2, str, 1);
            try {
                jSONArray = jSONObject.getJSONArray(str2);
            } catch (JSONException e) {
                jSONArray = jSONArray2;
            }
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    Object obj = null;
                    Object obj2 = null;
                    String str3 = null;
                    String str4 = null;
                    String str5 = null;
                    Object obj3 = null;
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (jSONObject2.has("pid")) {
                            str3 = jSONObject2.getString("pid");
                        }
                        if (jSONObject2.has("ne")) {
                            str4 = jSONObject2.getString("ne");
                        }
                        if (jSONObject2.has(IXAdRequestInfo.PHONE_TYPE)) {
                            str5 = jSONObject2.getString(IXAdRequestInfo.PHONE_TYPE);
                        }
                        if (jSONObject2.has("rk")) {
                            obj3 = Integer.valueOf(jSONObject2.getInt("rk"));
                        }
                        if (jSONObject2.has("x")) {
                            obj = Double.valueOf(jSONObject2.getDouble("x"));
                        }
                        if (jSONObject2.has("y")) {
                            obj2 = Double.valueOf(jSONObject2.getDouble("y"));
                        }
                        if (stringBuffer2.length() > 0) {
                            stringBuffer2.append(",");
                        }
                        stringBuffer2.append("(\"").append(str3).append("\",\"").append(str2).append("\",\"").append(str4).append("\",\"").append(str5).append("\",").append(obj).append(",").append(obj2).append(",").append(obj3).append(")");
                    } catch (JSONException e2) {
                    }
                    if (i2 % 50 == 49) {
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCPOI", stringBuffer2.toString()}));
                        stringBuffer2.setLength(0);
                    }
                }
                if (stringBuffer2.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCPOI", stringBuffer2.toString()}));
                }
            }
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCUPDATE", stringBuffer}));
        }
        arrayList.add(String.format(Locale.US, "DELETE FROM RGCPOI WHERE pid NOT IN (SELECT pid FROM RGCPOI LIMIT %d);", new Object[]{Integer.valueOf(i)}));
        return arrayList;
    }
}
