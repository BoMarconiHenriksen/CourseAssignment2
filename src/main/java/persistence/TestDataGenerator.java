package persistence;

import entity.Address;
import entity.CityInfo;
import entity.Hobby;
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

    DataFactory df = new DataFactory();
    Address a = new Address();
  
    // denne metoder henter cityinfo objekter fra databasen som blev kørt med startscriptet
    public List<CityInfo> getCityInfo(EntityManager em) throws ClassCastException {
        List<CityInfo> cities2 = new ArrayList<>();

        List<CityInfo> cities = new ArrayList<>();
        Query q = em.createQuery("select c from CityInfo c");

        CityInfo ci;
        cities = q.getResultList();
        for (int i = 0; i < cities.size(); i++) {
            ci = new CityInfo(cities.get(i).getZip(), cities.get(i).getCity());
            cities2.add(ci);
        }

        return cities2;

    }

    public void createTestAddresses(EntityManager em) {

        Address b;

        for (int i = 0; i < 49; i++) {
            b = new Address(df.getStreetName(), getCityInfo(em).get((int) (Math.random() * 49)));
            em.persist(b);

        }
        em.getTransaction().commit();
    }

    public List<Address> getAddresses(EntityManager em) throws ClassCastException {
        List<Address> adds = new ArrayList<>();

        List<Address> addressers = new ArrayList<>();
        Query q = em.createQuery("select a from Address a");

        Address ci;
        adds = q.getResultList();
        for (int i = 0; i < adds.size(); i++) {
            ci = new Address(adds.get(i).getStreet(), adds.get(i).getCityinfo());

        }

        return adds;

    }

    public void createTestPersons(EntityManager em) {
        InfoEntity ie;

        for (int i = 0; i < 49; i++) {
            ie = new Person(df.getFirstName(), df.getLastName(), getAddresses(em).get(i), df.getEmailAddress());
            em.persist(ie);

        }
        em.getTransaction().commit();

    }
//      super(address, email);
//        this.name = name;
//        this.description = description;
//        this.cvr = cvr;
//        this.numEmployees = numEmployees;
//        this.marketValue = marketValue;
     public void createTestCompanies(EntityManager em) {
        InfoEntity ie = null;

        for (int i = 0; i < 49; i++) {
//            ie = new Company(df.getAddress(),df.getEmailAddress(),df.getBusinessName(), df.getRandomWord(),(int) df.getNumberBetween(300000, 1000000), (int) (Math.random() * 200), (int) (Math.random() * 2300000));
            em.persist(ie);

        }
        em.getTransaction().commit();

    }
    
    // her skal vi have fundet nogle rigtige ord
    public void createHobbies(EntityManager em){
        Hobby h;
        for (int i = 0; i<30; i++){
            h= new Hobby(df.getRandomWord(), df.getRandomText(20));
            em.persist(h);
            
        }
          em.getTransaction().commit();
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CourseAssignment2_war_1.0-SNAPSHOTPU");

        EntityManager em = emf.createEntityManager();
        TestDataGenerator tdg = new TestDataGenerator();

        em.getTransaction().begin();
        System.out.println(tdg.getCityInfo(em));
        tdg.createTestAddresses(em);
        em.getTransaction().begin();
        tdg.createTestPersons(em);
        tdg.createHobbies(em);

    }
}
