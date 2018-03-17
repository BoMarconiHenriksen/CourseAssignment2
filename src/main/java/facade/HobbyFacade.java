package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class HobbyFacade {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    public List<Person> getPersonbyHobby(String description) {

        Query q = em.createQuery("SELECT c FROM Hobby c where c.description =" + description);
        q.setParameter("description", description);
        List<Person> persons = q.getResultList();
        return persons;

    }
    
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        HobbyFacade pf = new HobbyFacade();
        System.out.println(pf.getPersonbyHobby("Greg"));
        em.close();
    }
    
}
