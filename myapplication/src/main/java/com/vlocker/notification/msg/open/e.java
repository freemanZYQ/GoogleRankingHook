package com.vlocker.notification.msg.open;

class e implements Runnable {
    final /* synthetic */ FlowWebViewActivity a;

    e(FlowWebViewActivity flowWebViewActivity) {
        this.a = flowWebViewActivity;
    }

    public void run() {
        if (!this.a.u) {
            if (this.a.d()) {
                this.a.t.postDelayed(this.a.w, 10);
                return;
            }
            this.a.u = false;
            if ("weather_webview".equals(this.a.e) || "weather".equals(this.a.e)) {
                this.a.h();
            }
            this.a.finish();
        }
    }
}
