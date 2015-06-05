package com.smc.customerrecordapp.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.smc.customerrecordapp.cachedata.AppData;


/**
 * Created by ajaysingh on 21/04/15.
 */
public class CustomerRecordApp extends Application {

    private RequestQueue queue;
    private AppData cacheAppData = null;

    /*
    Http request queue
     */
    public RequestQueue getHttpRequestQueue(){
        if(queue==null){
            queue = Volley.newRequestQueue(this);
        }
        return queue;
    }

    /*
    Database helper instance
     */
    public AppData getCacheDataObj(){
        if (cacheAppData == null) {
            cacheAppData = OpenHelperManager.getHelper(this, AppData.class);
        }
        return cacheAppData;
    }
}
