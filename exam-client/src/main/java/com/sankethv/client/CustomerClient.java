/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankethv.client;

import com.sankethv.entity.CustomerMaster;
import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author sanket
 */
@RegisterRestClient(baseUri = "http://localhost:8080/exam-service/rest")
@ApplicationScoped
@Path("/customer")
public interface CustomerClient {

    @GET
    @Path("/getCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<CustomerMaster> getCustomer(@QueryParam("condition") String condition, @QueryParam("rating") int rating);
}
