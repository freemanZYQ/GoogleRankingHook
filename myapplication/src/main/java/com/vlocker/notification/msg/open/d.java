package com.vlocker.notification.msg.open;

class d implements Runnable {
    final /* synthetic */ FlowWebViewActivity a;

    d(FlowWebViewActivity flowWebViewActivity) {
        this.a = flowWebViewActivity;
    }

    public void run() {
        this.a.u = false;
        this.a.t.postDelayed(this.a.w, 1000);
    }
}
