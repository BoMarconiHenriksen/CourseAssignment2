/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ejer
 */
public class PersonFacadeIT {
    
    public PersonFacadeIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of deletePersonById method, of class PersonFacade.
     */
    @Test
    public void testDeletePersonById() {
        System.out.println("deletePersonById");
        EntityManager em = null;
        Long personId = null;
        PersonFacade.deletePersonById(em, personId);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of createPerson method, of class PersonFacade.
     */
    @Test
    public void testCreatePerson() {
        System.out.println("createPerson");
        EntityManager em = null;
        Person p = null;
        PersonFacade.createPerson(em, p);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of findPersonByName method, of class PersonFacade.
     */
    @Test
    public void testFindPersonByName() {
        System.out.println("findPersonByName");
        String firstname = "";
        PersonFacade instance = new PersonFacade();
        List<Person> expResult = null;
        List<Person> result = instance.findPersonByName(firstname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of getpersonsbyCity method, of class PersonFacade.
     */
    @Test
    public void testGetpersonsbyCity() {
        System.out.println("getpersonsbyCity");
        String city = "";
        PersonFacade instance = new PersonFacade();
        List<Person> expResult = null;
        List<Person> result = instance.getpersonsbyCity(city);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of getpersons method, of class PersonFacade.
     */
    @Test
    public void testGetpersons() {
        System.out.println("getpersons");
        EntityManager em = null;
        HashMap<Long, Person> expResult = null;
        HashMap<Long, Person> result = PersonFacade.getpersons(em);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of getPerson method, of class PersonFacade.
     */
    @Test
    public void testGetPerson() {
        System.out.println("getPerson");
        EntityManager em = null;
        Long id = null;
        Person expResult = null;
        Person result = PersonFacade.getPerson(em, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of main method, of class PersonFacade.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        PersonFacade.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//     
//    }
//    
}
