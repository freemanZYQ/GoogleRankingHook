package com.vlocker.weather.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.vlocker.b.i;
import com.vlocker.weather.e.a;
import com.vlocker.weather.e.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShowGifView extends View implements b {
    private a a;
    private Bitmap b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private Rect l;
    private s m;
    private u n;
    private byte[] o;
    private String p;
    private String q;
    private Handler r;

    public ShowGifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShowGifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.c = true;
        this.d = false;
        this.e = false;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = 0;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.n = u.SYNC_DECODER;
        this.r = new q(this, Looper.getMainLooper());
    }

    private void a() {
        if (this.a != null) {
            this.h = this.a.a;
            this.i = this.a.b;
            if (this.h > 0 && this.i > 0 && this.f > 0 && this.g > 0) {
                float f = (float) (this.h / this.i);
                float f2 = (float) (this.f / this.g);
                if (f >= 1.0f) {
                    if (f >= f2) {
                        this.j = this.f;
                        this.k = this.f / ((int) f);
                    } else {
                        this.k = this.g;
                        this.j = ((int) f) * this.g;
                    }
                } else if (f < 1.0f && f < f2) {
                    this.k = this.g;
                    this.j = ((int) f) * this.g;
                }
                a(this.j, this.k);
            }
            Log.e("debug", "show width-->" + this.j + " show height-->" + this.k + " max Width-->" + this.f + " max Height-->" + this.g + " rWidth-->" + this.h + " rHeight-->" + this.i);
        }
    }

    private void a(int i, int i2) {
        if (this.l == null) {
            this.l = new Rect();
        }
        this.l.left = 0;
        this.l.top = 0;
        this.l.right = i;
        this.l.bottom = i2;
    }

    private void b() {
        if (!TextUtils.isEmpty(this.q)) {
            Log.e("debug", "retry");
            a(this.q, true);
            new Thread(new t(this)).start();
        }
    }

    private void c() {
        if (this.r != null) {
            a();
            Message obtainMessage = this.r.obtainMessage();
            obtainMessage.what = 0;
            this.r.sendMessage(obtainMessage);
        }
    }

    private void setGifDecoderImage(InputStream inputStream) {
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
        this.a = new a(inputStream, (b) this);
        this.a.start();
    }

    private void setGifDecoderImage(byte[] bArr) {
        if (this.a != null) {
            this.a.a();
            this.a = null;
        }
        this.a = new a(bArr, (b) this);
        this.a.start();
    }

    public String a(String str) {
        File file = new File(i.h);
        if (!file.exists()) {
            file.mkdirs();
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        return (substring == null || substring.length() <= 0) ? null : i.h + substring;
    }

    public void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    for (File absolutePath : listFiles) {
                        a(absolutePath.getAbsolutePath(), true);
                    }
                }
                if (!z) {
                    return;
                }
                if (!file.isDirectory()) {
                    file.delete();
                } else if (file.listFiles().length == 0) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(boolean z, int i) {
        if (!z) {
            b();
        } else if (this.a != null) {
            switch (r.a[this.n.ordinal()]) {
                case 1:
                    if (i != -1) {
                        return;
                    }
                    if (this.a.b() > 1) {
                        new s().start();
                        return;
                    } else {
                        c();
                        return;
                    }
                case 2:
                    if (i == 1) {
                        this.b = this.a.c();
                        c();
                        return;
                    }
                    return;
                case 3:
                    if (i == 1) {
                        this.b = this.a.c();
                        c();
                        return;
                    } else if (i == -1) {
                        c();
                        return;
                    } else if (this.d && !this.c) {
                        this.c = true;
                        this.m = new s();
                        this.m.start();
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        } else {
            Log.e("gif", "parse error");
        }
    }

    public void a(boolean z, int i, u uVar) {
        this.n = uVar;
        a(z, i);
    }

    public void a(byte[] bArr, File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public byte[] b(String str) {
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayOutputStream.close();
                fileInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public byte[] c(String str) {
        Exception e;
        byte[] b;
        try {
            this.q = a(str);
            File file = new File(this.q);
            if (file.exists()) {
                b = b(this.q);
                if (b != null) {
                    return b;
                }
                try {
                    file.delete();
                    b = d(str);
                    a(b, file);
                    return b;
                } catch (Exception e2) {
                    e = e2;
                }
            } else {
                b = d(str);
                a(b, file);
                return b;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            b = null;
            e = exception;
            e.printStackTrace();
            return b;
        }
    }

    public byte[] d(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setRequestMethod("GET");
        return httpURLConnection.getResponseCode() == 200 ? a(httpURLConnection.getInputStream()) : null;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            if (this.a != null) {
                if (this.b == null) {
                    this.b = this.a.c();
                }
                if (this.b != null && !this.b.isRecycled()) {
                    int saveCount = canvas.getSaveCount();
                    canvas.save();
                    canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
                    if (this.j < 1) {
                        canvas.drawBitmap(this.b, 0.0f, 0.0f, null);
                    } else {
                        canvas.drawBitmap(this.b, null, this.l, null);
                    }
                    canvas.restoreToCount(saveCount);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onMeasure(int i, int i2) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        a();
        paddingRight = (paddingTop + paddingBottom) + this.k;
        setMeasuredDimension(resolveSize(Math.max((paddingLeft + paddingRight) + this.j, getSuggestedMinimumWidth()), i), resolveSize(Math.max(paddingRight, getSuggestedMinimumHeight()), i2));
    }

    public void setGifImage(int i) {
        setGifDecoderImage(getResources().openRawResource(i));
    }

    public void setGifImage(InputStream inputStream) {
        setGifDecoderImage(inputStream);
    }

    public void setGifImage(String str) {
        if (this.p == null || !this.p.equals(str)) {
            this.p = str;
            new Thread(new t(this)).start();
        }
    }

    public void setGifImage(byte[] bArr) {
        setGifDecoderImage(bArr);
    }

    public void setGifImageType(u uVar) {
        if (this.a == null) {
            this.n = uVar;
        }
    }
}
