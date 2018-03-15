package facade;

import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Bo
 */
public class PhoneFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CourseAssignment2_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    public List<Phone> getPersonbyPhone(int tlf) {

        Query q = em.createQuery("SELECT c FROM Phone c where c.number=:tlf");
        q.setParameter("tlf", tlf);
        List<Phone> phone = q.getResultList();
        return phone;

    }
    
     public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CourseAssignment2_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        PhoneFacade af = new PhoneFacade();
        System.out.println(af.getPersonbyPhone(44564345));
        em.close();
    }

}
