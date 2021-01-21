/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankethv.service;

import com.sankethv.entity.CustomerMaster;
import com.sankethv.model.CustomerModel;
import java.util.Collection;
import javax.faces.annotation.RequestParameterMap;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sanket
 */
@Path("/customer")
public class CustomerService {

    @Inject
    CustomerModel model;

    //End point
    //http://localhost:8080/exam-service/rest/customer/getCustomer?condition=eq&rating=5
    @GET
    @Path("/getCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<CustomerMaster> getCustomer(@QueryParam("condition") String condition, @QueryParam("rating") int rating) {

        return model.getCustomerWithRatings(condition, rating);
    }

}
