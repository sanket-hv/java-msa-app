/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankethv.cdi;

import com.sankethv.client.CustomerClient;
import com.sankethv.entity.CustomerMaster;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.inject.Inject;

/**
 *
 * @author sanket
 */
@Named(value = "customerCDI")
@SessionScoped
public class CustomerCDI implements Serializable {

    /**
     * Creates a new instance of CustomerCDI
     */
    String condition;
    int rating;

    @Inject
    CustomerClient client;

    Collection<CustomerMaster> customerCollection;

    CustomerMaster customer;

    public CustomerCDI() {
        customer = new CustomerMaster();
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public CustomerClient getClient() {
        return client;
    }

    public void setClient(CustomerClient client) {
        this.client = client;
    }

    public Collection<CustomerMaster> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<CustomerMaster> customerCollection) {
        this.customerCollection = customerCollection;
    }

    public CustomerMaster getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerMaster customer) {
        this.customer = customer;
    }

    public String getData() {
        customerCollection = client.getCustomer(condition, rating);
        return "index.jsf?faces-redirect=true";
    }
}
