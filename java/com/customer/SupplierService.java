package com.customer;

public class SupplierService {
    private int id;
    private String supplierName;
    private String companyName;
    private String email;
    private String phoneNumber;
    private String country;
    private String serviceType;
    private String serviceDescription;
    

    public SupplierService(int id, String supplierName, String companyName, String email, String phoneNumber, 
                           String country, String serviceType, String serviceDescription) {
        super();
        this.id = id;
        this.supplierName = supplierName;
        this.companyName = companyName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.serviceType = serviceType;
        this.serviceDescription = serviceDescription;
        
    }

    public int getId() {
        return id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

 
}