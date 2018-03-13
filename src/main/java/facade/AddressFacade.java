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
  
    public Pet findPet(int petId) {
       
        Query q = em.createNamedQuery("Pet.findById");
        q.setParameter("id",petId);
        Pet p = (Pet) q.getSingleResult();
        return p;
    }
     
 
    public List<Pet> getAllPets() {
       
        Query q = em.createQuery("select p from Pet p");
        List<Pet> pets = q.getResultList();
        return pets;
        
        
    }
    
   
    public int petCount(){
        Query q = em.createQuery("select count(*) from Pet");
        int count = (int) q.getSingleResult();
        return count;
    }
    
}