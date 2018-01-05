package com.vlocker.settings;

import android.content.Context;
import android.content.Intent;

class at implements Runnable {
    private Context a;
    private int b;
    private int c;

    public at(Context context, int i, int i2) {
        this.a = context;
        this.b = i2;
        this.c = i;
    }

    public void run() {
        try {
            Intent intent = new Intent(this.a, GuideWindowActivity.class);
            intent.putExtra("systype", this.c);
            intent.putExtra("view_res_id", this.b);
            intent.addFlags(268435456);
            this.a.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
