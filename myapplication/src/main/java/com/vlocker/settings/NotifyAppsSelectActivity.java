package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.model.d;
import com.vlocker.model.e;
import com.vlocker.model.f;
import com.vlocker.msg.ab;
import com.vlocker.msg.al;
import java.util.ArrayList;
import java.util.HashMap;

public class NotifyAppsSelectActivity extends Activity implements Runnable {
    private GridView a;
    private GridView b;
    private GridView c;
    private TextView d;
    private f e;
    private f f;
    private f g;
    private ArrayList h;
    private ArrayList i;
    private ArrayList j;
    private al k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private boolean p = false;
    private boolean q = false;
    private Handler r = new bn(this);

    private String a(int i) {
        return getResources().getString(R.string.msg_app_select_tip) + " ( " + i + " ) ";
    }

    private void a() {
        this.l = (TextView) findViewById(R.id.l_app_select_count);
        this.m = (TextView) findViewById(R.id.l_app_select_all);
        this.l.setText(a(0));
        this.n = (TextView) findViewById(R.id.app_hot_desc);
        this.o = (TextView) findViewById(R.id.app_sort_desc);
        this.l.setOnClickListener(new bo(this));
        this.a = (GridView) findViewById(R.id.app_selected);
        this.b = (GridView) findViewById(R.id.app_hot);
        this.c = (GridView) findViewById(R.id.app_sort);
        this.d = (TextView) findViewById(R.id.vlocker_install_loading);
        b();
    }

    private void a(f fVar, ArrayList arrayList) {
        if (fVar != null) {
            HashMap a = fVar.a();
            if (a != null && arrayList != null) {
                for (int i = 0; i < a.size(); i++) {
                    if (((Boolean) a.get(Integer.valueOf(i))).booleanValue()) {
                        p.a((Context) this, "Vlocker_Done_App_Select_PPC_TF", "app_name", ((e) arrayList.get(i)).b().b().toString());
                    }
                }
            }
        }
    }

    private void a(ArrayList arrayList, f fVar) {
        for (int i = 0; i < arrayList.size(); i++) {
            String a = ((e) arrayList.get(i)).b().a();
            if (!TextUtils.isEmpty(a)) {
                if (this.p) {
                    a.a((Context) this).c(a, true);
                    ab.a().a(a);
                } else {
                    a.a((Context) this).c(a, false);
                    ab.a().b(a);
                }
                fVar.a().put(Integer.valueOf(i), Boolean.valueOf(this.p));
            }
        }
        fVar.notifyDataSetChanged();
    }

    private void b() {
        this.a.setOnItemClickListener(new bp(this));
        this.b.setOnItemClickListener(new bq(this));
        this.c.setOnItemClickListener(new br(this));
        this.m.setOnClickListener(new bs(this));
        new Thread(this).start();
    }

    private final void c() {
        a.a((Context) this).T(this.p);
        a(this.h, this.e);
        a(this.i, this.f);
        a(this.j, this.g);
        this.l.setText(a((this.e.b() + this.f.b()) + this.g.b()));
        if (this.p) {
            this.m.setText(getResources().getString(R.string.v2_msg_need_light_app_all_not));
        } else {
            this.m.setText(getResources().getString(R.string.v2_msg_need_light_app_all));
        }
    }

    public void a(View view, int i, f fVar, ArrayList arrayList) {
        d dVar = (d) view.getTag();
        dVar.b.toggle();
        boolean isChecked = dVar.b.isChecked();
        fVar.a().put(Integer.valueOf(i), Boolean.valueOf(isChecked));
        String a = ((e) arrayList.get(i)).b().a();
        if (!TextUtils.isEmpty(a)) {
            if (isChecked) {
                a.a((Context) this).c(a, true);
                ab.a().a(a);
            } else {
                a.a((Context) this).c(a, false);
                ab.a().b(a);
            }
        }
        if (fVar.c() != -1) {
            fVar.a(-1);
        }
        if ((this.e.b() + this.f.b()) + this.g.b() == (this.h.size() + this.i.size()) + this.j.size()) {
            a.a((Context) this).T(true);
        } else {
            a.a((Context) this).T(false);
        }
        this.p = a.a((Context) this).bh();
        if (this.p) {
            this.m.setText(getResources().getString(R.string.v2_msg_need_light_app_all_not));
        } else {
            this.m.setText(getResources().getString(R.string.v2_msg_need_light_app_all));
        }
        fVar.notifyDataSetChanged();
        this.l.setText(a((this.e.b() + this.f.b()) + this.g.b()));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.l_msg_app_select_letter_sort_layout);
        a();
    }

    protected void onPause() {
        super.onPause();
        a(this.e, this.h);
        a(this.f, this.i);
        a(this.g, this.j);
    }

    protected void onResume() {
        super.onResume();
    }

    public void run() {
        Message message = new Message();
        this.k = new al(this);
        this.h = this.k.a();
        this.i = this.k.b();
        this.j = this.k.c();
        message.what = 1;
        this.r.sendMessage(message);
    }
}
