package com.vlocker.weather.a;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.weather.a;
import com.vlocker.weather.bean.MXOneDayWeatherBean;
import com.vlocker.weather.e.j;
import java.util.ArrayList;

public class v extends ag {
    private Context a;
    private View b;
    private TextView c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private ImageView i;
    private TextView j;
    private ImageView k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private Typeface o = Typeface.createFromAsset(this.a.getAssets(), "fonts/Time_w.ttf");
    private a p;

    public v(Context context, a aVar, View view) {
        this.a = context;
        this.p = aVar;
        this.b = view.findViewById(R.id.today_tomorrow_card);
        b();
    }

    private void b() {
        this.l = (ImageView) this.b.findViewById(R.id.weather_today_image);
        this.i = (ImageView) this.b.findViewById(R.id.weather_today_nightimage);
        this.c = (TextView) this.b.findViewById(R.id.weather_todaytemperatrue);
        this.j = (TextView) this.b.findViewById(R.id.weather_todaydes);
        this.e = (TextView) this.b.findViewById(R.id.tomorrowdaycondition);
        this.h = (TextView) this.b.findViewById(R.id.tomorrownightcondition);
        this.f = (TextView) this.b.findViewById(R.id.weather_tomorrowdaytemperatrue);
        this.g = (TextView) this.b.findViewById(R.id.weather_tomorrowbighttemperatrue);
        this.d = (ImageView) this.b.findViewById(R.id.weather_tomorrow_image);
        this.k = (ImageView) this.b.findViewById(R.id.weather_tomorrow_nightimage);
        this.m = (TextView) this.b.findViewById(R.id.todaydaycondition);
        this.n = (TextView) this.b.findViewById(R.id.todaynightcondition);
        this.b.findViewById(R.id.weather_tomorrow_layout).setOnClickListener(new w(this));
        this.b.findViewById(R.id.weather_today_layout).setOnClickListener(new x(this));
    }

    public View a() {
        return this.b;
    }

    public void a(TextView textView, int i, int i2, int i3) {
        CharSequence spannableString = new SpannableString(textView.getText());
        spannableString.setSpan(new AbsoluteSizeSpan(i), i2, i3, 33);
        textView.setText(spannableString);
    }

    public void a(TextView textView, String str) {
        textView.setTypeface(this.o);
        textView.setText(str);
    }

    public void a(ArrayList arrayList) {
        try {
            b(arrayList);
            c(arrayList);
        } catch (Exception e) {
        }
    }

    public void b(ArrayList arrayList) {
        if (arrayList.size() > 0) {
            MXOneDayWeatherBean mXOneDayWeatherBean = (MXOneDayWeatherBean) arrayList.get(0);
            this.j.setText(mXOneDayWeatherBean.e);
            a(this.c, mXOneDayWeatherBean.c);
            a(this.c, (int) this.a.getResources().getDimension(R.dimen.t_market_lowest_textsize), mXOneDayWeatherBean.c.length() - 1, mXOneDayWeatherBean.c.length());
            a(this.j, mXOneDayWeatherBean.d);
            a(this.j, (int) this.a.getResources().getDimension(R.dimen.t_market_lowest_textsize), mXOneDayWeatherBean.d.length() - 1, mXOneDayWeatherBean.d.length());
            if (TextUtils.isEmpty(mXOneDayWeatherBean.g)) {
                this.l.setImageResource(j.a(0, 1, this.a));
            } else {
                this.l.setImageResource(j.a(Integer.valueOf(mXOneDayWeatherBean.g).intValue(), 1, this.a));
            }
            if (TextUtils.isEmpty(mXOneDayWeatherBean.h)) {
                this.i.setImageResource(j.a(0, 2, this.a));
            } else {
                this.i.setImageResource(j.a(Integer.valueOf(mXOneDayWeatherBean.h).intValue(), 2, this.a));
            }
            this.m.setText(mXOneDayWeatherBean.j);
            this.n.setText(mXOneDayWeatherBean.k);
        }
    }

    public void c(ArrayList arrayList) {
        if (arrayList.size() > 0) {
            MXOneDayWeatherBean mXOneDayWeatherBean = (MXOneDayWeatherBean) arrayList.get(1);
            a(this.f, mXOneDayWeatherBean.c);
            a(this.g, mXOneDayWeatherBean.d);
            a(this.f, (int) this.a.getResources().getDimension(R.dimen.t_market_lowest_textsize), mXOneDayWeatherBean.c.length() - 1, mXOneDayWeatherBean.c.length());
            a(this.g, (int) this.a.getResources().getDimension(R.dimen.t_market_lowest_textsize), mXOneDayWeatherBean.d.length() - 1, mXOneDayWeatherBean.d.length());
            if (TextUtils.isEmpty(mXOneDayWeatherBean.g)) {
                this.d.setImageResource(j.a(0, 1, this.a));
            } else {
                this.d.setImageResource(j.a(Integer.valueOf(mXOneDayWeatherBean.g).intValue(), 1, this.a));
            }
            if (TextUtils.isEmpty(mXOneDayWeatherBean.h)) {
                this.k.setImageResource(j.a(0, 2, this.a));
            } else {
                this.k.setImageResource(j.a(Integer.valueOf(mXOneDayWeatherBean.h).intValue(), 2, this.a));
            }
            this.e.setText(mXOneDayWeatherBean.j);
            this.h.setText(mXOneDayWeatherBean.k);
        }
    }
}
