package com.vlocker.search;

import android.content.Context;
import com.moxiu.b.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class z {
    public static void a(Context context, List list) {
        Collection arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        for (a aVar : list) {
            int i = aVar.U;
            if (i == 6) {
                arrayList.add(aVar);
            } else if (i == 7) {
                arrayList2.add(aVar);
            }
        }
        x.a(context).a.clear();
        x.a(context).a.addAll(arrayList);
        x.a(context).b.clear();
        x.a(context).b.addAll(arrayList2);
    }
}
