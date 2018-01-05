package com.vlocker.ui.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import com.vlocker.locker.R;
import com.vlocker.ui.widget.MyAlertController.RecycleListView;

class u extends CursorAdapter {
    final /* synthetic */ RecycleListView a;
    final /* synthetic */ s b;
    private final int c;
    private final int d;

    u(s sVar, Context context, Cursor cursor, boolean z, RecycleListView recycleListView) {
        this.b = sVar;
        this.a = recycleListView;
        super(context, cursor, z);
        Cursor cursor2 = getCursor();
        this.c = cursor2.getColumnIndexOrThrow(this.b.L);
        this.d = cursor2.getColumnIndexOrThrow(this.b.M);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.c));
        this.a.setItemChecked(cursor.getPosition(), cursor.getInt(this.d) == 1);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.b.b.inflate(R.layout.l_select_dialog_multichoice, viewGroup, false);
    }
}
