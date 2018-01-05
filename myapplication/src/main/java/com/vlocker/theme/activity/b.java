package com.vlocker.theme.activity;

import com.vlocker.theme.model.a;
import java.util.Comparator;

class b implements Comparator {
    final /* synthetic */ LocationThemeActivity a;

    b(LocationThemeActivity locationThemeActivity) {
        this.a = locationThemeActivity;
    }

    public int a(a aVar, a aVar2) {
        long a = aVar.a();
        long a2 = aVar2.a();
        return a == a2 ? 0 : a < a2 ? 1 : -1;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((a) obj, (a) obj2);
    }
}
