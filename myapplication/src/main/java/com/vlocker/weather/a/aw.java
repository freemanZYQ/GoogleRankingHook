package com.vlocker.weather.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.m.aj;
import com.vlocker.m.l;
import com.vlocker.theme.f.e;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.weather.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aw extends ag {
    private Context a;
    private View b;
    private ListView c;
    private BaseAdapter d;
    private List e = new ArrayList();
    private a f;

    public aw(Context context, a aVar, View view) {
        this.a = context;
        this.f = aVar;
        this.b = LayoutInflater.from(this.a).inflate(R.layout.weather_zs_detail, null);
        b();
    }

    public static void a(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(listView.getWidth(), 0);
            View view = null;
            int i = 0;
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                view = adapter.getView(i2, view, listView);
                if (i2 == 0) {
                    view.setLayoutParams(new LayoutParams(makeMeasureSpec, -2));
                }
                view.measure(makeMeasureSpec, 0);
                i += view.getMeasuredHeight();
            }
            LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i;
            listView.setLayoutParams(layoutParams);
            listView.requestLayout();
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("zs_list");
            this.e.clear();
            if (jSONArray.length() > 0) {
                this.c.setVisibility(0);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("list");
                    if (jSONArray2 != null && jSONArray2.length() > 0) {
                        this.e.add(jSONArray.getJSONObject(i));
                    }
                }
            } else {
                this.c.setVisibility(8);
            }
            this.d.notifyDataSetChanged();
            a(this.c);
        } catch (Exception e) {
            e.printStackTrace();
            this.c.setVisibility(8);
        }
    }

    private void b() {
        this.c = (ListView) this.b.findViewById(R.id.lv_zs_list);
        c();
    }

    private void c() {
        this.d = new ax(this);
        this.c.setAdapter(this.d);
        this.c.setOnTouchListener(new ay(this));
    }

    public View a() {
        return this.b;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        Boolean valueOf = Boolean.valueOf(j.i(this.a));
        if (valueOf.booleanValue()) {
            try {
                String str7 = "com.taobao.taobao";
                if ("taobao".equals(str6) && j.a(this.a, "com.taobao.taobao") && aj.b(this.a, "com.taobao.taobao") >= 123) {
                    this.f.a(16, new ba(this, str));
                } else {
                    this.f.a(5, new bb(this, str, str2, str3, str4, str5));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (!valueOf.booleanValue()) {
            e.a(this.a, (CharSequence) "网络貌似不给力哦~", 0);
        }
    }

    public void a(JSONArray jSONArray, LinearLayout linearLayout, Context context, int i, String str) {
        int i2;
        View linearLayout2 = new LinearLayout(context);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
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
                    View inflate = LayoutInflater.from(this.a).inflate(i, null);
                    String string2 = jSONObject.getString("html");
                    String string3 = jSONObject.getString("desc");
                    String string4 = jSONObject.getString("type");
                    String optString = jSONObject.optString("sub_type");
                    inflate.setBackgroundResource(R.drawable.weather_indexitem_selector);
                    inflate.setOnClickListener(new az(this, str, string4, string2, string3, optString));
                    RecyclingImageView recyclingImageView = (RecyclingImageView) inflate.findViewById(R.id.weatherindeximage);
                    TextView textView = (TextView) inflate.findViewById(R.id.weather_indexbottomline);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.weather_indexname);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.weather_indexrightline);
                    ((TextView) inflate.findViewById(R.id.weather_indexdes)).setText(jSONObject.getString("title"));
                    textView2.setText(jSONObject.getString("desc"));
                    if (!(string == null || string.equals(""))) {
                        recyclingImageView.a(string, 2, 13);
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
                    int a = (int) ((((float) l.a()) - this.a.getResources().getDimension(R.dimen.t_market_album_margin_2)) / 2.0f);
                    LayoutParams layoutParams = new LayoutParams(a, (int) (((double) a) / 3.0d));
                    inflate.setLayoutParams(layoutParams);
                    view.addView(inflate);
                    if (view.getChildCount() == 2) {
                        linearLayout.addView(view);
                        linearLayout2 = null;
                        try {
                            view = new LinearLayout(context);
                        } catch (JSONException e) {
                            i2 = i4;
                            i3++;
                            i4 = i2;
                            view = linearLayout2;
                        } catch (Exception e2) {
                            i2 = i4;
                            i3++;
                            i4 = i2;
                            view = linearLayout2;
                        }
                        try {
                            view.setGravity(17);
                            view.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                            view.setOrientation(0);
                            linearLayout2 = view;
                        } catch (JSONException e3) {
                            linearLayout2 = view;
                            i2 = i4;
                            i3++;
                            i4 = i2;
                            view = linearLayout2;
                        } catch (Exception e4) {
                            linearLayout2 = view;
                            i2 = i4;
                            i3++;
                            i4 = i2;
                            view = linearLayout2;
                        }
                    } else {
                        linearLayout2 = view;
                    }
                    if ((jSONArray.length() - i4) % 2 == 1 && i3 == (jSONArray.length() - i4) - 1) {
                        View inflate2 = LayoutInflater.from(this.a).inflate(R.layout.weather_indexitem, null);
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

    public void a(JSONObject jSONObject, int i) {
        a(jSONObject);
    }
}
