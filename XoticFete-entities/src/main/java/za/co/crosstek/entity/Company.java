package za.co.crosstek.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Tinus
 */
@Entity
public class Company extends CoreEntity {

    @NotNull
    private String companyName;

    @NotNull
    private String registeredName;

    private String registrationNo;

    @Pattern(regexp = "^(http|https|ftp)://.*$", message = "Website URL must start with 'http://' or 'https://'")
    private String website;

    @OneToOne(cascade = CascadeType.REFRESH)
    private Preference preference;

    @OneToOne(cascade = CascadeType.REFRESH)
    @NotNull
    private GeoLocation location;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment logo;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    public Attachment getLogo() {
        return logo;
    }

    public void setLogo(Attachment logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return companyName;
    }
}
