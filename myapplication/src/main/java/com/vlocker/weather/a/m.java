package com.vlocker.weather.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.f.e;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.weather.a;
import java.util.ArrayList;
import java.util.List;

public class m extends ag {
    int a;
    OnClickListener b = new n(this);
    List c = new ArrayList();
    private Context d;
    private View e;
    private a f;
    private RelativeLayout[] g = new RelativeLayout[4];
    private TextView[] h = new TextView[4];
    private RecyclingImageView[] i = new RecyclingImageView[4];

    public m(Context context, a aVar, View view) {
        this.d = context;
        this.f = aVar;
        this.e = LayoutInflater.from(this.d).inflate(R.layout.weather_netservice_detail, null);
        d();
        this.a = this.d.getResources().getDisplayMetrics().heightPixels;
    }

    private void a(View view, int i) {
        int size = this.c.size();
        if (size > 0 && i <= size) {
            a(view, (com.moxiu.b.a.a) this.c.get(i));
        }
    }

    private void d() {
        this.i[0] = (RecyclingImageView) this.e.findViewById(R.id.card_img1);
        this.i[1] = (RecyclingImageView) this.e.findViewById(R.id.card_img2);
        this.i[2] = (RecyclingImageView) this.e.findViewById(R.id.card_img3);
        this.i[3] = (RecyclingImageView) this.e.findViewById(R.id.card_img4);
        this.h[0] = (TextView) this.e.findViewById(R.id.card_name1);
        this.h[1] = (TextView) this.e.findViewById(R.id.card_name2);
        this.h[2] = (TextView) this.e.findViewById(R.id.card_name3);
        this.h[3] = (TextView) this.e.findViewById(R.id.card_name4);
        this.g[0] = (RelativeLayout) this.e.findViewById(R.id.net_service_card1);
        this.g[0].setOnClickListener(this.b);
        this.g[1] = (RelativeLayout) this.e.findViewById(R.id.net_service_card2);
        this.g[1].setOnClickListener(this.b);
        this.g[2] = (RelativeLayout) this.e.findViewById(R.id.net_service_card3);
        this.g[2].setOnClickListener(this.b);
        this.g[3] = (RelativeLayout) this.e.findViewById(R.id.net_service_card4);
        this.g[3].setOnClickListener(this.b);
        b();
    }

    private void e() {
        new com.b.b.a(this.d.getApplicationContext()).a(com.b.d.a.b(this.d, "vweather_net_service"), 4, new o(this)).a();
    }

    private void f() {
        for (RelativeLayout visibility : this.g) {
            visibility.setVisibility(4);
        }
    }

    private void g() {
        int size = this.c.size();
        if (size > 4) {
            size = 4;
        }
        for (int i = 0; i < size; i++) {
            ((com.moxiu.b.a.a) this.c.get(i)).b(this.g[i]);
        }
    }

    public View a() {
        return this.e;
    }

    public void a(View view, com.moxiu.b.a.a aVar) {
        if (Boolean.valueOf(j.i(this.d)).booleanValue()) {
            try {
                this.f.a(5, new p(this, view, aVar));
                return;
            } catch (Exception e) {
                return;
            }
        }
        e.a(this.d, (CharSequence) "网络貌似不给力哦~", 0);
    }

    public void a(boolean z) {
        if (this.c.size() > 0) {
            f();
            int size = this.c.size();
            if (size > 4) {
                size = 4;
            }
            for (int i = 0; i < size; i++) {
                com.moxiu.b.a.a aVar = (com.moxiu.b.a.a) this.c.get(i);
                this.g[i].setVisibility(0);
                this.i[i].a(aVar.d(), 2, 0);
                this.h[i].setText(aVar.h());
            }
            if (z) {
                c();
            }
        }
    }

    public void b() {
        if (j.i(MoSecurityApplication.a().getApplicationContext())) {
            this.e.setVisibility(8);
            e();
        }
    }

    public void b(View view, com.moxiu.b.a.a aVar) {
        if (aVar != null) {
            aVar.a(false);
            com.vlocker.b.a.a(this.d, aVar, view, "netService_weather", null, false, null);
        }
    }

    public void c() {
        try {
            if (this.e != null && this.e.getWidth() != 0 && this.e.getHeight() != 0) {
                int i = 0;
                if (this.f.a != null) {
                    i = this.f.a.getHeight();
                }
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                int[] iArr3 = new int[2];
                this.e.getLocationOnScreen(iArr3);
                if (iArr3[1] != 0) {
                    iArr[1] = iArr3[1];
                    iArr2[1] = (iArr3[1] + this.e.getHeight()) - i;
                    if ((iArr3[1] > 0 && iArr[1] - this.a < 0) || (iArr3[1] < i && iArr2[1] > 0)) {
                        g();
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
