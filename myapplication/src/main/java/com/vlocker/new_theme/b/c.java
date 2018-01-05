package com.vlocker.new_theme.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.new_theme.activity.CategoryItemActivity;
import com.vlocker.new_theme.beans.T_CateInfo;
import com.vlocker.theme.c.a;

class c implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ b b;

    c(b bVar, int i) {
        this.b = bVar;
        this.a = i;
    }

    public void onClick(View view) {
        try {
            System.gc();
            Object obj = (T_CateInfo) this.b.b.get(this.a);
            Bundle bundle = new Bundle();
            bundle.putInt("from", 1);
            bundle.putInt("position", this.a);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            a.b().a(obj);
            intent.setClass(this.b.a, CategoryItemActivity.class);
            this.b.a.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
