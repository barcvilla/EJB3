/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.ch03.domain.listing_3_10;

import com.apress.ejb.ch03.domain.listing_3_11.CustomerPK;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
/**
 * La anotacion @EmbeddedId se puede designar uno de sus campos o propiedades que sea una llave principal compuesta
 * @author PC
 */
@Entity(name="Customer_10")
public class Customer {
    @EmbeddedId
    private CustomerPK customerId;
    
    private String name;

    public CustomerPK getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerPK customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
