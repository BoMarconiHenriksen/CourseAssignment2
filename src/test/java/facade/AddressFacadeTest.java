/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Address;
import entity.Person;
import java.util.List;
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
public class AddressFacadeTest {
    
    public AddressFacadeTest() {
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
     * Test of findAddress method, of class AddressFacade.
     */
    @Test
    public void testFindAddress() {
        System.out.println("findAddress");
        long id = 0L;
        AddressFacade instance = new AddressFacade();
        Address expResult = null;
        Address result = instance.findAddress(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddresses method, of class AddressFacade.
     */
    @Test
    public void testGetAddresses() {
        System.out.println("getAddresses");
        AddressFacade instance = new AddressFacade();
        List<Address> expResult = null;
        List<Address> result = instance.getAddresses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAddressbypersonName method, of class AddressFacade.
     */
    @Test
    public void testFindAddressbypersonName() {
        System.out.println("findAddressbypersonName");
        String firstName = "";
        AddressFacade instance = new AddressFacade();
        Person expResult = null;
        Person result = instance.findAddressbypersonName(firstName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddressbyPersonName method, of class AddressFacade.
     */
    @Test
    public void testGetAddressbyPersonName() {
        System.out.println("getAddressbyPersonName");
        String firstName = "";
        AddressFacade instance = new AddressFacade();
        List<Person> expResult = null;
        List<Person> result = instance.getAddressbyPersonName(firstName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddressCount method, of class AddressFacade.
     */
    @Test
    public void testAddressCount() {
        System.out.println("AddressCount");
        AddressFacade instance = new AddressFacade();
        int expResult = 0;
        int result = instance.AddressCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class AddressFacade.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AddressFacade.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
