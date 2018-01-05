package com.vlocker.l;

import android.content.Context;
import android.media.AudioManager;
import android.text.Html;
import com.vlocker.locker.R;
import com.vlocker.locker.b.ag;

public class am extends a {
    public am(Context context, ag agVar) {
        super(context, agVar);
    }

    public void a() {
        a("android.settings.SOUND_SETTINGS");
    }

    public boolean a(int i) {
        return false;
    }

    public boolean a(b bVar) {
        try {
            AudioManager audioManager = (AudioManager) this.b.getSystemService("audio");
            if (audioManager != null) {
                if (b.SWITCH_OFF == bVar) {
                    audioManager.setRingerMode(0);
                    c();
                    return true;
                } else if (b.SWITCH_ON == bVar) {
                    audioManager.setRingerMode(2);
                    c();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int b() {
        try {
            AudioManager audioManager = (AudioManager) this.b.getSystemService("audio");
            if (audioManager != null && audioManager.getRingerMode() == 2) {
                return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void c() {
        CharSequence fromHtml;
        String string = this.b.getString(R.string.toast_type_ringtone);
        if (b() == 1) {
            fromHtml = Html.fromHtml(this.b.getString(R.string.toast_template_on, new Object[]{string}));
        } else {
            fromHtml = Html.fromHtml(this.b.getString(R.string.toast_template_off, new Object[]{string}));
        }
        a(fromHtml);
    }
}
