package com.vlocker.weather.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class a extends ag {
    private RelativeLayout a;
    private TextView b;
    private float c;
    private float d;
    private float e;
    private long f = 0;
    private long g = 0;
    private int h;
    private LinearLayout i;
    private int j;
    private List k;
    private Context l;
    private View m;
    private com.vlocker.weather.a n;

    public a(Context context, com.vlocker.weather.a aVar, View view) {
        this.l = context;
        this.n = aVar;
        this.m = LayoutInflater.from(this.l).inflate(R.layout.weather_alarm_detail_new, null);
        b();
    }

    private void a(JSONObject jSONObject) {
        int i = 3;
        this.i.setVisibility(0);
        this.i.removeAllViews();
        this.a.setVisibility(8);
        JSONArray jSONArray = jSONObject.getJSONArray("alarm");
        if (jSONArray.length() <= 3) {
            i = jSONArray.length();
        }
        this.j = i;
        this.k = new ArrayList();
        int i2 = 0;
        while (i2 < this.j) {
            e eVar = new e(this);
            View inflate = LayoutInflater.from(this.l).inflate(R.layout.alarmlayout_new, null);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.weight = 1.0f;
            inflate.setLayoutParams(layoutParams);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.weather_alarm_title_item);
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 10, 0, 10);
            if (this.j == 1) {
                layoutParams2.gravity = 3;
            } else {
                layoutParams2.gravity = 1;
            }
            linearLayout.setLayoutParams(layoutParams2);
            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
            View findViewById = inflate.findViewById(R.id.weather_alarm_devider_new);
            TextView textView = (TextView) inflate.findViewById(R.id.weather_alarmtitle_detail);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.weather_alarmImage_detail);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.weather_alarmImagebg_detail);
            ((LinearLayout) inflate.findViewById(R.id.weather_alarm_title)).setVisibility(0);
            textView.setText(jSONObject2.getString("text"));
            eVar.a = textView;
            eVar.b = findViewById;
            eVar.d = jSONObject2.getString("desc");
            eVar.c = jSONObject2.optString("time");
            eVar.e = jSONObject2.optString("id");
            this.k.add(eVar);
            if (jSONObject2.getString("color").equals("blue")) {
                linearLayout2.setBackgroundResource(R.drawable.weather_bluebg);
            } else if (jSONObject2.getString("color").equals("yellow")) {
                linearLayout2.setBackgroundResource(R.drawable.weather_yellowbg);
            } else if (jSONObject2.getString("color").equals("orange")) {
                linearLayout2.setBackgroundResource(R.drawable.weather_orangebg);
            } else if (jSONObject2.getString("color").equals("red")) {
                linearLayout2.setBackgroundResource(R.drawable.weather_readbg);
            }
            if (jSONObject2.getString("text_img").equals("RoadIcing")) {
                imageView.setImageResource(R.drawable.weather_roadice);
            } else if (jSONObject2.getString("text_img").equals("SnowStorm")) {
                imageView.setImageResource(R.drawable.weather_stormsnow);
            } else if (jSONObject2.getString("text_img").equals("RainStorm")) {
                imageView.setImageResource(R.drawable.weather_stormrain);
            } else if (jSONObject2.getString("text_img").equals("Gale")) {
                imageView.setImageResource(R.drawable.weather_gale);
            } else if (jSONObject2.getString("text_img").equals("HeavyFog")) {
                imageView.setImageResource(R.drawable.weather_frog);
            } else if (jSONObject2.getString("text_img").equals("HeatWave")) {
                imageView.setImageResource(R.drawable.weather_heatwave);
            } else if (jSONObject2.getString("text_img").equals("Drought")) {
                imageView.setImageResource(R.drawable.weather_drought);
            } else if (jSONObject2.getString("text_img").equals("ColdWave")) {
                imageView.setImageResource(R.drawable.weather_code);
            } else if (jSONObject2.getString("text_img").equals("Lightning")) {
                imageView.setImageResource(R.drawable.weather_thunder);
            } else if (jSONObject2.getString("text_img").equals("Haze")) {
                imageView.setImageResource(R.drawable.weather_haze);
            } else if (jSONObject2.getString("text_img").equals("SandStorm")) {
                imageView.setImageResource(R.drawable.weather_hazard);
            } else if (jSONObject2.getString("text_img").equals("Frost")) {
                imageView.setImageResource(R.drawable.weather_frost);
            } else if (jSONObject2.getString("text_img").equals("Typhoon")) {
                imageView.setImageResource(R.drawable.weather_typhoon);
            } else if (jSONObject2.getString("text_img").equals("Hail")) {
                imageView.setImageResource(R.drawable.weather_hail);
            }
            if (i2 == 0) {
                try {
                    this.a.setVisibility(0);
                    this.b.setText(jSONObject2.getString("desc"));
                    this.b.setEllipsize(TruncateAt.END);
                    this.b.setMaxLines(2);
                    if (this.j == 1) {
                        textView.setTextColor(this.l.getResources().getColor(R.color.white));
                        findViewById.setBackgroundColor(this.l.getResources().getColor(R.color.moxiu_dialog_white_alph));
                    } else {
                        textView.setTextColor(this.l.getResources().getColor(R.color.white));
                        findViewById.setBackgroundColor(-1);
                    }
                    com.vlocker.c.a.a(this.l).L(jSONObject2.getString("text"));
                } catch (Exception e) {
                    this.a.setVisibility(8);
                }
            } else {
                textView.setTextColor(this.l.getResources().getColor(R.color.awhite));
                findViewById.setBackgroundColor(this.l.getResources().getColor(R.color.moxiu_dialog_white_alph));
            }
            try {
                this.i.addView(inflate);
                if (inflate != null) {
                    inflate.setOnClickListener(new d(this, jSONObject2));
                }
                i2++;
            } catch (Exception e2) {
                this.i.setVisibility(8);
                return;
            }
        }
        if (jSONArray.length() <= 0) {
        }
    }

    private void b() {
        this.h = l.a(this.l, 10.0f);
        this.m.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.i = (LinearLayout) this.m.findViewById(R.id.weather_alarm_title_layout_new);
        this.a = (RelativeLayout) this.m.findViewById(R.id.weather_alarm_detail_layout_new);
        this.b = (TextView) this.m.findViewById(R.id.weather_alarm_content_detail_new);
        this.b.setOnTouchListener(new b(this));
        this.b.setOnClickListener(new c(this));
    }

    private int c() {
        return Calendar.getInstance().get(6);
    }

    public View a() {
        return this.m;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && this.k != null) {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                e eVar = (e) this.k.get(i);
                TextView textView = eVar.a;
                View view = eVar.b;
                String str2 = eVar.c;
                CharSequence charSequence = eVar.d;
                String str3 = eVar.e;
                if (size == 1) {
                    textView.setTextColor(this.l.getResources().getColor(R.color.white));
                    view.setBackgroundColor(this.l.getResources().getColor(R.color.moxiu_dialog_white_alph));
                } else if (str.equals(textView.getText()) || str.equals(str3)) {
                    textView.setTextColor(this.l.getResources().getColor(R.color.white));
                    view.setBackgroundColor(-1);
                    this.a.setVisibility(0);
                    this.b.setText(charSequence);
                    com.vlocker.c.a.a(this.l).L(str);
                } else {
                    textView.setTextColor(this.l.getResources().getColor(R.color.awhite));
                    view.setBackgroundColor(this.l.getResources().getColor(R.color.moxiu_dialog_white_alph));
                }
            }
        }
    }

    public void a(JSONObject jSONObject, int i) {
        if (c() == i) {
            a(jSONObject);
        } else {
            this.a.setVisibility(8);
        }
    }
}
