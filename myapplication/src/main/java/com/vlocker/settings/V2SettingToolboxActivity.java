package com.vlocker.settings;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.model.b;
import com.vlocker.ui.widget.V2SettingHeaderBar;
import java.util.ArrayList;
import java.util.List;

public class V2SettingToolboxActivity extends Activity implements OnClickListener {
    private V2SettingHeaderBar a;
    private View b;
    private CheckBox c;
    private View d;
    private CheckBox e;
    private View f;
    private TextView g;
    private a h = null;
    private ArrayList i = new ArrayList();
    private Handler j;
    private Dialog k;
    private OnItemClickListener l = new cz(this);
    private BaseAdapter m = new db(this);

    private ArrayList a(Context context) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        List queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.media.action.STILL_IMAGE_CAMERA"), 0);
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            if (!"com.intsig.BizCardReader".equals(((ResolveInfo) queryIntentActivities.get(i)).activityInfo.applicationInfo.packageName)) {
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                dc dcVar = new dc();
                dcVar.b = resolveInfo.activityInfo.applicationInfo.packageName;
                dcVar.a = resolveInfo.loadLabel(packageManager).toString().trim();
                dcVar.d = resolveInfo.loadIcon(packageManager);
                arrayList.add(dcVar);
            }
        }
        ArrayList a = b.a(this, arrayList);
        if (a.size() > 0) {
            if ("".equals(this.h.bb())) {
                this.h.B(((dc) a.get(0)).a);
                this.h.z(((dc) a.get(0)).b);
                if (((dc) a.get(0)).c != null) {
                    this.h.A(((dc) a.get(0)).c);
                }
            }
            this.j.post(new cx(this));
        } else {
            this.j.post(new cy(this));
        }
        return a;
    }

    private void a() {
        this.a = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.a.setTitle(getString(R.string.v2_setting_toolbox_and_camera));
        this.a.setBackOnClickListener(new cv(this));
        this.b = findViewById(R.id.switch_open);
        this.c = (CheckBox) findViewById(R.id.switch_check);
        this.c.setChecked(this.h.av());
        this.d = findViewById(R.id.camera_open);
        this.e = (CheckBox) findViewById(R.id.camera_check);
        this.e.setChecked(this.h.aw());
        this.f = findViewById(R.id.camera_app_select_layout);
        this.b.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g = (TextView) findViewById(R.id.camera_app_select_des);
    }

    private void a(int i, ListView listView) {
        int a = l.a(50.0f);
        LayoutParams layoutParams = listView.getLayoutParams();
        if (i > 4) {
            layoutParams.height = (a / 2) + ((listView.getDividerHeight() + a) * 4);
        } else {
            layoutParams.height = ((a + listView.getDividerHeight()) * i) + listView.getDividerHeight();
        }
        listView.setLayoutParams(layoutParams);
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

    private boolean a(CheckBox checkBox) {
        boolean z = !checkBox.isChecked();
        checkBox.setChecked(z);
        return z;
    }

    private void b() {
        if (!this.h.bg()) {
            this.h.S(true);
        }
        this.k = new Builder(this).create();
        this.k.show();
        this.k.setCanceledOnTouchOutside(true);
        Window window = this.k.getWindow();
        View inflate = View.inflate(this, R.layout.l_locker_camera_select_dialog, null);
        ListView listView = (ListView) inflate.findViewById(R.id.l_setting_lockercamera_list);
        listView.setAdapter(this.m);
        listView.setOnItemClickListener(this.l);
        a(this.i.size(), listView);
        window.setContentView(inflate, new LayoutParams((int) ((((float) getResources().getDisplayMetrics().widthPixels) * 7.0f) / 9.0f), -2));
        this.k.setOnDismissListener(new cw(this));
    }

    private void c() {
        this.g.setText(getString(R.string.camera_hasselected) + this.h.bd());
    }

    public void onClick(View view) {
        boolean a;
        String str;
        String[] strArr;
        switch (view.getId()) {
            case R.id.switch_open:
                a = a(this.c);
                this.h.I(a);
                str = "Vlocker_Switch_Show_Toolbox_PPC_TF";
                strArr = new String[2];
                strArr[0] = "status";
                strArr[1] = a ? "On" : "Off";
                p.a((Context) this, str, strArr);
                return;
            case R.id.camera_open:
                a = a(this.e);
                this.h.J(a);
                str = "Vlocker_Switch_Show_Camera_PPC_TF";
                strArr = new String[2];
                strArr[0] = "status";
                strArr[1] = a ? "On" : "Off";
                p.a((Context) this, str, strArr);
                return;
            case R.id.camera_app_select_layout:
                b();
                if (this.h.bg()) {
                    findViewById(R.id.camera_app_select_hint).setVisibility(4);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = a.a((Context) this);
        setContentView(R.layout.l_v2_activity_setting_toolbox);
        this.j = new Handler();
        a();
        new Thread(new cu(this)).start();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        if (this.h.bg()) {
            findViewById(R.id.camera_app_select_hint).setVisibility(4);
        }
    }
}
