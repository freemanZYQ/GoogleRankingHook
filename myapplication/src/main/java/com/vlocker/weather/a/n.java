package com.vlocker.weather.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;

class n implements OnClickListener {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.net_service_card1:
                this.a.a(view, 0);
                return;
            case R.id.net_service_card2:
                this.a.a(view, 1);
                return;
            case R.id.net_service_card3:
                this.a.a(view, 2);
                return;
            case R.id.net_service_card4:
                this.a.a(view, 3);
                return;
            default:
                return;
        }
    }
}
