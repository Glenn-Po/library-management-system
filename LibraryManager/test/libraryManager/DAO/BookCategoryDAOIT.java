/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package libraryManager.DAO;

import java.util.List;
import libraryManager.models.BookCategory;
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
public class BookCategoryDAOIT {
    
    public BookCategoryDAOIT() {
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
     * Test of find method, of class BookCategoryDAO.
     */
    @Test
    public void testFind_Integer() {
        System.out.println("find");
        Integer id = null;
        BookCategoryDAO instance = new BookCategoryDAO();
        BookCategory expResult = null;
        BookCategory result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class BookCategoryDAO.
     */
    @Test
    public void testFind_String() {
        System.out.println("find");
        String name = "";
        BookCategoryDAO instance = new BookCategoryDAO();
        BookCategory expResult = null;
        BookCategory result = instance.find(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class BookCategoryDAO.
     */
    @Test
    public void testList() {
        System.out.println("list");
        BookCategoryDAO instance = new BookCategoryDAO();
        List<BookCategory> expResult = null;
        List<BookCategory> result = instance.list();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class BookCategoryDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        BookCategory bookCategory = null;
        BookCategoryDAO instance = new BookCategoryDAO();
        instance.create(bookCategory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class BookCategoryDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        BookCategory bookCategory = null;
        BookCategoryDAO instance = new BookCategoryDAO();
        instance.update(bookCategory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class BookCategoryDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        BookCategory bookCategory = null;
        BookCategoryDAO instance = new BookCategoryDAO();
        instance.delete(bookCategory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
