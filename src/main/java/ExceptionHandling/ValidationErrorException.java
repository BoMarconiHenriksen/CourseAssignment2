/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

/**
 *
 * @author Ejer
 */
public class ValidationErrorException extends RuntimeException {
    

    public ValidationErrorException(String r) {
        super(r);

    }
}


