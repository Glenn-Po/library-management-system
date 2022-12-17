
package libraryManager.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static libraryManager.DAO.DAOUtil.DAOUtil.prepareStatement;
import libraryManager.DAO.exceptions.DAOException;
import libraryManager.models.Book;


public class BookDAO implements libraryManager.DAO.DAOInterface.Book{
    private static final String SQL_FIND_BY_ID =
        "SELECT * FROM book WHERE book_id = ?";
    private static final String SQL_FIND_BY_ISBN =
        "SELECT * FROM book WHERE isbn = ?";
    private static final String SQL_FIND_BY_TITLE =
        "SELECT * FROM book WHERE title = ?";
    private static final String SQL_LIST_ORDER_BY_ID =
        "SELECT * FROM book ORDER BY book_id";
    private static final String SQL_LIST_BY_AUTHOR =
        "SELECT * FROM book WHERE author LIKE '%?%' ";
    private static final String SQL_INSERT =
        "INSERT INTO book(isbn, title, cover_image, author, publisher, short_description, "+
            "quantity, rack_number, category_id )" +
           "  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE =
        "UPDATE book SET isbn = ?, title = ?, cover_image = ?,"
            + " author = ?, publiser = ?, short_description =?,"
            + " quantity = ?, rack_number = ?, category_id = ?"+
        "WHERE book_id = ?";
    
    private static final String SQL_DELETE =
        "DELETE FROM book WHERE book_id = ?";
    
    private final Connection connection;
    public BookDAO(){
        connection = DAOFactory.getConnection();
    }
    
    @Override
    public Book find(Integer id) throws DAOException{
        return find(SQL_FIND_BY_ID, id);
    }
    
    @Override
    public Book find(String isbn) throws DAOException{
        return find(SQL_FIND_BY_ISBN, isbn);
    }
    
    @Override
    public List<Book> findByAuthor(String author) throws DAOException{
        List<Book> books = new ArrayList<>();

        try (
            PreparedStatement statement = prepareStatement(connection, SQL_LIST_BY_AUTHOR, false, new Object[]{author});
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
    
    @Override
    public Book findByTitle(String title) throws DAOException{
        return find(SQL_FIND_BY_TITLE, title);
    }

    /**
     * Returns the book from the database matching the given SQL query with the given values.
     * @param sql The SQL query to be executed in the database.
     * @param values The PreparedStatement values to be set.
     * @return The book from the database matching the given SQL query with the given values.
     * @throws DAOException If something fails at database level.
     */
    private Book find(String sql, Object... values) throws DAOException {
        Book book = null;

        try (
            PreparedStatement statement = prepareStatement(connection, sql, false, values);
            ResultSet resultSet = statement.executeQuery();
        ) {
            if (resultSet.next()) {
                book = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return book;
    }

    @Override
    public List<Book> list() throws DAOException{
        List<Book> books = new ArrayList<>();

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
    public void create(Book book) throws IllegalArgumentException, DAOException{
        if(book == null){
            throw new IllegalArgumentException("Invalid book cannot be created.");
        }
        Object[] values = {
            book.getIsbn(),
            book.getTitle(),
            book.getCoverImage(),
            book.getAuthor(),
            book.getPublisher(),
            book.getShortDescription(),
            book.getQuantity(),
            book.getRackNumber(),
            book.getCategoryId(),
        };

        try (
            PreparedStatement statement = prepareStatement(connection, SQL_INSERT, false, values);
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Failed to Create a new Book Item.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    //update
    @Override
    public void update(Book book) throws IllegalArgumentException, DAOException{
        if(book == null || book.getBookId() == null){
            throw new IllegalArgumentException("Invalid book cannot be updated.");
        }
        Object[] values = {
            book.getIsbn(),
            book.getTitle(),
            book.getCoverImage(),
            book.getAuthor(),
            book.getPublisher(),
            book.getShortDescription(),
            book.getQuantity(),
            book.getRackNumber(),
            book.getCategoryId(),
            book.getBookId(),
        };

        try (
            PreparedStatement statement = prepareStatement(connection, SQL_UPDATE, false, values);
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Failed to Update this book Item "+book);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    //delete
    @Override
    public void delete(Book book) throws DAOException{
        if(book == null || book.getBookId() == null){
            throw new IllegalArgumentException("This book doesn't exist and cannot be deleted.");
        }

        Object[] values = {
            book.getBookId()
        };

        try (
            PreparedStatement statement = prepareStatement(connection, SQL_DELETE, false, values);
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Failed to delete Book Item.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

     // Helpers 

    /**
     * Map the current row of the given ResultSet to an Book.
     * @param resultSet The ResultSet of which the current row is to be mapped to an Book.
     * @return The mapped Book from the current row of the given ResultSet.
     * @throws SQLException If something fails at database level.
     */
    private static Book map(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        
        book.setBookId(resultSet.getInt("book_id"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setTitle(resultSet.getString("title"));
        book.setCoverImage(resultSet.getBytes("cover_image"));
        book.setAuthor(resultSet.getString("author"));
        book.setPublisher(resultSet.getString("publisher"));
        book.setShortDescription(resultSet.getString("short_description"));
        book.setQuantity(resultSet.getInt("quantity"));
        book.setRackNumber(resultSet.getInt("rack_number"));
        book.setCategoryId(resultSet.getInt("category_id"));
        
        return book;
    }
    
}
