
package libraryManager.DAO.DAOInterface;

import java.util.List;
import libraryManager.DAO.exceptions.DAOException;

/*
*Find Account by ID
*Find Account by username and password
*
*Create Account
*Read account (By ID, By username&password) as above
*Update Account
*Delete Account
*
*Check if username exist
*Change Password
=========================
*Read all accounts
*/


public interface Account {
    // Actions ------------------------------------------------------------------------------------

    /**
     * Returns the account from the database matching the given ID, otherwise null.
     * @param id The ID of the account to be returned.
     * @return The account from the database matching the given ID, otherwise null.
     * @throws DAOException If something fails at database level.
     */
    public libraryManager.models.Account find(Integer id) throws DAOException;

    /**
     * Returns the account from the database matching the given email and password, otherwise null.
     * @param username The username of the account to be returned.
     * @param password The password of the account to be returned.
     * @return The account from the database matching the given email and password, otherwise null.
     * @throws DAOException If something fails at database level.
     */
    public libraryManager.models.Account find(String username, String password) throws DAOException;
    /**
     * Returns a list of all accounts from the database ordered by account ID. The list is never null and
     * is empty when the database does not contain any account.
     * @return A list of all accounts from the database ordered by account ID.
     * @throws DAOException If something fails at database level.
     */
    public List<libraryManager.models.Account> list() throws DAOException;

    /**
     * Create the given account in the database. The account ID must be null, otherwise it will throw
     * IllegalArgumentException. After creating, the DAO will set the obtained ID in the given account.
     * @param account The account to be created in the database.
     * @throws IllegalArgumentException If the account ID is not null.
     * @throws DAOException If something fails at database level.
     */
    public void create(libraryManager.models.Account account) throws IllegalArgumentException, DAOException;

    /**
     * Update the given account in the database. The account ID must not be null, otherwise it will throw
     * IllegalArgumentException. Note: the password will NOT be updated. Use changePassword() instead.
     * @param account The account to be updated in the database.
     * @throws IllegalArgumentException If the account ID is null.
     * @throws DAOException If something fails at database level.
     */
    public void update(libraryManager.models.Account account) throws IllegalArgumentException, DAOException;

    /**
     * Delete the given account from the database. After deleting, the DAO will set the ID of the given
     * account to null.
     * @param account The account to be deleted from the database.
     * @throws DAOException If something fails at database level.
     */
    public void delete(libraryManager.models.Account account) throws DAOException;

    /**
     * Returns true if the given email address exist in the database.
     * @param username The username which is to be checked in the database.
     * @return True if the given email address exist in the database.
     * @throws DAOException If something fails at database level.
     */
    public boolean existUsername(String username) throws DAOException;

    /**
     * Change the password of the given account. The account ID must not be null, otherwise it will throw
     * IllegalArgumentException.
     * @param account The account to change the password for.
     * @throws IllegalArgumentException If the account ID is null.
     * @throws DAOException If something fails at database level.
     */
    public void changePassword(libraryManager.models.Account account) throws DAOException;

}
