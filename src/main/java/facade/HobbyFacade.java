package facade;

import entity.Hobby;
import entity.Person;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class HobbyFacade {

    public static HashMap<Integer, Hobby> hobbies = new HashMap<>();

  
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    public List<Person> getPersonbyHobby(String description) {

        Query q = em.createQuery("SELECT c FROM Hobby c where c.description =:description");
        q.setParameter("description", description);
        List<Person> persons = q.getResultList();
        return persons;

    }
      public static HashMap<Integer,Hobby> getHobbies(EntityManager em) {
     
         Query q = em.createQuery("SELECT h FROM Hobby h");
       List<Hobby> hobbs = q.getResultList();
      for (int i = 0; i<hobbs.size(); i++){
         hobbies.put(i, hobbs.get(i));
      }
        
        return hobbies;

    }
    public static void main(String[] args) { 

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        HobbyFacade pf = new HobbyFacade();
        System.out.println(pf.getHobbies(em));
        System.out.println(pf.getHobbies(em).get(1));
        em.close();
    }
    
}
