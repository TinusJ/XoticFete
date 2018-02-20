package za.co.crosstek.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal; 
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
 
@Entity
public class SentSMS extends CoreEntity {

    @ManyToOne
    @NotNull
    private Wallet wallet;

    @NotNull
    private String recipients;

    @NotNull
    @Column(length = 160)
    private String message;

    @Column(length = Short.MAX_VALUE)
    private String comment;

    private Boolean sent;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;

    private Boolean delivered;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveredDate;

    @NotNull
    @Column(nullable = false)
    private UUID sentUUID;

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public UUID getSentUUID() {
        return sentUUID;
    }

    public void setSentUUID(UUID sentUUID) {
        this.sentUUID = sentUUID;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getSent() {
        return sent;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    @Override
    public String toString() {
        return "SentSMS";
    }
}
