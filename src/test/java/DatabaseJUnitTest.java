
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseJUnitTest {

    public DatabaseJUnitTest() {
    }

    @BeforeClass
    public void setUp() {
        Persistence.generateSchema("testPU", null);

        HashMap puproperties2 = new HashMap();
        puproperties2.put("javax.persistence.sql-load-script-source", "/scripts/reCreateTestDatabase.sql");

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
