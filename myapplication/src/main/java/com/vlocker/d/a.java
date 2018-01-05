package com.vlocker.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.m.ap;

public class a implements OnClickListener {
    private b a;
    private Activity b;
    private com.vlocker.c.a c = com.vlocker.c.a.a(this.b);
    private AlertDialog d = new Builder(this.b).create();
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;

    public a(Activity activity, b bVar) {
        this.b = activity;
        this.a = bVar;
        this.d.show();
        this.d.setCanceledOnTouchOutside(true);
        Window window = this.d.getWindow();
        window.setContentView(View.inflate(activity, R.layout.redpacket_voice_select_dialog, null), new LayoutParams((int) ((((float) this.b.getResources().getDisplayMetrics().widthPixels) * 7.0f) / 9.0f), -2));
        window.findViewById(R.id.voice_prompt_1_layout).setOnClickListener(this);
        window.findViewById(R.id.voice_prompt_2_layout).setOnClickListener(this);
        window.findViewById(R.id.voice_prompt_3_layout).setOnClickListener(this);
        window.findViewById(R.id.voice_prompt_4_layout).setOnClickListener(this);
        window.findViewById(R.id.voice_prompt_5_layout).setOnClickListener(this);
        window.findViewById(R.id.voice_prompt_6_layout).setOnClickListener(this);
        window.findViewById(R.id.voice_prompt_7_layout).setOnClickListener(this);
        this.e = (ImageView) window.findViewById(R.id.voice_prompt_1_img);
        this.f = (ImageView) window.findViewById(R.id.voice_prompt_2_img);
        this.g = (ImageView) window.findViewById(R.id.voice_prompt_3_img);
        this.h = (ImageView) window.findViewById(R.id.voice_prompt_4_img);
        this.i = (ImageView) window.findViewById(R.id.voice_prompt_5_img);
        this.j = (ImageView) window.findViewById(R.id.voice_prompt_6_img);
        this.k = (ImageView) window.findViewById(R.id.voice_prompt_7_img);
        a();
    }

    private void a() {
        int by = this.c.by();
        a(this.e, false);
        a(this.f, false);
        a(this.g, false);
        a(this.h, false);
        a(this.i, false);
        a(this.j, false);
        a(this.k, false);
        if (by == 0) {
            a(this.e, true);
        } else if (by == 1) {
            a(this.f, true);
        } else if (by == 2) {
            a(this.g, true);
        } else if (by == 3) {
            a(this.h, true);
        } else if (by == 4) {
            a(this.i, true);
        } else if (by == 5) {
            a(this.j, true);
        } else if (by == 6) {
            a(this.k, true);
        }
        this.a.a(true);
    }

    private void a(ImageView imageView, boolean z) {
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageResource(R.drawable.l_theme_color_selected);
        } else {
            imageView.setImageResource(R.drawable.l_v2_checkbox_circle_normal);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.voice_prompt_1_layout:
                this.c.B(0);
                a();
                p.a(this.b.getApplicationContext(), "Vlocker_Ringtone_Hongbao_Settings_PPC_TF", "ringtone", this.b.getResources().getString(R.string.voice_prompt_1));
                break;
            case R.id.voice_prompt_2_layout:
                this.c.B(1);
                a();
                p.a(this.b.getApplicationContext(), "Vlocker_Ringtone_Hongbao_Settings_PPC_TF", "ringtone", this.b.getResources().getString(R.string.voice_prompt_2));
                break;
            case R.id.voice_prompt_3_layout:
                this.c.B(2);
                a();
                p.a(this.b.getApplicationContext(), "Vlocker_Ringtone_Hongbao_Settings_PPC_TF", "ringtone", this.b.getResources().getString(R.string.voice_prompt_3));
                break;
            case R.id.voice_prompt_4_layout:
                this.c.B(3);
                a();
                p.a(this.b.getApplicationContext(), "Vlocker_Ringtone_Hongbao_Settings_PPC_TF", "ringtone", this.b.getResources().getString(R.string.voice_prompt_4));
                break;
            case R.id.voice_prompt_5_layout:
                this.c.B(4);
                a();
                p.a(this.b.getApplicationContext(), "Vlocker_Ringtone_Hongbao_Settings_PPC_TF", "ringtone", this.b.getResources().getString(R.string.voice_prompt_5));
                break;
            case R.id.voice_prompt_6_layout:
                this.c.B(5);
                a();
                p.a(this.b.getApplicationContext(), "Vlocker_Ringtone_Hongbao_Settings_PPC_TF", "ringtone", this.b.getResources().getString(R.string.voice_prompt_6));
                break;
            case R.id.voice_prompt_7_layout:
                this.c.B(6);
                a();
                p.a(this.b.getApplicationContext(), "Vlocker_Ringtone_Hongbao_Settings_PPC_TF", "ringtone", this.b.getResources().getString(R.string.voice_prompt_7));
                break;
        }
        ap.a(this.b).a("red_packet_voice_" + (this.c.by() + 1) + ".mp3");
        this.d.dismiss();
    }
}
