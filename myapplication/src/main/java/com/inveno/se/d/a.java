package com.inveno.se.d;

import android.content.Intent;

public class a extends aa {
    private Intent b;

    public a(m mVar) {
        super(mVar);
    }

    public String getMessage() {
        return this.b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
