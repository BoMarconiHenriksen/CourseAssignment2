/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ExceptionHandling.PersonNotFoundException;
import ExceptionHandling.WebApplicationException;
import com.google.gson.Gson;
import entity.JSONMessages.JSONMessage;
import entity.JSONMessages.MessageFacade;
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
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putPersonById(@PathParam("id") int personId, String content) {
        Person pStart = PersonFacade.getPerson(em, personId);
        Person pEnd = MessageFacade.fromJson(content, PersonMessage.class);
        pEnd.setId(pStart.getId());
        deletePersonById(personId);
        PersonFacade.createPerson(em, pEnd);

    }

    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletePersonById(@PathParam("id") int personId) {
        PersonFacade.deletePersonById(em, personId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPerson(String json) {
        Person p = MessageFacade.fromJson(json, PersonMessage.class);
        PersonFacade.createPerson(em, p);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getallPerson() {

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
    public String getPersonById(@PathParam("id") Integer id) {

        ArrayList<JSONMessage> messages = new ArrayList<>();

        Person p = PersonFacade.getPerson(em, id);
        messages.add(new PersonMessage(p));
        return gson.toJson(messages);

    }

}
