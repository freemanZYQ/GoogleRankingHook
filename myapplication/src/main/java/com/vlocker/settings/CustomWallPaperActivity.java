package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.ay;
import com.vlocker.m.ba;
import com.vlocker.m.g;
import com.vlocker.m.h;
import com.vlocker.m.l;
import com.vlocker.theme.f.e;
import com.vlocker.ui.view.ImageViewTouch;
import com.vlocker.ui.view.MaskImageView;
import com.vlocker.ui.view.MaskTextView;
import com.vlocker.ui.view.ao;
import com.vlocker.ui.view.ap;
import com.vlocker.ui.widget.b.c;
import com.vlocker.ui.widget.c.d;
import com.vlocker.weather.e.j;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CustomWallPaperActivity extends BaseBinderActivity implements OnClickListener {
    ImageViewTouch a;
    private TextView b;
    private TextView c;
    private String d;
    private View e;
    private View f;
    private View g;
    private Bitmap h;
    private v i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private MaskImageView m;
    private MaskTextView n;
    private TextView o;
    private ImageView p;
    private ap q;
    private RelativeLayout r;
    private a s;
    private Handler t = new Handler();
    private Runnable u = new q(this);
    private boolean v = true;
    private Runnable w = new r(this);
    private ao x;

    private static int a(Options options, int i, int i2) {
        int b = b(options, i, i2);
        if (b > 8) {
            return ((b + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < b) {
            i3 <<= 1;
        }
        return i3;
    }

    public static int a(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
                case 3:
                    return 180;
                case 6:
                    return 90;
                case 8:
                    return 270;
                default:
                    return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap a(int i, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        try {
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Error e) {
        }
        return bitmap;
    }

    public static void a(Activity activity, String str, String str2, int i) {
        Intent intent = new Intent(activity, CustomWallPaperActivity.class);
        intent.setFlags(67141632);
        intent.putExtra("image_file_path", str);
        intent.putExtra("image_output_path", str2);
        activity.startActivityForResult(intent, i);
    }

    private void a(View view) {
        view.animate().cancel();
        view.animate().translationY(0.0f).alpha(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(200).start();
    }

    private void a(View view, boolean z) {
        view.animate().cancel();
        float measuredHeight = (float) view.getMeasuredHeight();
        if (z) {
            measuredHeight = -measuredHeight;
        }
        view.animate().translationY(-measuredHeight).alpha(0.2f).setInterpolator(new DecelerateInterpolator()).setDuration(200).start();
    }

    private boolean a(String str, Bitmap bitmap) {
        Throwable th;
        if (bitmap != null) {
            File file = new File(str);
            BufferedOutputStream bufferedOutputStream = null;
            BufferedOutputStream bufferedOutputStream2;
            try {
                file.createNewFile();
                bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    bitmap.compress(CompressFormat.JPEG, 100, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    bufferedOutputStream2.close();
                    if (bufferedOutputStream2 == null) {
                        return true;
                    }
                    try {
                        bufferedOutputStream2.close();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                } catch (Exception e2) {
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                return false;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedOutputStream2 = null;
                th = th4;
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                throw th;
            }
        }
        return false;
    }

    private static int b(Options options, int i, int i2) {
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        int min = i == -1 ? 128 : (int) Math.min(Math.floor(d / ((double) i)), Math.floor(d2 / ((double) i)));
        return min < ceil ? ceil : (i2 == -1 && i == -1) ? 1 : i != -1 ? min : ceil;
    }

    static Options c() {
        Options options = new Options();
        options.inScaled = false;
        options.inPreferredConfig = Config.ARGB_8888;
        options.inDither = false;
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        return options;
    }

    private void c(String str) {
        try {
            Matrix matrix = new Matrix();
            this.h = b(str);
            if (this.h == null || this.h.isRecycled()) {
                this.h = null;
                b();
                return;
            }
            this.a.a(this.h, matrix, -1.0f, -1.0f);
        } catch (Exception e) {
            this.h = null;
            b();
        }
    }

    private void d() {
        this.r = (RelativeLayout) findViewById(R.id.cover_root);
        this.n = (MaskTextView) findViewById(R.id.slide_text);
        this.m = (MaskImageView) findViewById(R.id.slide_press);
        this.l = (ImageView) findViewById(R.id.slide_bg);
        this.k = (ImageView) findViewById(R.id.tool_box_img);
        this.j = (ImageView) findViewById(R.id.camera_icon);
        this.a = (ImageViewTouch) findViewById(R.id.wallpaper_bg);
        this.a.setVisibility(0);
        this.a.setSingleTapListener(new n(this));
        this.b = (TextView) findViewById(R.id.date_textview);
        this.c = (TextView) findViewById(R.id.time_textview);
        this.c.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/time.ttf"));
        this.b.getViewTreeObserver().addOnPreDrawListener(new o(this));
        e();
        f();
        this.a.setScrollListener(new p(this));
    }

    private void d(String str) {
        if (this.i != null) {
            this.i.cancel(true);
        }
        this.i = new v(this, new s(this), str, i());
        this.i.execute(new Void[0]);
    }

    private void e() {
        this.g = View.inflate(this, R.layout.l_custom_wallpaper_title, null);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = 0;
        this.r.addView(this.g, layoutParams);
        this.e = findViewById(R.id.titleLayout);
        findViewById(R.id.btn_back_main).setOnClickListener(this);
        findViewById(R.id.sure).setOnClickListener(this);
    }

    private void f() {
        this.f = View.inflate(this, R.layout.l_custom_wallpaper_tips, null);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(12, -1);
        layoutParams.leftMargin = l.a(50.0f);
        layoutParams.rightMargin = l.a(50.0f);
        layoutParams.bottomMargin = l.a(10.0f);
        this.r.addView(this.f, layoutParams);
    }

    private void g() {
        if (this.v) {
            a(this.e, false);
            a(this.f, true);
            this.v = false;
        }
    }

    private void h() {
        if (!this.v) {
            this.v = true;
            a(this.e);
            a(this.f);
        }
    }

    private Bitmap i() {
        Bitmap createBitmap = Bitmap.createBitmap(this.a.getMeasuredWidth(), this.a.getMeasuredHeight(), Config.ARGB_8888);
        this.a.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private void j() {
        try {
            if (this.x != null) {
                if (this.x.isShowing()) {
                    this.x.dismiss();
                }
                this.x = null;
            }
            this.x = new ao(this, R.style.aiVlockerFeedbackDialog);
            this.x.setCanceledOnTouchOutside(true);
            this.x.a(R.layout.l_weather_dialog);
            this.x.e.setText(R.string.dialog_wallpaper_crop_exit_abort);
            this.x.a.setText(R.string.dialog_wallpaper_crop_exit_msg);
            this.x.d.setText(R.string.dialog_wallpaper_crop_exit_save);
            this.x.d.setOnClickListener(new t(this));
            this.x.e.setOnClickListener(new u(this));
        } catch (Exception e) {
            if (this.x != null && this.x.isShowing()) {
                this.x.dismiss();
            }
        }
    }

    private void k() {
        if (com.vlocker.locker.b.ap.a() != null && com.vlocker.locker.b.ap.a().u != null && this.s.p()) {
            this.q = com.vlocker.locker.b.ap.a((Context) this).d();
            com.vlocker.locker.b.ap.a((Context) this).a(this.r, this.q);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            this.p.setVisibility(8);
            this.o.setVisibility(8);
            l();
            m();
        }
    }

    private void l() {
        if (com.vlocker.locker.b.ap.a().u == null) {
            return;
        }
        if (com.vlocker.locker.b.ap.a().u.i != null) {
            Bitmap a = c.a((Context) this, com.vlocker.locker.b.ap.a().u.i, 320);
            if (a != null) {
                this.m.setVisibility(0);
                this.m.setBitmap(a);
                this.n.setVisibility(8);
                if (com.vlocker.locker.b.ap.a().u.u != null) {
                    this.l.setVisibility(0);
                    this.l.setImageBitmap(c.a((Context) this, com.vlocker.locker.b.ap.a().u.u, 320));
                    return;
                }
                return;
            }
            this.m.setVisibility(8);
            this.n.setVisibility(4);
        } else if (com.vlocker.locker.b.ap.a().u.A != null) {
            this.n.setVisibility(0);
            this.n.setText(com.vlocker.locker.b.ap.a().u.A);
            this.n.setCompoundDrawables(null, null, null, null);
            if (com.vlocker.locker.b.ap.a().u.J) {
                float a2;
                if (com.vlocker.locker.b.ap.a().u.E != -1) {
                    this.n.setTextColor(com.vlocker.locker.b.ap.a().u.E);
                }
                if (com.vlocker.locker.b.ap.a().u.B != null) {
                    Typeface a3 = ba.a(this, com.vlocker.locker.b.ap.a().u.B, true);
                    if (a3 != null) {
                        this.n.setTypeface(a3);
                    }
                }
                if (com.vlocker.locker.b.ap.a().u.L != null) {
                    a2 = c.a(this, com.vlocker.locker.b.ap.a().u.L);
                    if (a2 != 0.0f) {
                        this.n.setTextSize(a2);
                    }
                }
                if (com.vlocker.locker.b.ap.a().u.x != 24) {
                    a2 = ((float) com.vlocker.locker.b.ap.a().u.x) * d.a;
                    if (a2 != 0.0f) {
                        this.n.setTextSize((float) l.c(a2));
                    }
                }
            }
        }
    }

    private void m() {
        if (com.vlocker.locker.b.ap.a() != null && com.vlocker.locker.b.ap.a().v != null) {
            if (com.vlocker.locker.b.ap.a().v.a != null) {
                this.k.setImageBitmap(c.a((Context) this, com.vlocker.locker.b.ap.a().v.a, 320));
            }
            if (com.vlocker.locker.b.ap.a().v.b != null) {
                this.j.setImageBitmap(c.a((Context) this, com.vlocker.locker.b.ap.a().v.b, 320));
            }
        }
    }

    public Bitmap a(String str, int i) {
        Bitmap bitmap = null;
        Options c = c();
        c.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, c);
        c.inSampleSize = a(c, -1, i);
        c.inJustDecodeBounds = false;
        try {
            int a = a(str);
            bitmap = BitmapFactory.decodeFile(str, c);
            if (a == 0) {
                return bitmap;
            }
            try {
                Bitmap a2 = a(a, bitmap);
                bitmap.recycle();
                return a2;
            } catch (Exception e) {
                return bitmap;
            }
        } catch (Exception e2) {
            return bitmap;
        }
    }

    public void a() {
        int j = this.s.j();
        float k = ((float) this.s.k()) / 255.0f;
        if (this.b != null) {
            this.b.setText(ay.b((Context) this).toUpperCase());
            this.b.setTextColor(j);
            this.b.setAlpha(k);
        }
        if (this.c != null) {
            this.c.setText(ay.a((Context) this));
            this.c.setTextColor(j);
            this.c.setAlpha(k);
        }
        this.o = (TextView) findViewById(R.id.curr_temp_textview);
        this.p = (ImageView) findViewById(R.id.weather_icon);
        this.p.setAlpha(k);
        this.o.setAlpha(k);
        String F = this.s.F("");
        if (!TextUtils.isEmpty(F)) {
            int L = this.s.L(0);
            if (L == 0) {
                L = j.a(0, 0, this);
                this.s.M(L);
            }
            this.o.setText(j.a(F, false));
            Drawable a = j != -1 ? g.a(new BitmapDrawable(BitmapFactory.decodeResource(getResources(), L)), a.a(e.a).j()) : new BitmapDrawable(BitmapFactory.decodeResource(getResources(), L));
            this.o.setTextColor(j);
            this.p.setBackgroundDrawable(a);
            this.o.setVisibility(0);
            this.p.setVisibility(0);
        }
    }

    public Bitmap b(String str) {
        try {
            int a = a(str);
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            if (a == 0) {
                return decodeFile;
            }
            Bitmap a2 = a(a, decodeFile);
            decodeFile.recycle();
            return a2.isRecycled() ? a(str, this.a.getMeasuredHeight() * this.a.getMeasuredWidth()) : a2;
        } catch (Error e) {
            return a(str, this.a.getMeasuredHeight() * this.a.getMeasuredWidth());
        }
    }

    public void b() {
        if (this.h != null) {
            this.h.recycle();
            this.h = null;
        }
        finish();
    }

    public void onBackPressed() {
        if (this.i == null) {
            j();
        }
    }

    public void onClick(View view) {
        if (this.i == null) {
            switch (view.getId()) {
                case R.id.btn_back_main:
                    j();
                    return;
                case R.id.sure:
                    p.a((Context) this, "Vlocker_Done_Custom_Wallpaper_PPC_TF", new String[0]);
                    d(getIntent().getStringExtra("image_output_path"));
                    return;
                default:
                    return;
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.s = a.a((Context) this);
        if (this.s.ai() != 0) {
            getWindow().setFlags(IXAdIOUtils.BUFFER_SIZE, IXAdIOUtils.BUFFER_SIZE);
        }
        if (VERSION.SDK_INT >= 19) {
            Window window = getWindow();
            window.setFlags(67108864, 67108864);
            window.setFlags(134217728, 134217728);
        }
        this.d = getIntent().getStringExtra("image_file_path");
        setContentView(R.layout.l_float_cover_wallpaper);
        try {
            if (!(this.d == null || new File(this.d).exists())) {
                b();
                return;
            }
        } catch (Exception e) {
        }
        setResult(0);
        d();
        a();
        k();
        if (VERSION.SDK_INT >= 19) {
            int d = h.d(this);
            if (this.s.ai() == 0) {
                this.g.setPadding(0, d, 0, 0);
            } else {
                this.g.setPadding(0, 0, 0, 0);
            }
        }
    }

    protected void onDestroy() {
        if (this.q != null) {
            this.r.removeView(this.q);
            this.q = null;
        }
        super.onDestroy();
    }
}
