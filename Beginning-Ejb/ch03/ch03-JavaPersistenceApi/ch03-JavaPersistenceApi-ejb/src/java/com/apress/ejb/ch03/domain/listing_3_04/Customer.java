/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.ch03.domain.listing_3_04;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad con valores
 * 
 * @author PC
 */
@Entity(name = "Customer_04")
@Table(name = "customer")
public class Customer implements Serializable{
    @Id
    @Column(name="customerId", table="customer", unique=true, nullable = false, insertable = true, updatable = true)
    private int customerId;
    
    @Basic(fetch=FetchType.EAGER)
    @Column(name = "name", table="customer")
    private String  name;
    
    public Customer(){}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
