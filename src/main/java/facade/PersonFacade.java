package facade;

import entity.Person;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PersonFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");

    EntityManager em = emf.createEntityManager();
    public static HashMap<Long, Person> persons = new HashMap<>();

    public static void deletePersonById(EntityManager em, Long personId) {
        Person p = getPerson(em, personId);
        em.getTransaction().begin();

        em.remove(p);//createQuery("DELETE from person where ID="+personId);
        em.getTransaction().commit();

    }

    public static void createPerson(EntityManager em, Person p) {
        em.getTransaction().begin();

        em.persist(p);
        em.getTransaction().commit();
        em.close();

    }

    public static void addPerson(EntityManager em, Long id, Person p) {
        createPerson(em, p);
        persons.put(id, p);
    }

    public List<Person> findPersonByName(String firstname) throws ClassCastException {

        Query q = em.createQuery("Select p from Person p where p.firstName=:firstname");
        q.setParameter("firstname", firstname);
        List< Person> persons = (List< Person>) q.getResultList();
        return persons;
    }

    public List<Person> getpersonsbyCity(String city) {

        Query q = em.createQuery("SELECT p FROM Person p, Address a, CityInfo c,  join p.address=a.cityinfo WHERE a.cityinfo=:city");
        List<Person> persons = q.getResultList();
        return persons;

    }
//    em.createQuery("SELECT MAX(p.price) FROM PurchaseOrder 
//                   o JOIN o.orderLineItems l JOIN l.product p JOIN p.supplier s WHERE s.sup_name = 'Tortuga Trading'")

    public static HashMap<Long, Person> getpersons(EntityManager em) {

        Query q = em.createQuery("SELECT p FROM Person p");
        List<Person> personnes = q.getResultList();
        for (int i = 0; i < personnes.size(); i++) {
            Long myLong = personnes.get(i).getId();
            persons.put(myLong, personnes.get(i));//persons.put(i, personnes.get(i));
        }

        return persons;

    }

    public static Person getPerson(EntityManager em, Long id) {
        return getpersons(em).get(id);

    }

    public static void updatePerson(Person p, Long id) {
        persons.remove(id);
        persons.put(id, p);
    }

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");

        EntityManager em = emf.createEntityManager();
        PersonFacade pf = new PersonFacade();
        pf.deletePersonById(em, 1L);

    }

}
