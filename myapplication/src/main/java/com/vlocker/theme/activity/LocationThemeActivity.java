package com.vlocker.theme.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vlocker.b.i;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.theme.a.b;
import com.vlocker.theme.f.c;
import com.vlocker.theme.f.e;
import com.vlocker.theme.model.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LocationThemeActivity extends ThemeBaseActivity implements OnClickListener {
    Handler a = new a(this);
    Runnable b = new c(this);
    private GridView c;
    private TextView d;
    private b e;
    private LinkedList f = new LinkedList();
    private List g = new LinkedList();
    private List h = new LinkedList();
    private TextView i;
    private int j = 0;
    private LinearLayout k;
    private OnItemClickListener l = new d(this);

    private void a() {
        if (e.c((Context) this)) {
            finish();
        } else {
            finish();
        }
    }

    public static void a(Context context) {
        try {
            context.startActivity(new Intent(context, LocationThemeActivity.class));
        } catch (Exception e) {
        }
    }

    private void a(List list) {
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        if (list != null && list.size() > 0) {
            Collections.sort(list, new b(this));
        }
    }

    private List b(String str) {
        List arrayList = new ArrayList();
        if (this.j == 0 && i.j.equals(str)) {
            a aVar = new a();
            aVar.a(false);
            aVar.b("");
            aVar.a("默认主题");
            aVar.b(true);
            aVar.a(Long.MAX_VALUE);
            arrayList.add(aVar);
        }
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (name.endsWith(".mx")) {
                        a aVar2 = new a();
                        aVar2.a(false);
                        aVar2.b(file2.getPath());
                        aVar2.a(file2.lastModified());
                        String b = c.b(this, file2.getPath(), 1);
                        if (b != null) {
                            aVar2.a(name);
                            aVar2.b(true);
                            arrayList.add(aVar2);
                        } else if (b == null && i.j.equals(str)) {
                            a(file2.getPath());
                        }
                    }
                }
            }
        } else if (!str.equals(i.i)) {
            this.f.addAll(arrayList);
        }
        return arrayList;
    }

    private void b() {
        switch (this.j) {
            case 0:
                this.d.setText(getString(R.string.l_theme_location_title));
                this.i.setText(getString(R.string.local_theme_edit));
                return;
            case 1:
                Iterator it = this.f.iterator();
                int i = 0;
                while (it.hasNext()) {
                    i = ((a) it.next()).b() ? i + 1 : i;
                }
                this.d.setText(getString(R.string.btn_cancel));
                this.i.setText(String.format(getResources().getString(R.string.local_theme_delete), new Object[]{Integer.valueOf(i)}));
                if (i == 0) {
                    this.i.setTextColor(getResources().getColor(R.color.gray));
                    return;
                } else {
                    this.i.setTextColor(getResources().getColor(R.color.textColorPrimary));
                    return;
                }
            case 2:
                this.d.setText(getString(R.string.btn_cancel));
                c();
                return;
            default:
                return;
        }
    }

    private void c() {
        Iterator it = this.f.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((a) it.next()).b() ? i + 1 : i;
        }
        if (i == 0) {
            this.j = 1;
            b();
            return;
        }
        Iterator it2 = this.f.iterator();
        while (it2.hasNext()) {
            a aVar = (a) it2.next();
            if (aVar.b()) {
                a(aVar.c());
            }
        }
        this.j = 0;
        new Thread(this.b).start();
    }

    public void a(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public void onClick(View view) {
        int i;
        switch (view.getId()) {
            case R.id.l_theme_title:
                if (this.j == 0) {
                    a();
                    return;
                }
                this.j = 0;
                for (i = 0; i < this.f.size(); i++) {
                    ((a) this.f.get(i)).a(false);
                }
                new Thread(this.b).start();
                return;
            case R.id.l_theme_location_edit:
                switch (this.j) {
                    case 0:
                        p.a((Context) this, "Vlocker_Edit_Themes_PPC_TF", new String[0]);
                        break;
                    case 1:
                        Iterator it = this.f.iterator();
                        i = 0;
                        while (it.hasNext()) {
                            i = ((a) it.next()).b() ? i + 1 : i;
                        }
                        if (i > 0) {
                            p.a((Context) this, "Vlocker_Delete_Themes_PPC_TF", "num", "" + i);
                            break;
                        }
                        break;
                }
                if (this.f.size() != 0) {
                    this.j++;
                    if (this.j > 2) {
                        this.j = 0;
                    }
                }
                if (this.j == 1) {
                    new Thread(this.b).start();
                    return;
                } else {
                    b();
                    return;
                }
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.l_theme_personalization_list);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        if (com.vlocker.c.a.a((Context) this).ay() != i) {
            com.vlocker.c.a.a((Context) this).m(i);
        }
        this.k = (LinearLayout) findViewById(R.id.allthemes_wait_layout);
        this.d = (TextView) findViewById(R.id.l_theme_title);
        this.d.setOnClickListener(this);
        this.c = (GridView) findViewById(R.id.gridview);
        this.i = (TextView) findViewById(R.id.l_theme_location_edit);
        this.i.setVisibility(0);
        this.i.setOnClickListener(this);
        this.e = new b(this, this.f);
        this.c.setAdapter(this.e);
        this.c.setOnItemClickListener(this.l);
        new Thread(this.b).start();
        p.a((Context) this, "Vlocker_Click_Local_Theme_PPC_TF", new String[0]);
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            System.gc();
        } catch (Exception e) {
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.j == 0) {
                a();
            } else {
                this.j = 0;
                for (int i2 = 0; i2 < this.f.size(); i2++) {
                    ((a) this.f.get(i2)).a(false);
                }
                new Thread(this.b).start();
            }
        }
        return false;
    }
}
