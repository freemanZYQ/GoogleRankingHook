package com.vlocker.theme.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.vlocker.theme.f.c;
import com.vlocker.theme.f.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;

class w extends a {
    int d;
    int e;
    ScaleType f;
    final /* synthetic */ u g;
    private Object h;
    private final WeakReference i;
    private int j;
    private String k = "";

    public w(u uVar, Object obj, RecyclingImageView recyclingImageView, int i, int i2, int i3, ScaleType scaleType) {
        this.g = uVar;
        this.h = obj;
        this.e = i2;
        this.d = i;
        this.j = i3;
        this.f = scaleType;
        this.i = new WeakReference(recyclingImageView);
    }

    private RecyclingImageView d() {
        ImageView imageView = (RecyclingImageView) this.i.get();
        return this == u.b(imageView) ? imageView : null;
    }

    protected BitmapDrawable a(Void... voidArr) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable;
        FileInputStream fileInputStream;
        BitmapDrawable bitmapDrawable2;
        Exception e;
        Throwable th;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3 = null;
        RecyclingImageView d = d();
        if (d != null) {
            d.setisloading(true);
            Drawable background = d.getBackground();
            if (background != null) {
                background.setCallback(null);
            }
        }
        this.k = String.valueOf(this.h);
        synchronized (this.g.d) {
            while (this.g.e && !c()) {
                try {
                    this.g.d.wait();
                } catch (InterruptedException e2) {
                }
            }
        }
        if (this.g.a == null || c() || d() == null || this.g.c) {
            bitmap = null;
        } else {
            try {
                Bitmap a = (this.j == 0 || this.j == 1 || this.j == 4 || this.j == 7 || this.j == 13 || this.j > 10000) ? this.g.a.a(this.g.g, this.k, this.j) : this.g.a.a(this.g.g, this.k + this.j, this.j);
                bitmap = a;
            } catch (Exception e3) {
                bitmap = null;
            }
        }
        if (bitmap != null || c() || d() == null || this.g.c) {
            Object obj = null;
            a = bitmap;
        } else {
            try {
                if (this.j == 0 || this.j == 13 || this.j == 30) {
                    bitmap = this.g.a(this.k, this.g.i, this.g.j, this.j);
                    if (bitmap == null) {
                        try {
                            InputStream openStream = new URL(this.k).openStream();
                            bitmap = BitmapFactory.decodeStream(openStream);
                            this.g.a.a(this.g.g, this.k, openStream);
                            bitmapDrawable = null;
                        } catch (OutOfMemoryError e4) {
                            e4.printStackTrace();
                            try {
                                this.g.a.b.a();
                                this.g.a.a.c();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                            bitmapDrawable = null;
                        }
                    }
                    bitmapDrawable = null;
                } else if (this.j == 1) {
                    try {
                        fileInputStream = new FileInputStream(new File(this.k));
                        try {
                            a = r.a(fileInputStream.getFD(), this.g.i, this.g.j, this.g.a, this.j);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e7) {
                                    bitmap = a;
                                    bitmapDrawable = null;
                                    bitmapDrawable2 = bitmapDrawable;
                                    a = bitmap;
                                    if (a != null) {
                                        bitmap = a;
                                    } else {
                                        try {
                                            if (this.j != 0) {
                                            }
                                            a = this.g.a(this.k, this.g.i, this.g.j, this.j);
                                            if (fileInputStream3 != null) {
                                                try {
                                                    fileInputStream3.close();
                                                } catch (IOException e8) {
                                                    e8.printStackTrace();
                                                }
                                            }
                                        } catch (Exception e9) {
                                            e = e9;
                                            try {
                                                e.printStackTrace();
                                                if (fileInputStream3 != null) {
                                                    try {
                                                        fileInputStream3.close();
                                                    } catch (IOException e82) {
                                                        e82.printStackTrace();
                                                    }
                                                }
                                                bitmap = a;
                                                if (bitmap != null) {
                                                    return bitmapDrawable2;
                                                }
                                                bitmapDrawable = aa.b() ? new z(this.g.f, bitmap) : new BitmapDrawable(this.g.f, bitmap);
                                                if (this.g.a != null) {
                                                    return bitmapDrawable;
                                                }
                                                if (this.j != 0) {
                                                }
                                                this.g.a.a(this.k, bitmapDrawable, this.j);
                                                return bitmapDrawable;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                if (fileInputStream3 != null) {
                                                    try {
                                                        fileInputStream3.close();
                                                    } catch (IOException e10) {
                                                        e10.printStackTrace();
                                                    }
                                                }
                                                throw th;
                                            }
                                        }
                                        bitmap = a;
                                    }
                                    if (bitmap != null) {
                                        return bitmapDrawable2;
                                    }
                                    if (aa.b()) {
                                    }
                                    if (this.g.a != null) {
                                        return bitmapDrawable;
                                    }
                                    if (this.j != 0) {
                                    }
                                    this.g.a.a(this.k, bitmapDrawable, this.j);
                                    return bitmapDrawable;
                                }
                            }
                        } catch (Exception e11) {
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 == null) {
                                a = bitmap;
                            } else {
                                fileInputStream2.close();
                                a = bitmap;
                            }
                            bitmap = a;
                            bitmapDrawable = null;
                            bitmapDrawable2 = bitmapDrawable;
                            a = bitmap;
                            if (a != null) {
                                bitmap = a;
                            } else {
                                if (this.j != 0) {
                                }
                                a = this.g.a(this.k, this.g.i, this.g.j, this.j);
                                if (fileInputStream3 != null) {
                                    fileInputStream3.close();
                                }
                                bitmap = a;
                            }
                            if (bitmap != null) {
                                return bitmapDrawable2;
                            }
                            if (aa.b()) {
                            }
                            if (this.g.a != null) {
                                return bitmapDrawable;
                            }
                            if (this.j != 0) {
                            }
                            this.g.a.a(this.k, bitmapDrawable, this.j);
                            return bitmapDrawable;
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e12) {
                        fileInputStream2 = null;
                        if (fileInputStream2 == null) {
                            fileInputStream2.close();
                            a = bitmap;
                        } else {
                            a = bitmap;
                        }
                        bitmap = a;
                        bitmapDrawable = null;
                        bitmapDrawable2 = bitmapDrawable;
                        a = bitmap;
                        if (a != null) {
                            if (this.j != 0) {
                            }
                            a = this.g.a(this.k, this.g.i, this.g.j, this.j);
                            if (fileInputStream3 != null) {
                                fileInputStream3.close();
                            }
                            bitmap = a;
                        } else {
                            bitmap = a;
                        }
                        if (bitmap != null) {
                            return bitmapDrawable2;
                        }
                        if (aa.b()) {
                        }
                        if (this.g.a != null) {
                            return bitmapDrawable;
                        }
                        if (this.j != 0) {
                        }
                        this.g.a.a(this.k, bitmapDrawable, this.j);
                        return bitmapDrawable;
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                    bitmap = a;
                    bitmapDrawable = null;
                } else if (this.j == 2) {
                    bitmapDrawable = (BitmapDrawable) c.i(this.g.b, this.k);
                    if (bitmapDrawable == null) {
                        return bitmapDrawable;
                    }
                    try {
                        if (this.g.a == null) {
                            return bitmapDrawable;
                        }
                        this.g.a.a(this.k + this.j, bitmapDrawable, this.j);
                        return bitmapDrawable;
                    } catch (Exception e13) {
                        bitmapDrawable2 = bitmapDrawable;
                        a = bitmap;
                        if (a != null) {
                            if (this.j != 0) {
                            }
                            a = this.g.a(this.k, this.g.i, this.g.j, this.j);
                            if (fileInputStream3 != null) {
                                fileInputStream3.close();
                            }
                            bitmap = a;
                        } else {
                            bitmap = a;
                        }
                        if (bitmap != null) {
                            return bitmapDrawable2;
                        }
                        if (aa.b()) {
                        }
                        if (this.g.a != null) {
                            return bitmapDrawable;
                        }
                        if (this.j != 0) {
                        }
                        this.g.a.a(this.k, bitmapDrawable, this.j);
                        return bitmapDrawable;
                    }
                } else if (this.j == 3) {
                    bitmapDrawable = (BitmapDrawable) c.j(this.g.b, this.k);
                    if (bitmapDrawable == null) {
                        return bitmapDrawable;
                    }
                    if (this.g.a == null) {
                        return bitmapDrawable;
                    }
                    this.g.a.a(this.k + this.j, bitmapDrawable, this.j);
                    return bitmapDrawable;
                } else if (this.j == 4) {
                    bitmap = r.a(Integer.valueOf(this.h.toString()).intValue(), e.a, this.g.a);
                    bitmapDrawable = null;
                } else if (this.j == 7) {
                    try {
                        fileInputStream2 = new FileInputStream(new File(this.k));
                        try {
                            bitmap = r.b(fileInputStream2.getFD(), this.g.i, this.g.j, this.g.a, this.j);
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                        } catch (Exception e14) {
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            bitmapDrawable = null;
                            bitmapDrawable2 = bitmapDrawable;
                            a = bitmap;
                            if (a != null) {
                                if (this.j != 0) {
                                }
                                a = this.g.a(this.k, this.g.i, this.g.j, this.j);
                                if (fileInputStream3 != null) {
                                    fileInputStream3.close();
                                }
                                bitmap = a;
                            } else {
                                bitmap = a;
                            }
                            if (bitmap != null) {
                                return bitmapDrawable2;
                            }
                            if (aa.b()) {
                            }
                            if (this.g.a != null) {
                                return bitmapDrawable;
                            }
                            if (this.j != 0) {
                            }
                            this.g.a.a(this.k, bitmapDrawable, this.j);
                            return bitmapDrawable;
                        } catch (Throwable th5) {
                            Throwable th6 = th5;
                            fileInputStream = fileInputStream2;
                            th = th6;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e15) {
                        fileInputStream2 = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        bitmapDrawable = null;
                        bitmapDrawable2 = bitmapDrawable;
                        a = bitmap;
                        if (a != null) {
                            bitmap = a;
                        } else {
                            if (this.j != 0) {
                            }
                            a = this.g.a(this.k, this.g.i, this.g.j, this.j);
                            if (fileInputStream3 != null) {
                                fileInputStream3.close();
                            }
                            bitmap = a;
                        }
                        if (bitmap != null) {
                            return bitmapDrawable2;
                        }
                        if (aa.b()) {
                        }
                        if (this.g.a != null) {
                            return bitmapDrawable;
                        }
                        if (this.j != 0) {
                        }
                        this.g.a.a(this.k, bitmapDrawable, this.j);
                        return bitmapDrawable;
                    } catch (Throwable th7) {
                        th = th7;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                    bitmapDrawable = null;
                } else if (this.j == 8) {
                    bitmapDrawable = (BitmapDrawable) c.a(this.g.b, this.k);
                    if (bitmapDrawable != null) {
                        if (this.g.a == null) {
                            return bitmapDrawable;
                        }
                        this.g.a.a(this.k + this.j, bitmapDrawable, this.j);
                        return bitmapDrawable;
                    }
                } else if (this.j == 9) {
                    bitmapDrawable = (BitmapDrawable) c.b(this.g.b, this.k);
                    if (bitmapDrawable != null) {
                        if (this.g.a == null) {
                            return bitmapDrawable;
                        }
                        this.g.a.a(this.k + this.j, bitmapDrawable, this.j);
                        return bitmapDrawable;
                    }
                } else if (this.j == 10) {
                    bitmapDrawable = (BitmapDrawable) c.c(this.g.b, this.k);
                    if (bitmapDrawable != null) {
                        if (this.g.a == null) {
                            return bitmapDrawable;
                        }
                        this.g.a.a(this.k + this.j, bitmapDrawable, this.j);
                        return bitmapDrawable;
                    }
                } else if (this.j == 11) {
                    bitmapDrawable = (BitmapDrawable) c.d(this.g.b, this.k);
                    if (bitmapDrawable != null) {
                        if (this.g.a == null) {
                            return bitmapDrawable;
                        }
                        this.g.a.a(this.k + this.j, bitmapDrawable, this.j);
                        return bitmapDrawable;
                    }
                } else if (this.j == 15) {
                    bitmapDrawable = (BitmapDrawable) c.e(this.g.b, this.k);
                    if (bitmapDrawable == null) {
                        bitmapDrawable = (BitmapDrawable) c.d(this.g.b, this.k);
                        if (bitmapDrawable == null) {
                            bitmapDrawable = (BitmapDrawable) c.b(this.g.b, this.k);
                            if (bitmapDrawable == null || this.g.a == null) {
                                return bitmapDrawable;
                            }
                            this.g.a.a(this.k + this.j, bitmapDrawable, this.j);
                            return bitmapDrawable;
                        } else if (this.g.a == null) {
                            return bitmapDrawable;
                        } else {
                            this.g.a.a(this.k + this.j, bitmapDrawable, this.j);
                            return bitmapDrawable;
                        }
                    } else if (this.g.a == null) {
                        return bitmapDrawable;
                    } else {
                        this.g.a.a(this.k + this.j, bitmapDrawable, this.j);
                        return bitmapDrawable;
                    }
                } else {
                    if (this.j > 10000) {
                        try {
                            bitmapDrawable = (BitmapDrawable) this.g.b.getResources().getDrawable(this.j);
                        } catch (OutOfMemoryError e16) {
                            bitmapDrawable = null;
                        }
                        if (bitmapDrawable != null) {
                            if (this.g.a == null) {
                                return bitmapDrawable;
                            }
                            this.g.a.a(this.k, bitmapDrawable, this.j);
                            return bitmapDrawable;
                        }
                    }
                    bitmapDrawable = null;
                }
                bitmapDrawable2 = bitmapDrawable;
                a = bitmap;
            } catch (Exception e17) {
                bitmapDrawable = null;
                bitmapDrawable2 = bitmapDrawable;
                a = bitmap;
                if (a != null) {
                    bitmap = a;
                } else {
                    if (this.j != 0) {
                    }
                    a = this.g.a(this.k, this.g.i, this.g.j, this.j);
                    if (fileInputStream3 != null) {
                        fileInputStream3.close();
                    }
                    bitmap = a;
                }
                if (bitmap != null) {
                    return bitmapDrawable2;
                }
                if (aa.b()) {
                }
                if (this.g.a != null) {
                    return bitmapDrawable;
                }
                if (this.j != 0) {
                }
                this.g.a.a(this.k, bitmapDrawable, this.j);
                return bitmapDrawable;
            }
        }
        if (a != null) {
            if (!(a != null || c() || d() == null || this.g.c)) {
                if (this.j != 0 || this.j == 13 || this.j == 30) {
                    a = this.g.a(this.k, this.g.i, this.g.j, this.j);
                } else if (this.j == 1) {
                    FileInputStream fileInputStream4 = new FileInputStream(new File(this.k));
                    try {
                        a = r.a(fileInputStream4.getFD(), this.g.i, this.g.j, this.g.a, this.j);
                        fileInputStream3 = fileInputStream4;
                    } catch (Exception e18) {
                        e = e18;
                        fileInputStream3 = fileInputStream4;
                        e.printStackTrace();
                        if (fileInputStream3 != null) {
                            fileInputStream3.close();
                        }
                        bitmap = a;
                        if (bitmap != null) {
                            return bitmapDrawable2;
                        }
                        if (aa.b()) {
                        }
                        if (this.g.a != null) {
                            return bitmapDrawable;
                        }
                        if (this.j != 0) {
                        }
                        this.g.a.a(this.k, bitmapDrawable, this.j);
                        return bitmapDrawable;
                    } catch (Throwable th8) {
                        th = th8;
                        fileInputStream3 = fileInputStream4;
                        if (fileInputStream3 != null) {
                            fileInputStream3.close();
                        }
                        throw th;
                    }
                }
                if (fileInputStream3 != null) {
                    fileInputStream3.close();
                }
            }
            bitmap = a;
        } else {
            bitmap = a;
        }
        if (bitmap != null) {
            return bitmapDrawable2;
        }
        if (aa.b()) {
        }
        if (this.g.a != null) {
            return bitmapDrawable;
        }
        if (this.j != 0 || this.j == 1 || this.j == 4 || this.j == 7 || this.j == 13 || this.j > 10000) {
            this.g.a.a(this.k, bitmapDrawable, this.j);
            return bitmapDrawable;
        } else if (this.j != 30) {
            return bitmapDrawable;
        } else {
            this.g.a.a(this.k + this.j, bitmapDrawable, this.j);
            return bitmapDrawable;
        }
    }

    protected void a(BitmapDrawable bitmapDrawable) {
        if (c() || this.g.c) {
            Drawable drawable = null;
        }
        RecyclingImageView d = d();
        if (d != null) {
            if (drawable != null) {
                d.setScaleType(this.f);
                d.setisload(true);
                d.setLoadFail(false);
                this.g.a(d, drawable, 1);
                if (d.getiImageResult() != null) {
                    d.getiImageResult().a(drawable);
                }
            } else {
                if (d.getiImageResult() != null) {
                    d.getiImageResult().a();
                }
                d.setLoadFail(true);
            }
            d.setisloading(false);
        }
    }

    protected void b(BitmapDrawable bitmapDrawable) {
        super.b((Object) bitmapDrawable);
        synchronized (this.g.d) {
            this.g.d.notifyAll();
        }
    }
}
