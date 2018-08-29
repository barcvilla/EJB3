/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.ch03.domain.listing_3_14;

import com.apress.ejb.ch03.entities.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC
 */
public class CustomerService {
    public static void main(String[] args) {
    final EntityManagerFactory emf =
      Persistence.createEntityManagerFactory("Chapter03PersistenceUnit-JSE");
    final EntityManager em = emf.createEntityManager();
    final Customer cust = new Customer();
    cust.setVersion(1);
    cust.setEmail("ceva_19@hotmail.com");
    cust.setName("Best Customer Ever");
    em.persist(cust);
    em.close();
  }
}
