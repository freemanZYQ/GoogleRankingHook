package com.vlocker.search;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.moxiu.b.a.a;
import com.vlocker.b.j;
import com.vlocker.theme.model.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class at extends BaseAdapter {
    public ReadWriteLock a = null;
    public d b = new d();
    public List c;
    public p d = null;
    private BaiduSearchActivity e;
    private ao f;
    private boolean g = false;

    public at(BaiduSearchActivity baiduSearchActivity) {
        this.e = baiduSearchActivity;
        this.a = new ReentrantReadWriteLock(false);
        baiduSearchActivity.c = true;
        d();
    }

    private d a(List list) {
        d dVar = new d();
        this.c = new ArrayList();
        int i = 0;
        while (i < 6) {
            for (a aVar : list) {
                M_bd_BaiduNewsInfo m_bd_BaiduNewsInfo = new M_bd_BaiduNewsInfo();
                if (aVar != null && aVar.U == i) {
                    m_bd_BaiduNewsInfo.a(aVar.c());
                    m_bd_BaiduNewsInfo.a(aVar.x());
                    m_bd_BaiduNewsInfo.b(aVar.y() ? 1 : 0);
                    dVar.add(m_bd_BaiduNewsInfo);
                    this.c.add(aVar);
                    i++;
                }
            }
            i++;
        }
        z.a(this.e, list);
        return dVar;
    }

    private void a(String str, String str2) {
        new com.vlocker.new_theme.a.d().a(str, new af(), new au(this));
    }

    private void b(aw awVar) {
        d a = awVar.a();
        if (this.b == null) {
            this.b = new d();
        } else {
            this.b.clear();
        }
        int i = -1;
        Iterator it = a.iterator();
        while (it.hasNext()) {
            int i2 = i + 1;
            ac acVar = (ac) it.next();
            if ("sites".equals(acVar.b())) {
                acVar.b("吃喝玩乐");
                this.b.add(acVar);
                i = i2;
            } else if ("ade".equals(acVar.b())) {
                acVar.b("");
                this.b.add(acVar);
                i = i2;
            } else if ("starry".equals(acVar.b())) {
                acVar.b("星座运势");
                this.b.add(acVar);
                i = i2;
            } else {
                if ("his".equals(acVar.b())) {
                    acVar = e();
                    if (acVar != null) {
                        this.b.add(acVar);
                        i = i2;
                    }
                } else if ("chars".equals(acVar.b())) {
                    acVar.b("热门标签");
                    this.b.add(acVar);
                    i = i2;
                }
                i = i2;
            }
        }
        notifyDataSetChanged();
    }

    private void d() {
        if (j.s(this.e)) {
            a("http://hao.dianou.com/json.php?do=Main" + j.t(this.e), "");
        }
    }

    private ac e() {
        this.f = ao.a(this.e);
        List a = this.f.a();
        if (a == null || a.size() <= 0) {
            ac acVar = new ac();
            acVar.a("his");
            acVar.b(new ArrayList());
            return acVar;
        }
        if (a.size() > 4) {
            a = a.subList(0, 4);
        }
        ac acVar2 = new ac();
        if (a != null) {
            acVar2.b(a);
        }
        acVar2.a("his");
        return acVar2;
    }

    public void a() {
        if (this.b != null && this.b.size() > 0) {
            for (int i = 0; i < this.b.size(); i++) {
                if ("his".equals(((ac) this.b.get(i)).b())) {
                    this.b.remove(i);
                    break;
                }
            }
        }
        ac e = e();
        if (e != null) {
            this.b.add(this.b.size(), e);
        }
        notifyDataSetChanged();
    }

    public void a(aw awVar) {
        new com.b.b.a(this.e).a(com.b.d.a.b(this.e, "search_hot_words"), 50, new av(this, awVar)).a();
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && this.b != null && this.b.size() > 0) {
            for (int i = 0; i < this.b.size(); i++) {
                if (str.equals(((ac) this.b.get(i)).b())) {
                    this.b.remove(i);
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    public void b() {
    }

    public void c() {
        if (this.b != null) {
            this.b.clear();
        }
        this.b = null;
    }

    public int getCount() {
        return ap.a() ? this.b == null ? 0 : this.b.size() : this.g ? this.b != null ? this.b.size() + 1 : 0 : this.b != null ? this.b.size() : 0;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        if (this.b == null) {
            return 9;
        }
        int i2;
        if (i < this.b.size()) {
            String b = ((ac) this.b.get(i)).b();
            if ("his".equals(b)) {
                i2 = 0;
            } else if ("chars".equals(b)) {
                i2 = 1;
            } else if ("sites".equals(b)) {
                i2 = 2;
            } else if ("ade".equals(b)) {
                i2 = 3;
            } else if ("starry".equals(b)) {
                i2 = 4;
            }
            return i2;
        }
        i2 = 9;
        return i2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = 9;
        if (this.b == null || i >= this.b.size()) {
            ac acVar = null;
        } else {
            ac acVar2 = (ac) this.b.get(i);
            Object obj = acVar2;
            i2 = getItemViewType(i);
        }
        this.d = null;
        switch (i2) {
            case 0:
                if (view != null) {
                    this.d = (t) view.getTag();
                    break;
                }
                this.d = new t(this.e, this);
                break;
            case 1:
                if (view == null) {
                    this.d = new v(this.e, this);
                } else {
                    this.d = (v) view.getTag();
                }
                if (obj != null) {
                    List a = obj.a();
                    if (a != null && a.size() >= 6) {
                        this.d.b(a);
                        break;
                    }
                }
                break;
            case 2:
                if (view == null) {
                    this.d = new ax(this.e, this);
                } else {
                    this.d = (ax) view.getTag();
                }
                if (obj != null) {
                    this.d.b(obj);
                    break;
                }
                break;
            case 3:
                if (view == null) {
                    this.d = new b(this.e, this);
                } else {
                    this.d = (b) view.getTag();
                }
                if (obj != null) {
                    this.d.b(obj);
                    break;
                }
                break;
            case 4:
                if (view == null) {
                    this.d = new ba(this.e, this);
                } else {
                    this.d = (ba) view.getTag();
                }
                if (obj != null) {
                    this.d.b(obj);
                    break;
                }
                break;
            case 9:
                if (view != null) {
                    this.d = (ar) view.getTag();
                    break;
                }
                this.d = new ar(this.e, this);
                break;
        }
        return this.d.c();
    }

    public int getViewTypeCount() {
        return 10;
    }

    public void notifyDataSetChanged() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ac acVar = (ac) it.next();
            if ("ads".equals(acVar.b()) && (acVar.c() == null || acVar.c().size() == 0)) {
                it.remove();
            }
        }
        super.notifyDataSetChanged();
    }
}
