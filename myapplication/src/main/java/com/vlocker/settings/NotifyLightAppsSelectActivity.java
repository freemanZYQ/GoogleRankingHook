package com.vlocker.settings;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.model.d;
import com.vlocker.model.g;
import com.vlocker.msg.al;
import java.util.ArrayList;

public class NotifyLightAppsSelectActivity extends Activity implements OnItemClickListener, Runnable {
    private GridView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private g e;
    private ArrayList f;
    private al g;
    private Button h;
    private Button i;
    private Handler j = new bt(this);

    private void a() {
        this.b = (TextView) findViewById(R.id.dialog);
        this.a = (GridView) findViewById(R.id.country_lvcountry);
        this.c = (TextView) findViewById(R.id.vlocker_install_loading);
        this.d = (TextView) findViewById(R.id.app_select_title);
        this.h = (Button) findViewById(R.id.select_light_msg_app_cancle);
        this.i = (Button) findViewById(R.id.select_light_msg_app_ok);
        b();
    }

    private void b() {
        this.a.setOnItemClickListener(this);
        new Thread(this).start();
    }

    private void c() {
        this.d.setText(getResources().getString(R.string.msg_app_select_tip) + " ( " + this.e.b() + "/" + this.f.size() + " ) ");
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.l_msg_light_app_select_letter_sort_layout);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        LayoutParams attributes = getWindow().getAttributes();
        attributes.height = (int) (((double) defaultDisplay.getHeight()) * 0.53d);
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.9d);
        getWindow().setAttributes(attributes);
        a();
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        d dVar = (d) view.getTag();
        dVar.b.toggle();
        boolean isChecked = dVar.b.isChecked();
        this.e.a().put(Integer.valueOf(i), Boolean.valueOf(isChecked));
        this.e.a(i, Boolean.valueOf(isChecked));
        if (this.e.c() != -1) {
            this.e.a(-1);
        }
        c();
        this.e.notifyDataSetChanged();
    }

    public void run() {
        Message message = new Message();
        this.g = new al(this);
        this.f = this.g.d();
        message.what = 1;
        this.j.sendMessage(message);
    }
}
