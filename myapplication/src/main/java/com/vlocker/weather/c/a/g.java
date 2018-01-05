package com.vlocker.weather.c.a;

import android.view.View;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.weather.c.c.b;

class g extends d {
    TextView a;
    TextView b;
    TextView c;
    RecyclingImageView d;
    RecyclingImageView e;
    RecyclingImageView f;
    final /* synthetic */ a g;

    public g(a aVar, View view) {
        this.g = aVar;
        super(aVar, view);
        this.h = 2;
        this.a = (TextView) view.findViewById(R.id.tv_weather_news_card_item_title);
        this.b = (TextView) view.findViewById(R.id.tv_weather_news_card_item_author);
        this.c = (TextView) view.findViewById(R.id.tv_weather_news_card_item_hot);
        this.d = (RecyclingImageView) view.findViewById(R.id.iv_weather_news_item_imgs_1);
        this.e = (RecyclingImageView) view.findViewById(R.id.iv_weather_news_item_imgs_2);
        this.f = (RecyclingImageView) view.findViewById(R.id.iv_weather_news_item_imgs_3);
    }

    public void a(b bVar) {
        this.a.setText(bVar.c());
        this.b.setText(bVar.f());
        this.c.setText(bVar.b());
        this.d.a((String) bVar.e().get(0), 2, 0);
        this.e.a((String) bVar.e().get(1), 2, 0);
        this.f.a((String) bVar.e().get(2), 2, 0);
    }
}
