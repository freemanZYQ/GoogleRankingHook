package com.vlocker.m;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.vlocker.security.MoSecurityApplication;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class ay {
    public static String a = "language_default";
    public static String b = "zh";
    public static String c = "country_default";
    public static String d = "CN";
    private static StringBuilder e;
    private static final long[] f = new long[]{19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42448, 83315, 21200, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46496, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19415, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448};
    private static final String[] g = new String[]{"", "正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "冬", "腊"};
    private static final String[] h = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final String[] i = new String[]{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    private static final String[] j = new String[]{"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    private static final String[] k = new String[]{"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};

    public static String a() {
        Calendar instance = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
        long[] a = a(instance.get(1), instance.get(2) + 1, instance.get(5));
        StringBuilder e = e();
        e.append(c((int) a[0]));
        e.append(b((int) a[0]));
        e.append("年");
        return e.toString();
    }

    public static final String a(int i) {
        String str = "";
        if (i == 10) {
            return "初十";
        }
        if (i == 20) {
            return "二十";
        }
        if (i == 30) {
            return "三十";
        }
        int i2 = i / 10;
        if (i2 == 0) {
            str = "初";
        }
        if (i2 == 1) {
            str = "十";
        }
        if (i2 == 2) {
            str = "廿";
        }
        if (i2 == 3) {
            str = "三";
        }
        switch (i % 10) {
            case 1:
                return str + "一";
            case 2:
                return str + "二";
            case 3:
                return str + "三";
            case 4:
                return str + "四";
            case 5:
                return str + "五";
            case 6:
                return str + "六";
            case 7:
                return str + "七";
            case 8:
                return str + "八";
            case 9:
                return str + "九";
            default:
                return str;
        }
    }

    public static String a(int i, int i2) {
        if (i2 == 3) {
            return d(i);
        }
        StringBuilder e = e();
        if (i < 10) {
            if (i2 != 2 || i <= 0) {
                e.append(h[i]);
            } else {
                e.append(h[0]);
                e.append(h[i]);
            }
        } else if (i < 20) {
            e.append("十");
            if (i % 10 != 0) {
                e.append(h[i % 10]);
            }
        } else {
            e.append(h[i / 10]);
            e.append("十");
            if (i % 10 != 0) {
                e.append(h[i % 10]);
            }
        }
        return e.toString();
    }

    public static String a(Context context) {
        Date date = new Date(System.currentTimeMillis());
        return DateFormat.is24HourFormat(context) ? new SimpleDateFormat("H:mm").format(date) : new SimpleDateFormat("h:mm").format(date);
    }

    public static final long[] a(int i, int i2, int i3) {
        long[] jArr = new long[7];
        int i4 = 0;
        int i5 = i;
        long time = (new GregorianCalendar(i5, i2 - 1, i3).getTime().getTime() - new GregorianCalendar(1900, 0, 31).getTime().getTime()) / 86400000;
        jArr[5] = 40 + time;
        jArr[4] = 14;
        int i6 = 1900;
        while (i6 < 2050 && time > 0) {
            i4 = e(i6);
            time -= (long) i4;
            jArr[4] = jArr[4] + 12;
            i6++;
        }
        if (time < 0) {
            time += (long) i4;
            i6--;
            jArr[4] = jArr[4] - 12;
        }
        jArr[0] = (long) i6;
        jArr[3] = (long) (i6 - 1864);
        int g = g(i6);
        jArr[6] = 0;
        long j = time;
        int i7 = i4;
        int i8 = 1;
        long j2 = j;
        while (i8 < 13 && j2 > 0) {
            if (g > 0 && i8 == g + 1 && jArr[6] == 0) {
                i8--;
                jArr[6] = 1;
                i7 = f((int) jArr[0]);
            } else {
                i7 = b((int) jArr[0], i8);
            }
            if (jArr[6] == 1 && i8 == g + 1) {
                jArr[6] = 0;
            }
            j2 -= (long) i7;
            if (jArr[6] == 0) {
                jArr[4] = jArr[4] + 1;
            }
            i8++;
        }
        if (j2 == 0 && g > 0 && i8 == g + 1) {
            if (jArr[6] == 1) {
                jArr[6] = 0;
                g = i8;
                if (j2 >= 0) {
                    time = ((long) i7) + j2;
                    i6 = g - 1;
                    jArr[4] = jArr[4] - 1;
                } else {
                    time = j2;
                    i6 = g;
                }
                jArr[1] = (long) i6;
                jArr[2] = time + 1;
                return jArr;
            }
            jArr[6] = 1;
            i8--;
            jArr[4] = jArr[4] - 1;
        }
        g = i8;
        if (j2 >= 0) {
            time = j2;
            i6 = g;
        } else {
            time = ((long) i7) + j2;
            i6 = g - 1;
            jArr[4] = jArr[4] - 1;
        }
        jArr[1] = (long) i6;
        jArr[2] = time + 1;
        return jArr;
    }

    private static final int b(int i, int i2) {
        return (f[i + -1900] & ((long) (65536 >> i2))) == 0 ? 29 : 30;
    }

    public static String b() {
        Calendar instance = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
        long[] a = a(instance.get(1), instance.get(2) + 1, instance.get(5));
        StringBuilder e = e();
        e.append(g[(int) a[1]]);
        e.append("月");
        return e.toString();
    }

    public static final String b(int i) {
        return k[(i - 4) % 12];
    }

    public static String b(Context context) {
        Date date = new Date(System.currentTimeMillis());
        String format = new SimpleDateFormat("MMMdd", MoSecurityApplication.a().c()).format(date);
        if (format.contains("月") && !format.contains("日")) {
            format = format + "日";
        }
        format = format + new SimpleDateFormat(" EEE", MoSecurityApplication.a().c()).format(date);
        return format.contains("星期") ? format.replace("星期", "周") : format;
    }

    public static String c() {
        Calendar instance = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
        long[] a = a(instance.get(1), instance.get(2) + 1, instance.get(5));
        StringBuilder e = e();
        e.append(a((int) a[2]));
        return e.toString();
    }

    public static final String c(int i) {
        return h((i - 1900) + 36);
    }

    public static String d() {
        Calendar instance = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
        long[] a = a(instance.get(1), instance.get(2) + 1, instance.get(5));
        StringBuilder e = e();
        e.append(g[(int) a[1]]);
        e.append("月");
        e.append(a((int) a[2]));
        return e.toString();
    }

    private static String d(int i) {
        String num = Integer.toString(i);
        StringBuilder e = e();
        for (int i2 = 0; i2 < num.length(); i2++) {
            e.append(h[Integer.parseInt(String.valueOf(num.charAt(i2)))]);
        }
        return e.toString();
    }

    private static final int e(int i) {
        int i2 = 348;
        for (int i3 = WXMediaMessage.THUMB_LENGTH_LIMIT; i3 > 8; i3 >>= 1) {
            if ((f[i - 1900] & ((long) i3)) != 0) {
                i2++;
            }
        }
        return i2 + f(i);
    }

    private static StringBuilder e() {
        if (e == null) {
            e = new StringBuilder();
        }
        e.delete(0, e.length());
        return e;
    }

    private static final int f(int i) {
        return g(i) != 0 ? (f[i + -1900] & 65536) != 0 ? 30 : 29 : 0;
    }

    private static final int g(int i) {
        return (int) (f[i - 1900] & 15);
    }

    private static final String h(int i) {
        return i[i % 10] + j[i % 12];
    }
}
