package facade;

import entity.InfoEntity;
import entity.Phone;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Bo
 */
public class InfoEntityFacade {
 EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");

    EntityManager em = emf.createEntityManager();

   public static HashMap<Long, InfoEntity> infoEntitites = new HashMap<>();
   public static HashMap<Integer, Phone>phones= new HashMap<>();
    
    
    public static void deleteInfoEntityById(EntityManager em, Long infoId) {
        InfoEntity ie = getInfoEntity(em, infoId);
        em.getTransaction().begin();
        em.remove(ie.getPhones());
        em.remove(ie);
//createQuery("DELETE from person where ID="+personId);
        em.getTransaction().commit();
    }

   

    public static InfoEntity getInfoEntity(EntityManager em, Long id) {
        return getInfoEntities(em).get(id);

    }
    
      public static Phone getPhones(int id) {
        return phones.get(id);
    }

    public static HashMap<Long, InfoEntity> getInfoEntities(EntityManager em) {

        Query q = em.createQuery("SELECT i FROM InfoEntity i");
        List<InfoEntity> ities = q.getResultList();
        for (int i = 0; i < ities.size(); i++) {
            infoEntitites.put(ities.get(i).getId(), ities.get(i));
        }

        return infoEntitites;

    }

    public static void main(String[] args) {
        InfoEntityFacade ief = new InfoEntityFacade();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");

    EntityManager em = emf.createEntityManager();
        
//        System.out.println(ief.getInfoEntities(em));
        ief.deleteInfoEntityById(em, 1L);
        System.out.println(ief.getPhones(0));
        
    }

   

}
