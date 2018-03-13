package persistence;

import entity.Address;
import entity.CityInfo;
import entity.InfoEntity;
import entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.fluttercode.datafactory.impl.DataFactory;

public class TestDataGenerator {

    InfoEntity ie = new InfoEntity() {
    };
    Person p;
    DataFactory df = new DataFactory();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CourseAssignment2_war_1.0-SNAPSHOTPU");

    EntityManager em = emf.createEntityManager();

    EntityManager em2 = emf.createEntityManager();

    List<Person> persons = new ArrayList<>();
    Address a = new Address();
    Address b;
    CityInfo ci;

    public List<CityInfo> getCityInfo(EntityManager em) {
        em.getTransaction().begin();
        Query q = em.createQuery("select c from CityInfo c");
        List<CityInfo> cities = q.getResultList();
        em.close();
        return cities;

    }

    public List<Address> createTestAddresses(EntityManager em) {

        em.getTransaction().begin();
        for (int i = 0; i < 100; i++) {
            b = new Address(df.getStreetName(), getCityInfo(em).get(i));
            em.persist(ie);

            em.getTransaction().commit();
            em.close();
        }
//String firstName, String lastname, Address address, String email
        return null;

    }

    public List<String> createTestPersons(EntityManager em) {
        em.getTransaction().begin();
        for (int i = 0; i < 100; i++) {
            ie = new Person(df.getFirstName(), df.getLastName(), a, df.getEmailAddress());
            em.persist(ie);

            em.getTransaction().commit();
            em.close();
        }
//String firstName, String lastname, Address address, String email
        return null;

    }

    public static void main(String[] args) {
 EntityManagerFactory emf = Persistence.createEntityManagerFactory("CourseAssignment2_war_1.0-SNAPSHOTPU");

    EntityManager em = emf.createEntityManager();
        TestDataGenerator tdg = new TestDataGenerator();
        tdg.getCityInfo(em);
        tdg.createTestAddresses(em);
        tdg.createTestPersons(em);

    }

}
