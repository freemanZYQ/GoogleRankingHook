package com.vlocker.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.vlocker.beans.ThemeItemInfo;
import com.vlocker.i.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class n {
    public boolean a = false;
    b b = null;
    private final String c = "Http";
    private long d = 0;
    private boolean e = false;

    public long a(String str, String str2, b bVar, ThemeItemInfo themeItemInfo) {
        InputStream inputStream;
        InputStream inputStream2;
        RandomAccessFile randomAccessFile;
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        Log.i("xx", "downloadHomeOrOther======22=======");
        if (str2 == null) {
            return -1;
        }
        int length;
        this.b = bVar;
        this.a = false;
        RandomAccessFile randomAccessFile2 = null;
        InputStream inputStream3 = null;
        int i = 0;
        File file = new File(str + ".tmp");
        try {
            length = file.createNewFile() ? 0 : (int) file.length();
        } catch (IOException e) {
            e.printStackTrace();
            length = i;
        }
        Log.i("xx", "downloadHomeOrOther======220=======" + str);
        RandomAccessFile randomAccessFile3;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.addRequestProperty("Range", "bytes=" + length + "-");
                if (httpURLConnection2.getResponseCode() == 200 || httpURLConnection2.getResponseCode() == 206) {
                    inputStream = httpURLConnection2.getInputStream();
                    try {
                        this.d = (long) Integer.parseInt(httpURLConnection2.getHeaderField("Accept-Length"));
                        long contentLength = this.d - ((long) httpURLConnection2.getContentLength());
                        randomAccessFile3 = new RandomAccessFile(file, "rwd");
                        try {
                            int i2;
                            randomAccessFile3.seek((long) length);
                            byte[] bArr = new byte[4096];
                            int i3 = length;
                            length = 0;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                randomAccessFile3.write(bArr, 0, read);
                                int i4 = i3 + read;
                                randomAccessFile3.seek((long) i4);
                                i2 = length + read;
                                Log.i("xx", "downloadHomeOrOther======33=======" + i2);
                                this.b.a((long) i4, this.d, false, themeItemInfo);
                                if (this.a) {
                                    break;
                                }
                                length = i2;
                                i3 = i4;
                            }
                            i2 = length;
                            if (!this.a) {
                                this.b.a((long) i2, this.d, true, themeItemInfo);
                            }
                            if (this.a) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                if (randomAccessFile3 != null) {
                                    randomAccessFile3.close();
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                return -2;
                            }
                            File file2 = new File(str + ".apk");
                            if (file2.exists()) {
                                file2.delete();
                            }
                            file.renameTo(file2);
                            contentLength = (long) i2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e3) {
                                }
                            }
                            if (randomAccessFile3 != null) {
                                randomAccessFile3.close();
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            return contentLength;
                        } catch (Exception e4) {
                            inputStream2 = inputStream;
                            randomAccessFile = randomAccessFile3;
                            httpURLConnection = httpURLConnection2;
                            exception = e4;
                            try {
                                Log.i("xx", "downloadHomeOrOther======221=======" + exception.toString());
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e5) {
                                        return -1;
                                    }
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                if (httpURLConnection == null) {
                                    return -1;
                                }
                                httpURLConnection.disconnect();
                                return -1;
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = inputStream2;
                                randomAccessFile3 = randomAccessFile;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e6) {
                                        throw th;
                                    }
                                }
                                if (randomAccessFile3 != null) {
                                    randomAccessFile3.close();
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            httpURLConnection = httpURLConnection2;
                            th = th3;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (randomAccessFile3 != null) {
                                randomAccessFile3.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Exception e42) {
                        inputStream2 = inputStream;
                        randomAccessFile = randomAccessFile2;
                        httpURLConnection = httpURLConnection2;
                        exception = e42;
                        Log.i("xx", "downloadHomeOrOther======221=======" + exception.toString());
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (httpURLConnection == null) {
                            return -1;
                        }
                        httpURLConnection.disconnect();
                        return -1;
                    } catch (Throwable th32) {
                        randomAccessFile3 = randomAccessFile2;
                        httpURLConnection = httpURLConnection2;
                        th = th32;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (randomAccessFile3 != null) {
                            randomAccessFile3.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (Exception e7) {
                    }
                }
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return -2;
            } catch (Exception e422) {
                inputStream2 = inputStream3;
                randomAccessFile = randomAccessFile2;
                httpURLConnection = httpURLConnection2;
                exception = e422;
                Log.i("xx", "downloadHomeOrOther======221=======" + exception.toString());
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (httpURLConnection == null) {
                    return -1;
                }
                httpURLConnection.disconnect();
                return -1;
            } catch (Throwable th322) {
                inputStream = inputStream3;
                randomAccessFile3 = randomAccessFile2;
                httpURLConnection = httpURLConnection2;
                th = th322;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (randomAccessFile3 != null) {
                    randomAccessFile3.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e8) {
            exception = e8;
            randomAccessFile = randomAccessFile2;
            InputStream inputStream4 = inputStream3;
            httpURLConnection = null;
            inputStream2 = inputStream4;
            Log.i("xx", "downloadHomeOrOther======221=======" + exception.toString());
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            if (httpURLConnection == null) {
                return -1;
            }
            httpURLConnection.disconnect();
            return -1;
        } catch (Throwable th4) {
            th = th4;
            inputStream = inputStream3;
            randomAccessFile3 = randomAccessFile2;
            httpURLConnection = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (randomAccessFile3 != null) {
                randomAccessFile3.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public boolean a(String str, String str2) {
        RandomAccessFile randomAccessFile;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        RandomAccessFile randomAccessFile2;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        Throwable th2;
        InputStream inputStream3 = null;
        boolean z = false;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return false;
        }
        this.a = false;
        File file = new File(str + ".tmp");
        try {
            int length = file.createNewFile() ? 0 : (int) file.length();
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str2).openConnection();
            try {
                InputStream inputStream4;
                httpURLConnection3.setConnectTimeout(10000);
                httpURLConnection3.setRequestMethod("GET");
                httpURLConnection3.addRequestProperty("Range", "bytes=" + length + "-");
                if (httpURLConnection3.getResponseCode() == 200 || httpURLConnection3.getResponseCode() == 206) {
                    inputStream4 = httpURLConnection3.getInputStream();
                    try {
                        randomAccessFile = new RandomAccessFile(file, "rwd");
                    } catch (Exception e) {
                        inputStream = inputStream4;
                        httpURLConnection = httpURLConnection3;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e2) {
                                return false;
                            }
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return false;
                    } catch (Throwable th3) {
                        randomAccessFile = null;
                        inputStream3 = inputStream4;
                        th = th3;
                        httpURLConnection2 = httpURLConnection3;
                        th2 = th;
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Exception e3) {
                                throw th2;
                            }
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th2;
                    }
                    try {
                        randomAccessFile.seek((long) length);
                        byte[] bArr = new byte[4096];
                        int i = 0;
                        do {
                            int read = inputStream4.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            randomAccessFile.write(bArr, 0, read);
                            length += read;
                            randomAccessFile.seek((long) length);
                            i += read;
                        } while (!this.a);
                        if (!this.a) {
                            File file2 = new File(str + ".apk");
                            if (file2.exists()) {
                                file2.delete();
                            }
                            file.renameTo(file2);
                            z = true;
                        }
                    } catch (Exception e4) {
                        randomAccessFile2 = randomAccessFile;
                        inputStream = inputStream4;
                        httpURLConnection = httpURLConnection3;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return false;
                    } catch (Throwable th32) {
                        inputStream3 = inputStream4;
                        th = th32;
                        httpURLConnection2 = httpURLConnection3;
                        th2 = th;
                        if (inputStream3 != null) {
                            inputStream3.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th2;
                    }
                }
                inputStream4 = null;
                randomAccessFile = null;
                z = true;
                if (inputStream4 != null) {
                    try {
                        inputStream4.close();
                    } catch (Exception e5) {
                        return z;
                    }
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return z;
            } catch (Exception e6) {
                httpURLConnection = httpURLConnection3;
                inputStream2 = null;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return false;
            } catch (Throwable th322) {
                randomAccessFile = null;
                th = th322;
                httpURLConnection2 = httpURLConnection3;
                th2 = th;
                if (inputStream3 != null) {
                    inputStream3.close();
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th2;
            }
        } catch (Exception e7) {
            inputStream2 = null;
            httpURLConnection = null;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return false;
        } catch (Throwable th4) {
            th2 = th4;
            randomAccessFile = null;
            httpURLConnection2 = null;
            if (inputStream3 != null) {
                inputStream3.close();
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th2;
        }
    }

    public long b(String str, String str2, b bVar, ThemeItemInfo themeItemInfo) {
        Log.i("xx", "downloadHomeOrOther======11=======");
        this.b = bVar;
        this.a = false;
        File file = new File(str + ".tmp");
        try {
            int length = file.createNewFile() ? 0 : (int) file.length();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            randomAccessFile.seek((long) length);
            if (str2 == null) {
                return -1;
            }
            try {
                long j;
                HttpUriRequest httpGet = new HttpGet(str2);
                httpGet.addHeader("Range", "bytes=" + length + "-");
                HttpClient defaultHttpClient = new DefaultHttpClient();
                HttpParams params = defaultHttpClient.getParams();
                HttpConnectionParams.setConnectionTimeout(params, 60000);
                HttpConnectionParams.setSoTimeout(params, 60000);
                HttpResponse execute = defaultHttpClient.execute(httpGet);
                HttpEntity entity = execute.getEntity();
                InputStream content = entity.getContent();
                long j2 = 0;
                long contentLength = entity.getContentLength();
                byte[] bArr;
                int read;
                long j3;
                switch (execute.getStatusLine().getStatusCode()) {
                    case 200:
                        bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
                        while (true) {
                            read = content.read(bArr);
                            if (-1 != read) {
                                randomAccessFile.write(bArr, 0, read);
                                length += read;
                                randomAccessFile.seek((long) length);
                                j3 = j2 + ((long) read);
                                this.b.a((long) length, contentLength, false, themeItemInfo);
                                j2 = this.a ? j3 : j3;
                            }
                            content.close();
                            if (!this.a) {
                                this.b.a(j2, contentLength, true, themeItemInfo);
                            }
                            j = j2;
                            break;
                        }
                    case 206:
                        bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
                        while (true) {
                            read = content.read(bArr);
                            if (-1 != read) {
                                randomAccessFile.write(bArr, 0, read);
                                length += read;
                                randomAccessFile.seek((long) length);
                                j3 = j2 + ((long) read);
                                this.b.a((long) length, contentLength, false, themeItemInfo);
                                j2 = this.a ? j3 : j3;
                            }
                            content.close();
                            if (!this.a) {
                                this.b.a(j2, contentLength, true, themeItemInfo);
                            }
                            j = j2;
                            break;
                        }
                    default:
                        j = 0;
                        break;
                }
                if (this.a) {
                    return -2;
                }
                File file2 = new File(str + ".apk");
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
                return j;
            } catch (NullPointerException e) {
                e.printStackTrace();
                return -1;
            } catch (IndexOutOfBoundsException e2) {
                e2.printStackTrace();
                return -1;
            } catch (IOException e3) {
                e3.printStackTrace();
                return -1;
            } catch (Exception e4) {
                return -1;
            }
        } catch (IOException e32) {
            e32.printStackTrace();
            return -1;
        }
    }
}
