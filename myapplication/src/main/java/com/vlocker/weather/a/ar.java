package com.vlocker.weather.a;

import android.content.Context;
import android.view.View;
import com.vlocker.locker.R;
import com.vlocker.weather.bean.MXOneDayWeatherBean;
import com.vlocker.weather.e.j;
import com.vlocker.weather.view.MXWeatherListShow;
import java.util.ArrayList;
import java.util.Iterator;

public class ar extends ag {
    private Context a;
    private View b;
    private MXWeatherListShow c;

    public ar(Context context, View view) {
        this.a = context;
        this.b = view.findViewById(R.id.week_card);
        b();
    }

    private void b() {
        this.c = (MXWeatherListShow) this.b.findViewById(R.id.weekweather_list);
    }

    public View a() {
        return this.b;
    }

    public void a(ArrayList arrayList) {
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                MXOneDayWeatherBean mXOneDayWeatherBean = (MXOneDayWeatherBean) it.next();
                if (j.a(-1).equals(mXOneDayWeatherBean.b)) {
                    mXOneDayWeatherBean.i = "昨天";
                }
                if (j.a(0).equals(mXOneDayWeatherBean.b)) {
                    mXOneDayWeatherBean.i = "今天";
                }
                if (j.a(1).equals(mXOneDayWeatherBean.b)) {
                    mXOneDayWeatherBean.i = "明天";
                }
            }
            this.c.setMxOneDayWeatherBeans(arrayList);
            this.c.setDay(0);
            this.c.setOnClickListener(new as(this));
        } catch (Exception e) {
        }
    }
}
