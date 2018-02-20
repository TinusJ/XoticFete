package za.co.crosstek.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import za.co.crosstek.anot.EntityAnotation; 
import za.co.crosstek.anot.FieldAnotation; 
import za.co.crosstek.enums.EntityAttribute;

/**
 *
 * @author Tinus
 */
@Entity
@EntityAnotation(attributes = {EntityAttribute.SHOW_ON_MENU, EntityAttribute.SINGLE_RECORD, EntityAttribute.REST}, label = "Company", icon = "fa fa-building")
public class Company extends CoreEntity {

    @NotNull
    @FieldAnotation(label = "Company Name")
    private String companyName;

    @NotNull
    @FieldAnotation(label = "Registered Name")
    private String registeredName;

    @FieldAnotation(label = "Registration Number")
    private String registrationNo;

    @Pattern(regexp = "^(http|https)://.*$", message = "Website URL must start with 'http://' or 'https://'")
    @FieldAnotation(label = "Website")
    private String website;

    @OneToOne(cascade = CascadeType.REFRESH)
    @FieldAnotation(label = "Preference")
    private Preference preference;

    @OneToOne(cascade = CascadeType.REFRESH)
    @FieldAnotation(label = "Wallet")
    private Wallet wallet;

    @OneToOne(cascade = CascadeType.REFRESH)
    @NotNull
    @FieldAnotation(label = "Location")
    private GeoLocation location;

    @FieldAnotation(label = "Logo")
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

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return companyName;
    }
}
