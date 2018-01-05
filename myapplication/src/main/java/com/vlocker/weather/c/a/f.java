package com.vlocker.weather.c.a;

import android.view.View;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.weather.c.c.b;

class f extends d {
    TextView a;
    TextView b;
    TextView c;
    RecyclingImageView d;
    final /* synthetic */ a e;

    public f(a aVar, View view) {
        this.e = aVar;
        super(aVar, view);
        this.h = 1;
        this.a = (TextView) view.findViewById(R.id.tv_weather_news_card_item_title);
        this.b = (TextView) view.findViewById(R.id.tv_weather_news_card_item_author);
        this.c = (TextView) view.findViewById(R.id.tv_weather_news_card_item_hot);
        this.d = (RecyclingImageView) view.findViewById(R.id.iv_weather_news_card_item);
        aVar.a(this.d, false);
    }

    public void a(b bVar) {
        this.a.setText(bVar.c());
        this.b.setText(bVar.f());
        this.c.setText(bVar.b());
        if (bVar.e() == null || bVar.e().size() <= 0) {
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        this.d.a((String) bVar.e().get(0), 2, 0);
    }
}
