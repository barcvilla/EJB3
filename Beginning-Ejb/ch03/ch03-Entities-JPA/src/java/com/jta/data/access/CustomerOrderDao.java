/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jta.data.access;

import com.jta.entities.Customer;
import com.jta.entities.CustomerOrder;
import java.util.List;

/**
 *
 * @author PC
 */
public interface CustomerOrderDao {
    public List<CustomerOrder> findAllCustomerOrdersById(Customer customer);
}
