package com.xinmei365.fontsdk.download;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b {
    private static HashMap k = new HashMap();
    private Context context;
    private List g = new ArrayList();
    private LinkedList h = new LinkedList();
    private List i = new ArrayList();
    private List j = new ArrayList();
    private a l;

    public class a {
        private int m;
        private String type;

        public a(String str, int i) {
            this.m = i;
            this.type = str;
        }
    }

    interface b {
        void g(d dVar);

        void h(d dVar);
    }

    class c implements DownloadListener {
        final /* synthetic */ b n;

        private c(b bVar) {
            this.n = bVar;
        }

        public void canceled(DownloadInfo downloadInfo) {
            d d = this.n.d(downloadInfo.getUrlStr());
            if (d != null) {
                this.n.f(d);
            }
        }

        public void failed(DownloadInfo downloadInfo, int i) {
            d d = this.n.d(downloadInfo.getUrlStr());
            if (d != null) {
                this.n.f(d);
            }
        }

        public void paused(DownloadInfo downloadInfo) {
            d d = this.n.d(downloadInfo.getUrlStr());
            if (d != null && this.n.i.contains(this.n.d(downloadInfo.getUrlStr()))) {
                this.n.i.remove(d);
            }
            this.n.a();
        }

        public void prepared(DownloadInfo downloadInfo) {
        }

        public void processing(DownloadInfo downloadInfo) {
        }

        public void successed(DownloadInfo downloadInfo) {
            d d = this.n.d(downloadInfo.getUrlStr());
            if (d != null) {
                this.n.f(d);
            }
        }

        public void waited(DownloadInfo downloadInfo) {
        }
    }

    private b(Context context, a aVar) {
        this.context = context;
        this.l = aVar;
        c.b().c(context);
        g.n().c(context);
    }

    public static b a(Context context, a aVar) {
        if (aVar == null) {
            aVar = new a("font", 5);
        }
        if (!k.containsKey(aVar.type) || k.get(aVar.type) == null) {
            synchronized (b.class) {
                k.put(aVar.type, new b(context, aVar));
            }
        }
        return (b) k.get(aVar.type);
    }

    private synchronized void a() {
        if (this.h.size() > 0 && this.i.size() < this.l.m) {
            d dVar = (d) this.h.removeFirst();
            if (!this.i.contains(dVar)) {
                this.i.add(dVar);
            }
            dVar.start();
        }
    }

    public static b b(Context context) {
        return a(context, null);
    }

    private synchronized void b(d dVar) {
        if (c(dVar)) {
            Iterator it = this.h.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (dVar.getPriority() >= ((d) it.next()).getPriority()) {
                    break;
                }
                i++;
            }
            if (!this.h.contains(dVar)) {
                this.h.add(i, dVar);
            }
        }
    }

    private boolean c(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.g.contains(dVar)) {
            return true;
        }
        throw new RuntimeException("This downloader was deprecated, you cannot do anything for it!!!!");
    }

    private synchronized void f(d dVar) {
        if (this.i.contains(dVar)) {
            this.i.remove(dVar);
        }
        if (this.g.contains(dVar)) {
            this.g.remove(dVar);
        }
        if (this.h.contains(dVar)) {
            this.h.remove(dVar);
        }
    }

    public d a(String str, String str2) {
        d d = d(str);
        if (d != null) {
            return d;
        }
        d dVar = new d(str, str2);
        dVar.b(new c());
        this.g.add(dVar);
        for (int i = 0; i < this.j.size(); i++) {
            ((b) this.j.get(i)).g(dVar);
        }
        return dVar;
    }

    public final void a(d dVar) {
        dVar.d().setStatus(0);
        b(dVar);
        a();
    }

    public d d(String str) {
        if (str != null) {
            for (int i = 0; i < this.g.size(); i++) {
                if (str.equals(((d) this.g.get(i)).d().getUrlStr())) {
                    return (d) this.g.get(i);
                }
            }
        }
        return null;
    }

    public final void d(d dVar) {
        if (c(dVar)) {
            dVar.cancel();
            for (int i = 0; i < this.j.size(); i++) {
                ((b) this.j.get(i)).h(dVar);
            }
        }
    }

    public final void e(d dVar) {
        if (c(dVar)) {
            if (this.i != null && this.i.size() > 0) {
                this.i.remove(dVar);
            }
            dVar.pause();
        }
    }
}
