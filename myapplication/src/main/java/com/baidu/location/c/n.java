package com.baidu.location.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

enum n extends b {
    n(String str, int i, String str2, String str3, String str4, int i2, int i3) {
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
            b.b(stringBuffer, str2, str, 0);
            try {
                jSONArray = jSONObject.getJSONArray(str2);
            } catch (JSONException e) {
                jSONArray = jSONArray2;
            }
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    Object obj = null;
                    Object obj2 = null;
                    Object obj3 = null;
                    Object obj4 = null;
                    String str3 = null;
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (jSONObject2.has("st")) {
                            str3 = jSONObject2.getString("st");
                        }
                        if (jSONObject2.has("x1")) {
                            obj = Double.valueOf(jSONObject2.getDouble("x1"));
                        }
                        if (jSONObject2.has("y1")) {
                            obj2 = Double.valueOf(jSONObject2.getDouble("y1"));
                        }
                        if (jSONObject2.has("x2")) {
                            obj3 = Double.valueOf(jSONObject2.getDouble("x2"));
                        }
                        if (jSONObject2.has("y2")) {
                            obj4 = Double.valueOf(jSONObject2.getDouble("y2"));
                        }
                        if (!(str3 == null || obj == null || obj2 == null || obj3 == null || obj4 == null)) {
                            if (stringBuffer2.length() > 0) {
                                stringBuffer2.append(",");
                            }
                            stringBuffer2.append("(NULL,\"").append(str2).append("\",\"").append(str3).append("\",").append(obj).append(",").append(obj2).append(",").append(obj3).append(",").append(obj4).append(")");
                        }
                    } catch (JSONException e2) {
                    }
                    if (i2 % 50 == 49 && stringBuffer2.length() > 0) {
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCROAD", stringBuffer2.toString()}));
                        stringBuffer2.setLength(0);
                    }
                }
                if (stringBuffer2.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCROAD", stringBuffer2.toString()}));
                }
            }
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCUPDATE", stringBuffer}));
        }
        arrayList.add(String.format(Locale.US, "DELETE FROM RGCROAD WHERE _id NOT IN (SELECT _id FROM RGCROAD LIMIT %d);", new Object[]{Integer.valueOf(i)}));
        return arrayList;
    }
}
