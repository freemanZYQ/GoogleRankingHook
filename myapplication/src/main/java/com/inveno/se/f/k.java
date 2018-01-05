package com.inveno.se.f;

import android.os.Environment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class k {
    public static synchronized void a(String str, String str2) {
        BufferedWriter bufferedWriter;
        Exception e;
        Throwable th;
        synchronized (k.class) {
            if (a() && b(str2) && c.a(Environment.getExternalStorageDirectory()) != 0) {
                File file = new File(str2);
                File file2 = new File(file.getParent());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file.createNewFile();
                if (file.exists()) {
                    BufferedWriter bufferedWriter2 = null;
                    try {
                        bufferedWriter = new BufferedWriter(new FileWriter(str2));
                        try {
                            bufferedWriter.write(str);
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                e.printStackTrace();
                                if (bufferedWriter != null) {
                                    bufferedWriter.close();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedWriter2 = bufferedWriter;
                                if (bufferedWriter2 != null) {
                                    bufferedWriter2.close();
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        bufferedWriter = null;
                        e.printStackTrace();
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.close();
                        }
                        throw th;
                    }
                }
            }
        }
    }

    public static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean b(String str) {
        return !a(str);
    }

    public static String c(String str) {
        BufferedReader bufferedReader;
        Exception e;
        Throwable th;
        String str2 = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            try {
                str2 = bufferedReader.readLine();
                if (bufferedReader == null) {
                    return str2;
                }
                try {
                    bufferedReader.close();
                    return str2;
                } catch (IOException e2) {
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        return str2;
                    }
                    try {
                        bufferedReader.close();
                        return str2;
                    } catch (IOException e4) {
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            return null;
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            e.printStackTrace();
            if (bufferedReader != null) {
                return str2;
            }
            bufferedReader.close();
            return str2;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }
}
