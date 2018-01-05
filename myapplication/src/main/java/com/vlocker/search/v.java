package com.vlocker.search;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.moxiu.b.a.a;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import java.util.List;

public class v extends p {
    private static final LayoutParams p = new LayoutParams(-1, -2);
    public List a;
    OnClickListener b = new w(this);
    private LinearLayout c;
    private TextView d;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private at m;
    private Animation n;
    private int o;
    private int q = 0;

    public v(BaiduSearchActivity baiduSearchActivity, at atVar) {
        super(baiduSearchActivity, atVar);
        this.m = atVar;
        this.o = ap.a((Context) baiduSearchActivity);
        this.n = AnimationUtils.loadAnimation(baiduSearchActivity, R.anim.m_bd_refresh_textview);
    }

    private LinearLayout a(LinearLayout linearLayout) {
        try {
            linearLayout.removeAllViews();
            linearLayout.setLayoutAnimation(new LayoutAnimationController(this.n));
            linearLayout.addView(d());
            linearLayout.addView(d());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linearLayout;
    }

    private LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.e);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        linearLayout.setAnimationCacheEnabled(true);
        return linearLayout;
    }

    private LinearLayout d() {
        LinearLayout linearLayout = new LinearLayout(this.e);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        linearLayout.setBackgroundResource(R.drawable.t_search_tag_btn);
        View textView = new TextView(this.e);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, (int) this.e.getResources().getDimension(R.dimen.search_hot_item_height));
        layoutParams.gravity = 17;
        try {
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(this.e.getResources().getColor(R.color.m_bd_baidu_type_word_title));
            textView.setGravity(17);
            textView.setMaxEms(8);
            textView.setSingleLine(true);
            textView.setEllipsize(TruncateAt.valueOf("END"));
            linearLayout.setOnClickListener(this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        linearLayout.addView(textView);
        View imageView = new ImageView(this.e);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins((int) this.e.getResources().getDimension(R.dimen.search_hot_icon_margin_left), 0, 0, 0);
        layoutParams2.gravity = 17;
        imageView.setLayoutParams(layoutParams2);
        imageView.setImageDrawable(this.e.getResources().getDrawable(R.drawable.hot_icon));
        imageView.setVisibility(8);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    protected View a() {
        View b = j.b(this.e, (int) R.layout.m_bd_searchhottag_item);
        this.c = (LinearLayout) j.a(b, (int) R.id.main_search_hottagitem);
        this.d = (TextView) j.a(b, (int) R.id.text_search_info);
        this.j = b();
        this.k = b();
        this.l = b();
        this.c.addView(this.j, p);
        this.c.addView(this.k, p);
        this.c.addView(this.l, p);
        return b;
    }

    public void a(List list) {
        this.a = this.m.c;
        try {
            if ((this.e.c || this.j.getChildCount() < 1) && list != null && list.size() > 0) {
                this.j = a(this.j);
                this.k = a(this.k);
                this.l = a(this.l);
            } else {
                list = null;
            }
            if (list != null && this.a != null) {
                int i = 0;
                int i2 = 0;
                while (i < this.c.getChildCount()) {
                    LinearLayout linearLayout = (LinearLayout) this.c.getChildAt(i);
                    int i3 = 0;
                    int i4 = i2;
                    while (i3 < linearLayout.getChildCount()) {
                        LinearLayout linearLayout2 = (LinearLayout) linearLayout.getChildAt(i3);
                        if (linearLayout2.getChildCount() >= 1) {
                            TextView textView = (TextView) linearLayout2.getChildAt(0);
                            ImageView imageView = (ImageView) linearLayout2.getChildAt(1);
                            if (i4 > list.size() - 1) {
                                break;
                            }
                            textView.setText(((M_bd_BaiduNewsInfo) list.get(i4)).a());
                            linearLayout2.setTag(this.a.get(i4));
                            ((a) this.a.get(i4)).b((View) linearLayout2);
                            if (((a) this.a.get(i4)).y()) {
                                imageView.setVisibility(0);
                            }
                            i3++;
                            i4++;
                        } else {
                            break;
                        }
                    }
                    i++;
                    i2 = i4;
                }
                this.e.c = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
