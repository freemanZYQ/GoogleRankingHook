package com.baidu.mobads.j;

import java.io.File;

class h implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ g b;

    h(g gVar, String str) {
        this.b = gVar;
        this.a = str;
    }

    public void run() {
        String[] list = new File(this.a).list();
        if (list != null && list.length > 0) {
            for (String file : list) {
                File file2 = new File(file);
                long currentTimeMillis = System.currentTimeMillis() - file2.lastModified();
                if (file2.exists() && currentTimeMillis > 604800000) {
                    file2.delete();
                }
            }
        }
    }
}
