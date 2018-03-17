package facade;

import entity.InfoEntity;
import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 *
 * @author Bo
 */
public class PhoneFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    DataFactory df = new DataFactory();
    InfoEntity ie;

    public List<Phone> getPersonbyPhone(int tlf) {

        Query q = em.createQuery("SELECT c FROM Phone c where c.number=:tlf");
        q.setParameter("tlf", tlf);
        List<Phone> phone = q.getResultList();
        return phone;

    }

    public List<InfoEntity> getInfoEntities(EntityManager em) {
        List<InfoEntity> ies;
        Query q = em.createQuery("select e from InfoEntity e");
        ies = q.getResultList();
        return ies;
    }

    public void createPhones(EntityManager em) {

        Phone phone;
        for (int i = 0; i < 100; i++) {
            phone = new Phone(df.getNumberBetween(0000000, 9999999), df.getRandomWord(), getInfoEntities(em).get((int) (Math.random() * 49)));
            em.persist(phone);

        }
    }

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        PhoneFacade phf = new PhoneFacade();
        phf.createPhones(em);
        System.out.println("Not printable data, becouse of void methoed!");
        em.close();
    }

}
