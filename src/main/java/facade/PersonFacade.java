package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PersonFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CourseAssignment2_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    public Person findpersons(String firstname) {

        Query q = em.createNamedQuery("Cityinfo.findAll");
        q.setParameter("firstname", getpersons());
        Person person = (Person) q.getSingleResult();
        return person;
    }

    public List<Person> getpersons() {

        Query q = em.createQuery("SELECT c FROM CITYINFO c");
        List<Person> persons = q.getResultList();
        return persons;

    }

    Person getPerson(int id) {
        return null;

    }

    List<Person> getPersons() {
        return null;

    }

    List<Person> getPersons(int zipCode) {
        return null;

    }

    public Person findpersonsbyCity(String firstname) {

        Query q = em.createNamedQuery("Cityinfo.findByCity");
        q.setParameter("firstname", getpersonsbyCity());
        Person person = (Person) q.getSingleResult();
        return person;
    }

    public List<Person> getpersonsbyCity() {

        Query q = em.createQuery("SELECT c FROM Cityinfo c WHERE c.city = :city");
        List<Person> persons = q.getResultList();
        return persons;

    }

}
