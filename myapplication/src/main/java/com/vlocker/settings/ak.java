package com.vlocker.settings;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.m.a.e;
import com.vlocker.m.ax;
import java.lang.reflect.Array;
import java.util.Vector;

class ak extends BaseAdapter {
    Context a;
    final /* synthetic */ GuideSettingListActivity b;
    private String[][] c = ((String[][]) null);

    public ak(GuideSettingListActivity guideSettingListActivity, Context context) {
        this.b = guideSettingListActivity;
        this.a = context;
        a();
    }

    private void a() {
        int i = 0;
        Vector vector = new Vector();
        try {
            String str = Build.DEVICE;
            String str2 = Build.MODEL;
            if (str != null) {
                if (str.toLowerCase().contains("mx3".toLowerCase())) {
                    vector.add(new String[]{"", "MX3系统"});
                } else if (str.toLowerCase().contains("mx4".toLowerCase())) {
                    vector.add(new String[]{"", "MX4系统"});
                }
            }
            if (str2 != null) {
                if (str2.toLowerCase().contains("vivo x".toLowerCase())) {
                    vector.add(new String[]{"", "vivoX系列系统"});
                } else if (str2.toLowerCase().contains("vivo y".toLowerCase())) {
                    vector.add(new String[]{"", "vivoY系列系统"});
                }
            }
            if (e.c(this.b)) {
                vector.add(new String[]{"", "华为系统"});
            }
        } catch (Exception e) {
        }
        try {
            String[][] strArr = ax.c;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (j.b(this.a, strArr[i2][0])) {
                    vector.add(strArr[i2]);
                }
            }
            if (vector.size() > 0) {
                this.c = (String[][]) Array.newInstance(String.class, new int[]{vector.size(), 2});
                while (i < vector.size()) {
                    this.c[i] = (String[]) vector.elementAt(i);
                    i++;
                }
            }
        } catch (Exception e2) {
        }
    }

    public String a(int i) {
        String str = null;
        try {
            if (this.c != null) {
                str = this.c[i][1];
            }
        } catch (Exception e) {
        }
        return str;
    }

    public int getCount() {
        return this.c != null ? this.c.length : 0;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        al alVar;
        if (view == null) {
            al alVar2 = new al(this);
            view = View.inflate(this.a, R.layout.l_guid_list_item, null);
            alVar2.a = (TextView) view.findViewById(R.id.l_guide_list_tv_title1);
            alVar2.b = (ImageView) view.findViewById(R.id.l_guide_list_iv1);
            view.setTag(alVar2);
            alVar = alVar2;
        } else {
            alVar = (al) view.getTag();
        }
        try {
            alVar.a.setText(this.c[i][1]);
        } catch (Exception e) {
        }
        return view;
    }
}
