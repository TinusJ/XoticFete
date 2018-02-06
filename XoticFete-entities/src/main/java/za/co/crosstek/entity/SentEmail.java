package za.co.crosstek.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
    @NamedQuery(
            name = "SentEmail.findToSend",
            query = "SELECT en FROM SentEmail en "
            + "WHERE (en.sent IS NULL OR en.sent = false) "
            + "AND (en.retrycount IS NULL OR en.retrycount < 2)")
})
public class SentEmail extends CoreEntity {

    @ManyToOne
    @NotNull
    private Wallet wallet;

    @NotNull
    @Column(length = Short.MAX_VALUE)
    private String recipients;

    @Column(length = Short.MAX_VALUE)
    private String cc;

    private String sender;

    private Integer retrycount;

    @NotNull
    @Column(nullable = false)
    private String subject;

    @OneToMany
    private List<Attachment> attachments;

    @Column(length = Short.MAX_VALUE)
    private String comment;

    private Boolean sent;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;

    @NotNull
    @Lob
    private String message;

    private Boolean doNotFormat;

    private String messageID;

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

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Integer getRetrycount() {
        return retrycount;
    }

    public void setRetrycount(Integer retrycount) {
        this.retrycount = retrycount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getDoNotFormat() {
        return doNotFormat;
    }

    public void setDoNotFormat(Boolean doNotFormat) {
        this.doNotFormat = doNotFormat;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    @Override
    public String toString() {
        return subject;
    }
}
