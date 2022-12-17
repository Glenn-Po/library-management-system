/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package libraryManager.DAO.DAOUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
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
public class DAOUtilIT {
    
    public DAOUtilIT() {
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
     * Test of prepareStatement method, of class DAOUtil.
     */
    @Test
    public void testPrepareStatement() throws Exception {
        System.out.println("prepareStatement");
        Connection connection = null;
        String sql = "";
        boolean returnGeneratedKeys = false;
        Object[] values = null;
        PreparedStatement expResult = null;
        PreparedStatement result = DAOUtil.prepareStatement(connection, sql, returnGeneratedKeys, values);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValues method, of class DAOUtil.
     */
    @Test
    public void testSetValues() throws Exception {
        System.out.println("setValues");
        PreparedStatement statement = null;
        Object[] values = null;
        DAOUtil.setValues(statement, values);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toSqlDate method, of class DAOUtil.
     */
    @Test
    public void testToSqlDate() {
        System.out.println("toSqlDate");
        Date date = null;
        Date expResult = null;
        Date result = DAOUtil.toSqlDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
