package com.vlocker.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import java.util.ArrayList;
import java.util.HashMap;

public class g extends BaseAdapter {
    public ArrayList a;
    private Context b;
    private d c;
    private int d = -1;
    private boolean e;
    private HashMap f = new HashMap();

    public g(Context context, ArrayList arrayList, boolean z) {
        this.b = context;
        this.a = arrayList;
        this.e = z;
    }

    public HashMap a() {
        return this.f;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(int i, Boolean bool) {
        this.f.put(Integer.valueOf(i), bool);
    }

    public void a(boolean z) {
        for (int i = 0; i < this.a.size(); i++) {
            this.f.put(Integer.valueOf(i), Boolean.valueOf(a.a(this.b).s(((e) this.a.get(i)).b().a())));
        }
    }

    public int b() {
        int size = this.f.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = ((Boolean) this.f.get(Integer.valueOf(i))).booleanValue() ? i2 + 1 : i2;
            i++;
            i2 = i3;
        }
        return i2;
    }

    public int c() {
        return this.d;
    }

    public int getCount() {
        return this.a.isEmpty() ? 0 : this.a.size();
    }

    public Object getItem(int i) {
        return this.a != null ? this.a.get(i) : null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a b = ((e) this.a.get(i)).b();
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.l_msg_app_select_letter_sort_item, null);
            this.c = new d();
            this.c.a = (ImageView) view.findViewById(R.id.vlocker_dialog_app_icon);
            this.c.c = (TextView) view.findViewById(R.id.vlocker_dialog_app_name);
            this.c.b = (CheckBox) view.findViewById(R.id.vlocker_dialog_app_check);
            view.setTag(this.c);
        } else {
            this.c = (d) view.getTag();
        }
        this.c.a.setImageDrawable(b.c());
        this.c.c.setText(b.b());
        if (this.e) {
            this.c.b.setChecked(((Boolean) a().get(Integer.valueOf(i))).booleanValue());
        } else {
            this.c.b.setChecked(false);
        }
        return view;
    }
}
