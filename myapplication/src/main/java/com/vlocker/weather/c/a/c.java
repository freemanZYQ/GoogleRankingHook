package com.vlocker.weather.c.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.moxiu.b.a.a;
import com.vlocker.locker.R;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.weather.c.c.b;

class c extends d {
    TextView a;
    TextView b;
    TextView c;
    RecyclingImageView d;
    ImageView e;
    boolean f;
    final /* synthetic */ a g;

    public c(a aVar, View view, boolean z) {
        this.g = aVar;
        super(aVar, view);
        this.f = z;
        this.h = z ? 4 : 3;
        this.a = (TextView) view.findViewById(R.id.tv_weather_news_card_item_title);
        this.b = (TextView) view.findViewById(R.id.tv_weather_news_card_item_author);
        this.c = (TextView) view.findViewById(R.id.tv_weather_news_card_item_hot);
        this.d = (RecyclingImageView) view.findViewById(R.id.iv_weather_news_card_item);
        this.e = (ImageView) view.findViewById(R.id.iv_weather_news_card_item_ad);
        aVar.a(this.d, z);
    }

    public void a(b bVar) {
        a a = ((com.vlocker.weather.c.c.a) bVar).a();
        this.a.setText(this.f ? a.h() : a.c());
        this.b.setText(this.f ? a.c() : a.h());
        this.d.a(a.d(), 2, 0);
        this.e.setVisibility(0);
        this.c.setVisibility(8);
    }
}
