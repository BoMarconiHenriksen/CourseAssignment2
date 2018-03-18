package entity;

import java.io.Serializable;
import java.util.List;
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
public class Hobby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    //Mange Hobby kender mange Person
    @ManyToMany(mappedBy = "hobbies")
    private List<Person> persons;

    public Hobby(Long id, String name, String description, List<Person> persons) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.persons = persons;
    }
    
    

    public Hobby(String name, String description, List<Person> persons) {
        this.name = name;
        this.description = description;
        this.persons = persons;
    }
    

    public Hobby() {

    }

    public Hobby(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Hobby(int hobbyId, String name, String description, List<Person> persons) {
   
    }

  

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoEntity)) {
            return false;
        }
        InfoEntity other = (InfoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hobby{" + "id=" + id + ", name=" + name + ", description=" + description + ", persons=" + persons + '}';
    }

}
