package com.vlocker.b;

import android.os.Environment;
import com.vlocker.new_theme.beans.g;

public class i {
    public static String a = "http://mobile.moxiu.com/json.php?do=Vlocker.Theme.List&cid=5580d16492ac7af65000023b&from=banner";
    public static String b = "锁屏主题";
    public static String[] c = new String[]{"http://weather.moxiu.net/", "http://210.14.155.123:8001/"};
    public static String[] d = new String[]{"http://soft.moxiu.net/", "http://210.14.155.123:8002/"};
    public static String e = c[0];
    public static String f = d[0];
    public static final String g = (Environment.getExternalStorageDirectory().toString() + "/vlocker/update/");
    public static final String h = (Environment.getExternalStorageDirectory().toString() + "/vlocker/picture/pic/");
    public static final String i = (Environment.getExternalStorageDirectory().toString() + "/moxiu/themes/");
    public static final String j = (Environment.getExternalStorageDirectory().toString() + "/vlocker/themes/");
    public static final String k = (Environment.getExternalStorageDirectory().toString() + "/vlocker/picture/notic/");
    public static final String l = (Environment.getExternalStorageDirectory().toString() + "/vlocker/picture/share/");
    public static final String m = (Environment.getExternalStorageDirectory().toString() + "/vlocker/flags/");
    public static int n = 0;
    public static g o = new g();
    private static String[] p = new String[]{"http://mobile.moxiu.com/", "http://mobile.moxiu.net/", "http://101.251.251.184:8080/"};
    private static String[] q = new String[]{"http://mobile.test.imoxiu.cn/", "http://mobile.dns.imoxiu.cn/", "http://10.0.0.27:8080/"};

    public static String a() {
        return b()[n];
    }

    public static void a(String str, int i) {
        b()[i] = str;
    }

    private static String[] b() {
        return p;
    }
}
