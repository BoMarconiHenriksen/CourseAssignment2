package facade;

import entity.Hobby;
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
  public static HashMap<Integer, Hobby> hobbies = new HashMap<>();
  public static HashMap<Integer, Person> persons= new HashMap<>();
    
  
    
    
    public static void deletePersonById(EntityManager em, int personId) {
        Person p = getPerson(em, personId);
        em.getTransaction().begin();

        em.remove(p);//createQuery("DELETE from person where ID="+personId);
        em.getTransaction().commit();
    }
  
    public static void createPerson(EntityManager em, Person p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
       
    }
  
    public List <Person> findPersonByName(String firstname)throws ClassCastException {

        Query q = em.createQuery("Select p from Person p where p.firstName=:firstname");
        q.setParameter("firstname", firstname);
        List< Person>persons = (List< Person>) q.getResultList();
        return persons;
    }
    
    
    public static List <Hobby> findHobbiesById(Long id){
        return (List<Hobby>) hobbies.get(id);
        
    }
    public List<Person> getpersonsbyCity(String city) {

        Query q = em.createQuery("SELECT p FROM Person p, Address a, CityInfo c,  join p.address=a.cityinfo WHERE a.cityinfo=:city");
        List<Person> persons = q.getResultList();
        return persons;

    }
//    em.createQuery("SELECT MAX(p.price) FROM PurchaseOrder 
//                   o JOIN o.orderLineItems l JOIN l.product p JOIN p.supplier s WHERE s.sup_name = 'Tortuga Trading'")

 
    public static HashMap<Integer,Person> getpersons(EntityManager em) {

        Query q = em.createQuery("SELECT p FROM Person p");
        List<Person> personnes = q.getResultList();
      for (int i = 0; i<personnes.size(); i++){
          persons.put(i, personnes.get(i));
      }
        
        return persons;

    }

  public static  Person getPerson(EntityManager em,int id) {
        return getpersons(em).get(id);

    }
   
    
    public static void main(String[] args) {
        
        
    }

}
