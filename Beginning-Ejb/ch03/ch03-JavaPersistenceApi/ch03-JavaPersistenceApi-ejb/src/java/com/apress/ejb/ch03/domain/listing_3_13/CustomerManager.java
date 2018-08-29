/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.ch03.domain.listing_3_13;

import com.apress.ejb.ch03.entities.Customer;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author PC
 */
@Stateless(name = "Listing_3_13_CustomerManager")
public class CustomerManager implements Serializable{
    
    @PersistenceContext(unitName = "Chapter03PersistenceUnit")
    private EntityManager em;
    
    public void createCustomer()
    {
        final Customer customer = new Customer();
        customer.setName("Moneybags McGee");
        em.persist(customer);
    }
}
