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

  public HashMap<Integer,Person> getpersonsDebug(EntityManager em) {

        Query q = em.createQuery("SELECT p FROM Person p");
        List<Person> personnes = q.getResultList();
      for (int i = 0; i<personnes.size(); i++){
          persons.put(i, personnes.get(i));
      }
        
        return persons;

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
        //System.out.println(pf.getpersonsDebug(pf.em));
        HashMap<Integer,Person> testMap = pf.getpersonsDebug(pf.em);
        Person p0 = testMap.get(0);
        System.out.println(p0);
        Long i0 = p0.getId();
        System.out.println(i0);
        
        Person p1 = testMap.get(1);
        System.out.println(p1);
        Long i1 = p1.getId();
        System.out.println(i1);
        
        Person p2 = testMap.get(2);
        System.out.println(p2);
        Long i2 = p2.getId();
        System.out.println(i2);
        
        System.out.println("id nr 3: Chelsie Hurst");
        //get id, getAddress,  get email, 
        System.out.println(p2.getId());
        System.out.println(p2.getAddress());
        System.out.println(p2.getEmail());
        
        //System.out.println(pf.findPersonByName("Tim"));
        //System.out.println(pf.getpersonsbyCity("København K"));
        //System.out.println(PersonFacade.getpersons(em));
//        System.out.println(pf.getpersonsbyCity("København K"));s


    }

}
