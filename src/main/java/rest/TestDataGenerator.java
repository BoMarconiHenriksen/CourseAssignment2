package rest;

import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.InfoEntity;
import entity.Person;
import entity.Phone;
import facade.HobbyFacade;
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

    public void createTestAddresses(EntityManager em) throws ClassCastException {

        Address b;

        for (int i = 0; i < 100; i++) {
            b = new Address(df.getStreetName(), getCityInfo(em).get((int) (Math.random() * 1348)));
            em.persist(b);

        }

    }

    
    void dropOurDatabase(EntityManager em) {
        em.createQuery("delete from ca2_databuilders ca2_databuilders;");
        
    }
    
    void createOurDatabase(EntityManager em) {
        em.createQuery("create SCHEMA ca2_databuilders;");
        
    }
    
    public List<Address> getAddresses(EntityManager em) throws ClassCastException {
        List<Address> adds = new ArrayList<>();

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
//            createTestAddresses(em);
            ie = new Person(getAddresses(em).get(i), df.getEmailAddress(),df.getFirstName(), df.getLastName(),  createHobbyLists(em));
            em.persist(ie);

        }

    }
//      super(address, email);
//String name, String description, int cvr, int numEmployees, int marketValue, Address address, String email

    public void createTestCompanies(EntityManager em) {
        InfoEntity ie;

        for (int i = 0; i < 49; i++) {
            ie = new Company(df.getBusinessName(), df.getRandomWord(), (int) df.getNumberBetween(300000, 1000000), (int) (Math.random() * 200), (int) (Math.random() * 2300000), getAddresses(em).get(i + 49), df.getEmailAddress());
            em.persist(ie);

        }

    }

    // her skal vi have fundet nogle rigtige ord
    public void createHobbies(EntityManager em) {

        Hobby h;
        for (int i = 0; i < 30; i++) {
            h = new Hobby(df.getRandomWord(), df.getRandomWord() + " " + df.getRandomWord());
            em.persist(h);

        }

    }
    public List<Hobby> createHobbyLists(EntityManager em){
        List<Hobby>hobbies= new ArrayList<>();
        Hobby h ;
        for (int i =0;i<Math.random()*30;i++){
            for (int j= 0;j<Math.random()*5;j++){
            h=HobbyFacade.getHobbies(em).get(j);
            hobbies.add(h);
        }
      
    }
         return hobbies;
    }

    public List<InfoEntity> getInfoEntities(EntityManager em) {
        List<InfoEntity> ies;
        Query q = em.createQuery("select e from InfoEntity e");
        ies = q.getResultList();
        return ies;
    }

    public void createPhones(EntityManager em) {

        Phone phone;
        for (int i = 0; i < 100; i++) {
            phone = new Phone(df.getNumberBetween(10000000, 99999999), df.getRandomWord(), getInfoEntities(em).get((int) (Math.random() *49)));
            em.persist(phone);

        }

    }

    //public static void main(String[] args) {
    public static void fillTables() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeployedCourseAssignment2_war_1.0-SNAPSHOTPU");

        EntityManager em = emf.createEntityManager();
        TestDataGenerator tdg = new TestDataGenerator();

        em.getTransaction().begin();

        tdg.createTestAddresses(em);
        tdg.createHobbies(em);
        tdg.createTestPersons(em);
        
        tdg.createTestCompanies(em);
        tdg.createPhones(em);
//System.out.println(tdg.getCityInfo(em));
        em.getTransaction().commit();
        em.close();
    }

}
