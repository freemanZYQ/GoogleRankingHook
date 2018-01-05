package com.vlocker.security;

import android.content.Context;
import com.vlocker.b.j;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

final class i implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ File c;

    i(String str, Context context, File file) {
        this.a = str;
        this.b = context;
        this.c = file;
    }

    public void run() {
        try {
            if (j.a(this.b, new JSONObject(this.a), j.a(8))) {
                this.c.delete();
            }
        } catch (JSONException e) {
            this.c.delete();
        } catch (Exception e2) {
            this.c.delete();
        }
    }
}
