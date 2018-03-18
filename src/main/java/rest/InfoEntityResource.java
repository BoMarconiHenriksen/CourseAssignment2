/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ExceptionHandling.PersonNotFoundException;


import com.google.gson.Gson;
import entity.InfoEntity;
import entity.JSONMessages.EntityMessage;
import entity.JSONMessages.JSONMessage;
import facade.InfoEntityFacade;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Ejer
 */
@Path("ies")
public class InfoEntityResource {

    InfoEntityFacade ief = new InfoEntityFacade();
    Gson gson = new Gson();
    @Context
    private UriInfo context;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    public InfoEntityResource() {
    }

//    @Path("{id}")
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putPersonById(@PathParam("id") Long personId, String content) {
//        Person pStart = PersonFacade.getPerson(em, personId);
//        Person pEnd = MessageFacade.fromJson(content, PersonMessage.class);
//        pEnd.setId(pStart.getId());
//        deletePersonById(personId);
//        PersonFacade.createPerson(em, pEnd);
//
//    }
//
//    @Path("{id}")
//    @DELETE
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void deletePersonById(@PathParam("id") Long personId) {
//        InfoEntityFacade.deleteInfoEntityById(em, personId);
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void addPerson(String json) {
//        Person p = MessageFacade.fromJson(json, PersonMessage.class);
//        PersonFacade.createPerson(em, p);
//
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getallEntities() {

        ArrayList<JSONMessage> messages = new ArrayList<>();
        InfoEntityFacade.getInfoEntities(em);
        for (InfoEntity ie : InfoEntityFacade.infoEntitites.values()) {

            messages.add(new EntityMessage(ie));
        }

        return gson.toJson(messages);

    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoEntityId(@PathParam("id") Long id) {

        ArrayList<JSONMessage> messages = new ArrayList<>();

        InfoEntity ie = InfoEntityFacade.getInfoEntity(em, id);
        if (ie==null) {
            throw new PersonNotFoundException("No company or person with that id");

        } else {
         
               messages.add(new EntityMessage(ie));
            }
        

        return gson.toJson(messages);
    }

//    @Path("firstName/{firstName}")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getPersonByFirstName(@PathParam("firstName") String firstName) {
//
//        ArrayList<JSONMessage> messages = new ArrayList<>();
//
//        List<Person> ie = ief.findPersonByName(firstName);
//        if (ie.isEmpty()) {
//            throw new PersonNotFoundException("No persons with that firstname");
//
//        } else {
//            for (int i = 0; i < ie.size(); i++) {
//                messages.add(new PersonMessage(ie.get(i)));
//            }
//
//            return gson.toJson(messages);
//
//        }
//
//    }
}
