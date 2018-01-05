package com.vlocker.m;

import android.content.Context;
import android.text.TextUtils;
import com.vlocker.security.MoSecurityApplication;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class p {
    public static File a(Context context) {
        File file = null;
        if (context == null) {
            context = MoSecurityApplication.a();
        }
        if (context != null) {
            for (int i = 0; i < 3; i++) {
                file = context.getFilesDir();
                if (file != null) {
                    break;
                }
                try {
                    Thread.sleep(166);
                } catch (InterruptedException e) {
                }
            }
        }
        return file;
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? File.separator : str.charAt(str.length() + -1) != File.separatorChar ? str + File.separatorChar : str;
    }

    public static boolean a(File file, File file2) {
        if (!b(file, file2)) {
            return false;
        }
        file.delete();
        return true;
    }

    public static boolean b(File file, File file2) {
        OutputStream fileOutputStream;
        InputStream inputStream;
        Throwable th;
        FileOutputStream fileOutputStream2;
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        OutputStream outputStream;
        boolean z = false;
        BufferedOutputStream bufferedOutputStream = null;
        BufferedInputStream bufferedInputStream2 = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        InputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                inputStream = fileInputStream2;
            } catch (FileNotFoundException e) {
                fileOutputStream = null;
                inputStream = fileInputStream2;
                if (inputStream != null) {
                }
                if (null != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (null != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e22) {
                        e22.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e222) {
                        e222.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2222) {
                        e2222.printStackTrace();
                    }
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = null;
                InputStream inputStream2 = fileInputStream2;
                bufferedInputStream = null;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e22222) {
                        e22222.printStackTrace();
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e222222) {
                        e222222.printStackTrace();
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2222222) {
                        e2222222.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e4) {
            fileInputStream2 = null;
            fileOutputStream = null;
            inputStream = fileInputStream2;
            if (inputStream != null) {
            }
            if (null != null) {
                bufferedOutputStream2.close();
            }
            if (null != null) {
                bufferedInputStream2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            fileOutputStream2 = null;
            fileInputStream = null;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        if (inputStream != null || fileOutputStream == null) {
            if (null != null) {
                bufferedOutputStream2.close();
            }
            if (null != null) {
                bufferedInputStream2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } else {
            try {
                bufferedInputStream2 = new BufferedInputStream(inputStream);
                try {
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(fileOutputStream);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            try {
                                int read = bufferedInputStream2.read(bArr);
                                if (-1 == read) {
                                    break;
                                }
                                bufferedOutputStream3.write(bArr, 0, read);
                            } catch (IOException e5) {
                            }
                        }
                        bufferedOutputStream3.flush();
                        z = true;
                        if (bufferedOutputStream3 != null) {
                            try {
                                bufferedOutputStream3.close();
                            } catch (IOException e22222222) {
                                e22222222.printStackTrace();
                            }
                        }
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e222222222) {
                                e222222222.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2222222222) {
                                e2222222222.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e22222222222) {
                                e22222222222.printStackTrace();
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = bufferedOutputStream3;
                        bufferedInputStream = bufferedInputStream2;
                        outputStream = fileOutputStream;
                        inputStream2 = inputStream;
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = bufferedInputStream2;
                    outputStream = fileOutputStream;
                    inputStream2 = inputStream;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = null;
                outputStream = fileOutputStream;
                inputStream2 = inputStream;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        return z;
    }
}
