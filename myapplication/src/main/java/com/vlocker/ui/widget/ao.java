package com.vlocker.ui.widget;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.location.LocationClientOption;
import com.vlocker.b.j;
import com.vlocker.m.aj;
import com.vlocker.m.o;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.update.UpdateApkParamBean;
import com.vlocker.update.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class ao extends Handler {
    final /* synthetic */ V2GuideBannerView a;

    ao(V2GuideBannerView v2GuideBannerView) {
        this.a = v2GuideBannerView;
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            ArrayList arrayList;
            int i;
            int i2 = i.b(this.a.f).getInt("update_service_ver", 0);
            Object obj = i2 > o.b(this.a.f) ? 1 : null;
            if (this.a.k == null || this.a.k.a() == null) {
                arrayList = null;
                i = 0;
            } else {
                ArrayList a = this.a.k.a();
                if (a != null) {
                    arrayList = a;
                    i = a.size();
                } else {
                    arrayList = a;
                    i = 0;
                }
            }
            this.a.u = false;
            this.a.h();
            if (i > 0 || obj != null) {
                ba baVar;
                int i3;
                Object obj2;
                int i4;
                int i5;
                for (int i6 = 0; i6 < i; i6++) {
                    baVar = (ba) arrayList.get(i6);
                    if (baVar.b) {
                        this.a.u = true;
                    }
                    bc a2 = this.a.a(baVar);
                    if (a2 != null) {
                        String a3 = baVar.a();
                        if ("app".equals(a3)) {
                            if (aj.a(baVar.d())) {
                            }
                        } else if ("update".equals(a3)) {
                            if (obj != null) {
                                try {
                                    if (i2 != Integer.parseInt(baVar.d())) {
                                    }
                                } catch (Exception e) {
                                }
                            }
                        } else if ("apps".equals(a3)) {
                            ArrayList g = baVar.g();
                            if (g != null && g.size() > 0) {
                                for (int i7 = 0; i7 < g.size(); i7++) {
                                    Iterator it = g.iterator();
                                    while (it.hasNext()) {
                                        if (aj.a(((UpdateApkParamBean) it.next()).h())) {
                                            it.remove();
                                        }
                                    }
                                }
                            }
                        } else if (("topic".equals(a3) || "index".equals(a3)) && !aj.a("com.moxiu.launcher")) {
                        }
                        if ("apps".equals(a3) && baVar.g() != null && baVar.g().size() > 0) {
                            this.a.g.add(a2);
                        } else if (!"apps".equals(a3) || baVar.g() == null || baVar.g().size() != 0) {
                            if (!"ade".equals(a3)) {
                                this.a.g.add(a2);
                            } else if (!i.e(this.a.f).booleanValue() && j.g(this.a.getContext())) {
                                this.a.g.add(a2);
                            }
                        }
                    }
                }
                int size = this.a.g.size();
                if (obj != null) {
                    for (i3 = 0; i3 < size; i3++) {
                        baVar = ((bc) this.a.g.get(i3)).b;
                        if ("update".equals(baVar.a()) || "type_new_version".equals(baVar.a())) {
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        this.a.g.add(this.a.q());
                    }
                }
                if (this.a.u) {
                    i4 = 0;
                    while (i4 < this.a.g.size()) {
                        if ("type_main".equals(((bc) this.a.g.get(i4)).b.d)) {
                            break;
                        }
                        i4++;
                    }
                    i4 = -1;
                    if (i4 > -1) {
                        this.a.g.remove(i4);
                    }
                }
                i4 = this.a.g.size();
                this.a.h.clear();
                this.a.e.a(false);
                if (i4 > 0) {
                    Collections.sort(this.a.g);
                    for (i5 = 0; i5 < i4; i5++) {
                        this.a.h.add(this.a.g.get(i5));
                    }
                }
                obj2 = null;
                if (this.a.h.size() == 2) {
                    for (i3 = 0; i3 < 2; i3++) {
                        ba baVar2 = ((bc) this.a.h.get(i3)).b;
                        String str = baVar2.d;
                        obj2 = null;
                        if (!baVar2.a) {
                            obj2 = this.a.a(baVar2);
                        } else if ("type_fix_lock".equals(str)) {
                            obj2 = this.a.k();
                        } else if ("type_close_sys_lock".equals(str)) {
                            obj2 = this.a.l();
                        } else if ("type_pwd".equals(str)) {
                            obj2 = this.a.o();
                        } else if ("type_msg".equals(str)) {
                            obj2 = this.a.p();
                        } else if ("type_new_version".equals(str)) {
                            obj2 = this.a.q();
                        } else if ("type_main".equals(str)) {
                            obj2 = this.a.j();
                        }
                        if (obj2 != null) {
                            this.a.h.add(obj2);
                        }
                    }
                    obj2 = 1;
                }
                i4 = this.a.h.size();
                if (i4 > 1) {
                    i5 = obj2 != null ? 2 : i4;
                    for (i4 = 0; i4 < i5; i4++) {
                        this.a.e.a(i4, new be(), true);
                    }
                }
                this.a.d.setAdapter(null);
                this.a.d.setAdapter(this.a.i);
                this.a.d.setCurrentItem(this.a.h.size() * LocationClientOption.MIN_SCAN_SPAN);
                if (this.a.h.size() > 1) {
                    this.a.e();
                } else {
                    this.a.f();
                }
            }
        } else if (message.what == 2) {
            if (SystemClock.elapsedRealtime() - this.a.B >= 2000 && this.a.h.size() > 1 && LockerService.e(this.a.getContext()) && this.a.d.isShown()) {
                this.a.d.a(this.a.d.getCurrentItem() + 1, true);
                this.a.y.sendEmptyMessageDelayed(2, 3000);
            }
        } else if (3 == message.what) {
            this.a.w();
        }
    }
}
