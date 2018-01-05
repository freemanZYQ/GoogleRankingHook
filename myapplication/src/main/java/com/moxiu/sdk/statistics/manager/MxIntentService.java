package com.moxiu.sdk.statistics.manager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.moxiu.sdk.statistics.a.a;
import com.moxiu.sdk.statistics.c.b;
import com.moxiu.sdk.statistics.e.f;
import com.moxiu.sdk.statistics.e.i;

public class MxIntentService extends IntentService {
    public MxIntentService() {
        super("MxIntentService");
    }

    public static void a(Context context) {
        i.a("startPostCache");
        Intent intent = new Intent(context, MxIntentService.class);
        intent.setAction("post_cache");
        a(context, intent);
    }

    private static void a(Context context, Intent intent) {
        try {
            intent.setPackage(context.getPackageName());
            context.startService(intent);
        } catch (Throwable e) {
            i.a("startServiceWithCatch", e);
        }
    }

    public static void a(Context context, a aVar) {
        i.a("startWriteCache");
        Intent intent = new Intent(context, MxIntentService.class);
        intent.setAction("wirte_cache");
        intent.putExtra("cache", aVar);
        a(context, intent);
    }

    public static void a(Context context, b bVar, f fVar) {
        i.a("startPostModel");
        Intent intent = new Intent(context, MxIntentService.class);
        intent.setAction("post_model");
        intent.putExtra("model", bVar);
        intent.putExtra("type", fVar);
        a(context, intent);
    }

    public static void b(Context context) {
        i.a("startPostDelay");
        Intent intent = new Intent(context, MxIntentService.class);
        intent.setAction("postdelay");
        a(context, intent);
    }

    public static void b(Context context, a aVar) {
        i.a("startWriteDelay");
        Intent intent = new Intent(context, MxIntentService.class);
        intent.setAction("wirte_delay");
        intent.putExtra("delay", aVar);
        a(context, intent);
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            i.a("onHandleIntent action = " + action);
            try {
                if ("post_model".equals(action)) {
                    h.a().b((b) intent.getSerializableExtra("model"), (f) intent.getSerializableExtra("type"));
                } else if ("wirte_cache".equals(action)) {
                    a.a().b((a) intent.getSerializableExtra("cache"));
                } else if ("post_cache".equals(action)) {
                    a.a().c();
                } else if ("wirte_delay".equals(action)) {
                    e.a().b((a) intent.getSerializableExtra("delay"));
                } else if ("postdelay".equals(action)) {
                    e.a().c();
                } else if ("pollingcheck".equals(action)) {
                    MxPollingManager.a().f();
                }
            } catch (Throwable e) {
                i.a("onHandleIntent Exception = ", e);
            }
        }
    }
}
