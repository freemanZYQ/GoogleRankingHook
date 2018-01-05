package com.vlocker.setting.common.a;

import android.content.Context;
import android.util.Log;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private Map a = new HashMap();
    private Context b = null;

    public a(Context context) {
        this.b = context;
    }

    private Map a(Class cls) {
        Map map = (Map) this.a.get(cls);
        if (map != null) {
            return map;
        }
        Map hashMap = new HashMap();
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(b.class)) {
                hashMap.put(((b) method.getAnnotation(b.class)).a(), method);
            }
        }
        this.a.put(cls, hashMap);
        return hashMap;
    }

    private void a(Object obj, Method method, JSONArray jSONArray, int i) {
        try {
            Log.d(getClass().getSimpleName(), i + ":" + jSONArray.getString(i));
            Class cls = method.getParameterTypes()[0];
            if (String.class.equals(cls)) {
                method.invoke(obj, new Object[]{jSONArray.getString(i)});
            } else if (Boolean.TYPE.equals(cls)) {
                method.invoke(obj, new Object[]{Boolean.valueOf(jSONArray.getBoolean(i))});
            } else if (Integer.TYPE.equals(cls)) {
                method.invoke(obj, new Object[]{Integer.valueOf(jSONArray.getInt(i))});
            } else {
                a(jSONArray.getJSONObject(i), cls.newInstance());
                method.invoke(obj, new Object[]{r0});
            }
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), e.toString());
        }
    }

    private void a(Object obj, Method method, JSONObject jSONObject, String str) {
        try {
            Log.d(getClass().getSimpleName(), str + ":" + jSONObject.getString(str));
            Class cls = method.getParameterTypes()[0];
            if (String.class.equals(cls)) {
                method.invoke(obj, new Object[]{jSONObject.getString(str)});
            } else if (Boolean.TYPE.equals(cls)) {
                method.invoke(obj, new Object[]{Boolean.valueOf(jSONObject.getBoolean(str))});
            } else if (Integer.TYPE.equals(cls)) {
                method.invoke(obj, new Object[]{Integer.valueOf(jSONObject.getInt(str))});
            } else {
                a(jSONObject.getJSONObject(str), cls.newInstance());
                method.invoke(obj, new Object[]{r0});
            }
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), e.toString());
        }
    }

    public void a(String str, Object obj) {
        try {
            InputStream open = this.b.getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            a(new JSONObject(new String(bArr, "UTF-8")), obj);
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), e.toString());
        }
    }

    public void a(JSONObject jSONObject, Object obj) {
        try {
            Map a = a(obj.getClass());
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                Method method = (Method) a.get(str);
                if (method == null) {
                    Log.w(getClass().getSimpleName(), str + ":" + jSONObject.get(str));
                } else if (jSONObject.get(str) instanceof JSONArray) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        a(obj, method, jSONArray, i);
                    }
                } else {
                    a(obj, method, jSONObject, str);
                }
            }
        } catch (JSONException e) {
            Log.e(getClass().getSimpleName(), e.toString());
        }
    }
}
