package com.vlocker.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class v {
    private static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", jSONObject.optString("id"));
            jSONObject3.put("bid", jSONObject.optString("bid"));
            jSONObject3.put("predef", jSONObject.optBoolean("predef", true));
            jSONObject3.put("type", "Train");
            jSONObject3.put("train", jSONObject2);
            return jSONObject3;
        } catch (Exception e) {
            return null;
        }
    }

    public static void a(Context context) {
        String b = b(context);
        if (b != null) {
            new q(b).a();
        }
    }

    public static void a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("train")) {
                c(context, a(jSONObject, jSONObject.getJSONObject("train")).toString());
            }
            if (jSONObject.has("trains")) {
                JSONArray jSONArray = jSONObject.getJSONArray("trains");
                for (int i = 0; i < jSONArray.length(); i++) {
                    c(context, a(jSONObject, (JSONObject) jSONArray.get(i)).toString());
                }
            }
            a(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("icon_sharedPreferences", 0);
        Editor edit = sharedPreferences.edit();
        long j = -1;
        for (Entry entry : sharedPreferences.getAll().entrySet()) {
            long parseLong;
            try {
                String[] split = sharedPreferences.getString((String) entry.getKey(), null).split("@_@");
                if (System.currentTimeMillis() >= Long.parseLong(split[0]) && System.currentTimeMillis() < Long.parseLong(split[1])) {
                    parseLong = Long.parseLong((String) entry.getKey());
                    if (j == -1 || parseLong < j) {
                        j = parseLong;
                    }
                } else if (System.currentTimeMillis() >= Long.parseLong(split[1])) {
                    edit.remove((String) entry.getKey());
                    edit.commit();
                }
                parseLong = j;
            } catch (Exception e) {
                edit.remove((String) entry.getKey());
                edit.commit();
                parseLong = j;
            }
            j = parseLong;
        }
        return j != -1 ? sharedPreferences.getString(j + "", null).split("@_@")[2] : null;
    }

    public static void b(Context context, String str) {
        try {
            Editor edit = context.getSharedPreferences("icon_sharedPreferences", 0).edit();
            edit.remove(str);
            edit.commit();
        } catch (Exception e) {
        }
    }

    private static void c(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("train");
            String string = jSONObject.getString("resid");
            a aVar = new a();
            aVar.a(jSONObject.optString("sdate"));
            aVar.b(jSONObject.optString("edate"));
            Editor edit = context.getSharedPreferences("icon_sharedPreferences", 0).edit();
            edit.putString(string, aVar.y + "@_@" + aVar.z + "@_@" + str);
            edit.commit();
        } catch (Exception e) {
        }
    }
}
