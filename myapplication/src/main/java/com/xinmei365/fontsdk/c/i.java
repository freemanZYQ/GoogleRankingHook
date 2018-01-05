package com.xinmei365.fontsdk.c;

import android.os.Environment;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.File;
import java.io.InputStream;

public class i {
    public static boolean D() {
        return Environment.getExternalStorageState().equals("mounted") && Environment.getExternalStorageDirectory().canWrite();
    }

    public static String E() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (!"".equals(absolutePath) && new File(absolutePath).canWrite()) {
            return absolutePath;
        }
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
            processBuilder.command(new String[]{"mount"});
            processBuilder.redirectErrorStream(true);
            Process start = processBuilder.start();
            start.waitFor();
            InputStream inputStream = start.getInputStream();
            byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
            while (-1 != inputStream.read(bArr)) {
                absolutePath = absolutePath + new String(bArr);
            }
            inputStream.close();
            start.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] split = absolutePath.split("\n");
        absolutePath = "";
        for (String str : split) {
            if (str.contains(" vfat ") || str.contains(" sdcardfs ")) {
                String[] split2 = str.split("\\s");
                if (split2.length > 1 && !"".equals(split2[1]) && new File(split2[1]).canWrite()) {
                    return split2[1];
                }
            }
        }
        return absolutePath;
    }
}
