package com.vlocker.weather;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.vlocker.b.j;
import com.vlocker.c.a;
import com.vlocker.search.BaiduSearchActivity;
import com.vlocker.search.M_bd_BaiduNewsInfo;
import com.vlocker.search.ap;
import com.vlocker.search.x;
import com.vlocker.theme.f.e;
import com.vlocker.theme.model.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class r {
    public M_bd_BaiduNewsInfo a;
    private Context b;
    private ArrayList c;

    public r(Context context) {
        this.b = context;
    }

    private d d() {
        List j = ap.j(this.b);
        if (j == null || j.size() <= 10) {
            return ap.i(this.b);
        }
        d dVar = new d();
        for (int i = 0; i < j.size(); i++) {
            HashMap hashMap = (HashMap) j.get(i);
            M_bd_BaiduNewsInfo m_bd_BaiduNewsInfo = new M_bd_BaiduNewsInfo();
            m_bd_BaiduNewsInfo.a((String) hashMap.get("title"));
            m_bd_BaiduNewsInfo.b((String) hashMap.get("url"));
            dVar.add(m_bd_BaiduNewsInfo);
        }
        return dVar;
    }

    private boolean e() {
        long l = ap.l(this.b);
        return (l == 0 || System.currentTimeMillis() - l < 0) ? !j.f(this.b) : System.currentTimeMillis() - l <= 3600000 || !j.f(this.b);
    }

    public void a() {
        if (Boolean.valueOf(j.i(this.b)).booleanValue()) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("comefrom", "search_box");
                Intent intent = new Intent(this.b, BaiduSearchActivity.class);
                intent.putExtras(bundle);
                intent.setData(Uri.parse("moxiusearch://"));
                intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
                intent.addFlags(268435456);
                this.b.startActivity(intent);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        e.a(this.b, (CharSequence) "网络貌似不给力哦~", 0);
    }

    public void a(a aVar, int i) {
        if (Boolean.valueOf(j.i(this.b)).booleanValue()) {
            String str = null;
            if (i == 1 || i == 0 || i == 3) {
                str = a.a(this.b).C();
                if (!TextUtils.isEmpty(str)) {
                    str = i == 3 ? str + a.a(this.b).cN() : str + "天气预报";
                } else {
                    return;
                }
            } else if (i == 2) {
                str = "日历";
            }
            String h = ap.h(this.b);
            if (h.equals("") || h.length() < 8) {
                h = "https://m.baidu.com/s?from=1001706a&word=";
            }
            try {
                aVar.a(5, new t(this, i, h + str, str));
                return;
            } catch (Exception e) {
                return;
            }
        }
        e.a(this.b, (CharSequence) "网络貌似不给力哦~", 0);
    }

    public void a(a aVar, String str) {
        if (Boolean.valueOf(j.i(this.b)).booleanValue()) {
            String h = ap.h(this.b);
            if (h.equals("") || h.length() < 8) {
                h = "https://m.baidu.com/s?from=1001706a&word=";
            }
            try {
                aVar.a(5, new s(this, h + str, str));
                return;
            } catch (Exception e) {
                return;
            }
        }
        e.a(this.b, (CharSequence) "网络貌似不给力哦~", 0);
    }

    public void b() {
        List list = x.a(this.b).a;
        if ((list == null || list.size() == 0 || !e()) && j.f(this.b)) {
            ap.a(this.b, System.currentTimeMillis());
            x.a(this.b).a();
        }
    }

    public String c() {
        if (this.c == null) {
            this.c = d();
        }
        if (!(this.c == null || this.c.isEmpty())) {
            this.a = (M_bd_BaiduNewsInfo) this.c.get(new Random().nextInt(this.c.size()));
        }
        return this.a.a();
    }
}
