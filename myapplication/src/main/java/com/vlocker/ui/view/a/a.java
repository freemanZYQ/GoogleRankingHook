package com.vlocker.ui.view.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.vlocker.locker.R;
import com.vlocker.m.y;
import java.util.ArrayList;
import java.util.List;

public class a extends BaseAdapter {
    public static final int a = VERSION.SDK_INT;
    private Context b;
    private List c = new ArrayList();
    private SparseBooleanArray d = new SparseBooleanArray();

    public a(Context context, int i) {
        this.b = context;
        b(i);
    }

    public static int a(Context context, String str) {
        int i = -1;
        SharedPreferences sharedPreferences = context.getSharedPreferences("vlocker.launcher.main.menu.preferences", com.vlocker.c.a.a());
        int i2 = 0;
        if ("selected_position".equals(str)) {
            i2 = -1;
        }
        if ("selected_color".equals(str)) {
            i2 = y.g(context);
        }
        if ("switch_selected_position".equals(str)) {
            i2 = -1;
        }
        if ("switch_selected_color".equals(str)) {
            i2 = a >= 8 ? y.g(context) : -1;
        }
        if ("weather_selected_position".equals(str)) {
            i2 = -1;
        }
        if ("weather_selected_color".equals(str)) {
            i2 = a >= 8 ? y.g(context) : -1;
        }
        if ("baidu_selected_position".equals(str)) {
            i2 = -1;
        }
        if ("baidu_selected_color".equals(str)) {
            i2 = a >= 8 ? y.g(context) : -1;
        }
        if ("digit_selected_position".equals(str)) {
            i2 = -1;
        }
        if (!"digit_selected_color".equals(str)) {
            i = i2;
        } else if (a >= 8) {
            i = y.g(context);
        }
        return sharedPreferences.getInt(str, i);
    }

    private void b(int i) {
        int i2;
        this.c = new ArrayList();
        this.c.clear();
        r4 = new String[10][];
        r4[0] = new String[]{"704997", "515daa", "5bbecd", "89cda6", "fdcefc", "fefccd"};
        r4[1] = new String[]{"000000", "434343", "666666", "999999", "CCCCCC", "FFFFFF"};
        r4[2] = new String[]{"A46A21", "CF8933", "EAA041", "FFBC6B", "FFD6A2", "FFE6C7"};
        r4[3] = new String[]{"AA8831", "D5AE49", "F2C960", "FCDA83", "FCE8B3", "FEF1D1"};
        r4[4] = new String[]{"74aa3a", "8fcb48", "b8e964", "c2f58f", "d8f0a8", "e6f8c8"};
        r4[5] = new String[]{"1A764D", "2A9C68", "3DC789", "68DFA9", "A0EAC9", "C6F3DE"};
        r4[6] = new String[]{"1C4587", "285BAC", "3C78D8", "6D9EEB", "A4C2F4", "C9DAF8"};
        r4[7] = new String[]{"41236D", "653E9B", "8E63CE", "B694E8", "D0BCF1", "E4D7F5"};
        r4[8] = new String[]{"83334C", "B65775", "E07798", "F7A7C0", "FBC8D9", "FCDEE8"};
        r4[9] = new String[]{"822111", "AC2B16", "CC3A21", "E66550", "EFA093", "F6C5BE"};
        for (i2 = 0; i2 < r4.length; i2++) {
            for (String str : r4[i2]) {
                this.c.add(Integer.valueOf(Color.parseColor("#" + str)));
            }
        }
        int a = a(this.b, "switch_selected_position");
        i2 = 0;
        while (i2 < this.c.size()) {
            this.d.put(i2, i2 == a);
            i2++;
        }
    }

    public int a(int i) {
        return ((Integer) this.c.get(i)).intValue();
    }

    public SparseBooleanArray a() {
        return this.d;
    }

    public int getCount() {
        return this.c.isEmpty() ? 0 : this.c.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b(this);
            view = View.inflate(this.b, R.layout.l_vlocker_font_color_settings_item, null);
            bVar.a = (ImageView) view.findViewById(R.id.font_color_iv);
            bVar.b = (ImageView) view.findViewById(R.id.font_color_selected_iv);
            bVar.b.setBackgroundResource(R.drawable.l_msg_app_select_checkbox_selected);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.a.setBackgroundColor(((Integer) this.c.get(i)).intValue());
        bVar.b.setVisibility(a().get(i) ? 0 : 4);
        return view;
    }
}
