/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ExceptionHandling.PersonNotFoundException;


import com.google.gson.Gson;
import entity.JSONMessages.JSONMessage;
import entity.JSONMessages.MessageFacade;
import entity.JSONMessages.PersonMessage;
import entity.Person;
import facade.PersonFacade;
import java.util.ArrayList;
import java.util.List;
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

    PersonFacade pf = new PersonFacade();
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
    public void putPersonById(@PathParam("id") Long personId, String content) {
        Person pStart = PersonFacade.getPerson(em, personId);
        Person pEnd = MessageFacade.fromJson(content, PersonMessage.class);
        pEnd.setId(pStart.getId());
        deletePersonById(personId);
        PersonFacade.createPerson(em, pEnd);

    }

    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletePersonById(@PathParam("id") Long personId) {
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
    public String getPersonById(@PathParam("id") Long id) {

        ArrayList<JSONMessage> messages = new ArrayList<>();

        Person p = PersonFacade.getPerson(em, id);
        if (p==null) {
            throw new PersonNotFoundException("No person with that id");

        } else {
         
               messages.add(new PersonMessage(p));
            }
        

        return gson.toJson(messages);
    }

    @Path("firstName/{firstName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonByFirstName(@PathParam("firstName") String firstName) {

        ArrayList<JSONMessage> messages = new ArrayList<>();

        List<Person> p = pf.findPersonByName(firstName);
        if (p.isEmpty()) {
            throw new PersonNotFoundException("No persons with that firstname");

        } else {
            for (int i = 0; i < p.size(); i++) {
                messages.add(new PersonMessage(p.get(i)));
            }

            return gson.toJson(messages);

        }

    }
}
