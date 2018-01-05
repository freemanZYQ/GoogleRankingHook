package com.vlocker.search;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.vlocker.b.j;
import com.vlocker.notification.msg.open.FlowWebViewActivity;
import com.vlocker.theme.model.d;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class ap {
    public static final int a = VERSION.SDK_INT;
    public static int b = 0;
    public static int c = 2;
    public static int d = 1;
    public static int e = 3;
    public static boolean f = true;
    public static final String g = (c() + "/log.php?do=Search");
    public static final String h = (c() + "/bd.php?do=Map");
    public static final String[] i = new String[]{"com.UCMobile", "com.tencent.mtt", "com.baidu.browser.apps"};
    private static int j = 0;
    private static String k = null;
    private static String l = "com.moxiu.launcher";

    public static int a(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static String a(Context context, String str, List list) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            HttpUriRequest httpPost = new HttpPost(str);
            httpPost.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            HttpResponse execute = new DefaultHttpClient().execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(execute.getEntity().getContent(), "UTF-8"), 8192);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine + "\n");
                }
                bufferedReader.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        return Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(str).replaceAll("").trim();
    }

    public static void a(Context context, long j) {
        Editor edit = context.getSharedPreferences("ALauncher_m_bd_settings", 1).edit();
        edit.putLong("baiduhotkeyrefreshtime", j);
        edit.commit();
    }

    public static void a(Context context, Bitmap bitmap, int i) {
        Exception e;
        OutputStream outputStream;
        Throwable th;
        String c = c(context);
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(c);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(c, "vague" + i);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            OutputStream fileOutputStream2 = new FileOutputStream(file2);
            try {
                bitmap.compress(CompressFormat.PNG, 100, fileOutputStream2);
                fileOutputStream2.flush();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                outputStream = fileOutputStream2;
                try {
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    public static void a(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void a(Context context, String str) {
        try {
            k(context).putString("searchurl", str).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            k(context).putString("searchfrom", str).putString("searchtuijian", str2).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, FlowWebViewActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        intent.putExtra("tag", str3);
        context.startActivity(intent);
    }

    public static void a(Context context, String str, String str2, String str3, int i) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("web_view_click" + i, 0);
            Editor edit = sharedPreferences.edit();
            long j = sharedPreferences.getLong("lastClickTime", 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j > 1000 || currentTimeMillis < j) {
                edit.putLong("lastClickTime", currentTimeMillis);
                edit.commit();
                switch (i) {
                    case 0:
                        a(context, str, "", str3);
                        return;
                    case 1:
                        a(context, str, "爱淘宝", str3);
                        return;
                    case 2:
                        a(context, str, str2, str3);
                        return;
                    case 3:
                        a(context, str, "", str3);
                        return;
                    default:
                        return;
                }
            } else if (currentTimeMillis - j < 1000 && currentTimeMillis - j > 0) {
                Toast.makeText(context, "亲，点一下就行了~", 0).show();
            }
        } catch (Exception e) {
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        new Thread(new aq(str, j.t(context), str5, str2, str3, str4, context)).start();
    }

    public static boolean a() {
        return a < 14 ? true : a == 14 ? false : false;
    }

    public static int b(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static String b(String str) {
        return Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\\s]").matcher(str).replaceAll("").trim();
    }

    public static boolean b() {
        return a < 11;
    }

    public static String c() {
        return "http://util.moxiu.net";
    }

    public static String c(Context context) {
        return context.getFilesDir() == null ? Environment.getExternalStorageDirectory().toString() + "/vague/" : context.getFilesDir().getPath() + "vague/";
    }

    public static int d() {
        try {
            if (VERSION.SDK_INT >= 14) {
                return 4;
            }
        } catch (NumberFormatException e) {
        } catch (Exception e2) {
        }
        return 0;
    }

    public static String d(Context context) {
        return f(context).getString("searchfrom", "");
    }

    public static String e(Context context) {
        return f(context).getString("searchtuijian", "");
    }

    public static SharedPreferences f(Context context) {
        return context.getSharedPreferences("Moxiu_back", d());
    }

    public static boolean g(Context context) {
        try {
            System.currentTimeMillis();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null) {
                    State state = networkInfo.getState();
                    if (state == State.CONNECTED || state == State.CONNECTING) {
                        System.currentTimeMillis();
                        return true;
                    }
                }
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null) {
                    State state2 = networkInfo2.getState();
                    if (state2 == State.CONNECTED || state2 == State.CONNECTING) {
                        System.currentTimeMillis();
                        return true;
                    }
                }
            }
            System.currentTimeMillis();
        } catch (Exception e) {
        }
        return false;
    }

    public static String h(Context context) {
        return f(context).getString("searchurl", "https://m.baidu.com/s?from=1001706a&word=");
    }

    public static d i(Context context) {
        try {
            InputStream open = context.getResources().getAssets().open("defaultkey.xml");
            if (open != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = open.read();
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(read);
                }
                String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                if (byteArrayOutputStream2.length() <= 10) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(byteArrayOutputStream2);
                if (jSONObject.getInt("code") != 200) {
                    return null;
                }
                d dVar = new d();
                JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("list");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    M_bd_BaiduNewsInfo m_bd_BaiduNewsInfo = new M_bd_BaiduNewsInfo();
                    m_bd_BaiduNewsInfo.a(a(jSONObject2.getString("title")));
                    m_bd_BaiduNewsInfo.b(jSONObject2.getString("url"));
                    dVar.add(m_bd_BaiduNewsInfo);
                }
                return dVar;
            }
        } catch (IOException e) {
        } catch (Exception e2) {
        }
        return null;
    }

    public static List j(Context context) {
        try {
            return (List) new ObjectInputStream(new ByteArrayInputStream(Base64.decode(context.getSharedPreferences("ALauncher_m_bd_settings", d()).getString("baiduhottag", "").getBytes(), 0))).readObject();
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    public static Editor k(Context context) {
        return context.getSharedPreferences("Moxiu_back", d()).edit();
    }

    public static long l(Context context) {
        return context.getSharedPreferences("ALauncher_m_bd_settings", 1).getLong("baiduhotkeyrefreshtime", 0);
    }
}
