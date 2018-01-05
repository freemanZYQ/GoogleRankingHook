package com.vlocker.ui.widget;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import com.vlocker.locker.R;
import com.vlocker.ui.widget.MyAlertController.RecycleListView;

public class s {
    public int A;
    public int B;
    public int C;
    public int D;
    public boolean E = false;
    public boolean[] F;
    public boolean G;
    public boolean H;
    public int I = -1;
    public OnMultiChoiceClickListener J;
    public Cursor K;
    public String L;
    public String M;
    public boolean N;
    public OnItemSelectedListener O;
    public x P;
    public boolean Q = true;
    public boolean R = true;
    public boolean S = false;
    public boolean T = false;
    public boolean U = false;
    public boolean V = true;
    public boolean W;
    public final Context a;
    public final LayoutInflater b;
    public int c = 0;
    public CharSequence d;
    public CharSequence e;
    public boolean f;
    public boolean g;
    public View h;
    public CharSequence i;
    public boolean j = true;
    public boolean k = true;
    public boolean l = true;
    public CharSequence m;
    public OnClickListener n;
    public CharSequence o;
    public OnClickListener p;
    public CharSequence q;
    public OnClickListener r;
    public boolean s;
    public OnCancelListener t;
    public OnKeyListener u;
    public CharSequence[] v;
    public ListAdapter w;
    public OnClickListener x;
    public View y;
    public boolean z;

    public s(Context context) {
        this.a = context;
        this.s = true;
        this.b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    private void b(MyAlertController myAlertController) {
        ListAdapter arrayAdapter;
        ListView listView = (RecycleListView) this.b.inflate(R.layout.l_select_dialog, null);
        if (!this.G) {
            int i = this.H ? R.layout.l_select_dialog_singlechoice : R.layout.l_select_dialog_item;
            arrayAdapter = this.K == null ? this.w != null ? this.w : new ArrayAdapter(this.a, i, R.id.text1, this.v) : new SimpleCursorAdapter(this.a, i, this.K, new String[]{this.L}, new int[]{16908308});
        } else if (this.K == null) {
            arrayAdapter = new t(this, this.a, R.layout.l_select_dialog_multichoice, R.id.text1, this.v, listView);
        } else {
            Object uVar = new u(this, this.a, this.K, false, listView);
        }
        if (this.P != null) {
            this.P.a(listView);
        }
        myAlertController.Q = arrayAdapter;
        myAlertController.R = this.I;
        if (this.x != null) {
            listView.setOnItemClickListener(new v(this, myAlertController));
        } else if (this.J != null) {
            listView.setOnItemClickListener(new w(this, listView, myAlertController));
        }
        if (this.O != null) {
            listView.setOnItemSelectedListener(this.O);
        }
        if (this.H) {
            listView.setChoiceMode(1);
        } else if (this.G) {
            listView.setChoiceMode(2);
        }
        listView.a = this.Q;
        myAlertController.k = listView;
    }

    public void a(MyAlertController myAlertController) {
        if (this.h != null) {
            myAlertController.b(this.h);
        } else {
            if (this.d != null) {
                myAlertController.a(this.d);
            }
            if (this.e != null) {
                myAlertController.c(this.e);
            }
            myAlertController.a(this.f);
        }
        myAlertController.c(this.g);
        myAlertController.d(this.V);
        myAlertController.e(this.W);
        if (this.i != null) {
            myAlertController.b(this.i);
        }
        if (this.m != null) {
            myAlertController.a(-1, this.m, this.n, null);
            myAlertController.v = this.j;
        }
        if (this.o != null) {
            myAlertController.a(-2, this.o, this.p, null);
            myAlertController.z = this.k;
        }
        if (this.q != null) {
            myAlertController.a(-3, this.q, this.r, null);
            myAlertController.D = this.l;
        }
        if (this.N) {
            myAlertController.f(true);
        }
        if (!(this.v == null && this.K == null && this.w == null)) {
            b(myAlertController);
        }
        if (this.y != null) {
            if (this.E) {
                myAlertController.a(this.y, this.A, this.B, this.C, this.D);
            } else {
                myAlertController.c(this.y);
            }
            myAlertController.b(this.z);
        }
        if (!this.R) {
            myAlertController.T = false;
        }
        myAlertController.U = this.S;
        myAlertController.V = this.T;
        myAlertController.a = this.U;
    }
}
