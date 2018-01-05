package com.vlocker.share;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.vlocker.b.p;

class q implements OnItemClickListener {
    final /* synthetic */ h a;

    q(h hVar) {
        this.a = hVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.a.o) {
            switch ((int) j) {
                case 0:
                    p.a(this.a.e, "Vlocker_ApplyShare_ThemeDetail_PPC_TF", "ShareTo", "qzone");
                    this.a.b(1);
                    this.a.a();
                    return;
                case 1:
                    p.a(this.a.e, "Vlocker_ApplyShare_ThemeDetail_PPC_TF", "ShareTo", "wx_circle");
                    this.a.a(1);
                    this.a.a();
                    return;
                case 2:
                    p.a(this.a.e, "Vlocker_ApplyShare_ThemeDetail_PPC_TF", "ShareTo", "QQ");
                    this.a.b(0);
                    this.a.a();
                    return;
                case 3:
                    p.a(this.a.e, "Vlocker_ApplyShare_ThemeDetail_PPC_TF", "ShareTo", "wx");
                    this.a.a(0);
                    this.a.a();
                    return;
                case 4:
                    p.a(this.a.e, "Vlocker_ApplyShare_ThemeDetail_PPC_TF", "ShareTo", "weibo");
                    this.a.d();
                    this.a.a();
                    return;
                default:
                    return;
            }
        }
    }
}
