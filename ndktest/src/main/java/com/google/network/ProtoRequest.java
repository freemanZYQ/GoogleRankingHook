package com.google.network;

import java.util.Map;

/**
 * Created by apple on 16/10/5.
 */
public class ProtoRequest<T> extends Request<T> {

    public RequestEntity<T> mRequestEntity;

    public ProtoRequest(RequestEntity<T> requestEntity){
        super(requestEntity.getMethod(),requestEntity.getUrl());
        this.mRequestEntity = requestEntity;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return mRequestEntity != null ? mRequestEntity.getHeaders():super.getHeaders();
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return mRequestEntity != null ? mRequestEntity.getPostParams():super.getParams();
    }
}
