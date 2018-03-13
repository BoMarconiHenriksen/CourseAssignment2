
package persistence;

import entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.fluttercode.datafactory.impl.DataFactory;

public class TestDataGenerator {
    Person p ;
    DataFactory df = new DataFactory();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CourseAssignment2_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
  List <Person> persons = new ArrayList<>();
  
    
    
      public List<String> createTestPersons(){
        em.getTransaction().begin();
        for (int i = 0; i<100;i++){
            p= new Person (df.getFirstName(), df.getLastName(),null, df.getEmailAddress());
            em.persist(p);
            em.close();
            persons.add(p);
              em.getTransaction().commit();
        }
        
        
        return null;
             

        
    }
    
 public static void main(String[] args) {
     
      TestDataGenerator tdg = new TestDataGenerator();
      tdg.createTestPersons();
     
 
        
        
 
    }
 
 
}