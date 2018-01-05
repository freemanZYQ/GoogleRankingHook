package com.vlocker.m;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class bd {
    public static void a(String str, String str2) {
        if (str != null && str2 != null) {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
            File file = new File(str);
            a(file.getParent() + File.separator, file.getName(), zipOutputStream);
            zipOutputStream.flush();
            zipOutputStream.close();
        }
    }

    private static void a(String str, String str2, ZipOutputStream zipOutputStream) {
        int i = 0;
        if (zipOutputStream != null) {
            File file = new File(str + str2);
            if (file.isFile()) {
                ZipEntry zipEntry = new ZipEntry(str2);
                FileInputStream fileInputStream = new FileInputStream(file);
                zipOutputStream.putNextEntry(zipEntry);
                byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, IXAdIOUtils.BUFFER_SIZE);
                    if (read != -1) {
                        zipOutputStream.write(bArr, 0, read);
                    } else {
                        fileInputStream.close();
                        return;
                    }
                }
            }
            String[] list = file.list();
            if (list != null) {
                if (list.length <= 0) {
                    zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                }
                while (i < list.length) {
                    a(str, str2 + File.separator + list[i], zipOutputStream);
                    i++;
                }
            }
        }
    }
}
