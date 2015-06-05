package com.smc.customerrecordapp.dao;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;

/**
 * Created by ajaysingh on 21/04/15.
 */
public class Order {

    @SerializedName("OrderID")
    @DatabaseField
    private long orderId;

    @SerializedName("CustomerID")
    @DatabaseField
    private String customerId;

    @SerializedName("EmployeeID")
    @DatabaseField
    private int employeeId;

    @SerializedName("OrderDate")
    @DatabaseField
    private String orderDate;

    @SerializedName("RequiredDate")
    @DatabaseField
    private String requiredDate;

    @SerializedName("ShippedDate")
    @DatabaseField
    private String shippedDate;

    @SerializedName("ShipVia")
    @DatabaseField
    private int ShipVia;

    @SerializedName("Freight")
    @DatabaseField
    private float freight;

    @SerializedName("ShipName")
    @DatabaseField
    private String shipName;

    @SerializedName("ShipAddress")
    @DatabaseField
    private String shipAddress;

    @SerializedName("ShipCity")
    @DatabaseField
    private String shipCity;

    @SerializedName("ShipRegion")
    @DatabaseField
    private String shipRegion;

    @SerializedName("ShipPostalCode")
    @DatabaseField
    private String shipPostalCode;

    @SerializedName("ShipCountry")
    @DatabaseField
    private String shipCountry;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public int getShipVia() {
        return ShipVia;
    }

    public void setShipVia(int shipVia) {
        ShipVia = shipVia;
    }

    public float getFreight() {
        return freight;
    }

    public void setFreight(float freight) {
        this.freight = freight;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }
}

        /*OrderID: 10692
        CustomerID: "ALFKI"
        EmployeeID: 4
        OrderDate: "1997-10-03T00:00:00"
        RequiredDate: "1997-10-31T00:00:00"
        ShippedDate: "1997-10-13T00:00:00"
        ShipVia: 2
        Freight: 61.02
        ShipName: "Alfred's Futterkiste"
        ShipAddress: "Obere Str. 57"
        ShipCity: "Berlin"
        ShipRegion: null
        ShipPostalCode: "12209"
        ShipCountry: "Germany"*/

        
