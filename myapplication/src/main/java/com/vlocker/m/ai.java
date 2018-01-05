package com.vlocker.m;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ai extends JSONObject {
    private LinkedHashMap a = new LinkedHashMap();

    static void a(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Double) {
            if (((Double) obj).isInfinite() || ((Double) obj).isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        } else if (!(obj instanceof Float)) {
        } else {
            if (((Float) obj).isInfinite() || ((Float) obj).isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        }
    }

    static String b(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (!(obj instanceof JSONStringer)) {
            return obj instanceof Number ? numberToString((Number) obj) : obj instanceof ai ? ((ai) obj).toString() : ((obj instanceof Boolean) || (obj instanceof JSONObject) || (obj instanceof JSONArray)) ? obj.toString() : obj instanceof Map ? new JSONObject((Map) obj).toString() : obj instanceof Collection ? new JSONArray((Collection) obj).toString() : quote(obj.toString());
        } else {
            try {
                String jSONStringer = ((JSONStringer) obj).toString();
                if (jSONStringer instanceof String) {
                    return jSONStringer;
                }
                throw new JSONException("Bad value from toJSONString: " + jSONStringer);
            } catch (Exception e) {
                throw new JSONException(e.getMessage());
            }
        }
    }

    public long getLong(String str) {
        Object obj = this.a.get(str);
        if (obj != null && (obj instanceof Long)) {
            return ((Long) obj).longValue();
        }
        throw new JSONException("No long value for " + str);
    }

    public JSONObject put(String str, double d) {
        put(str, new Double(d));
        return this;
    }

    public JSONObject put(String str, int i) {
        put(str, new Integer(i));
        return this;
    }

    public JSONObject put(String str, long j) {
        put(str, new Long(j));
        return this;
    }

    public JSONObject put(String str, Object obj) {
        if (str == null) {
            throw new JSONException("Null key.");
        }
        if (obj != null) {
            a(obj);
            this.a.put(str, obj);
        } else {
            remove(str);
        }
        return this;
    }

    public JSONObject put(String str, boolean z) {
        put(str, z ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }

    public Object remove(String str) {
        return this.a.remove(str);
    }

    public String toString() {
        try {
            StringBuffer stringBuffer = new StringBuffer("{");
            for (Object next : this.a.keySet()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                stringBuffer.append(quote(next.toString()));
                stringBuffer.append(':');
                stringBuffer.append(b(this.a.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
