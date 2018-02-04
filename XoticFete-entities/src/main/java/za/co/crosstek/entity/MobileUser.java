package za.co.crosstek.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.AssertTrue;
import org.apache.commons.lang3.StringUtils;

@Entity
public class MobileUser extends CoreEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String cellNumber;

    private String appUUID;

    private Boolean unsubscribed;

    @OneToMany(cascade = CascadeType.REFRESH)
    private List<GeoLocation> lastKnowLocations;

    @OneToMany(mappedBy = "mobileUser", cascade = CascadeType.REFRESH)
    private List<FavoriteEvent> favEvents;

    @OneToMany(mappedBy = "mobileUser", cascade = CascadeType.REFRESH)
    private List<FavoriteSpecial> favSpecials;

    @OneToMany(mappedBy = "mobileUser", cascade = CascadeType.REFRESH)
    private List<FavoriteCompany> favCompanies;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getAppUUID() {
        return appUUID;
    }

    public void setAppUUID(String appUUID) {
        this.appUUID = appUUID;
    }

    public Boolean getUnsubscribed() {
        return unsubscribed;
    }

    public void setUnsubscribed(Boolean unsubscribed) {
        this.unsubscribed = unsubscribed;
    }

    public List<GeoLocation> getLastKnowLocations() {
        return lastKnowLocations;
    }

    public void setLastKnowLocations(List<GeoLocation> lastKnowLocations) {
        this.lastKnowLocations = lastKnowLocations;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<FavoriteEvent> getFavEvents() {
        return favEvents;
    }

    public void setFavEvents(List<FavoriteEvent> favEvents) {
        this.favEvents = favEvents;
    }

    public List<FavoriteSpecial> getFavSpecials() {
        return favSpecials;
    }

    public void setFavSpecials(List<FavoriteSpecial> favSpecials) {
        this.favSpecials = favSpecials;
    }

    public List<FavoriteCompany> getFavCompanies() {
        return favCompanies;
    }

    public void setFavCompanies(List<FavoriteCompany> favCompanies) {
        this.favCompanies = favCompanies;
    }

    //</editor-fold>
    @Override
    public String toString() {
        return StringUtils.isNotBlank(email)
                ? email
                : StringUtils.isNotBlank(appUUID)
                ? appUUID
                : StringUtils.isNotBlank(cellNumber)
                ? cellNumber : "";
    }

    @AssertTrue(message = "Cell | Email | AppID -> One or more are required!")
    private boolean isValid() {
        return (StringUtils.isNotBlank(email) || StringUtils.isNotBlank(appUUID) || StringUtils.isNotBlank(cellNumber));
    }
}
