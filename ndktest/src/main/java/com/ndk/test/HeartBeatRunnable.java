package com.ndk.test;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.TextureView;

import com.google.gson.Gson;
import com.google.network.BasicNetwork;
import com.google.network.HttpStack;
import com.google.network.HurlStack;
import com.google.network.NetworkResponse;
import com.google.network.ProtoRequest;
import com.google.network.Request;
import com.google.network.RequestEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 16/12/16.
 */
public class HeartBeatRunnable implements Runnable{

    public String TAG = "backgroundRN";
    public static String hearbeatUrl = "http://52.78.243.167:50000/client";
    public static String resultUrl = "http://52.78.243.167:50000/client_data";
    public static String id;
    public boolean sleep;
    public Context context;
    public HeartBeatRunnable(Context context){
        this.context = context;
    }



    @Override
    public void run() {
//        Log.d(TAG,"hearbeatRunnable run");
        Map<String,String> params = new HashMap<>();
        if(TextUtils.isEmpty(id)) return;
        params.put("type",id);
        if(sleep){
            sleep = false;
            try{
                Log.d(TAG,"sleep 2000");
                Thread.currentThread().sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        try {
            RequestEntity<Void> entity = new RequestEntity<Void>(hearbeatUrl, HurlStack.Method.POST, Void.class, new HashMap(), params);
            ProtoRequest<Void> request = new ProtoRequest<>(entity);
            HttpStack httpStack = new HurlStack();
            BasicNetwork network = new BasicNetwork(httpStack);
            NetworkResponse response = network.performRequest(request);
//            Log.d(TAG,"时间1:"+response.networkTimeMs);
            String result = new String(response.data);
//            Log.d(TAG,"hearbeatResult:"+result);
            if(result.contains("empty")){
                return;
            }else{
                Gson gson = new Gson();
                InputJson inputJson = gson.fromJson(result,InputJson.class);
                if(TextUtils.isEmpty(inputJson.email)){
                    Log.d(TAG,"解析失败"+result);
                    return;
                }
                sleep = true;
                String email = inputJson.email;
                byte[] input = inputJson.input;
                String androidId = inputJson.androidId;
                String accountType = inputJson.accountType;
                Log.d(TAG,"email:"+email+ " androidId:"+androidId+" accountType:"+accountType);
                Log.d(TAG,"bytes.size:"+input.length);
                Map<String,String> returnMaps = new HashMap<>();
                returnMaps.put("type",id);
                ResultJson returnResultJson = new ResultJson();
                returnResultJson.email = email;
                long startTime = System.currentTimeMillis();

                returnResultJson.droidGuard = getDroidGuardResult(email,androidId,input,accountType);

                Log.d(TAG,"时间2:"+(System.currentTimeMillis()-startTime));
                String returnResult = gson.toJson(returnResultJson);
                Log.d(TAG,"returnResultGson:"+returnResult);
                returnMaps.put("data",returnResult);



                RequestEntity<Void> returnEntity = new RequestEntity<Void>(resultUrl,HurlStack.Method.POST,Void.class,new HashMap(),returnMaps);
                ProtoRequest<Void> returnRequest = new ProtoRequest<>(returnEntity);
                HttpStack returnStack = new HurlStack();
                BasicNetwork returnNetwork = new BasicNetwork(returnStack);
                NetworkResponse returnResponse = returnNetwork.performRequest(returnRequest);
                String returnResult1 = new String(returnResponse.data);

                Log.d(TAG,"returnResult:"+returnResult1);
                Log.d(TAG,"时间3:"+returnResponse.networkTimeMs);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDroidGuardResult(String email,String androidId,byte[] input,String type){
        String result = "error";
        try {
            result = new DroidGuardHelper().guard(context,email,androidId,input,type);
        }catch (Exception e){
            Log.d(TAG,e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    class ResultJson{
        public String email;
        public String droidGuard;

    }

     class InputJson{
        byte[] input;
        String email;
        String androidId;
         String accountType;

    }
}
