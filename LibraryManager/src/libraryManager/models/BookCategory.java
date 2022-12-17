
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book_category")
@NamedQueries({
    @NamedQuery(name = "BookCategory.findAll", query = "SELECT b FROM BookCategory b"),
    @NamedQuery(name = "BookCategory.findByCategoryId", query = "SELECT b FROM BookCategory b WHERE b.categoryId = :categoryId"),
    @NamedQuery(name = "BookCategory.findByName", query = "SELECT b FROM BookCategory b WHERE b.name = :name")})
public class BookCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "category_id")
    private Integer categoryId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private Collection<Book> bookCollection;

    public BookCategory() {
    }

    public BookCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public BookCategory(Integer categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }
    
    public BookCategory(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Collection<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookCategory)) {
            return false;
        }
        BookCategory other = (BookCategory) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libraryManager.models.BookCategory[ categoryId=" + categoryId + " ]";
    }
    
}
