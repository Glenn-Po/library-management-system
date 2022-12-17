/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package libraryManager.DAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Admin
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({libraryManager.DAO.DAOFactoryIT.class, libraryManager.DAO.AccountDAOIT.class, libraryManager.DAO.BookDAOIT.class, libraryManager.DAO.BookIssueDAOIT.class, libraryManager.DAO.exceptions.ExceptionsITSuite.class, libraryManager.DAO.BookCategoryDAOIT.class, libraryManager.DAO.DAOUtil.DAOUtilITSuite.class})
public class DAOITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
