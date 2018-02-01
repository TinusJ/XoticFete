package za.co.crosstek.entity;

import javax.persistence.Entity;
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

    @Override
    public String toString() {
        return companyName;
    }
}
