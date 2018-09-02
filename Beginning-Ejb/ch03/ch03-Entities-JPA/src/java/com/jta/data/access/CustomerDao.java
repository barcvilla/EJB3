/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jta.data.access;

import com.jta.entities.Customer;
import java.util.List;

/**
 *
 * @author PC
 */
public interface CustomerDao {
    public List<Customer> findAllCustomers();
    public Customer findCustomerById(Customer customer);
    public Customer finCustomerByName();
    public void insertCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Customer customer);
}
