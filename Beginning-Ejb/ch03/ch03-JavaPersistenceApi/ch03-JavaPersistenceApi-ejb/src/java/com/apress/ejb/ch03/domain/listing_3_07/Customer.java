/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.ch03.domain.listing_3_07;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @GeneratedValue esta anotacion le dice al framework de persistencia llene esta columna con el generador de secuencia especificado.
 * @SequenceGenerator define un generador de secuencia compartible el cual puede ya sea definir un nuevo generador de frecuencia de un
 * framework o de una secuencia existente en la BD
 * @author PC
 */
@Entity(name = "Customer_07")
@SequenceGenerator(name = "CustomerSequence", sequenceName = "CUSTOMER_SEQ", initialValue = 100, allocationSize = 20)
public class Customer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomerSequence")
    private Integer id;
    private String name;

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
