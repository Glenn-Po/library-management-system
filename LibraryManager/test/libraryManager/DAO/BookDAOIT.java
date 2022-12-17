/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package libraryManager.DAO;

import java.util.List;
import libraryManager.models.Book;
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
public class BookDAOIT {
    
    public BookDAOIT() {
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
     * Test of find method, of class BookDAO.
     */
    @Test
    public void testFind_Integer() {
        System.out.println("find");
        Integer id = null;
        BookDAO instance = new BookDAO();
        Book expResult = null;
        Book result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class BookDAO.
     */
    @Test
    public void testFind_String() {
        System.out.println("find");
        String isbn = "";
        BookDAO instance = new BookDAO();
        Book expResult = null;
        Book result = instance.find(isbn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByAuthor method, of class BookDAO.
     */
    @Test
    public void testFindByAuthor() {
        System.out.println("findByAuthor");
        String author = "";
        BookDAO instance = new BookDAO();
        List<Book> expResult = null;
        List<Book> result = instance.findByAuthor(author);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByTitle method, of class BookDAO.
     */
    @Test
    public void testFindByTitle() {
        System.out.println("findByTitle");
        String title = "";
        BookDAO instance = new BookDAO();
        Book expResult = null;
        Book result = instance.findByTitle(title);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class BookDAO.
     */
    @Test
    public void testList() {
        System.out.println("list");
        BookDAO instance = new BookDAO();
        List<Book> expResult = null;
        List<Book> result = instance.list();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class BookDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Book book = null;
        BookDAO instance = new BookDAO();
        instance.create(book);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class BookDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Book book = null;
        BookDAO instance = new BookDAO();
        instance.update(book);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class BookDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Book book = null;
        BookDAO instance = new BookDAO();
        instance.delete(book);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
