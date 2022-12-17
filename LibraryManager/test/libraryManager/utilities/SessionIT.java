/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package libraryManager.utilities;

import libraryManager.models.Account;
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
public class SessionIT {
    
    public SessionIT() {
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
     * Test of getAccount method, of class Session.
     */
    @Test
    public void testGetAccount() {
       java.lang.System.out.println("getAccount");
        Session instance = null;
        Account expResult = null;
        Account result = instance.getAccount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startSession method, of class Session.
     */
    @Test
    public void testStartSession() {
       java.lang.System.out.println("startSession");
        Account account = null;
        Session.startSession(account);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSession method, of class Session.
     */
    @Test
    public void testGetSession() {
       java.lang.System.out.println("getSession");
        Session expResult = null;
        Session result = Session.getSession();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of killSession method, of class Session.
     */
    @Test
    public void testKillSession() {
       java.lang.System.out.println("killSession");
        Session.killSession();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
