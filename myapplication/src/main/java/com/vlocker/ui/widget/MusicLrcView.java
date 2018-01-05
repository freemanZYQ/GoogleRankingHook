package com.vlocker.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.vlocker.j.a;
import com.vlocker.j.a.f;
import com.vlocker.j.n;
import com.vlocker.locker.R;
import com.vlocker.locker.b.p;
import com.vlocker.m.l;
import com.vlocker.msg.aq;
import com.vlocker.msg.w;
import com.vlocker.ui.view.ArtworkView;
import com.vlocker.ui.view.NextView;
import com.vlocker.ui.view.PlayView;
import java.util.ArrayList;
import java.util.List;

public class MusicLrcView extends RelativeLayout implements OnClickListener {
    public static boolean a = false;
    public static boolean b;
    private long A = 0;
    private OnTouchListener B = new j(this);
    private BaseAdapter C = new k(this);
    private boolean D;
    aq c = new w(getContext(), new g(this));
    private int d = 0;
    private long e = 0;
    private long f = 0;
    private long g = 0;
    private long h = 0;
    private List i = new ArrayList();
    private List j = new ArrayList();
    private m k = new m(this);
    private ListView l;
    private ImageView m;
    private AlwaysMarqueeTextView n;
    private AlwaysMarqueeTextView o;
    private NextView p;
    private PlayView q;
    private NextView r;
    private WakeLock s;
    private ArtworkView t;
    private Bitmap u;
    private View v;
    private p w;
    private boolean x;
    private Handler y = new f(this);
    private long z;

    public MusicLrcView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void e() {
        this.s = ((PowerManager) getContext().getSystemService("power")).newWakeLock(10, "Lrc_Light");
    }

    private void setListViewVisibility(boolean z) {
        this.y.post(new h(this, z));
    }

    public void a() {
        this.j = new ArrayList();
        this.y.sendEmptyMessage(1);
        setListViewVisibility(false);
    }

    public void a(long j) {
        if (this.g != j) {
            this.g = j;
            this.y.removeCallbacks(this.k);
            this.y.post(this.k);
            if (this.t != null) {
                this.t.a();
            }
        }
    }

    public void a(p pVar) {
        this.w = pVar;
        this.l = (ListView) findViewById(R.id.lv_lrc);
        this.l.setOnTouchListener(this.B);
        this.n = (AlwaysMarqueeTextView) findViewById(R.id.tv_music_lrc_name);
        this.o = (AlwaysMarqueeTextView) findViewById(R.id.tv_music_lrc_author);
        this.p = (NextView) findViewById(R.id.music_lrc_prev);
        this.q = (PlayView) findViewById(R.id.music_lrc_play);
        this.r = (NextView) findViewById(R.id.music_lrc_next);
        this.t = (ArtworkView) findViewById(R.id.artview_music_lrc);
        this.m = (ImageView) findViewById(R.id.iv_music_lrc_artwork);
        this.t.a(this.m);
        findViewById(R.id.tv_music_forbidern).setOnClickListener(this);
        findViewById(R.id.tv_music_delete).setOnClickListener(this);
        this.v = findViewById(R.id.music_little_operation_bg);
        this.r.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.p.setOnClickListener(this);
        e();
        try {
            this.u = BitmapFactory.decodeResource(getResources(), R.drawable.l_music_art_lrc_default);
        } catch (OutOfMemoryError e) {
        }
    }

    public void a(List list) {
        if (list != null && list.size() > 0) {
            this.x = true;
            this.j = list;
            this.y.sendEmptyMessage(1);
            setListViewVisibility(true);
            this.y.post(new i(this));
        }
    }

    public void a(boolean z) {
        if (!z) {
            this.y.removeCallbacks(this.k);
        } else if (this.x && this.i != null && this.i.size() > 0 && a.a) {
            this.l.setSelectionFromTop(getIndex(), 0);
            this.y.removeCallbacks(this.k);
            this.y.postDelayed(this.k, 500);
        }
    }

    public void a(boolean z, Bitmap bitmap) {
        ImageView imageView = this.m;
        if (z) {
            bitmap = this.u;
        }
        imageView.setImageBitmap(bitmap);
    }

    public boolean a(n nVar, long j) {
        if (System.currentTimeMillis() - this.z < 300) {
            return false;
        }
        this.x = false;
        this.d = 0;
        this.y.removeCallbacks(this.k);
        this.z = System.currentTimeMillis();
        this.n.setText(nVar.d);
        this.o.setText(nVar.c);
        this.g = 0;
        this.f = j;
        setListViewVisibility(false);
        return true;
    }

    public void b() {
        if (this.x && this.i != null && this.l != null && this.y != null && this.i.size() > 0) {
            this.l.setSelectionFromTop(getIndex(), 0);
            this.y.removeCallbacks(this.k);
            this.y.post(this.k);
        }
    }

    public void b(boolean z) {
        this.D = z;
        findViewById(R.id.music_lrc_bg).setBackgroundDrawable(z ? getContext().getResources().getDrawable(R.drawable.l_msg_bg_blur) : getContext().getResources().getDrawable(R.drawable.l_msg_bg));
        this.r.setColor(z ? getResources().getColor(R.color.msg_title_light) : getResources().getColor(R.color.msg_title_dark));
        this.q.setColor(z ? getResources().getColor(R.color.msg_title_light) : getResources().getColor(R.color.msg_title_dark));
        this.p.setColor(z ? getResources().getColor(R.color.msg_title_light) : getResources().getColor(R.color.msg_title_dark));
        this.n.setTextColor(z ? getResources().getColor(R.color.msg_title_light) : getResources().getColor(R.color.msg_title_dark));
        this.o.setTextColor(z ? getResources().getColor(R.color.msg_content_light) : getResources().getColor(R.color.msg_content_dark));
    }

    public void c() {
        if (this.x && this.i != null && this.l != null && this.i.size() > 0 && a.a) {
            this.l.setSelectionFromTop(getIndex(), 0);
        }
    }

    public void c(boolean z) {
        if (!(this.q == null || this.q.a())) {
            this.q.a(z);
        }
        if (this.t == null) {
            return;
        }
        if (z) {
            this.t.b();
        } else {
            this.t.a();
        }
    }

    public void d() {
        if (this.t != null) {
            this.t.b();
        }
        this.y.removeCallbacks(this.k);
    }

    public int getIndex() {
        this.e = (System.currentTimeMillis() - this.f) - this.g;
        if (this.i != null) {
            int i = this.d;
            while (i < this.i.size()) {
                if (i < this.i.size() - 1) {
                    if (i > 0 && this.e < ((f) this.i.get(i)).a()) {
                        return i + 1;
                    }
                    if (this.e >= ((f) this.i.get(i)).a() && this.e <= ((f) this.i.get(i + 1)).a()) {
                        this.d = i;
                        return i;
                    } else if (this.e < ((f) this.i.get(0)).a() && i == 0) {
                        this.d = 0;
                        return 0;
                    }
                } else if (i == this.i.size() - 1) {
                    this.d = i;
                    return i;
                }
                i++;
            }
        }
        return 0;
    }

    public long getSongLong() {
        return (this.i == null || this.i.size() <= 0) ? 0 : ((f) this.i.get(this.i.size() - 1)).a();
    }

    public void onClick(View view) {
        boolean z = true;
        switch (view.getId()) {
            case R.id.music_lrc_prev:
                if (!this.p.b()) {
                    com.vlocker.b.p.a(getContext(), "Vlocker_Doing_MusicLrc_PPC_TF", "music_action_2", "Previous");
                    this.y.removeCallbacks(this.k);
                    a.a().e();
                    a.a = true;
                    this.p.a();
                    this.q.a(false);
                    return;
                }
                return;
            case R.id.music_lrc_play:
                if (!this.q.a()) {
                    this.y.removeCallbacks(this.k);
                    com.vlocker.b.p.a(getContext(), "Vlocker_Doing_MusicLrc_PPC_TF", "music_action_2", "Pause");
                    if (a.a) {
                        a.a().c();
                    } else {
                        a.a().b();
                    }
                    if (a.a) {
                        z = false;
                    }
                    a.a = z;
                    a.a().j();
                    return;
                }
                return;
            case R.id.music_lrc_next:
                if (!this.r.b()) {
                    com.vlocker.b.p.a(getContext(), "Vlocker_Doing_MusicLrc_PPC_TF", "music_action_2", "Next");
                    this.y.removeCallbacks(this.k);
                    a.a().d();
                    a.a = true;
                    this.r.a();
                    this.q.a(false);
                    return;
                }
                return;
            case R.id.tv_music_forbidern:
                a = false;
                a.a().b = true;
                a.a().h();
                com.vlocker.c.a.a(getContext()).B(false);
                return;
            case R.id.tv_music_delete:
                a.a().b = true;
                a.a().h();
                return;
            default:
                return;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return ((w) this.c).a(this, motionEvent);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (i > 0) {
            this.v.setAlpha(i > l.a(120.5f) ? 1.0f : ((float) i) / ((float) l.a(120.5f)));
        } else {
            this.v.setAlpha(0.0f);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ((w) this.c).a((View) this, motionEvent, new l(this));
        if (motionEvent.getAction() == 0) {
            b = true;
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            b = false;
        }
        return true;
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            c();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            c(!a.a);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            c();
        }
    }

    public void setLrcWakeLock(boolean z) {
        if (this.s == null) {
            return;
        }
        if (com.vlocker.c.a.a(getContext()).bj() && z && !this.s.isHeld()) {
            this.s.acquire();
        } else if (this.s.isHeld()) {
            this.s.setReferenceCounted(false);
            this.s.release();
        }
    }
}
