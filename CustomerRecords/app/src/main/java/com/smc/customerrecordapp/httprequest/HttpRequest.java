package com.smc.customerrecordapp.httprequest;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.j256.ormlite.dao.Dao;
import com.smc.customerrecordapp.application.CustomerRecordApp;
import com.smc.customerrecordapp.cachedata.AppData;
import com.smc.customerrecordapp.dao.Customer;
import com.smc.customerrecordapp.dao.Order;
import com.smc.customerrecordapp.httpRequestParser.GsonRequest;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ajaysingh on 21/04/15.
 * All http call will be made through this class
 */
public class HttpRequest {

    /*
    Create header for backend service
     */

    private static Map<String, String> getHeader(){
        // Request header
        Map<String, String> headers= new HashMap<String, String>();
        headers.put("Authorization", "Basic YWRtaW46YWRtaW4=");
        headers.put("lat","20.000");
        headers.put("long","77.0000");

        return  headers;
    }

        /*
        Fetch customer list
         */
    public static void getCustomerList(final Context context, final Handler successHandler, final Handler failureHandler){

        // Request header
        Map<String, String> headers= getHeader();

        // Request a pojo object response from the provided URL.
        GsonRequest request = new GsonRequest(Request.Method.GET, HttpRequestEndpoints.GETCUSTOMERLISTURL, Customer[].class, headers,
                new Response.Listener<Customer[]>() {
                    @Override
                    public void onResponse(Customer[] response) {
                        Log.d("Mymsg", "Customer List Response: " + response.toString());
                        Message successReponse= Message.obtain();
                        List<Customer> customers= Arrays.asList(response);
                        successReponse.obj=(List<Customer>) customers;
                        successHandler.sendMessage(successReponse);

                        // Insert entries in database
                        CustomerRecordApp app= (CustomerRecordApp)context;
                        AppData cacheAppData= app.getCacheDataObj();
                        try {
                            for (int customerIndex=0; customerIndex<customers.size(); customerIndex++){
                                Dao<Customer, Integer> customerDao=cacheAppData.getCustomerDao();
                                customerDao.create(customers.get(customerIndex));
                            }

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Message exceptionResponseMessage= Message.obtain();
                exceptionResponseMessage.obj= error;
                failureHandler.sendMessage(exceptionResponseMessage);
            }
        });

        // Add the request to the RequestQueue.
        CustomerRecordApp app= (CustomerRecordApp)context;
        RequestQueue queue= app.getHttpRequestQueue();
        queue.add(request);
    }

    /*
        Fetch order list of customer
         */
    public static void getOrderListOfCustomer(Context context, String customerId/*, final Handler successHandler, Handler failureHandler*/){

        // Request header
        Map<String, String> headers= getHeader();

        // Request a pojo object response from the provided URL.
        GsonRequest request = new GsonRequest(Request.Method.GET, HttpRequestEndpoints.GETORDERLISTOFCUSTOMERIDURL, Order[].class, headers,
                new Response.Listener<Order[]>() {
                    @Override
                    public void onResponse(Order[] response) {
                        Log.d("Mymsg", "Order List Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Mymsg", "That didn't work!");
                error.printStackTrace();
            }
        });

        // Add the request to the RequestQueue.
        CustomerRecordApp app= (CustomerRecordApp)context;
        RequestQueue queue= app.getHttpRequestQueue();
        queue.add(request);
    }
}
