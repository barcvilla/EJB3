/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jta.service;

import com.jta.data.access.CustomerOrderDao;
import com.jta.entities.Customer;
import com.jta.entities.CustomerOrder;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PC
 */
@Stateless
public class CustomerOrderServiceImpl implements CustomerOrderServiceLocal {
    
    @EJB
    CustomerOrderDao customerOrderDao;

    @Override
    public List<CustomerOrder> getCustomerOrderFindById(Customer customer) {
        return customerOrderDao.getCustomerOrderFindById(customer);
    }
    
}
