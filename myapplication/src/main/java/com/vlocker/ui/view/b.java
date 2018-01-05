package com.vlocker.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;

class b implements OnClickListener {
    final /* synthetic */ BatteryChargeView a;

    b(BatteryChargeView batteryChargeView) {
        this.a = batteryChargeView;
    }

    public void onClick(View view) {
        boolean z = true;
        switch (view.getId()) {
            case R.id.layout_battery_wave:
                if (this.a.H != null) {
                    com.vlocker.locker.c.b i = this.a.H;
                    if (com.vlocker.locker.c.b.f) {
                        z = false;
                    }
                    i.b(z);
                    return;
                }
                return;
            case R.id.layout_battery_fast:
                this.a.F.removeCallbacks(this.a.L);
                this.a.I.setText(R.string.battery_time_des_fast_click);
                this.a.a(this.a.I, true);
                this.a.a(this.a.findViewById(R.id.iv_battery_fast_des), true);
                this.a.a(this.a.B, false);
                this.a.findViewById(R.id.iv_battery_normal_des).setVisibility(4);
                this.a.findViewById(R.id.iv_battery_slow_des).setVisibility(4);
                this.a.F.postDelayed(this.a.L, 4000);
                return;
            case R.id.layout_battery_normal:
                this.a.F.removeCallbacks(this.a.L);
                this.a.I.setText(R.string.battery_time_des_normal_click);
                this.a.a(this.a.I, true);
                this.a.a(this.a.findViewById(R.id.iv_battery_normal_des), true);
                this.a.a(this.a.B, false);
                this.a.findViewById(R.id.iv_battery_fast_des).setVisibility(4);
                this.a.findViewById(R.id.iv_battery_slow_des).setVisibility(4);
                this.a.F.postDelayed(this.a.L, 4000);
                return;
            case R.id.layout_battery_slow:
                this.a.F.removeCallbacks(this.a.L);
                this.a.I.setText(R.string.battery_time_des_slow_click);
                this.a.a(this.a.I, true);
                this.a.a(this.a.findViewById(R.id.iv_battery_slow_des), true);
                this.a.a(this.a.B, false);
                this.a.findViewById(R.id.iv_battery_fast_des).setVisibility(4);
                this.a.findViewById(R.id.iv_battery_normal_des).setVisibility(4);
                this.a.F.postDelayed(this.a.L, 4000);
                return;
            case R.id.tv_delete:
            case R.id.tv_little_delete:
                this.a.i();
                return;
            case R.id.tv_forbidern:
            case R.id.tv_little_forbidern:
                this.a.j();
                return;
            default:
                return;
        }
    }
}
