package facade;

import entity.InfoEntity;
import entity.Person;
import static facade.PersonFacade.persons;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class InfoEntityFacade {

    public static HashMap<Integer, InfoEntity> infoEntityList = new HashMap<>();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    public static InfoEntity getEntityById(EntityManager em, long id) {
        Query query = em.createQuery("SELECT i FROM InfoEntity i WHERE i.id = :id")//+ id :id
                .setParameter("id", id);
        InfoEntity infoEntity = (InfoEntity) query.getSingleResult();

        return infoEntity;

    }

    public static HashMap<Integer, InfoEntity> getAllEntities(EntityManager em) {

        Query query = em.createQuery("SELECT i FROM InfoEntity i");
        List<InfoEntity> infoEntities = query.getResultList();
        for (int i = 0; i < infoEntities.size(); i++) {
            infoEntityList.put(i, infoEntities.get(i));
        }

        return infoEntityList;

    }

    public static InfoEntity getEntityByEmail(String email, EntityManager em) {
        Query query = em.createQuery("SELECT e FROM InfoEntity e WHERE e.email = :email")
                .setParameter("email", email);
        InfoEntity infoEntity = (InfoEntity) query.getSingleResult();

        System.out.println("Email: " + infoEntity.toString());

        return infoEntity;

    }

    //Til test
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

//        System.out.println(getEntityById(em, 1L));
        System.out.println(getAllEntities(em));
//        System.out.println(getEntityByEmail("worldin@b1zmail.us", em));
    }

}
