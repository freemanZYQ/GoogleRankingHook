package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

public class b implements Serializable {
    public final HashMap a = new HashMap();

    public b(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.a.put(str, bundle.getString(str));
            }
        }
    }
}
