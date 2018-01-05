package com.vlocker.m;

import android.app.usage.UsageEvents;
import android.app.usage.UsageEvents.Event;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Build.VERSION;
import java.util.List;

public class bb {
    public static boolean a() {
        return VERSION.SDK_INT > 20;
    }

    public static boolean a(Context context) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            List queryUsageStats = ((UsageStatsManager) context.getSystemService("usagestats")).queryUsageStats(4, currentTimeMillis - 3600000, currentTimeMillis);
            return (queryUsageStats == null || queryUsageStats.isEmpty()) ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String b(Context context) {
        UsageEvents queryEvents = ((UsageStatsManager) context.getSystemService("usagestats")).queryEvents(System.currentTimeMillis() - 3600000, System.currentTimeMillis());
        String str = "";
        String str2 = "";
        while (queryEvents.hasNextEvent()) {
            Event event = new Event();
            queryEvents.getNextEvent(event);
            if (event.getEventType() == 1) {
                str = event.getPackageName();
                str2 = event.getClassName();
            }
        }
        return (str + " " + str2).toLowerCase();
    }
}
