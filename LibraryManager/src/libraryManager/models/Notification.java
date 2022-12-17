
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "notification")
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n"),
    @NamedQuery(name = "Notification.findByNoticeId", query = "SELECT n FROM Notification n WHERE n.noticeId = :noticeId"),
    @NamedQuery(name = "Notification.findByNoticeTitle", query = "SELECT n FROM Notification n WHERE n.noticeTitle = :noticeTitle"),
    @NamedQuery(name = "Notification.findByNoticeTime", query = "SELECT n FROM Notification n WHERE n.noticeTime = :noticeTime")})
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "notice_id")
    private Integer noticeId;
    @Column(name = "notice_title")
    private String noticeTitle;
    @Lob
    @Column(name = "notice_text")
    private String noticeText;
    @Column(name = "notice_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date noticeTime;
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    @ManyToOne
    private Integer accountId;

    public Notification() {
    }

    public Notification(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeText() {
        return noticeText;
    }

    public void setNoticeText(String noticeText) {
        this.noticeText = noticeText;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noticeId != null ? noticeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.noticeId == null && other.noticeId != null) || (this.noticeId != null && !this.noticeId.equals(other.noticeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libraryManager.models.Notification[ noticeId=" + noticeId + " ]";
    }
    
}
