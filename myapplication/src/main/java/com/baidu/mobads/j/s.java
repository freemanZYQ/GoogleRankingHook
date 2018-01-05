package com.baidu.mobads.j;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;

public class s implements IXAdViewUtils {
    private boolean a(View view) {
        return view.getWidth() > 15 && view.getHeight() > 15;
    }

    public int getViewState(View view) {
        return !isScreenOn(view.getContext()) ? 4 : !isAdViewShown(view) ? 1 : !a(view) ? 6 : !isVisible(view, 50) ? 3 : 0;
    }

    public int getVisiblePercent(View view, Context context) {
        if (view == null) {
            return 0;
        }
        try {
            if (!view.isShown()) {
                return 0;
            }
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i = displayMetrics.heightPixels;
            int i2 = displayMetrics.widthPixels;
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            if (rect.top > i || rect.left > i2) {
                return 0;
            }
            double width = (double) (rect.width() * rect.height());
            return (int) ((width * 100.0d) / ((double) (view.getHeight() * view.getWidth())));
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean isAdViewOutsideScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect windowRect = m.a().m().getWindowRect(view.getContext());
        int width = iArr[0] + (view.getWidth() / 2);
        int height = iArr[1] + (view.getHeight() / 2);
        return width <= 0 || width >= windowRect.width() || height <= 0 || height >= windowRect.height();
    }

    public boolean isAdViewShown(View view) {
        return view != null && view.isShown();
    }

    public boolean isAdViewTooSmall(View view) {
        return view != null && (view.getWidth() < 10 || view.getHeight() < 10);
    }

    public boolean isScreenOn(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return ((Boolean) powerManager.getClass().getMethod("isScreenOn", new Class[0]).invoke(powerManager, new Object[0])).booleanValue();
        } catch (Throwable e) {
            m.a().f().d(e);
            return true;
        }
    }

    public boolean isVisible(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        long height = ((long) view.getHeight()) * ((long) view.getWidth());
        return height > 0 && (((long) rect.height()) * ((long) rect.width())) * 100 >= height * ((long) i);
    }
}
