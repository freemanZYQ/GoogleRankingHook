package com.vlocker.ui.widget.a;

import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.vlocker.ui.cover.h;

public class r extends q {
    public int a;
    public int b = 1;
    public int c = 1;
    public int d = 1;
    public int e = 1;
    public int r = 1;
    public int s = 1;
    public int t = 1;
    public String u;

    public void Q(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.j = Boolean.parseBoolean(str);
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("right".equals(str)) {
                h.a = 1;
            } else if ("bottom".equals(str)) {
                h.a = 2;
            } else if ("top".equals(str)) {
                h.a = 3;
            }
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("all".equals(str)) {
                h.b = 1;
            } else if ("unlock".equals(str)) {
                h.b = 2;
            } else if ("unlock_notbg".equals(str)) {
                h.b = 4;
            }
        }
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a = Integer.parseInt(str);
        }
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("all".equals(str)) {
                h.c = 1;
            } else if ("unlock".equals(str)) {
                h.c = 2;
            }
        }
    }

    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("visibility".equals(str)) {
                this.c = 1;
            } else if ("gone".equals(str)) {
                this.c = 2;
            }
        }
    }

    public void q(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("false".equals(str)) {
                h.d = 1;
            } else if ("true".equals(str)) {
                h.d = 2;
            }
        }
    }

    public void r(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("toLeft".equals(str)) {
                h.e = 1;
            } else if ("toTop".equals(str)) {
                h.e = 2;
            } else if ("toBottom".equals(str)) {
                h.e = 3;
            }
        }
    }

    public void s(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("false".equals(str)) {
                h.f = 1;
            } else if ("true".equals(str)) {
                h.f = 2;
            }
        }
    }

    public void t(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (IXAdSystemUtils.NT_NONE.equals(str)) {
                h.g = 1;
            } else if ("flash".equals(str)) {
                h.g = 2;
            } else if ("move".equals(str)) {
                h.g = 3;
            }
        }
    }

    public void u(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("slide".equals(str)) {
                h.h = 1;
            } else if (!"fadeout".equals(str)) {
            } else {
                if (h.a != 1 || h.b != 1) {
                    h.h = 2;
                }
            }
        }
    }

    public void v(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.u = str;
        }
    }
}
