package com.moxiu.b.d;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class e {
    public static final String a = (Environment.getExternalStorageDirectory().toString() + "/moxiu/pullup.flag");
    public static final String b = (Environment.getExternalStorageDirectory().toString() + "/moxiu/");

    private static String a() {
        Exception e;
        Throwable th;
        String str = null;
        File file = new File(a);
        if (file.exists()) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    char[] cArr = new char[IXAdIOUtils.BUFFER_SIZE];
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        int read = bufferedReader.read(cArr);
                        if (read == -1) {
                            break;
                        }
                        stringBuffer.append(cArr, 0, read);
                    }
                    str = stringBuffer.toString();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                Object obj = str;
                e.printStackTrace();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return str;
            } catch (Throwable th3) {
                bufferedReader = str;
                th = th3;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        }
        return str;
    }

    public static void a(Context context) {
        context.sendBroadcast(new Intent("pullup_changed"));
    }

    public static synchronized void a(Context context, String str) {
        synchronized (e.class) {
            if (b()) {
                JSONObject jSONObject;
                String a = a();
                if (a != null) {
                    try {
                        jSONObject = new JSONObject(a);
                        a(jSONObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    jSONObject = new JSONObject();
                }
                jSONObject.putOpt(str, Integer.valueOf(new Date().getDate()));
                b(jSONObject.toString());
                a(context);
            }
        }
    }

    private static void a(JSONObject jSONObject) {
        try {
            int date = new Date().getDate();
            Iterator keys = jSONObject.keys();
            List arrayList = new ArrayList();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (date > jSONObject.getInt(str)) {
                    arrayList.add(str);
                }
            }
            for (date = 0; date < arrayList.size(); date++) {
                jSONObject.remove((String) arrayList.get(date));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized boolean a(String str) {
        boolean z = false;
        synchronized (e.class) {
            if (b()) {
                String a = a();
                if (a != null) {
                    try {
                        if (new Date().getDate() == new JSONObject(a).getInt(str)) {
                            z = true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return z;
    }

    private static void b(String str) {
        try {
            File file = new File(b);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(a);
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean b() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
