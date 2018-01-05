package com.baidu.location.h;

import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.baidu.location.b.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class g {
    public List a = null;
    private long b = 0;
    private long c = 0;
    private boolean d = false;
    private boolean e;

    public g(List list, long j) {
        this.b = j;
        this.a = list;
        this.c = System.currentTimeMillis();
        i();
    }

    private void i() {
        if (a() >= 1) {
            Object obj = 1;
            for (int size = this.a.size() - 1; size >= 1 && r2 != null; size--) {
                int i = 0;
                obj = null;
                while (i < size) {
                    Object obj2;
                    if (((ScanResult) this.a.get(i)).level < ((ScanResult) this.a.get(i + 1)).level) {
                        ScanResult scanResult = (ScanResult) this.a.get(i + 1);
                        this.a.set(i + 1, this.a.get(i));
                        this.a.set(i, scanResult);
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    i++;
                    obj = obj2;
                }
            }
        }
    }

    public int a() {
        return this.a == null ? 0 : this.a.size();
    }

    public String a(int i) {
        return a(i, false);
    }

    public String a(int i, boolean z) {
        int i2;
        if (a() < 1) {
            return null;
        }
        int i3;
        int i4;
        int size;
        Object obj;
        int i5 = 0;
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer(512);
        List<Long> arrayList = new ArrayList();
        String i6 = m.a().i();
        Object obj2 = null;
        if (VERSION.SDK_INT >= 17) {
            long elapsedRealtimeNanos;
            try {
                elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Exception e) {
                elapsedRealtimeNanos = 0;
            }
            if (elapsedRealtimeNanos > 0) {
                obj2 = 1;
            }
        }
        if (obj2 == null || obj2 == null || z) {
            i3 = 0;
            i4 = 0;
            size = this.a.size();
            obj = 1;
        } else {
            i3 = 0;
            i4 = 0;
            size = this.a.size();
            obj = 1;
        }
        if (size <= i) {
            i = size;
        }
        int i7 = 0;
        while (i7 < i) {
            int i8;
            if (((ScanResult) this.a.get(i7)).level == 0) {
                obj2 = obj;
                i8 = i3;
                i2 = i4;
                i4 = i5;
                i5 = i2;
            } else {
                if (obj != null) {
                    obj = null;
                    stringBuffer.append("&wf=");
                } else {
                    stringBuffer.append("|");
                }
                String replace = ((ScanResult) this.a.get(i7)).BSSID.replace(":", "");
                stringBuffer.append(replace);
                size = ((ScanResult) this.a.get(i7)).level;
                if (size < 0) {
                    size = -size;
                }
                stringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[]{Integer.valueOf(size)}));
                i3++;
                if (i6 != null && i6.equals(replace)) {
                    this.e = m.a().a(((ScanResult) this.a.get(i7)).capabilities);
                    m.a().h();
                    i4 = i3;
                }
                if (i5 == 0) {
                    try {
                        if (random.nextInt(10) == 2 && ((ScanResult) this.a.get(i7)).SSID != null && ((ScanResult) this.a.get(i7)).SSID.length() < 30) {
                            stringBuffer.append(((ScanResult) this.a.get(i7)).SSID);
                            size = 1;
                        }
                        size = i5;
                    } catch (Exception e2) {
                        obj2 = obj;
                        i8 = i3;
                        i2 = i4;
                        i4 = i5;
                        i5 = i2;
                    }
                } else {
                    if (i5 == 1) {
                        if (random.nextInt(20) == 1 && ((ScanResult) this.a.get(i7)).SSID != null && ((ScanResult) this.a.get(i7)).SSID.length() < 30) {
                            stringBuffer.append(((ScanResult) this.a.get(i7)).SSID);
                            size = 2;
                        }
                    }
                    size = i5;
                }
                i5 = i4;
                i4 = size;
                obj2 = obj;
                i8 = i3;
            }
            i7++;
            i3 = i8;
            obj = obj2;
            i2 = i5;
            i5 = i4;
            i4 = i2;
        }
        if (obj != null) {
            return null;
        }
        stringBuffer.append("&wf_n=" + i4);
        if (0 > 10 && arrayList.size() > 0) {
            StringBuffer stringBuffer2 = new StringBuffer(128);
            stringBuffer2.append("&wf_ut=");
            Long l = (Long) arrayList.get(0);
            obj = 1;
            for (Long l2 : arrayList) {
                Object obj3;
                if (obj != null) {
                    stringBuffer2.append(l2.longValue());
                    obj3 = null;
                } else {
                    long longValue = l2.longValue() - l.longValue();
                    if (longValue != 0) {
                        stringBuffer2.append("" + longValue);
                    }
                    obj3 = obj;
                }
                stringBuffer2.append("|");
                obj = obj3;
            }
            stringBuffer.append(stringBuffer2.toString());
        }
        stringBuffer.append("&wf_st=");
        stringBuffer.append(this.b);
        stringBuffer.append("&wf_et=");
        stringBuffer.append(this.c);
        stringBuffer.append("&wf_vt=");
        stringBuffer.append(f.a);
        if (i4 > 0) {
            this.d = true;
            stringBuffer.append("&wf_en=");
            stringBuffer.append(this.e ? 1 : 0);
        }
        return stringBuffer.toString();
    }

    public boolean a(g gVar) {
        if (this.a == null || gVar == null || gVar.a == null) {
            return false;
        }
        int size = this.a.size() < gVar.a.size() ? this.a.size() : gVar.a.size();
        for (int i = 0; i < size; i++) {
            if (!((ScanResult) this.a.get(i)).BSSID.equals(((ScanResult) gVar.a.get(i)).BSSID)) {
                return false;
            }
        }
        return true;
    }

    public String b() {
        try {
            return a(h.L, true);
        } catch (Exception e) {
            return null;
        }
    }

    public String b(int i) {
        int i2 = 0;
        try {
            if (a() < 1) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.a.size();
            if (size <= i) {
                i = size;
            }
            while (i2 < i) {
                if (((ScanResult) this.a.get(i2)).level != 0) {
                    stringBuffer.append(String.format(Locale.CHINA, "<access-point>\n<mac>%s</mac>\n<signal-strength>%d</signal-strength>\n</access-point>\n", new Object[]{((ScanResult) this.a.get(i2)).BSSID.replace(":", ""), Integer.valueOf(((ScanResult) this.a.get(i2)).level)}));
                }
                i2++;
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean b(g gVar) {
        if (this.a == null || gVar == null || gVar.a == null) {
            return false;
        }
        int size = this.a.size() < gVar.a.size() ? this.a.size() : gVar.a.size();
        for (int i = 0; i < size; i++) {
            String str = ((ScanResult) this.a.get(i)).BSSID;
            int i2 = ((ScanResult) this.a.get(i)).level;
            String str2 = ((ScanResult) gVar.a.get(i)).BSSID;
            int i3 = ((ScanResult) gVar.a.get(i)).level;
            if (!str.equals(str2) || i2 != i3) {
                return false;
            }
        }
        return true;
    }

    public String c() {
        try {
            return a(15);
        } catch (Exception e) {
            return null;
        }
    }

    public String c(int i) {
        if (a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        int size = this.a.size();
        if (size <= i) {
            i = size;
        }
        int i2 = 0;
        int i3 = 1;
        while (i2 < i) {
            if (((ScanResult) this.a.get(i2)).level == 0) {
                size = i3;
            } else {
                if (i3 != 0) {
                    i3 = 0;
                } else {
                    stringBuffer.append("|");
                }
                stringBuffer.append(((ScanResult) this.a.get(i2)).BSSID.replace(":", ""));
                size = ((ScanResult) this.a.get(i2)).level;
                if (size < 0) {
                    size = -size;
                }
                stringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[]{Integer.valueOf(size)}));
                size = i3;
            }
            i2++;
            i3 = size;
        }
        return i3 == 0 ? stringBuffer.toString() : null;
    }

    public boolean c(g gVar) {
        return f.a(gVar, this, h.O);
    }

    public int d() {
        for (int i = 0; i < a(); i++) {
            int i2 = -((ScanResult) this.a.get(i)).level;
            if (i2 > 0) {
                return i2;
            }
        }
        return 0;
    }

    public String d(int i) {
        if (i == 0 || a() < 1) {
            return null;
        }
        int i2;
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.a.size() > h.L) {
            i2 = h.L;
        }
        i2 = 0;
        int i3 = 1;
        for (int i4 = 0; i4 < h.L; i4++) {
            if ((i3 & i) != 0) {
                if (i2 == 0) {
                    stringBuffer.append("&ssid=");
                } else {
                    stringBuffer.append("|");
                }
                stringBuffer.append(((ScanResult) this.a.get(i4)).BSSID.replace(":", ""));
                stringBuffer.append(";");
                stringBuffer.append(((ScanResult) this.a.get(i4)).SSID);
                i2++;
            }
            i3 <<= 1;
        }
        return stringBuffer.toString();
    }

    public boolean e() {
        return this.d;
    }

    public boolean f() {
        return System.currentTimeMillis() - this.c < 3000;
    }

    public boolean g() {
        return System.currentTimeMillis() - this.c < 5000;
    }

    public boolean h() {
        return System.currentTimeMillis() - this.b < 3000;
    }
}
