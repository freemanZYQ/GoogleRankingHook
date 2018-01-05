package com.baidu.mobads;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdSettings {
    private static HashSet a = new HashSet();
    private static JSONArray b = new JSONArray();
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static HashSet j = new HashSet();
    private static JSONArray k = new JSONArray();
    private static JSONObject l = new JSONObject();

    public enum a {
        PRIMARY(0),
        JUNIOR(1),
        SENIOR(2),
        SPECIALTY(3),
        BACHELOR(4),
        MASTER(5),
        DOCTOR(6);
        
        private int h;

        private a(int i) {
            this.h = i;
        }

        public int a() {
            return this.h;
        }
    }

    public enum b {
        F0T1k(0),
        F1kT2k(1),
        F2kT3k(2),
        F3kT4k(3),
        F4kT5k(4),
        F5kT6k(5),
        F6kT7k(6),
        F7kT8k(7),
        F8kT9k(8),
        F9kT10k(9),
        F10kT15k(10),
        F15kT20k(11),
        F20(12);
        
        private int n;

        private b(int i) {
            this.n = i;
        }

        public int a() {
            return this.n;
        }
    }

    public enum c {
        MALE(0),
        FEMALE(1);
        
        private int c;

        private c(int i) {
            this.c = i;
        }

        public int a() {
            return this.c;
        }
    }

    protected static JSONObject getAttr() {
        JSONObject jSONObject = new JSONObject();
        Iterator it = a.iterator();
        b = new JSONArray();
        while (it.hasNext()) {
            b.put(it.next());
        }
        it = j.iterator();
        k = new JSONArray();
        while (it.hasNext()) {
            k.put(it.next());
        }
        try {
            jSONObject.putOpt("KEY", b);
            jSONObject.putOpt("SEX", c);
            jSONObject.putOpt("BIR", d);
            jSONObject.putOpt("CITY", e);
            jSONObject.putOpt("ZIP", f);
            jSONObject.putOpt("JOB", g);
            jSONObject.putOpt("EDU", h);
            jSONObject.putOpt("SAL", i);
            jSONObject.putOpt("HOB", k);
            jSONObject.putOpt("R", l);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public static void setBirthday(Calendar calendar) {
        if (calendar != null) {
            int i = calendar.get(1);
            int i2 = calendar.get(2) + 1;
            int i3 = calendar.get(5);
            d = i + "";
            if (i2 <= 0 || i2 >= 10) {
                d += i2;
            } else {
                d += "0" + i2;
            }
            if (i3 <= 0 || i3 >= 10) {
                d += i3;
            } else {
                d += "0" + i3;
            }
        }
    }

    public static void setCity(String str) {
        e = str;
    }

    public static void setEducation(a aVar) {
        if (aVar != null) {
            h = aVar.a() + "";
        }
    }

    public static void setHob(List list) {
        j.addAll(list);
    }

    public static void setHob(String[] strArr) {
        for (Object add : strArr) {
            j.add(add);
        }
    }

    public static void setJob(String str) {
        g = str;
    }

    public static void setKey(List list) {
        a.addAll(list);
    }

    public static void setKey(String[] strArr) {
        for (Object add : strArr) {
            a.add(add);
        }
    }

    public static void setSalary(b bVar) {
        if (bVar != null) {
            i = bVar.a() + "";
        }
    }

    public static void setSex(c cVar) {
        if (cVar != null) {
            c = cVar.a() + "";
        }
    }

    public static void setUserAttr(String str, String str2) {
        try {
            l.put(str, str2);
        } catch (JSONException e) {
        }
    }

    public static void setZip(String str) {
        f = str;
    }
}
