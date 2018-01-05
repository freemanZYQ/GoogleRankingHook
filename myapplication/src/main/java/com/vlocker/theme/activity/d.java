package com.vlocker.theme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.vlocker.theme.model.a;

class d implements OnItemClickListener {
    final /* synthetic */ LocationThemeActivity a;

    d(LocationThemeActivity locationThemeActivity) {
        this.a = locationThemeActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.a.j == 0) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            intent.setClass(this.a, ThemeDetailActivity.class);
            bundle.putString("tag", "locklocaltheme");
            if (i == 0) {
                bundle.putString("filePath", "default");
            } else {
                bundle.putString("filePath", ((a) this.a.f.get(i)).c());
            }
            intent.putExtras(bundle);
            this.a.startActivityForResult(intent, 1);
            return;
        }
        ((a) this.a.f.get(i)).a(!((a) this.a.f.get(i)).b());
        this.a.b();
        this.a.e.a(view, i);
    }
}
