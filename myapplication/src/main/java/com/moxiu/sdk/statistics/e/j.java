package com.moxiu.sdk.statistics.e;

public class j {
    public static boolean a() {
        try {
            if (Runtime.getRuntime().exec("ping -c 1 -w 10 " + "www.baidu.com").waitFor() == 0) {
                i.a("pingBaidu success");
                return true;
            }
            i.a("pingBaidu failed");
            return false;
        } catch (Exception e) {
            i.b("pingBaidu Exception");
            return false;
        }
    }
}
