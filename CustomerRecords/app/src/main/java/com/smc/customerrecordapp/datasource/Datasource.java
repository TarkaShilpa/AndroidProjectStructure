package com.smc.customerrecordapp.datasource;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.smc.customerrecordapp.application.CustomerRecordApp;
import com.smc.customerrecordapp.cachedata.AppData;
import com.smc.customerrecordapp.dao.Customer;
import com.smc.customerrecordapp.dao.Order;
import com.smc.customerrecordapp.httprequest.HttpRequest;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sumit chakole on 21/04/15.
 * This class acts as the data provider to UI layer
 */
public class Datasource {

    /*
    Check if network online
     */
    private static boolean isOnline(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (!(netInfo != null && netInfo.isConnectedOrConnecting())){
            return false;
        }else{
            return true;
        }
    }

    /*
    Fetch customers list data
     */
    public static void fetchCustomers(Context context, Handler successHandler, Handler failureHandler){
        Log.d("Mymsg", "public static void fetchCustomers(Context context, Handler successHandler, Handler failureHandler)----> START");

        if (isOnline(context)){
            HttpRequest.getCustomerList(context, successHandler, failureHandler);
        }else{
            CustomerRecordApp customerRecordApp= (CustomerRecordApp) context.getApplicationContext();
            AppData cacheAppData= customerRecordApp.getCacheDataObj();

            try {
                Dao<Customer, Integer> customerDao= cacheAppData.getCustomerDao();

                // Get all customer list
                List<Customer> customers= customerDao.queryForAll();

                Message customerListResponseMessage= Message.obtain();
                customerListResponseMessage.obj= customers;
                successHandler.sendMessage(customerListResponseMessage);
            } catch (SQLException e) {
                Message exceptionResponseMessage= Message.obtain();
                exceptionResponseMessage.obj= e;
                failureHandler.sendMessage(exceptionResponseMessage);
            }
        }
        Log.d("Mymsg", "public static void fetchCustomers(Context context, Handler successHandler, Handler failureHandler)----> STOP");
    }

    /*
    Fetch order list of customer id
     */
    public static void fetchOrderList(Context context, String customerId){

        Log.d("Mymsg", "public static void fetchOrderList(Context context, String customerId)----> START");

        if (isOnline(context)){
            HttpRequest.getOrderListOfCustomer(context, customerId);
        }else{
            CustomerRecordApp customerRecordApp= (CustomerRecordApp) context.getApplicationContext();
            AppData cacheAppData= customerRecordApp.getCacheDataObj();

            try {
                Dao<Order, Integer> orderDao= cacheAppData.getOrderDao();

                // Get all customer list
                List<Order> orders= orderDao.queryForEq("customerId", customerId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        Log.d("Mymsg", "public static void fetchOrderList(Context context, String customerId)----> STOP");
    }
}
