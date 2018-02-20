package za.co.crosstek.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne; 
import javax.validation.constraints.NotNull;

@Entity 
public class SentNotification extends CoreEntity {

    @ManyToOne
    @NotNull
    private Wallet wallet;

    @NotNull
    @Column(nullable = false)
    private UUID sentUUID;

    @Column(length = Short.MAX_VALUE)
    private String comment;

    @NotNull
    private String title;

    @NotNull
    private String toAppID;

    private String message;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getToAppID() {
        return toAppID;
    }

    public void setToAppID(String toAppID) {
        this.toAppID = toAppID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SentNotification";
    }
}
