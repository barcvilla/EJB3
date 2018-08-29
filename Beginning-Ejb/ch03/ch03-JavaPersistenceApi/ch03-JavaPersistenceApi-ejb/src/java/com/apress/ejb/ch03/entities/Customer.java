/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.ch03.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "ch03_customer")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"), 
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")})
@TableGenerator(name = "Customer_ID_Generator", table = "ch03_customer_id_gen", pkColumnName = "primary_key_name", pkColumnValue = "Customer.id",
                valueColumnName = "next_id_value")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Customer_ID_Generator")
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "version")
    private Integer version;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    
    @Size(max = 4000)
    @Column(name = "email")
    private String email;
    
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL})
    private List<CustomerOrder> customerOrders;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "billing_address", referencedColumnName = "id")
    private Address billingAddress;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "shipping_address", referencedColumnName = "id")
    private Address shippingAddress;
    
    @Size(max = 400)
    @Column(name = "name")
    private String name;

    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<CustomerOrder> getCustomerOrders()
    {
        return customerOrders;
    }
    
    public CustomerOrder addCustomerOrder(CustomerOrder customerOrder)
    {
        if(customerOrder == null)
        {
            customerOrders = new ArrayList<CustomerOrder>();
        }
        
        customerOrders.add(customerOrder);
        customerOrder.setCustomer(this);
        return customerOrder;
    }

    public CustomerOrder removeCustomerOrder(CustomerOrder customerOrder)
    {
        getCustomerOrders().remove(customerOrder);
        customerOrder.setCustomer(null);
        return customerOrder;
    }
    
    
    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apress.ejb.ch03.entities.Customer[ id=" + id + " ]";
    }
    
}
