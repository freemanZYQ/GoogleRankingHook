package com.vlocker.m;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.vlocker.b.j;
import com.vlocker.b.o;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;

public class be {
    private static int a;
    private static int b;
    private static String c = "";
    private static String d = "";

    private static String a(Context context, JSONObject jSONObject, String str, boolean z) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray == null) {
                return null;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (!(optJSONObject == null || optJSONObject.isNull("url"))) {
                    Object optString = optJSONObject.optString("url");
                    if (TextUtils.isEmpty(optString)) {
                        continue;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder(optString);
                        boolean equals = "post".equals(optJSONObject.optString("httpmethod"));
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("params");
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject2 != null) {
                                    String optString2 = optJSONObject2.optString("key");
                                    String optString3 = optJSONObject2.optString("value");
                                    if (!(TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3))) {
                                        stringBuilder = a(context, optString2, optString3, stringBuilder);
                                    }
                                }
                            }
                        }
                        String stringBuilder2 = stringBuilder.toString();
                        if (TextUtils.isEmpty(stringBuilder2)) {
                            continue;
                        } else if (!z) {
                            return stringBuilder2;
                        } else {
                            Thread bfVar = new bf(context, stringBuilder2, equals);
                            bfVar.setPriority(3);
                            bfVar.start();
                        }
                    }
                }
            }
            return null;
        } catch (Exception e) {
        }
    }

    private static StringBuilder a(Context context, String str, String str2, StringBuilder stringBuilder) {
        if (a < 1) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics = context.getResources().getDisplayMetrics();
            a = displayMetrics.widthPixels;
            b = displayMetrics.heightPixels;
        }
        if (TextUtils.isEmpty(c)) {
            try {
                c = "" + Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception e) {
            }
        }
        if (TextUtils.isEmpty(d)) {
            try {
                d = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
            } catch (Exception e2) {
            }
        }
        String d = e.d(context);
        String c = h.c();
        if (c == null) {
            c = "cn";
        }
        o b = j.b(context);
        if ("package".equals(str)) {
            c = "";
            try {
                c = URLEncoder.encode(context.getResources().getString(R.string.app_short_name), "utf-8");
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            stringBuilder.append("&" + str2 + "=").append(c);
        } else if ("imei".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(d);
        } else if ("channel".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(j.p(context));
        } else if ("language".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(c);
        } else if ("version".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(o.b(context));
        } else if ("ver".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(o.a(context));
        } else if ("android_sdk".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(VERSION.SDK_INT);
        } else if ("net".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(b);
        } else if ("ipaddr".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(j.f());
        } else if ("display".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(a + "*" + b);
        } else if ("timestamp".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(System.currentTimeMillis());
        } else if ("model".equals(str)) {
            c = "";
            try {
                c = URLEncoder.encode(Build.MODEL, "utf-8");
            } catch (Exception e32) {
                e32.printStackTrace();
            }
            stringBuilder.append("&" + str2 + "=").append(c);
        } else if ("manufacturer".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(Build.MANUFACTURER);
        } else if ("mac".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(d);
        } else if ("android_id".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(c);
        } else if ("width".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(a);
        } else if ("height".equals(str)) {
            stringBuilder.append("&" + str2 + "=").append(b);
        }
        return stringBuilder;
    }

    public static void a(Context context, Intent intent) {
        if (intent != null) {
            try {
                a(context, new JSONObject(intent.getStringExtra("trace")));
            } catch (Exception e) {
            }
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        a(context, jSONObject, "ex_tracking", true);
    }

    public static String b(Context context, Intent intent) {
        if (intent != null) {
            try {
                return b(context, new JSONObject(intent.getStringExtra("trace")));
            } catch (Exception e) {
            }
        }
        return null;
    }

    private static String b(Context context, JSONObject jSONObject) {
        return a(context, jSONObject, "cli_tracking", false);
    }

    private static void b(Context context, String str, boolean z) {
        Throwable th;
        if (j.i(context)) {
            HttpURLConnection httpURLConnection = null;
            HttpURLConnection httpURLConnection2;
            try {
                httpURLConnection2 = (HttpURLConnection) new URL(str.toString()).openConnection();
                if (z) {
                    try {
                        httpURLConnection2.setRequestMethod("POST");
                        httpURLConnection2.setDoOutput(true);
                    } catch (Exception e) {
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        httpURLConnection = httpURLConnection2;
                        th = th3;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                if (Integer.parseInt(VERSION.SDK) < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
                if (httpURLConnection2.getResponseCode() == 200) {
                    httpURLConnection2.getInputStream();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception e2) {
                httpURLConnection2 = null;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th4) {
                th = th4;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }
}
