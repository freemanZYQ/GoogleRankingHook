package com.vlocker.ui.widget.a;

import android.graphics.Color;
import android.text.TextUtils;

public class q extends d {
    public String A;
    public String B;
    public String C;
    public String D;
    public int E = -1;
    public int F = 0;
    public int G = 0;
    public int H;
    public int I;
    public boolean J = false;
    public int K;
    public int[] L = null;
    public String M = "number";
    public String N;
    public boolean O = false;
    public int P = 255;
    public float Q = 0.0f;
    public int x = 24;
    public int y = -1;
    public int z = -1;

    public void A(String str) {
        if (str != null) {
            this.B = str;
        }
    }

    public void B(String str) {
        if (str != null) {
            this.C = str;
        }
    }

    public void C(String str) {
        if (str != null) {
            this.D = str;
        }
    }

    public void D(String str) {
        if (str != null) {
            try {
                this.E = Color.parseColor(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void E(String str) {
        if (str != null) {
            try {
                this.F = Color.parseColor(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void F(String str) {
        if (str != null) {
            try {
                this.G = Color.parseColor(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void G(String str) {
        if (str != null) {
            this.H = Integer.parseInt(str);
        }
    }

    public void H(String str) {
        if (str != null) {
            this.I = Color.parseColor(str);
        }
    }

    public void I(String str) {
        if ("true".equals(str)) {
            this.J = true;
        } else {
            this.J = false;
        }
    }

    public void J(String str) {
        if (str != null) {
            this.K = Integer.parseInt(str);
        }
    }

    public void K(String str) {
        if (str != null) {
            String[] split = str.split(",");
            if (split != null && split.length > 0) {
                this.L = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    this.L[i] = Integer.parseInt(split[i]);
                }
            }
        }
    }

    public void L(String str) {
        if (str != null) {
            this.M = str;
        }
    }

    public void M(String str) {
        if (str != null) {
            this.N = str;
        }
    }

    public void N(String str) {
        if (str != null && !str.equals("")) {
            if (str.equals("true")) {
                this.O = true;
            } else {
                this.O = false;
            }
        }
    }

    public void O(String str) {
        if (str != null) {
            this.P = Integer.parseInt(str);
        }
    }

    public void P(String str) {
        if (str != null) {
            this.Q = Float.parseFloat(str);
        }
    }

    public boolean a() {
        return ((this.F == this.G || this.F == 0 || this.G == 0) && ((this.y == this.z || this.y == -1 || this.z == -1) && (TextUtils.isEmpty(this.C) || TextUtils.isEmpty(this.D) || this.C.equals(this.D)))) ? false : true;
    }

    public void w(String str) {
        if (str != null) {
            this.x = Integer.parseInt(str);
        }
    }

    public void x(String str) {
        if (str != null) {
            this.y = Integer.parseInt(str);
        }
    }

    public void y(String str) {
        if (str != null) {
            this.z = Integer.parseInt(str);
        }
    }

    public void z(String str) {
        if (str != null) {
            this.A = str;
        }
    }
}
