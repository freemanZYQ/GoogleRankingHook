package com.baidu.mobads.j;

import android.content.Context;
import android.os.Environment;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class i implements IXAdIOUtils {
    public void copyFileFromAssetsTo(Context context, String str, String str2) {
        try {
            m.a().k().copyFileInputStream(context.getAssets().open(str), str2);
        } catch (Throwable e) {
            m.a().f().d(e);
        }
    }

    public void copyFileInputStream(InputStream inputStream, String str) {
        Throwable th;
        OutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                inputStream.close();
                fileOutputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public File deleteFileRecursive(File file) {
        File file2 = null;
        try {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File deleteFileRecursive : listFiles) {
                    File deleteFileRecursive2 = deleteFileRecursive(deleteFileRecursive2);
                    if (deleteFileRecursive2 != null) {
                        return deleteFileRecursive2;
                    }
                }
            }
            return file.delete() ? null : file;
        } catch (Exception e) {
            if (!file.delete()) {
                file2 = file;
            }
            return file2;
        }
    }

    public File deleteFileRecursive(String str) {
        return deleteFileRecursive(new File(str));
    }

    public File getExternalFilesDir(Context context) {
        try {
            return m.a().n().isUseOldStoragePath() ? Environment.getExternalStorageDirectory() : context.getExternalFilesDir(null);
        } catch (Exception e) {
            m.a().f().e("XAdIOUtils", e.getMessage());
            return null;
        }
    }

    public String getStoreagePath(Context context) {
        return getStoreagePath(context, IXAdIOUtils.DEFAULT_SD_CARD_PATH, IXAdIOUtils.DEFAULT_CACHE_PATH);
    }

    public String getStoreagePath(Context context, String str, String str2) {
        try {
            return getExternalFilesDir(context).getPath() + str2;
        } catch (Exception e) {
            return str + str2;
        }
    }

    public boolean renameFile(String str, String str2) {
        boolean z = false;
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (file != null && file.exists()) {
                z = file.renameTo(file2);
            }
        } catch (Exception e) {
        }
        return z;
    }
}
