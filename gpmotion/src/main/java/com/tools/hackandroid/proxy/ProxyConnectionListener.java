package com.tools.hackandroid.proxy;

/**
 * Created by bintou on 16/9/22.
 */

public interface ProxyConnectionListener {

    public void onConnectSuccess();

    public void onConnectFail();

    public void onConnectError();


}
