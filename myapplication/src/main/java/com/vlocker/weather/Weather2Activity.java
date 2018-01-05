package com.vlocker.weather;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RatingBar;
import android.widget.TextView;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.vlocker.functionactivity.BaseFragmentActivity;
import com.vlocker.locker.BuildConfig;
import com.vlocker.locker.R;
import com.vlocker.m.bb;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.weather.bean.PromotionAppInfo;
import com.vlocker.weather.view.PromotionAppDetailScrollView;
import java.util.List;

public class Weather2Activity extends BaseFragmentActivity implements OnClickListener {
    public static y m;
    private boolean A = false;
    private ActivityManager B = null;
    private Runnable C = new x(this);
    private RecyclingImageView n;
    private RecyclingImageView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private Button s;
    private RatingBar t;
    private PromotionAppInfo u;
    private PromotionAppDetailScrollView v;
    private View w;
    private String x;
    private boolean y = false;
    private Handler z = new Handler();

    public static int a(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static void a(Context context, PromotionAppInfo promotionAppInfo, String str, y yVar) {
        try {
            m = yVar;
            Intent intent = new Intent(context, Weather2Activity.class);
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
            intent.addFlags(268435456);
            intent.putExtra("tag", str);
            Bundle bundle = new Bundle();
            bundle.putParcelable("promotionappinfo", promotionAppInfo);
            intent.putExtras(bundle);
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }

    public static int b(Context context) {
        int i = 0;
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    private void l() {
        this.w = findViewById(R.id.f_promotion_view);
        this.o = (RecyclingImageView) findViewById(R.id.f_promotion_app_icon);
        this.p = (TextView) findViewById(R.id.f_promotion_app_name);
        this.q = (TextView) findViewById(R.id.f_promotion_describle);
        this.r = (TextView) findViewById(R.id.f_promotion_download_num);
        this.s = (Button) findViewById(R.id.f_promotion_download_btn);
        this.t = (RatingBar) findViewById(R.id.l_ad_ratingbar);
        this.n = (RecyclingImageView) findViewById(R.id.f_pos_image_cover);
        this.n.setLayoutParams(new LayoutParams(-1, (int) n()));
        m();
    }

    private void m() {
        CharSequence charSequence;
        this.o.b(this.u.b, 2, 30);
        this.p.setText(this.u.a);
        this.n.b(this.u.x, 2, 30);
        this.q.setText("简介：" + this.u.d);
        String str = "";
        try {
            long parseLong = Long.parseLong(this.u.s);
            charSequence = parseLong > 10000 ? (parseLong / 10000) + "万人下载" : parseLong + "人下载";
        } catch (Exception e) {
            charSequence = "";
        }
        this.r.setText(charSequence);
        if (TextUtils.isEmpty(this.u.y)) {
            this.t.setVisibility(8);
        } else {
            try {
                this.t.setVisibility(0);
                this.t.setRating((float) Integer.parseInt(this.u.y));
            } catch (Exception e2) {
                this.t.setVisibility(8);
            }
        }
        this.s.setOnClickListener(this);
        this.v = (PromotionAppDetailScrollView) findViewById(R.id.scollview);
        this.v.setTranslationY((float) (((double) a((Context) this)) - (((double) b((Context) this)) * 0.8d)));
        this.v.animate().translationY(0.0f).setDuration(500).setListener(new u(this));
    }

    private float n() {
        return ((float) getResources().getDisplayMetrics().widthPixels) / 1.9f;
    }

    private void o() {
        if ("weather_cover".equals(this.x)) {
            LockerService.a().b();
        }
    }

    public void g() {
        this.v.animate().translationY((float) (a((Context) this) + this.v.getScrollY())).setDuration(400).setListener(new v(this)).start();
    }

    public void h() {
        this.w.setBackgroundColor(getResources().getColor(R.color.transparent));
        this.A = true;
        o();
        finish();
    }

    public void i() {
        new Thread(new w(this)).start();
    }

    public boolean j() {
        if (VERSION.SDK_INT >= 20 && bb.a(this)) {
            return k();
        }
        try {
            List runningTasks = this.B.getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0 && ((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName().equals(Weather2Activity.class.getName())) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean k() {
        return !bb.a(this) || bb.b(this).contains(BuildConfig.APPLICATION_ID);
    }

    public void onBackPressed() {
        if (!this.y) {
            this.y = true;
            g();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.f_promotion_download_btn:
                if (m != null) {
                    this.A = true;
                    m.a(this.u.w);
                    m = null;
                    o();
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.f_p_detail_layout);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        this.x = intent.getStringExtra("tag");
        if (extras == null) {
            finish();
            return;
        }
        this.u = (PromotionAppInfo) extras.getParcelable("promotionappinfo");
        if (this.u == null) {
            finish();
            return;
        }
        this.B = (ActivityManager) getSystemService("activity");
        l();
        if ("weather_cover".equals(this.x)) {
            LockerService.a().a(5);
            i();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.y = false;
    }

    protected void onStart() {
        super.onStart();
    }
}
