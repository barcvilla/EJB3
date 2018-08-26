/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.chapter03.listings.listing_3_06;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author PC
 */
@Entity(name = "Customer_06")
public class Customer {
    @Id
    private Integer id;
    private String name;
    
    public Customer(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
