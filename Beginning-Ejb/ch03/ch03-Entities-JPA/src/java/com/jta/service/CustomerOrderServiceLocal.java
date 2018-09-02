/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jta.service;

import com.jta.entities.Customer;
import com.jta.entities.CustomerOrder;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface CustomerOrderServiceLocal {
    public List<CustomerOrder> getCustomerOrderFindById(Customer customer);
}
