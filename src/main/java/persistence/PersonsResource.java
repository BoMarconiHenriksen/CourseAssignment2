/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import com.google.gson.Gson;
import entities.JSONMessages.JSONMessage;
import entities.JSONMessages.MessageFacade;
import entities.JSONMessages.PersonMessage;
import entity.Person;
import facade.PersonFacade;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CourseAssignment2_war_1.0-SNAPSHOTPU");
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPerson(String json) {
        Person p = MessageFacade.fromJson(json, PersonMessage.class);
        PersonFacade.createPerson(em, p);
        
        
    }
    
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putPersonByID(@PathParam("id") int personId, String json) {
        Person pOrigin = PersonFacade.getPerson(em, personId);
        Person pChange = MessageFacade.fromJson(json, PersonMessage.class);
        pChange.setId(pOrigin.getId());
        // mangler at slette den originale og saette den nye ind
    }
    
    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletePersonById(@PathParam("id") int personId) {
        PersonFacade.deletePersonById(em, personId);
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

}
