package com.vlocker.weather.a;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.theme.f.a;
import com.vlocker.weather.e.j;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private Context f;
    private View g;
    private Typeface h = Typeface.createFromAsset(this.f.getAssets(), "fonts/Time_w.ttf");
    private int i;
    private RelativeLayout j;
    private LinearLayout k;

    public f(Context context, View view) {
        this.f = context;
        this.g = view;
        c();
    }

    private void a(TextView textView, String str) {
        textView.setTypeface(this.h);
        textView.setText(str);
    }

    private void b(JSONObject jSONObject, int i) {
        try {
            JSONArray jSONArray = new JSONArray(jSONObject.getString("detail_hours"));
            long longValue = a.b("weathercurrenttime", this.f).longValue();
            int i2 = Calendar.getInstance().get(11);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(longValue);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                if (instance.get(11) == Integer.valueOf(jSONObject2.getString("hour").toString()).intValue() && d() == i) {
                    this.i = i3;
                }
                if (Integer.valueOf(jSONObject2.getString("hour").toString()).intValue() == i2) {
                    String string = jSONObject2.getString("temp");
                    string = string.substring(0, string.length() - 1);
                    if (System.currentTimeMillis() < longValue || System.currentTimeMillis() - longValue > 86400000) {
                        JSONObject jSONObject3 = (JSONObject) jSONArray.get(this.i);
                        String string2 = jSONObject3.getString("temp");
                        string2 = string2.substring(0, string2.length() - 1);
                        this.d.setText(jSONObject3.getString("text"));
                        a(this.b, string2.toString());
                        com.vlocker.c.a.a(this.f).I(jSONObject2.getString("text"));
                        com.vlocker.c.a.a(this.f).G(string2.toString());
                    } else {
                        a(this.b, string.toString());
                        com.vlocker.c.a.a(this.f).G(string.toString());
                        com.vlocker.c.a.a(this.f).I(jSONObject2.getString("text"));
                        this.d.setText(jSONObject2.getString("text"));
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private void c() {
        this.j = (RelativeLayout) this.g.findViewById(R.id.weathertodaylayout);
        this.b = (TextView) this.g.findViewById(R.id.weather_day_temperature);
        this.c = (TextView) this.g.findViewById(R.id.weather_degree);
        this.d = (TextView) this.g.findViewById(R.id.weather_condition);
        this.a = (TextView) this.g.findViewById(R.id.weather_aqi);
        a(this.c, "℃");
        a(this.b, "--");
        this.a.setOnClickListener(new g(this));
        this.k = (LinearLayout) this.g.findViewById(R.id.toptext);
        this.e = (ImageView) this.g.findViewById(R.id.weather_condition_img);
    }

    private int d() {
        return Calendar.getInstance().get(6);
    }

    public RelativeLayout a() {
        return this.j;
    }

    public void a(JSONObject jSONObject) {
        try {
            this.a.setVisibility(0);
            if (j.a(this.f)) {
                this.a.setText(this.f.getResources().getString(R.string.weather_out_of_date));
                this.a.setBackgroundResource(R.drawable.weather_moderatepollution);
                return;
            }
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = jSONObject.getJSONObject("aqi");
            } catch (JSONException e) {
            }
            if (jSONObject2 == null) {
                this.a.setText("空气良");
                this.a.setBackgroundResource(R.drawable.weather_conditiongood);
                this.a.setTextColor(this.f.getResources().getColor(R.color.weather_condition_text));
                return;
            }
            this.a.setText(jSONObject2.getString("text"));
            this.a.setTextColor(this.f.getResources().getColor(R.color.white));
            if (jSONObject2.getString("color").toLowerCase().equals("green")) {
                this.a.setBackgroundResource(R.drawable.weather_excellent);
            } else if (jSONObject2.getString("color").toLowerCase().equals("yellow")) {
                this.a.setBackgroundResource(R.drawable.weather_conditiongood);
                this.a.setTextColor(this.f.getResources().getColor(R.color.weather_condition_text));
            } else if (jSONObject2.getString("color").toLowerCase().equals("orange")) {
                this.a.setBackgroundResource(R.drawable.weather_midpollution);
            } else if (jSONObject2.getString("color").toLowerCase().equals("red")) {
                this.a.setBackgroundResource(R.drawable.weather_moderatepollution);
            } else if (jSONObject2.getString("color").toLowerCase().equals("purple")) {
                this.a.setBackgroundResource(R.drawable.weather_severepollution);
            } else if (jSONObject2.getString("color").toLowerCase().equals("maroon")) {
                this.a.setBackgroundResource(R.drawable.weather_seriouspolltion);
            }
            this.a.setPadding(10, 0, 10, 0);
        } catch (Exception e2) {
            this.a.setVisibility(8);
        }
    }

    public void a(JSONObject jSONObject, int i) {
        if (i == d()) {
            a(jSONObject);
        } else if (j.a(this.f)) {
            this.a.setText(this.f.getResources().getString(R.string.weather_out_of_date));
            this.a.setBackgroundResource(R.drawable.weather_moderatepollution);
        } else {
            this.a.setText("空气良");
            this.a.setBackgroundResource(R.drawable.weather_conditiongood);
            this.a.setTextColor(this.f.getResources().getColor(R.color.weather_condition_text));
            this.a.setPadding(10, 0, 10, 0);
        }
        b(jSONObject, i);
        this.e.setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeResource(this.f.getResources(), com.vlocker.c.a.a(this.f).L(0))));
    }

    public LinearLayout b() {
        return this.k;
    }
}
