package com.ndk.test;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by apple on 16/12/16.
 */
public class BackgroundService extends Service {

    public String TAG = "backgroundRN";
    public HeartBeatRunnable heartBeatRunnable;
    public ScheduledFuture mScheduledFuture;
    public ScheduledExecutorService mExecutorService;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"服务已启动");
        scheduledWithFixedDelay(500);
        return Service.START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void scheduledWithFixedDelay(long duration) {
        try {
            if (mExecutorService == null) {
                mExecutorService = Executors.newScheduledThreadPool(1);
            }
            if (mScheduledFuture == null || (mScheduledFuture != null && mScheduledFuture.isCancelled())) {
                    if (heartBeatRunnable == null) {
                        heartBeatRunnable = new HeartBeatRunnable(this);
                    }
                    mScheduledFuture = mExecutorService.scheduleWithFixedDelay(heartBeatRunnable,
                            3,
                            duration,
                            TimeUnit.MILLISECONDS);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
