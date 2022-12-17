/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package libraryManager.utilities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class UtilitiesIT {
    
    public UtilitiesIT() {
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
     * Test of hash method, of class Utilities.
     */
    @Test
    public void testHash() {
       java.lang.System.out.println("hash");
        String input = "password";
        String expResult = "18b12113515c14f1c61a319815f1171a411e1571fb1871e21bd16d1861a71421661a01e01341321061681f014316a1cc1651be16611d12316f13c1ad15518b14c1f41571a215d13b1e91731bd1251701fc1a51621a210c12017a14c1e31d41d1";
        String result = Utilities.hash(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of matchRegex method, of class Utilities.
     */
    @Test
    public void testMatchRegex() {
       java.lang.System.out.println("matchRegex");
          String input = "123";
        Utilities instance = new Utilities();
        boolean expResult = false;
        boolean result = instance.matchRegex(regex, input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidPassword method, of class Utilities.
     */
    @Test
    public void testIsValidPassword() {
       java.lang.System.out.println("isValidPassword");
        String password = "Qw@23+77rU4eD";
        Utilities instance = new Utilities();
        boolean expResult = true;
        boolean result = instance.isValidPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidEmail method, of class Utilities.
     */
    @Test
    public void testIsValidEmail() {
       java.lang.System.out.println("isValidEmail");
        String emailAdress = "libman@gmail.com";
        Utilities instance = new Utilities();
        boolean expResult = true;
        boolean result = instance.isValidEmail(emailAdress);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidPhone method, of class Utilities.
     */
    @Test
    public void testIsValidPhone() {
       java.lang.System.out.println("isValidPhone");
        String PhoneNumber = "(+237)677777777";
        Utilities instance = new Utilities();
        boolean expResult = false;
        boolean result = instance.isValidPhone(PhoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
