package com.inveno.se.d.a;

import com.inveno.se.d.c;
import com.inveno.se.d.m;
import com.inveno.se.f.a;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class j {
    public static long a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0;
        }
    }

    public static c a(m mVar) {
        long j;
        long j2;
        Object obj = null;
        long j3 = 0;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = mVar.c;
        String str = (String) map.get("Date");
        long a = str != null ? a(str) : 0;
        if (map.containsKey("Content-Encoding")) {
            a.b("has Content-Encoding");
        }
        str = (String) map.get("Cache-Control");
        if (str != null) {
            String[] split = str.split(",");
            long j4 = 0;
            for (String trim : split) {
                String trim2 = trim2.trim();
                if (!(trim2.equals("no-cache") || trim2.equals("no-store"))) {
                    if (trim2.startsWith("max-age=")) {
                        try {
                            j4 = Long.parseLong(trim2.substring(8));
                        } catch (Exception e) {
                        }
                        a.b("max-age=" + j4);
                    } else if (trim2.equals("must-revalidate") || trim2.equals("proxy-revalidate")) {
                        a.b("must-revalidate");
                        j4 = 0;
                    }
                }
            }
            j = j4;
            obj = 1;
        } else {
            j = 0;
        }
        str = (String) map.get("Expires");
        if (str != null) {
            long a2 = a(str);
            a.b("Expires:" + a2);
            j2 = a2;
        } else {
            j2 = 0;
        }
        str = (String) map.get("ETag");
        if (obj != null) {
            j3 = (1000 * j) + currentTimeMillis;
        } else if (a > 0 && j2 >= a) {
            j3 = (j2 - a) + currentTimeMillis;
        }
        c cVar = new c();
        cVar.a = mVar.b;
        cVar.b = str;
        cVar.e = j3;
        cVar.d = cVar.e;
        cVar.c = a;
        cVar.f = map;
        return cVar;
    }

    public static String a(Map map) {
        String str = (String) map.get("Content-Type");
        if (str != null) {
            String[] split = str.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return "ISO-8859-1";
    }
}
