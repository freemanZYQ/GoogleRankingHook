package com.vlocker.m;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.search.ba;

public class au implements OnClickListener {
    private static final LayoutParams d = new LayoutParams(-1, -2);
    private av a;
    private AlertDialog b;
    private Context c;

    public au(Context context, av avVar, boolean z) {
        this.a = avVar;
        this.b = new Builder(context).create();
        this.c = context;
        this.b.show();
        this.b.setCanceledOnTouchOutside(true);
        Window window = this.b.getWindow();
        window.setContentView(View.inflate(context, R.layout.l_starry_select_dialog, null), new LayoutParams(-2, -2));
        LinearLayout linearLayout = (LinearLayout) window.findViewById(R.id.starry_gitem);
        for (int i = 0; i < 6; i++) {
            linearLayout.addView(a(i));
        }
    }

    private View a(int i) {
        View inflate = View.inflate(this.c, R.layout.l_starry_grid_iten, null);
        inflate.findViewById(R.id.starry_layout1).setOnClickListener(this);
        inflate.findViewById(R.id.starry_layout1).setTag(ba.c[i]);
        ((TextView) inflate.findViewById(R.id.starry_name1)).setText(ba.d[i]);
        ((TextView) inflate.findViewById(R.id.starry_date1)).setText(ba.j[i]);
        inflate.findViewById(R.id.starry_layout2).setOnClickListener(this);
        inflate.findViewById(R.id.starry_layout2).setTag(ba.c[i + 6]);
        ((TextView) inflate.findViewById(R.id.starry_name2)).setText(ba.d[i + 6]);
        ((TextView) inflate.findViewById(R.id.starry_date2)).setText(ba.j[i + 6]);
        return inflate;
    }

    public void onClick(View view) {
        String str = (String) view.getTag();
        if (this.a != null) {
            this.a.a(str);
        }
        if (this.b != null) {
            this.b.dismiss();
        }
    }
}
