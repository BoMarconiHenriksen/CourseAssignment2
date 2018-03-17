/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.JSONMessages;


import entity.Hobby;
import entity.Person;
import facade.HobbyFacade;
import java.util.ArrayList;


/**
 *
 * @author Ejer
 */
public class PersonMessage implements JSONMessage<Person> {

    public String firstName;
    public String lastName;
    public long personId;
    //public Address address;//List<Address> addresses;

    public PersonMessage(Person p) {
        this.personId = p.getId();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastname();
        //this.address = p.getAddress();
        //this.addresses.add(p.getAddress());

    }

    @Override
    public Person toInternal() {
        ArrayList<Hobby>hobbies=new ArrayList();
        for (Hobby id :hobbies){
            hobbies.add((Hobby) HobbyFacade.hobbies.get(id.id));
        
    }
        return new Person(firstName, lastName,hobbies);
    }



}
