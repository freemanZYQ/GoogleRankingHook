package com.vlocker.theme.activity;

import android.os.Handler;
import android.os.Message;
import com.vlocker.locker.R;

class a extends Handler {
    final /* synthetic */ LocationThemeActivity a;

    a(LocationThemeActivity locationThemeActivity) {
        this.a = locationThemeActivity;
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            if (this.a.j == 0) {
                this.a.i.setTextColor(this.a.getResources().getColor(R.color.gray));
                this.a.i.setClickable(false);
            } else {
                this.a.i.setTextColor(this.a.getResources().getColor(R.color.textColorPrimary));
                this.a.i.setClickable(true);
            }
        } else if (message.what == 2 && this.a.j == 0) {
            this.a.i.setTextColor(this.a.getResources().getColor(R.color.textColorPrimary));
        }
        this.a.f.clear();
        this.a.e.notifyDataSetChanged();
        this.a.f.addAll(this.a.g);
        this.a.f.addAll(this.a.h);
        this.a.a(this.a.f);
        this.a.e.notifyDataSetChanged();
        this.a.b();
        this.a.k.setVisibility(8);
    }
}
