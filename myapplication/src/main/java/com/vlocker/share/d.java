package com.vlocker.share;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.vlocker.locker.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class d extends BaseAdapter {
    Comparator a = new e(this);
    private Context b;
    private List c = new ArrayList();
    private g d;

    public d(Context context, int i) {
        this.b = context;
        a(i);
    }

    private void a() {
        if (a("com.tencent.mobileqq")) {
            f fVar = new f(this, 2, "QQ", R.drawable.share_mx_qq);
            f fVar2 = new f(this, 0, "QZone", R.drawable.share_mx_zone);
            this.c.add(fVar);
            this.c.add(fVar2);
        }
    }

    private void a(int i) {
        switch (i) {
            case 1:
                a();
                b();
                c();
                d();
                break;
            case 2:
                a();
                b();
                c();
                break;
        }
        Collections.sort(this.c, this.a);
    }

    private boolean a(String str) {
        try {
            return this.b.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private void b() {
        if (a(WXApp.WXAPP_PACKAGE_NAME)) {
            f fVar = new f(this, 3, "微信", R.drawable.share_mx_wx);
            f fVar2 = new f(this, 1, "朋友圈", R.drawable.share_mx_circle);
            this.c.add(fVar);
            this.c.add(fVar2);
        }
    }

    private void c() {
        if (a("com.sina.weibo")) {
            this.c.add(new f(this, 4, "新浪微博", R.drawable.share_mx_sina));
        }
    }

    private void d() {
        f fVar = new f(this, 5, "浏览器打开", R.drawable.share_mx_webview);
        f fVar2 = new f(this, 6, "复制链接", R.drawable.share_mx_copy);
        this.c.add(fVar);
        this.c.add(fVar2);
    }

    public int getCount() {
        return this.c.size();
    }

    public Object getItem(int i) {
        return this.c.get(i);
    }

    public long getItemId(int i) {
        return (long) ((f) this.c.get(i)).a;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.d = new g();
            view = LayoutInflater.from(this.b).inflate(R.layout.l_share_item, null);
            this.d.a = (ImageView) view.findViewById(R.id.share_item_img);
            this.d.b = (TextView) view.findViewById(R.id.share_item_tv);
            view.setTag(this.d);
        } else {
            this.d = (g) view.getTag();
        }
        this.d.a.setImageResource(((f) this.c.get(i)).b);
        this.d.b.setText(((f) this.c.get(i)).c);
        return view;
    }
}
