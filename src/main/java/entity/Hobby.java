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
public class Hobby extends InfoEntity implements Serializable {

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    
    @ManyToMany(mappedBy = "hobbyCollection")
    private Collection<Person> personCollection;
    //private ArrayList<Person> personList;// = new ArrayList();

    public Hobby(String name, String description, Collection<Person> personCollection) {
        this.name = name;
        this.description = description;
        this.personCollection = personCollection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    
    
}
