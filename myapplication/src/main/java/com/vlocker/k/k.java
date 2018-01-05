package com.vlocker.k;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.bb;
import com.vlocker.m.h;
import com.vlocker.m.l;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.share.ShareActivity;
import com.vlocker.theme.f.b;
import com.vlocker.ui.cover.f;
import java.util.List;
import org.json.JSONObject;

public class k implements OnClickListener {
    private static k a;
    private View b = View.inflate(this.f, R.layout.l_redpocket_float_share, null);
    private LayoutParams c;
    private volatile boolean d;
    private WindowManager e = ((WindowManager) this.f.getSystemService("window"));
    private Context f = MoSecurityApplication.a();
    private boolean g;
    private int h;
    private String i;
    private TextView j = ((TextView) this.b.findViewById(R.id.tv_content));
    private ImageView k = ((ImageView) this.b.findViewById(R.id.iv_title));
    private ImageButton l = ((ImageButton) this.b.findViewById(R.id.btn_close));
    private Button m = ((Button) this.b.findViewById(R.id.btn_share));
    private Handler n;
    private long o;
    private String p;
    private String q;
    private String r;
    private String s;
    private ActivityManager t;
    private Runnable u = new n(this);

    private k() {
        this.j.setShadowLayer(10.0f, 10.0f, 10.0f, this.f.getResources().getColor(R.color.l_redpacket_share_txt_shadow));
        this.c = new LayoutParams();
        this.c.systemUiVisibility = 1;
        if (b.d()) {
            this.c.type = 2005;
            this.c.y = h.d(this.f);
        } else {
            this.c.type = 2010;
        }
        this.c.width = -1;
        this.c.height = -2;
        this.c.format = 1;
        this.c.gravity = 48;
        this.c.flags = 1800;
        this.b.setFocusableInTouchMode(true);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n = new Handler();
        this.t = (ActivityManager) this.f.getSystemService("activity");
    }

    public static k a() {
        if (a == null) {
            a = new k();
        }
        return a;
    }

    private String a(long j) {
        return j <= 3000 ? "我已成为绝世高手" : j <= 6000 ? "我已练成闪电快手" : "我已练成葵花点穴手";
    }

    private void a(String str, TextView textView) {
        CharSequence spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(l.b(14.0f)), 0, str.indexOf("速") + 1, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(l.b(24.0f)), str.indexOf("速") + 1, str.indexOf("秒") + 1, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(l.b(14.0f)), str.indexOf("%") + 1, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, str.indexOf("速") + 1, 33);
        spannableString.setSpan(new ForegroundColorSpan(-271263), str.indexOf("速") + 1, str.indexOf("秒") + 1, 33);
        spannableString.setSpan(new ForegroundColorSpan(-1), str.indexOf("%") + 1, str.length(), 33);
        textView.setText(spannableString);
    }

    private int b(long j) {
        return j <= 3000 ? R.drawable.l_redpacket_share_title_1 : j <= 6000 ? R.drawable.l_redpacket_share_title_2 : R.drawable.l_redpacket_share_title_3;
    }

    private int c(long j) {
        if (j > 3000) {
            return j <= 6000 ? (int) ((10.0f * (((float) (j - 3000)) / 3000.0f)) + 6.0f) : (int) ((15.0f * (((float) (j - 6000)) / 2500.0f)) + 16.0f);
        } else {
            float f = (((float) j) / 1000.0f) - 2.0f;
            return f > 0.0f ? ((int) (5.0f * f)) < 5 ? ((int) (5.0f * f)) + 1 : 5 : 1;
        }
    }

    private String d(long j) {
        int i = 5;
        if (j > 3000) {
            return j <= 6000 ? "手速" + (((float) (j / 10)) / 100.0f) + "秒！已进入全国前" + ((int) ((10.0f * (((float) (j - 3000)) / 3000.0f)) + 6.0f)) + "%，\n红包抢到手软了吧？" : "手速" + (((float) (j / 10)) / 100.0f) + "秒！已进入全国前" + ((int) ((15.0f * (((float) (j - 6000)) / 2500.0f)) + 16.0f)) + "%，\n果然高手在民间!";
        } else {
            float f = (((float) j) / 1000.0f) - 2.0f;
            if (f <= 0.0f) {
                return "手速" + (((float) (j / 10)) / 100.0f) + "秒！已进入全国前" + 1 + "%，\n不服来战！";
            }
            StringBuilder append = new StringBuilder().append("手速").append(((float) (j / 10)) / 100.0f).append("秒！已进入全国前");
            if (((int) (5.0f * f)) < 5) {
                i = ((int) (5.0f * f)) + 1;
            }
            return append.append(i).append("%，\n不服来战！").toString();
        }
    }

    private void g() {
        Intent intent;
        if (f.e && this.g) {
            intent = new Intent("action_stop_check");
            intent.putExtra("from", "share");
            intent.putExtra("hasPwd", true);
            this.f.sendBroadcast(intent);
        } else if (this.g) {
            intent = new Intent("action_stop_check");
            intent.putExtra("from", "share");
            intent.putExtra("hasPwd", false);
            this.f.sendBroadcast(intent);
        } else {
            d();
        }
    }

    private void h() {
        try {
            JSONObject jSONObject = new JSONObject(a.a(this.f).bM()).getJSONObject("data").getJSONObject("packet_float");
            if (jSONObject != null) {
                this.p = jSONObject.getString("url") + "&time=" + (((float) (this.o / 10)) / 100.0f) + "&ratio=" + c(this.o);
                this.q = jSONObject.getString("title");
                this.r = jSONObject.getString("desc");
                if (TextUtils.isEmpty(this.r)) {
                    this.r = a(this.o) + "，不服来战！";
                }
                this.s = jSONObject.getString("preview");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(boolean z, long j) {
        this.o = j;
        h();
        if (!TextUtils.isEmpty(this.p) && j <= 8500 && !this.d && a.a(this.f).bJ() < 5) {
            p.a(this.f, "Vlocker_ShareShow_Hongbao_PPC_XXB", new String[0]);
            e.a().b();
            this.g = z;
            this.h = b(j);
            this.i = d(j);
            a(this.i, this.j);
            this.k.setImageResource(this.h);
            try {
                this.e.addView(this.b, this.c);
                this.d = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            com.vlocker.n.a.a().removeCallbacks(this.u);
            com.vlocker.n.a.a().postDelayed(this.u, 500);
        }
    }

    public void b() {
        if (this.d) {
            try {
                this.e.removeViewImmediate(this.b);
                this.d = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        this.n.postDelayed(new l(this), 500);
    }

    public void d() {
        Intent intent = new Intent(this.f, ShareActivity.class);
        intent.putExtra("title", this.q);
        intent.putExtra("content", this.r);
        intent.putExtra("url", this.p);
        intent.putExtra("bmp", this.s);
        intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
        intent.addFlags(268435456);
        this.f.startActivity(intent);
    }

    public boolean e() {
        return bb.b(this.f).toLowerCase().contains("com.tencent.mm.plugin.luckymoney.ui.luckymoneydetailui");
    }

    public boolean f() {
        if (VERSION.SDK_INT >= 20 && bb.a(this.f)) {
            return e();
        }
        try {
            List runningTasks = this.t.getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0) {
                return ((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName().toLowerCase().contains("com.tencent.mm.plugin.luckymoney.ui.luckymoneydetailui");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_close:
                com.vlocker.n.a.a().removeCallbacks(this.u);
                a.a(this.f).G(a.a(this.f).bJ() + 1);
                b();
                if (this.g) {
                    this.f.sendBroadcast(new Intent("action_stop_check"));
                    return;
                }
                return;
            case R.id.btn_share:
                com.vlocker.n.a.a().removeCallbacks(this.u);
                g();
                b();
                return;
            default:
                return;
        }
    }
}
