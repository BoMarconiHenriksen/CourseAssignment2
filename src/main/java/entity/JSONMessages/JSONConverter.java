/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.JSONMessages;

import com.google.gson.Gson;
import entity.Person;

import java.util.List;

/**
 *
 * @author Ejer
 */
public class JSONConverter {

    static Gson gson = new Gson();

    public static Person getPersonFromJson(String js) {

        return gson.fromJson(js, Person.class);
    }

    public static String getJSONFromPerson(Person p) {
        return gson.toJson(p);
    }

    public static String getJSONFromPersons(List<Person> persons) {
        return gson.toJson(persons);
    }
    
  
}
