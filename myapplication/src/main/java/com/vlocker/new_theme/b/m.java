package com.vlocker.new_theme.b;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.new_theme.beans.T_SpecialThemeInfo;
import com.vlocker.new_theme.e.g;
import com.vlocker.theme.imageloader.RecyclingImageView;
import java.util.Date;
import java.util.Locale;

public class m extends a {
    private Context b;
    private g c = null;
    private int d;

    public m(Context context) {
        super(context);
        this.b = context;
        this.d = ((Activity) this.b).getWindowManager().getDefaultDisplay().getWidth();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        OutOfMemoryError outOfMemoryError;
        T_SpecialThemeInfo t_SpecialThemeInfo;
        OutOfMemoryError outOfMemoryError2;
        Date date;
        String toUpperCase;
        CharSequence format;
        T_SpecialThemeInfo t_SpecialThemeInfo2 = null;
        try {
            if (this.a != null && this.a.size() > 0 && i < this.a.size()) {
                t_SpecialThemeInfo2 = (T_SpecialThemeInfo) this.a.get(i);
            }
            if (view == null) {
                try {
                    view = LayoutInflater.from(this.b).inflate(R.layout.t_market_homelistviewitem, null);
                    this.c = new g();
                    this.c.a = (RecyclingImageView) view.findViewById(R.id.imgView);
                    this.c.a.setPressedDark(true);
                    this.c.b = (TextView) view.findViewById(R.id.t_album_title);
                    this.c.d = (TextView) view.findViewById(R.id.t_album_des);
                    this.c.c = (TextView) view.findViewById(R.id.t_album_day);
                    this.c.e = (TextView) view.findViewById(R.id.t_album_month);
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    ((WindowManager) this.b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                    LayoutParams layoutParams = this.c.a.getLayoutParams();
                    layoutParams.width = displayMetrics.widthPixels;
                    layoutParams.height = (int) (((float) displayMetrics.widthPixels) / 2.09f);
                    view.setTag(this.c);
                } catch (OutOfMemoryError e) {
                    outOfMemoryError = e;
                    t_SpecialThemeInfo = t_SpecialThemeInfo2;
                    outOfMemoryError2 = outOfMemoryError;
                    outOfMemoryError2.printStackTrace();
                    date = new Date(t_SpecialThemeInfo.e());
                    toUpperCase = String.format(Locale.ENGLISH, "%tb", new Object[]{date}).toUpperCase();
                    format = String.format("%td", new Object[]{date});
                    this.c.b.setText(t_SpecialThemeInfo.c());
                    this.c.d.setText(t_SpecialThemeInfo.d());
                    this.c.c.setText(format);
                    this.c.e.setText(toUpperCase + ".");
                    this.c.a.setScaleType(ScaleType.FIT_XY);
                    this.c.a.a(t_SpecialThemeInfo.b(), 1, 0);
                    return view;
                }
            }
            this.c = (g) view.getTag();
            t_SpecialThemeInfo = t_SpecialThemeInfo2;
        } catch (OutOfMemoryError e2) {
            outOfMemoryError = e2;
            t_SpecialThemeInfo = null;
            outOfMemoryError2 = outOfMemoryError;
            outOfMemoryError2.printStackTrace();
            date = new Date(t_SpecialThemeInfo.e());
            toUpperCase = String.format(Locale.ENGLISH, "%tb", new Object[]{date}).toUpperCase();
            format = String.format("%td", new Object[]{date});
            this.c.b.setText(t_SpecialThemeInfo.c());
            this.c.d.setText(t_SpecialThemeInfo.d());
            this.c.c.setText(format);
            this.c.e.setText(toUpperCase + ".");
            this.c.a.setScaleType(ScaleType.FIT_XY);
            this.c.a.a(t_SpecialThemeInfo.b(), 1, 0);
            return view;
        }
        date = new Date(t_SpecialThemeInfo.e());
        toUpperCase = String.format(Locale.ENGLISH, "%tb", new Object[]{date}).toUpperCase();
        format = String.format("%td", new Object[]{date});
        this.c.b.setText(t_SpecialThemeInfo.c());
        this.c.d.setText(t_SpecialThemeInfo.d());
        this.c.c.setText(format);
        this.c.e.setText(toUpperCase + ".");
        this.c.a.setScaleType(ScaleType.FIT_XY);
        this.c.a.a(t_SpecialThemeInfo.b(), 1, 0);
        return view;
    }
}
