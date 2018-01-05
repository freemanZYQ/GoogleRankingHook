package com.vlocker.setting.common.b;

import android.os.Handler;
import android.os.Message;

public abstract class a {
    protected abstract boolean a(Message message);

    protected abstract boolean b(Message message);

    protected abstract boolean c(Message message);

    public final void clear() {
        clear(null, 0);
    }

    public final void clear(Handler handler, int i) {
        b.a().a(this, 8, handler, i);
    }

    protected abstract boolean d(Message message);

    public final void init() {
        init(null, 0);
    }

    public final void init(Handler handler, int i) {
        b.a().a(this, 1, handler, i);
    }

    public final void save() {
        save(null, 0);
    }

    public final void save(Handler handler, int i) {
        b.a().a(this, 4, handler, i);
    }

    public final void stop() {
        b.a().b();
    }

    public final void update() {
        update(null, 0);
    }

    public final void update(Handler handler, int i) {
        b.a().a(this, 2, handler, i);
    }
}
