package com.vlocker.weather.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.weather.bean.MXOneDayWeatherBean;
import com.vlocker.weather.e.j;
import java.util.ArrayList;
import java.util.List;

public class MXWeatherListShow extends LinearLayout {
    TextView a;
    TextView b;
    private Context c;
    private LinearLayout d;
    private LinearLayout e;
    private LinearLayout f;
    private ArrayList g;

    public MXWeatherListShow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = context;
        setLayoutParams(new LayoutParams(-1, -1));
        setOrientation(1);
        setPadding(0, 0, 0, 0);
        b();
        a();
    }

    private void a() {
        this.f = new LinearLayout(this.c);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        this.f.setOrientation(0);
        this.f.setGravity(16);
        this.f.setLayoutParams(layoutParams);
        addView(this.f, 1);
        for (int i = 0; i < 7; i++) {
            View linearLayout = new LinearLayout(this.c);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -2, 1.0f);
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.setOrientation(1);
            View textView = new TextView(this.c);
            layoutParams2.gravity = 1;
            layoutParams2.topMargin = l.a(1.0f);
            textView.setLayoutParams(layoutParams2);
            textView.setGravity(1);
            textView.setTextSize(2, 12.0f);
            textView.setTextColor(-1);
            linearLayout.addView(textView, 0);
            textView = new TextView(this.c);
            layoutParams2.gravity = 1;
            layoutParams2.topMargin = l.a(1.0f);
            layoutParams2.bottomMargin = l.a(2.0f);
            textView.setLayoutParams(layoutParams2);
            textView.setGravity(1);
            textView.setTextSize(2, 12.0f);
            textView.setTextColor(-16137994);
            linearLayout.addView(textView, 1);
            this.f.addView(linearLayout, i);
        }
    }

    private void b() {
        this.d = new LinearLayout(this.c);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        this.d.setOrientation(0);
        this.d.setGravity(16);
        this.d.setLayoutParams(layoutParams);
        this.d.setPadding(0, 0, 0, 0);
        addView(this.d, 0);
        for (int i = 0; i < 7; i++) {
            View linearLayout = new LinearLayout(this.c);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -2, 1.0f);
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.setOrientation(1);
            View textView = new TextView(this.c);
            layoutParams2.gravity = 1;
            layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.t_market_album_margin);
            textView.setLayoutParams(layoutParams2);
            textView.setGravity(1);
            textView.setTextSize(2, 12.0f);
            linearLayout.addView(textView, 0);
            View imageView = new ImageView(this.c);
            imageView.setScaleType(ScaleType.FIT_XY);
            ViewGroup.LayoutParams layoutParams3 = new LayoutParams(getResources().getDimensionPixelSize(R.dimen.weather_week_temppic_width), getResources().getDimensionPixelSize(R.dimen.weather_week_temppic_height));
            layoutParams3.gravity = 1;
            layoutParams3.topMargin = getResources().getDimensionPixelSize(R.dimen.t_market_album_week_top_margin);
            imageView.setLayoutParams(layoutParams3);
            linearLayout.addView(imageView, 1);
            this.d.addView(linearLayout, i);
        }
    }

    public ArrayList getMxOneDayWeatherBeans() {
        return this.g;
    }

    public void setDay(int i) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        int size = this.g.size();
        Object obj = 1;
        int i2;
        LinearLayout linearLayout;
        TextView textView;
        ImageView imageView;
        if (size <= 7 || i == 0) {
            int min = Math.min(7, size);
            i2 = 0;
            while (i2 < min) {
                try {
                    arrayList.add(Float.valueOf(((MXOneDayWeatherBean) this.g.get(i2)).c.replace("℃", "")));
                    arrayList2.add(Float.valueOf(((MXOneDayWeatherBean) this.g.get(i2)).d.replace("℃", "")));
                    i2++;
                } catch (Exception e) {
                    arrayList.clear();
                    arrayList2.clear();
                    e.printStackTrace();
                }
            }
            int i3 = 0;
            while (i3 < min) {
                Object obj2;
                linearLayout = (LinearLayout) this.d.getChildAt(i3);
                linearLayout.setVisibility(0);
                textView = (TextView) linearLayout.getChildAt(0);
                textView.setText(j.a(((MXOneDayWeatherBean) this.g.get(i3)).b));
                textView.setTextColor(-1);
                imageView = (ImageView) linearLayout.getChildAt(1);
                LinearLayout linearLayout2 = (LinearLayout) this.f.getChildAt(i3);
                TextView textView2 = (TextView) linearLayout2.getChildAt(0);
                TextView textView3 = (TextView) linearLayout2.getChildAt(1);
                if (TextUtils.isEmpty(((MXOneDayWeatherBean) this.g.get(i3)).g)) {
                    imageView.setImageResource(j.a(0, 1, this.c));
                } else {
                    imageView.setImageResource(j.a(Integer.valueOf(((MXOneDayWeatherBean) this.g.get(i3)).g).intValue(), 1, this.c));
                }
                textView2.setText(Math.round(((Float) arrayList.get(i3)).floatValue()) + "℃");
                textView3.setText(Math.round(((Float) arrayList2.get(i3)).floatValue()) + "℃");
                if (j.a(-1).equals(((MXOneDayWeatherBean) this.g.get(i3)).b)) {
                    textView.setText("昨天");
                    obj2 = obj;
                } else if (j.a(0).equals(((MXOneDayWeatherBean) this.g.get(i3)).b)) {
                    textView.setText("今天");
                    obj2 = null;
                } else if (j.a(1).equals(((MXOneDayWeatherBean) this.g.get(i3)).b)) {
                    textView.setText("明天");
                    obj2 = null;
                } else {
                    obj2 = obj;
                }
                if (obj2 != null) {
                    textView.setTextColor(getResources().getColor(R.color.awhite));
                    textView2.setTextColor(getResources().getColor(R.color.awhite));
                    textView3.setTextColor(2131345654);
                    if (VERSION.SDK_INT >= 11) {
                        imageView.setAlpha(0.3f);
                    }
                } else {
                    textView.setTextColor(-1);
                    if (VERSION.SDK_INT >= 11) {
                        imageView.setAlpha(1.0f);
                    }
                }
                i3++;
                obj = obj2;
            }
            for (i2 = min; i2 < 7 - min; i2++) {
                ((LinearLayout) this.d.getChildAt(i2)).setVisibility(8);
                ((LinearLayout) this.e.getChildAt(i2)).setVisibility(8);
            }
            this.b.setTextColor(-285212673);
            this.a.setTextColor(-2080374785);
            this.b.setSelected(true);
            this.a.setSelected(false);
        } else if (i == 7) {
            int min2 = Math.min(7, size - 7);
            for (int i4 = 7; i4 < min2 + 7; i4++) {
                linearLayout = (LinearLayout) this.d.getChildAt(i4 - 7);
                linearLayout.setVisibility(0);
                textView = (TextView) linearLayout.getChildAt(0);
                textView.setText(j.a(((MXOneDayWeatherBean) this.g.get(i4)).b));
                textView.setTextColor(-1);
                imageView = (ImageView) linearLayout.getChildAt(1);
                if (TextUtils.isEmpty(((MXOneDayWeatherBean) this.g.get(i4)).g)) {
                    imageView.setImageResource(j.a(0, 1, this.c));
                } else {
                    imageView.setImageResource(j.a(Integer.valueOf(((MXOneDayWeatherBean) this.g.get(i4)).g).intValue(), 1, this.c));
                }
                if (VERSION.SDK_INT >= 11) {
                    imageView.setAlpha(1.0f);
                }
            }
            i2 = 7;
            while (i2 < min2 + 7) {
                try {
                    arrayList.add(Float.valueOf(((MXOneDayWeatherBean) this.g.get(i2)).c.replace("℃", "")));
                    arrayList2.add(Float.valueOf(((MXOneDayWeatherBean) this.g.get(i2)).d.replace("℃", "")));
                    i2++;
                } catch (Exception e2) {
                    arrayList.clear();
                    arrayList2.clear();
                    e2.printStackTrace();
                }
            }
            for (i2 = min2; i2 < 7; i2++) {
                ((LinearLayout) this.d.getChildAt(i2)).setVisibility(8);
                ((LinearLayout) this.e.getChildAt(i2)).setVisibility(8);
            }
            this.b.setSelected(false);
            this.a.setSelected(true);
            this.b.setTextColor(-2080374785);
            this.a.setTextColor(-285212673);
        }
    }

    public void setMxOneDayWeatherBeans(ArrayList arrayList) {
        this.g = arrayList;
    }
}
