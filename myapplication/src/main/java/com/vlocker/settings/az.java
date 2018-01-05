package com.vlocker.settings;

import com.vlocker.locker.R;

class az implements Runnable {
    final /* synthetic */ ay a;

    az(ay ayVar) {
        this.a = ayVar;
    }

    public void run() {
        this.a.b.e.setTextColor(this.a.b.getResources().getColor(R.color.flow_word_text));
        if (this.a.a) {
            this.a.b.e.setText(this.a.b.getString(R.string.v3_pwd_input_number, new Object[]{Integer.valueOf(8)}));
            this.a.b.x = true;
        } else {
            if (this.a.b.y) {
                this.a.b.e.setText(this.a.b.getString(R.string.password_check_again_txt));
            } else {
                this.a.b.e.setText(this.a.b.getString(R.string.v3_pwd_input_number, new Object[]{Integer.valueOf(0)}));
            }
            this.a.b.f();
            this.a.b.x = false;
        }
        this.a.b.C = false;
    }
}
