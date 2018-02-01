package za.co.crosstek.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
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

    @OneToOne(cascade = CascadeType.ALL)
    private GeoLocation location;

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

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
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
