package za.co.crosstek.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tinus
 */
@Entity
public class FavoriteCompany extends CoreEntity {

    @ManyToOne
    @NotNull
    private Company company;

    @ManyToOne
    @NotNull
    private MobileUser mobileUser;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public MobileUser getMobileUser() {
        return mobileUser;
    }

    public void setMobileUser(MobileUser mobileUser) {
        this.mobileUser = mobileUser;
    }

    @Override
    public String toString() {
        return mobileUser.toString() + " " + company.toString();
    }

}
