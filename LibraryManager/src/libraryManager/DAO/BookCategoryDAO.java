
package libraryManager.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static libraryManager.DAO.DAOUtil.DAOUtil.prepareStatement;
import libraryManager.DAO.exceptions.DAOException;
import libraryManager.models.BookCategory;

public class BookCategoryDAO implements libraryManager.DAO.DAOInterface.BookCategory{
    private static final String SQL_FIND_BY_ID =
        "SELECT * FROM book_category WHERE book_id = ?";
    private static final String SQL_FIND_BY_NAME =
        "SELECT * FROM book_category WHERE name = ?";
    private static final String SQL_LIST_ORDER_BY_ID =
        "SELECT * FROM book_category ORDER BY category_id";
    private static final String SQL_INSERT =
        "INSERT INTO book_category(name) VALUES (?)";
    private static final String SQL_UPDATE =
        "UPDATE book_category SET name = ? WHERE category_id = ?";
    private static final String SQL_DELETE =
        "DELETE FROM book_category WHERE category_id = ?";
    
    private final Connection connection;
    public BookCategoryDAO(){
        connection = DAOFactory.getConnection();
    }
    
    @Override
    public BookCategory find(Integer id) throws DAOException{
        return find(SQL_FIND_BY_ID, id);
    }
    
    @Override
    public BookCategory find(String name) throws DAOException{
        return find(SQL_FIND_BY_NAME, name);
    }
    

    /**
     * Returns the bookCategory from the database matching the given SQL query with the given values.
     * @param sql The SQL query to be executed in the database.
     * @param values The PreparedStatement values to be set.
     * @return The bookCategory from the database matching the given SQL query with the given values.
     * @throws DAOException If something fails at database level.
     */
    private BookCategory find(String sql, Object... values) throws DAOException {
        BookCategory bookCategory = null;

        try (
            PreparedStatement statement = prepareStatement(connection, sql, false, values);
            ResultSet resultSet = statement.executeQuery();
        ) {
            if (resultSet.next()) {
                bookCategory = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return bookCategory;
    }

    @Override
    public List<BookCategory> list() throws DAOException{
        List<BookCategory> books = new ArrayList<>();

        try (
            PreparedStatement statement = connection.prepareStatement(SQL_LIST_ORDER_BY_ID);
            ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                books.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return books;
    }
    
    //create 
    @Override
    public void create(BookCategory bookCategory) throws IllegalArgumentException, DAOException{
        if(bookCategory == null){
            throw new IllegalArgumentException("Invalid bookCategory cannot be created.");
        }
        Object[] values = {
            bookCategory.getName(),
        };

        try (
            PreparedStatement statement = prepareStatement(connection, SQL_INSERT, false, values);
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Failed to Create a new BookCategory Item.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    //update
    @Override
    public void update(BookCategory bookCategory) throws IllegalArgumentException, DAOException{
        if(bookCategory == null || bookCategory.getCategoryId()== null){
            throw new IllegalArgumentException("Invalid bookCategory cannot be updated.");
        }
        Object[] values = {
            bookCategory.getName(),
            bookCategory.getCategoryId(),
        };

        try (
            PreparedStatement statement = prepareStatement(connection, SQL_UPDATE, false, values);
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Failed to Update this bookCategory Item "+bookCategory);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    //delete
    @Override
    public void delete(BookCategory bookCategory) throws DAOException{
        if(bookCategory == null || bookCategory.getCategoryId()== null){
            throw new IllegalArgumentException("This bookCategory doesn't exist and cannot be deleted.");
        }

        Object[] values = {
            bookCategory.getCategoryId(),
        };

        try (
            PreparedStatement statement = prepareStatement(connection, SQL_DELETE, false, values);
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Failed to delete BookCategory Item.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

     // Helpers 

    /**
     * Map the current row of the given ResultSet to an BookCategory.
     * @param resultSet The ResultSet of which the current row is to be mapped to an BookCategory.
     * @return The mapped BookCategory from the current row of the given ResultSet.
     * @throws SQLException If something fails at database level.
     */
    private static BookCategory map(ResultSet resultSet) throws SQLException {
        BookCategory bookCategory = new BookCategory();
        
        bookCategory.setCategoryId(resultSet.getInt("category_id"));
        bookCategory.setName(resultSet.getString("name"));
        
        return bookCategory;
    }

}
