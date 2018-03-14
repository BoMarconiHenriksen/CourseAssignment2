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

    public List <Person> findPersonByName(String firstname)throws ClassCastException {

        Query q = em.createQuery("Select p from Person p where p.firstName=:firstname");
        q.setParameter("firstname", firstname);
        List< Person>persons = (List< Person>) q.getResultList();
        return persons;
    }

 
    public List<Person> getpersons() {

        Query q = em.createQuery("SELECT p FROM Person p");
        List<Person> persons = q.getResultList();
        return persons;

    }

    Person getPerson(int id) {
        return null;

    }



    

//    public List<Person> getpersonsbyCity(String city) {
//
//        Query q = em.createQuery("SELECT p FROM Person p, Address a, CityInfo c,  join p.address=a.cityinfo WHERE a.cityinfo=:city");
//        List<Person> persons = q.getResultList();
//        return persons;
//
//    }
//    em.createQuery("SELECT MAX(p.price) FROM PurchaseOrder 
//                   o JOIN o.orderLineItems l JOIN l.product p JOIN p.supplier s WHERE s.sup_name = 'Tortuga Trading'")

    
    public static void main(String[] args) {
        PersonFacade pf= new PersonFacade();
//        System.out.println(pf.getpersonsbyCity("København K"));s
    }

}
