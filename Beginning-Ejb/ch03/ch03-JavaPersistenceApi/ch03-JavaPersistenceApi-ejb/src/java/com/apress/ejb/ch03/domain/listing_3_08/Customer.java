/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.ch03.domain.listing_3_08;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import com.apress.ejb.ch03.domain.listing_3_09.CustomerPK;
import java.io.Serializable;
import javax.persistence.Id;

/**
 * Llave primaria compuesta: Mapea multiples columnas en la BD. Para estos cada columna en la clase se le coloca la anotacion @Id
 * @author PC
 */
@Entity(name = "Customer_08")
@IdClass(CustomerPK.class) // permite indicar que la entidad utilizara una llave principal compuesta
public class Customer implements Serializable{
    @Id
    private Integer customerId;
    
    @Id
    private String name;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
