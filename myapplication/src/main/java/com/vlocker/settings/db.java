package com.vlocker.settings;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;

class db extends BaseAdapter {
    final /* synthetic */ V2SettingToolboxActivity a;

    db(V2SettingToolboxActivity v2SettingToolboxActivity) {
        this.a = v2SettingToolboxActivity;
    }

    public int getCount() {
        return this.a.i.size();
    }

    public Object getItem(int i) {
        return this.a.i.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = View.inflate(this.a, R.layout.l_cameta_select_item, null);
        ((TextView) inflate.findViewById(R.id.camere_select_item_title)).setText(((dc) this.a.i.get(i)).a);
        ((ImageView) inflate.findViewById(R.id.camera_select_item_img)).setImageDrawable(((dc) this.a.i.get(i)).d);
        this.a.a((ImageView) inflate.findViewById(R.id.camera_select_item_check), this.a.h.bb().equals(((dc) this.a.i.get(i)).b));
        return inflate;
    }
}
