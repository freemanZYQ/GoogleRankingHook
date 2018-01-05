package com.vlocker.l;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.settings.dc;

class m extends BaseAdapter {
    final /* synthetic */ j a;

    m(j jVar) {
        this.a = jVar;
    }

    public int getCount() {
        return this.a.w.size();
    }

    public Object getItem(int i) {
        return this.a.w.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ai aiVar;
        if (view == null) {
            aiVar = new ai(this.a);
            view = View.inflate(this.a.b, R.layout.l_toolbox_item, null);
            view.setLayoutParams(new LayoutParams(this.a.x, -2));
            aiVar.d = (TextView) view.findViewById(R.id.tv_toolbox_item);
            aiVar.a = (ImageView) view.findViewById(R.id.btn_toolbox_item);
            aiVar.b = (ImageView) view.findViewById(R.id.close_toolbox_item);
            aiVar.c = (ImageView) view.findViewById(R.id.hint_toolbox_item);
            view.setTag(aiVar);
        } else {
            aiVar = (ai) view.getTag();
        }
        aiVar.d.setText(((dc) this.a.w.get(i)).a);
        aiVar.a.setImageDrawable(((dc) this.a.w.get(i)).d);
        if ("vlocker_flashlight".equals(((dc) this.a.w.get(i)).b)) {
            this.a.h.a(aiVar.a);
        }
        if (!"vlocker_boost".equals(((dc) this.a.w.get(i)).b) || a.a(this.a.b).al()) {
            aiVar.c.setVisibility(8);
        } else {
            aiVar.c.setVisibility(0);
        }
        return view;
    }
}
