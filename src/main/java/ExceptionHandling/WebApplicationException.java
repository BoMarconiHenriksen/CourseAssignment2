/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

import javax.ws.rs.core.Response;

/**
 *
 * @author Ejer
 */
public class WebApplicationException extends RuntimeException {

    public WebApplicationException() {
    }

    
   public WebApplicationException(Response response) {
    }

    public WebApplicationException(int status) {
    }

    public WebApplicationException(Response.Status status) {
    }

    public WebApplicationException(Throwable cause) {
    }

    public WebApplicationException(Throwable cause,
            Response response) {
    }

    public WebApplicationException(Throwable cause, int status) {
    }

    public WebApplicationException(Throwable cause,
            Response.Status status) {
    }

    public Response getResponse() {
        return null;
    }
}
