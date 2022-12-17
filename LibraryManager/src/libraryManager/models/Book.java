
package libraryManager.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBookId", query = "SELECT b FROM Book b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "Book.findByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author"),
    @NamedQuery(name = "Book.findByPublisher", query = "SELECT b FROM Book b WHERE b.publisher = :publisher"),
    @NamedQuery(name = "Book.findByQuantity", query = "SELECT b FROM Book b WHERE b.quantity = :quantity"),
    @NamedQuery(name = "Book.findByRackNumber", query = "SELECT b FROM Book b WHERE b.rackNumber = :rackNumber")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "cover_image")
    private byte[] coverImage;
    @Basic(optional = false)
    @Column(name = "author")
    private String author;
    @Column(name = "publisher")
    private String publisher;
    @Lob
    @Column(name = "short_description")
    private String shortDescription;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "rack_number")
    private Integer rackNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private Collection<BookIssue> bookIssueCollection;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false)
    private Integer categoryId;

    public Book() {
    }

    public Book(Integer bookId) {
        this.bookId = bookId;
    }

    public Book(Integer bookId, String author) {
        this.bookId = bookId;
        this.author = author;
    }
    public Book(Integer bookId, String isbn, String title, byte[] coverImage,
            String author, String publisher, String shortDescription, Integer quantity,
            Integer rackNumber, Integer catergoryID) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.coverImage = coverImage;
        this.author = author;
        this.publisher = publisher;
        this.shortDescription = shortDescription;
        this.quantity = quantity;
        this.rackNumber = rackNumber;
        this.categoryId = catergoryID;
    }
    
    public Book(String isbn, String title, byte[] coverImage,
            String author, String publisher, String shortDescription, Integer quantity,
            Integer rackNumber, Integer catergoryID) {
        this.isbn = isbn;
        this.title = title;
        this.coverImage = coverImage;
        this.author = author;
        this.publisher = publisher;
        this.shortDescription = shortDescription;
        this.quantity = quantity;
        this.rackNumber = rackNumber;
        this.categoryId = catergoryID;
    }
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(byte[] coverImage) {
        this.coverImage = coverImage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(Integer rackNumber) {
        this.rackNumber = rackNumber;
    }

    public Collection<BookIssue> getBookIssueCollection() {
        return bookIssueCollection;
    }

    public void setBookIssueCollection(Collection<BookIssue> bookIssueCollection) {
        this.bookIssueCollection = bookIssueCollection;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libraryManager.models.Book[ bookId=" + bookId + " ]";
    }
    
}
