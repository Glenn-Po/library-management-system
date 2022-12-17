
package libraryManager.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import static libraryManager.DAO.DAOUtil.DAOUtil.*;
import java.util.List;
import libraryManager.DAO.exceptions.DAOException;
import libraryManager.models.Account;
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
*Read all users
*/

public class AccountDAO implements libraryManager.DAO.DAOInterface.Account {
    private static final String SQL_FIND_BY_ID =
        "SELECT * FROM account WHERE account_id = ?";
    private static final String SQL_FIND_BY_ID_USERNAME_AND_PASSWORD =
        "SELECT * FROM account WHERE username = ? AND hashed_password = ?";
    private static final String SQL_LIST_ORDER_BY_ID =
        "SELECT * FROM account ORDER BY account_id";
    private static final String SQL_INSERT =
        "INSERT INTO account(username, full_name, email, phone_number,priviledge, hashed_password, "+
            "account_status,recovery_question, recovery_answer )" +
           "  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE =
        "UPDATE account SET username = ?, full_name = ?, "+
            "email = ?, phone_number = ?,priviledge = ?, hashed_password = ?, "+
            "account_status = ?,recovery_question = ?, recovery_answer = ? "+
        "WHERE account_id = ?";
    
    private static final String SQL_DELETE =
        "DELETE FROM account WHERE account_id = ?";
    private static final String SQL_EXIST_USERNAME =
        "SELECT account_id FROM account WHERE username = ?";
    private static final String SQL_CHANGE_PASSWORD =
        "UPDATE account SET password = ? WHERE account_id = ?";
    
    private final Connection connection;
    public AccountDAO(){
        connection = DAOFactory.getConnection();
    }
    
    @Override
    public Account find(Integer id) throws DAOException{
        return find(SQL_FIND_BY_ID, id);
    }

    @Override
    public Account find(String username, String password) throws DAOException{
        return find(SQL_FIND_BY_ID_USERNAME_AND_PASSWORD, username, password);
    }
    
    /**
     * Returns the account from the database matching the given SQL query with the given values.
     * @param sql The SQL query to be executed in the database.
     * @param values The PreparedStatement values to be set.
     * @return The account from the database matching the given SQL query with the given values.
     * @throws DAOException If something fails at database level.
     */
    private Account find(String sql, Object... values) throws DAOException {
        Account account = null;

        try (
            PreparedStatement statement = prepareStatement(connection, sql, false, values);
            ResultSet resultSet = statement.executeQuery();
        ) {
            if (resultSet.next()) {
                account = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return account;
    }

    @Override
    public List<Account> list() throws DAOException{
        List<Account> accounts = new ArrayList<>();

        try (
            PreparedStatement statement = connection.prepareStatement(SQL_LIST_ORDER_BY_ID);
            ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                accounts.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return accounts;
    }

    @Override
    public void create(Account account) throws IllegalArgumentException, DAOException{
        Object[] values = {
            account.getUsername(),
            account.getFullName(),
            account.getEmail(),
            account.getPhoneNumber(),
            account.getPriviledge(),
            account.getHashedPassword() ,
            account.getAccountStatus(),
            account.getRecoveryQuestion(),
            account.getRecoveryAnswer()
        };

        try (
            PreparedStatement statement = prepareStatement(connection, SQL_INSERT, false, values);
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Failed to Create a new account.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void update(Account account) throws IllegalArgumentException, DAOException{
        Object[] values = {
            account.getUsername(),
            account.getFullName(),
            account.getEmail(),
            account.getPhoneNumber(),
            account.getPriviledge(),
            account.getHashedPassword() ,
            account.getAccountStatus(),
            account.getRecoveryQuestion(),
            account.getRecoveryAnswer(),
            account.getAccountId()
        };

        try (
            PreparedStatement statement = prepareStatement(connection, SQL_UPDATE, false, values);
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Failed to make changes to account.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(Account account) throws DAOException{
        if (account.getAccountId() == null) {
            throw new DAOException("User is not created yet, the user ID is null.");
        }

        Object[] values = {
            account.getAccountId()
        };

        try (
            PreparedStatement statement = prepareStatement(connection, SQL_DELETE, false, values);
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Failed to delete Account.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean existUsername(String username) throws DAOException{
        boolean usernameExists = false;

        try (
            PreparedStatement statement = prepareStatement(connection, SQL_EXIST_USERNAME, false, new Object[]{username});
        ) {
            int affectedRows = statement.executeUpdate();
            usernameExists = affectedRows > 0;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return usernameExists;
    }

    @Override
    public void changePassword(Account account) throws DAOException{
        if (account.getAccountId() == null) {
            throw new IllegalArgumentException("User is not created yet, the user ID is null.");
        }

        Object[] values = {
            account.getHashedPassword() ,
            account.getAccountId()
        };

        try (
            PreparedStatement statement = prepareStatement(connection, SQL_CHANGE_PASSWORD, false, values);
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Failed to change password for account.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    
     // Helpers 

    /**
     * Map the current row of the given ResultSet to an Account.
     * @param resultSet The ResultSet of which the current row is to be mapped to an Account.
     * @return The mapped Account from the current row of the given ResultSet.
     * @throws SQLException If something fails at database level.
     */
    private static Account map(ResultSet resultSet) throws SQLException {
        Account account = new Account();
        
        account.setAccountId(resultSet.getInt("account_id"));
        account.setUsername(resultSet.getString("username"));
        account.setFullName(resultSet.getString("full_name"));
        account.setEmail(resultSet.getString("email"));
        account.setPhoneNumber(resultSet.getString("phone_number"));
        account.setPriviledge(resultSet.getString("priviledge"));
        account.setHashedPassword(resultSet.getString("hashed_password"));
        account.setAccountStatus(resultSet.getString("account_status"));
        account.setRecoveryQuestion(resultSet.getString("recovery_question"));
        account.setRecoveryAnswer(resultSet.getString("recovery_answer"));
        
        return account;
    }

}
