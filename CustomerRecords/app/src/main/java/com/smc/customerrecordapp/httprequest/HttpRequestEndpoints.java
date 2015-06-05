package com.smc.customerrecordapp.httprequest;

/**
 * Created by Sumit on 4/22/2015.
 */
public interface HttpRequestEndpoints {

    public String BASEURL="http://188.40.75.207:8888/api";
    public String GETCUSTOMERLISTURL= BASEURL+"/customer";
    public String GETORDERLISTOFCUSTOMERIDURL= BASEURL+"/Order/{customerId}";
}
