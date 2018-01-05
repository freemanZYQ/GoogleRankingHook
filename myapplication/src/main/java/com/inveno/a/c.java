package com.inveno.a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.inveno.se.f.a;

class c implements ActivityLifecycleCallbacks {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.a.d = this.a.d + 1;
        a.e("onActivityCreated: " + activity.getClass().getName());
    }

    public void onActivityDestroyed(Activity activity) {
        this.a.d = this.a.d - 1;
        this.a.d();
        a.e("onActivityDestroyed: " + activity.getClass().getName());
    }

    public void onActivityPaused(Activity activity) {
        this.a.f = this.a.f - 1;
        a.e("onActivityPaused: " + activity.getClass().getName());
    }

    public void onActivityResumed(Activity activity) {
        this.a.f = this.a.f + 1;
        a.e("onActivityResumed: " + activity.getClass().getName());
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a.e("onActivitySaveInstanceState: " + activity.getClass().getName());
    }

    public void onActivityStarted(Activity activity) {
        a.e("onActivityStarted: " + activity.getClass().getName());
        this.a.e = this.a.e + 1;
    }

    public void onActivityStopped(Activity activity) {
        this.a.e = this.a.e - 1;
        this.a.d();
        a.e("onActivityStopped: " + activity.getClass().getName());
    }
}
