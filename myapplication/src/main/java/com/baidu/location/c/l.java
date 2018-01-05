package com.baidu.location.c;

import java.util.Comparator;
import java.util.Map.Entry;

class l implements Comparator {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public int a(Entry entry, Entry entry2) {
        return ((Integer) entry2.getValue()).compareTo((Integer) entry.getValue());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((Entry) obj, (Entry) obj2);
    }
}
