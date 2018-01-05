package com.vlocker.msg;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.vlocker.battery.clean.y;
import com.vlocker.locker.R;
import com.vlocker.msg.b.a;
import com.vlocker.msg.b.b;
import com.vlocker.msg.b.c;
import com.vlocker.msg.b.d;
import com.vlocker.msg.b.e;
import com.vlocker.msg.b.f;
import com.vlocker.msg.b.g;
import com.vlocker.msg.b.h;
import com.vlocker.msg.b.i;
import com.vlocker.msg.b.j;
import com.vlocker.msg.b.k;
import com.vlocker.msg.b.l;
import com.vlocker.msg.b.n;
import com.vlocker.msg.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class m extends BaseAdapter {
    int a;
    private ArrayList b = new ArrayList();
    private Context c;
    private a d;
    private p e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private ListView l;
    private float m;
    private int n;
    private OnTouchListener o = new n(this);

    public m(Context context, p pVar, ListView listView) {
        this.c = context;
        this.e = pVar;
        this.l = listView;
        Resources resources = this.c.getResources();
        this.f = resources.getString(R.string.notify_time_day);
        this.g = resources.getString(R.string.notify_time_hour);
        this.h = resources.getString(R.string.notify_time_minute);
        this.i = resources.getString(R.string.notify_time_pre);
        this.j = resources.getString(R.string.notify_time_just);
        this.k = (int) this.c.getResources().getDimension(R.dimen.l_msg_item_height);
        this.n = context.getResources().getDisplayMetrics().widthPixels;
        this.m = 0.49115f * ((float) this.n);
    }

    private void b(ak akVar) {
        this.d.n = 7;
        this.d.l.setOnTouchListener(this.o);
        this.d.k.setOnTouchListener(this.o);
        this.d.g.setText(this.d.a(akVar.g));
        this.d.h.setTag(akVar.b);
    }

    private View c(ak akVar) {
        this.d = new b(this.c);
        return ((b) this.d).b(akVar);
    }

    public ArrayList a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ak akVar = (ak) it.next();
            if (akVar.j != null && akVar.j.equals("vlocker.MyWeather")) {
                Object obj;
                for (String endsWith : strArr) {
                    if (endsWith.endsWith(akVar.p)) {
                        obj = null;
                        break;
                    }
                }
                int i = 1;
                if (obj != null) {
                    arrayList.add(akVar);
                }
            }
        }
        if (arrayList.size() > 0) {
            this.b.removeAll(arrayList);
            arrayList.clear();
            notifyDataSetChanged();
        }
        return arrayList;
    }

    public void a() {
        Object arrayList = new ArrayList();
        arrayList.clear();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ak akVar = (ak) it.next();
            if (akVar.j != null && akVar.j.equals("vlocker.MyWeather")) {
                arrayList.add(akVar);
            }
        }
        if (arrayList.size() > 0) {
            this.b.removeAll(arrayList);
            arrayList.clear();
            notifyDataSetChanged();
        }
    }

    public void a(ak akVar) {
        if (akVar == null || akVar.b == null || !akVar.b.startsWith(this.c.getPackageName())) {
            Collection arrayList = new ArrayList();
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ak akVar2 = (ak) it.next();
                if (akVar2.j != null && akVar2.j.equals(akVar.j) && akVar2.F == -1) {
                    arrayList.add(akVar2);
                }
            }
            this.b.removeAll(arrayList);
            this.b.add(akVar);
            String g = com.vlocker.c.a.a(this.c).g();
            int i = 0;
            while (i < this.b.size()) {
                if (((ak) this.b.get(i)).b.equals(g) && i > 1) {
                    this.b.add(0, this.b.get(i));
                    this.b.remove(i + 1);
                    break;
                }
                i++;
            }
            notifyDataSetChanged();
            return;
        }
        this.b.add(0, akVar);
        notifyDataSetChanged();
    }

    public void a(String str) {
        Object obj;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ak akVar = (ak) it.next();
            if (str.equals(akVar.b)) {
                this.b.remove(akVar);
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            notifyDataSetChanged();
        }
    }

    public void a(String str, int i) {
        Collection arrayList = new ArrayList();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ak akVar = (ak) it.next();
            if (akVar.b.startsWith(this.c.getPackageName())) {
                if (str == null || str.isEmpty()) {
                    if (!akVar.E) {
                        arrayList.add(akVar);
                    }
                } else if (akVar.b.equals(str) || as.b(akVar.b) == i) {
                    arrayList.add(akVar);
                }
            } else if (akVar.b.contains("red_packet") && !akVar.E) {
                arrayList.add(akVar);
            }
        }
        if (arrayList.size() > 0) {
            this.b.removeAll(arrayList);
            notifyDataSetChanged();
        }
        Log.e("liu---", "removeSpecialData data=" + this.b);
    }

    public void a(ArrayList arrayList) {
        Collection arrayList2 = new ArrayList();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ak akVar = (ak) it.next();
            if (akVar.b.startsWith(this.c.getPackageName()) || akVar.b.contains("red_packet") || akVar.b.equals("url") || akVar.b.equals("app") || akVar.b.equals("mad") || akVar.b.equals("ade") || akVar.b.equals("mx_ad") || akVar.b.equals("mx_clean") || akVar.b.equals("weather_news") || akVar.b.equals("mx_update")) {
                arrayList2.add(akVar);
            }
        }
        this.b.clear();
        this.b.addAll(arrayList);
        if (arrayList2.size() > 0) {
            this.b.addAll(arrayList2);
        }
        String g = com.vlocker.c.a.a(this.c).g();
        int i = 0;
        while (i < this.b.size()) {
            if (((ak) this.b.get(i)).b.equals(g) && i > 1) {
                this.b.add(0, this.b.get(i));
                this.b.remove(i + 1);
                break;
            }
            i++;
        }
        notifyDataSetChanged();
    }

    public ak b(String str) {
        Log.e("liu---", "getSpecialMsg data=" + this.b);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ak akVar = (ak) it.next();
            if (akVar.b.equals(str)) {
                return akVar;
            }
        }
        return null;
    }

    public void b() {
        Collection arrayList = new ArrayList();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ak akVar = (ak) it.next();
            if (akVar.b.startsWith(this.c.getPackageName()) && akVar.E) {
                arrayList.add(akVar);
            }
        }
        this.b.clear();
        if (arrayList.size() > 0) {
            this.b.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public int c() {
        return this.b.size();
    }

    public boolean d() {
        if (this.b == null) {
            return false;
        }
        int i = 0;
        while (i < this.b.size()) {
            if (getItemViewType(i) == 9 || getItemViewType(i) == 10) {
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean e() {
        if (this.b == null) {
            return false;
        }
        for (int i = 0; i < this.b.size(); i++) {
            if (getItemViewType(i) == 10) {
                return true;
            }
        }
        return false;
    }

    public int getCount() {
        if (this.b.size() != this.a) {
            this.a = this.b.size();
            if (this.a > 0) {
                this.e.g();
            } else {
                this.e.f();
            }
        }
        return this.b.size();
    }

    public Object getItem(int i) {
        return this.b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return ((ak) this.b.get(i)).C;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int size = this.b.size();
        ak akVar = (size <= 0 || i >= size) ? null : (ak) this.b.get(i);
        if (akVar == null) {
            return null;
        }
        switch (getItemViewType(i)) {
            case 1:
                if (view != null) {
                    this.d = (a) view.getTag();
                    break;
                }
                this.d = new h(this.c);
                view = this.d.a();
                break;
            case 2:
                if (view != null) {
                    this.d = (a) view.getTag();
                    break;
                }
                this.d = new g(this.c);
                view = this.d.a();
                break;
            case 3:
                if (view != null) {
                    this.d = (a) view.getTag();
                    break;
                }
                this.d = new f(this.c);
                view = this.d.a();
                break;
            case 4:
                if (view != null) {
                    this.d = (a) view.getTag();
                    break;
                }
                this.d = new com.vlocker.msg.b.m(this.c);
                view = this.d.a();
                break;
            case 5:
                if (view != null) {
                    this.d = (a) view.getTag();
                    break;
                }
                this.d = new o(this.c);
                view = this.d.a();
                break;
            case 6:
                if (view != null) {
                    this.d = (a) view.getTag();
                    break;
                }
                this.d = new k(this.c);
                view = this.d.a();
                break;
            case 7:
                if (view == null) {
                    this.d = new j(this.c);
                    view = this.d.a();
                } else {
                    this.d = (a) view.getTag();
                }
                b(akVar);
                break;
            case 8:
                if (view != null) {
                    this.d = (a) view.getTag();
                    break;
                }
                this.d = new i(this.c);
                view = this.d.a();
                break;
            case 9:
                if (view != null) {
                    this.d = (a) view.getTag();
                    if (!("url".equals(this.d.u) && (akVar.y || akVar.z)) && (!"app".equals(this.d.u) || akVar.y || akVar.z)) {
                        view = c(akVar);
                        break;
                    }
                }
                view = c(akVar);
                break;
            case 10:
                view = y.a().i();
                this.d = new c(this.c);
                this.d.n = 10;
                this.d.h = view.findViewById(R.id.l_msg_pkg);
                this.d.h.setTag(akVar.b);
                view.setTag(this.d);
                break;
            case 11:
                if (view != null) {
                    this.d = (a) view.getTag();
                    break;
                }
                this.d = new n(this.c);
                view = this.d.a();
                break;
            case 12:
                if (view != null) {
                    this.d = (a) view.getTag();
                    break;
                }
                this.d = new e(this.c);
                view = this.d.a();
                break;
            case 13:
                if (view != null) {
                    this.d = (a) view.getTag();
                    break;
                }
                this.d = new l(this.c);
                view = this.d.a();
                break;
            default:
                if (view != null) {
                    this.d = (a) view.getTag();
                    break;
                }
                this.d = new d(this.c);
                view = this.d.a();
                break;
        }
        if (this.d == null) {
            return view;
        }
        this.d.a((Object) akVar);
        this.d.c();
        return view;
    }

    public int getViewTypeCount() {
        return 14;
    }
}
