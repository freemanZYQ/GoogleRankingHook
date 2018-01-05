package com.vlocker.m;

import android.os.AsyncTask;
import com.vlocker.locker.a.a;

final class d extends AsyncTask {
    Object a;
    final /* synthetic */ a b;

    d(a aVar) {
        this.b = aVar;
    }

    protected Boolean a(Void... voidArr) {
        this.a = this.b.b();
        return Boolean.valueOf(true);
    }

    protected void a(Boolean bool) {
        if (this.a != null) {
            this.b.a(this.a);
        } else {
            this.b.c();
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected void onCancelled() {
        this.b.c();
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Boolean) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.b.a();
    }
}
