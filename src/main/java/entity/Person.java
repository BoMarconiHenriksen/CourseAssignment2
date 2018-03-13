/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Mantzius Lykke
 */
@Entity
public class Person extends InfoEntity implements Serializable {

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastname;
    
    @ManyToMany
    private Collection<Hobby> hobbycCollection;
    //private ArrayList<Hobby> hobbyList; //= new ArrayList();

    public Person(String firstName, String lastname, Collection<Hobby> hobbycCollection, Address address, String email) {
        super(address, email);
        this.firstName = firstName;
        this.lastname = lastname;
        this.hobbycCollection = hobbycCollection;
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

    public Collection<Hobby> getHobbycCollection() {
        return hobbycCollection;
    }

    public void setHobbycCollection(Collection<Hobby> hobbycCollection) {
        this.hobbycCollection = hobbycCollection;
    }

    
    
    
}
