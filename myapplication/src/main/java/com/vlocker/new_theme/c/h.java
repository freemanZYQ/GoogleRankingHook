package com.vlocker.new_theme.c;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.new_theme.b.b;
import java.lang.ref.WeakReference;

class h extends Handler {
    WeakReference a;
    final /* synthetic */ f b;
    private GridView c;
    private b d;

    h(f fVar, Activity activity) {
        this.b = fVar;
        this.a = new WeakReference(activity);
    }

    public void handleMessage(Message message) {
        try {
            switch (message.what) {
                case 264:
                    TextView textView = (TextView) this.b.ab.findViewById(R.id.theme_fetch_loading);
                    ((ImageView) this.b.ab.findViewById(R.id.theme_fetch_loading_imageView1)).setVisibility(0);
                    textView.setText(R.string.t_market_listloading_fail);
                    this.b.ac.setOnClickListener(new i(this));
                    return;
                case 265:
                    try {
                        this.b.ac.setVisibility(8);
                        this.c = (GridView) this.b.ab.findViewById(R.id.main_homecate_listview);
                        this.d = new b(this.b.c(), this.b.aa);
                        this.c.setAdapter(this.d);
                        this.d.notifyDataSetChanged();
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        e2.printStackTrace();
    }
}
