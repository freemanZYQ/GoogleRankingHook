package com.baidu.mobads.openad.f;

import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import com.baidu.mobads.openad.interfaces.utils.IOAdTimer.EventHandler;
import com.qq.e.comm.constants.ErrorCode.InitError;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

public class a implements IOAdTimer {
    private static String c = "OAdTimer";
    protected int a;
    private EventHandler b;
    private int d;
    private int e;
    private int f;
    private Timer g;
    private AtomicInteger h;

    public a(int i) {
        this(i, InitError.INIT_AD_ERROR);
    }

    public a(int i, int i2) {
        this.a = InitError.INIT_AD_ERROR;
        this.a = i2;
        int i3 = i / this.a;
        m.a().f().i(c, "RendererTimer(duration=" + i3 + ")");
        this.d = i3;
        this.e = i3;
        this.g = new Timer();
        this.h = new AtomicInteger(-1);
    }

    public int getCurrentCount() {
        return this.f;
    }

    public int getRepeatCount() {
        return this.d;
    }

    public void pause() {
        m.a().f().i(c, "pause");
        this.h.set(1);
    }

    public void reset() {
        m.a().f().i(c, "reset");
        this.h.set(-1);
        this.e = this.d;
    }

    public void resume() {
        m.a().f().i(c, "resume");
        this.h.set(0);
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.b = eventHandler;
    }

    public void start() {
        m.a().f().i(c, "start");
        this.h.set(0);
        this.g.scheduleAtFixedRate(new b(this), 0, (long) this.a);
    }

    public void stop() {
        m.a().f().i(c, "stop");
        this.h.set(2);
        if (this.g != null) {
            this.g.purge();
            this.g.cancel();
            this.g = null;
        }
    }
}
