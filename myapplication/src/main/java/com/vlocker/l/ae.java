package com.vlocker.l;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.theme.f.b;

class ae implements OnClickListener, OnLongClickListener {
    final /* synthetic */ j a;
    private int b;
    private int c;
    private ImageView d;
    private SeekBar e;
    private a f;
    private Runnable g;
    private ClipDrawable h;
    private View i;

    public ae(j jVar, ImageButton imageButton, ImageView imageView, View view, View view2, c cVar, int i, int i2) {
        this.a = jVar;
        this.d = imageButton;
        this.f = cVar;
        this.b = i;
        this.c = i2;
        this.e = (SeekBar) view2;
        this.i = view;
        this.h = (ClipDrawable) imageView.getDrawable();
        if (b.B() && this.e != null) {
            LayoutParams layoutParams = this.e.getLayoutParams();
            layoutParams.width = l.a(245.0f);
            this.e.setLayoutParams(layoutParams);
        }
        this.e.setMax(229);
        this.e.setOnSeekBarChangeListener(new af(this, jVar, cVar));
        imageButton.setOnClickListener(this);
        imageButton.setOnLongClickListener(this);
        this.i.setOnClickListener(this);
    }

    public ae(j jVar, ImageButton imageButton, a aVar, int i, int i2) {
        this.a = jVar;
        this.d = imageButton;
        this.f = aVar;
        this.b = i;
        this.c = i2;
        if (aVar instanceof c) {
            throw new IllegalArgumentException("BrightnessController is IllegalArgument");
        }
        if (!(aVar instanceof h) || VERSION.SDK_INT < 17) {
            imageButton.setOnClickListener(this);
        } else {
            imageButton.setOnClickListener(new ag(this, jVar));
        }
        imageButton.setOnLongClickListener(this);
    }

    private void a(int i, boolean z) {
        Context c;
        String str;
        String[] strArr;
        if (this.f instanceof an) {
            c = this.a.b;
            str = "Vlocker_Switch_Wifi_PPC_TF";
            strArr = new String[2];
            strArr[0] = "status";
            strArr[1] = i == 1 ? "Off" : "On";
            p.a(c, str, strArr);
        } else if (!(this.f instanceof c)) {
            if (this.f instanceof d) {
                c = this.a.b;
                str = "Vlocker_Switch_Network_PPC_TF";
                strArr = new String[2];
                strArr[0] = "status";
                strArr[1] = i == 1 ? "Off" : "On";
                p.a(c, str, strArr);
            } else if (this.f instanceof h) {
                c = this.a.b;
                str = "Vlocker_Switch_FlightMode_PPC_TF";
                strArr = new String[2];
                strArr[0] = "status";
                strArr[1] = i == 1 ? "Off" : "On";
                p.a(c, str, strArr);
            } else if (this.f instanceof al) {
                c = this.a.b;
                str = "Vlocker_Switch_Viberate_PPC_TF";
                strArr = new String[2];
                strArr[0] = "status";
                strArr[1] = i == 1 ? "Off" : "On";
                p.a(c, str, strArr);
            } else if (this.f instanceof am) {
                c = this.a.b;
                str = "Vlocker_Switch_Ringtone_PPC_TF";
                strArr = new String[2];
                strArr[0] = "status";
                strArr[1] = i == 1 ? "Off" : "On";
                p.a(c, str, strArr);
            }
        }
    }

    public void a() {
        int b = this.f.b();
        b bVar = b == 0 ? b.SWITCH_OFF : b == 1 ? b.SWITCH_ON : b == 2 ? b.SWITCH_VALUE : b.SWITCH_OFF;
        if (this.f instanceof c) {
            if (bVar == b.SWITCH_ON) {
                a(115);
            } else {
                a(((c) this.f).c());
            }
        }
        a(bVar);
    }

    public void a(int i) {
        if (this.e != null) {
            this.e.setProgress(i);
        }
        if (this.h == null) {
            return;
        }
        if (i >= 229) {
            this.h.setLevel(9000);
        } else {
            this.h.setLevel(i * 35);
        }
    }

    public void a(View view) {
        if (this.a.r != null) {
            this.a.r.a(new ah(this), this.a.b.getResources().getString(R.string.lk_number_password_ui_from_airplane_tip));
        }
        a(0, false);
    }

    public void a(b bVar) {
        if (b.SWITCH_ON == bVar) {
            this.d.setImageResource(this.c);
        } else if (b.SWITCH_OFF == bVar) {
            this.d.setImageResource(this.b);
        }
    }

    public void a(Runnable runnable) {
        this.g = runnable;
    }

    public void onClick(View view) {
        int b = this.f.b();
        b bVar = b.SWITCH_OFF;
        if (b == 1) {
            b bVar2 = b.SWITCH_OFF;
            if (this.f instanceof c) {
                p.a(this.a.b, "Vlocker_Switch_AutoBrightness_PPC_TF", "status", "Off");
                int c = ((c) this.f).c() + 26;
                this.a.r.a((float) c);
                a(c - 26);
                bVar = bVar2;
            } else {
                bVar = bVar2;
            }
        } else {
            bVar = b.SWITCH_ON;
            if (this.f instanceof c) {
                this.a.r.a(-1.0f);
                p.a(this.a.b, "Vlocker_Switch_AutoBrightness_PPC_TF", "status", "On");
                a(115);
            }
        }
        boolean a = this.f.a(bVar);
        a(b, true);
        if (a) {
            a(bVar);
            if (this.g != null) {
                this.g.run();
            }
        }
    }

    public boolean onLongClick(View view) {
        a(view);
        return false;
    }
}
