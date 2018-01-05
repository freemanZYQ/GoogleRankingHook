package com.baidu.mobads.g;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.j.m;

public class d extends LinearLayout {
    protected b a;
    private Context b;
    private IXAdCommonUtils c = m.a().m();

    class a extends TextView {
        final /* synthetic */ d a;

        public a(d dVar, Context context, String str) {
            this.a = dVar;
            super(context);
            a(str);
        }

        private void a(String str) {
            setText(str);
            setTextColor(-16777216);
            setGravity(17);
            setBackgroundColor(-1);
            setTextSize(19.0f);
            setLayoutParams(new LayoutParams(-1, this.a.c.getPixel(this.a.b, 50)));
        }
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    public d(Context context) {
        super(context);
        this.b = context;
        setBackgroundColor(-2236963);
        setOrientation(1);
        View aVar = new a(this, context, "刷新");
        LayoutParams layoutParams = (LayoutParams) aVar.getLayoutParams();
        layoutParams.bottomMargin = this.c.getPixel(this.b, 2);
        addView(aVar, layoutParams);
        View aVar2 = new a(this, context, "复制网址");
        layoutParams = (LayoutParams) aVar2.getLayoutParams();
        layoutParams.bottomMargin = this.c.getPixel(this.b, 4);
        addView(aVar2, layoutParams);
        View aVar3 = new a(this, context, "取消");
        addView(aVar3);
        aVar.setOnClickListener(new e(this));
        aVar2.setOnClickListener(new f(this));
        aVar3.setOnClickListener(new g(this));
    }

    public void a(b bVar) {
        this.a = bVar;
    }
}
