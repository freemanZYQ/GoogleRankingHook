package com.vlocker.setting.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.setting.a.a.e;
import java.util.ArrayList;
import java.util.List;

public class a extends BaseAdapter {
    private List a = new ArrayList();
    private Context b = null;

    public a(Context context) {
        this.b = context;
    }

    public e a(int i) {
        return (e) this.a.get(i);
    }

    public synchronized void a(List list) {
        if (list != null) {
            this.a.clear();
            for (int i = 0; i < list.size(); i++) {
                e eVar = (e) list.get(i);
                if (!(eVar == null || TextUtils.isEmpty(eVar.getTaskName()))) {
                    this.a.add(eVar);
                }
            }
        }
    }

    public int getCount() {
        return this.a.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.manual_repair_item, viewGroup, false);
            b bVar2 = new b(this);
            bVar2.a = (TextView) view.findViewById(R.id.manual_repair_task_name);
            bVar2.b = (TextView) view.findViewById(R.id.manual_repair_task_desc);
            bVar2.c = (TextView) view.findViewById(R.id.manual_repair_task_finish);
            bVar2.e = (Button) view.findViewById(R.id.manual_repair_task_set);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        e a = a(i);
        if (a != null) {
            bVar.a.setText(a.getTaskName());
            if (a.getDes() != null) {
                bVar.b.setText(a.getDes());
            }
            bVar.a(a, i);
        }
        return view;
    }
}
