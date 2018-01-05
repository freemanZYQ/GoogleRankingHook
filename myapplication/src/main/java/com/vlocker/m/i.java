package com.vlocker.m;

import com.baidu.location.LocationClientOption;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.vlocker.locker.BuildConfig;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class i {
    private static Object a = new Object();
    private static i b;

    private i() {
    }

    public static i a() {
        if (b == null) {
            synchronized (i.class) {
                if (b == null) {
                    b = new i();
                }
            }
        }
        return b;
    }

    private static String a(String str, String str2, String str3, String str4) {
        String str5 = "/data/data/" + str;
        String str6 = str5 + "/lib/" + str2;
        String str7 = str5 + "/" + str3;
        str5 = str5 + "/" + str3 + " " + str4;
        String str8 = "chmod 777 " + str7;
        str6 = "dd if=" + str6 + " of=" + str7;
        StringBuffer stringBuffer = new StringBuffer();
        if (!new File("/data/data/" + str3).exists()) {
            b(str, str6, stringBuffer);
            stringBuffer.append(";");
        }
        b(str, str8, stringBuffer);
        stringBuffer.append(";");
        b(str, str5, stringBuffer);
        stringBuffer.append(";");
        return stringBuffer.toString();
    }

    public static void b() {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        a(BuildConfig.APPLICATION_ID, "libmydaemon.so", "mydaemon1", "");
        File file = new File("/data/data/com.vlocker.locker/flag");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(new byte[]{(byte) 49});
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            e.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            throw th;
        }
    }

    private static boolean b(String str, String str2, StringBuffer stringBuffer) {
        try {
            Process exec = Runtime.getRuntime().exec(IXAdRequestInfo.SCREEN_HEIGHT);
            DataInputStream dataInputStream = new DataInputStream(exec.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
            dataOutputStream.writeBytes("cd /data/data/" + str + "\n");
            dataOutputStream.writeBytes(str2 + " &\n");
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            exec.waitFor();
            byte[] bArr = new byte[dataInputStream.available()];
            dataInputStream.read(bArr);
            String str3 = new String(bArr);
            if (stringBuffer != null) {
                stringBuffer.append("CMD Result:\n" + str3);
            }
            return true;
        } catch (Exception e) {
            if (stringBuffer != null) {
                stringBuffer.append("Exception:" + e.getMessage());
            }
            return false;
        }
    }

    public static void c() {
        Exception e;
        Throwable th;
        File file = new File("/data/data/com.vlocker.locker/flag");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(new byte[]{(byte) 48});
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            e.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            throw th;
        }
    }

    private static int h() {
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        int i = -1;
        CharSequence charSequence = "/data/data/com.vlocker.locker/mydaemon1";
        int i2 = i();
        if (i2 >= LocationClientOption.MIN_SCAN_SPAN) {
            File file = new File("/proc/" + i2 + "/cmdline");
            BufferedReader bufferedReader = null;
            if (file != null && file.exists() && file.isFile()) {
                BufferedReader bufferedReader2;
                try {
                    bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null && readLine.contains(charSequence)) {
                            i = i2;
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        e2 = e4;
                        try {
                            e2.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e32) {
                                    e32.printStackTrace();
                                }
                            }
                            return i;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e322) {
                                    e322.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        e322 = e5;
                        bufferedReader = bufferedReader2;
                        try {
                            e322.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e3222) {
                                    e3222.printStackTrace();
                                }
                            }
                            return i;
                        } catch (Throwable th3) {
                            th = th3;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    }
                } catch (FileNotFoundException e6) {
                    e2 = e6;
                    bufferedReader2 = null;
                    e2.printStackTrace();
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return i;
                } catch (IOException e7) {
                    e3222 = e7;
                    e3222.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return i;
                }
            }
        }
        return i;
    }

    private static int i() {
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        int i = 0;
        try {
            File file = new File("/data/data/com.vlocker.locker/daemon.pid");
            BufferedReader bufferedReader = null;
            if (file != null && file.exists()) {
                BufferedReader bufferedReader2;
                try {
                    bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    try {
                        i = Integer.valueOf(bufferedReader2.readLine().trim()).intValue();
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        e2 = e4;
                        try {
                            e2.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e32) {
                                    e32.printStackTrace();
                                }
                            }
                            return i;
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
                    } catch (IOException e6) {
                        e32 = e6;
                        bufferedReader = bufferedReader2;
                        try {
                            e32.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e322) {
                                    e322.printStackTrace();
                                }
                            }
                            return i;
                        } catch (Throwable th3) {
                            th = th3;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    } catch (NullPointerException e7) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3222) {
                                e3222.printStackTrace();
                            }
                        }
                        return i;
                    } catch (Exception e8) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e32222) {
                                e32222.printStackTrace();
                            }
                        }
                        return i;
                    }
                } catch (FileNotFoundException e9) {
                    e2 = e9;
                    bufferedReader2 = null;
                    e2.printStackTrace();
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return i;
                } catch (IOException e10) {
                    e32222 = e10;
                    e32222.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return i;
                } catch (NullPointerException e11) {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return i;
                } catch (Exception e12) {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return i;
                }
            }
        } catch (Exception e13) {
        }
        return i;
    }

    public void d() {
        new j(this, "kill -19 ").start();
    }

    public void e() {
        new j(this, "kill -18 ").start();
    }
}
