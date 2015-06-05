package com.smc.customerrecordapp.cachedata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.smc.customerrecordapp.dao.Customer;
import com.smc.customerrecordapp.dao.Order;

import java.sql.SQLException;

/**
 * Database helper class used to manage the creation and upgrading of your database. This class also usually provides
 * the DAOs used by the other classes.
 */
public class AppData extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "CustomerRecords.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    // the DAO object we use to access the Customer table
    private Dao<Customer, Integer> customerDao = null;
    private Dao<Order, Integer> orderDao = null;

    public AppData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(AppData.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, Customer.class);
            //TableUtils.clearTable(connectionSource, Order.class);
        } catch (SQLException e) {
            Log.e(AppData.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
     * the various data to match the new version number.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(AppData.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Customer.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(AppData.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the Database Access Object (DAO) for our Customer class. It will create it or just give the cached
     * value.
     */
    public Dao<Customer, Integer> getCustomerDao() throws SQLException {
        if (customerDao == null) {
            customerDao = getDao(Customer.class);
        }
        return customerDao;
    }

    /**
     * Returns the Database Access Object (DAO) for our Customer class. It will create it or just give the cached
     * value.
     */
    public Dao<Order, Integer> getOrderDao() throws SQLException {
        if (orderDao == null) {
            orderDao = getDao(Order.class);
        }
        return orderDao;
    }

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        customerDao = null;
    }
}
