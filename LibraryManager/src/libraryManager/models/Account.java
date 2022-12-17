
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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAccountId", query = "SELECT a FROM Account a WHERE a.accountId = :accountId"),
    @NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username = :username"),
    @NamedQuery(name = "Account.findByFullName", query = "SELECT a FROM Account a WHERE a.fullName = :fullName"),
    @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email"),
    @NamedQuery(name = "Account.findByPhoneNumber", query = "SELECT a FROM Account a WHERE a.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Account.findByPriviledge", query = "SELECT a FROM Account a WHERE a.priviledge = :priviledge"),
    @NamedQuery(name = "Account.findByHashedPassword", query = "SELECT a FROM Account a WHERE a.hashedPassword = :hashedPassword"),
    @NamedQuery(name = "Account.findByAccountStatus", query = "SELECT a FROM Account a WHERE a.accountStatus = :accountStatus"),
    @NamedQuery(name = "Account.findByRecoveryAnswer", query = "SELECT a FROM Account a WHERE a.recoveryAnswer = :recoveryAnswer")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "account_id")
    private Integer accountId;
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "full_name")
    private String fullName;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "priviledge")
    private String priviledge;
    @Basic(optional = false)
    @Column(name = "hashed_password")
    private String hashedPassword;
    @Column(name = "account_status")
    private String accountStatus;
    @Lob
    @Column(name = "recovery_question")
    private String recoveryQuestion;
    @Column(name = "recovery_answer")
    private String recoveryAnswer;
    @OneToMany(mappedBy = "accountId")
    private Collection<Notification> notificationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<BookIssue> bookIssueCollection;
    @OneToMany(mappedBy = "accountId")
    private Collection<Log> logCollection;

    public Account() {
    }

    public Account(Integer accountId) {
        this.accountId = accountId;
    }

    public Account(Integer accountId, String fullName, String email, String priviledge, String hashedPassword) {
        this.accountId = accountId;
        this.fullName = fullName;
        this.email = email;
        this.priviledge = priviledge;
        this.hashedPassword = hashedPassword;
    }
    
    //constructor with all attributes
    public Account(Integer accountId, String username, String fullName, String email,
            String phoneNumber, String priviledge, String hashedPassword,String accountStatus,
            String recoveryQuestion, String recoveryAnswer) {
        this.accountId = accountId;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.priviledge = priviledge;
        this.hashedPassword = hashedPassword;
        this.accountStatus = accountStatus;
        this.recoveryQuestion = recoveryQuestion;
        this.recoveryAnswer = recoveryAnswer;
    }
    //constructor with all attributes but ID
    public Account(String username, String fullName, String email,
            String phoneNumber, String priviledge, String hashedPassword,String accountStatus,
            String recoveryQuestion, String recoveryAnswer) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.priviledge = priviledge;
        this.hashedPassword = hashedPassword;
        this.accountStatus = accountStatus;
        this.recoveryQuestion = recoveryQuestion;
        this.recoveryAnswer = recoveryAnswer;
    }
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPriviledge() {
        return priviledge;
    }

    public void setPriviledge(String priviledge) {
        this.priviledge = priviledge;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getRecoveryQuestion() {
        return recoveryQuestion;
    }

    public void setRecoveryQuestion(String recoveryQuestion) {
        this.recoveryQuestion = recoveryQuestion;
    }

    public String getRecoveryAnswer() {
        return recoveryAnswer;
    }

    public void setRecoveryAnswer(String recoveryAnswer) {
        this.recoveryAnswer = recoveryAnswer;
    }

    public Collection<Notification> getNotificationCollection() {
        return notificationCollection;
    }

    public void setNotificationCollection(Collection<Notification> notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    public Collection<BookIssue> getBookIssueCollection() {
        return bookIssueCollection;
    }

    public void setBookIssueCollection(Collection<BookIssue> bookIssueCollection) {
        this.bookIssueCollection = bookIssueCollection;
    }

    public Collection<Log> getLogCollection() {
        return logCollection;
    }

    public void setLogCollection(Collection<Log> logCollection) {
        this.logCollection = logCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libraryManager.models.Account[ accountId=" + accountId + " ]";
    }
    
}
