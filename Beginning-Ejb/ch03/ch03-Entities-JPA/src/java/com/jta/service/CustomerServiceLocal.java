/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jta.service;

import com.jta.entities.Customer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface CustomerServiceLocal {
    public List<Customer> findAllCustomers();
    public Customer findCustomerById(Customer customer);
    public Customer finCustomerByName();
    public void insertCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Customer customer);
}
