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

/**
 *
 * @author Ejer
 */
public class ValidationErrorExceptionMapper implements ExceptionMapper<ValidationErrorException> {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    ServletContext context;
  

    @Override
    public Response toResponse(ValidationErrorException exception) {
       boolean isDebug = context.getInitParameter("debug").endsWith("true");
         ErrorMessage err = new ErrorMessage(exception, 400, isDebug);
         err.setMessage("A person must have both a first and a last name");
         
        return Response.status(400)
                .entity(gson.toJson(err))
                .type(MediaType.APPLICATION_JSON)
                .build();

}
}