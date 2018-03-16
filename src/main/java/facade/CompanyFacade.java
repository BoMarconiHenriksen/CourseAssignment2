package facade;

import entity.Company;
import static facade.PersonFacade.persons;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CompanyFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
    public static HashMap<Integer, Company> companies = new HashMap<>();
    
    public List <Company> findCompanyByName(String name)throws ClassCastException {

        Query q = em.createQuery("Select c from Company c where c.name:name");
        q.setParameter("name", name);
        List< Company>companies = (List< Company>) q.getResultList();
        return companies;
    }
    
    public static HashMap<Integer, Company> getCompanies(EntityManager em) {

        Query q = em.createQuery("SELECT c FROM Company c");
        List<Company> cmpnies = q.getResultList();
        for (int i = 0; i<cmpnies.size(); i++){
          companies.put(i, cmpnies.get(i));
      }
        return companies;

    }
    
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CompanyFacade compaf = new CompanyFacade();
        System.out.println(compaf.getCompanies(em));
        em.close();
    }
    
}
