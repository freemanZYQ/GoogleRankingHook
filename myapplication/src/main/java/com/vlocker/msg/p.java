package com.vlocker.msg;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.vlocker.b.j;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.cover.g;
import com.vlocker.ui.widget.MsgListView;
import com.vlocker.ui.widget.MusicLrcView;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class p {
    public static boolean a;
    private static p j;
    public boolean b;
    private u c;
    private t d;
    private MsgListView e;
    private Context f = MoSecurityApplication.a();
    private m g;
    private r h;
    private s i;

    private p() {
    }

    public static p a() {
        if (j == null) {
            synchronized (p.class) {
                if (j == null) {
                    j = new p();
                }
            }
        }
        return j;
    }

    public static boolean a(ak akVar, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (!"launcher_manager_notification".equals(jSONObject.getString("subType"))) {
                return false;
            }
            jSONObject = jSONObject.getJSONObject("subData");
            String string = jSONObject.getString("showType");
            akVar.D = str;
            akVar.c = jSONObject.getString("title");
            akVar.e = jSONObject.getString("description");
            if ("show_type_normal".equals(string) || "show_type_with_expand_img".equals(string)) {
                akVar.C = 1;
            } else if ("show_type_custom_title_img".equals(string)) {
                akVar.C = 13;
            } else if ("show_type_custom_only_img".equals(string)) {
                akVar.C = 2;
            }
            if (akVar.C == 2 || akVar.C == 13) {
                akVar.u = jSONObject.getString("desImg");
                Bitmap bitmap = null;
                if (akVar.u != null) {
                    bitmap = McmPushWidget.getBitmapFromURL(akVar.u);
                }
                if (akVar.t == null && bitmap == null) {
                    akVar.C = 1;
                }
                if (bitmap != null) {
                    akVar.t = bitmap;
                }
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void d(String str) {
        if (this.g != null) {
            this.g.a(ab.a().d());
        }
    }

    private void o() {
        if (this.g != null) {
            this.g.notifyDataSetChanged();
        }
    }

    private void p() {
        if (this.d == null) {
            this.d = new t(this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.vlocker.app.msgcount.changed");
        intentFilter.addAction("com.vlocker.app.msgcount.remove");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("com.vlocker.app.msgcount.remove.weahter");
        intentFilter.addAction("com.vlocker.locker.AlarmSend");
        intentFilter.addAction("AlarmChange");
        intentFilter.addAction("action_redpacket_share");
        intentFilter.addAction("com.vlocker.open.notification");
        this.f.registerReceiver(this.d, intentFilter);
    }

    private void q() {
        if (this.d != null) {
            this.f.unregisterReceiver(this.d);
            this.d = null;
        }
    }

    public void a(View view, r rVar) {
        this.e = (MsgListView) view.findViewById(R.id.msg_list);
        this.h = rVar;
        c();
    }

    public void a(ak akVar) {
        if (akVar != null && this.c != null) {
            if (akVar.r) {
                com.vlocker.b.p.a(this.f, "Vlock_SendToUser_PushMsg_PPC_TF", "Location", "Locker", "PushName", akVar.c);
                if (!LockerService.e(this.f) || !g.a) {
                    a.a(this.f).a(akVar.D);
                    a.a(this.f).b(akVar.b);
                } else if (a.a(this.f).g().equals(akVar.b)) {
                    a.a(this.f).a("");
                    a.a(this.f).b("");
                }
            }
            Message message = new Message();
            message.what = 8;
            message.obj = akVar;
            this.c.sendMessage(message);
        }
    }

    public void a(s sVar) {
        this.i = sVar;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && this.c != null) {
            Message message = new Message();
            message.what = 7;
            message.obj = str;
            this.c.sendMessage(message);
        }
    }

    public void a(String[] strArr) {
        if (this.c != null) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = strArr;
            obtainMessage.what = 5;
            this.c.sendMessage(obtainMessage);
        }
    }

    public boolean a(int i) {
        if (this.g == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.g.getCount(); i2++) {
            if (((ak) this.g.getItem(i2)).C == i) {
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        return this.e.getVisibility() == 0;
    }

    public boolean b(String str) {
        if (this.g == null) {
            return false;
        }
        for (int i = 0; i < this.g.getCount(); i++) {
            ak akVar = (ak) this.g.getItem(i);
            if (akVar.C == 6 && akVar.j.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public ak c(String str) {
        return this.g != null ? this.g.b(str) : null;
    }

    public void c() {
        this.g = new m(this.f, this, this.e);
        this.e.setAdapter(this.g);
        this.c = new u(this);
        this.e.setMsgTouchListener(new q(this));
        p();
    }

    public void d() {
        if (this.c != null) {
            this.c.sendEmptyMessage(9);
        }
    }

    public void e() {
        q();
    }

    public void f() {
        this.b = false;
        if (this.e.getVisibility() != 8) {
            this.e.setVisibility(8);
        }
        if (this.i != null) {
            this.i.a();
        }
    }

    public void g() {
        this.b = true;
        if (this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
        if (this.i != null) {
            this.i.b();
        }
    }

    public boolean h() {
        if (this.g != null) {
            if (this.g.d()) {
                return true;
            }
            if ((MusicLrcView.a && this.g.c() > 0) || this.g.c() > 1) {
                return true;
            }
        }
        return false;
    }

    public boolean i() {
        if (this.g != null) {
            if (this.g.e()) {
                return true;
            }
            if ((MusicLrcView.a && this.g.c() > 0) || this.g.c() > 1) {
                return true;
            }
        }
        return false;
    }

    public boolean j() {
        if (this.e == null) {
            return false;
        }
        View childAt = this.e.getChildAt(0);
        return childAt == null || childAt.getTop() == 0;
    }

    public void k() {
        if (this.g != null) {
            this.g.notifyDataSetChanged();
        }
    }

    public View l() {
        if (this.e == null) {
            return null;
        }
        int childCount = this.e.getChildCount();
        int i = 0;
        View view = null;
        while (i < childCount) {
            View view2;
            view = this.e.getChildAt(i);
            if (view == null || ((com.vlocker.msg.b.a) view.getTag()) == null) {
                view2 = view;
            } else if (((com.vlocker.msg.b.a) view.getTag()).n == 9) {
                return view;
            } else {
                view2 = null;
            }
            i++;
            view = view2;
        }
        return view;
    }

    public ArrayList m() {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        if (!(this.g == null || this.e == null)) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.g.getCount()) {
                ak akVar = (ak) this.g.getItem(i2);
                if (this.e.getChildAt(i2) != null && this.e.getChildAt(i2).isShown()) {
                    if (!(akVar.c == null || akVar.b == null || !"msg_ad".equals(akVar.b))) {
                        com.vlocker.b.p.a(this.f, "Vlock_Show_MsgAD_PPC_TF", "msg_name", akVar.c);
                    }
                    if (akVar.r) {
                        arrayList.add(akVar);
                        if ("A_tengxun".equals(j.p(this.f))) {
                            if (akVar.c != null) {
                                com.vlocker.b.p.a(this.f, "Vlock_ShowUser_Lock_PushMsg_PPC_TF", "PushName", akVar.c);
                            } else {
                                com.vlocker.b.p.a(this.f, "Vlock_ShowUser_Lock_PushMsg_PPC_TF", "PushName", "null");
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(akVar.b) && a.a(this.f).g().equals(akVar.b)) {
                    a.a(this.f).a("");
                    a.a(this.f).b("");
                    i3 = 1;
                }
                if (akVar != null) {
                    v.a(this.f).a(akVar.b, akVar.r, akVar.j);
                }
                i2++;
            }
            v.a(this.f).a();
            v.a(this.f).a(this.g.getCount());
            n();
            i = i3;
        }
        if (i == 0) {
            a.a(this.f).b(System.currentTimeMillis());
        }
        return arrayList;
    }

    public void n() {
        Object obj = System.currentTimeMillis() - a.a(this.f).h() > 1800000 ? 1 : null;
        Object f = a.a(this.f).f();
        String g = a.a(this.f).g();
        if (obj != null && !TextUtils.isEmpty(f)) {
            try {
                as.a(this.f, as.b(g));
            } catch (Exception e) {
            }
            a.a(this.f).a("");
            a.a(this.f).b("");
            Intent intent = new Intent();
            intent.putExtra("json", f);
            intent.setAction("push_msg");
            this.f.sendBroadcast(intent);
        }
    }
}
