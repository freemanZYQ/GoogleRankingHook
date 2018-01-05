package com.vlocker.ui.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.vlocker.j.a.f;
import com.vlocker.locker.R;

class k extends BaseAdapter {
    final /* synthetic */ MusicLrcView a;

    k(MusicLrcView musicLrcView) {
        this.a = musicLrcView;
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
        n nVar;
        if (view == null) {
            view = View.inflate(this.a.getContext(), R.layout.music_lrc_item_little_layout, null);
            n nVar2 = new n(this.a);
            nVar2.a = (TextView) view.findViewById(R.id.tv_item);
            view.setTag(nVar2);
            nVar = nVar2;
        } else {
            nVar = (n) view.getTag();
        }
        nVar.a.setTextColor(this.a.D ? this.a.getResources().getColor(R.color.msg_content_light) : this.a.getResources().getColor(R.color.msg_content_dark));
        if (this.a.i == null || this.a.i.size() <= 0 || i >= this.a.i.size()) {
            nVar.a.setText("");
        } else {
            nVar.a.setText(((f) this.a.i.get(i)).b());
        }
        return view;
    }
}
