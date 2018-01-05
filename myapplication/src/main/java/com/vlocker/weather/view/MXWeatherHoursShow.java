package com.vlocker.weather.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.theme.f.a;
import com.vlocker.weather.a.i;
import com.vlocker.weather.e.j;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONObject;

public class MXWeatherHoursShow extends LinearLayout {
    private Context a;
    private LinearLayout b;
    private MXWeatherHourLineView c;
    private HorizontalScrollView d;
    private int e;
    private int f;
    private boolean g;
    private int h = -1;

    public MXWeatherHoursShow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        setLayoutParams(new LayoutParams(-1, -1));
        setPadding(0, 0, 0, 0);
        setOrientation(1);
    }

    private void setHourView(int i) {
        this.b = new LinearLayout(this.a);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(Math.max((getResources().getDimensionPixelSize(R.dimen.weather_temppic_width) * (i - 1)) * 2, -1), -2);
        layoutParams.topMargin = l.a(4.0f);
        this.b.setOrientation(0);
        this.b.setGravity(16);
        this.b.setLayoutParams(layoutParams);
        for (int i2 = 0; i2 < i; i2++) {
            View linearLayout = new LinearLayout(this.a);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2, 1.0f);
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.setOrientation(1);
            View textView = new TextView(this.a);
            if (VERSION.SDK_INT >= 14) {
                textView.setLayerType(1, null);
            }
            layoutParams2.gravity = 1;
            textView.setLayoutParams(layoutParams2);
            textView.setGravity(1);
            textView.setTextSize(2, 10.0f);
            textView.setTextColor(Integer.MAX_VALUE);
            linearLayout.addView(textView, 0);
            this.b.addView(linearLayout, i2);
        }
        addView(this.b, 1);
    }

    private void setTempLineView(int i) {
        this.c = new MXWeatherHourLineView(this.a);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(Math.max((getResources().getDimensionPixelSize(R.dimen.weather_temppic_width) * (i - 1)) * 2, -1), -2);
        getResources().getDimension(R.dimen.t_market_album_margin);
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        layoutParams.height = l.a(92.0f);
        this.c.setBackgroundColor(0);
        this.c.setLayoutParams(layoutParams);
        addView(this.c, 0);
    }

    public void a() {
        if (this.h >= 0) {
            try {
                if (this.d.isShown()) {
                    this.d.scrollTo(this.b.getChildAt(this.h).getLeft(), 0);
                } else {
                    this.d.setScrollX(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(Context context, List list, JSONObject jSONObject, int i, int i2, HorizontalScrollView horizontalScrollView, View view) {
        long j;
        Calendar instance;
        this.d = horizontalScrollView;
        setTempLineView(list.size());
        setHourView(list.size());
        int i3 = Calendar.getInstance().get(11);
        try {
            j = jSONObject.getLong("detail_hours_time");
            instance = Calendar.getInstance();
            instance.setTimeInMillis(j);
            i = instance.get(6);
        } catch (Exception e) {
            e.printStackTrace();
        }
        j = a.b("weathercurrenttime", context).longValue();
        Long b = a.b("weathersunrise", context);
        Long b2 = a.b("weathersunset", context);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(b.longValue());
        instance = Calendar.getInstance();
        instance.setTimeInMillis(b2.longValue());
        Calendar.getInstance().setTimeInMillis(j);
        this.e = instance2.getTime().getHours();
        instance2.getTime().getMinutes();
        this.f = instance.getTime().getHours();
        instance.getTime().getMinutes();
        Object obj = null;
        if (this.e < 3 || this.e > 9 || this.f < 16 || this.f > 20) {
            obj = 1;
            this.e = 6;
            this.f = 18;
        }
        Object obj2 = obj;
        if ((i2 != i || i3 < Integer.valueOf(((i) list.get(0)).a).intValue()) && (i2 != i + 1 || i3 > Integer.valueOf(((i) list.get(list.size() - 1)).a).intValue())) {
            view.setVisibility(8);
            return;
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        this.h = -1;
        this.g = true;
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        while (i6 < list.size()) {
            int i7;
            i iVar = (i) list.get(i6);
            if (iVar == null) {
                i7 = i4;
                i4 = i5;
            } else {
                arrayList.add(Float.valueOf(iVar.b.replace("℃", "")));
                i7 = (Integer.valueOf(iVar.a).intValue() <= this.e || Integer.valueOf(iVar.a).intValue() > this.f) ? j.a(Integer.parseInt(iVar.d), 2, context) : j.a(Integer.parseInt(iVar.d), 1, context);
                arrayList2.add(Integer.valueOf(i7));
                LinearLayout linearLayout = (LinearLayout) this.b.getChildAt(i6);
                linearLayout.setVisibility(0);
                TextView textView = (TextView) linearLayout.getChildAt(0);
                if (Integer.valueOf(iVar.a).intValue() == i3) {
                    if (this.h == -1) {
                        this.h = i6;
                    }
                    textView.setText("现在");
                    this.g = false;
                } else {
                    textView.setText(iVar.a + "时");
                }
                if (this.g) {
                    textView.setTextColor(Integer.MAX_VALUE);
                } else {
                    textView.setTextColor(Integer.MAX_VALUE);
                }
                if (Integer.valueOf(iVar.a).intValue() == this.e && "rize".equals(iVar.e) && obj2 == null) {
                    textView.setText("日出");
                    i5 = i6;
                }
                if (Integer.valueOf(iVar.a).intValue() == this.f && "set".equals(iVar.e) && obj2 == null) {
                    textView.setText("日落");
                    i7 = i6;
                    i4 = i5;
                } else {
                    i7 = i4;
                    i4 = i5;
                }
            }
            i6++;
            i5 = i4;
            i4 = i7;
        }
        this.c.setRootView(this);
        if (this.h != -1) {
            this.c.setNowIndex(this.h);
        }
        this.c.setRiseIndex(i5);
        this.c.setSetIndex(i4);
        this.c.setDrawLine(true);
        this.c.setTemps(arrayList);
        this.c.setimages(arrayList2);
        this.c.a();
    }
}
