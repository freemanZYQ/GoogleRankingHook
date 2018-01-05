package com.vlocker.settings;

import android.graphics.Bitmap;
import android.os.AsyncTask;

class v extends AsyncTask {
    final /* synthetic */ CustomWallPaperActivity a;
    private Runnable b;
    private String c;
    private Bitmap d;

    public v(CustomWallPaperActivity customWallPaperActivity, Runnable runnable, String str, Bitmap bitmap) {
        this.a = customWallPaperActivity;
        this.b = runnable;
        this.c = str;
        this.d = bitmap;
    }

    protected Boolean a(Void... voidArr) {
        return Boolean.valueOf(this.a.a(this.c, this.d));
    }

    protected void a(Boolean bool) {
        super.onPostExecute(bool);
        if (!(this.d == null || this.d.isRecycled())) {
            this.d.recycle();
            this.d = null;
        }
        if (this.b != null) {
            this.b.run();
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Boolean) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }
}
