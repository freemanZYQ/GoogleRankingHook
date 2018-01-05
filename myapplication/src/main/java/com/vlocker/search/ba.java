package com.vlocker.search;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.locker.d.d;
import com.vlocker.m.au;
import com.vlocker.notification.msg.open.FlowWebViewActivity;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.imageloader.RecyclingImageView;
import java.util.Calendar;

public class ba extends p {
    public static final String[] c = new String[]{"Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"};
    public static final String[] d = new String[]{"白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座"};
    public static final String[] j = new String[]{"3.21-4.20", "4.21-5.20", "5.21-6.21", "6.22-7.22", "7.23-8.22", "8.23-9.22", "9.23-10.23", "10.24-11.22", "11.23-12.21", "12.22-1.19", "1.20-2.18", "2.19-3.20"};
    protected Context a;
    bj b;
    int[] k = new int[]{R.id.love_icon1, R.id.love_icon2, R.id.love_icon3, R.id.love_icon4, R.id.love_icon5};
    int[] l = new int[]{R.id.all_icon1, R.id.all_icon2, R.id.all_icon3, R.id.all_icon4, R.id.all_icon5};
    private LinearLayout m;

    public ba(BaiduSearchActivity baiduSearchActivity, at atVar) {
        super(baiduSearchActivity, atVar);
        this.a = baiduSearchActivity;
    }

    private int a(int i) {
        return i == 0 ? 0 : i <= 20 ? 1 : i <= 40 ? 2 : i <= 60 ? 3 : i <= 80 ? 4 : i <= 100 ? 5 : 0;
    }

    private void b() {
        if (this.b != null) {
            String str = this.b.d;
            String h = ap.h(this.a);
            if (h.equals("") || h.length() < 8) {
                h = "https://m.baidu.com/s?from=1001706a&word=";
            }
            h = h + str;
            Intent intent = new Intent(this.a, FlowWebViewActivity.class);
            intent.putExtra("url", h);
            intent.putExtra("title", "");
            intent.putExtra("tag", "search");
            this.a.startActivity(intent);
            CharSequence d = ap.d(this.a);
            if (TextUtils.isEmpty(d)) {
                d = "default";
            }
            p.a(this.a, "Vlock_Done_Search_PPC_TF", "word", str, "search_engine", d, "from", "constellation");
        }
    }

    private void d() {
        au auVar = new au(this.a, new bf(this), true);
    }

    private int e() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(2) + 1;
        int i2 = instance.get(5);
        switch (i) {
            case 1:
                return i2 >= 20 ? 10 : 9;
            case 2:
                return i2 >= 19 ? 11 : 10;
            case 3:
                return i2 < 21 ? 11 : 0;
            case 4:
                return i2 >= 21 ? 1 : 0;
            case 5:
                return i2 >= 21 ? 2 : 1;
            case 6:
                return i2 >= 22 ? 3 : 2;
            case 7:
                return i2 >= 23 ? 4 : 3;
            case 8:
                return i2 >= 23 ? 5 : 4;
            case 9:
                return i2 >= 23 ? 6 : 5;
            case 10:
                return i2 >= 24 ? 7 : 6;
            case 11:
                return i2 >= 23 ? 8 : 7;
            case 12:
                return i2 >= 22 ? 9 : 8;
            default:
                return 0;
        }
    }

    private void f() {
        int i = 0;
        if (this.b != null) {
            int i2;
            this.m.setVisibility(0);
            ((TextView) this.m.findViewById(R.id.starry_title)).setText(this.b.d);
            int i3 = 0;
            while (i3 < j.length) {
                if (TextUtils.equals(this.b.d, d[i3]) || TextUtils.equals(this.b.d, c[i3])) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            i2 = 0;
            ((TextView) this.m.findViewById(R.id.starry_date)).setText(j[i2]);
            int a = a(this.b.b);
            int a2 = a(this.b.a);
            ((RecyclingImageView) this.m.findViewById(R.id.starry_icon)).a(this.b.c, 2, 0);
            ((RecyclingImageView) this.m.findViewById(R.id.starry_icon)).setIsCircle(true);
            for (i2 = 0; i2 < 5; i2++) {
                if (i2 < a) {
                    ((ImageView) this.m.findViewById(this.k[i2])).setBackgroundResource(R.drawable.l_starry_r_star);
                } else {
                    ((ImageView) this.m.findViewById(this.k[i2])).setBackgroundResource(R.drawable.l_starry_w_star);
                }
            }
            while (i < 5) {
                if (i < a2) {
                    ((ImageView) this.m.findViewById(this.l[i])).setBackgroundResource(R.drawable.l_starry_b_star);
                } else {
                    ((ImageView) this.m.findViewById(this.l[i])).setBackgroundResource(R.drawable.l_starry_w_star);
                }
                i++;
            }
        }
    }

    protected View a() {
        this.m = (LinearLayout) j.b(this.e, (int) R.layout.l_starry_searchd_card);
        this.m.findViewById(R.id.starry_icon).setOnClickListener(new bb(this));
        this.m.findViewById(R.id.starry_title_and_date_rl).setOnClickListener(new bc(this));
        this.m.setOnClickListener(new bd(this));
        this.m.findViewById(R.id.t_starry_bt).setOnClickListener(new be(this));
        this.m.setVisibility(8);
        return this.m;
    }

    protected void a(ac acVar) {
        if (acVar != null && this.b == null) {
            String cS = a.a(this.a).cS();
            if (TextUtils.isEmpty(cS)) {
                a(c[e()]);
                return;
            }
            a(cS);
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && j.i(MoSecurityApplication.a().getApplicationContext())) {
            new d().a((j.e() + str + j.n(MoSecurityApplication.a().getApplicationContext())).trim().replaceAll(" ", ""), new bg(this));
        }
    }
}
