package com.tools.hackandroid.gp;

import android.os.Message;

import net.luna.common.debug.LunaLog;
import net.luna.common.util.HttpUtils;
import net.luna.common.util.StringUtils;
import net.luna.common.util.ThreadUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bintou on 2016/10/21.
 */

public class SmsVerifier {

    String phoneNum;
    int retryTime = 0;
    int phomeretryTime = 0;
    String smsToken;
    WebViewLoginService service;

    public SmsVerifier(WebViewLoginService service) {
        this.service = service;
    }

    public void getPhoneNum() {


        ThreadUtils.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    LunaLog.d("请求电话号码");
                    phomeretryTime++;
                    smsToken = HttpUtils.httpGetString("http://api.ema6.com:20161/Api/userLogin?uName=mosida&pWord=jianqiao098");
                    LunaLog.d("phone token" + smsToken);
                    if (StringUtils.isBlank(smsToken)) {
                        if (phomeretryTime >= 5) {
                            Message phoneMsg = new Message();
                            phoneMsg.what = WebViewLoginService.INIT;
                            service.getHandler().sendMessage(phoneMsg);
                            phomeretryTime = 0;
                            return;
                        }
                        LunaLog.d("请求失败");
                        getPhoneNum();
                        return;
                    }
                    smsToken = smsToken.replace("\n", "");

                    String url = "http://api.ema6.com:20161/Api/userGetPhone?ItemId=133&token=" + smsToken + "&PhoneType=0";
                    LunaLog.d("url: " + url);
                    phoneNum = HttpUtils.httpGetString(url);
                    if (!StringUtils.isBlank(phoneNum)) {
                        phoneNum = phoneNum.replace(";", "").replace("\n", "");
                        LunaLog.d(phoneNum);
                        phomeretryTime = 0;

                        if (service.getHandler().currentStep == 4) {
                            Message phoneMsg = new Message();
                            phoneMsg.what = WebViewLoginService.GET_PHONE_NUMBER;
                            phoneMsg.obj = phoneNum;
                            service.getHandler().sendMessage(phoneMsg);
                        }
                        return;
                    } else {
                        LunaLog.d("请求失败");
                    }
                } catch (Exception e) {
                    LunaLog.e(e);
                }
            }
        });
    }

    public void getSms() {
        ThreadUtils.execute(new Runnable() {
            @Override
            public void run() {
                if (smsToken == null) {
                    LunaLog.d("先获取号码");
                    return;
                }
                LunaLog.d("http://api.ema6.com:20161/Api/userGetMessage?token=" + smsToken + "&Code=UTF8");
                String smsCode = HttpUtils.httpGetString("http://api.ema6.com:20161/Api/userGetMessage?token=" + smsToken + "&Code=UTF8");

//                LunaLog.d(url);

                LunaLog.d("smscode: " + smsCode);

                String releaseUrl = "http://api.ema6.com:20161/Api/userReleasePhone?token=" + smsToken + "&phoneList=" + phoneNum + "-133";
                if (smsCode.contains("Null") || smsCode.contains("null") || smsCode.contains("False")) {
                    retryTime++;
                } else {
                    retryTime = 0;
                    HttpUtils.httpGet(releaseUrl);

                    Pattern pattern = Pattern.compile("G-([0-9]{6})");
                    Matcher matcher = pattern.matcher(smsCode);
                    if (matcher.find()) {
                        smsCode = matcher.group(0);
                        smsCode = smsCode.replace("G-", "");
                    }
                }

                Message message = new Message();

                message.what = service.GET_PHONE_MSG;
                message.obj = smsCode;
                service.getHandler().sendMessage(message);

                if (retryTime > 10) {
                    retryTime = 0;

                    HttpUtils.httpGet(releaseUrl);
                    LunaLog.d("超过重载次数,请重新获取电话号码");
                }
            }
        });
    }


    public void putInBlackList() {
        ThreadUtils.execute(new Runnable() {
            @Override
            public void run() {
                String url = "http://api.ema6.com:20161/Api/userAddBlack?token=" + smsToken + "&phoneList=133-" + phoneNum;
                LunaLog.d("加入黑名单 : " + url);
                HttpUtils.httpGet(url);
            }
        });


    }

}
