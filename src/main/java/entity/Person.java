/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Mantzius Lykke
 */
@DiscriminatorValue("Person")
@Entity
public class Person extends InfoEntity implements Serializable {

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastname;
    
    //Mange Person kender mange Hobby
    
    @ManyToMany
    private List<Hobby> hobbies = new ArrayList();

    public Person(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public Person(String firstName, String lastname, Address address, String email) {
        super(address, email);
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public Person(String firstName, String lastName, ArrayList<Hobby> hobbies) {
      this.firstName = firstName;
      this.lastname= lastName;
      this.hobbies=hobbies;
    }

    public List<Hobby> getHobbies() {
         if (hobbies == null) {
           hobbies= new ArrayList<>();
       
    } return hobbies;
    }
    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Person(Address address, String email) {
        super(address, email);
    }

    public Person() {
    }

   




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastname=" + lastname + ", hobbies=" + hobbies + '}';
    }
    
}
