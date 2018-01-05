package com.vlocker.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.setting.a.a.e;
import com.vlocker.setting.ui.HexagonContentView;
import com.vlocker.setting.ui.HexagonView;
import com.vlocker.setting.ui.a.a;
import com.vlocker.settings.SettingsActivity;
import java.util.List;

public class ManualRepairActivity extends Activity implements OnClickListener {
    private ListView a;
    private TextView b;
    private RelativeLayout c;
    private HexagonView d;
    private HexagonContentView e;
    private TextView f;
    private a g;
    private boolean h;
    private String i;
    private boolean j;
    private List k;
    private boolean l;
    private e m;
    private Handler n = new i(this);

    private void a() {
        if (("from_repair".equals(this.i) && !com.vlocker.setting.a.a.getInstance().finished()) || "from_accessibility".equals(this.i)) {
            SettingsActivity.a((Context) this);
        } else if (this.k != null && this.k.size() == 1 && !TextUtils.isEmpty(((e) this.k.get(0)).getGuideUrl())) {
            SettingsActivity.a((Context) this);
        } else if ("from_repair".equals(this.i) && OneKeySettingActivity.a() != null) {
            OneKeySettingActivity.a().g();
        }
        finish();
    }

    public static void a(Context context, boolean z, String str) {
        Intent intent = new Intent(context, ManualRepairActivity.class);
        intent.putExtra("content_key", z);
        intent.putExtra("from", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void a(e eVar) {
        this.l = true;
        this.m = eVar;
        String str = "Vlocker_Manual_Rescue_Locker_PPC_TF";
        String[] strArr = new String[6];
        strArr[0] = "rescue_name";
        strArr[1] = this.m.getTaskName();
        strArr[2] = "Do";
        strArr[3] = "Start";
        strArr[4] = "status";
        strArr[5] = com.vlocker.c.a.a((Context) this).bp() ? "F" : "NF";
        p.a((Context) this, str, strArr);
    }

    public void onBackPressed() {
        a();
    }

    public void onClick(View view) {
        a();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_manual_repair);
        this.j = true;
        this.h = getIntent().getBooleanExtra("content_key", false);
        this.i = getIntent().getStringExtra("from");
        this.c = (RelativeLayout) findViewById(R.id.ball_layout);
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        LayoutParams layoutParams = (LayoutParams) this.c.getLayoutParams();
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (i * 39) / 64;
        this.c.setLayoutParams(layoutParams);
        this.a = (ListView) findViewById(R.id.repair_manual_listview);
        this.b = (TextView) findViewById(R.id.manual_jump);
        this.d = (HexagonView) findViewById(R.id.setting_hexagon_view);
        this.e = (HexagonContentView) findViewById(R.id.setting_hexagon_content_view);
        this.f = (TextView) findViewById(R.id.setting_hexagon_content_des);
        this.f.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/setting_font.otf"));
        this.d.b();
        this.e.setFinishViewStatus(false);
        this.b.setOnClickListener(this);
        this.g = new a(this);
        this.k = com.vlocker.setting.a.a.getInstance().getMaunalTasks(this.h);
        this.g.a(this.k);
        this.a.setAdapter(this.g);
        if ("from_repair".equals(this.i)) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        if (!(this.k == null || this.k.size() != 1 || TextUtils.isEmpty(((e) this.k.get(0)).getGuideUrl()))) {
            findViewById(R.id.setting_des_content).setVisibility(4);
        }
        String str = "Vlocker_Click_M_Rescue_Locker_PPC_TF";
        String[] strArr = new String[2];
        strArr[0] = "status";
        strArr[1] = com.vlocker.c.a.a((Context) this).bp() ? "F" : "NF";
        p.a((Context) this, str, strArr);
    }

    protected void onResume() {
        super.onResume();
        if (this.j) {
            this.m = null;
        } else if (this.l) {
            com.vlocker.setting.a.a.getInstance(getApplicationContext()).init(this.n, 1);
        } else {
            this.m = null;
        }
        this.j = false;
        this.l = false;
    }
}
