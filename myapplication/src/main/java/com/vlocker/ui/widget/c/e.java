package com.vlocker.ui.widget.c;

import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.vlocker.ui.widget.a.a;
import com.vlocker.ui.widget.a.b;
import com.vlocker.ui.widget.a.c;
import com.vlocker.ui.widget.a.d;
import com.vlocker.ui.widget.a.f;
import com.vlocker.ui.widget.a.g;
import com.vlocker.ui.widget.a.h;
import com.vlocker.ui.widget.a.i;
import com.vlocker.ui.widget.a.j;
import com.vlocker.ui.widget.a.k;
import com.vlocker.ui.widget.a.l;
import com.vlocker.ui.widget.a.m;
import com.vlocker.ui.widget.a.n;
import com.vlocker.ui.widget.a.o;
import com.vlocker.ui.widget.a.p;
import com.vlocker.ui.widget.a.q;
import com.vlocker.ui.widget.a.r;
import com.vlocker.ui.widget.a.s;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class e extends DefaultHandler {
    private d a;
    private d b;
    private d c;
    private String d = null;
    private String e = "";

    private void d(Attributes attributes, d dVar) {
        ((q) dVar).G(attributes.getValue("styleType"));
        ((q) dVar).D(attributes.getValue("fontColor"));
        ((q) dVar).E(attributes.getValue("numColor"));
        ((q) dVar).F(attributes.getValue("textColor"));
        ((q) dVar).w(attributes.getValue("fontSize"));
        ((q) dVar).x(attributes.getValue("numSize"));
        ((q) dVar).y(attributes.getValue("textSize"));
        ((q) dVar).A(attributes.getValue("fontPath"));
        ((q) dVar).B(attributes.getValue("numPath"));
        ((q) dVar).C(attributes.getValue("textPath"));
        ((q) dVar).H(attributes.getValue("secondFcolor"));
        ((q) dVar).z(attributes.getValue("text"));
        ((q) dVar).I(attributes.getValue("isFont"));
        ((q) dVar).J(attributes.getValue("shadowType"));
        ((q) dVar).K(attributes.getValue("fontSizeArr"));
        ((q) dVar).L(attributes.getValue("textType"));
        ((q) dVar).N(attributes.getValue("isVertical"));
        ((q) dVar).O(attributes.getValue("fontAlpha"));
        ((q) dVar).P(attributes.getValue("textSpace"));
        ((q) dVar).M(attributes.getValue("dateShow"));
        c(attributes, dVar);
    }

    public int a(String str) {
        int i = 540;
        if (str == null) {
            return 0;
        }
        if (!str.contains("#screen_width") && !str.contains("#screen_height")) {
            return Integer.parseInt(str);
        }
        int b = this.a.b();
        if (b == 0) {
            b = 540;
        }
        int c = this.a.c();
        if (c != 0) {
            i = c;
        }
        return str.equals("#screen_width") ? b : str.equals("#screen_height") ? i : (int) new a(str.replaceAll("#screen_width", b + "").replaceAll("#screen_height", i + "")).a();
    }

    public d a() {
        return this.a;
    }

    public void a(Attributes attributes, d dVar) {
        ((f) dVar).a(attributes.getValue("offx"));
        ((f) dVar).b(attributes.getValue("hourType"));
        d(attributes, dVar);
    }

    public void a(Attributes attributes, h hVar) {
        hVar.a(attributes.getValue("tools_src"));
        hVar.b(attributes.getValue("camer_src"));
        hVar.c(attributes.getValue("qq_src"));
        hVar.d(attributes.getValue("tip_src"));
        hVar.e(attributes.getValue("fontColor"));
        hVar.q(attributes.getValue("isCustom"));
        hVar.t(attributes.getValue("tool_x"));
        hVar.u(attributes.getValue("tool_y"));
        hVar.r(attributes.getValue("camer_x"));
        hVar.s(attributes.getValue("camer_y"));
        c(attributes, hVar);
    }

    public void a(Attributes attributes, j jVar) {
        jVar.a(attributes.getValue("bank_src"));
        jVar.b(attributes.getValue("bank_select"));
        jVar.c(attributes.getValue("orientation"));
        jVar.d(attributes.getValue("bank_bg"));
        d(attributes, jVar);
    }

    public void a(Attributes attributes, l lVar) {
        c(attributes, lVar);
        this.a.y.add(lVar);
    }

    public void a(Attributes attributes, m mVar) {
        mVar.a(attributes.getValue("num_src"));
        mVar.b(attributes.getValue("num_select"));
        mVar.c(attributes.getValue("fontpng"));
        mVar.d(attributes.getValue("fontSelectpng"));
        mVar.e(attributes.getValue("fontText"));
        mVar.q(attributes.getValue("fontSelectColor"));
        mVar.r(attributes.getValue("id"));
        d(attributes, mVar);
        this.a.x.add(mVar);
    }

    public void a(Attributes attributes, o oVar) {
        oVar.a(attributes.getValue("bank_src"));
        oVar.b(attributes.getValue("bank_select"));
        oVar.c(attributes.getValue("num_src"));
        oVar.d(attributes.getValue("num_select"));
        oVar.s(attributes.getValue("wordColor"));
        oVar.e(attributes.getValue("fontpng"));
        oVar.q(attributes.getValue("fontSelectpng"));
        oVar.r(attributes.getValue("fontText"));
        oVar.t(attributes.getValue("isBgAlpa"));
        oVar.u(attributes.getValue("lock_bg"));
        oVar.v(attributes.getValue("fontSelectColor"));
        d(attributes, oVar);
    }

    public void a(Attributes attributes, r rVar) {
        rVar.a(attributes.getValue("type"));
        rVar.b(attributes.getValue("move_type"));
        rVar.c(attributes.getValue("move_distance"));
        rVar.d(attributes.getValue("touch_type"));
        rVar.e(attributes.getValue("visibility"));
        rVar.q(attributes.getValue("time_show"));
        rVar.r(attributes.getValue("anim_direction"));
        rVar.s(attributes.getValue("unlock_move_show"));
        rVar.t(attributes.getValue("hint_anim"));
        rVar.u(attributes.getValue("pwd_type"));
        rVar.v(attributes.getValue("src_bg"));
        rVar.Q(attributes.getValue("move_islimited"));
        d(attributes, rVar);
    }

    public void b(Attributes attributes, d dVar) {
        ((c) dVar).a(attributes.getValue("bg_src"));
        ((c) dVar).d(attributes.getValue("hour_src"));
        ((c) dVar).c(attributes.getValue("minute_src"));
        ((c) dVar).b(attributes.getValue("second_src"));
        ((c) dVar).e(attributes.getValue("cover_src"));
        c(attributes, dVar);
    }

    public void c(Attributes attributes, d dVar) {
        dVar.k(attributes.getValue(IXAdRequestInfo.HEIGHT));
        dVar.j(attributes.getValue(IXAdRequestInfo.WIDTH));
        dVar.g(attributes.getValue("src"));
        dVar.f(attributes.getValue("pngSrc"));
        dVar.h(a(attributes.getValue("x")) + "");
        dVar.i(a(attributes.getValue("y")) + "");
        dVar.l(attributes.getValue("anchor"));
        dVar.m(attributes.getValue("anchor_vertical"));
        dVar.n(attributes.getValue("pos"));
        dVar.o(attributes.getValue("pngScale"));
        dVar.p(attributes.getValue("isOnClock"));
    }

    public void characters(char[] cArr, int i, int i2) {
        if (this.d == null) {
        }
    }

    public void endElement(String str, String str2, String str3) {
        if (!"widgetControl".equals(str2)) {
            if ("widgethour".equals(str2) || "widgetminute".equals(str2) || "widgetclock".equals(str2) || "widgetWeek".equals(str2) || "widgetApm".equals(str2) || "widgetbg".equals(str2) || "widgetDate".equals(str2) || "widgetTemp".equals(str2) || "WidgetTextData".equals(str2) || "widgetImage".equals(str2)) {
                if (("widgetclock".equals(str2) || "widgethour".equals(str2) || "WidgetTextData".equals(str2)) && this.c != null) {
                    this.a.a(this.c);
                    this.c = null;
                }
                if (this.b.q) {
                    this.a.a(this.b);
                }
                this.a.b(this.b);
                this.b = null;
            }
        }
    }

    public void startDocument() {
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if ("widgetControl".equals(str2)) {
            this.a = new d();
            this.a.c(attributes.getValue("name"));
            this.a.d(attributes.getValue("version"));
            this.a.e(attributes.getValue("versonCode"));
            this.a.f(attributes.getValue("width"));
            this.a.g(attributes.getValue("height"));
            this.a.h(attributes.getValue("targeth"));
            this.a.i(attributes.getValue("targetw"));
            this.a.a(attributes.getValue("wallpaper"));
            this.a.b(attributes.getValue("wallpaper_num"));
            this.a.j(a(attributes.getValue("x")) + "");
            this.a.k(a(attributes.getValue("y")) + "");
            this.a.m(attributes.getValue("pos"));
            this.a.n(attributes.getValue("sounds"));
            this.a.l(attributes.getValue("gravity"));
            this.a.o(attributes.getValue("scaleTime"));
        } else if ("widgetclock".equals(str2)) {
            this.b = new c();
            this.b.a((byte) 13);
            b(attributes, this.b);
            this.c = new c();
            this.c.a((byte) 13);
            b(attributes, this.c);
        } else if ("widgethour".equals(str2)) {
            this.b = new f();
            this.b.a((byte) 3);
            a(attributes, this.b);
            this.c = new f();
            this.c.a((byte) 3);
            a(attributes, this.c);
        } else if ("widgetminute".equals(str2)) {
            this.b = new i();
            this.b.a((byte) 4);
            d(attributes, this.b);
        } else if ("widgetWeek".equals(str2)) {
            this.b = new s();
            this.b.a((byte) 6);
            ((s) this.b).a(attributes.getValue("dateType"));
            d(attributes, this.b);
        } else if ("widgetApm".equals(str2)) {
            this.b = new a();
            this.b.a((byte) 5);
            d(attributes, this.b);
        } else if ("widgetDate".equals(str2)) {
            this.b = new com.vlocker.ui.widget.a.e();
            this.b.a((byte) 7);
            ((com.vlocker.ui.widget.a.e) this.b).a(attributes.getValue("dateType"));
            d(attributes, this.b);
        } else if ("widgetTemp".equals(str2)) {
            this.b = new p();
            this.b.a((byte) 8);
            ((p) this.b).a(attributes.getValue("tempShow"));
            d(attributes, this.b);
        } else if ("widgetbg".equals(str2)) {
            this.b = new b();
            this.b.a((byte) 1);
            c(attributes, this.b);
        } else if ("widgetImage".equals(str2)) {
            this.b = new g();
            this.b.a((byte) 12);
            c(attributes, this.b);
        } else if ("widgetUnlocker".equals(str2)) {
            if (this.a != null) {
                this.a.u = new r();
                a(attributes, this.a.u);
            }
        } else if ("widgetLockerTools".equals(str2)) {
            if (this.a != null) {
                this.a.v = new h();
                a(attributes, this.a.v);
            }
        } else if ("widgetNumLocker".equals(str2)) {
            if (this.a != null) {
                this.a.w = new o();
                a(attributes, this.a.w);
            }
        } else if ("WidgetTextData".equals(str2)) {
            this.b = new q();
            this.b.a((byte) 2);
            d(attributes, this.b);
            if (!(TextUtils.isEmpty(attributes.getValue("text")) || this.e.contains(attributes.getValue("text")) || (!":".equals(attributes.getValue("text")) && !"时".equals(attributes.getValue("text")) && !"時".equals(attributes.getValue("text")) && !"分".equals(attributes.getValue("text"))))) {
                this.e += attributes.getValue("text");
                this.c = new q();
                this.c.a((byte) 2);
                d(attributes, this.c);
            }
        } else if ("numPoint".equals(str2)) {
            if (this.a != null) {
                a(attributes, new m());
            }
        } else if ("numBank".equals(str2)) {
            if (this.a != null) {
                this.a.z = new j();
                a(attributes, this.a.z);
            }
        } else if ("numTip".equals(str2)) {
            if (this.a != null) {
                this.a.A = new n();
                this.a.A.a(attributes.getValue("tip_bg"));
                d(attributes, this.a.A);
                if (this.a.A.l < 48) {
                    this.a.A.l = 48;
                }
            }
        } else if ("numDel".equals(str2)) {
            if (this.a != null) {
                this.a.B = new k();
                this.a.B.a(attributes.getValue("del_src"));
                this.a.B.b(attributes.getValue("del_bg"));
                d(attributes, this.a.B);
            }
        } else if ("numImage".equals(str2) && this.a != null) {
            a(attributes, new l());
        }
        this.d = str2;
    }
}
