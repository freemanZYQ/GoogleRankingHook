package com.moxiu.b.c;

import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpUriRequest;

public class p {
    final /* synthetic */ o a;
    private boolean b = false;

    public p(o oVar) {
        this.a = oVar;
    }

    public Object a(HttpEntity httpEntity, l lVar, String str, HttpUriRequest httpUriRequest) {
        Exception e;
        Throwable th;
        RandomAccessFile randomAccessFile = null;
        InputStream inputStream = null;
        try {
            if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
                randomAccessFile.close();
                inputStream.close();
                return null;
            } else if (str != null) {
                CharSequence substring = str.substring(str.lastIndexOf(".") + 1);
                File file = new File(str.replace(substring, "tmp"));
                long length = file.createNewFile() ? 0 : file.length();
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
                try {
                    InputStream content = httpEntity.getContent();
                    try {
                        randomAccessFile2.seek(content.skip(length));
                        if (this.b) {
                            randomAccessFile2.close();
                            content.close();
                            return null;
                        }
                        long contentLength = httpEntity.getContentLength();
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = content.read(bArr, 0, 8192);
                            if (read != -1 && !this.b) {
                                randomAccessFile2.write(bArr, 0, read);
                                length += (long) read;
                                lVar.a(contentLength, length, false);
                            }
                        }
                        if (length >= contentLength) {
                            file.renameTo(new File(str.replace("tmp", substring)));
                            lVar.a(contentLength, length, true);
                            randomAccessFile2.close();
                            content.close();
                            return file;
                        }
                        randomAccessFile2.close();
                        content.close();
                        return null;
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = content;
                        randomAccessFile = randomAccessFile2;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = content;
                        randomAccessFile = randomAccessFile2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile = randomAccessFile2;
                    try {
                        e.printStackTrace();
                        randomAccessFile.close();
                        inputStream.close();
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile.close();
                        inputStream.close();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    randomAccessFile = randomAccessFile2;
                    randomAccessFile.close();
                    inputStream.close();
                    throw th;
                }
            } else {
                randomAccessFile.close();
                inputStream.close();
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            randomAccessFile.close();
            inputStream.close();
            return null;
        }
    }
}
