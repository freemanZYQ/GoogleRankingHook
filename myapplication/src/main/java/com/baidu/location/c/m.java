package com.baidu.location.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

enum m extends b {
    m(String str, int i, String str2, String str3, String str4, int i2, int i3) {
        super(str, i, str2, str3, str4, i2, i3);
    }

    List a(JSONObject jSONObject, String str, int i) {
        Iterator keys = jSONObject.keys();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        List arrayList = new ArrayList();
        int i2 = 0;
        while (keys.hasNext()) {
            String str2 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            String str8 = (String) keys.next();
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str8);
                if (jSONObject2.has("cy")) {
                    str2 = jSONObject2.getString("cy");
                }
                if (jSONObject2.has("cyc")) {
                    str3 = jSONObject2.getString("cyc");
                }
                if (jSONObject2.has("prov")) {
                    str4 = jSONObject2.getString("prov");
                }
                if (jSONObject2.has("ctc")) {
                    str5 = jSONObject2.getString("ctc");
                }
                if (jSONObject2.has("ct")) {
                    str6 = jSONObject2.getString("ct");
                }
                if (jSONObject2.has("dist")) {
                    str7 = jSONObject2.getString("dist");
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append("(\"").append(str8).append("\",\"").append(str2).append("\",\"").append(str3).append("\",\"").append(str4).append("\",\"").append(str6).append("\",\"").append(str5).append("\",\"").append(str7).append("\",").append(System.currentTimeMillis() / 1000).append(",\"\")");
                b.b(stringBuffer2, str8, str, 0);
            } catch (JSONException e) {
            }
            if (i2 % 50 == 49 && stringBuffer.length() > 0) {
                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCAREA", stringBuffer}));
                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCUPDATE", stringBuffer2}));
                stringBuffer.setLength(0);
            }
            i2++;
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCAREA", stringBuffer}));
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCUPDATE", stringBuffer2}));
            stringBuffer.setLength(0);
        }
        arrayList.add(String.format(Locale.US, "DELETE FROM RGCAREA WHERE gridkey NOT IN (SELECT gridkey FROM RGCAREA LIMIT %d);", new Object[]{Integer.valueOf(i)}));
        return arrayList;
    }
}
