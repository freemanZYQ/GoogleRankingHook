package com.ndk.test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by apple on 16/12/8.
 */
public class BasicService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

//        try {
//            new DroidGuardHelper().guard(this);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
