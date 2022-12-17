package libraryManager.DAO.DAOInterface;

import java.util.List;
import libraryManager.DAO.exceptions.DAOException;

public interface BookCategory {
        // Actions ------------------------------------------------------------------------------------

    /**
     * Returns the bookCategory from the database matching the given ID, otherwise null.
     * @param id The ID of the bookCategory to be returned.
     * @return The bookCategory from the database matching the given ID, otherwise null.
     * @throws DAOException If something fails at database level.
     */
    public libraryManager.models.BookCategory find(Integer id) throws DAOException;

    /**
     * Returns the bookCategory from the database matching the given email and password, otherwise null.
     * @param name The isbn of the bookCategory to be returned.
     * @return The bookCategory from the database matching the given email and password, otherwise null.
     * @throws DAOException If something fails at database level.
     */
    public libraryManager.models.BookCategory find(String name) throws DAOException;
    /**
     * Returns a list of all books from the database ordered by bookCategory ID. The list is never null and
     * is empty when the database does not contain any bookCategory.
     * @return A list of all books from the database ordered by bookCategory ID.
     * @throws DAOException If something fails at database level.
     */
    public List<libraryManager.models.BookCategory> list() throws DAOException;

    /**
     * Create the given bookCategory in the database. The bookCategory ID must be null, otherwise it will throw
     * IllegalArgumentException. After creating, the DAO will set the obtained ID in the given bookCategory.
     * @param bookCategory The bookCategory to be created in the database.
     * @throws IllegalArgumentException If the bookCategory ID is not null.
     * @throws DAOException If something fails at database level.
     */
    public void create(libraryManager.models.BookCategory bookCategory) throws IllegalArgumentException, DAOException;

    /**
     * Update the given bookCategory in the database. The bookCategory ID must not be null, otherwise it will throw
     * IllegalArgumentException. Note: the password will NOT be updated. Use changePassword() instead.
     * @param bookCategory The bookCategory to be updated in the database.
     * @throws IllegalArgumentException If the bookCategory ID is null.
     * @throws DAOException If something fails at database level.
     */
    public void update(libraryManager.models.BookCategory bookCategory) throws IllegalArgumentException, DAOException;

    /**
     * Delete the given bookCategory from the database. After deleting, the DAO will set the ID of the given
     * bookCategory to null.
     * @param bookCategory The bookCategory to be deleted from the database.
     * @throws DAOException If something fails at database level.
     */
    public void delete(libraryManager.models.BookCategory bookCategory) throws DAOException;


}
