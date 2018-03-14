package facade;

import entity.Address;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AddressFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CourseAssignment2_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    public Address findAddress(long id) {

        Query q = em.createQuery("select a from Address where a.id=:id");
        q.setParameter("id", getAddresses().get((int) id));
        Address addr = (Address) q.getSingleResult();
        return addr;
    }

    public List<Address> getAddresses() {

        Query q = em.createQuery("SELECT c FROM Address c");
        List<Address> addr = q.getResultList();
        return addr;

    }
    
    public Person findAddressbypersonName(String firstName) {

        Query q = em.createQuery("select a from Address where a.firstName=:" + firstName);
        q.setParameter("id", getAddressbyPersonName(firstName));
        Person person = (Person) q.getSingleResult();
        return person;
    }

    public List<Person> getAddressbyPersonName(String firstName) {

        Query q = em.createQuery("SELECT c FROM Address c where a.id:" + firstName);
        List<Person> person = q.getResultList();
        return person;

    }

    public int AddressCount() {
        Query q = em.createQuery("select count(*) from Address");
        int count = (int) q.getSingleResult();
        return count;
    }

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CourseAssignment2_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        AddressFacade af = new AddressFacade();
        System.out.println(af.findAddress(1L));
        em.close();
    }

}
