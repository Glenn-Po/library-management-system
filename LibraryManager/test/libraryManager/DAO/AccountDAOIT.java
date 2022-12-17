/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package libraryManager.DAO;

import java.util.List;
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
public class AccountDAOIT {
    
    public AccountDAOIT() {
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
     * Test of find method, of class AccountDAO.
     */
    @Test
    public void testFind_Integer() {
        System.out.println("find");
        Integer id = null;
        AccountDAO instance = new AccountDAO();
        Account expResult = null;
        Account result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class AccountDAO.
     */
    @Test
    public void testFind_String_String() {
        System.out.println("find");
        String username = "";
        String password = "";
        AccountDAO instance = new AccountDAO();
        Account expResult = null;
        Account result = instance.find(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class AccountDAO.
     */
    @Test
    public void testList() {
        System.out.println("list");
        AccountDAO instance = new AccountDAO();
        List<Account> expResult = null;
        List<Account> result = instance.list();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class AccountDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Account account = null;
        AccountDAO instance = new AccountDAO();
        instance.create(account);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class AccountDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Account account = null;
        AccountDAO instance = new AccountDAO();
        instance.update(account);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class AccountDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Account account = null;
        AccountDAO instance = new AccountDAO();
        instance.delete(account);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existUsername method, of class AccountDAO.
     */
    @Test
    public void testExistUsername() {
        System.out.println("existUsername");
        String username = "";
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.existUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class AccountDAO.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        Account account = null;
        AccountDAO instance = new AccountDAO();
        instance.changePassword(account);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
