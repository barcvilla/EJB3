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

/**
 *
 * @author PC
 */
@Stateless
public class CustomerOrderDaoImpl implements CustomerOrderDao{

    @Override
    public List<CustomerOrder> findAllCustomerOrdersById(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
