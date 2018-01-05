package com.vlocker.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.m.l;

public class ao extends Dialog {
    public TextView a;
    public TextView b;
    public TextView c;
    public Button d;
    public Button e;
    public View f;
    public ImageView g;
    private Context h;
    private int i = 0;
    private Window j = null;
    private float k = 0.85714287f;

    public ao(Context context, int i) {
        super(context, i);
        this.h = context;
    }

    public void a(int i) {
        setContentView(i);
        Window window = getWindow();
        window.addFlags(1);
        window.setGravity(17);
        window.setLayout((int) (((float) l.a()) * this.k), -2);
        this.d = (Button) findViewById(R.id.new_sure_btn);
        this.a = (TextView) findViewById(R.id.dialog_title);
        this.e = (Button) findViewById(R.id.close_dialog);
        show();
    }

    public void a(int i, int i2, int i3) {
        setContentView(i);
        Window window = getWindow();
        window.addFlags(1);
        window.setGravity(17);
        window.setLayout((int) (((float) l.a()) * this.k), -2);
        this.d = (Button) findViewById(R.id.new_sure_btn);
        this.a = (TextView) findViewById(R.id.dialog_title);
        this.b = (TextView) findViewById(R.id.dialog_title_ver);
        this.c = (TextView) findViewById(R.id.dialog_content);
        this.e = (Button) findViewById(R.id.close_dialog);
        this.f = findViewById(R.id.close_dialog_layout);
        show();
    }

    public void a(int i, boolean z) {
        setContentView(i);
        Window window = getWindow();
        window.addFlags(1);
        window.setGravity(17);
        if (z) {
            window.setLayout((int) (((float) l.a()) * 0.6f), -2);
        } else {
            window.setLayout((int) (((float) l.a()) * this.k), -2);
        }
        this.d = (Button) findViewById(R.id.new_sure_btn);
        this.g = (ImageView) findViewById(R.id.dialog_img);
        this.a = (TextView) findViewById(R.id.dialog_title);
        show();
    }

    public void b(int i) {
        setContentView(i);
        Window window = getWindow();
        window.addFlags(1);
        window.setGravity(17);
        window.setLayout((int) (((float) l.a()) * this.k), -2);
        this.d = (Button) findViewById(R.id.new_sure_btn);
        this.a = (TextView) findViewById(R.id.dialog_title);
        show();
    }

    public void c(int i) {
        setContentView(i);
        Window window = getWindow();
        window.addFlags(1);
        window.setGravity(17);
        window.setLayout((int) (((float) l.a()) * this.k), -2);
        this.d = (Button) findViewById(R.id.new_sure_btn);
        this.e = (Button) findViewById(R.id.close_dialog);
        show();
    }
}
