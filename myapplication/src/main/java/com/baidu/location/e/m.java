package com.baidu.location.e;

import android.os.Environment;
import java.io.File;

class m extends Thread {
    final /* synthetic */ k a;

    m(k kVar) {
        this.a = kVar;
    }

    public void run() {
        this.a.a(new File(Environment.getExternalStorageDirectory() + "/baidu/tempdata", "intime.dat"), "http://itsdata.map.baidu.com/long-conn-gps/sdk.php");
    }
}
