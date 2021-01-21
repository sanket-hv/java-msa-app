/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankethv.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sanket
 */
@Entity
@Table(name = "customer_master")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerMaster.findAll", query = "SELECT c FROM CustomerMaster c"),
    @NamedQuery(name = "CustomerMaster.findLT", query = "SELECT cm FROM CustomerMaster cm WHERE cm.rating < :rating"),
    @NamedQuery(name = "CustomerMaster.findGT", query = "SELECT cm FROM CustomerMaster cm WHERE cm.rating > :rating"),
    @NamedQuery(name = "CustomerMaster.findLTE", query = "SELECT cm FROM CustomerMaster cm WHERE cm.rating <= :rating"),
    @NamedQuery(name = "CustomerMaster.findGTE", query = "SELECT cm FROM CustomerMaster cm WHERE cm.rating >= :rating"),
    @NamedQuery(name = "CustomerMaster.findEQ", query = "SELECT cm FROM CustomerMaster cm WHERE cm.rating = :rating"),

    @NamedQuery(name = "CustomerMaster.findByCustomerId", query = "SELECT c FROM CustomerMaster c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "CustomerMaster.findByEmail", query = "SELECT c FROM CustomerMaster c WHERE c.email = :email"),
    @NamedQuery(name = "CustomerMaster.findByName", query = "SELECT c FROM CustomerMaster c WHERE c.name = :name"),
    @NamedQuery(name = "CustomerMaster.findByRating", query = "SELECT c FROM CustomerMaster c WHERE c.rating = :rating"),
    @NamedQuery(name = "CustomerMaster.findByPhone", query = "SELECT c FROM CustomerMaster c WHERE c.phone = :phone")})
public class CustomerMaster implements Serializable {

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rating")
    private int rating;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "phone")
    private String phone;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;

    public CustomerMaster() {
    }

    public CustomerMaster(Integer customerId) {
        this.customerId = customerId;
    }

    public CustomerMaster(Integer customerId, String email, String name, int rating, String address, String phone) {
        this.customerId = customerId;
        this.email = email;
        this.name = name;
        this.rating = rating;
        this.address = address;
        this.phone = phone;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerMaster)) {
            return false;
        }
        CustomerMaster other = (CustomerMaster) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sankethv.entity.CustomerMaster[ customerId=" + customerId + " ]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
