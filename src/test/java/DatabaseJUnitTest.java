
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rest.TestDataGenerator;

public class DatabaseJUnitTest {

    public DatabaseJUnitTest() {
    }

    @BeforeClass
    public void setUp() {
        Persistence.generateSchema("testPU", null);

//        HashMap puproperties2 = new HashMap();
        //reCreateTestDatabase.sql skal køres hver gang test databasen skal køres
//        puproperties2.put("javax.persistence.sql-load-script-source", "/scripts/reCreateTestDatabase.sql");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");

        EntityManager em = emf.createEntityManager();
        TestDataGenerator tdg = new TestDataGenerator();

        em.getTransaction().begin();

        tdg.createTestAddresses(em);

        tdg.createTestPersons(em);
        tdg.createHobbies(em);
        tdg.createTestCompanies(em);
        tdg.createPhones(em);
//System.out.println(tdg.getCityInfo(em));
        em.getTransaction().commit();
        em.close();
        
        
    }
        /**
         * Test at vi har en forbindelse.
         */
        @Test
        public void testSetUpOK() {
//        assertNotNull( testConnection );
    }
    
    @AfterClass
        public static void tearDownClass() {
    }
    
    @After
        public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
