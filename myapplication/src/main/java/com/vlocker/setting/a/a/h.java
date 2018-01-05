package com.vlocker.setting.a.a;

import com.vlocker.setting.common.a.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class h {
    private String[] a = null;
    private boolean b = true;
    private List c = new ArrayList();

    public String[] getRomNames() {
        return this.a;
    }

    public boolean matched() {
        boolean z = false;
        int i = 0;
        while (i < this.c.size()) {
            boolean matched = ((i) this.c.get(i)).matched();
            if (this.b != matched) {
                return matched;
            }
            i++;
            z = matched;
        }
        return z;
    }

    @b(a = "feature")
    public void setFeature(i iVar) {
        this.c.add(iVar);
    }

    @b(a = "logical")
    public void setLogical(String str) {
        if ("or".equals(str.toLowerCase(Locale.ENGLISH))) {
            this.b = false;
        }
    }

    @b(a = "name")
    public void setRomName(String str) {
        this.a = str.split(",");
    }
}
