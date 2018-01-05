package com.vlocker.new_theme.c;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.vlocker.new_theme.activity.SpecialSingleItemActivity;
import com.vlocker.new_theme.beans.T_SpecialThemeInfo;
import com.vlocker.theme.c.a;

class d implements OnItemClickListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2 = i + 1;
        Intent intent = new Intent(this.a.c(), SpecialSingleItemActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("from", "home");
        bundle.putInt("position", i2);
        bundle.putString("special_title", ((T_SpecialThemeInfo) a.b().b(String.valueOf(8201)).a().get(i2 - 1)).c());
        intent.putExtras(bundle);
        this.a.c().startActivity(intent);
    }
}
