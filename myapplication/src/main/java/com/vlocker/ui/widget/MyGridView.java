package com.vlocker.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MyGridView extends GridView {
    public static boolean a = false;
    private OnItemClickListener b;
    private OnItemLongClickListener c;
    private int d = -1;
    private View e = null;
    private int f = -1;
    private ArrayList g = new ArrayList();
    private ArrayList h = new ArrayList();
    private ListAdapter i;
    private ae j;

    public MyGridView(Context context) {
        super(context);
        a();
    }

    public MyGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MyGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
    }

    @TargetApi(16)
    private int getColumnWidthCompatible() {
        if (VERSION.SDK_INT >= 16) {
            return super.getColumnWidth();
        }
        try {
            Field declaredField = GridView.class.getDeclaredField("mColumnWidth");
            declaredField.setAccessible(true);
            return declaredField.getInt(this);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private ae getItemClickHandler() {
        if (this.j == null) {
            this.j = new ae();
        }
        return this.j;
    }

    @TargetApi(11)
    private int getNumColumnsCompatible() {
        if (VERSION.SDK_INT >= 11) {
            return super.getNumColumns();
        }
        try {
            Field declaredField = GridView.class.getDeclaredField("mNumColumns");
            declaredField.setAccessible(true);
            return declaredField.getInt(this);
        } catch (Exception e) {
            if (this.d != -1) {
                return this.d;
            }
            throw new RuntimeException("Can not determine the mNumColumns for this API platform, please call setNumColumns to set it.");
        }
    }

    public int getFooterViewCount() {
        return this.h.size();
    }

    public int getHeaderViewCount() {
        return this.g.size();
    }

    @TargetApi(16)
    public int getHorizontalSpacing() {
        try {
            if (VERSION.SDK_INT >= 16) {
                return super.getHorizontalSpacing();
            }
            Field declaredField = GridView.class.getDeclaredField("mHorizontalSpacing");
            declaredField.setAccessible(true);
            return declaredField.getInt(this);
        } catch (Exception e) {
            return 0;
        }
    }

    public ListAdapter getOriginalAdapter() {
        return this.i;
    }

    public int getRowHeight() {
        if (this.f > 0) {
            return this.f;
        }
        ListAdapter adapter = getAdapter();
        int numColumnsCompatible = getNumColumnsCompatible();
        if (adapter == null || adapter.getCount() <= (this.g.size() + this.h.size()) * numColumnsCompatible) {
            return -1;
        }
        int columnWidthCompatible = getColumnWidthCompatible();
        View view = getAdapter().getView(numColumnsCompatible * this.g.size(), this.e, this);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2, 0);
            view.setLayoutParams(layoutParams);
        }
        view.measure(getChildMeasureSpec(MeasureSpec.makeMeasureSpec(columnWidthCompatible, 1073741824), 0, layoutParams.width), getChildMeasureSpec(MeasureSpec.makeMeasureSpec(0, 0), 0, layoutParams.height));
        this.e = view;
        this.f = view.getMeasuredHeight();
        return this.f;
    }

    @TargetApi(16)
    public int getVerticalSpacing() {
        try {
            if (VERSION.SDK_INT >= 16) {
                return super.getVerticalSpacing();
            }
            Field declaredField = GridView.class.getDeclaredField("mVerticalSpacing");
            declaredField.setAccessible(true);
            return declaredField.getInt(this);
        } catch (Exception e) {
            return 0;
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e = null;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof ad)) {
            ((ad) adapter).a(getNumColumnsCompatible());
            ((ad) adapter).b(getRowHeight());
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        this.i = listAdapter;
        if (this.g.size() > 0 || this.h.size() > 0) {
            ListAdapter adVar = new ad(this.g, this.h, listAdapter);
            int numColumnsCompatible = getNumColumnsCompatible();
            if (numColumnsCompatible > 1) {
                adVar.a(numColumnsCompatible);
            }
            adVar.b(getRowHeight());
            super.setAdapter(adVar);
            return;
        }
        super.setAdapter(listAdapter);
    }

    public void setClipChildren(boolean z) {
    }

    public void setClipChildrenSupper(boolean z) {
        super.setClipChildren(false);
    }

    public void setNumColumns(int i) {
        super.setNumColumns(i);
        this.d = i;
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof ad)) {
            ((ad) adapter).a(i);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.b = onItemClickListener;
        super.setOnItemClickListener(getItemClickHandler());
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.c = onItemLongClickListener;
        super.setOnItemLongClickListener(getItemClickHandler());
    }
}
