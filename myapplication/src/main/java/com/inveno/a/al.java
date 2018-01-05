package com.inveno.a;

abstract class al implements Comparable {
    private Integer a;

    al() {
    }

    public int a(al alVar) {
        return b() == alVar.b() ? this.a.intValue() - alVar.a.intValue() : alVar.b() - b();
    }

    abstract void a();

    public final void a(int i) {
        this.a = Integer.valueOf(i);
    }

    protected int b() {
        return 2;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return a((al) obj);
    }
}
