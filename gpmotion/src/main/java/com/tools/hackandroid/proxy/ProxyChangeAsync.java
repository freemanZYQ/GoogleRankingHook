/*
 * Copyright (c) 2016 John Paul Krause.
 * ProxyChangeAsync.java is part of AndroidProxySetter.
 *
 * AndroidProxySetter is free software: you can redistribute it and/or modify
 * iit under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AndroidProxySetter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AndroidProxySetter.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.tools.hackandroid.proxy;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.tools.hackandroid.util.DLog;

/**
 * Async task that handles executing the proxy change request
 */
public class ProxyChangeAsync {

    private Activity activity;
    private ProxyChangeExecutor executor;
    private ProxyConnectionListener listener;


    public ProxyChangeAsync(Activity activity, ProxyConnectionListener listener) {
        this.activity = activity;
        this.listener = listener;
    }

    public void execute(Intent intent) {
        executor = new ProxyChangeExecutor(activity, this);
        activity.getApplicationContext().registerReceiver(executor, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        executor.executeChange(intent);
    }

    public void cleanWifi(Intent intent){
        executor = new ProxyChangeExecutor(activity, this);
        executor.resetNetWork(intent);
    }


    public void onProgressUpdate(String msg) {
        DLog.d(msg);
    }

    public void onConnectResult(boolean isSuccess) {
        DLog.e("on ConnectResult");
        if(listener!=null) {
            DLog.e("on return listen");
            if (isSuccess) {
                listener.onConnectSuccess();
            } else {
                listener.onConnectFail();
            }
        }
    }

}