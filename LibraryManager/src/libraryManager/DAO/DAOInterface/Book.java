
package libraryManager.DAO.DAOInterface;

import java.util.List;
import libraryManager.DAO.exceptions.DAOException;

/*
*Find Book by ID
*Find Book by title
*Find books by author
*
*Create Book
*Read Book (By ID, By username&password) as above
*Update Book
*Delete Book
* 
=========================
*Read all books
*/
public interface Book {
    // Actions ------------------------------------------------------------------------------------

    /**
     * Returns the book from the database matching the given ID, otherwise null.
     * @param id The ID of the book to be returned.
     * @return The book from the database matching the given ID, otherwise null.
     * @throws DAOException If something fails at database level.
     */
    public libraryManager.models.Book find(Integer id) throws DAOException;

    /**
     * Returns the book from the database matching the given email and password, otherwise null.
     * @param isbn The isbn of the book to be returned.
     * @return The book from the database matching the given email and password, otherwise null.
     * @throws DAOException If something fails at database level.
     */
    public libraryManager.models.Book find(String isbn) throws DAOException;
    /**
     * Returns a list of all books from the database ordered by book ID. The list is never null and
     * is empty when the database does not contain any book.
     * @return A list of all books from the database ordered by book ID.
     * @throws DAOException If something fails at database level.
     */
    public List<libraryManager.models.Book> list() throws DAOException;

    /**
     * Create the given book in the database. The book ID must be null, otherwise it will throw
     * IllegalArgumentException. After creating, the DAO will set the obtained ID in the given book.
     * @param book The book to be created in the database.
     * @throws IllegalArgumentException If the book ID is not null.
     * @throws DAOException If something fails at database level.
     */
    public void create(libraryManager.models.Book book) throws IllegalArgumentException, DAOException;

    /**
     * Update the given book in the database. The book ID must not be null, otherwise it will throw
     * IllegalArgumentException. Note: the password will NOT be updated. Use changePassword() instead.
     * @param book The book to be updated in the database.
     * @throws IllegalArgumentException If the book ID is null.
     * @throws DAOException If something fails at database level.
     */
    public void update(libraryManager.models.Book book) throws IllegalArgumentException, DAOException;

    /**
     * Delete the given book from the database. After deleting, the DAO will set the ID of the given
     * book to null.
     * @param book The book to be deleted from the database.
     * @throws DAOException If something fails at database level.
     */
    public void delete(libraryManager.models.Book book) throws DAOException;

    /**
     * FInds and returns all books by the author in the database.
     * @param author The athor whose books are to be gotten from the database.
     * @return list of books write by the author.
     * @throws DAOException If something fails at database level.
     */
    public List<libraryManager.models.Book> findByAuthor(String author) throws DAOException;
    
    /**
     * Finds and returns the books with the particular title in the database
     * @param title The title of the book in the database.
     * @return The book with the particular title
     * @throws DAOException If something fails at database level.
     */
    public libraryManager.models.Book findByTitle(String title) throws DAOException;

}
