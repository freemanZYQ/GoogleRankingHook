package com.vlocker.theme.a;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.m.aj;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.f.d;
import com.vlocker.theme.f.e;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.theme.model.T_ThemeItemInfo;
import com.vlocker.theme.model.T_ThemePreviewParserInfo;

public class c extends BaseAdapter {
    private Context a;
    private String b;
    private d c = null;
    private com.vlocker.theme.model.d d;
    private boolean e = true;
    private DisplayMetrics f;

    public c(Context context, T_ThemeItemInfo t_ThemeItemInfo) {
        this.a = context;
        this.d = t_ThemeItemInfo.j();
        this.f = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(this.f);
    }

    public void a(T_ThemeItemInfo t_ThemeItemInfo, boolean z) {
        this.d = t_ThemeItemInfo.j();
        this.e = z;
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.d.size();
    }

    public Object getItem(int i) {
        return this.d.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.c = new d();
            view = LayoutInflater.from(this.a).inflate(R.layout.t_market_onlinetheme_detail_preview_item, null);
            view.setTag(this.c);
        } else {
            this.c = (d) view.getTag();
        }
        if ((j.a(this.a, "com.moxiu.launcher") && aj.b(this.a, "com.moxiu.launcher") >= 533 && !MoSecurityApplication.a) || i == 0) {
            view.findViewById(R.id.moxiu_detail_mark).setVisibility(8);
        }
        if (e.b(this.a).booleanValue()) {
            this.c.a = (RecyclingImageView) view.findViewById(R.id.mypreview);
            this.b = ((T_ThemePreviewParserInfo) this.d.get(i)).a().toString();
            this.c.a.a(this.b, 1, 0);
        } else {
            if (i > 1 && this.e) {
                this.c.a = (RecyclingImageView) view.findViewById(R.id.mypreview);
                this.b = ((T_ThemePreviewParserInfo) this.d.get(i)).a().toString();
                this.c.a.a(this.b, 1, 0);
            }
            if (i == 0 || i == 1) {
                this.c.a = (RecyclingImageView) view.findViewById(R.id.mypreview);
                this.b = ((T_ThemePreviewParserInfo) this.d.get(i)).a().toString();
                this.c.a.a(this.b, 1, 0);
            }
        }
        return view;
    }
}
