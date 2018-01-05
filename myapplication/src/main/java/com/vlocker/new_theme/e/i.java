package com.vlocker.new_theme.e;

import com.vlocker.new_theme.beans.e;
import java.util.Comparator;

public class i implements Comparator {
    public int compare(Object obj, Object obj2) {
        e eVar = (e) obj2;
        int a = ((e) obj).a();
        int a2 = eVar.a();
        return a < a2 ? 1 : a > a2 ? -1 : 0;
    }
}
