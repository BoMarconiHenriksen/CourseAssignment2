/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.JSONMessages;

import entity.Hobby;
import entity.Person;
import facade.PersonFacade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ejer
 */
public class HobbyMessage implements JSONMessage {

    public int hobbyId;
    public String name;
    public String description;
    public List<Person> persons;

    public HobbyMessage(int id, String name, String description, List<Person> persons) {
        this.hobbyId = id;
        this.name = name;
        this.description = description;
        this.persons = persons;
    }
    

    @Override
    public Hobby toInternal() {
        List<Person> persons = new ArrayList();
        for (Person id : persons) {
            persons.add((Person) PersonFacade.persons.get(id.id));

        }
        return new Hobby(hobbyId, name,description, persons);
    }

}
