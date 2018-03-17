/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Ejer
 */
@Provider
public class PersonNotFoundExceptionMapper implements ExceptionMapper<PersonNotFoundException> {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    ServletContext context;

    @Override
    public Response toResponse(PersonNotFoundException exception) {
        boolean isDebug = context.getInitParameter("debug").endsWith("true");
        ErrorMessage err = new ErrorMessage(exception, 404, isDebug);
        err.setMessage(exception.getMessage());

        err.setDescription("You might consider looking up Jade instead. It is much more likely you will find a Jade in our magnificent list of all names");

        return Response.status(404)
                .entity(gson.toJson(err))
                .type(MediaType.APPLICATION_JSON)
                .build();
        
    }
}

 