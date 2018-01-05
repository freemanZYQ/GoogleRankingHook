package com.vlocker.search;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import java.util.List;

public class r extends p {
    private TextView a;
    private LinearLayout b;

    public r(BaiduSearchActivity baiduSearchActivity) {
        super(baiduSearchActivity);
    }

    protected View a() {
        View b = j.b(this.e, (int) R.layout.m_bd_searchhit_card);
        this.b = (LinearLayout) b.findViewById(R.id.t_diglinearlayout);
        this.a = (TextView) b.findViewById(R.id.digtagtitletext);
        return b;
    }

    protected void a(ac acVar) {
        super.a((Object) acVar);
        try {
            this.a.setText("搜索推荐");
            List d = acVar.d();
            int i = 0;
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                LinearLayout linearLayout = (LinearLayout) this.b.getChildAt(i2);
                int i3 = 0;
                while (i3 < linearLayout.getChildCount()) {
                    int i4;
                    TextView textView = (TextView) linearLayout.getChildAt(i3);
                    textView.setVisibility(0);
                    if (i > d.size() - 1) {
                        textView.setVisibility(8);
                        i4 = i;
                    } else {
                        textView.setText(((M_bd_BaiduNewsInfo) d.get(i)).a());
                        textView.setTag(d.get(i));
                        textView.setOnClickListener(new s(this));
                        i4 = i + 1;
                    }
                    i3++;
                    i = i4;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
