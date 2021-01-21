/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankethv.model;

import com.sankethv.entity.CustomerMaster;
import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author sanket
 */
@Named
@ApplicationScoped
public class CustomerModel {

    EntityManager em;

    public CustomerModel() {
        em = Persistence.createEntityManagerFactory("CustomerPU").createEntityManager();
    }

    public Collection<CustomerMaster> getCustomerWithRatings(String condition, int rating) {

        if (condition.equals("lt")) {
            System.out.println("In condition lt.......................");
            return em.createNamedQuery("CustomerMaster.findLT").setParameter("rating", rating).getResultList();
        } else if (condition.equals("gt")) {
            System.out.println("In condition gt.......................");
            return em.createNamedQuery("CustomerMaster.findGT").setParameter("rating", rating).getResultList();
        } else if (condition.equals("lte")) {
            System.out.println("In condition lte.......................");
            return em.createNamedQuery("CustomerMaster.findLTE").setParameter("rating", rating).getResultList();
        } else if (condition.equals("gte")) {
            System.out.println("In condition gte.......................");
            return em.createNamedQuery("CustomerMaster.findGTE").setParameter("rating", rating).getResultList();
        } else if (condition.equals("eq")) {
            System.out.println("In condition eq.......................");
            return em.createNamedQuery("CustomerMaster.findEQ").setParameter("rating", rating).getResultList();
        }
        System.out.println("Out condition.......................");
        return em.createNamedQuery("CustomerMaster.findAll").getResultList();

    }

}
