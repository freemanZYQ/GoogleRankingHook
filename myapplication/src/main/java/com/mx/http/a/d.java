package com.mx.http.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.util.Map;

public class d {
    private static String a = "moxiu_http_data";

    public static Object a(Context context, String str, Class cls) {
        ObjectInputStream objectInputStream;
        Object readObject;
        IOException e;
        StreamCorruptedException e2;
        Throwable th;
        ClassNotFoundException e3;
        ObjectInputStream objectInputStream2 = null;
        SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
        if (sharedPreferences.contains(str)) {
            InputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(sharedPreferences.getString(str, objectInputStream2), 0));
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    readObject = objectInputStream.readObject();
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                } catch (StreamCorruptedException e5) {
                    e2 = e5;
                    try {
                        e2.printStackTrace();
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e42) {
                                e42.printStackTrace();
                            }
                        }
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return readObject;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e422) {
                                e422.printStackTrace();
                                throw th;
                            }
                        }
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e422 = e6;
                    e422.printStackTrace();
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e4222) {
                            e4222.printStackTrace();
                        }
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    return readObject;
                } catch (ClassNotFoundException e7) {
                    e3 = e7;
                    e3.printStackTrace();
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e42222) {
                            e42222.printStackTrace();
                        }
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    return readObject;
                }
            } catch (StreamCorruptedException e8) {
                e2 = e8;
                objectInputStream = objectInputStream2;
                e2.printStackTrace();
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return readObject;
            } catch (IOException e9) {
                e42222 = e9;
                objectInputStream = objectInputStream2;
                e42222.printStackTrace();
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return readObject;
            } catch (ClassNotFoundException e10) {
                e3 = e10;
                objectInputStream = objectInputStream2;
                e3.printStackTrace();
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return readObject;
            } catch (Throwable th3) {
                objectInputStream = objectInputStream2;
                th = th3;
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                throw th;
            }
        }
        return readObject;
    }

    public static Map a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
        return sharedPreferences != null ? sharedPreferences.getAll() : null;
    }

    public static void a(Context context, String str, Object obj) {
        ObjectOutputStream objectOutputStream;
        IOException e;
        Throwable th;
        SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                String str2 = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
                Editor edit = sharedPreferences.edit();
                edit.putString(str, str2);
                edit.commit();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    e2.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                            return;
                        }
                    }
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e22 = e5;
            objectOutputStream = null;
            e22.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            throw th;
        }
    }

    public static boolean a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
        if (sharedPreferences == null) {
            return false;
        }
        Editor edit = sharedPreferences.edit();
        edit.remove(str);
        return edit.commit();
    }
}
