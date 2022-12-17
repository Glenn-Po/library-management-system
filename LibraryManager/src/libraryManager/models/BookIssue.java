
package libraryManager.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "book_issue")
@NamedQueries({
    @NamedQuery(name = "BookIssue.findAll", query = "SELECT b FROM BookIssue b"),
    @NamedQuery(name = "BookIssue.findByIssueId", query = "SELECT b FROM BookIssue b WHERE b.issueId = :issueId"),
    @NamedQuery(name = "BookIssue.findByIssueStatus", query = "SELECT b FROM BookIssue b WHERE b.issueStatus = :issueStatus"),
    @NamedQuery(name = "BookIssue.findByIssueDate", query = "SELECT b FROM BookIssue b WHERE b.issueDate = :issueDate"),
    @NamedQuery(name = "BookIssue.findByDueDate", query = "SELECT b FROM BookIssue b WHERE b.dueDate = :dueDate")})
public class BookIssue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "issue_id")
    private Integer issueId;
    @Column(name = "issue_status")
    private String issueStatus;
    @Column(name = "issue_date")
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @Column(name = "due_date")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    @ManyToOne(optional = false)
    private Account accountId;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    @ManyToOne(optional = false)
    private Integer bookId;

    public BookIssue() {
    }

    public BookIssue(Integer issueId) {
        this.issueId = issueId;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (issueId != null ? issueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookIssue)) {
            return false;
        }
        BookIssue other = (BookIssue) object;
        if ((this.issueId == null && other.issueId != null) || (this.issueId != null && !this.issueId.equals(other.issueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libraryManager.models.BookIssue[ issueId=" + issueId + " ]";
    }
    
}
