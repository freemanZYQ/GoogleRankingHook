package com.vlocker.j.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    public static String a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(b(str));
            if (jSONObject != null) {
                return jSONObject.getString("lyric");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String b(String str) {
        Exception e;
        Throwable th;
        File file = new File(str);
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                } catch (Exception e2) {
                    e = e2;
                }
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader2 = null;
            try {
                e.printStackTrace();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                    }
                }
                return stringBuffer.toString();
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        return stringBuffer.toString();
    }
}
