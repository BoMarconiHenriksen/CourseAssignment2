package facade;

import entity.Address;
import entity.CityInfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CityInfoFacade {
    
   EntityManagerFactory emf = Persistence.createEntityManagerFactory("CourseAssignment2_war_1.0-SNAPSHOTPU");
     EntityManager em = emf.createEntityManager();
  
    public CityInfo findzipcodes(long id) {
       
        Query q = em.createNamedQuery("Cityinfo.findAll");
        q.setParameter("id", getzipcodes());
        CityInfo cityinfo = (CityInfo) q.getSingleResult();
        return cityinfo;
    }
     
 
    public List<CityInfo> getzipcodes() {
       
        Query q = em.createQuery("SELECT c FROM CITYINFO c");
        List<CityInfo> cityinfo = q.getResultList();
        return cityinfo;
        
        
    }
}