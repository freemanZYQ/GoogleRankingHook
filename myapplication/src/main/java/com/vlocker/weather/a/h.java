package com.vlocker.weather.a;

import android.content.Context;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.vlocker.locker.R;
import com.vlocker.weather.view.MXWeatherHoursShow;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class h extends ag {
    HorizontalScrollView a;
    private Context b;
    private View c;
    private MXWeatherHoursShow d;
    private List e = new ArrayList();

    public h(Context context, View view) {
        this.b = context;
        this.c = view.findViewById(R.id.hours_card);
        e();
    }

    private int d() {
        return Calendar.getInstance().get(6);
    }

    private void e() {
        this.c.setVisibility(0);
        this.a = (HorizontalScrollView) this.c.findViewById(R.id.hours_scroll);
        this.a.scrollTo(0, 0);
        this.d = (MXWeatherHoursShow) this.c.findViewById(R.id.hours_gallery);
    }

    public View a() {
        return this.c;
    }

    public void a(JSONObject jSONObject, int i) {
        try {
            int i2;
            this.c.setVisibility(0);
            JSONArray jSONArray = new JSONArray(jSONObject.getString("detail_hours"));
            this.e.clear();
            for (i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                i iVar = new i(this);
                iVar.a(jSONObject2.getString("hour"));
                iVar.b(jSONObject2.getString("temp"));
                iVar.c(jSONObject2.getString("text"));
                iVar.d(jSONObject2.getString("text_img"));
                this.e.add(iVar);
            }
            if (this.e.isEmpty()) {
                this.c.setVisibility(8);
                return;
            }
            int i3;
            this.d.removeAllViews();
            List arrayList = new ArrayList();
            int i4 = Calendar.getInstance().get(11);
            i2 = 0;
            int i5 = -1;
            while (i2 < this.e.size()) {
                i3 = (i4 == Integer.valueOf(((i) this.e.get(i2)).a).intValue() && d() == i) ? i2 : i5;
                i2++;
                i5 = i3;
            }
            if (i5 == -1) {
                this.c.setVisibility(8);
                return;
            }
            if (i5 % 2 == 0) {
                for (i3 = 0; i3 < this.e.size(); i3 += 2) {
                    arrayList.add(this.e.get(i3));
                }
            } else {
                for (i3 = 1; i3 < this.e.size(); i3 += 2) {
                    arrayList.add(this.e.get(i3));
                }
            }
            this.d.a(this.b, arrayList, jSONObject, i, d(), this.a, this.c);
        } catch (Exception e) {
            this.c.setVisibility(8);
        }
    }

    public void b() {
        if (this.d != null) {
            this.d.a();
        }
    }

    public HorizontalScrollView c() {
        return this.a;
    }
}
