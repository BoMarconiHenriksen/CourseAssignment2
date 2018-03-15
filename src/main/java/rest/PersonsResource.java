/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entity.JSONMessages.JSONMessage;
import entity.JSONMessages.PersonMessage;
import entity.Person;
import facade.PersonFacade;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author Ejer
 */
@Path("persons")
public class PersonsResource {

    Gson gson = new Gson();
    @Context
    private UriInfo context;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    public PersonsResource() {
    }

    /**
     * Creates a new instance of PersonsResource
     */
 
    /**
     * Retrieves representation of an instance of persistence.PersonsResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {

        ArrayList<JSONMessage> messages = new ArrayList<>();
        PersonFacade.getpersons(em);
        for (Person p : PersonFacade.persons.values()) {

            messages.add(new PersonMessage(p));
        }

        return gson.toJson(messages);

    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("id") Integer id) {

        ArrayList<JSONMessage> messages = new ArrayList<>();
        Person p=PersonFacade.getPerson(em, id);
        

            messages.add(new PersonMessage(p));
     

        return gson.toJson(messages);

    }

    /**
     * PUT method for updating or creating an instance of PersonsResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
