package com.vlocker.weather.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.weather.a;
import org.json.JSONObject;

class d implements OnClickListener {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ a b;

    d(a aVar, JSONObject jSONObject) {
        this.b = aVar;
        this.a = jSONObject;
    }

    public void onClick(View view) {
        com.vlocker.weather.e.d.a(this.b.l, "Weather(V)_Click_WarningTitle_PPC_YZY", new String[0]);
        a.a(this.b.l);
        try {
            this.b.a(this.a.getString("text"));
        } catch (Exception e) {
            this.b.a.setVisibility(8);
        }
    }
}
