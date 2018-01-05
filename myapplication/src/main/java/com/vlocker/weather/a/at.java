package com.vlocker.weather.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.location.LocationClientOption;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.weather.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class at extends ag {
    private LinearLayout a;
    private LinearLayout b;
    private RelativeLayout c;
    private Animation d;
    private ImageView e;
    private Context f;
    private View g;
    private List h = new ArrayList();
    private a i;

    public at(Context context, a aVar, View view) {
        this.f = context;
        this.i = aVar;
        this.g = LayoutInflater.from(this.f).inflate(R.layout.weather_wind_detail, null);
        e();
    }

    private void a(int i) {
        this.d = AnimationUtils.loadAnimation(this.f, R.anim.weather_leaf_roll);
        this.d.setDuration((long) i);
        this.d.setInterpolator(new LinearInterpolator());
    }

    private void e() {
        this.a = (LinearLayout) this.g.findViewById(R.id.weather_Linearlayout_index);
        this.b = (LinearLayout) this.g.findViewById(R.id.weather_indexlayout);
        this.c = (RelativeLayout) this.g.findViewById(R.id.weather_windlayout);
    }

    public int a(String str) {
        int i = 0;
        while (i < str.length()) {
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                return i;
            }
            i++;
        }
        return -1;
    }

    public View a() {
        return this.g;
    }

    public void a(JSONArray jSONArray, LinearLayout linearLayout, Context context, int i, String str) {
        int i2;
        View linearLayout2 = new LinearLayout(context);
        linearLayout2.setLayoutParams(new LayoutParams(-2, -2));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        int i3 = 0;
        int i4 = 0;
        View view = linearLayout2;
        while (i3 < jSONArray.length()) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                if (jSONObject.getString("type").equals("Wind")) {
                    i2 = i4 + 1;
                    linearLayout2 = view;
                } else {
                    String string = jSONObject.getString("icon");
                    jSONObject.getString("title");
                    View inflate = LayoutInflater.from(this.f).inflate(i, null);
                    inflate.setOnClickListener(new av(this, jSONObject.getString("type")));
                    RecyclingImageView recyclingImageView = (RecyclingImageView) inflate.findViewById(R.id.weatherindeximage);
                    TextView textView = (TextView) inflate.findViewById(R.id.weather_indexbottomline);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.weather_indexname);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.weather_indexrightline);
                    ((TextView) inflate.findViewById(R.id.weather_indexdes)).setText(jSONObject.getString("title"));
                    textView2.setText(jSONObject.getString("desc"));
                    if (!(string == null || string.equals(""))) {
                        recyclingImageView.a(string, 2, 13);
                        this.h.add(recyclingImageView);
                    }
                    if ((jSONArray.length() - i4) % 2 == 1) {
                        if (i3 > jSONArray.length() - 2) {
                            textView.setVisibility(8);
                        } else {
                            textView.setVisibility(0);
                        }
                    } else if (jSONArray.length() - i4 == 2) {
                        textView.setVisibility(8);
                    } else if (i3 > (jSONArray.length() - i4) - 3) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (i4 > 0) {
                        if (i3 == 1 || (i3 % 2 == 0 && i3 > 1)) {
                            textView3.setVisibility(8);
                        }
                    } else if (i3 % 2 == 1) {
                        textView3.setVisibility(8);
                    }
                    int a = (int) ((((float) l.a()) - this.f.getResources().getDimension(R.dimen.t_market_album_margin_2)) / 2.0f);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(a, (int) (((double) a) / 3.0d));
                    inflate.setLayoutParams(layoutParams);
                    view.addView(inflate);
                    if (view.getChildCount() == 2) {
                        linearLayout.addView(view);
                        linearLayout2 = null;
                        try {
                            view = new LinearLayout(context);
                            try {
                                view.setGravity(17);
                                view.setLayoutParams(new LayoutParams(-2, -2));
                                view.setOrientation(0);
                                linearLayout2 = view;
                            } catch (JSONException e) {
                                linearLayout2 = view;
                                i2 = i4;
                                i3++;
                                i4 = i2;
                                view = linearLayout2;
                            } catch (Exception e2) {
                                linearLayout2 = view;
                                i2 = i4;
                                i3++;
                                i4 = i2;
                                view = linearLayout2;
                            }
                        } catch (JSONException e3) {
                            i2 = i4;
                            i3++;
                            i4 = i2;
                            view = linearLayout2;
                        } catch (Exception e4) {
                            i2 = i4;
                            i3++;
                            i4 = i2;
                            view = linearLayout2;
                        }
                    } else {
                        linearLayout2 = view;
                    }
                    if ((jSONArray.length() - i4) % 2 == 1 && i3 == (jSONArray.length() - i4) - 1) {
                        View inflate2 = LayoutInflater.from(this.f).inflate(R.layout.weather_indexitem, null);
                        inflate2.setLayoutParams(layoutParams);
                        inflate2.setVisibility(4);
                        linearLayout2.addView(inflate2);
                        linearLayout.addView(linearLayout2);
                    }
                    i2 = i4;
                }
            } catch (JSONException e5) {
                linearLayout2 = view;
                i2 = i4;
                i3++;
                i4 = i2;
                view = linearLayout2;
            } catch (Exception e6) {
                linearLayout2 = view;
                i2 = i4;
                i3++;
                i4 = i2;
                view = linearLayout2;
            }
            i3++;
            i4 = i2;
            view = linearLayout2;
        }
    }

    public void a(JSONObject jSONObject) {
        if (this.a != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("weather_index");
                if (jSONArray.length() > 0) {
                    this.a.setVisibility(0);
                    this.b.removeAllViews();
                    this.c.removeAllViews();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                        String string = jSONObject2.getString("type");
                        if (string != null && string.equals("Wind")) {
                            View inflate = LayoutInflater.from(this.f).inflate(R.layout.weather_winditem, null);
                            this.e = (ImageView) inflate.findViewById(R.id.weather_shuye);
                            TextView textView = (TextView) inflate.findViewById(R.id.weather_winddir);
                            TextView textView2 = (TextView) inflate.findViewById(R.id.weather_winddes);
                            String string2 = jSONObject2.getString("title");
                            if (string2 == null) {
                                textView2.setText("暂无数据");
                                textView.setText("暂无数据");
                            } else {
                                int i2;
                                int a = a(string2);
                                textView.setText(string2.substring(0, a));
                                textView2.setText(string2.substring(a));
                                switch (Integer.valueOf(string2.substring(a, a + 1)).intValue()) {
                                    case 0:
                                    case 1:
                                        i2 = 6000;
                                        break;
                                    case 2:
                                    case 3:
                                        i2 = 4000;
                                        break;
                                    case 4:
                                    case 5:
                                        i2 = 3000;
                                        break;
                                    case 6:
                                    case 7:
                                        i2 = 2000;
                                        break;
                                    case 8:
                                    case 9:
                                        i2 = 1500;
                                        break;
                                    default:
                                        i2 = LocationClientOption.MIN_SCAN_SPAN;
                                        break;
                                }
                                a(i2);
                                this.e.startAnimation(this.d);
                            }
                            inflate.setOnClickListener(new au(this));
                            this.c.addView(inflate);
                        }
                        this.b.removeAllViews();
                        this.h.clear();
                        a(jSONArray, this.b, this.f, R.layout.weather_indexitem, "");
                    }
                    return;
                }
                this.a.setVisibility(8);
            } catch (JSONException e) {
                this.a.setVisibility(8);
            }
        }
    }

    public void a(JSONObject jSONObject, int i) {
        a(jSONObject);
    }

    public void b() {
        if (this.e != null && this.d != null) {
            this.e.startAnimation(this.d);
        }
    }

    public void c() {
        if (this.e != null) {
            this.e.clearAnimation();
        }
    }

    public void d() {
        for (int i = 0; i < this.h.size(); i++) {
            RecyclingImageView recyclingImageView = (RecyclingImageView) this.h.get(i);
            if (!TextUtils.isEmpty(recyclingImageView.getImageUrl()) && recyclingImageView.getDrawable() == null) {
                recyclingImageView.a(recyclingImageView.getImageUrl(), 2, 13);
            }
        }
    }
}
