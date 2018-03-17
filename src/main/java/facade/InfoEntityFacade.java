package facade;

import entity.InfoEntity;
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

    HashMap<Integer, InfoEntity> infoEntitites = new HashMap<>();

    public InfoEntity getInfoEntity(EntityManager em, Long id) {
        return getInfoEntities(em).get(id);

    }

    public HashMap<Integer, InfoEntity> getInfoEntities(EntityManager em) {

        Query q = em.createQuery("SELECT i FROM InfoEntity i");
        List<InfoEntity> ities = q.getResultList();
        for (int i = 0; i < ities.size(); i++) {
            infoEntitites.put(i, ities.get(i));
        }

        return infoEntitites;

    }

}
