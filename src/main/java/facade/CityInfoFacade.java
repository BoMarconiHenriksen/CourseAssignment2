package facade;

import entity.CityInfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CityInfoFacade {
    
   EntityManagerFactory emf = Persistence.createEntityManagerFactory("CourseAssignment2_war_1.0-SNAPSHOTPU");
     EntityManager em = emf.createEntityManager();
  
     
 
    public List<CityInfo> getallzipofDK() {
       
        Query q = em.createQuery("SELECT c FROM CityInfo c");
        List<CityInfo> cityinfo = q.getResultList();
        return cityinfo;
                
    }
    
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CourseAssignment2_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CityInfoFacade cif = new CityInfoFacade();
        System.out.println(cif.getallzipofDK());
        em.close();
    }
}