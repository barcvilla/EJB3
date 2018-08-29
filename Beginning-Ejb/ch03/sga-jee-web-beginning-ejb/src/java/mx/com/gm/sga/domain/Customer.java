/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "customer")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id")
    , @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name")
    , @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL})
    private List<CustomerOrder> customerOrders;
    
    // relacion unidirecional
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "shipping_address")
    private Address shippingAddress;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 400)
    @Column(name = "email")
    private String email;
    
    //relacion unidireccional
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "billing_address")
    private Address billingAddress;
    

    public Customer() {
    }
    public Customer(Integer id) {
        this.id = id;
    }
    public Customer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
        return "[Customer: " + id + " ]";
    }
    public List<CustomerOrder> getCustomerOrders()
    {
        return customerOrders;
    }
    public void setCustomerOrders(List<CustomerOrder> customerOrders)
    {
        this.customerOrders = customerOrders;
    }
    public CustomerOrder addCustomerOrder(CustomerOrder customerOrder)
    {
        if(customerOrders == null)
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
    public void setBillingAddress(Address billingAddress)
    {
        this.billingAddress = billingAddress;
    }
    public Address setBillingAddress()
    {
        return billingAddress;
    }
    public void setShippingAddress(Address shippingAddress)
    {
        this.shippingAddress = shippingAddress;
    }
    public Address getShippingAddress()
    {
        return shippingAddress;
    }
}
