/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.ch03.domain.listing_3_04;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @Transient : Se aplica cuando no queremos que una variable de instancia sea persisente en la BD. Estos campos que lleven la anotacion
 * @transient seran ingnorados por el framework de persistencia. Esta variable de instancia solo sirve para adaptar el valor int interno
 * a un valor String derivado favorable para el cliente.
 * @author PC
 */
@Entity
public class Address implements Serializable{
    @Id
    private long addressId;
    
    @Column(name = "zip")
    private int zipCodeInternational;
    
    @Transient
    private String zipCode;
    
    public Address(){}
    
    /**
     * get & setZipCode() permite a la entidad transformar los datos internos
     * @return 
     */
    public String getZipCode()
    {
        if(zipCode == null && zipCodeInternational > 0)
        {
            zipCode = convertToStr(zipCodeInternational);
        }
        
        return zipCode;
    }
    
    public void setZipCode(String zipCode) throws IllegalArgumentException
    {
        //validamos el zipcode string, nos aseguramos que se reduzca claramente a 5 o 9 digitos, y asignarlos al campo de clase de persistencia
        //interna zipCodeInternational
        this.zipCode = zipCode;
        zipCodeInternational = convertToInt(zipCode);
    }
    
    public void setAddressId(long addressId)
    {
        this.addressId = addressId;
    }
    
    public long getAddressId()
    {
        return addressId;
    }
    
    private int convertToInt(String zipCode)
    {
        return new Integer(zipCode).intValue();
    }
    
    private String convertToStr(int zipCode)
    {
        return new Integer(zipCode).toString();
    }
    
}
