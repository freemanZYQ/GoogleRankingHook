package com.xinmei365.fontsdk.c;

import com.xinmei365.fontsdk.bean.Font;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class c {
    private static int aA = 4096;

    public static void a(Font font, String str) {
        Closeable bufferedWriter;
        IOException e;
        Throwable th;
        if (font != null && str != null) {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(str));
                try {
                    bufferedWriter.write(Font.createJSONObjectByFont(font).toString());
                    d.a(bufferedWriter);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        d.a(bufferedWriter);
                    } catch (Throwable th2) {
                        th = th2;
                        d.a(bufferedWriter);
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                bufferedWriter = null;
                e.printStackTrace();
                d.a(bufferedWriter);
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = null;
                d.a(bufferedWriter);
                throw th;
            }
        }
    }

    public static boolean a(String str, String str2, String str3) {
        Closeable fileInputStream;
        Exception e;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        Object obj;
        Closeable closeable;
        Closeable closeable2 = null;
        Closeable zipInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
                Closeable closeable3 = null;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            try {
                                if (nextEntry.getName().contains("font")) {
                                    if (nextEntry.getName().contains("font-en")) {
                                        d.a(closeable3);
                                        d.a(closeable2);
                                    } else {
                                        byte[] bArr = new byte[aA];
                                        File file = new File(str2 + str3 + ".ttf");
                                        File file2 = new File(file.getParent());
                                        if (!file2.exists()) {
                                            file2.mkdirs();
                                        }
                                        OutputStream fileOutputStream = new FileOutputStream(file);
                                        try {
                                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream, aA);
                                            while (true) {
                                                try {
                                                    int read = zipInputStream.read(bArr, 0, aA);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    bufferedOutputStream2.write(bArr, 0, read);
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    OutputStream outputStream = fileOutputStream;
                                                    bufferedOutputStream = bufferedOutputStream2;
                                                    closeable2 = outputStream;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    Object obj2 = bufferedOutputStream2;
                                                    obj = fileOutputStream;
                                                }
                                            }
                                            bufferedOutputStream2.flush();
                                            closeable3 = bufferedOutputStream2;
                                            closeable2 = fileOutputStream;
                                        } catch (Exception e3) {
                                            e = e3;
                                            obj = fileOutputStream;
                                            closeable = closeable3;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            obj = fileOutputStream;
                                        }
                                    }
                                }
                                d.a(closeable3);
                                d.a(closeable2);
                            } catch (Exception e4) {
                                e = e4;
                                closeable = closeable3;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } else {
                            d.a(zipInputStream);
                            d.a(fileInputStream);
                            return true;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        closeable2 = zipInputStream;
                        closeable = fileInputStream;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                try {
                    throw e;
                } catch (Throwable th6) {
                    th = th6;
                    closeable3 = bufferedOutputStream;
                }
                d.a(closeable3);
                d.a(closeable2);
                throw th;
            } catch (Exception e6) {
                e = e6;
                closeable = fileInputStream;
                try {
                    throw e;
                } catch (Throwable th7) {
                    th = th7;
                    zipInputStream = closeable2;
                    fileInputStream = closeable;
                }
            } catch (Throwable th8) {
                th = th8;
                zipInputStream = null;
                d.a(zipInputStream);
                d.a(fileInputStream);
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            closeable = null;
            throw e;
        } catch (Throwable th9) {
            th = th9;
            zipInputStream = null;
            fileInputStream = null;
            d.a(zipInputStream);
            d.a(fileInputStream);
            throw th;
        }
    }

    public static boolean deleteFile(String str) {
        if (str == null) {
            return true;
        }
        File file = new File(str);
        return file.exists() ? file.delete() : true;
    }

    public static boolean f(String str, String str2) {
        return deleteFile(str + str2);
    }

    public static boolean z(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            for (String str2 : file.list()) {
                if (!z(file.getAbsolutePath() + "/" + str2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }
}
