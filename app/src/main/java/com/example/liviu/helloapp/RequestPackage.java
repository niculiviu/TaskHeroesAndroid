package com.example.liviu.helloapp;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liviu on 26.04.2015.
 */
public class RequestPackage {
    private String uri;
    private String method="GET";
    private Map<String,String> params = new HashMap<>();
    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void SetParam(String key,String value){
        params.put(key, value);
    }

    public String getEncodedParams(){
        StringBuilder sb=new StringBuilder();
        for(String key: params.keySet()){
            String value=null;
            try {
                value = URLEncoder.encode(params.get(key),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if(sb.length()>0){
                sb.append("&");
            }

            sb.append(key+"="+value);
        }
        return sb.toString();
    }


}
