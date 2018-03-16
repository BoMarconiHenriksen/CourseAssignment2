/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ExceptionHandling.PersonNotFoundException;
import com.google.gson.Gson;
import entity.JSONMessages.JSONMessage;
import entity.JSONMessages.PersonMessage;
import entity.Company;
import entity.JSONMessages.CompanyMessage;
import entity.Person;
import facade.CompanyFacade;
import facade.PersonFacade;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Ticondrus
 */

@Path("companies")
public class CompanyResource {
    
    Gson gson = new Gson();
    @Context
    private UriInfo context;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
    CompanyFacade cmFacade = new CompanyFacade();
    
    public CompanyResource(){ 
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getallCompanies() {

        ArrayList<JSONMessage> messages = new ArrayList<>();
        CompanyFacade.getCompanies(em);
        for (Company c : CompanyFacade.companies.values()) {

            messages.add(new CompanyMessage(c));
        }

        return gson.toJson(messages);

    }
    
    @Path("/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCompanyByName(@PathParam("name") String name) {

        ArrayList<JSONMessage> messages = new ArrayList<>();
       Company c = (Company) CompanyFacade.findCompanyByName(em, name);
        if (c == null) {
            throw new PersonNotFoundException("No person with that id");

        } else {

            messages.add(new CompanyMessage(c));
        }

        return gson.toJson(messages);

    }
    
}
