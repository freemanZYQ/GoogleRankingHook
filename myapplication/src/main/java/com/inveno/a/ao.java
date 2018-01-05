package com.inveno.a;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

class ao {
    private int a;
    private Queue b;
    private HashMap c = new HashMap();

    ao(int i) {
        this.a = i;
        this.b = new LinkedBlockingDeque(i);
    }

    Object a() {
        Object poll = this.b.poll();
        if (poll != null) {
            this.c.remove(Integer.valueOf(poll.hashCode()));
        }
        return poll;
    }

    boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        if (b() == this.a) {
            a();
        }
        this.c.put(Integer.valueOf(obj.hashCode()), obj);
        return this.b.offer(obj);
    }

    int b() {
        return this.b.size();
    }

    void c() {
        this.b.clear();
        this.c.clear();
    }

    public String toString() {
        if (this.b.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object obj : this.b) {
            stringBuilder.append(obj.toString());
            stringBuilder.append("#");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
