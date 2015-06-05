package com.smc.customerrecordapp.dao;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;

/**
 * Created by ajaysingh on 21/04/15.
 */
public class Customer {

    @SerializedName("CustomerID")
    @DatabaseField
    private String customerId;

    @SerializedName("CompanyName")
    @DatabaseField
    private String companyName;

    @SerializedName("ContactName")
    @DatabaseField
    private String contactName;

    @SerializedName("ContactTitle")
    @DatabaseField
    private String contractTitle;

    @SerializedName("Address")
    @DatabaseField
    private String address;

    @SerializedName("City")
    @DatabaseField
    private String city;

    @SerializedName("Region")
    @DatabaseField
    private String region;

    @SerializedName("PostalCode")
    @DatabaseField
    private String postalCode;

    @SerializedName("Country")
    @DatabaseField
    private String country;

    @SerializedName("Phone")
    @DatabaseField
    private String phoneNumber;

    @SerializedName("Fax")
    @DatabaseField
    private String fax;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContractTitle() {
        return contractTitle;
    }

    public void setContractTitle(String contractTitle) {
        this.contractTitle = contractTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public String toString() {
        return "{"
                    +"customerId: "+customerId+" "
                    +"companyName: "+companyName+" "
                    +"contactName: "+contactName+" "
                    +"contractTitle: "+contractTitle+" "
                    +"address: "+address+" "
                    +"city: "+city+" "
                    +"region: "+region+" "
                    +"postalCode: "+postalCode+" "
                    +"country: "+country+" "
                    +"phoneNumber: "+phoneNumber+" "
                    +"fax: "+fax+" "
                +"}";
    }
}

        /*CustomerID: "ALFKI"
        CompanyName: "Alfreds Futterkiste"
        ContactName: "Maria Anders"
        ContactTitle: "Sales Representative"
        Address: "Obere Str. 57"
        City: "Berlin"
        Region: null
        PostalCode: "12209"
        Country: "Germany"
        Phone: "030-0074321"
        Fax: "030-0076545"*/
