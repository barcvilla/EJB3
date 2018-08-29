/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.ch03.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "ch_03_customer_order")
@NamedQueries({
    @NamedQuery(name = "CustomerOrder.findAll", query = "SELECT c FROM CustomerOrder c")})
@TableGenerator(name = "CustomerOrder_ID_Generator", table = "ch03_customer_order_id_gen", pkColumnName = "primary_key_name",
        pkColumnValue = "CustomerOrder.id")
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CustomerOrder_ID_Generator")
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "version")
    private Integer version;
    
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    
    @Size(max = 30)
    @Column(name = "status")
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public CustomerOrder() {
    }

    public CustomerOrder(Integer id) {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof CustomerOrder)) {
            return false;
        }
        CustomerOrder other = (CustomerOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apress.ejb.ch03.entities.CustomerOrder[ id=" + id + " ]";
    }
    
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
