package com.vlocker.new_theme.e;

import com.vlocker.new_theme.beans.T_CateInfo;
import java.util.Comparator;

public class h implements Comparator {
    public int compare(Object obj, Object obj2) {
        T_CateInfo t_CateInfo = (T_CateInfo) obj2;
        int g = ((T_CateInfo) obj).g();
        int g2 = t_CateInfo.g();
        return g < g2 ? 1 : g > g2 ? -1 : 0;
    }
}
