/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jta.data.access;

import com.jta.entities.Customer;
import com.jta.entities.CustomerOrder;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class CustomerOrderDaoImpl implements CustomerOrderDao{
    
    @PersistenceContext(unitName = "RRHHDB")
    EntityManager em;
    
    @Override
    public List<CustomerOrder> getCustomerOrderFindById(Customer customer) {
        return em.createNamedQuery("CustomerOrder.findByCustomerId", CustomerOrder.class)
                .setParameter("customer_id", customer)
                .getResultList();
    }

    
    
}
