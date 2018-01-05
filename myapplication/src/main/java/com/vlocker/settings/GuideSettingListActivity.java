package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.a.e;

public class GuideSettingListActivity extends Activity {
    OnClickListener a = new ai(this);
    String b = "http://mp.weixin.qq.com/s?__biz=MzA3NjA5OTY2MA==&mid=202506368&idx=1&sn=c957d50cf9c0a772f66edbe3d93675e4#rd";
    String c = "http://mp.weixin.qq.com/s?__biz=MzA3NjA5OTY2MA==&mid=202506350&idx=1&sn=06e1686058a047a9711271db9b1658d1#rd";
    String d = "http://mp.weixin.qq.com/s?__biz=MzA3NjA5OTY2MA==&mid=202506395&idx=1&sn=8ece8e39681e75ab18a7099ea1531f38#rd";
    String e = "http://mp.weixin.qq.com/s?__biz=MzA3NjA5OTY2MA==&mid=202506599&idx=1&sn=a3f34d16b08783fb2e9304ac512de565#rd";
    String f = "http://mp.weixin.qq.com/s?__biz=MzA3NjA5OTY2MA==&mid=202506626&idx=1&sn=f0b7710f1765d58a7bff712d26e9b148#rd";
    String g = "http://mp.weixin.qq.com/s?__biz=MzA3NjA5OTY2MA==&mid=202506533&idx=1&sn=b28a3b9493ca9ed84c24b77bb81eb22e#rd";
    String h = "http://mp.weixin.qq.com/s?__biz=MzA3NjA5OTY2MA==&mid=202506684&idx=1&sn=b76338143b6a7856f2278702f1fcc6e0#rd";
    String i = "http://mp.weixin.qq.com/s?__biz=MzA3NjA5OTY2MA==&mid=202506656&idx=1&sn=0d49327883a9257d565dee666f538681#rd";
    String j = "http://mp.weixin.qq.com/s?__biz=MzA3NjA5OTY2MA==&mid=202506565&idx=1&sn=f20fdceada17ba0f293408dc9f617dc0#rd";
    String k = "http://mp.weixin.qq.com/s?__biz=MzA3NjA5OTY2MA==&mid=202506512&idx=1&sn=d5cf32ec7663e3e2cfb31cf276faa317#rd";
    String l = "http://mp.weixin.qq.com/s?__biz=MzA3NjA5OTY2MA==&mid=202506503&idx=1&sn=26f9e27359365bb1b777aaa4e34232b4#rd";
    String m = "http://mp.weixin.qq.com/s?__biz=MzA3NjA5OTY2MA==&mid=202506479&idx=1&sn=dd8426ba59b55ef558d1642d574a9cab#rd";
    String n = "http://mp.weixin.qq.com/s?__biz=MzA3NjA5OTY2MA==&mid=202506582&idx=1&sn=bc5cae03e07798e8af2985e307b2e1fa#rd";
    private ListView o;
    private ak p;
    private a q = null;

    private void a() {
        findViewById(R.id.btn_back_main).setOnClickListener(this.a);
        if (this.p == null) {
            this.p = new ak(this, this);
        }
        this.o = (ListView) findViewById(R.id.lv);
        this.o.setAdapter(this.p);
        this.p.notifyDataSetChanged();
        this.o.setOnItemClickListener(new ah(this));
    }

    private void a(int i) {
        String str = null;
        try {
            String a = this.p.a(i);
            if (!(a == null || a.equals(""))) {
                if (a.equals("360清理大师")) {
                    str = this.b;
                } else if (a.equals("百度手机卫士")) {
                    str = this.e;
                } else if (a.equals("360手机卫士")) {
                    str = this.c;
                } else if (a.equals("LBE")) {
                    str = this.d;
                } else if (a.equals("猎豹清理大师")) {
                    str = this.f;
                } else if (a.equals("腾讯超级管理")) {
                    str = this.g;
                } else if (a.equals("腾讯手机管家")) {
                    str = this.h;
                } else if (a.equals("酷派酷管家")) {
                    str = this.i;
                } else if (a.equals("vivoX系列系统")) {
                    str = this.j;
                } else if (a.equals("vivoY系列系统")) {
                    str = this.k;
                } else if (a.equals("联想乐安全")) {
                    str = this.l;
                } else if (a.equals("MX3系统")) {
                    str = this.m;
                } else if (a.equals("MX4系统")) {
                    str = this.n;
                } else if (a.equals("华为系统")) {
                    e.d(this);
                    return;
                }
            }
            GuideWebViewActivity.a(this, 0, str, a);
        } catch (Exception e) {
        }
    }

    public static void a(Context context) {
        new Handler().postDelayed(new aj(context), 200);
    }

    private void b() {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.l_guide_list_activity);
        this.q = a.a((Context) this);
        a();
    }

    protected void onResume() {
        super.onResume();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
