package facade;

import entity.Address;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AddressFacade {
    
   EntityManagerFactory emf = Persistence.createEntityManagerFactory("CourseAssignment2_war_1.0-SNAPSHOTPU");
     EntityManager em = emf.createEntityManager();
  
    public Address findAddress(long id) {
       
        Query q = em.createNamedQuery("Address.findAll");
        q.setParameter("id", getAddresses());
        Address addr = (Address) q.getSingleResult();
        return addr;
    }
     
 
    public List<Address> getAddresses() {
       
        Query q = em.createQuery("SELECT c FROM Address c");
        List<Address> addr = q.getResultList();
        return addr;
        
        
    }
    
   
    public int AddressCount(){
        Query q = em.createQuery("select count(*) from Address");
        int count = (int) q.getSingleResult();
        return count;
    }
    
}